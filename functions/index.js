const functions = require("firebase-functions");
const admin = require('firebase-admin');
admin.initializeApp();


exports.scheduledFunction = functions.pubsub.schedule('every 5 minutes').onRun((context) => {
    var date = new Date();
    admin.database().ref('CurrentDate').set(date.getTime());

});
