var express = require('express');
var router = express.Router();
var Categorie = require("../models/categorie");

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

router.post("/", (req, res) => {
  var categorie = new Categorie(req.body);
  categorie.save((err, categorie) => {
    if (err) res.send(err);
    else res.send(categorie);
  });
});

module.exports = router;
