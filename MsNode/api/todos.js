var express = require("express");
var router = express.Router();
var Todo = require("../models/todo");

router.post("/", (req, res) => {
  var todo = new Todo(req.body);
  todo.save((err, todo) => {
    if (err) res.send(err);
    else res.send(todo);
  });
});
router.get("/", (req, res) => {
  Todo.find((err, todos) => {
    if (err) res.send(err);
    if (!todos) res.status(404).send();
    else res.json(todos);
  });
});
router.get("/:id", (req, res) => {
  var id = req.params.id;
  Todo.findById(id).exec((err, todo) => {
    if (err) res.status(400).send(err);
    if (!todo) res.status(404).send();
    else res.json(todo._id);
  });
});
router.delete("/:id", (req, res) => {
  var id = req.params.id;
  Todo.findByIdAndRemove(id, (err, todo) => {
    if (err) res.send;
    else res.send("Todo Supprimée");
  });
});
router.put("/:id", (req, res) => {
  Todo.findById(req.params.id).exec((err, todo) => {
    if (!err) {
      if (todo.completed === "true") {
        Todo.updateOne(todo, req.body, (err, todoo) => {
          if (!err) res.send(todoo);
          else res.send(err);
        });
      }
    } else res.send(err);
  });
});

router.get("/todos/:id/medias", function(req, res) {
  console.log(req.params.id);
  Todo.findById(req.params.id).exec(function(err, todo) {
    if (err) {
      res.status(400).send(err);
    } else {
      res.send(todo);
    }
  });
});

router.post("/todos/:id/medias", function(req, res) {
  Todo.findById(req.params.id).exec(function(err, todo) {
    if (!err) {
      if (Array.isArray(req.body)) {
        todo.documents.push.apply(todo.documents, req.body);
        todo.save(function(err, todo) {
          if (err) {
            res.status(400).send(err);
          } else {
            res.send(todo);
          }
        });
      } else {
        todo.documents.push(req.body);
        todo.save(function(err, todo) {
          if (err) {
            res.status(400).send(err);
          } else {
            res.send(todo);
          }
        });
      }
    } else {
      res.status(400).send(err);
    }
  });
});

router.get("/todos/:id/media/:idm", function(req, res) {
  Todo.findById(req.params.id).exec(function(err, todo) {
    if (err) {
      res.status(400).send(err);
    } else {
      var media;
      for (var i = 0; i < todo.documents.length; i++) {
        if (todo.documents[i]._id == req.params.idm) {
          media = todo;
        }
      }
      res.send(media);
    }
  });
});

router.put("/todos/:id/media/:idm", function(req, res) {
  Todo.findById(req.params.id).exec(function(err, todo) {
    todo.documents.forEach(media => {
      if (media._id == req.params.idm) {
        todo.documents.splice(todo.documents.indexOf(media), 1);
        if (req.body.uploadDate == null) {
          req.body.uploadDate = media.uploadDate;     
        }
        req.body._id = media._id;
        todo.documents.push(req.body);
      }
    });
    todo.save(function(err, todo) {
      if (err) {
        res.status(400).send(err);
      } else {
        res.send(todo);
      }
    });
  });
});

router.delete('/todos/:id/media/:idm',function(req,res){
  Todo.findById(req.params.id).exec(function(err,todo){
    todo.documents.forEach(function(media){
      if(media._id == req.params.idm){
        todo.documents.splice(todo.documents.indexOf(media),1)
      }
    })
    todo.save(function(err,todo){
      if(err){
        res.status(400).send(err)
      }else{
        res.send(todo)
      }
    })
  })
})
module.exports = router;
