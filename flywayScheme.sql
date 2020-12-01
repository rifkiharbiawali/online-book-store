/*
SQLyog Community
MySQL - 10.4.14-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `flyway_schema_history` (
	`installed_rank` int (11),
	`version` varchar (150),
	`description` varchar (600),
	`type` varchar (60),
	`script` varchar (3000),
	`checksum` int (11),
	`installed_by` varchar (300),
	`installed_on` timestamp ,
	`execution_time` int (11),
	`success` tinyint (1)
); 
insert into `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) values('1','1.0','online book store','SQL','V1_0__online_book_store.sql','1391162555','root','2020-12-01 19:39:04','20266','1');
insert into `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) values('2','1.1','populate online book store','SQL','V1_1__populate_online_book_store.sql','-364539831','root','2020-12-01 19:39:05','248','0');
