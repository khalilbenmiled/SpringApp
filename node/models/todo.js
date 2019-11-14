var mongoose =require('mongoose');

var documentSchema = require('../models/document')
// var documentSchema = new mongoose.Schema({
//     name: { type: String, required: true, minlength: 1, trim: true },
//     uploadDate: { type: Date, default: Date.now }
//   });

var todoSchema = new mongoose.Schema({
    text:{type:String, required: true,minlength:1,trim:true},
    completed:{type:Boolean,default:false},
    completedAt:{type:Number,default:null},
    documents : [documentSchema]
});
module.exports = mongoose.model('Todo',todoSchema)