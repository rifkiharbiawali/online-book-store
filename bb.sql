/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `bb` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`count` varchar (765),
	`basket_id` bigint (20),
	`book_id` bigint (20)
); 
insert into `bb` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `count`, `basket_id`, `book_id`) values('1',NULL,NULL,NULL,NULL,'5','1','2');
insert into `bb` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `count`, `basket_id`, `book_id`) values('2',NULL,NULL,NULL,NULL,'3','2','1');
