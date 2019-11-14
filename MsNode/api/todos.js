var express = require("express");
var router = express.Router();
var Categorie = require("../models/categorie");

router.post("/", (req, res) => {
  var categorie = new Categorie(req.body);
  categorie.save((err, categorie) => {
    if (err) res.send(err);
    else res.send(categorie);
  });
});
router.get("/", (req, res) => {
  Categorie.find((err, categories) => {
    if (err) res.send(err);
    if (!categories) res.status(404).send();
    else res.json(categories);
  });
});
router.get("/:id", (req, res) => {
  var id = req.params.id;
  Categorie.findById(id).exec((err, categorie) => {
    if (err) res.status(400).send(err);
    if (!categorie) res.status(404).send();
    else res.json(categorie._id);
  });
});
router.delete("/:id", (req, res) => {
  var id = req.params.id;
  Categorie.findByIdAndRemove(id, (err, categorie) => {
    if (err) res.send;
    else res.send("Todo Supprimée");
  });
});
router.put("/:id", (req, res) => {
  Categorie.findById(req.params.id).exec((err, categorie) => {
    if (!err) {
     
        Categorie.updateOne(categorie, req.body, (err, categoriee) => {
          if (!err) res.send(categoriee);
          else res.send(err);
        });
    
    } else res.send(err);
  });
});


module.exports = router;
