var mongoose = require('mongoose')
mongoose.connect('mongodb://localhost/twin',()=>{
    console.log('db connect')
});
