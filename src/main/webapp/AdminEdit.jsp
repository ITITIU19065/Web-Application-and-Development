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
                                            <li><a href="AdminIndex.jsp">Admin Home Page</a></li>
                                            <li><i class="fa fa-angle-right"></i></li>
                                            <li>Edit Page</li>
                                        </ul>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--breadcrumbs area end-->

                         <!--shopping cart area start -->
                      	
                      	<div class="customer_login">
                            <div class="row">
                                       <!--login area start-->
                                        <div class="col-lg-6 col-md-6">
                                            <div class="account_form">
                                                <form action="SelectAndShow" method="POST">
                                                	<p>   
                                                        <label>Select to Show  <span>*</span></label>
                                                     
                                                     </p>
                                                    <p>   
                                                        <select name="select">
                                                        	<option value="1">Oldest Product</option>
                                                        	<option value="2">Newest Product</option>
                                                        </select>
                                                     </p>  
                                                    <div class="login_submit">
                                                        <button type="submit">Select and Show</button>
                                                    </div>
                                                </form>
                                             </div>    
                                        </div>
                                        <!--login area start-->

                                        <!--register area start-->
                                        <div class="col-lg-6 col-md-6">
                                            <div class="account_form register">
                                                <form action="SelectCategory" method="POST">
                                                    <p>   
                                                        <label>Select Category to Show <span>*</span></label>
                                                     </p>
													<select name="selectCate">
													<% 
                                                     	categoryDAO dao = new categoryDAO();
                                                     	List<Category> category = dao.getAllCategory();
                                                     	for(Category c:category){ %>
                                                     		<option value="<%= c.getCateID() %>"><%= c.getCateName() %></option>
                                                     <%	}
                                                     %>
														
													</select>
                                                    <div class="login_submit">
                                                        <button type="submit">Select and Show</button>
                                                    </div>
                                                </form>
                                                <form method="POST" action="SelectBrand">
                                                	<p>   
                                                        <label>Select Brand to Show <span>*</span></label>
                                                     </p>
                                                     <select name="selectBrand">
                                                     <% 
                                                     	brandDAO daoB = new brandDAO();
                                                     	List<Brand> brand = daoB.getAllBrand();
                                                     	for(Brand b:brand){ %>
                                                     		<option value="<%= b.getBrandID() %>"><%= b.getBrandName() %></option>
                                                     <%	}
                                                     %>
                                                     </select>
                                                     <div class="login_submit">
                                                        <button type="submit">Select and Show</button>
                                                    </div>
                                                </form>
                                            </div>    
                                        </div>
                                        <!--register area end-->
                                    </div>
                                   
                                    <!--register area end-->
                            </div>
                      	
                      	
                                        
                        <div class="shopping_cart_area">
                        
                               <form action="#"> 
                                    <div class="row">
                                        <div class="col-12">
                                            <div class="table_desc wishlist">
                                                <div class="cart_page table-responsive">
                                                    <table>
                                                        <thead>
                                                            <tr>
                                                                <th class="product_remove">Delete</th>
                                                                <th class="product_name">Product ID</th>
                                                                <th class="product_thumb">Image</th>
                                                                <th class="product_name">Product</th>
                                                                <th class="product_name">Brand</th>
                                                                <th class="product_name">Category</th>
                                                                <th class="product-price">Price</th>
                                                                <th class="product_quantity">Discount</th>
                                                                <th class="product_total">Quantity Instock</th>
                                                                <th class="product_total">Decription</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        	<c:forEach items="${listC }" var="l">
                                                        			 <tr>
                                                               			<td class="product_remove"><a href="DeleteProduct?pid=${ l.productID }">X</a></td>
                                                                		<td class="product-price">${l.productID }</td>
                                                                		<td class="product_thumb"><img src="${l.image }" alt=""></td>
                                                                		<td class="product-price">${l.productName }</td>
                                                                		<td class="product-price">${l.brandName }</td>
                                                                		<td class="product-price">${l.categoryName }</td>
                                                                		<td class="product-price">$${l.price }</td>
                                                                		<td class="product-price">${l.discount }%</td>
                                                                		<td class="product-price">${l.quantity }</td>
                                                                		<td class="product-price">${l.desciption }</td>
                                                            		</tr>
                                                        	</c:forEach>
                                                           
                                                        </tbody>
                                                    </table>   
                                                </div>  

                                            </div>
                                         </div>
                                     </div>

                                </form> 
                                <div class="customer_login">
                            <div class="row">
                                       <!--login area start-->
                                        <div class="col-lg-6 col-md-6">
                                            <div class="account_form">
                                                <h2>Edit Product By Id</h2>
                                                <form action="EditProduct" method="POST">
                                                	<p>   
                                                        <label>Select Product Id to Edit <span>*</span></label>
                                                     </p>
                                                    <select name="pid">
                                                    
                                                    	<%
                                                    		productDAO daoP = new productDAO();
                                                    		List<Product> listP = daoP.getAllProductID();
                                                    		for(Product p:listP){ %>
                                                    			<option value="<%= p.getProductID() %>"><%= p.getProductID() %></option>
                                                    	<%	}
                                                    	%>
                                                    </select>
                                                    <p>   
                                                        <label>Select Brand <span>*</span></label>
                                                     </p>
                                                     <select name="EditBrand">
                                                     <% 
                                                     	for(Brand b:brand){ %>
                                                     		<option value="<%= b.getBrandID() %>"><%= b.getBrandName() %></option>
                                                     <%	}
                                                     %>
                                                     </select>
                                                     <p>   
                                                        <label>Select Category <span>*</span></label>
                                                     </p>
                                                     <select name="EditCate">
													<% 
                                                     	for(Category c:category){ %>
                                                     		<option value="<%= c.getCateID() %>"><%= c.getCateName() %></option>
                                                     <%	}
                                                     %>
                                                     </select>
                                                     <p>   
                                                        <label>Status <span>*</span></label>
                                                     </p>
                                                     <select name="EditActive">
                                                     	<option value="1">Active</option>
                                                     	<option value="0">No Active</option>
                                                     </select>
                                                     <p>   
                                                        <label>Product Name<span>*</span></label>
                                                        <input type="text" name="EName">
                                                     </p>
                                                     <p>   
                                                        <label>Product Price<span>*</span></label>
                                                        <input type="text" name="EPrice">
                                                     </p>
                                                     <p>   
                                                        <label>Product Discount<span>*</span></label>
                                                        <input type="text" name="EDis">
                                                     </p><p>   
                                                        <label>Product Quantity<span>*</span></label>
                                                        <input type="text" name="EQuan">
                                                     </p>
                                                     <p>   
                                                        <label>Product Image<span>*</span></label>
                                                        <input type="text" name="EImg">
                                                     </p>
                                                     <p>   
                                                        <label>Product Description<span>*</span></label>
                                                        <input type="text" name="EDes">
                                                     </p>
                                                     <%
                                                     	String message = (String) session.getAttribute("Update");
                                                     	if("failed".equals(message)){ %>
                                                     		<p style="color:red">Failed update new product</p>
                                                     <%	}
                                                     %>
                                                     <%
                                                     	if("successfully".equals(message)){ %>
                                                     		<p style="color:red">Successfully update new product</p>
                                                     <%	}
                                                     %>
                                                    <div class="login_submit">
                                                        <button type="submit">Update product</button>
                                                    </div>

                                                </form>
                                             </div>    
                                        </div>
                                        <!--login area start-->  
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
