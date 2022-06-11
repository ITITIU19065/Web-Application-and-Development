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
    </head>
    <body>
            <!-- Add your site or application content here -->
            
            <!--pos page start-->
            <div class="pos_page">
                <div class="container">
                    <!--pos page inner-->
                    <div class="pos_page_inner">  
                       <%@ include file="./includes/headerAdmin.jsp" %>
                         <!--breadcrumbs area start-->
                        <div class="breadcrumbs_area">
                            <div class="row">
                                <div class="col-12">
                                    <div class="breadcrumb_content">
                                        <ul>
                                            <li><a href="AdminIndex.jsp">home</a></li>
                                            <li><i class="fa fa-angle-right"></i></li>
                                            <li>Order Page Admin</li>
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
                                                <div class="cart_page table-responsive">
                                                    <table>
                                                        <thead>
                                                            <tr>
                                                              
                                                             
                                                                <th class="product_name">Name</th>
                                                                <th class="product-price">orderCreated</th>
                                                                <th class="product_quantity">Address, City</th>
                                                                <th class="product_total">Phone</th>
                                                                <th class="product_total">View</th>
                                                                <th class="product_total">Delivery</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        <%
                                                        	orderDAO dao = new orderDAO();
                                                        	List<OrderDetail> order =  dao.getAllOrderByAdmin();
                                                        	for(OrderDetail o:order){ %>
                                                        	<tr>
                                                          
                                                                
                                                                <td class="product_name"><a href="#"><%= o.getShippedFname() %> <%= o.getShippedLName() %></a></td>
                                                                <td class="product_quantity"><%= o.getOrderCreated() %></td>
                                                                <td class="product_quantity"><%= o.getShippedAddress() %>, <%= o.getShippedCity() %></td>
                                                                <td class="product_quantity"><%= o.getShippedPhone() %></td>
                                                                <td ><a class="view" href="ViewInforOrder?oid=<%= o.getOrderID() %>">View</a></td>
                                                                <%
                                                                	if(o.isShippedStatus() == false){ %>
                                                                		<td class="product_total"><a href="DeliveryServlet?oid=<%= o.getOrderID() %>">Delivery</a></td>
                                                                <%	}else{ %>
                                                                		<td class="product_name">Successfully Delivery</td>
                                                               <% }
                                                                %>
                                                                
                                                            </tr>
                                                        <%	}
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
