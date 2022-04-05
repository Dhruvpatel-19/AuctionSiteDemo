
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Auction Site</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="Free Website Template" name="keywords">
        <meta content="Free Website Template" name="description">

        <!-- Favicon -->
        <link href="/img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Open+Sans:300;400;600;700;800&display=swap" rel="stylesheet">

        <!-- Font Awesome -->
       <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="/css/bidderDashboard.css" rel="stylesheet">
    </head>

    <body>
        <div class="wrapper">
            <div class="sidebar">
                <div class="sidebar-text d-flex flex-column h-100 justify-content-center text-center">
                    <!-- <img  src="/img/sik2.jpeg" alt="Image"> -->
                    <img  src="https://media.istockphoto.com/photos/gavel-on-auction-word-picture-id917901978?k=20&m=917901978&s=612x612&w=0&h=NULGu8-bVpy28gbW6AZbZlEVra-Q4s2rg607emPfkCs=" alt="Image">
                   <!--  for image border => class="mx-auto d-block w-75 bg-primary img-fluid rounded-circle mb-4 p-3" -->
                    <h1 class="font-weight-bold">Proxibid</h1>
                    <p class="mb-4">
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.
                    </p>
                    <div class="d-flex justify-content-center mb-5">
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-linkedin-in"></i></a>
                        <a class="btn btn-outline-primary mr-2" href="#"><i class="fab fa-instagram"></i></a>
                    </div>
                    <a href="/auctionCatalog" style="background-color:green" class="btn btn-lg btn-block btn-primary mt-auto">Add Auction Events</a>
                </div>
                <div class="sidebar-icon d-flex flex-column h-100 justify-content-center text-right">
                    <i class="fas fa-2x fa-angle-double-right text-primary"></i>
                </div>
            </div>
            <div class="content">
            
                <!-- Navbar Start -->
                <div class="container p-0">
                    <nav class="navbar navbar-expand-lg bg-secondary navbar-dark">
                        <a href="" class="navbar-brand d-block d-lg-none">Navigation</a>
                        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                            <div class="navbar-nav m-auto">
                                <a href="index.html" class="nav-item nav-link active">Home</a>
                                <a href="about.html" class="nav-item nav-link">About</a>
                                <div class="nav-item dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                                    <div class="dropdown-menu">
                                        <a href="blog.html" class="dropdown-item">Blog Grid</a>
                                        <a href="single.html" class="dropdown-item">Blog Detail</a>
                                    </div>
                                </div>
                                <a href="contact.html" class="nav-item nav-link">Contact</a>
                            </div>
                        </div>
                    </nav>
                </div>
                <!-- Navbar End -->
                
                <!-- Carousel Start -->
                <div class="container p-0">
                    <div id="blog-carousel" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="w-100" src="https://www.pixelstalk.net/wp-content/uploads/2016/08/Art-Images-Background.jpg" alt="Image">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <h2 class="mb-3 text-white font-weight-bold">Lorem ipsum dolor sit amet</h2>
                                    <div class="d-flex text-white">
                                        <small class="mr-2"><i class="fa fa-calendar"></i> 01-Jan-2045</small>
                                        <small class="mr-2"><i class="fa fa-clock-o"></i> Web Design</small>
                                        <small class="mr-2"><i class="fa fa-clock-o"></i> 15 Comments</small>
                                    </div>
                                    <a href="" class="btn btn-lg btn-outline-light mt-4"> Read More </a>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img class="w-100" src="https://www.pixelstalk.net/wp-content/uploads/2016/08/Art-Images-Background.jpg" alt="Image">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <h2 class="text-white font-weight-bold">Lorem ipsum dolor sit amet</h2>
                                    <div class="d-flex">
                                        <small class="mr-2"><i class="fa fa-calendar"></i> 01-Jan-2045</small>
                                        <small class="mr-2"><i class="fa fa-clock-o"></i> Web Design</small>
                                        <small class="mr-2"><i class="fa fa-clock-o"></i> 15 Comments</small>
                                    </div>
                                    <a href="" class="btn btn-lg btn-outline-light mt-4">Read More</a>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <img class="w-100" src="https://www.pixelstalk.net/wp-content/uploads/2016/08/Art-Images-Background.jpg" alt="Image">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <h2 class="text-white font-weight-bold">Lorem ipsum dolor sit amet</h2>
                                    <div class="d-flex">
                                        <small class="mr-2"><i class="fa fa-calendar"></i> 01-Jan-2045</small>
                                        <small class="mr-2"><i class="fa fa-clock-o"></i> Web Design</small>
                                        <small class="mr-2"><i class="fa fa-clock-o"></i> 15 Comments</small>
                                    </div>
                                    <a href="" class="btn btn-lg btn-outline-light mt-4">Read More</a>
                                </div>
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#blog-carousel" data-slide="prev">
                            <span class="carousel-control-prev-icon"></span>
                        </a>
                        <a class="carousel-control-next" href="#blog-carousel" data-slide="next">
                            <span class="carousel-control-next-icon"></span>
                        </a>
                    </div>
                </div>
                <!-- Carousel End -->
                
                
                <!-- Blog List Start -->
                
                   <!--  for main.......... -->
                
                <c:forEach var="auction" items="${auctionList}">
                <div class="container bg-white pt-5">
                    <div class="row blog-item px-3 pb-5">
                        <div class="col-md-5">
                            
                            <img src="/auctionimage/${auction.autionImage}" class="img-fluid mb-4 mb-md-0" alt="...">
                        </div>
                        <div class="col-md-7">
                            <h3 class="mt-md-4 px-md-3 mb-2 py-2 bg-white font-weight-bold">${auction.eventName}</h3>
                            
                            <div class="d-flex mb-3">
                            	
                                <small class="mr-2 text-muted"><i class="fa fa-calendar"></i> ${auction.startDate}</small>
                                <small class="mr-2 text-muted"><i class="fa fa-clock-o"></i>${auction.startTime}</small>
                                <small class="mr-2 text-muted"><i class="fa fa-clock-o"></i>${auction.endTime}</small>
                            </div>
                            
                            <p>
                                <i class="fa fa-mobile " style="font-size:20px"></i>&nbsp;${auction.contact}
                            </p>
                            
                            <a class="btn btn-link p-0" href="/bidder/event/${auction.event_id}">Enter Into Auction <i class="fa fa-angle-right"></i></a>
                             <%-- <a href="/bidder/event/${auction.event_id}" class="btn btn-primary">Go somewhere</a> --%>
                        </div>
                    </div>
                    
                    
   <!--                  <div class="row blog-item px-3 pb-5">
                        <div class="col-md-5">
                            <img class="img-fluid mb-4 mb-md-0" src="/img/blog-2.jpg" alt="Image">
                        </div>
                        <div class="col-md-7">
                            <h3 class="mt-md-4 px-md-3 mb-2 py-2 bg-white font-weight-bold">Lorem ipsum dolor sit amet</h3>
                            <div class="d-flex mb-3">
                                <small class="mr-2 text-muted"><i class="fa fa-calendar"></i> 01-Jan-2045</small>
                                <small class="mr-2 text-muted"><i class="fa fa-folder"></i> Web Design</small>
                                <small class="mr-2 text-muted"><i class="fa fa-comments"></i> 15 Comments</small>
                            </div>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu suscipit orci velit id libero
                            </p>
                            <a class="btn btn-link p-0" href="">Read More <i class="fa fa-angle-right"></i></a>
                        </div>
                    </div>
                    <div class="row blog-item px-3 pb-5">
                        <div class="col-md-5">
                            <img class="img-fluid mb-4 mb-md-0" src="/img/blog-3.jpg" alt="Image">
                        </div>
                        <div class="col-md-7">
                            <h3 class="mt-md-4 px-md-3 mb-2 py-2 bg-white font-weight-bold">Lorem ipsum dolor sit amet</h3>
                            <div class="d-flex mb-3">
                                <small class="mr-2 text-muted"><i class="fa fa-calendar"></i> 01-Jan-2045</small>
                                <small class="mr-2 text-muted"><i class="fa fa-folder"></i> Web Design</small>
                                <small class="mr-2 text-muted"><i class="fa fa-comments"></i> 15 Comments</small>
                            </div>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu suscipit orci velit id libero
                            </p>
                            <a class="btn btn-link p-0" href="">Read More <i class="fa fa-angle-right"></i></a>
                        </div>
                        
                        
                        
                        
                    </div> -->
                </div>
                </c:forEach>
                <!-- Blog List End -->
                
                
                <!-- Subscribe Start -->
                <div class="container py-5 px-4 bg-secondary text-center">
                    <h1 class="text-white font-weight-bold">Subscribe My Newsletter</h1>
                    <p class="text-white">Subscribe and get my latest article in your inbox</p>
                    <form class="form-inline justify-content-center">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Your Email">
                            <div class="input-group-append">
                              <button class="btn btn-primary" type="submit">Subscribe</button>
                            </div>
                          </div>
                    </form>
                </div>
                <!-- Subscribe End -->
                
                
                <!-- Blog List Start -->
                
            
                
              <%--   <div class="container bg-white pt-5">
                     <c:forEach var="auction" items="${auctions}">
                <div class="container bg-white pt-5">
                    <div class="row blog-item px-3 pb-5">
                        <div class="col-md-5">
                            <img class="img-fluid mb-4 mb-md-0" src="/img/blog-1.jpg" alt="Image">
                        </div>
                        <div class="col-md-7">
                            <h3 class="mt-md-4 px-md-3 mb-2 py-2 bg-white font-weight-bold">${auction.category}</h3>
                            <div class="d-flex mb-3">
                                <small class="mr-2 text-muted"><i class="fa fa-calendar"></i> ${auction.startDate}</small>
                                <small class="mr-2 text-muted"><i class="fa fa-clock-o"></i>${auction.startTime}</small>
                                <small class="mr-2 text-muted"><i class="fa fa-clock"></i>${auction.endTime}</small>
                            </div>
                            <p>
                                ${auction.contact}
                            </p>
                            <a class="btn btn-link p-0" href="">Read More <i class="fa fa-angle-right"></i></a>
                        </div>
                    </div>
                    
                    </div>
                    </c:forEach>
                    
                </div> --%>
                <!-- Blog List End -->
                
                
                <!-- Footer Start -->
                <div class="container py-4 bg-secondary text-center">
                    <p class="m-0 text-white">
                        &copy; <a class="text-white font-weight-bold" href="#">Your Site Name</a>. All Rights Reserved. Designed by <a class="text-white font-weight-bold" href="https://htmlcodex.com">HTML Codex</a>
                    </p>
                </div>
                <!-- Footer End -->
            </div>
        </div>
        
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-angle-double-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="/lib/easing/easing.min.js"></script>
        <script src="/lib/waypoints/waypoints.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="/mail/jqBootstrapValidation.min.js"></script>
        <script src="/mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="/js/main.js"></script>
    </body>
</html>
