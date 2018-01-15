'use strict';

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.bulkInsert('users', [{
      firstName: 'John',
      lastName: 'Doe',
      email: 'demo@demo.com'
    },{
      firstName: 'John2',
      lastName: 'Doe2',
      email: 'demo@demo.com2'
    },], {});
  },

  down: (queryInterface, Sequelize) => {
    return queryInterface.bulkDelete('users', null, {});
  }
};
