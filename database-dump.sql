-- Table structure for table `categories`
-- create schema ecommerce char set utf8mb4 collate utf8mb4_0900_ai_ci;

-- drop schema ecommerce;

select * from products;

select * from order_item;

select * from cart;

drop table cart;

drop table orders;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
--
-- Table structure for table `products`
--
drop table if exists `child_categories`;
create table `child_categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(1000) DEFAULT NULL,
  `parent_id` bigint(20) not null,
  PRIMARY KEY (`id`),
  constraint `fk_child_categories` foreign key (`parent_id`) references `ecommerce`.`categories` (`id`)
);

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(1000) DEFAULT NULL,
  `imageurl` varchar(1000) DEFAULT NULL,
  `name` varchar(1000) DEFAULT NULL,
  `price` double NOT NULL,
  `category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  constraint `fk_products_child_categories` foreign key (`category_id`) references `ecommerce`.`child_categories` (`id`)
);


--
-- Dumping data for table `products`
--
--
-- Table structure for table `tokens`
--
drop table if exists `images`;
create table `images` (
`id` bigint(20) not null auto_increment,
`imageurl` varchar(1000) default null,
`product_id` bigint(20) not null,
primary key (`id`),
constraint `fk_product_image_product` foreign key (`product_id`) references `ecommerce`.`products` (`id`)
);

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tokens` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2dylsfo39lgjyqml2tbe0b0ss` (`user_id`)
);

--
-- Table structure for table `user_profile`
--
--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
--
-- Table structure for table `wishlist`
--

DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) default null,
  `last_name` varchar(255) default null,
  `phone` varchar(255) DEFAULT null,
  `address` varchar(255) DEFAULT null,
  `user_id` int(20) NOT NULL,
  PRIMARY KEY (`id`),
  constraint `fk_user_profile_users` foreign key (`user_id`) references `ecommerce`.`users` (`id`)
);

drop table if exists `cart`;
create table `cart` (
`id` bigint(20) not null auto_increment,
`created_date` datetime not null,
`product_id` bigint(20) not null,
`user_id` int(11) not null,
`quantity` int(10) not null,
primary key (`id`),
constraint `fk_cart_product` foreign key (`product_id`) references `ecommerce`.`products` (`id`),
constraint `fk_cart_user` foreign key (`user_id`) references `ecommerce`.`users` (`id`)
);

drop table if exists `orders`;
create table `orders` (
`id` bigint(20) not null auto_increment,
`total_price` double not null,
`status` varchar(255) not null,
`created_date` datetime not null,
`user_id` int(10) not null,
`shipping_info_id` bigint(20) not null,
primary key (`id`),
constraint `fk_orders_users` foreign key (`user_id`) references `ecommerce`.`users` (`id`),
constraint `fk_orders_shipping_info` foreign key (`shipping_info_id`) references `ecommerce`.`shipping_info` (`id`)
);

drop table if exists `order_item`;
create table `order_item` (
`id` bigint (20) not null auto_increment,
`quantity` int(10) not null,
`price` double not null,
`created_date` datetime not null,
`order_id` bigint(20) not null,
`product_id` bigint(20) not null,
primary key (`id`),
constraint `fk_orders_item_orders` foreign key (`order_id`) references `ecommerce`.`orders` (`id`),
constraint `fk_orders_item_products` foreign key (`product_id`) references `ecommerce`.`products` (`id`)
);

drop table if exists `shipping_info`;
create table `shipping_info` (
`id` bigint(20) not null auto_increment,
`full_name` varchar(255) not null,
`phone` varchar(255) not null,
`address` varchar(255) not null,
primary key (`id`)
);

DROP TABLE IF EXISTS `wishlist`;
CREATE TABLE `wishlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `created_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6p7qhvy1bfkri13u29x6pu8au` (`product_id`)
);

-- Dump completed on 2021-01-13  3:42:14
