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
        <title>Coron - Fashion eCommerce Bootstrap4 Template</title>
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
					
					
                        <!--pos home section-->
                        <div class="pos_home_section">
                            <div class="row">
                               <!--banner slider start-->
                                <div class="col-12">
                                    <div class="banner_slider slider_two">
                                        <div class="slider_active owl-carousel">
                                            <div class="single_slider" style="background-image: url(assets/img/slider/slider_2.png)">
                                                <div class="slider_content">
                                                    <div class="slider_content_inner">  
                                                        <h1>Wellcome to Admin Home Page</h1>
                                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br> Cumque eligendi quia, ratione porro, nemo non.</p>
                                                        
                                                    </div>     
                                                </div>
                                            </div>
                                            <div class="single_slider" style="background-image: url(assets/img/slider/slide_4.png)">
                                                 <div class="slider_content">
                                                    <div class="slider_content_inner">  
                                                        <h1>Clothing fashion for you</h1>
                                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br> Cumque eligendi quia, ratione porro, nemo non.</p>
                                                        
                                                    </div>     
                                                </div> 
                                            </div>
                                            <div class="single_slider" style="background-image: url(assets/img/slider/slider_3.png)">
                                                 <div class="slider_content">
                                                    <div class="slider_content_inner">  
                                                        <h1>fashion for you</h1>
                                                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. <br> Cumque eligendi quia, ratione porro, nemo non.</p>
                                                        
                                                    </div>     
                                                </div>
                                            </div>
                                        </div>
                                    </div> 
                                    <!--banner slider start-->
                                </div>    
                            </div>  
                             
                                   
                            
                                                          
                            
                     <!-- customer login start -->
                        <div class="customer_login">
                            <div class="row">
                                       <!--login area start-->
                                        <div class="col-lg-6 col-md-6">
                                            <div class="account_form">
                                                <h2>Insert New Product</h2>
                                                <form action="InsertProduct" method="POST">
                                                	<%
                                                		productDAO dao = new productDAO();
                                                       	categoryDAO cateDao = new categoryDAO();
                                                        brandDAO brandDao = new brandDAO();
                                                        int newestID = dao.getNewestIdProduct();
                                                	%>
                                                	<p>   
                                                        <label>New Product Id:<span> <%= newestID %> </span></label>
                                                     </p>
                                                    
                                                	<p>
                                                		<label>Category <span>*</span></label>
                                                     	<select name="cate">
                                                     	<%
                                                    	List<Category> listCate = cateDao.getAllCategory();
                                                    	if(!listCate.isEmpty()){ 
                                                    		for(Category c:listCate){ %>
                                                    			<option value="<%= c.getCateID() %>"><%= c.getCateName() %></option>
                                                    	<%	}
                                                    	}
                                                    	%>
                                                     	</select>
                                                	</p>
                                                	<p>
                                                		<label>Brand <span>*</span></label>
                                                     	<select name="brand">
                                                     		<%
                                                     			List<Brand> listBrand = brandDao.getAllBrand();
                                                     			if(!listBrand.isEmpty()){
                                                     				for(Brand b:listBrand){ %>
                                                     					<option value="<%= b.getBrandID() %>"><%= b.getBrandName() %></option>
                                                     		<%		}
                                                     			}
                                                     		%>
                                                     	</select>
                                                	</p>
                                                	<p>
                                                		<label>Status <span>*</span></label>
                                                     	<select name="status">
                                                     		<option value="1">Active</option>
                                                     		<option value="0">Not Active</option>
                                                     	</select>
                                                	</p>
                                                    <p>   
                                                        <label>Product Name<span>*</span></label>
                                                        <input type="text" name="name" >
                                                     </p>
                                                     
                                                     <p>   
                                                        <label>Image <span>*</span></label>
                                                        <input type="text" name="img">
                                                     </p>   
                                                     <p>   
                                                        <label>Price <span>*</span></label>
                                                        <input type="text" name="price">
                                                     </p>  
                                                     <p>   
                                                        <label>Discount <span>*</span></label>
                                                        <input type="text" name="discount">
                                                     </p>  
                                                     <p>   
                                                        <label>Description <span>*</span></label>
                                                        <input type="text" name="description">
                                                     </p>  
                                                     <p>   
                                                        <label>Quantity Instock <span>*</span></label>
                                                        <input type="text" name="quantity">
                                                     </p>
                                                     <% 
                                                     	String message = (String) session.getAttribute("message");
                                                     	if("empty".equals(message)){ %>
                                                     		<p style="color:red">Please, input all fields</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("failed".equals(message)){ %>
                                                     		<p style="color:red">Failed input new product</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(message)){ %>
                                                     		<p style="color:red">Successfully input new product</p>
                                                     <%	}
                                                     %>
                                                    <div class="login_submit">
                                                        <button type="submit">Insert</button>
                                                        
                                                    </div>

                                                </form>
                                             </div>    
                                        </div>
                                        <!--login area start-->

                                        <!--register area start-->
                                        <div class="col-lg-6 col-md-6">
                                            <div class="account_form register">
                                                <h2>Insert New Brand</h2>
                                                <form action="InsertBrand" method="POST">
                                                    <p>   
                                                        <label>New Brand Name  <span>*</span></label>
                                                        <input type="text" name="brand">
                                                     </p>
                                                     <% 
                                                     	String checkingBrand = (String) session.getAttribute("checkingBrand");
                                                     	if("empty".equals(checkingBrand)){ %>
                                                     		<p style="color:red">Please, input all fields</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("failed".equals(checkingBrand)){ %>
                                                     		<p style="color:red">Failed input new brand</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(checkingBrand)){ %>
                                                     		<p style="color:red">Successfully input new brand</p>
                                                     <%	}
                                                     %>
                                                    <div class="login_submit">
                                                        <button type="submit">Insert</button>
                                                    </div>
                                                </form>
                                                <form action="DeleteBrand" method="POST">
                                                	<p>   
                                                        <label>Select Brand Name to Delete  <span>*</span></label>
                                                      	<select name="brandDel">
                                                     		<%
                                                     			if(!listBrand.isEmpty()){
                                                     				for(Brand b:listBrand){ %>
                                                     					<option value="<%= b.getBrandID() %>"><%= b.getBrandName() %></option>
                                                     		<%		}
                                                     			}
                                                     		%>
                                                     	</select>
                                                     </p>
                                                    <%
                                                    	String checkingB =(String) session.getAttribute("checkingB");
                                                     	if("failed".equals(checkingB)){ %>
                                                     		<p style="color:red">Failed Detele Brand</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(checkingB)){ %>
                                                     		<p style="color:red">Successfully Detele Brand</p>
                                                     <%	}
                                                     %>
                                                     <div class="login_submit">
                                                        <button type="submit">Delete</button>
                                                    </div>
                                                </form>
                                            </div> 
                                            <div class="account_form register">
                                                <h2>Insert New Category</h2>
                                                <form action="InsertCategory" method="POST">
                                                    <p>   
                                                        <label>Category Name <span>*</span></label>
                                                        <input type="text" name="cate">
                                                     </p>
                                                     <% 
                                                     	String checkingCate = (String) session.getAttribute("checkingCate");
                                                     	if("empty".equals(checkingCate)){ %>
                                                     		<p style="color:red">Please, input all fields</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("failed".equals(checkingCate)){ %>
                                                     		<p style="color:red">Failed input new category</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(checkingCate)){ %>
                                                     		<p style="color:red">Successfully input new category</p>
                                                     <%	}
                                                     %>
                                                    <div class="login_submit">
                                                        <button type="submit">Insert</button>
                                                    </div>
                                                </form>
                                                
                                                <form action="DeleteCategory" method="POST">
                                                	<p>
                                                		<label>Select Category Name to Delete <span>*</span></label>
                                                		<select name="CateDel">
                                                			<%
                                                    	if(!listCate.isEmpty()){ 
                                                    		for(Category c:listCate){ %>
                                                    			<option value="<%= c.getCateID() %>"><%= c.getCateName() %></option>
                                                    	<%	}
                                                    	}
                                                    	%>
                                                		</select>
                                                	</p>
                                                	<%
                                                    	String checkingC =(String) session.getAttribute("checkingC");
                                                     	if("failed".equals(checkingC)){ %>
                                                     		<p style="color:red">Failed Delete Category</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(checkingC)){ %>
                                                     		<p style="color:red">Successfully Delete Category</p>
                                                     <%	}
                                                     %>
                                                	<div class="login_submit">
                                                        <button type="submit">Delete</button>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="account_form register">
                                                <h2>Insert New Sercurity Question</h2>
                                                <form action="InsertQuestion" method="POST">
                                                    <p>   
                                                        <label>Sercurity Question  <span>*</span></label>
                                                        <input type="text" name="question">
                                                     </p>
                                                   	<% 
                                                     	String checkingQ = (String) session.getAttribute("checkingQ");
                                                     	if("empty".equals(checkingQ)){ %>
                                                     		<p style="color:red">Please, input all fields</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("failed".equals(checkingQ)){ %>
                                                     		<p style="color:red">Failed input new question</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(checkingQ)){ %>
                                                     		<p style="color:red">Successfully input new question</p>
                                                     <%	}
                                                     %>
                                                    <div class="login_submit">
                                                        <button type="submit">Insert</button>
                                                    </div>
                                                </form>
                                                <form action="DeteleSercurity" method="POST">
                                                	<p>   
                                                        <label>Select Sercurity Question to Delete <span>*</span></label>
                                                        <select name="sercurityDel">
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
                                                     <%
                                                    	String checkingQs =(String) session.getAttribute("checkingQs");
                                                     	if("failed".equals(checkingQs)){ %>
                                                     		<p style="color:red">Failed Delete Sercurity Question</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(checkingQs)){ %>
                                                     		<p style="color:red">Successfully Delete Sercurity Question</p>
                                                     <%	}
                                                     %>
                                                     <div class="login_submit">
                                                        <button type="submit">Detele</button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <!--register area end-->
                                    </div>
                               <!--register area end-->
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
