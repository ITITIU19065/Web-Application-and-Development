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
        <title>Coron-wishlist</title>
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
        <style>
			.alert {
 				 	padding: 20px;
  				 	background-color: #f44336;
  				 	color: white;
			}
			.closebtn {
  					margin-left: 15px;
  					color: white;
  					font-weight: bold;
  					float: right;
  					font-size: 22px;
  					line-height: 20px;
  					cursor: pointer;
  					transition: 0.3s;
			}

			.closebtn:hover {
  					color: black;
			}
		</style>
    </head>
    <body>
            <!-- Add your site or application content here -->
            
            <!--pos page start-->
            <div class="pos_page">
                <div class="container">
                    <!--pos page inner-->
                    <div class="pos_page_inner">  
                    
                    
                       <%@ include file="./includes/header.jsp" %>
                       
                       
                         <!--breadcrumbs area start-->
                        <div class="breadcrumbs_area">
                            <div class="row">
                                <div class="col-12">
                                    <div class="breadcrumb_content">
                                        <ul>
                                            <li><a href="index.jsp">home</a></li>
                                            <li><i class="fa fa-angle-right"></i></li>
                                            <li>wishlist</li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--breadcrumbs area end-->

                         <!--shopping cart area start -->
                        <div class="shopping_cart_area">
                               <form action="#"> 
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="table_desc wishlist">
                                            <%
                                            	String message = (String) session.getAttribute("message");
                                            	if("exist".equals(message)){ %>
                                            <div class="alert">
  												<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  												<strong>Danger!</strong> This product is already in cart list!!!
											</div>
                                            <% 	}
                                            	session.setAttribute("message", "");
                                            %>
                                                <div class="cart_page table-responsive">
                                                    <table>
                                                        <thead>
                                                            <tr>
                                                                <th class="product_remove">Delete</th>
                                                                <th class="product_thumb">Image</th>
                                                                <th class="product_name">Product</th>
                                                                <th class="product-price">Price</th>
                                                                <th class="product_quantity">Stock Status</th>
                                                                <th class="product_total">Add To Cart</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        	 <%
                                    								userDAO daoUser = new userDAO();
                                    								String userName = (String) session.getAttribute("user");
                                    								int userId = daoUser.getUserIdByName(userName);
                                    	
                                    								wishListDAO daoWish = new wishListDAO();
                                    								List<Product> wishList = daoWish.getInWishListByUserId(userId);
                                    								for(Product w:wishList){
                                    						%>
                                                            <tr>
                                                               <td class="product_remove"><a href="DeteleWishList?pid=<%= w.getProductID() %>">X</a></td>
                                                                <td class="product_thumb"><img src="<%= w.getImage() %>" alt=""></td>
                                                                <td class="product_name"><a href="DetailServlet?pid=<%= w.getProductID() %>"><%= w.getProductName() %></a></td>
                                                                <td class="product-price">$<%= w.getPrice() %></td>
                                                                <td class="product_quantity"><%= w.getQuantity() %> Products In Stock</td>
                                                                <td class="product_total"><a href="AddWishListToCart?pid=<%= w.getProductID() %>">Add To Cart</a></td>
                                                            </tr>
															<%
                                    								}
															%>
                                                          

                                                        </tbody>
                                                    </table>   
                                                </div>  

                                            </div>
                                         </div>
                                     </div>

                                </form> 
                                <div class="row">
                                    <div class="col-12">
                                         <div class="wishlist-share">
                                            <h4>Share on:</h4>
                                            <ul>
                                                <li><a href="#"><i class="fa fa-rss"></i></a></li>           
                                                <li><a href="#"><i class="fa fa-vimeo"></i></a></li>           
                                                <li><a href="#"><i class="fa fa-tumblr"></i></a></li>           
                                                <li><a href="#"><i class="fa fa-pinterest"></i></a></li>        
                                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>        
                                            </ul>      
                                        </div>
                                    </div> 
                                </div>

                         </div>
                         <!--shopping cart area end -->

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
