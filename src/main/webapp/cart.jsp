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
        <title>Coron-cart</title>
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
                                            <li>Shopping Cart</li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--breadcrumbs area end-->



                         <!--shopping cart area start -->
                        <div class="shopping_cart_area">
                            <form action="CheckOutServlet" method="POST"> 
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="table_desc">
                                            <%
                                            	String message = (String) session.getAttribute("message");
                                            	if("over".equals(message)){ %>
                                            <div class="alert">
  												<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  												<strong>Danger!</strong> The Quantity Instock of Product Is Over.
											</div>
                                            <% 	}
                                            	session.setAttribute("message", "");
                                            %>
                                            <%
                                            	if("exist".equals(message)){ %>
                                            <div class="alert">
  												<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  												<strong>Danger!</strong> This product is already in cart list!!!
											</div>
                                            <% 	}
                                            	session.setAttribute("message", "");
                                            %>
											<%
                                            	if("empty".equals(message)){ %>
                                            <div class="alert">
  												<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  												<strong>Danger!</strong> Your cart is empty
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
                                                        <th class="product-price">Discount</th>
                                                        <th class="product-price">Dis Price</th>
                                                        <th class="product-price">Decrease</th>
                                                        <th class="product_quantity">Quantity</th>
                                                        <th class="product-price">Increase</th>
                                                        <th class="product-price">Size</th>
                                                        <th class="product_total">Sub Total</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                
                                                <%
                                                	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
                                                	List<Cart> cartProduct = null;
                                                	if(cart_list != null ){
                                                		cartDAO dao = new cartDAO();
                                                		cartProduct = dao.getCartProduct(cart_list);
                                                		request.setAttribute("cart_list", cart_list);
                                                	}
                                                	if(cart_list != null){
                                                		for(Cart c:cartProduct){ 
                                                			
                                                		%>
                           									<tr>
                                                       			<td class="product_remove"><a href="DeleteCartServlet?pid=<%= c.getProductID()%>"><i class="fa fa-trash-o"></i></a></td>
                                                        		<td class="product_thumb" ><img src="<%= c.getImage() %>" alt=""></td>
                                                        		<td class="product_name"><a href="DetailServlet?pid=<%= c.getProductID() %>"><%= c.getProductName() %></a></td>
                                                        		<td class="product-price">$<%= c.getPrice() %></td>
                                                        		<td class="product-price"><%= c.getDiscount()%>%</td>
                                                        		<td class="product-price">$<%= c.getDisPrice() %></td>
                                                        		<td class="product-price">
																	<div class="cart_submit">
                                                    					<button type="submit"><a href="QuantityButton?action=dec&pid=<%= c.getProductID() %>">Decrease</a></button>
                                               		 				</div> 
																</td>
                                                        		<td class="product-price"><%= c.getQuantityOrder()%></td>
                                                        		<td class="product-price">
                                                        			<div class="cart_submit">
                                                    					<button type="submit"><a href="QuantityButton?action=ins&pid=<%= c.getProductID() %>">Increase</a></button>
                                                					</div> 
                                                        		</td>
                                                        		<td>
                                                        			<a class="btn btn-primary dark" href="SizeServlet?action=des&pid=<%= c.getProductID() %>&size=<%= c.getSize() %>" role="button">-</a>
                                                        			<%= c.getSize() %>
                                                        			<a class="btn btn-primary dark" href="SizeServlet?action=ins&pid=<%= c.getProductID() %>&size=<%= c.getSize() %>" role="button">+</a>
                                                        		</td>
                                                        		<td class="product_total">$<%= c.getSubTotal() %></td>
                                                    		</tr>                     			
                                                	<% 	
                                                	 	
                                                	}
                                                	}
                                                %>
                                                </tbody>
                                            </table> 
                                                </div>      
                                            </div>
                                         </div>
                                     </div>
                                     <!--coupon code area start-->
                                    <div class="coupon_area">
                                        <div class="row">
                                            <div class="col-lg-6 col-md-6">
                                               
                                                
                                            </div>
                                            <div class="col-lg-6 col-md-6">
                                                <div class="coupon_code">
                                                    <h3>Cart Totals</h3>
                                                    <div class="coupon_inner">
                                                    <%
                                                    if(cart_list != null){
                                                    	cartDAO dao = new cartDAO();
                                                    	double payment = dao.getTotalPayment(cart_list);
                                                    	double paymentVAT = dao.getPaymentVAT(payment);
                                                    	double total =  dao.getTotalPaymentAndVAT(payment,paymentVAT);
                                                    	request.setAttribute("total", payment);
                                                    	request.setAttribute("VAT", paymentVAT);
                                                    	request.setAttribute("totalPayment", total);
                                                    }
                                                    %>
                                                       <div class="cart_subtotal">
                                                           <p> Total Payment</p>
                                                           <p class="cart_amount">$${total }</p>
                                                       </div>
                                                    <div class="cart_subtotal ">
                                                           <p>VAT Fee</p>
                                                           <p class="cart_amount"><span>10%</span>$${VAT}</p>
                                                       </div>
                                                       <a href="#">Calculating</a>

                                                       <div class="cart_subtotal">
                                                           <p>Total</p>
                                                           <p class="cart_amount">$${totalPayment }</p>
                                                       </div>
                                                       		<div class="login_submit">
                                                      			<button type="submit">Processing Order</button>
                                                   			</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                      
                                    </div>
                                    
                                    <!--coupon code area end-->
                                </form> 
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
