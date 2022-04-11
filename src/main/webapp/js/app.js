var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
  
}

function connect() {
    var socket = new SockJS('/bidwebsocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/bid/newBid', function (newBid1) {
	console.log("inside greeting");
            newBid(JSON.parse(newBid1.body));
        });
    });
}

function connect(id) {
    var socket = new SockJS('/bidwebsocket');
    console.log('Inventory wih id'+id+' is connected');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/bid/newBid', function (newBid1) {
	console.log("inside greeting");
            newBid(JSON.parse(newBid1.body));
        });
    });
}

function disconnect() {
	
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function disconnect(id) {
	console.log('Inventory wih id'+id+' is disconnected');
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function sendBid() {
    
    stompClient.send("/app/addBid", {}, JSON.stringify({'oldBidValue': Number($("#greetings").val())}));

    
}

function sendBid(id) {
    
    stompClient.send("/app/addBid", {}, JSON.stringify({'oldBidValue': Number($("#greetings").val())}));

    
}

/*function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message.message + "</td></tr>");
}*/

function newBid(bidValue) {
  /*  $("#greetings").text(bidValue.newBidValue );*/
  document.getElementById("greetings").value = bidValue.newBidValue;
}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
   
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendBid(); });
});