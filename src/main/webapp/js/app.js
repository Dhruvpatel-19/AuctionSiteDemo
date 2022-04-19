var stompClient = null;


function connect(id) {
    var socket = new SockJS('/bidwebsocket');
    console.log('Inventory wih id'+id+' is connected');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
      
        console.log('Connected: ' + frame);
        
        $("#connect"+id).prop('disabled', true);
        
        stompClient.subscribe('/bid/newBid', function (newBid1) {
			//console.log("newBid value "+newBid1.body);
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
   
    console.log("Disconnected");    
    
    //reload page
    location.reload();
}


function disconnect(id) {
	console.log('Inventory wih id'+id+' is disconnected');
    if (stompClient !== null) {
        stompClient.disconnect();
    }

    console.log("Disconnected");
}


function sendBid(bidderId,bidderName,id) {
	console.log("bidderId : "+bidderId);
	
	//$("#send"+id).prop('disabled', true);
	if(stompClient != null){
		if( Number($("#bidInput"+id).val()) >  Number($("#highBid"+id).val()))
		{
    		stompClient.send("/app/addBid", {}, JSON.stringify({'bidderId' : Number(bidderId), 'bidderName': bidderName ,'oldBidValue': Number($("#bidInput"+id).val())}));
    	}
    	else{
		
			//console.log("Your Bid is Low");
			alert("Your Bid is Low");
		}
	}
	else{
		console.log("Websocket not connected...");
	}
}


function acceptBid(id) {
    
    stompClient.send("/app/bidCompleted", {}, JSON.stringify({'inventoryId' : Number(id) , 'soldPrice': Number($("#highBid"+id).val()) , 'bidderId':Number($("#highBidId"+id).val()) , 'bidderName': $("#highBidName"+id).val() }));
    
}



function newBid(bidValue,id) {
    
  console.log("Inside newBid id : "+id);
  document.getElementById("highBid"+id).value = bidValue.newBidValue;
  document.getElementById("highBidId"+id).value = bidValue.bidderId;
  document.getElementById("highBidName"+id).value = bidValue.bidderName;
  
}


$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
});