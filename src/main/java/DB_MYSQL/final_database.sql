create database e_commerce_web;
use e_commerce_web;
create table Sercurity(
	questionID int not null auto_increment,
    question varchar(100),
    primary key (questionID)
);

create table User(
	userID int not null unique auto_increment,
    userName varchar(100) not null unique,
    userPass varchar(100) not null,
    primary key(userID)
);

create table UserDetail(
	userID int not null unique auto_increment ,
	firstName varchar(100),
    lastName varchar(100),
	phone varchar(15),
    age int,
    gender varchar(10),
    address varchar(100),
    city varchar(100),
	questionID int,
    answer varchar(100) not null,
    primary key (userID),
    foreign key (userID) references User(userID),
	foreign key (questionID) references Sercurity(questionID)
);
create table productCategory(
	cateID int not null unique auto_increment,
    cateName varchar(100) not null,
    primary key(cateID)
);

create table brand(
	brandID int not null unique auto_increment,
    brandName varchar(100) not null,
    primary key (brandID)
);

create table productDetail(
	productID int not null unique auto_increment,
    cateID int,
    brandId int,
    productName varchar(100) not null,
    status boolean default true,
    image varchar(100) not null,
    price double(10,2) not null,
    discount int,
    desciption varchar(500),
    quantity int not null,
    primary key (productID),
    foreign key (cateID) references productCategory(cateID),
    foreign key (brandId) references brand(brandId)
);


create table orders(
	orderID int not null unique auto_increment,
    userID int not null,
    stateOrder boolean default true,
    orderCreated date ,
    shippedStatus boolean default false,
    shippedAddress varchar(100),
    shippedCity varchar(100),
    shippedFirstName varchar(100),
    shippedLastName varchar(100),
    shippedPhone varchar(15),
    shippedNote varchar(500),
    paymentType varchar(30),
    primary key(orderID),
    foreign key (userID) references UserDetail(userID)
);
create table orderDetail(
	orderDetailID int not null unique auto_increment,
    orderID int not null,
    productID int not null,
    detailQuantity int,
    detailSize varchar(10),
    detailProductName varchar(100),
    detailPrice double (10,2),
    VAT int,
    shippedStatus boolean default false,
    primary key (orderDetailID),
    foreign key (orderID) references orders(orderID),
    foreign key (productID) references productDetail(productID)
);
create table wishList(
	wishId int not null unique auto_increment,
    productId int not null,
	userId int not null,
    foreign key (productID) references productDetail(productID)
);


insert into Sercurity(question)
value
('What is your dream job?'),
('What is your favorite fruits?'),
('What is your favorite number?'),
('What is frist pets');

insert into productCategory(cateName)
value 
('Dress'),
('Shoes'),
('T-shirt'),
('Pan');

insert into brand(brandName)
value
('Adidas'),
('Yame'),
('Channel'),
('Dior'),
('Louis Vuitton');
insert into productDetail
(cateID,brandId,productName,image,price,discount,desciption,quantity)
value
(1,3,'Spring Blue Dress','./assets/img/product/card1.png',120,20,'the fashion women chanel dress',20),
(3,1,'Sport T-shirt Men','./assets/img/product/card2.png',200,10,'the fashion men Yame cloth',10),
(3,1,'Sport T-shirt Men','./assets/img/product/product2.png',510,0,'the fashion men Yame cloth',10),
(1,5,'Autumn Dress Men','./assets/img/product/card3.png',400,0,'the fashion men Louis Vuitton dress for autumn',5),
(1,3,'Rose Dior Dress','./assets/img/product/card4.png',300,20,'the fashion women dior red dress for party or event',30),
(3,2,'Office T-Shirt','./assets/img/product/card5.png',520,20,'the fashion men Dior long sleeve shirts for working on office',4),
(2,4,'Sport Shoes','./assets/img/product/card10.png',400,0,'the sport shoes for men',2),
(2,4,'Air Force One','./assets/img/product/card14.png',90,0,'Fashion Shoes For Men',2),
(2,5,'Adidas Sport Shoes','./assets/img/product/card11.png',320,0,'the sport Adidas shoes for men',6),
(4,3,'Pan Men Office','./assets/img/product/card8.png',190,10,'The office pan for working',4),
(4,3,'Sport Pan For Women','./assets/img/product/product13.png',90,10,'The  pan for Sport',4),
(4,3,'Pan For Women','./assets/img/product/product8.png',90,10,'The  pan for Sport',4),
(1,5,'Office Women Suit','./assets/img/product/product14.png',560,10,'The office Suit for working',5),
(1,5,'Office Women Suit','./assets/img/product/product15.png',80,10,'The office Suit for Women',5);

SET FOREIGN_KEY_CHECKS = 1;