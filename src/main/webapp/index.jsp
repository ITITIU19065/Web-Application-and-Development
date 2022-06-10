<%@page import="Context.*" %>
<%@page import="control.*" %>
<%@page import="DAO.*" %>
<%@page import="entity.*" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
	}
%>
<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Coron - Fashion eCommerce Shopping</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets\img\favicon.png">
		
		<!-- all css here -->
        <link rel="stylesheet" href="assets\css\bootstrap.min.css">
        <link rel="stylesheet" href="assets\css\plugin.css">
        <link rel="stylesheet" href="assets\css\bundle.css">
        <link rel="stylesheet" href="assets\css\style.css">
        <link rel="stylesheet" href="assets\css\responsive.css">
        <script src="assets\js\vendor\modernizr-2.8.3.min.js"></script>
    </head>
    <body>
            <!-- Add your site or application content here -->
            
            <!--pos page start-->
            <div class="pos_page">
                <div class="container">
                   <!--pos page inner-->
                    <div class="pos_page_inner">  
                    
                    
                       <%@ include file="./includes/header.jsp" %>
                       
                       
                       
                       
                        <!--pos home section-->
                        <div class=" pos_home_section">
                            <div class="row pos_home">
                                <div class="col-lg-3 col-md-8 col-12">
                                   <!--sidebar banner-->
                                    <div class="sidebar_widget banner mb-35">
                                        <div class="banner_img mb-35">
                                            <a href="#"><img src="assets\img\banner\banner5.jpg" alt=""></a>
                                        </div>
                                        <div class="banner_img">
                                            <a href="#"><img src="assets\img\banner\banner6.jpg" alt=""></a>
                                        </div>
                                    </div>
                                    <!--sidebar banner end-->

                                    <!--categorie menu start-->
                                    <div class="sidebar_widget catrgorie mb-35">
                                        <h3>Categories</h3>
                                        <ul>
                                            <li class="has-sub"><a href="#"><i class="fa fa-caret-right"></i> Category</a>
                                                <ul class="categorie_sub">
                                               <%
                                               	categoryDAO cate = new categoryDAO();
                                               List<Category> listCate = cate.getAllCategory();
                                               if(!listCate.isEmpty()){
                                            	   for(Category c:listCate){ %>
                                            		   <li><a href="CategoryServlet?cateID=<%= c.getCateID() %>"><i class="fa fa-caret-right"></i><%= c.getCateName() %></a></li>
                                            <%	   }
                                               }
                                               %>
                                                </ul>     
                                            </li>
                                            <li class="has-sub"><a href="#"><i class="fa fa-caret-right"></i> Brand</a>
                                                <ul class="categorie_sub">
                                                    <%
														brandDAO brand = new brandDAO();
                                                    	List<Brand> listBrand = brand.getAllBrand();
                                                    	if(!listBrand.isEmpty()){
                                                    		for(Brand b:listBrand){ %>
                                                    			<li><a href="BrandServlet?brandID=<%= b.getBrandID() %> "><i class="fa fa-caret-right"></i> <%= b.getBrandName() %></a></li>
                                                    <%		}
                                                    	}
                                                    %>
                                                    
                                                </ul> 
                                            </li>
                                            <li class="has-sub"><a href="#"><i class="fa fa-caret-right"></i>Price</a>
                                                <ul class="categorie_sub">
                                                    <li><a href="SearchByPrice?action=1"><i class="fa fa-caret-right"></i>less than $100</a></li>
                                                    <li><a href="SearchByPrice?action=2"><i class="fa fa-caret-right"></i>$100-$200</a></li>
                                                    <li><a href="SearchByPrice?action=3"><i class="fa fa-caret-right"></i>$200-$500</a></li>
                                                    <li><a href="SearchByPrice?action=4"><i class="fa fa-caret-right"></i>Greater than $500</a></li>
                                                </ul>     
                                            </li>
                                        </ul>
                                    </div>
                                    <!--categorie menu end-->

                                    <!--wishlist block start-->
                                    <div class="sidebar_widget wishlist mb-35">
                                        <div class="block_title">
                                            <h3><a href="#">Wishlist</a></h3>
                                        </div>
                                    <%
                                    	userDAO daoUser = new userDAO();
                                    	String userName = (String) session.getAttribute("user");
                                    	int userId = daoUser.getUserIdByName(userName);
                                    	
                                    	wishListDAO daoWish = new wishListDAO();
                                    	List<Product> wishList = daoWish.getInWishListByUserId(userId);
                                    	for(Product w:wishList){
                                    %>
                                        <div class="cart_item">
                                           <div class="cart_img">
                                               <a href="#"><img src="<%= w.getImage() %>" alt=""></a>
                                           </div>
                                            <div class="cart_info">
                                                <a href="#">$<%= w.getProductName() %></a>
                                                <span class="cart_price">$<%= w.getPrice() %></span>
                                               
                                            </div>
                                            <div class="cart_remove">
                                                <a title="Remove this item" href="DeteleWishList?pid=<%= w.getProductID() %>"><i class="fa fa-times-circle"></i></a>
                                            </div>
                                        </div>
                                      <%
                                    	}
                                      %>
                                        <div class="block_content">
                                            <p><%= wishList.size()%> products</p>
                                            <a href="wishList.jsp">» My wishlists</a>
                                        </div>
                                    </div>
                                    <!--wishlist block end-->

                                    <!--sidebar banner-->
                                    <div class="sidebar_widget bottom ">
                                        <div class="banner_img">
                                            <a href="#"><img src="assets\img\banner\banner9.jpg" alt=""></a>
                                        </div>
                                    </div>
                                    <!--sidebar banner end-->



                                </div>
                                <div class="col-lg-9 col-md-12">
                                    <!--banner slider start-->
                                    <div class="banner_slider slider_1">
                                        <div class="slider_active owl-carousel">
                                            <div class="single_slider" style="background-image: url(assets/img/forgot/accessories-collection.png)">
                                                <div class="slider_content">
                                                    <div class="slider_content_inner">  
                                                        <h1>Clothing Fashion Store</h1>
                                                        <p>Clothing - The best choice for fashion </p>
                                                        <a href="index.jsp">shop now</a>
                                                    </div>     
                                                </div>    
                                            </div>
                                            <div class="single_slider" style="background-image: url(assets/img/slider/slider_2.png)">
                                                <div class="slider_content">
                                                    <div class="slider_content_inner">  
                                                        <h1>New Collection</h1>
                                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. </p>
                                                        <a href="#">shop now</a>
                                                    </div>         
                                                </div>         
                                            </div>
                                            <div class="single_slider" style="background-image: url(assets/img/slider/slider_3.png)">
                                                <div class="slider_content">  
                                                    <div class="slider_content_inner">  
                                                        <h1>Best Collection</h1>
                                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. </p>
                                                        <a href="#">shop now</a>
                                                    </div> 
                                                </div> 
                                            </div>
                                        </div>
                                    </div> 
                                    

                                    
									<!-- Category Search Product Start -->
									<c:forEach items="${cateChecking }" var="c" >
									<div class="new_product_area">
                                        <div class="block_title">
                                            <h3>Searching ${cateChecking} Products</h3>
                                        </div>
                                        <div class="row">
                                            <div class="product_active owl-carousel">
                                            
									<c:forEach items="${listC}" var="l">
										<div class="col-lg-3">
                                                    <div class="single_product">
                                                        <div class="product_thumb">
                                                           <a href="single-product.html"><img src="${l.image }" alt=""></a> 
                                                           <div class="img_icone">
                                                               <img src="assets\img\cart\span-new.png" alt="">
                                                           </div>
                                                           <div class="product_action">
                                                               <a href="AddCartServlet?pid=${l.productID}"> <i class="fa fa-shopping-cart"></i> Add to cart</a>
                                                           </div>
                                                        </div>
                                                        <div class="product_content">
                                                            <span class="product_price">$${l.price } </span>
                                                            <h3 class="product_title"><a href="DetailServlet?pid=${l.productID}">${ l.productName }</a></h3>
                                                        </div>
                                                        <div class="product_info">
                                                            <ul>
                                                                <li><a href="AddWishList?pid=${l.productID}" title=" Add to Wishlist ">Add to Wishlist</a></li>
                                                                <li><a href="DetailServlet?pid=${l.productID}">View Detail</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
									</c:forEach>
											</div> 
                                        </div>       
                                    </div>
								</c:forEach> 
                                    <!-- Category Search Product End -->
                                    
                                    
                                    <!--New product area start-->
                                    <div class="new_product_area">
                                        <div class="block_title">
                                            <h3>Newest Products</h3>
                                        </div>
                                        <div class="row">
                                            <div class="product_active owl-carousel">
                                            
                                            <%
                                            	productDAO productNew = new productDAO();
                                            	List<Product> listNewP = productNew.getNewProduct();
                                            	if(!listNewP.isEmpty()){
                                            		for(Product p:listNewP){ %>
                                            	<div class="col-lg-3">
                                                    <div class="single_product">
                                                        <div class="product_thumb">
                                                           <a href="single-product.html"><img src="<%= p.getImage() %>" alt=""></a> 
                                                           <div class="img_icone">
                                                               <img src="assets\img\cart\span-new.png" alt="">
                                                           </div>
                                                           <div class="product_action">
                                                               <a href="AddCartServlet?pid=<%= p.getProductID() %>"> <i class="fa fa-shopping-cart"></i> Add to cart</a>
                                                           </div>
                                                        </div>
                                                        <div class="product_content">
                                                            <span class="product_price">$<%= p.getPrice() %>  </span>
                                                            <h3 class="product_title"><a href="DetailServlet?pid=<%= p.getProductID() %>"><%= p.getProductName() %></a></h3>
                                                        </div>
                                                        <div class="product_info">
                                                            <ul>
                                                                <li><a href="AddWishList?pid=<%= p.getProductID() %>" title=" Add to Wishlist ">Add to Wishlist</a></li>
                                                                <li><a href="DetailServlet?pid=<%= p.getProductID() %>">View Detail</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            <%		}
                                            	}
                                            %>
                                                
                                            </div> 
                                        </div>       
                                    </div> 
                                    <!--New product area End-->

                                    <!--All product area start-->
                                    <div class="new_product_area">
                                        <div class="block_title">
                                            <h3>All Products</h3>
                                        </div>
                                        <div class="row">
                                            <div class="product_active owl-carousel">
                                            
                                            <%
                                            	productDAO product = new productDAO();
                                            	List<Product> listP = productNew.getAllProduct();
                                            	if(!listP.isEmpty()){
                                            		for(Product p:listP){ %>
                                            	<div class="col-lg-3">
                                                    <div class="single_product">
                                                        <div class="product_thumb">
                                                           <a href="single-product.html"><img src="<%= p.getImage() %>" alt=""></a> 
                                                          
                                                           <div class="product_action">
                                                               <a href="AddCartServlet?pid=<%= p.getProductID() %>"> <i class="fa fa-shopping-cart"></i> Add to cart</a>
                                                           </div>
                                                        </div>
                                                        <div class="product_content">
                                                            <span class="product_price">$<%= p.getPrice() %></span>
                                                            <h3 class="product_title"><a href="DetailServlet?pid=<%= p.getProductID() %>"><%= p.getProductName() %></a></h3>
                                                        </div>
                                                        <div class="product_info">
                                                            <ul>
                                                                <li><a href="AddWishList?pid=<%= p.getProductID() %>" title=" Add to Wishlist ">Add to Wishlist</a></li>
                                                                <li><a href="DetailServlet?pid=<%= p.getProductID() %>" >View Detail</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            <%		}
                                            	}
                                            %>
                                                
                                            </div> 
                                        </div>       
                                    </div> 
                                    <!--All product area End-->  

                                    <!--Sale off product start--> 
                                    <div class="featured_product">
                                        <div class="block_title">
                                            <h3>Sale Off Products</h3>
                                        </div>
                                        <div class="row">
                                            <div class="product_active owl-carousel">
                                            <%
                                            productDAO productOff = new productDAO();
                                            List<Product> listOff = productOff.getDiscountProduct();
                                            if(!listOff.isEmpty()){
                                            	for(Product p:listOff){ %>
                                            		<div class="col-lg-3">
                                                    <div class="single_product">
                                                        <div class="product_thumb">
                                                           <a href="single-product.html"><img src="<%= p.getImage() %>" alt=""></a> 
                                                           <div class="hot_img">
                                                               <img src="assets\img\cart\span-hot.png" alt="">
                                                           </div>
                                                           <div class="product_action">
                                                               <a href="AddCartServlet?pid=<%= p.getProductID() %>"> <i class="fa fa-shopping-cart"></i> Add to cart</a>
                                                           </div>
                                                        </div>
                                                        <div class="product_content">
                                                            <span class="product_price">
                                                            	<p style="color: red;">Sale off <%= p.getDiscount() %>%</p> 
                                                            	<p style="text-decoration: line-through">$<%= p.getPrice() %></p>
                                                            	$<%= p.getDisPrice() %>
                                                            </span>
                                                            <h3 class="product_title"><a href="DetailServlet?pid=<%= p.getProductID() %>"><%= p.getProductName() %></a></h3>
                                                        </div>
                                                        <div class="product_info">
                                                            <ul>
                                                                <li><a href="AddWishList?pid=<%= p.getProductID() %>" title=" Add to Wishlist ">Add to Wishlist</a></li>
                                                                <li><a href="DetailServlet?pid=<%= p.getProductID() %>">View Detail</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            <%	}
                                            }
                                            %>                                                
                                            </div> 
                                        </div> 
                                    </div>     
                                    <!--Sale Off product end--> 

                                    <!--banner area start-->
                                    <div class="banner_area mb-60">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                                <div class="single_banner">
                                                    <a href="#"><img src="assets\img\banner\banner7.jpg" alt=""></a>
                                                    <div class="banner_title">
                                                        <p>Up to <span> 40%</span> off</p>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <div class="single_banner">
                                                    <a href="#"><img src="assets\img\banner\banner8.jpg" alt=""></a>
                                                    <div class="banner_title title_2">
                                                        <p>sale off <span> 30%</span></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>     
                                    <!--banner area end-->      
                                </div>
                            </div>  
                        </div>
                        <!--pos home section end-->
                    </div>
                    <!--pos page inner end-->
                </div>
            </div>
            <!--pos page end-->
            
            <%@ include file="./includes/footer.jsp" %>
            
            
            
		<!-- all js here -->
        <script src="assets\js\vendor\jquery-1.12.0.min.js"></script>
        <script src="assets\js\popper.js"></script>
        <script src="assets\js\bootstrap.min.js"></script>
        <script src="assets\js\ajax-mail.js"></script>
        <script src="assets\js\plugins.js"></script>
        <script src="assets\js\main.js"></script>
    </body>
</html>
