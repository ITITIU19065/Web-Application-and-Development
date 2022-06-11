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
        <title>Coron-my account</title>
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
                        
                         <!--breadcrumbs area start-->
                        <div class="breadcrumbs_area">
                            <div class="row">
                                <div class="col-12">
                                    <div class="breadcrumb_content">
                                        <ul>
                                            <li><a href="index.jsp">home</a></li>
                                            <li><i class="fa fa-angle-right"></i></li>
                                            <li>my account</li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--breadcrumbs area end-->

                        <!-- Start Maincontent  -->
                        <section class="main_content_area">
                                <div class="account_dashboard">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-3 col-lg-3">
                                            <!-- Nav tabs -->
                                            <div class="dashboard_tab_button">
                                                <ul role="tablist" class="nav flex-column dashboard-list">
                                                    <li> <a href="#orders" data-toggle="tab" class="nav-link">Orders</a></li>
                                                  
                                                    <li><a href="#address" data-toggle="tab" class="nav-link">Account Detail</a></li>
                                                    <li><a href="#account-details" data-toggle="tab" class="nav-link">Update Account details</a></li>
                                                    <li><a href="LogOutServlet" class="nav-link">logout</a></li>
                                                </ul>
                                            </div>    
                                        </div>
                                        <div class="col-sm-12 col-md-9 col-lg-9">
                                            <!-- Tab panes -->
                                            <div class="tab-content dashboard_content">
                                              
                                                <div class="tab-pane fade" id="orders">
                                                    <h3>Orders</h3>
                                                    <div class="coron_table table-responsive">
                                                        <table class="table">
                                                            <thead>
                                                                <tr>
                                                                	<th>Order ID</th>
                                                                    <th>Name</th>
                                                                    <th>Date</th>
                                                                    <th>Payment Type</th>
                                                                   	<th>Phone</th>
                                                                    <th>Address,City</th>
                                              
                                                                   	<th>View Infor</th>
                                                                    <th>Cancel All Order</th>	 	 	 	
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                            <%
                                                            String Name = (String) session.getAttribute("user");
                                                         	userDAO daoUs = new userDAO();
                                                         	int ID = daoUs.getUserIdByName(Name);
                                                         	orderDAO oder = new orderDAO();
                                                         	List<OrderDetail> order = oder.getOrderByUserID(ID);
                                                         	cartDAO daoCart = new cartDAO();
                                                         	
                                                         	if(!order.isEmpty()){
                                                         		for(OrderDetail o:order){ %>
                                                         		<tr>
                                                         			<td><%= o.getOrderID() %></td>
                                                                    <td><%= o.getShippedFname() %> <%= o.getShippedLName() %></td>
                                                                    <td><%= o.getOrderCreated() %></td>
                                                                    <td><%= o.getPaymentType() %></td>
                                                                  	<td><%= o.getShippedPhone() %></td>
                                                                    <td><%= o.getShippedAddress() %>, <%= o.getShippedCity() %></td>
                                                                    <td><a href="ViewInfor?oid=<%= o.getOrderID() %>" class="view">View</a></td>
                                                                    <%
                                                                    	if(o.isShippedStatus() == false){ %>
                                                                    		<td><a href="CancelOrder?oid=<%= o.getOrderID() %>" class="view">Cancel</a></td>
                                                                    <%	}else{ %>
                                                                    		<td>Completed</td>
                                                                   	<% }
                                                                    %>
                                                                    
                                                                    
                                                                </tr>
                                                         	<%	}
                                                         		
                                                         	}
                                                            %>
                                                               
                                                                
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                               
                                                <div class="tab-pane" id="address">
                                                <h4 class="billing-address">Account Detail</h4>
                                                <%
                                                	String user = (String) session.getAttribute("user");
                                                    userDAO daoU = new userDAO();
                                                    int userId = daoU.getUserIdByName(user);
                                                    userDetailDAO dao = new userDetailDAO();
                                                    String result = dao.checkingEmptyDetailById(userId);
                                                   	session.setAttribute("result", result);
                                                   	if("empty".equals(result)){ %>
                                                   		<p style="color:red">Your Detail Account is empty, please fill your information</p>
                                                <%   	}%>
                                                   	
                                                 <%  if("valid".equals(result)){ 
                                                 	String userName = (String) session.getAttribute("user");
                                                 	userDAO daoUser = new userDAO();
                                                 	int userID = daoUser.getUserIdByName(userName);
                                                 	userDetailDAO userDetail = new userDetailDAO();
                                                 	UserDetail detail = userDetail.getDetailUser(userID);
                                             
                                                 %>
                                               
                                                    <p><strong>Name: <%= detail.getFirstName() %> <%= detail.getLastName() %></strong></p>
                                                    <address>
                                                        Phone: <%= detail.getPhone() %><br>
                                                        Age: <%= detail.getAge() %><br>
                                                        Gender: <%= detail.getGender() %> <br>
                                                        Address: <%= detail.getAddress() %><br>
                                                        City: <%= detail.getCity() %><br>
                                                    </address>
                                               <% }
                                                %>
                                                      
                                                </div>
                                                    
                                                <div class="tab-pane fade" id="account-details">
                                                    <h3>Update Account details </h3>
                                                    <div class="login">
                                                        <div class="login_form_container">
                                                            <div class="account_login_form">
                                                                <form action="UpdateAccountServlet" method="POST">
                                                                    <div class="input-radio">
                                                                        <span class="custom-radio"><input type="radio" value="Male" name="id_gender"> Male</span>
                                                                        <span class="custom-radio"><input type="radio" value="Female" name="id_gender"> Female</span>
                                                                        <span class="custom-radio"><input type="radio" value="Another" name="id_gender"> Another</span>
                                                                    </div> <br>
                                                                    <label>First Name</label>
                                                                    <input type="text" name="first-name">
                                                                    <label>Last Name</label>
                                                                    <input type="text" name="last-name">
                                                                    <label>Phone</label>
                                                                    <input type="text" name="phone">
                                                                    <label>Age</label>
                                                                    <input type="text" name="age">
                                                                    <label>Address</label>
                                                                    <input type="text" name="address">
                                                                    <label>City</label>
                                                                    <input type="text" name="city">
                                                                    <%
                                                                    	String message = (String) session.getAttribute("checkingAcc");
                                                                    	if("empty".equals(message)){ %>
                                                                    		<p style="color:red">Please, input all of fields above!</p>	
                                                                    <% 	}
                                                                     %>
                                                                    <%
                                                                    	if("successfully".equals(message)){ %>
                                                                    		<p style="color:red">Successfully updated information</p>	
                                                                    <%	}
                                                                    %>
                                                                    <%
                                                                    	if("failed".equals(message)){ %>
                                                                    		<p style="color:red">Failed updated information</p>	
                                                                    <%	}
                                                                    %>
                                                                    
                                                                    <div class="login_submit">
                                                        				<button type="submit">Update</button>
                                                     
                                                    				</div>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>      	
                        </section>			
                        <!-- End Maincontent  --> 
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
