var mongoose = require("mongoose");
var documentSchema = new mongoose.Schema({
  name: { type: String, required: true, minlength: 1, trim: true },
  uploadDate: { type: Date, default: Date.now }
});
module.exports = documentSchema