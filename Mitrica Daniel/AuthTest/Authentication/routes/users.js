const express = require('express');
const router = express.Router();
const bcrypt = require('bcryptjs');
var pg = require('pg');
const config = require('../config/database');
var client = new pg.Client(config.database);
let User = require('../models/user');


//register
router.get('/register',function(req,res){
  res.render('register');
});

router.post('/register',function(req,res){
  const username = req.body.username;
  const email = req.body.email;
  const password = req.body.password;
  const password2 = req.body.password2;

  req.checkBody('username', 'Username is required').notEmpty();
  req.checkBody('email', 'Email is required').notEmpty();
  req.checkBody('email', 'Email is not valid').isEmail();
  req.checkBody('password', 'Password is required').notEmpty();
  req.checkBody('password2', 'Passwords do not match').equals(req.body.password);

  let errors = req.validationErrors();

  if(errors){
    console.log("erroare");
    res.render('register',{
      errors:errors
    });
  }else{
    let newUser = new User({
      username:req.body.username,
      email:req.body.email,
      password:req.body.password
    });

    bcrypt.genSalt(3, function(err,salt){
      bcrypt.hash(newUser.password, salt, function(error,hash){
        if(error){
          console.log(error);
        }
        newUser.password = hash;
        //Insert into Database
        client.connect();
        client.query('INSERT into Users(username,email,password) VALUES($1,$2,$3)',[newUser.username,newUser.email,newUser.password],function(err,result){
        if(err){
          console.log('Register insert error: '+err);
//          console.log(newUser.password);
        }
        else{
          console.log('New user added to database');
          req.flash('success','You are now registered and can log in');
          res.redirect('/users/login');
        }
        client.end();
        });
      });
    });
  }
});

router.get('/login',function(req,res){
  res.render('login');
});
//Login Submit

router.post('/login', function(req, res){
  const username = req.body.username;
  const password = req.body.password;

  req.checkBody('username', 'Username is required').notEmpty();
  req.checkBody('password', 'Password is required').notEmpty();

  let errors = req.validationErrors();

  if(errors){
    console.log("erroare");
    res.render('login',{
      errors:errors
    });
  }else{
    let logUser = new User({
      username:req.body.username,
      password:req.body.password
    });
  client.connect();
  client.query('SELECT * FROM users WHERE username = $1',[logUser.username], function(err, result) {
    console.log('Debug: '+logUser.username+' '+logUser.password);
    if(err) {
      client.end();
      return console.error('error running query', err);
    }
    else if (result.rows.length!=0){
      console.log("Found");
    }
    else{
      client.end();
      return done(null,false,{message:'Username or password incorrect'});
    }
  });

  //Match password
  client.query('SELECT id AS id, password AS password FROM users WHERE username = $1',[logUser.username], function(err, result) {
    if(err) {
      client.end();
      return console.error('error running query', err);
    }
    if(result.rows.length!=0){
      bcrypt.compare(password,result.rows[0].password,function(err,isMatch){
        if(err) throw err;
        if(isMatch){
          console.log('Match');
          let user = new User();
          user.id=result.rows[0].id;
          user.username=logUser.username;
          user.password=logUser.password;
          client.end();
          return done(null,user);
        } else {
          client.end();
          return done(null,false,{message:'Username or password incorrect'});
        }
      });
    }else{
      client.end();
      return done(null,false,{message:'Username or password incorrect'});
    }
    client.end();
  });
  }
});
module.exports = router;
