var mongoose =require('mongoose');


// var documentSchema = new mongoose.Schema({
//     name: { type: String, required: true, minlength: 1, trim: true },
//     uploadDate: { type: Date, default: Date.now }
//   });

var categorieSchema = new mongoose.Schema({
    nom:{type:String, required: true,minlength:1,trim:true},
    type:{type:String,required: true,minlength:1,trim:true}
});
module.exports = mongoose.model('Categorie',categorieSchema)