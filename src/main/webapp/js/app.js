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
			//console.log("--------------------------");
			//console.log("newBid value "+newBid1.body);
			//console.log("--------------------------");
            newBid(JSON.parse(newBid1.body),id);
        });
        
        stompClient.subscribe('/bid/placebid', function () {
            showBid();
        });
        
    });
}


function showBid(){
	console.log("----------------Bidding Done--------------");
	
	if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
    
    //reload page
    location.reload();
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


function sendBid(bidderId,bidderName,id) {
	console.log("bidderId : "+bidderId);
	
	//$("#send"+id).prop('disabled', true);
	
	if( Number($("#bidInput"+id).val()) >  Number($("#highBid"+id).val()))
	{
    	stompClient.send("/app/addBid", {}, JSON.stringify({'bidderId' : Number(bidderId), 'bidderName': bidderName ,'oldBidValue': Number($("#bidInput"+id).val())}));
    }
    else{
		
		//console.log("Your Bid is Low");
		alert("Your Bid is Low");
	}
}

function acceptBid(id) {
    
    stompClient.send("/app/bidCompleted", {}, JSON.stringify({'inventoryId' : Number(id) , 'soldPrice': Number($("#greetings"+id).val()) , 'bidderId':Number($("#highBidId"+id).val()) , 'bidderName':Number($("#highBidName"+id).val())}));
    
}




/*function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message.message + "</td></tr>");
}*/
function newBid(bidValue) {
  /*  $("#greetings").text(bidValue.newBidValue );*/
  document.getElementById("greetings").value = bidValue.newBidValue;
}

function newBid(bidValue,id) {
  /*  $("#greetings").text(bidValue.newBidValue );*/
  
  console.log("Inside newBid id : "+id);
  document.getElementById("highBid"+id).value = bidValue.newBidValue;
  document.getElementById("highBidId"+id).value = bidValue.bidderId;
  document.getElementById("highBidName"+id).value = bidValue.bidderName;
  
}




$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
   
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendBid(); });
    
    /*$("#connect1").click( function(){
	$("#normalButton").prop('disabled', true);
	$("#normalButton").prop('disabled', false);
	});*/
});