/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `customers` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`address` varchar (765),
	`email` varchar (765),
	`name` varchar (765),
	`phone` varchar (765)
); 
insert into `customers` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `email`, `name`, `phone`) values('1',NULL,NULL,NULL,NULL,'Jakarta','kiki@g.com','kiki','099877');
insert into `customers` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `email`, `name`, `phone`) values('2',NULL,NULL,NULL,NULL,'Bandung','dia@g.com','Dia','099874537');
