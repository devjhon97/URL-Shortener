const sql = require('sequelize');
const db = require('../database');

const database = db.define('database',{
    url: {
        type: sql.STRING,
        allowNull: false
    },
    shorturl: {
        type: sql.STRING,
        allowNull: false
    },
    id: {
        type: sql.INTEGER.UNSIGNED,
        autoIncrement: true,
        primaryKey: true
    }
})

module.exports = database;