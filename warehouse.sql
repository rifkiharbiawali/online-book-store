/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `warehouse` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`address` varchar (765),
	`phone` varchar (765)
); 
insert into `warehouse` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `phone`) values('1',NULL,NULL,NULL,NULL,'Jakarta','0210000');
insert into `warehouse` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `phone`) values('2',NULL,NULL,NULL,NULL,'Sukabumi','0210000');
