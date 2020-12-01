/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `publisher` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`address` varchar (765),
	`name` varchar (765),
	`phone` varchar (765),
	`url` varchar (765)
); 
insert into `publisher` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `name`, `phone`, `url`) values('1',NULL,NULL,NULL,NULL,'Jakarta','Rifki Foundation','099587877','www.foundation.com');
insert into `publisher` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `name`, `phone`, `url`) values('2',NULL,NULL,NULL,NULL,'Jakarta','Nadia Novel','0322212','www.novel.com');
