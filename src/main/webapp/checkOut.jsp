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
        <title>Coron-checkout</title>
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
                                            <li>checkout</li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--breadcrumbs area end-->


                        <!--Checkout page section-->
                        <div class="Checkout_section">
                            <div class="row">
                                   <div class="col-12">
                                        
                                            
                                   </div>
                                </div>
                            <div class="checkout_form">
                                    <div class="row">
                                    		<%
                                    		String message = (String) session.getAttribute("message");
                                            	if("empty".equals(message)){ %>
                                            <div class="alert">
  												<span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
  												<strong>Danger!</strong> Your cart is empty
											</div>
                                            <% 	}
                                            	session.setAttribute("message", "");
                                            %>
                                        <div class="col-lg-6 col-md-6">
                                            
                                                <h3>Billing Details</h3>
                                                <div class="row">
													                                                <%
                                                	String user = (String) session.getAttribute("user");
                                                    userDAO daoU = new userDAO();
                                                    int userId = daoU.getUserIdByName(user);
                                                    userDetailDAO dao = new userDetailDAO();
                                                    String result = dao.checkingEmptyDetailById(userId);
                                                   	session.setAttribute("result", result);
                                                   	if("empty".equals(result)){ %>
                                                   	<div class="col-12 mb-30">
                                                   		<p style="color:red">Your Detail Account is empty, please fill your information</p>
                                                   </div>
                                                <%   	}%>
                                                    <%  if("valid".equals(result)){ 
                                                 	String userName = (String) session.getAttribute("user");
                                                 	userDAO daoUser = new userDAO();
                                                 	int userID = daoUser.getUserIdByName(userName);
                                                 	userDetailDAO userDetail = new userDetailDAO();
                                                 	UserDetail detail = userDetail.getDetailUser(userID);
                                             
                                                 %>
                                                 <div class="col-12 mb-30">
                                                 <form action="ConfirmDefault" method="POST">
                                                    <div class="col-12 mb-30">
                                                        <label>Customer Name: <%= detail.getFirstName() %> <%= detail.getLastName() %></label>           
                                                    </div>
                                                    <div class="col-12 mb-30">
                                                        <label for="country">City: <%= detail.getCity() %></label>
                                                    </div>

                                                    <div class="col-12 mb-30">
                                                        <label>Street address: <%= detail.getAddress() %></label>
                                                           
                                                    </div>
                                                    <div class="col-12 mb-30">
                                                        <label>Phone: <%= detail.getPhone() %></label>
                                                    </div>
                                                   <div class="col-12 mb-30">
                                                        <label>Payment Type</label>
                                                        <select name="type">
                                                        	<option value="Cash">Cash</option>
                                                        	<option value="Visa">Visa</option>
                                                        	<option value="Paypal">Paypal</option>
                                                        </select>
                                                    </div>
                                                    <div class="col-12">
                                                        <div class="order-notes">
                                                             <label for="order_note">Order Notes</label>
                                                            <textarea name="note" id="order_note" placeholder="Notes about your order, e.g. special notes for delivery."></textarea>
                                                        </div>    
                                                    </div>  
                                                    <div class="col-12 mb-30">
                                                    		<div class="login_submit">
                                                      			<button type="submit">Confirm Order</button>
                                                   			</div>
                                                    </div>
                                                   </form>
                                                   </div>
                                                    <%
                                                    }%>
                                                    
                                                    <div class="col-12 mb-30">
                                                        <input id="address" type="checkbox" data-target="createp_account">
                                                        <label class="righ_0" for="address" data-toggle="collapse" data-target="#collapsetwo" aria-controls="collapseOne">Ship to a different address?</label>

                                                        <div id="collapsetwo" class="collapse one" data-parent="#accordion">
                                                           <div class="row">
                                                           <div class="col-12 mb-30">
                                                           <form action="ConfirmAnother" method="POST">
                                                           
                                                                <div class="col-lg-12 mb-30">
                                                                    <label>First Name <span>*</span></label>
                                                                    <input type="text" name="fname">    
                                                                </div>
                                                                <div class="col-lg-12 mb-30">
                                                                    <label>Last Name  <span>*</span></label>
                                                                    <input type="text" name="lname"> 
                                                                </div>
                                                                <div class="col-12 mb-30">
                                                                    <label>Address</label>
                                                                    <input type="text" name="address">     
                                                                </div>
                                                                <div class="col-12 mb-30">
                                                                    <label>City</label>
                                                                    <input type="text" name=city>     
                                                                </div> 
                                                                <div class="col-lg-12 mb-30">
                                                                    <label>Phone<span>*</span></label>
                                                                    <input type="text" name="phone"> 

                                                                </div> 
                                                                <div class="col-12 mb-30">
                                                        			<label>Payment Type</label>
                                                        			<select name="type">
                                                        				<option value="Cash">Cash</option>
                                                        				<option value="Visa">Visa</option>
                                                        				<option value="Paypal">Paypal</option>
                                                        			</select>
                                                    			</div>
                                                                <div class="col-12">
                                                        <div class="order-notes">
                                                             <label for="order_note">Order Notes</label>
                                                            <textarea name="note" id="order_note" placeholder="Notes about your order, e.g. special notes for delivery."></textarea>
                                                        </div>    
                                                    </div>  
                                                                 <div class="col-12 mb-30">
                                                    				<div class="login_submit">
                                                      					<button type="submit">Confirm Order</button>
                                                   					</div>
                                                    			</div>
                                                            </form>
                                                            </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                      	    	    	    	    	    	    
                                                </div>
                                         
                                        </div>
                                        <div class="col-lg-6 col-md-6">
                                                
                                                <h3>Your order</h3> 
                                                <div class="order_table table-responsive mb-30">
                                                    <table>
                                                        <thead>
                                                            <tr>
                                                                <th>Product</th>
                                                                <th>Total</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        <%
                                                	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
                                                	List<Cart> cartProduct = null;
                                                	if(cart_list != null ){
                                                		cartDAO daoCart = new cartDAO();
                                                		cartProduct = daoCart.getCartProduct(cart_list);
                                                		request.setAttribute("cart_list", cart_list);
                                                	}
                                                	if(cart_list != null){
                                                		for(Cart c:cartProduct){ %>
                                                            <tr>
                                                                <td> <%= c.getProductName() %> <strong> x<%= c.getQuantityOrder() %> Size: <%= c.getSize() %></strong></td>
                                                                <td>$<%= c.getDisPrice() %></td>
                                                            </tr>
                                                     <%
                                                		}
                                                		} %>
                                                            
                                                            
                                                        </tbody>
                                                        <tfoot>
                                                        <%
                                                    if(cart_list != null){
                                                    	cartDAO daoCart = new cartDAO();
                                                    	double payment = daoCart.getTotalPayment(cart_list);
                                                    	double paymentVAT = daoCart.getPaymentVAT(payment);
                                                    	double total =  daoCart.getTotalPaymentAndVAT(payment,paymentVAT);
                                                    	request.setAttribute("total", payment);
                                                    	request.setAttribute("VAT", paymentVAT);
                                                    	request.setAttribute("totalPayment", total);
                                                    }
                                                    %>
                                                            <tr>
                                                                <th>Cart Subtotal</th>
                                                                <td>$${total }</td>
                                                            </tr>
                                                            <tr>
                                                                <th>10% VAT</th>
                                                                <td><strong>$${VAT}</strong></td>
                                                            </tr>
                                                            <tr class="order_total">
                                                                <th>Order Total</th>
                                                                <td><strong>$${totalPayment }</strong></td>
                                                            </tr>
                                                        </tfoot>
                                                    </table>     
                                                </div>
                                                   
                                        </div>
                                    </div> 
                                </div>        
                        </div>
                        <!--Checkout page section end-->

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
