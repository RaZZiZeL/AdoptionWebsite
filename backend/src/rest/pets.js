var express = require('express');
var router = express.Router();
var pets = require('../service/').pets;
var localMessage = 'Bogdan';





router.get('/', pets.list);
//router.get('/pets',pets.listP);
// router.get('/:id', user.findById);
// router.post('/', user.create);
// // router.put('/:id',user.update);
// router.delete('/:id', user.delete);
module.exports = router;