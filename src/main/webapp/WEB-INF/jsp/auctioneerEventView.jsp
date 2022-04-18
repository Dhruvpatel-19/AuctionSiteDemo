<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&display=swap" rel="stylesheet">
    
    <title>Auction Page</title>
<!--

TemplateMo 548 Training Studio

https://templatemo.com/tm-548-training-studio

-->
    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

    <link rel="stylesheet" href="/css/templatemo-training-studio.css">
    
   <!--  <link href="/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
   <!--  <link href="/main.css" rel="stylesheet"> -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/sockjs-client/sockjs.min.js"></script>
    <script src="/webjars/stomp-websocket/stomp.min.js"></script>
    <script src="/js/app.js"></script>
    
    </head>
    
    <body>
    
    <!-- ***** Preloader Start ***** -->
    <div id="js-preloader" class="js-preloader">
      <div class="preloader-inner">
        <span class="dot"></span>
        <div class="dots">
          <span></span>
          <span></span>
          <span></span>
        </div>
      </div>
    </div>
    <!-- ***** Preloader End ***** -->
    
    
    <!-- ***** Header Area Start ***** -->
    <header class="header-area header-sticky">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav class="main-nav">
                        <!-- ***** Logo Start ***** -->
                        <a href="index.html" class="logo">PROXI<em>BID</em></a>
                        <!-- ***** Logo End ***** -->
                        <!-- ***** Menu Start ***** -->
                        <ul class="nav">
                            <li class="scroll-to-section"><a href="#top" class="active">Home</a></li>
                            <li class="scroll-to-section"><a href="#features">About</a></li>
                            
                        </ul>        
                        <a class='menu-trigger'>
                            <span>Menu</span>
                        </a>
                        <!-- ***** Menu End ***** -->
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- ***** Header Area End ***** -->

    <!-- ***** Main Banner Area Start ***** -->
    <div class="main-banner" id="top">
        <video autoplay muted loop id="bg-video">
            <source src="assets/images/gym-video.mp4" type="video/mp4" />
        </video>

        <div class="video-overlay header-text">
            <div class="caption">
                
                <h2>${auctionName}</h2>
                <div class="main-button scroll-to-section">
                    <h6>${description}</h6>
                </div>
            </div>
        </div>
    </div>
    <!-- ***** Main Banner Area End ***** -->

    <!-- ***** Features Item Start ***** -->
    <%-- <c:forEach var="inventory" items="${items}"> --%>
    <section class="section" id="features">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="section-heading">
                        <h2>Auction&nbsp;<em>Items</em></h2>
                        <img src="/images/line-dec.png" alt="waves">        
                    </div>
                </div>
                
               
                <div class="col-lg-6">
                 <c:forEach var="inventory" items="${items}">
                    <ul class="features-items">
                        <li class="feature-item">
                            <div class="left-icon">
                                <img src="/catalogimage/${inventory.image}" alt="First One">
                            </div>
                            <div class="right-content">
                             
                               
                              <h4>${inventory.name}</h4>
                              <p>${inventory.descInventory}</p>
                              
                             <%--  <c:if test="${inventory.isSold}">
                            	<p id="isSold">This Item Is Sold for ${inventory.soldPrice}<p>
                              </c:if> --%>
                   
                             
                              
                    		   <c:choose>
    									<c:when test="${inventory.isSold}">
    										<p id="isSold">This Item Is Sold for ${inventory.soldPrice}<p>
    										<p>Sold for :</p>
                             				<input type="number" id = "greetings${inventory.inventoryId}" value="${inventory.soldPrice}">
    										
    										<button disabled="disabled" id="connect${inventory.inventoryId}" class="btn btn-default">Start Bid</button> 
                    		  				<button disabled="disabled" id="disconnect${inventory.inventoryId}" class="btn btn-default">Accept Bid</button>
                    		  				
                    		  				<br>
                              				<p>Winner Bidder Id :</p>
                              				<input id = "highBidId${inventory.inventoryId}" value="${soldItem.get(inventory.inventoryId - 1).bidderId}">
                              				<p>Winner Bidder:</p>
                             				<input id = "highBidName${inventory.inventoryId}" value="${soldItem.get(inventory.inventoryId - 1).bidderName}">		 					
    									</c:when>
    									    
    									<c:otherwise>
    										<p>Current Bid :</p>
                              				<input type="number" id = "greetings${inventory.inventoryId}" value="${inventory.start_bid}">
        									
        									<button id="connect${inventory.inventoryId}" class="btn btn-default" type="submit" onclick="connect('${inventory.inventoryId}')">Start Bid</button> 
                    		 				<button id="disconnect${inventory.inventoryId}" class="btn btn-default" type="submit"  onclick="acceptBid('${inventory.inventoryId}')">Accept Bid</button>
                    		 				
                    		 				<br>
                              				<p>Highest Bidder Id :</p>
                              				<input id = "highBidId${inventory.inventoryId}" value="None">
                              				<p>Highest Bidder:</p>
                              				<input id = "highBidName${inventory.inventoryId}" value="None">	
   										</c:otherwise>
   										
								</c:choose>
                              
                            </div>
                        </li>
                    </ul>
                  </c:forEach>
                </div>
               
            </div>
        </div>
    </section>
     
    <!-- ***** Features Item End ***** -->

    <!-- ***** Call to Action Start ***** -->
   <section class="section" id="call-to-action">
       <div class="container">
   
            <div class="row">
                <div class="col-lg-10 offset-lg-1">
                    <div class="cta-content">
                        <h2>PROXI<em>BID</em>!</h2>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                        <div class="main-button scroll-to-section">
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
    <!-- ***** Call to Action End ***** -->

    
    
    <!-- ***** Footer Start ***** -->
    <!-- <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; 2020 Training Studio
                    
                    - Designed by <a rel="nofollow" href="https://templatemo.com" class="tm-text-link" target="_parent">TemplateMo</a></p>
                    
                 
                    
                </div>
            </div>
        </div>
    </footer> -->

    <!-- jQuery -->
    <script src="/js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="/js/popper.js"></script>
    <script src="/js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="/js/scrollreveal.min.js"></script>
    <script src="/js/waypoints.min.js"></script>
    <script src="/js/jquery.counterup.min.js"></script>
    <script src="/js/imgfix.min.js"></script> 
    <script src="/js/mixitup.js"></script> 
    <script src="/js/accordions.js"></script>
    
    <!-- Global Init -->
    <script src="/js/custom.js"></script>

  </body>
</html>