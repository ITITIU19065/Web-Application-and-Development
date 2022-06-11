# Web-Application-and-Development
<h1 align="center">:blush: PROJECT REPORT :100:</h1>

<h2 align="center">Pos Coron- Ecommerce Shopping Web
</h2>

## Members:
- [Nguyen Ngoc Bao  - ITITIU19084](https://www.facebook.com/profile.php?id=100008043999306)
- [Hoang Tuan Kiet - ITITIU19065](https://www.facebook.com/tuankiet.hoang.718)
- [Nguyen Ha Minh Tri - ITITIU19057]()
## Contribute:
| Name | Job | Contribute |
| --- | --- | --- |
| Nguyen Ngoc Bao - ITITIU19084 | Back End,Report,Diagram,Front End | 55% |
| Hoang Tuan Kiet - ITITIU19065 | Front end,Report,Power Point,Diagram  | 40% |
| Nguyen Ha Minh Tri - ITITIU19057 | Some Database  | 5% |


## Table of Contents:
* [Chapter I:Introduction](#intro)
    * [1.1: Motivation](#1.1)
    * [1.2:	Problems Statement](#1.2)
    * [1.3: Scope](#1.3)
* [Chapter II: LITERATURE REVIEW](#II)
    * [2.1: Similar Applications / Systems:](#2.1)	
    * [2.2: Platform and Tools Review](#2.2)
* [Chapter III: SYSTEM DESIGN](#III)
    * [3.1.	System Requirement Specification](#3.1)
    * [3.2: Functional Requiremen](#3.2)
    * [3.3: Non-functional Requirements](#3.3)
        * [3.3.1: Product Requirements](#3.3.1)
        * [3.3.2: Organizational Requirements](#3.3.2)
    * [3.4: System Design Specification](#3.4)
        * [3.4.1: Use – Case Diagram](#3.4.1)
        * [3.4.2: Sequence Diagram](#3.4.2)
        * [3.4.3: Activity Diagram](#3.4.3)
        * [3.4.4: Entity – Relationship Diagram](#3.4.4)
        * [3.4.5: Database Relational Schema](#3.4.5)
        * [3.4.6: Class Diagram](#3.4.6)
* [Chapter IV: CHAPTER IV: - SYSTEM IMPLEMENTATION](#Chapter_IV)
    * [4.1: Configure database connection:](#4.1)
    * [4.2: Add run mySQL file to add data](#4.2)
    * [4.3: Run the project:](#4.3)
    * [4.4: Login Page](#4.4)
        * [4.5: Register new account](#4.4.1)
        * [4.6: Login by new account](#4.4.2)
* [Chapter V: References](#References)
    * [5.1: Database Diagram](#5.1)
    * [5.2: User Sequence Diagram](#5.2)
    * [5.3: Admin Sequence Diagram](#5.3)
    * [5.4: Class Diagram](#5.4)

<h2 id="intro">Chapter I: Introduction</h2>
    &emsp;<h3 id="1.1">1.1: Motivation</h3>
    &emsp;&emsp;<p>When deciding where to sell products online, many merchants choose between selling on a marketplace and creating their own website. While each option has its own set of pros and cons – and there is no one-size-fits-all solution that works perfectly for everyone – we believe businesses that are truly serious about ecommerce should have their own website.</p>

&emsp;&emsp;<p>
    Of course, marketplaces (like Amazon, Etsy, eBay, and Walmart Marketplace) can be great sales channels for many merchants, but there are plenty of limitations. And according to BigCommerce’s History of Ecommerce, customers will soon expect to be able to “research, browse, shop, and purchase seamlessly between different devices and on different platforms (like a standalone web store, an Amazon presence, etc.)” — a marketplace alone is not enough.
</p>

&emsp;<h3 id="1.2">1.2.	Problems Statement</h3>
Some of the problems that the team will likely encounter throughout the process of developing the project are:
- Every member is still extremely novice to Web Development.
- There is not much time since most member have multiple projects to work on during this semester.
- There may be difficulties in designing an attractive website.
- There may be difficulties in creating a fully functional website.
- There may be difficulties in connecting the database with the website.
- There may be difficulties in making a secure website.
- There may be difficulties in working on the project together since teamwork has never been easy.


&emsp;<h3 id="1.3">1.3:	Scope</h3>
During the project, some of the below issues may have higher chances to be resolved:
- Get more used to coding and designing web pages.
- Work together to create a decent looking website (e.g., a website that looks good enough, but not too spectacular).
- Finish some of the main functionalities of a basic website (e.g., Order, Get Payment, search for items, etc.).
- Try to understand each other and share the work logically.

<h2 id="II">Chapter II: LITERATURE REVIEW</h2>
&emsp;<h3 id="2.1">2.1.	Similar Applications / Systems:</h3>
There are obviously many websites that provides the same functionalities as our website, and most of them are better in multiple ways:

<h4><a href="https://shopee.vn/">Shoppe</a></h4>

Strengths:
- Users can login to an account.
- Users have their own account, which can connect to Facebook and Instagram.
- User can find the item via item categories.
- Users can find item via recommendation of “Most search for”.
- Users can download mobile app via QR code on the webpage.
- Users can view some discount packages for many kinds of item.
- Has detailed discount voucher for each item.
- Has many of hot deal.
- User can become a Shopee seller.
Weaknesses: 
- There are no significant weaknesses for this website.


<h4><a href=" https://tiki.vn/">Tiki</a></h4>

Strengths:
- This webpage has sufficient search bar.
- Has detailed discount voucher for each item.
- Has many of hot deal.
- Detailed homepage.
- Also contains recommendation for each items.
Weaknesses: 
- There are no significant weaknesses for this website.
	
<h4><a href="https://www.lazada.vn/">Lazada</a></h4>

Strengths:
- User can login to an account.
- Has a vertical search bar
Weaknesses:
- The design is not eye-catching.
- There are no significant weaknesses for this website.

<h4><a href="https://www.lazada.vn/">Sendo</a></h4>

Strengths:
- Has a sufficient search bar.
- Has a chat box for users.
- Has a list recommendation for each item.
- Also has discount voucher, but not too many.
- Weaknesses:
- The design is quite simplistic, but it is still nice to look at.
- There are no significant weaknesses for this website.

And many more…

&emsp;<h3 id="2.2">2.2: Platform and Tools Review</h3>

The programming languages used for this project are:
- Hyper Text Markup Language (HTML).
- Cascading Style Sheet (CSS).
- Structured Query Language (SQL).
- JavaServer Page (JSP) & Servlet
- JDBC (Java Database Connectivity)
- Tomcat 10
- Java
 
The libraries / platforms used for this project are:
- JSTL (Javs Standard Tag Library)
The tools used for this project are:
- Visual Studio Code.
- MySQL WorkBrench.
- Eclipse
Framework:
- BoostTrap


<h2 id="III">Chapter III: SYSTEM DESIGN</h2>
&emsp;<h3 id="3.1">3.1.	System Requirement Specification</h3>
List out all of the user’s requirement, which is also the system’s functionalities, in this section.

&emsp;<h3 id="3.2">3.2: Functional Requirement</h3>

<h5>Use Case 1: Register</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin and user to log into the system toper form many actions. | When someone attempts to use system functions. | Customer |  

Main Success Scenario :
- Customer click to the Login page
- Login interface is produced.
- Customer choose “Sign up” option
- Customer fill in email , password and some personal information
- Customer click “Sign up” button.
- System accept new user and add to database
- System displays “successfully sign-up” message.

Alternative Scenarios :
- Customer enter incorrect email:
    - System display message “Email is not exist, please enter again”
- Customer enter invalid or empty password
    - System display “Invalid password, please enter again”

<h5>Use Case 2: Login</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin and user to log into the system to perform many actions. | When someone attempts to use system functions. | Admin, customer |  

Main Success Scenario :
- User selects a login option.
- Login interface is produced.
- User enters password and username.
- System validates input against system database.
- System accepts user type.
- System displays “Successfully login” message.
- System automatically open home page


Alternative Scenarios :
- Either user name field of password field is empty or contain unaccepted characters. Error message display to verify input:

    - Let’s user to re-enter username/password.
    - Person use forgot password:
    - System asked user to recover password
    - User type new password and answer the security question.
    - System validates e-mail and display window for them to change their password and system update database if the answer is matched.
-	Username/Password invalid:
    - System notifies “invalid username/password”.
    - Let’s user to re-enter login information again.

<h5>Use Case 3: View profile</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to view their profile | When customer click on “View profile” | Customer |  

Main Success Scenario :
- Login the Customer account.
- On the header bar. Click on “User”.
- Customer click on “View profile”
- System displays customer profile page.
- Customer can choose option “Update information”, “Show information”, “View order detail

<h5>Use Case 4: Update information</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to edit information | When customer click on “View profile”, choose “Update information” | Customer |  

Main Success Scenario :
- Login the Customer account.
- On the header bar. Click on “View profile”.
- Customer clicks on “Update information”.
- Customer edit any information of user profile.
- Customer clicks on “Update”
- System accepts changes and update profile.


<h5>Use Case 5: View Order Detail</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to view order detail | When customer clicks on “View Profile” then click “View order detail” | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the header bar. Click on “View profile”.
-	Admin clicks on “View order detail”.
-	System displays the list of order that customer made.
-	System displays all detail information (date, category, payment..)

<h5>Use Case 6: View All Product</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer view all product of shop. | When customer registered and login into webpage and choose “View all product” | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “View all product”.
-	System display all type of product.

<h5>Use Case 7: Add product to Wish List</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to add item into wish list. | When customer choose item and click “Add to wish list” | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the webpage. Click on any item.
-	Click “add item to my wish list”.
-	System accepted to add item to wish list.
-	Customer click view wish list
-	System display all item added to wish list

Alternative Scenario :
- Customer click “Remove item from my wish list”.
- System remove item from wish list

<h5>Use Case 8: Add Product to Cart</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to add product into Cart | When customer select item and click “Add to Cart | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the webpage. Select any item.
-	Click “Add item to my cart”
-	System accepted to add item to the Cart
-	Customer click “View Cart”
-	System display a list of all item in Cart
-	Customer can choose the payment for all item or remove item from the cart


<h5>Use Case 9: Delete product in cart</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to add product into Cart | When customer select item and click “Add to Cart | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the webpage. Select any item.
-	Click “Add item to my cart”
-	System accepted to add item to the Cart
-	Customer click “View Cart”
-	System display a list of all item in Cart
-	Customer can choose the payment for all item or remove item from the cart

<h5>Use Case 10: Create Order</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to make order for products | When Customer clicks on “Cart” then click “order” | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the header bar. Click on “dashboard”.
-	Customer clicks on “Cart”.
-	Custom click select all item in Cart and click “Order”
-	System display cost and payment
-	System display message “Do you want to make order”
-	Customer choose “Yes” option
-	System automatically make an order, set date and asked for customer’s address.
-	Customer order can be view in “View order detail”

Alternative Scenario :
- If there is no item in Cart. System display “There’s no item in Cart, you cannot make an order”
- If customer choose “Cancel” system won’t make an order


<h5>Use Case 11: Cancel Order</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to cancel order | When Customer forgot password, click on “cancel” | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the header bar. Click on “dashboard”.
-	Customer clicks on “Cart”.
-	Custom click select all item in Cart and click “Order”
-	System display cost and payment
- 	System display message “Do you want to make order”
-	Customer choose “Yes” option
-	System automatically make an order, set date and asked for customer’s address.
-	Customer order can be view in “View order detail”

<h5>Use Case 12: Password recovery</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed customer to recover password | When Customer forgot password, click on “forgot password” | Customer |  

Main Success Scenario :
-	Login the Customer account.
-	On the header bar. Click on “dashboard”.
-	Customer clicks on “Cart”.
-	Custom click select all item in Cart and click “Order”
-	System display cost and payment
- 	System display message “Do you want to make order”
-	Customer choose “Yes” option
-	System automatically make an order, set date and asked for customer’s address.
-	Customer order can be view in “View order detail”


Alternative Scenario :
- If username is not correct. System display “Incorrect usename”
- If password is invalid or empty. System display notice.
- If the answer does not matched
- System display “Wrong answer. Try again”


<h5>Use Case 13: Admin Add product</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to add new product | When administrator clicks on “Manage product” click “add new product” | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage Product”.
-	System display add item page
-	Admin edit any information of the post.
-	Admin clicks “Add item”.
-	System accepted and save to the database

<h5>Use Case 14: Remove Product</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to remove item | When administrator clicks on “Manage Product” then click “remove item” | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage Product”.
-	System display add item page
-	Admin edit any information of the post.
-	Admin clicks “Add item”.
-	System accepted and save to the database

<h5>Use Case 15: Edit Product</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to edit new product | When administrator clicks on “Manage Product” then click “Edit product” | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage Product”.
-	Admin enters name/id of the product that need to be edited.
-	Admin edit information (brand, discount, price, status,..)
-	Admin click “Update product”
-	System accept and save changed into database.

<h5>Use Case 16: Show all product</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to show all product | When administrator clicks on “Manage Product then click “show all product” | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage Product”.
-	Admin clicks on “show all product”.
-	System display all type of product and information

<h5>Use Case 17: Search by Brand/Category</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to search item by brand/category | When administrator clicks on“Manage product” then click “search” bar | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Search product”.
-	Admin search brand/category of product on the search bar
-	System displays all product that matched brand/category


<h5>Use Case 19: Add new category</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to add new category | When administrator clicks on “Manage product” choose an item and edit its category | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage Product”.
-	Admin select an item.
-	Admin edit new categories
-	Admin click “Update product”
-	System accept and save into database


<h5>Use Case 20: Delete category</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to delete product categories | When administrator clicks on “Manage product” select a product and delete categories | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage Product”.
-	Admin select any product
-	Admin select any current category.
-	Admin select “delete”
-	System accept and remove out of database

<h5>Use Case 21: Add new brand</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to delete brand out of the shop. | When administrator select a brand and delete | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage Product”.
-	Admin search a brand on search bar
-	Admin select any existed brand.
-	Admin click “Delete brand”.
-	System displays successfully message and remove brand from database.


<h5>Use Case 22: Delete brand</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to add new brand to shop | When administrator clicks on “Manage VN Accommodations” then click “Add new brand” | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Add new brand”.
-	Admin enter new brand name
-	Admin clicks “Update Brand”.
-	System displays successfully updated message and save new brand to database


<h5>Use Case 23: Add new security question</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin add new security question | When administrator clicks on “Manage user”, choose “Security” , choose add new security question | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage User”.
-	Admin clicks on “Security”.
-	Admin enter new security question
-	Admin clicks on “add new security question”.
-	System accept and add new security question to database.

<h5>Use Case 24: Delete security question</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin delete a security question | When administrator clicks on “Manage user”, choose “Security” , choose a security question to delete | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage User”.
-	Admin clicks on “View customer order”.
-	Admin search a user on search bar and choose him/her
-	System display that customer information and all order that he/she made
-	Admin can check status of customer order.


<h5>Use Case 25: View all customer’s order</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to view customer’s order | When admin click “Manage user”, click “View customer’s order” | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage User”.
-	Admin clicks on “Security”.
-	Admin choose a current security question
-	Admin clicks “delete”.
-	System accept and remove security question out of database

<h5>Use Case 26: Delivery</h5>

| Aspect | Trigger | Actors |
| --- | --- | --- |
| System must be able allowed admin to manage order delivery | When user clicks on “Manage user” Choose delivery | Admin |  

Main Success Scenario :
-	Login the Admin account.
-	On the header bar. Click on “dashboard”.
-	Admin clicks on “Manage User”.
-	Admin clicks on “Delivery”.
-	System display all customer order status.
-	Admin click “Delivery”
-	System change order status to delived. And a shipper of shop will automatically get the order.


&emsp;<h3 id="3.3">3.3:	Non-functional Requirements</h3>
&emsp;&emsp;<h4 id="3.3.1">3.3.1: Product Requirements</h4>

| Usability Requirements | Efficiency Requirements | Performance Requirements |
| --- | --- | --- |
| The System shall include 2 types of accounts: Customer and Admin. If a password is forgotten by a system user, they have to recover password by answer security question. Interface action and elements should be consistent. The system should be implemented with simple HTML interfaces for it to be easy to understand and easy to learn. | The system should response to user actions within 20ms. The system should handle 100 users/second | Database processing time should not exceed 100ms. The system shall facilitate data integrity | 

&emsp;&emsp;<h4 id="3.3.2">3.3.2: Organizational Requirements</h4>
| Delivery Requirements | Implementation Requirements |
| --- | --- |
| The system shall be deployed within six months. The system shall be completed within the allocated budget. | The system should be implemented with HTML and CSS for interfaces, PHP for sever side scripting, JSP& Servlet, Tomcat for the validation and MYSQL for database management system. The environment that shall be hosting the system should contain minimum hardware requirements. The environmental that shall be hosting the system should contain minimum software requirements. (Windows 10) | 

&emsp;<h3 id="3.4">3.4:	System Design Specification</h3>
&emsp;&emsp;<h4 id="3.4.1">3.4.1: Use – Case Diagram</h4>

![image](https://user-images.githubusercontent.com/94380995/173072600-3561f55e-24ea-4bcf-b19f-ab128f7f9859.png)<br/>


&emsp;&emsp;<h4 id="3.4.2">3.4.2: Sequence Diagram</h4>
Login to an Account Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173073994-dbdedfcf-06a3-4810-844f-906624300077.png)<br/>

Register new account Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173088665-ea5c5890-f2d7-4db7-962b-16f996181d62.png)<br/>

Password Recovery Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173089482-60ea6676-c5f4-4730-9b18-9ec141f6149d.png)<br/>

Display index page Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173089679-45e86e54-457e-4139-a473-e1b41c3b7f85.png)


Search product Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173089802-2d535d5d-0fe1-4646-baab-c542cc41aa90.png)

View detail Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173089954-66d5d569-f4bd-484f-a260-7f406da58353.png)

Add product to wish list Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173090214-0e2ddab9-61e7-488e-aad3-b10b856ede05.png)

Add product to cart Sequence Diagram:

![image](https://user-images.githubusercontent.com/94380995/173090349-6736c8d0-df9c-4b1b-b52f-2625447b0819.png)

&emsp;&emsp;<h4 id="3.4.3">3.4.3: Activity Diagram</h4>
Customer register Activity Diagram:

![image](https://user-images.githubusercontent.com/94380995/173090788-411bb4fe-eefa-482e-a41f-51714e6fd5c6.png)


Customer Login Activity Diagram:

![image](https://user-images.githubusercontent.com/94380995/173091024-e4d3743b-8515-4ce1-8d66-6d92486426b8.png)

Password Recovery Activity Diagram:

![image](https://user-images.githubusercontent.com/94380995/173091163-d888e78a-a532-407b-b467-a186dad52765.png)

Admin add new item Activity Diagram:

![image](https://user-images.githubusercontent.com/94380995/173091274-3deac474-3aa1-4938-8aaa-2045ff1440a1.png)

&emsp;&emsp;<h4 id="3.4.4">3.4.4: Entity – Relationship Diagram</h4>

![Entity Diagram drawio](https://user-images.githubusercontent.com/94380995/173092487-e62ece4a-8087-4ea8-8975-72144d952e39.png)

&emsp;&emsp;<h4 id="3.4.5">3.4.5: Database Relational Schema</h4>

![image](https://user-images.githubusercontent.com/94380995/173092686-d4a82034-d63c-4544-8155-470fa630c2a2.png)

&emsp;&emsp;<h4 id="3.4.6">3.4.6: Class Diagram</h4>

![Class_Diagram drawio (1)](https://user-images.githubusercontent.com/94380995/173110287-15bc2ae5-aa6c-4033-9beb-bfba96a8b9fd.png)




<h2 id="Chapter_IV">CHAPTER IV: - SYSTEM IMPLEMENTATION</h2> <br/>
    &emsp;<h3 id="4.1">4.1: Configure database connection:</h3> <br/>
        &emsp;&emsp;- fisrt, open the package context<br/>
        &emsp;&emsp;- second, change the username and password before run the project is neccessary. NOTE: Using the default username and password of yor WorkBrench IDE <br/>

![image](https://user-images.githubusercontent.com/94380995/172983335-53be9511-9ad7-4e92-8eb1-0093f830b261.png)<br/><br/>
    &emsp; <h3 id="4.2">4.2:  Add run mySQL file to add data</h3><br/>
        &emsp;&emsp; - first, open the package DB_MYSQL, then run the this file in MYSQL workbench to get all neccessary date for project.<br/>

![image](https://user-images.githubusercontent.com/94380995/172984921-11d6cc30-a4ae-4dd2-9079-013a5ca8845b.png)<br/><br/>
    &emsp; <h3 id="4.3">4.3: Run the project:</h3><br/>
        
![image](https://user-images.githubusercontent.com/94380995/172985173-44d4d2cd-3631-4b77-8717-02ac93bc0e2c.png)<br/>
        &emsp;&emsp;; - Choose server Tomcat to run projet
                
![image](https://user-images.githubusercontent.com/94380995/172985267-acfae45d-2809-4f53-b33f-2e52419fd67a.png)<br/><br/>
    &emsp; <h3 id="4.4">4.4: Login Page</h3><br/>
        &emsp;&emsp; - after run project, the login page will appeare to requirt the user login before go to index page of website.<br/>
        
![image](https://user-images.githubusercontent.com/94380995/172986125-010066c3-88f6-4d27-b73f-cc8e8b53fdb6.png)<br/>
        &emsp;&emsp;<h3 id="4.4.1"> 4.4.1: Register new account.</h3><br/>
        &emsp;&emsp;&emsp; *Condition 1: if user does not input anything and click Register button. Website will send danger message for user to input all fields.<br/>
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172986746-49d802ec-ee5e-4e63-b95b-30326648aa64.png)<br/>
        &emsp;&emsp;&emsp; *Condition 2: if user choose exist account in database the website will send message for user choose another account.<br/>
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172986912-364839e2-a6af-4ead-b021-172a6206e397.png)<br/>
        &emsp;&emsp;&emsp; *Condition 3: if user's password and repassword does not match, the website will send message for user input passs again.<br/>
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172987222-a4fb03f3-b010-455e-974c-6a64bd073b69.png)<br/>
        &emsp;&emsp;&emsp; *Condition 4: if all fields which input by user is valid wesite all send the message for user"Successfully Register"<br/>
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172987501-42605bf1-2cd6-4a63-902a-29fe165f7813.png)<br>
        &emsp;&emsp;&emsp;Successfully Register:
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172987780-e17de458-a791-48f7-80a8-4c551f56e9c3.png)<br/><br/>
        &emsp;&emsp; <h3 id="4.4.2">4.4.2: Login by new account.</h3><br/>
        &emsp;&emsp;&emsp; *Condition 1: if user does not input anything and click Login button. Website will send danger message for user to input all fields.<br/>
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172987893-72c4f324-7b1c-40ef-9d70-3188bb8677f2.png)<br/>
        &emsp;&emsp;&emsp; *Condition 2: if all fields input by user is valid, the website send redirect to index Page of ecommerce shopping.<br/>
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172988164-b3f7ab2d-ad13-4b33-80cd-7bf0095c1609.png)<br/><br/>
    &emsp; 4.5: Index Home Page Of User<br/>
        
![image](https://user-images.githubusercontent.com/94380995/172990816-a6655496-cdd1-4170-8dda-1d2c10dcbd68.png)<br/>
        &emsp;&emsp; - In index home page of user, user can use all of function such as: 
        
&emsp;![image](https://user-images.githubusercontent.com/94380995/172989456-fbab2318-8c66-4dbb-91c1-641270112030.png)<br/>
            &emsp;&emsp;&emsp; + My WishList: wish list will store all product which user like in database and load it on the index page when user login. when user click Add Wish Button this product will be stored in database and display in wishList area or wishList Page<br/>
            &emsp;&emsp;&emsp; + My Acount: here store all information of user such as: oreders detail, prersonal address user for order, and user also update information at here.<br/>
            &emsp;&emsp;&emsp; + My Cart: all of product which user want to buy, will be store at here, and user can choose quantity size, and system will calucate subtotal, VAT and total payment for this order. But if user log out before complete the order, all of products in cart list will be deleted.<br/>
            &emsp;&emsp;&emsp; + log out and delete all product in cart list then send redirect to login page.<br/>
            &emsp;&emsp;&emsp; + search area: use can search product by name.<br/>
            &emsp;&emsp;&emsp; + search by category navbar: user can search by category name, brand name, and price.<br/>
            &emsp;&emsp; 4.5.1: Product Line:<br/>
            &emsp;&emsp;&emsp; - there are 3 line to dislay product: <br/>
            &emsp;&emsp;&emsp;&emsp; + Newest Product: this line will display newest product in system <br/>
            
&emsp;![image](https://user-images.githubusercontent.com/94380995/172990271-fe2ff0e8-9e56-4891-84f1-282becbac775.png)<br/>
            &emsp;&emsp;&emsp;&emsp; + All product: this line will show all product in system <br/>
            
&emsp;![image](https://user-images.githubusercontent.com/94380995/172990351-e6f1be98-fc8e-47b4-b627-d6a2e31bbf30.png)<br/>
            &emsp;&emsp;&emsp;&emsp; + Sale off Product: display all sale of product in system include discount percent, discout price and initial price. product at this line will be added "HOT" tag on image<br/>
            
&emsp;![image](https://user-images.githubusercontent.com/94380995/172990600-4cfb0804-a288-4d48-8b66-80dcb230c94a.png)<br/>
            &emsp; - all of div product tag have 3 buton: add to cart, add wishList, view detail.
        &emsp; 4.6: Add WishList button<br/>
            &emsp;&emsp; when User clip Add wish list button, it will call Addwish List Servlet to collect productID and add into database by userID. after that, list of wish List will be display in wishlist area or in WishList page. <br/>
            
&emsp;![image](https://user-images.githubusercontent.com/94380995/172991792-6e6bc0c4-d75e-474d-8557-72ad7b745723.png)<br/>
            &emsp;&emsp; - in wishlist page: there are 2 button: delete button to detele product from wishlist or add to cart button to add into cart list<br/>
            
![image](https://user-images.githubusercontent.com/94380995/172991948-a711e633-fa2c-4750-a0bc-2eb1fcf54a73.png)<br/>
            &emsp;&emsp; - if this product is already exist in wishlist the system will send message danger for user in wishlist page<br/>
            
&emsp;![image](https://user-images.githubusercontent.com/94380995/172993046-580a4a44-f763-4639-9583-15b6a80ee278.png)<br/>
        &emsp; 4.7: View Detail button<br/>
            &emsp;&emsp; when user click view detail button, the website will send redirect to Detail page. in there user can see all information of product such as: name, price, discount price, quantity remain instock, and there are 2 button add to cart and add to add to wish list. user can also order with mulpti quantity but it can not get over quantity in stock. if not the system will send danger message for user in cart.jsp page <br/>
            
&emsp;![image](https://user-images.githubusercontent.com/94380995/172992202-b66fa46c-67c2-4b95-b2b0-7cc45a0adcbe.png)<br/>

![image](https://user-images.githubusercontent.com/94380995/172992832-d180fce9-e472-46e3-8a10-d73ccfaad433.png)<br/>

![image](https://user-images.githubusercontent.com/94380995/172992869-92f340fd-15b2-4179-b217-5a73c4c98327.png)<br/>
        &emsp; 4.8: Add to Cart button<br/>
            &emsp;&emsp; when user click add to button product will be added into cart list. if product is already exist in cart, quantity of this product will increasing by 1. if user inceasing quantity over qunatity instock system will send message. or if user decreasing quantity equal zero, system will automically remove this product. system will auto calculate subtal, payment, and VAT fee for user <br/>
            
![image](https://user-images.githubusercontent.com/94380995/172994571-de4f34b1-a671-47a1-92a7-c0ff85f8fc24.png)<br/>
        &emsp; 4.8: Processing Order button<br/>
            &emsp;&emsp;when user click Processing Order, system will send redirect to checkOut.jsp and display all cart list include size of product. in this page there 2 option for user choose. create order with default address of account(if it null user need to update address for account, and system alse send message for user to know that) or user can choose shipped by another address <br/>

![image](https://user-images.githubusercontent.com/94380995/172997474-7d5ba2bb-28a2-496c-9a9f-d43f867f531c.png)<br/>
            
![image](https://user-images.githubusercontent.com/94380995/172997546-b0118ba4-5c6c-4a53-ae72-5f1e4a685ad2.png)<br/>
            &emsp;&emsp; if fault detail of account is not empty<br/>
            
![image](https://user-images.githubusercontent.com/94380995/172997710-3816e139-039e-47e5-9227-a89ecccb3b26.png)<br/>
            &emsp;&emsp; click Confirm Order to finish order.<br/>
         &emsp; 4.9: My Account Page<br/>
            &emsp;&emsp;in my acount page use can show all order, Account detail, or Update account di detail<br/>
            &emsp;&emsp;Before admin delivery user's order, user can Cancel order by click Cancel order(delete order from database). or user can view detail all of order <br/>
            
![image](https://user-images.githubusercontent.com/94380995/172998926-8c9d6ad5-c84c-4767-89b6-cb30e4b2baf0.png)<br/>
            &emsp;&emsp;user can view account detail and update profile<br/>
            
            
![image](https://user-images.githubusercontent.com/94380995/172999276-6a51ece4-78d1-4b03-866c-98272a99eb71.png)<br/>
            
![image](https://user-images.githubusercontent.com/94380995/172999337-5998e303-ba90-4979-95fb-8c935d515ef4.png)<br/>
        &emsp; 4.9: Admin Home Page<br/>
        &emsp;&emsp; after Admin login successfully by user name= "admin@admin" and password = "admin". System will redirect to AminIndex.jsp. in this page, Admin can insert new Product, new brand, new category and new sercurity. Also, deleting brand, category, sercurity question, by select option in select box.<br/>
        
![image](https://user-images.githubusercontent.com/94380995/173019516-9ec0c53f-4ae6-4e6f-87eb-ecff7d9fe35f.png)<br./>
        &emsp;&emsp; 4.9.1: insert new product<br/>
        &emsp;&emsp;&emsp; in insert new product box, the new id is calcuted automatically by system and display it at the first line.<br/>
         &emsp;&emsp;&emsp;&emsp;*Condition 1: if admin does not fill all fields in input from, system will notificate for admin by message<br/>
        
![image](https://user-images.githubusercontent.com/94380995/173020449-1a7fbc06-5f6e-4202-9f37-674c9a77e219.png)<br/>
          &emsp;&emsp;&emsp;&emsp;*Condition 2: if admin fill all fields and valid, system will add new product into dababase and display it on line new product, and system will display for admin by message "successfully insert new product"<br/>
![image](https://user-images.githubusercontent.com/94380995/173020875-c616adab-870b-4113-a97f-1b964da22f4d.png)<br/>
         
![image](https://user-images.githubusercontent.com/94380995/173023661-3e1c0190-71a4-420b-8a43-b92f9cecf655.png)<br/>
        &emsp;&emsp; 4.9.2: insert brand product<br/>
        &emsp;&emsp;&emsp; in insert new brand box, admin have to input new brand name to insert. similar with deleting brand, admin need to select name of brand to delete.<br/>

![image](https://user-images.githubusercontent.com/94380995/173021915-93ee9bee-5efe-4cca-8abd-7efd830af83b.png)<br/>
         &emsp;&emsp;&emsp; the system will notificate for admin if deletion or insertion are successfully.<br/>
         
![image](https://user-images.githubusercontent.com/94380995/173022043-564b838e-4a2f-45b5-b95d-c8e2f18ece34.png)<br/>
         &emsp;&emsp; 4.9.3: insert category product<br/>
        &emsp;&emsp;&emsp; in insert new category box, admin have to input new category name to insert. similar with deleting category, admin need to select name of category to delete.<br/>

![image](https://user-images.githubusercontent.com/94380995/173022714-7d19941c-fa0a-47ca-9dc1-fd7b4641f645.png)<br/>
         &emsp;&emsp;&emsp; the system will notificate for admin if deletion or insertion are successfully.<br/>

![image](https://user-images.githubusercontent.com/94380995/173022849-4e42fd9b-daad-42a4-9686-9183d4f9575b.png)<br/>
        &emsp;&emsp; 4.9.4: insert sercurity question<br/>
        &emsp;&emsp;&emsp; in insert new sercurity question box, admin have to input new sercurity question to insert. similar with deleting sercurity question, admin need to select sercurity question to delete.<br/>       
        
![image](https://user-images.githubusercontent.com/94380995/173023083-b29d9009-333f-4f2e-af14-5d005c3dcd6b.png)<br/>
         &emsp;&emsp;&emsp; the system will notificate for admin if deletion or insertion are successfully.<br/>
        
![image](https://user-images.githubusercontent.com/94380995/173023223-a969a644-c2b9-4e02-8fd5-8d6aab7731bf.png)<br/>
        &emsp;&emsp; 4.9.5:Edit product Page<br/>
        &emsp;&emsp;&emsp; At Edit produt page, admin can show product by category name, brand name, or show all newest and oldes product in system <br/>       
        
![image](https://user-images.githubusercontent.com/94380995/173024148-6e884485-0a96-4a6d-8f26-b5d34f452180.png)<br/>
         &emsp;&emsp;&emsp; to edit product, Admin need to select product id first. after that, filling all fields in edit box. and system will notification if it is successfully <br/>
        
![image](https://user-images.githubusercontent.com/94380995/173024895-90019f9c-684f-4985-beca-97f7276b003d.png)<br/>
        &emsp;&emsp; 4.9.6:Order Page<br/>
        &emsp;&emsp;&emsp; At Order page, admin can show all order of users in system.  <br/>       
        
![image](https://user-images.githubusercontent.com/94380995/173027156-89eeb60f-3d60-48c2-a789-711ad3dfd4b2.png)<br/>
         &emsp;&emsp;&emsp; if admin click delivery button, the system will set status of order by order Id and update it into database, and change the button delivery to "successfully status" <br/>
        
![image](https://user-images.githubusercontent.com/94380995/173027614-7312c3aa-8fa5-4c43-8273-a15a0797aec7.png)<br/>
         &emsp;&emsp;&emsp; system also change "Cancel " button on user side to "complete". it means the user can not cancel order if it is completed delivery <br/>
         
![image](https://user-images.githubusercontent.com/94380995/173028443-17df4ac7-327d-446f-96ea-3ac698dd7c00.png)<br/>

<h2 id="References">CHAPTER V: - References</h2> <br/>
&emsp;&emsp;<h4 id="5.1">5.1: Database Diagram</h4>
- <a href="https://drive.google.com/drive/folders/1z5RpyU-DXj6KJPEHa6Y50Q7O3w1UU878?usp=sharing">Database Diagram</a>

&emsp;&emsp;<h4 id="5.2">5.2: User Sequence Diagram</h4>
- <a href="https://drive.google.com/drive/folders/1CbqTtnJvTrAGwmIqPMYHL6jJPqOAXwWU?usp=sharing">User Sequence Diagram</a>

&emsp;&emsp;<h4 id="5.3">5.3: Admin Sequence Diagram</h4>
- <a href="https://drive.google.com/drive/folders/1KnS4l2iyG9bDyOSXrSTEKhpADcUosIqo?usp=sharing">Admin Sequence Diagram</a>

&emsp;&emsp;<h4 id="5.4">5.4: Class Diagram</h4>
- <a href="https://drive.google.com/drive/folders/1F3X8eE4ZBVhrwmIe9tjHthVqC_L5tne5?usp=sharing">5.4: Class Diagram</a>
            









    

    







       