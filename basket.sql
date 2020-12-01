/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `basket` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`customer_id` bigint (20)
); 
insert into `basket` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `customer_id`) values('1',NULL,NULL,NULL,NULL,'1');
insert into `basket` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `customer_id`) values('2',NULL,NULL,NULL,NULL,'2');
