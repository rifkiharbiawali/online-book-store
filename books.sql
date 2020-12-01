/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `books` (
	`id` bigint (20),
	`created` datetime ,
	`created_by` varchar (765),
	`last_modified` datetime ,
	`last_modified_by` varchar (765),
	`isbn` varchar (765),
	`price` double ,
	`title` varchar (765),
	`year` mediumint (9),
	`author_id` bigint (20),
	`publisher_id` bigint (20)
); 
insert into `books` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `isbn`, `price`, `title`, `year`, `author_id`, `publisher_id`) values('1',NULL,NULL,NULL,NULL,'2','10000','Menuju Sukses','202002','1','1');
insert into `books` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `isbn`, `price`, `title`, `year`, `author_id`, `publisher_id`) values('2',NULL,NULL,NULL,NULL,'1','50000','Menuju Puncak','201902','1','2');
insert into `books` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `isbn`, `price`, `title`, `year`, `author_id`, `publisher_id`) values('3',NULL,NULL,NULL,NULL,'4','50000','Si Dia','202002','2','2');
insert into `books` (`id`, `created`, `created_by`, `last_modified`, `last_modified_by`, `isbn`, `price`, `title`, `year`, `author_id`, `publisher_id`) values('4',NULL,NULL,NULL,NULL,'3','100000','Kata Mutiara','202002','2','1');
