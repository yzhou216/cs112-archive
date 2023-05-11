const LENGTH = 10000;
function setValues(values) {
        const L = values.length;
        for(var i = 0; i <= L-1; i++) {
                values[i] = Math.floor(Math.random() * (4 * L - 1));
        }
}
function doSort(values) {
        for(var i = values.length-1; i >= 1; --i) {
                for(var j = 1; j <= i; j++) {
                        if(values[j-1] > values[j]) {
                                const TMP = values[j-1];
                                values[j-1] = values[j];
                                values[j] = TMP;
                        }
                }
        }
}
function arrayToString(values) {
        var str = "";
        for(var i = 0; i <= values.length-1; i++) {
                str += values[i] + " ";
        }
        return str;
}
var values = [];
values.length = LENGTH;
setValues(values);
const start = new Date();
let totalStartMilliseconds = start.getSeconds() * 1000 + start.getMilliseconds();
doSort(values);
const stop = new Date();
let totalStopMilliseconds = stop.getSeconds() * 1000 + stop.getMilliseconds();
console.log((totalStopMilliseconds - totalStartMilliseconds)/1000.0);
const fs = require("fs");
fs.writeFile("./sort.txt", arrayToString(values), (err) => {
        if(err) {
                console.error(err);
                return;
        }
});
