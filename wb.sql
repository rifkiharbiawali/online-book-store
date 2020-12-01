/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `wb` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`count` varchar (765),
	`book_id` bigint (20),
	`warehouse_id` bigint (20)
); 
insert into `wb` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `count`, `book_id`, `warehouse_id`) values('1',NULL,NULL,NULL,NULL,'100','1','1');
insert into `wb` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `count`, `book_id`, `warehouse_id`) values('2',NULL,NULL,NULL,NULL,'50','2','1');
insert into `wb` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `count`, `book_id`, `warehouse_id`) values('3',NULL,NULL,NULL,NULL,'20','3','1');
insert into `wb` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `count`, `book_id`, `warehouse_id`) values('4',NULL,NULL,NULL,NULL,'200','4','2');
