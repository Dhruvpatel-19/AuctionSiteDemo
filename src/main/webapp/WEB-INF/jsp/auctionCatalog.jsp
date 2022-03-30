<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bidstyle.css"> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">
 <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">

</head>
<body>

<section>
<div style="top-padding:50px;">
<h2 style="background-color:#28a745;color:white;">Proxibid - A trusted Auction Site </h2>  
</div>
<div class="container-fluid px-1 py-5 mx-auto">

    <div class="row d-flex justify-content-center">
        <div>
        
            <div class="card" >
                <h5 class="text-center mb-4">Auction Events</h5>
                <form method="POST" enctype="multipart/form-data" action="/auctionhouse/auction" id="auctionform" name="auctionform">
                     <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Event Name<span class="text-danger"> *</span></label> <input type="text" id="fname" name="category" placeholder="Enter event name" onblur="validate(1)"> </div>
                        
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Email<span class="text-danger"> *</span></label> <input type="text" id="email" name="email" placeholder="Enter Email" onblur="validate(3)"> </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Phone number<span class="text-danger"> *</span></label> <input type="text" id="mob" name="contact" placeholder="Enter Phone number" onblur="validate(4)"> </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Start Date<span class="text-danger"> *</span></label> <input type="date" id="job" name="startDate" placeholder="" onblur="validate(5)"> </div>
                    </div>
                    <div class="row justify-content-between text-left">
                         <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Start Time<span class="text-danger"> *</span></label> <input type="time" id="fname" name="startTime" placeholder="Enter start time" onblur="validate(1)"> </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">End Time<span class="text-danger"> *</span></label> <input type="time" id="lname" name="endTime" placeholder="Enter end time" onblur="validate(2)"> </div> 
                   
                    </div>
                    
                    <br> 
                     <hr class="dashed">
                     <br> 
                     
<!-- FOR ADD ITEMS....  -->                    
                     <div id="inputFormRow">
                     <div class="row justify-content-end">
                   	<div class="form-group col-sm-5">
                   	 <input type="button"  id="addRow" value ="Add Another Item" style="width:270px;" class="btn-block btn-primary"> </div>
                   
                   
                   
                    </div>
                     
                     <div class="row justify-content-between text-left">
                        <div class="form-group col-sm-6 flex-column d-flex"> 
                        <label class="form-control-label px-3">Select Image of the Item<span class="text-danger"> *</span></label> 
                        <input type="file" id="itemImage" name="itemImage" placeholder="Choose File" onblur="validate(1)" > </div>
                        <!-- <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Last name<span class="text-danger"> *</span></label> <input type="text" id="lname" name="lname" placeholder="Enter your last name" onblur="validate(2)"> </div> -->
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Product/Item name:<span class="text-danger"> *</span></label> <input type="text" id="name" name="itemName" placeholder="Enter Item Name" onblur="validate(3)"> </div>
                    </div>
                    <div class="row justify-content-between text-left">
                        
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Enter the initial bid:<span class="text-danger"> *</span></label> <input type="text" id="mob" name="start_Bid" placeholder="Enter Initial Bid" onblur="validate(4)"> </div>
                        <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Product/Item description:<span class="text-danger"> *</span></label> <input type="text" id="job" name="descc" placeholder="Enter the Description" onblur="validate(5)" > </div>
                    </div>

								<div class="input-group">
									<button id="removeRow" type="button" class="btn btn-danger">remove
										this product</button>
								</div>
							<!-- 	<hr class="dashed"> -->
                      <hr class="dashed">
                     <div id="newRow"></div>
                    
                    
                     
                      <div class="row justify-content-end">
                        <div class="form-group col-sm-6">
                         <input type="submit" style="background-color:green" class="btn-block btn-primary">
                          </div>
                    </div>
                    </div>
                </form>
               
            </div>
            
            
        </div>
    </div>
</div>
</section>

<script>


$("#addRow").click(function () {
    var html = '';
   
    html += '<br>';
    html += '<div id="inputFormRow">';
    html += '<div class="row justify-content-between text-left">';
    html += '<div class="form-group col-sm-6 flex-column d-flex">'; 
    html += '<label class="form-control-label px-3">Select Image of the Item<span class="text-danger"> *</span></label>';
    html += '<input type="file" id="itemImage" name="itemImage" placeholder="Choose File" onblur="validate(1)" > </div>';
    <!-- <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Last name<span class="text-danger"> *</span></label> <input type="text" id="lname" name="lname" placeholder="Enter your last name" onblur="validate(2)"> </div> -->
    html += '<div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Product/Item name:<span class="text-danger"> *</span></label> <input type="text" id="name" name="itemName" placeholder="Enter Item Name" onblur="validate(3)"> </div>';
    html += '</div>';
  
    html +=  ' <div class="row justify-content-between text-left">';
    
    html +=' <div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Enter the initial bid:<span class="text-danger"> *</span></label> <input type="text" id="mob" name="start_Bid" placeholder="Enter Initial Bid" onblur="validate(4)"> </div>';
    html += '<div class="form-group col-sm-6 flex-column d-flex"> <label class="form-control-label px-3">Product/Item description:<span class="text-danger"> *</span></label> <input type="text" id="job" name="descc" placeholder="Enter the Description" onblur="validate(5)" > </div>';
    html += '</div>';
    html += '<div class="input-group">';
    html += ' <button id="removeRow" type="button" class="btn btn-danger">remove this product</button>';
    html += '</div>'; 
    html += ' <hr class="dashed">';
    html += '</div>';

    $('#newRow').append(html);
    
    $(document).on('click', '#removeRow', 
        	function () 
        	{
            $(this).closest('#inputFormRow').remove();
        });

});
/*     function validate(val) {
	v1 = document.getElementById("fname");
	v2 = document.getElementById("lname");
	v3 = document.getElementById("email");
	v4 = document.getElementById("mob");
	v5 = document.getElementById("job");
	v6 = document.getElementById("ans");

	flag1 = true;
	flag2 = true;
	flag3 = true;
	flag4 = true;
	flag5 = true;
	flag6 = true;

	if(val>=1 || val==0) {
	if(v1.value == "") {
	v1.style.borderColor = "red";
	flag1 = false;
	}
	else {
	v1.style.borderColor = "green";
	flag1 = true;
	}
	}

	if(val>=2 || val==0) {
	if(v2.value == "") {
	v2.style.borderColor = "red";
	flag2 = false;
	}
	else {
	v2.style.borderColor = "green";
	flag2 = true;
	}
	}
	if(val>=3 || val==0) {
	if(v3.value == "") {
	v3.style.borderColor = "red";
	flag3 = false;
	}
	else {
	v3.style.borderColor = "green";
	flag3 = true;
	}
	}
	if(val>=4 || val==0) {
	if(v4.value == "") {
	v4.style.borderColor = "red";
	flag4 = false;
	}
	else {
	v4.style.borderColor = "green";
	flag4 = true;
	}
	}
	if(val>=5 || val==0) {
	if(v5.value == "") {
	v5.style.borderColor = "red";
	flag5 = false;
	}
	else {
	v5.style.borderColor = "green";
	flag5 = true;
	}
	}
	if(val>=6 || val==0) {
	if(v6.value == "") {
	v6.style.borderColor = "red";
	flag6 = false;
	}
	else {
	v6.style.borderColor = "green";
	flag6 = true;
	}
	}

	flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;

	return flag;
	} */
   
    
   
</script>
</body>
</html>