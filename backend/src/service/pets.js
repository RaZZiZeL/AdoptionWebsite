

const pets = require('../models').pets;

module.exports.list = function(req, res){
  pets.findAll().then(pets => {
        res.jsonp(pets);
      }).catch((error) => res.status(400).send(error));
};

 

// exports.listP = function (req, res) {
//   pets.findAll().then(pets => {
//     res.jsonp(pets);
//   }).catch((error) => res.status(400).send(error));
// };

  // exports.createP = function (req, res) {
  //   res.jsonp(pets.create(req.body));
  // };



  // exports.findByIdP = function (req, res) {
  //   let id = req.params.id;
  //   pets.findById(id).then(pets => {
  //     if (!pets) {
  //       return res.status(400).send({
  //         message: 'pets Not Found',
  //       });
  //     }
  //     res.jsonp(pets);
  //   });
  // };
  
  // exports.deleteP = function (req, res) {
  //   let id = req.params.id;
  //   pets.findById(req.params.id)
  //     .then(pets => {
  //       if (!pets) {Y
  //         return res.status(400).send({
  //           message: 'pets Not Found',
  //         });
  //       }
  //       return pets
  //         .destroy()
  //         .then(() => res.status(204).send())
  //         .catch(error => res.status(400).send(error));
  //     })
  //     .catch(error => res.status(400).send(error));
  // };
  
