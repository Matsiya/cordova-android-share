
var exec = require("cordova/exec");

var SocialShare = function () {
    this.name = "SocialShare";
};


SocialShare.prototype.share = function (subject, text) {
    exec(null, null, "SocialShare", "share", [{subject: subject, text: text}]);
};

module.exports = new SocialShare();
