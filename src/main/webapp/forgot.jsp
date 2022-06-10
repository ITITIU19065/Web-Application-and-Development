<%@page import="Context.*" %>
<%@page import="control.*" %>
<%@page import="DAO.*" %>
<%@page import="entity.*" %>
<%@page import="java.util.List" %>
<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Coron-login</title>
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
                       <!--header area -->
                        <%@ include file="./includes/headerLogin.jsp" %>
                         <!--breadcrumbs area start-->
                        <div class="breadcrumbs_area">
                            <div class="row">
                                    <div class="col-12">
                                        <div class="breadcrumb_content">
                                            <ul>
                                                <li><a href="login.jsp">login page</a></li>
                                                <li><i class="fa fa-angle-right"></i></li>
                                                <li>Forgot Page</li>
                                            </ul>

                                        </div>
                                    </div>
                                </div>
                        </div>
                        <!--breadcrumbs area end-->

                       <!-- customer login start -->
                        <div class="customer_login">
                            <div class="row">
                                   

                                        <!--register area start-->
                                        <div class="col-lg-6 col-md-6">
                                            <div class="account_form register">
                                                <h2>Forgot Password</h2>
                                                <form action="ForgortSerlet" method="POST">
                                                    <p>   
                                                        <label>Email address  <span>*</span></label>
                                                        <input type="text" name="userName">
                                                     </p>
                                                     <p>   
                                                        <label>New Passwords <span>*</span></label>
                                                        <input type="password" name="pass">
                                                     </p>
                                                     <p>   
                                                        <label>Confrim new Passwords <span>*</span></label>
                                                        <input type="password" name="rePass">
                                                     </p>
                                                     <p>
                                                     	<label>Sercurity Question <span>*</span></label>
                                                     	<select name="sercurity">
                                                     	<%
                                                     		sercurityDAO ser = new sercurityDAO();
                                                     		List<Sercurity> question = ser.getAllSercurity();
                                                     		if(!question.isEmpty()){
                                                     			for(Sercurity q:question){ %>
                                                     				<option value=<%= q.getQuestionId() %>><%= q.getQuestion() %></option>
                                                     		<%	}
                                                     		}
                                                     	%>
														</select>
                                                     </p>
                                                     <p>   
                                                        <label>Answer <span>*</span></label>
                                                        <input type="text" name="answer">
                                                     </p>
                                                     <% String checking = (String) session.getAttribute("forgotCheck"); 
                                                     	if("empty".equals(checking)){ %>
                                                     		<p style="color:red">Please, input all fields</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("invalid".equals(checking)){ %>
                                                     		<p style="color:red">Invalid Account</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("notMatch".equals(checking)){ %>
                                                     		<p style="color:red">The new Password is not match</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("wrong".equals(checking)){ %>
                                                     		<p style="color:red">The Sercurity Question and Answer is not corect</p>
                                                    <% 	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(checking)){ %>
                                                     		<p style="color:red">Successfully Change Password</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("failed".equals(checking)){ %>
                                                     		<p style="color:red">Failed Change Password</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("notExist".equals(checking)){ %>
                                                     		<p style="color:red">This account is not exist</p>
                                                     <%	}
                                                     %>
                                                    <div class="login_submit">
                                                        <button type="submit">Change Password</button>
                                                        <a href="login.jsp">Login Page</a>
                                                    </div>
                                                </form>
                                            </div>    
                                        </div>
                                        <!--register area end-->
                                        <div class="col-lg-6 col-md-6">
                                            <img alt="" src="./img/forgot/accessories-collection.png">    
                                        </div>
                                    </div>
                                </div>
                        </div>
                        <!-- customer login end -->

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
