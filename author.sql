/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `authors` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`address` varchar (765),
	`name` varchar (765),
	`url` varchar (765)
); 
insert into `authors` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `name`, `url`) values('1',NULL,NULL,NULL,NULL,'Jakarta','Rifki','www.Rifki.com');
insert into `authors` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `address`, `name`, `url`) values('2',NULL,NULL,NULL,NULL,'Jakarta','Nadia','www.Nadia.com');
