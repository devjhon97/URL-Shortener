const sql = require("sequelize");
const db = new sql({
    dialect: 'sqlite',
    storage: './db.sql'
})

module.exports = db;