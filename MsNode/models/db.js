var mongoose = require('mongoose')
mongoose.connect('mongodb://mongo:27017/gestionStock',()=>{
    console.log('db connect')
});

