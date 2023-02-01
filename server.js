const express = require("express");
const site = express();
const bp = require('body-parser');
const db = require('./database');
const database = require('./storage/db');
const encode = require('./encode');
const path = require("path");
const link = require("url");

site.use(bp.urlencoded({extended: false}));

site.use('/public', express.static(path.join(__dirname, "public")));

(async function(){
    await database.sync()    
})();

site.get('/:info', async (req,res)=>{
    const shorturl = req.params.info;

    const dbres = await database.findOne({where: {shorturl}});

    if(!dbres) return res.sendStatus(404);

    res.redirect(dbres.url);
})

site.set('view engine','ejs');

site.set('/views', path.join(__dirname, "views"));

site.get('/', (req,res) => {
    res.render('index',{});
})

site.post('/', async (req,res) =>{
    var userurl = req.body.iptsite;
    var url = userurl;

    if(!/^https?:\/\//i.test(url)){
        url = 'http://'+url;
    }

    var shorturl = await encode(8);

    const dbres = await database.create({
        url,
        shorturl
    })

    res.render('result',{shorturl});
})

site.listen(5000);