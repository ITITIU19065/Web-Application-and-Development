# Web-Application-and-Development

CHAPTER 4: - SYSTEM IMPLEMENTATION<br/>
    &emsp;4.1: Configure database connection: <br/>
        &emsp;&emsp;- fisrt, open the package context<br/>
        &emsp;&emsp;- second, change the username and password before run the project is neccessary. NOTE: Using the default username and password of yor WorkBrench IDE <br/>
        ![image](https://user-images.githubusercontent.com/94380995/172983335-53be9511-9ad7-4e92-8eb1-0093f830b261.png)<br/><br/>
    &emsp; 4.2:  Add run mySQL file to add data<br/>
        &emsp;&emsp; - first, open the package DB_MYSQL, then run the this file in MYSQL workbench to get all neccessary date for project.<br/>
        ![image](https://user-images.githubusercontent.com/94380995/172984921-11d6cc30-a4ae-4dd2-9079-013a5ca8845b.png)<br/><br/>
    &emsp; 4.3: Run the project:<br/>
        ![image](https://user-images.githubusercontent.com/94380995/172985173-44d4d2cd-3631-4b77-8717-02ac93bc0e2c.png)<br/>
        &emsp;&emsp;; - Choose server Tomcat to run projet
        ![image](https://user-images.githubusercontent.com/94380995/172985267-acfae45d-2809-4f53-b33f-2e52419fd67a.png)<br/><br/>
    &emsp; 4.4: Login Page<br/>
        &emsp;&emsp; - after run project, the login page will appeare to requirt the user login before go to index page of website.<br/>
        ![image](https://user-images.githubusercontent.com/94380995/172986125-010066c3-88f6-4d27-b73f-cc8e8b53fdb6.png)<br/>
        &emsp;&emsp; 4.4.1: Register new account.<br/>
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
        &emsp;&emsp; 4.4.2: Login by new account.<br/>
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
        &emsp;&emsp; 4.9.1: insert brand product<br/>
        &emsp;&emsp;&emsp; in insert new brand box, admin have to input new brand name to insert. similar with deleting brand, admin need to select name of brand to delete.<br/>
        ![image](https://user-images.githubusercontent.com/94380995/173021915-93ee9bee-5efe-4cca-8abd-7efd830af83b.png)<br/>
         &emsp;&emsp;&emsp; the system will notificate for admin if deletion or insertion are successfully.<br/>
         ![image](https://user-images.githubusercontent.com/94380995/173022043-564b838e-4a2f-45b5-b95d-c8e2f18ece34.png)<br/>


            









    

    







       