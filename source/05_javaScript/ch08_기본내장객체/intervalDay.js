// JavaScript source code(intervalDay.js)
Date.prototype.intervalDay = function (that) {
    if (this > that) {
        var intervalMili = this.getTime() - that.getTime();
    } else {
        var intervalMili = that.getTime() - this.getTime();
    }
    var day = intervalMili / (1000 * 60 * 60 * 24);
    return Math.trunc(day);
};