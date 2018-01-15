'use strict';
module.exports = (sequelize, DataTypes) => {
  var pets = sequelize.define('pets', {
    Name: DataTypes.STRING,
    Type: DataTypes.STRING,
    ImageName: DataTypes.STRING
  }, {
    classMethods: {
      associate: function(models) {
       
        // associations can be defined here
      }
      
    }
  });
  return pets;
};