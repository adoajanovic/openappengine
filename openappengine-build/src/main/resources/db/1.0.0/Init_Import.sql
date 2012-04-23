-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.28-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema openapps_p01
--

CREATE DATABASE IF NOT EXISTS openapps_p01;
USE openapps_p01;

--
-- Definition of table `ab_address_book`
--

DROP TABLE IF EXISTS `ab_address_book`;
CREATE TABLE `ab_address_book` (
  `AB_ADDRESS_BOOK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AB_ADDRESS_1` varchar(100) NOT NULL,
  `AB_ADDRESS_2` varchar(100) DEFAULT NULL,
  `AB_ATTN_NAME` varchar(100) NOT NULL,
  `AB_CITY` varchar(100) NOT NULL,
  `AB_COUNTRY` varchar(100) NOT NULL,
  `AB_DIRECTIONS` varchar(100) DEFAULT NULL,
  `AB_POSTAL_CODE` varchar(100) NOT NULL,
  `AB_POSTAL_CODE_EXT` varchar(100) DEFAULT NULL,
  `AB_STATE_PROVINCE` varchar(100) NOT NULL,
  `AB_TO_NAME` varchar(100) NOT NULL,
  PRIMARY KEY (`AB_ADDRESS_BOOK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ab_address_book`
--

/*!40000 ALTER TABLE `ab_address_book` DISABLE KEYS */;
INSERT INTO `ab_address_book` (`AB_ADDRESS_BOOK_ID`,`AB_ADDRESS_1`,`AB_ADDRESS_2`,`AB_ATTN_NAME`,`AB_CITY`,`AB_COUNTRY`,`AB_DIRECTIONS`,`AB_POSTAL_CODE`,`AB_POSTAL_CODE_EXT`,`AB_STATE_PROVINCE`,`AB_TO_NAME`) VALUES 
 (1,'A','B','Hrishikesh Joshi','MUM','IND',NULL,'400002',NULL,'MAH','Hrishikesh Joshi'),
 (2,'b','b','Nachiket Bordekar','b','b',NULL,'b',NULL,'b','Nachiket Bordekar');
/*!40000 ALTER TABLE `ab_address_book` ENABLE KEYS */;


--
-- Definition of table `ab_address_type`
--

DROP TABLE IF EXISTS `ab_address_type`;
CREATE TABLE `ab_address_type` (
  `AT_ADDRESS_BOOK_ID` int(11) NOT NULL,
  `AT_ADDRESS_TYPE_ID` int(11) NOT NULL,
  PRIMARY KEY (`AT_ADDRESS_BOOK_ID`,`AT_ADDRESS_TYPE_ID`),
  UNIQUE KEY `AT_ADDRESS_BOOK_ID` (`AT_ADDRESS_BOOK_ID`),
  UNIQUE KEY `AT_ADDRESS_TYPE_ID` (`AT_ADDRESS_TYPE_ID`),
  KEY `FK2A263C23C679213F` (`AT_ADDRESS_TYPE_ID`),
  KEY `FK2A263C23AADDFDD6` (`AT_ADDRESS_BOOK_ID`),
  CONSTRAINT `FK2A263C23AADDFDD6` FOREIGN KEY (`AT_ADDRESS_BOOK_ID`) REFERENCES `ab_address_book` (`AB_ADDRESS_BOOK_ID`),
  CONSTRAINT `FK2A263C23C679213F` FOREIGN KEY (`AT_ADDRESS_TYPE_ID`) REFERENCES `ab_type` (`AB_ADDRESS_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ab_address_type`
--

/*!40000 ALTER TABLE `ab_address_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `ab_address_type` ENABLE KEYS */;


--
-- Definition of table `ab_role`
--

DROP TABLE IF EXISTS `ab_role`;
CREATE TABLE `ab_role` (
  `AB_ADDRESS_ROLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AB_ROLE_FROM_DATE` datetime NOT NULL,
  `AB_ROLE_VALUE` varchar(100) NOT NULL,
  `AB_ROLE_TO_DATE` datetime NOT NULL,
  PRIMARY KEY (`AB_ADDRESS_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ab_role`
--

/*!40000 ALTER TABLE `ab_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `ab_role` ENABLE KEYS */;


--
-- Definition of table `ab_type`
--

DROP TABLE IF EXISTS `ab_type`;
CREATE TABLE `ab_type` (
  `AB_ADDRESS_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AB_TYPE_FROM_DATE` datetime NOT NULL,
  `AB_TYPE_TO_DATE` datetime NOT NULL,
  `AB_TYPE_VALUE` varchar(100) NOT NULL,
  PRIMARY KEY (`AB_ADDRESS_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ab_type`
--

/*!40000 ALTER TABLE `ab_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `ab_type` ENABLE KEYS */;


--
-- Definition of table `ad_table_sequences`
--

DROP TABLE IF EXISTS `ad_table_sequences`;
CREATE TABLE `ad_table_sequences` (
  `TS_SEQUENCE_NAME` varchar(100) NOT NULL,
  `TS_SEQUENCE_VALUE` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ad_table_sequences`
--

/*!40000 ALTER TABLE `ad_table_sequences` DISABLE KEYS */;
INSERT INTO `ad_table_sequences` (`TS_SEQUENCE_NAME`,`TS_SEQUENCE_VALUE`) VALUES 
 ('prod_product',6),
 ('prod_product_price',7),
 ('PM_PARTY',3),
 ('AB_ADDRESS_BOOK',3),
 ('PM_PARTY_CONTACT_MECH',9),
 ('FM_ORDER_HEADER',31),
 ('FM_ORDER_ITEM',41),
 ('fm_invoice',5);
/*!40000 ALTER TABLE `ad_table_sequences` ENABLE KEYS */;


--
-- Definition of table `cn_contract_det`
--

DROP TABLE IF EXISTS `cn_contract_det`;
CREATE TABLE `cn_contract_det` (
  `CN_CONTRACT_DET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CN_COST` decimal(10,2) DEFAULT NULL,
  `CN_DISCOUNT` decimal(10,2) DEFAULT NULL,
  `CN_ITEM_ID` int(11) NOT NULL,
  `CN_LOCATION` varchar(255) DEFAULT NULL,
  `CN_LOT_NO` varchar(255) DEFAULT NULL,
  `CN_ORD_TYPE` varchar(10) NOT NULL,
  `CN_PRICE` decimal(10,2) DEFAULT NULL,
  `CN_QTY_ORD` decimal(10,2) DEFAULT NULL,
  `CN_UOM` varchar(50) NOT NULL,
  `CN_WEIGHT` decimal(10,2) DEFAULT NULL,
  `CN_CONTRACT_ID` int(11) NOT NULL,
  PRIMARY KEY (`CN_CONTRACT_DET_ID`),
  UNIQUE KEY `CN_CONTRACT_DET_ID` (`CN_CONTRACT_DET_ID`),
  KEY `FKF3C069A713F1903` (`CN_CONTRACT_ID`),
  CONSTRAINT `FKF3C069A713F1903` FOREIGN KEY (`CN_CONTRACT_ID`) REFERENCES `cn_contract_hdr` (`CN_CONTRACT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cn_contract_det`
--

/*!40000 ALTER TABLE `cn_contract_det` DISABLE KEYS */;
/*!40000 ALTER TABLE `cn_contract_det` ENABLE KEYS */;


--
-- Definition of table `cn_contract_hdr`
--

DROP TABLE IF EXISTS `cn_contract_hdr`;
CREATE TABLE `cn_contract_hdr` (
  `CN_CONTRACT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAN_DATE` datetime DEFAULT NULL,
  `CN_END_DATE` datetime NOT NULL,
  `CN_START_DATE` datetime NOT NULL,
  `CN_PARTY_ID` int(11) NOT NULL,
  PRIMARY KEY (`CN_CONTRACT_ID`),
  UNIQUE KEY `CN_CONTRACT_ID` (`CN_CONTRACT_ID`),
  KEY `FKF3C157DBFDB665F` (`CN_PARTY_ID`),
  CONSTRAINT `FKF3C157DBFDB665F` FOREIGN KEY (`CN_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cn_contract_hdr`
--

/*!40000 ALTER TABLE `cn_contract_hdr` DISABLE KEYS */;
/*!40000 ALTER TABLE `cn_contract_hdr` ENABLE KEYS */;


--
-- Definition of table `co_code_master`
--

DROP TABLE IF EXISTS `co_code_master`;
CREATE TABLE `co_code_master` (
  `CM_CODE_MASTER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CM_CODE_LABEL` varchar(100) NOT NULL,
  `CM_CODE_VALUE` varchar(100) NOT NULL,
  `CM_CODE_TYPE_ID` int(11) NOT NULL,
  PRIMARY KEY (`CM_CODE_MASTER_ID`),
  KEY `FK775A85A1E63F8364` (`CM_CODE_TYPE_ID`),
  CONSTRAINT `FK775A85A1E63F8364` FOREIGN KEY (`CM_CODE_TYPE_ID`) REFERENCES `co_code_type` (`CT_CODE_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `co_code_master`
--

/*!40000 ALTER TABLE `co_code_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `co_code_master` ENABLE KEYS */;


--
-- Definition of table `co_code_type`
--

DROP TABLE IF EXISTS `co_code_type`;
CREATE TABLE `co_code_type` (
  `CT_CODE_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CT_CODE_TYPE_VALUE` varchar(100) NOT NULL,
  PRIMARY KEY (`CT_CODE_TYPE_ID`),
  UNIQUE KEY `CT_CODE_TYPE_ID` (`CT_CODE_TYPE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `co_code_type`
--

/*!40000 ALTER TABLE `co_code_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `co_code_type` ENABLE KEYS */;


--
-- Definition of table `fm_invoice`
--

DROP TABLE IF EXISTS `fm_invoice`;
CREATE TABLE `fm_invoice` (
  `IN_INVOICE_ID` int(11) NOT NULL,
  `IN_INVOICE_TYPE_ID` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_PARTY_ID_FROM` int(11) DEFAULT NULL,
  `IN_PARTY_ID` int(11) DEFAULT NULL,
  `IN_ROLE_TYPE_ID` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_STATUS_ID` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_BILLING_ACCOUNT_ID` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_CONTACT_MECH_ID` int(11) DEFAULT NULL,
  `IN_INVOICE_DATE` datetime DEFAULT NULL,
  `IN_DUE_DATE` datetime DEFAULT NULL,
  `IN_PAID_DATE` datetime DEFAULT NULL,
  `IN_INVOICE_MESSAGE` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_REFERENCE_NUMBER` varchar(60) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_DESCRIPTION` varchar(255) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_CURRENCY_UOM_ID` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  `IN_RECURRENCE_INFO_ID` varchar(20) CHARACTER SET latin1 COLLATE latin1_general_cs DEFAULT NULL,
  PRIMARY KEY (`IN_INVOICE_ID`),
  KEY `INVOICE_PARTY` (`IN_PARTY_ID`),
  CONSTRAINT `INVOICE_PARTY` FOREIGN KEY (`IN_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fm_invoice`
--

/*!40000 ALTER TABLE `fm_invoice` DISABLE KEYS */;
INSERT INTO `fm_invoice` (`IN_INVOICE_ID`,`IN_INVOICE_TYPE_ID`,`IN_PARTY_ID_FROM`,`IN_PARTY_ID`,`IN_ROLE_TYPE_ID`,`IN_STATUS_ID`,`IN_BILLING_ACCOUNT_ID`,`IN_CONTACT_MECH_ID`,`IN_INVOICE_DATE`,`IN_DUE_DATE`,`IN_PAID_DATE`,`IN_INVOICE_MESSAGE`,`IN_REFERENCE_NUMBER`,`IN_DESCRIPTION`,`IN_CURRENCY_UOM_ID`,`IN_RECURRENCE_INFO_ID`) VALUES 
 (0,'SALES_INVOICE',0,1,NULL,'INVOICE_READY','1',1,'2012-04-15 12:13:13',NULL,NULL,NULL,'IN00002',NULL,'INR',NULL),
 (1,'SALES_INVOICE',0,1,NULL,'INVOICE_READY','1',1,'2012-04-15 12:16:35',NULL,NULL,NULL,'IN00003',NULL,'INR',NULL),
 (2,'SALES_INVOICE',0,1,NULL,'INVOICE_READY','1',1,'2012-04-15 15:17:21',NULL,NULL,NULL,'IN00004',NULL,'INR',NULL),
 (3,'SALES_INVOICE',0,1,NULL,'INVOICE_READY','1',1,'2012-04-15 18:17:44',NULL,NULL,NULL,'IN00005',NULL,'INR',NULL),
 (4,'SALES_INVOICE',0,1,NULL,'INVOICE_READY','1',1,'2012-04-15 18:31:01',NULL,NULL,NULL,'IN00006',NULL,'INR',NULL);
/*!40000 ALTER TABLE `fm_invoice` ENABLE KEYS */;


--
-- Definition of table `fm_invoice_item`
--

DROP TABLE IF EXISTS `fm_invoice_item`;
CREATE TABLE `fm_invoice_item` (
  `IT_INVOICE_ID` int(11) NOT NULL,
  `IT_INVOICE_ITEM_SEQ_ID` varchar(20) NOT NULL,
  `IT_INVOICE_ITEM_TYPE_ID` varchar(50) DEFAULT NULL,
  `IT_OVERRIDE_GL_ACCOUNT_ID` int(11) DEFAULT NULL,
  `IT_OVERRIDE_ORG_PARTY_ID` int(11) DEFAULT NULL,
  `IT_INVENTORY_ITEM_ID` int(20) DEFAULT NULL,
  `IT_PRODUCT_ID` int(11) DEFAULT NULL,
  `IT_PRODUCT_FEATURE_ID` varchar(20) DEFAULT NULL,
  `IT_PARENT_INVOICE_ID` int(11) DEFAULT NULL,
  `IT_PARENT_INVOICE_ITEM_SEQ_ID` varchar(20) DEFAULT NULL,
  `IT_UOM_ID` varchar(20) DEFAULT NULL,
  `IT_TAXABLE_FLAG` bit(1) DEFAULT NULL,
  `IT_QUANTITY` decimal(18,6) DEFAULT NULL,
  `IT_AMOUNT` decimal(18,3) DEFAULT NULL,
  `IT_DESCRIPTION` varchar(255) DEFAULT NULL,
  `IT_TAX_AUTH_PARTY_ID` varchar(20) DEFAULT NULL,
  `IT_TAX_AUTH_GEO_ID` varchar(20) DEFAULT NULL,
  `IT_TAX_AUTHORITY_RATE_SEQ_ID` varchar(20) DEFAULT NULL,
  `IT_SALES_OPPORTUNITY_ID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IT_INVOICE_ID`,`IT_INVOICE_ITEM_SEQ_ID`),
  KEY `INVCE_ITM_INVCE` (`IT_INVOICE_ID`),
  KEY `INVCE_ITM_PROD` (`IT_PRODUCT_ID`),
  CONSTRAINT `INVCE_ITM_INVCE` FOREIGN KEY (`IT_INVOICE_ID`) REFERENCES `fm_invoice` (`IN_INVOICE_ID`),
  CONSTRAINT `INVCE_ITM_PROD` FOREIGN KEY (`IT_PRODUCT_ID`) REFERENCES `prod_product` (`PD_PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fm_invoice_item`
--

/*!40000 ALTER TABLE `fm_invoice_item` DISABLE KEYS */;
INSERT INTO `fm_invoice_item` (`IT_INVOICE_ID`,`IT_INVOICE_ITEM_SEQ_ID`,`IT_INVOICE_ITEM_TYPE_ID`,`IT_OVERRIDE_GL_ACCOUNT_ID`,`IT_OVERRIDE_ORG_PARTY_ID`,`IT_INVENTORY_ITEM_ID`,`IT_PRODUCT_ID`,`IT_PRODUCT_FEATURE_ID`,`IT_PARENT_INVOICE_ID`,`IT_PARENT_INVOICE_ITEM_SEQ_ID`,`IT_UOM_ID`,`IT_TAXABLE_FLAG`,`IT_QUANTITY`,`IT_AMOUNT`,`IT_DESCRIPTION`,`IT_TAX_AUTH_PARTY_ID`,`IT_TAX_AUTH_GEO_ID`,`IT_TAX_AUTHORITY_RATE_SEQ_ID`,`IT_SALES_OPPORTUNITY_ID`) VALUES 
 (0,'1','SV',0,0,0,4,NULL,0,NULL,NULL,0x00,'10.000000','1123.600','Demo1',NULL,NULL,NULL,NULL),
 (1,'1','SV',0,0,0,4,NULL,0,NULL,NULL,0x00,'10.000000','1123.600','Demo1',NULL,NULL,NULL,NULL),
 (2,'1','SV',0,0,0,1,NULL,0,NULL,NULL,0x00,'12.000000','2696.640','XYZ TRIP',NULL,NULL,NULL,NULL),
 (3,'1','SV',0,0,0,1,NULL,0,NULL,NULL,0x00,'5.000000','1123.600','XYZ TRIP',NULL,NULL,NULL,NULL),
 (4,'1','SV',0,0,0,1,NULL,0,NULL,NULL,0x00,'4.000000','898.880','XYZ TRIP',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `fm_invoice_item` ENABLE KEYS */;


--
-- Definition of table `fm_invoice_sequence`
--

DROP TABLE IF EXISTS `fm_invoice_sequence`;
CREATE TABLE `fm_invoice_sequence` (
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fm_invoice_sequence`
--

/*!40000 ALTER TABLE `fm_invoice_sequence` DISABLE KEYS */;
INSERT INTO `fm_invoice_sequence` (`value`) VALUES 
 (6);
/*!40000 ALTER TABLE `fm_invoice_sequence` ENABLE KEYS */;


--
-- Definition of table `fm_order_header`
--

DROP TABLE IF EXISTS `fm_order_header`;
CREATE TABLE `fm_order_header` (
  `OH_ORDER_ID` int(11) NOT NULL,
  `OH_ORDER_TYPE_ID` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_ORDER_NAME` varchar(100) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_EXTERNAL_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_ORDER_DATE` datetime DEFAULT NULL,
  `OH_PRIORITY` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_ENTRY_DATE` datetime DEFAULT NULL,
  `OH_STATUS_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_CURRENCY_UOM` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_BILLING_ACCOUNT_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_PRODUCT_STORE_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_TRANSACTION_ID` varchar(60) COLLATE latin1_general_cs DEFAULT NULL,
  `OH_GRAND_TOTAL` decimal(18,6) DEFAULT NULL,
  PRIMARY KEY (`OH_ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_order_header`
--

/*!40000 ALTER TABLE `fm_order_header` DISABLE KEYS */;
INSERT INTO `fm_order_header` (`OH_ORDER_ID`,`OH_ORDER_TYPE_ID`,`OH_ORDER_NAME`,`OH_EXTERNAL_ID`,`OH_ORDER_DATE`,`OH_PRIORITY`,`OH_ENTRY_DATE`,`OH_STATUS_ID`,`OH_CURRENCY_UOM`,`OH_BILLING_ACCOUNT_ID`,`OH_PRODUCT_STORE_ID`,`OH_TRANSACTION_ID`,`OH_GRAND_TOTAL`) VALUES 
 (23,'SALES_ORDER','41','OR00041','2012-04-21 19:57:12','\0','2012-04-21 19:57:12','ORDER_CREATED','INR','1',NULL,NULL,'674.160000'),
 (24,'SALES_ORDER','42','OR00042','2012-04-21 20:07:17','\0','2012-04-21 20:07:17','ORDER_CREATED','INR','1',NULL,NULL,'898.880000'),
 (25,'SALES_ORDER','43','OR00043','2012-04-21 20:14:54','\0','2012-04-21 20:14:54','ORDER_CREATED','INR','1',NULL,NULL,'1797.760000'),
 (26,'SALES_ORDER','45','OR00045','2012-04-21 22:27:22','\0','2012-04-21 22:27:22','ORDER_CREATED','INR','1',NULL,NULL,'2247.200000'),
 (27,'SALES_ORDER','46','OR00046','2012-04-21 22:35:37','\0','2012-04-21 22:35:37','ORDER_CREATED','INR','1',NULL,NULL,'224.720000'),
 (28,'SALES_ORDER','Demo 48','OR00048','2012-04-22 00:20:02','\0','2012-04-22 00:20:02','ORDER_CREATED','INR','2',NULL,NULL,'449.440000'),
 (29,'SALES_ORDER','Dapoli Trip Nachiket','OR00049','2012-04-22 00:45:09','\0','2012-04-22 00:45:09','ORDER_CREATED','INR','2',NULL,NULL,'11236.000000'),
 (30,'SALES_ORDER','OR00050','OR00050','2012-04-22 15:20:48','\0','2012-04-22 15:20:48','ORDER_CANCELLED','INR','2',NULL,NULL,'224.720000');
/*!40000 ALTER TABLE `fm_order_header` ENABLE KEYS */;


--
-- Definition of table `fm_order_item`
--

DROP TABLE IF EXISTS `fm_order_item`;
CREATE TABLE `fm_order_item` (
  `OI_ORDER_ITEM_ID` int(11) NOT NULL,
  `OI_ORDER_ID` int(11) NOT NULL,
  `OI_ORDER_ITEM_SEQ_ID` varchar(20) COLLATE latin1_general_cs NOT NULL,
  `OI_EXTERNAL_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `OI_ORDER_ITEM_TYPE_ID` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `OI_PRODUCT_ID` int(11) DEFAULT NULL,
  `OI_QUANTITY` decimal(18,6) DEFAULT NULL,
  `OI_CANCEL_QUANTITY` decimal(18,6) DEFAULT NULL,
  `OI_SELECTED_AMOUNT` decimal(18,6) DEFAULT NULL,
  `OI_UNIT_PRICE` decimal(18,2) DEFAULT NULL,
  `OI_UNIT_LIST_PRICE` decimal(18,2) DEFAULT NULL,
  `OI_IS_MODIFIED_PRICE` bit(1) DEFAULT NULL,
  `OI_ITEM_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `OI_COMMENTS` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `OI_STATUS_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `OI_TAX_PRICE` decimal(18,2) DEFAULT NULL,
  `OI_LINE_TOTAL_PRICE` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`OI_ORDER_ITEM_ID`),
  KEY `ORDER_ITEM_HDR` (`OI_ORDER_ID`),
  CONSTRAINT `ORDER_ITEM_HDR` FOREIGN KEY (`OI_ORDER_ID`) REFERENCES `fm_order_header` (`OH_ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_order_item`
--

/*!40000 ALTER TABLE `fm_order_item` DISABLE KEYS */;
INSERT INTO `fm_order_item` (`OI_ORDER_ITEM_ID`,`OI_ORDER_ID`,`OI_ORDER_ITEM_SEQ_ID`,`OI_EXTERNAL_ID`,`OI_ORDER_ITEM_TYPE_ID`,`OI_PRODUCT_ID`,`OI_QUANTITY`,`OI_CANCEL_QUANTITY`,`OI_SELECTED_AMOUNT`,`OI_UNIT_PRICE`,`OI_UNIT_LIST_PRICE`,`OI_IS_MODIFIED_PRICE`,`OI_ITEM_DESCRIPTION`,`OI_COMMENTS`,`OI_STATUS_ID`,`OI_TAX_PRICE`,`OI_LINE_TOTAL_PRICE`) VALUES 
 (30,23,'1',NULL,'SV',1,'2.000000',NULL,NULL,'200.00','200.00',0x00,'XYZ TRIP',NULL,'ORDER_ITEM_STORED','49.44','449.44'),
 (31,23,'2',NULL,'SV',4,'2.000000',NULL,NULL,'100.00','100.00',0x00,'Demo1',NULL,'ORDER_ITEM_STORED','24.72','224.72'),
 (32,24,'1',NULL,'SV',1,'2.000000',NULL,NULL,'200.00','200.00',0x00,'XYZ TRIP',NULL,'ORDER_ITEM_STORED','49.44','449.44'),
 (33,24,'2',NULL,'SV',4,'4.000000',NULL,NULL,'100.00','100.00',0x00,'Demo1',NULL,'ORDER_ITEM_STORED','49.44','449.44'),
 (34,25,'1',NULL,'SV',1,'2.000000',NULL,NULL,'200.00','200.00',0x00,'XYZ TRIP',NULL,'ORDER_ITEM_STORED','49.44','449.44'),
 (35,25,'2',NULL,'SV',4,'12.000000',NULL,NULL,'100.00','100.00',0x00,'Demo1',NULL,'ORDER_ITEM_STORED','148.32','1348.32'),
 (36,26,'1',NULL,'SV',1,'10.000000',NULL,NULL,'200.00','200.00',0x00,'XYZ TRIP',NULL,'ORDER_ITEM_STORED','247.20','2247.20'),
 (37,27,'1',NULL,'SV',1,'1.000000',NULL,NULL,'200.00','200.00',0x00,'XYZ TRIP',NULL,'ORDER_ITEM_STORED','24.72','224.72'),
 (38,28,'1',NULL,'SV',1,'2.000000',NULL,NULL,'200.00','200.00',0x00,'XYZ TRIP',NULL,'ORDER_ITEM_STORED','49.44','449.44'),
 (39,29,'1',NULL,'SV',5,'10.000000',NULL,NULL,'1000.00','1000.00',0x00,'Dapoli Trip',NULL,'ORDER_ITEM_STORED','1236.00','11236.00'),
 (40,30,'1',NULL,'SV',1,'1.000000',NULL,NULL,'200.00','200.00',0x00,'XYZ TRIP',NULL,'ORDER_ITEM_STORED','24.72','224.72');
/*!40000 ALTER TABLE `fm_order_item` ENABLE KEYS */;


--
-- Definition of table `fm_order_sequence`
--

DROP TABLE IF EXISTS `fm_order_sequence`;
CREATE TABLE `fm_order_sequence` (
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fm_order_sequence`
--

/*!40000 ALTER TABLE `fm_order_sequence` DISABLE KEYS */;
INSERT INTO `fm_order_sequence` (`value`) VALUES 
 (50);
/*!40000 ALTER TABLE `fm_order_sequence` ENABLE KEYS */;


--
-- Definition of table `fm_order_type`
--

DROP TABLE IF EXISTS `fm_order_type`;
CREATE TABLE `fm_order_type` (
  `OT_ORDER_TYPE_ID` int(11) NOT NULL,
  `OT_HAS_TABLE` bit(1) DEFAULT NULL,
  `OT_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  PRIMARY KEY (`OT_ORDER_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_order_type`
--

/*!40000 ALTER TABLE `fm_order_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_order_type` ENABLE KEYS */;


--
-- Definition of table `fm_payment`
--

DROP TABLE IF EXISTS `fm_payment`;
CREATE TABLE `fm_payment` (
  `PMT_PAYMENT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PMT_PAYMENT_TYPE_ID` int(11) DEFAULT NULL,
  `PMT_PAYMENT_METHOD_TYPE_ID` int(11) DEFAULT NULL,
  `PMT_PAYMENT_METHOD_ID` int(11) DEFAULT NULL,
  `PMT_PARTY_ID_FROM` int(11) DEFAULT NULL,
  `PMT_PARTY_ID_TO` int(11) DEFAULT NULL,
  `PMT_ROLE_TYPE_ID_TO` int(11) DEFAULT NULL,
  `PMT_STATUS_ID` int(11) DEFAULT NULL,
  `PMT_EFFECTIVE_DATE` datetime DEFAULT NULL,
  `PMT_PAYMENT_REF_NUM` varchar(60) COLLATE latin1_general_cs DEFAULT NULL,
  `PMT_AMOUNT` decimal(18,2) DEFAULT NULL,
  `PMT_COMMENTS` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `PMT_FIN_ACCOUNT_TRANS_ID` int(11) DEFAULT NULL,
  `PMT_ACTUAL_CURRENCY_AMOUNT` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`PMT_PAYMENT_ID`),
  KEY `FK_PM_PAYMENT_TYPE_ID` (`PMT_PAYMENT_TYPE_ID`),
  KEY `FK_PM_PAYMENT_METHOD_TYPE_ID` (`PMT_PAYMENT_METHOD_TYPE_ID`),
  CONSTRAINT `FK_PM_PAYMENT_METHOD_TYPE_ID` FOREIGN KEY (`PMT_PAYMENT_METHOD_TYPE_ID`) REFERENCES `fm_payment_menthod_type` (`PM_PAYMENT_METHOD_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PM_PAYMENT_TYPE_ID` FOREIGN KEY (`PMT_PAYMENT_TYPE_ID`) REFERENCES `fm_payment_type` (`PT_PAYMENT_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_payment`
--

/*!40000 ALTER TABLE `fm_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_payment` ENABLE KEYS */;


--
-- Definition of table `fm_payment_menthod_type`
--

DROP TABLE IF EXISTS `fm_payment_menthod_type`;
CREATE TABLE `fm_payment_menthod_type` (
  `PM_PAYMENT_METHOD_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PM_PAYMENT_METHOD_TYPE_DESC` varchar(255) NOT NULL,
  `PM_HAS_TABLE` char(1) DEFAULT NULL,
  `PM_TABLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PM_PAYMENT_METHOD_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fm_payment_menthod_type`
--

/*!40000 ALTER TABLE `fm_payment_menthod_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_payment_menthod_type` ENABLE KEYS */;


--
-- Definition of table `fm_payment_type`
--

DROP TABLE IF EXISTS `fm_payment_type`;
CREATE TABLE `fm_payment_type` (
  `PT_PAYMENT_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PT_PAYMENT_TYPE_DESC` varchar(255) NOT NULL,
  `PT_HAS_TABLE` char(1) DEFAULT NULL,
  `PT_TABLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PT_PAYMENT_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fm_payment_type`
--

/*!40000 ALTER TABLE `fm_payment_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_payment_type` ENABLE KEYS */;


--
-- Definition of table `fm_tax_rate_product_type`
--

DROP TABLE IF EXISTS `fm_tax_rate_product_type`;
CREATE TABLE `fm_tax_rate_product_type` (
  `TR_TAX_RATE_ID` int(11) NOT NULL,
  `TR_TAX_RATE_TYPE_ID` int(11) DEFAULT NULL,
  `TR_PRODUCT_TYPE_ID` int(11) DEFAULT NULL,
  `TR_MIN_ITEM_PRICE` decimal(18,2) DEFAULT NULL,
  `TR_MIN_PURCHASE` decimal(18,2) DEFAULT NULL,
  `TR_TAX_PERCENTAGE` decimal(18,6) DEFAULT NULL,
  `TR_FROM_DATE` datetime DEFAULT NULL,
  `TR_TO_DATE` datetime DEFAULT NULL,
  `TR_DESCRIPTION` longtext CHARACTER SET latin1,
  PRIMARY KEY (`TR_TAX_RATE_ID`),
  KEY `FK_TAX_RATE_PRODUCT_ID` (`TR_PRODUCT_TYPE_ID`),
  KEY `FK_TAX_RATE_TYPE_ID` (`TR_TAX_RATE_TYPE_ID`),
  CONSTRAINT `FK_TR_PRODUCT_TYPE_ID` FOREIGN KEY (`TR_PRODUCT_TYPE_ID`) REFERENCES `prod_product_type` (`PT_PRODUCT_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TAX_RATE_TYPE_ID` FOREIGN KEY (`TR_TAX_RATE_TYPE_ID`) REFERENCES `fm_tax_type` (`TT_TAX_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_tax_rate_product_type`
--

/*!40000 ALTER TABLE `fm_tax_rate_product_type` DISABLE KEYS */;
INSERT INTO `fm_tax_rate_product_type` (`TR_TAX_RATE_ID`,`TR_TAX_RATE_TYPE_ID`,`TR_PRODUCT_TYPE_ID`,`TR_MIN_ITEM_PRICE`,`TR_MIN_PURCHASE`,`TR_TAX_PERCENTAGE`,`TR_FROM_DATE`,`TR_TO_DATE`,`TR_DESCRIPTION`) VALUES 
 (1,1,1,NULL,NULL,'12.360000','2012-04-01 00:00:00','2013-03-31 00:00:00','SERVICE TAX');
/*!40000 ALTER TABLE `fm_tax_rate_product_type` ENABLE KEYS */;


--
-- Definition of table `fm_tax_type`
--

DROP TABLE IF EXISTS `fm_tax_type`;
CREATE TABLE `fm_tax_type` (
  `TT_TAX_TYPE_ID` int(11) NOT NULL,
  `TT_DESCRIPTION` longtext CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`TT_TAX_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_tax_type`
--

/*!40000 ALTER TABLE `fm_tax_type` DISABLE KEYS */;
INSERT INTO `fm_tax_type` (`TT_TAX_TYPE_ID`,`TT_DESCRIPTION`) VALUES 
 (1,'SERVICE TAX');
/*!40000 ALTER TABLE `fm_tax_type` ENABLE KEYS */;


--
-- Definition of table `fms_driver`
--

DROP TABLE IF EXISTS `fms_driver`;
CREATE TABLE `fms_driver` (
  `FD_DRIVER_ID` int(11) NOT NULL,
  `FD_PARTY_ID` int(11) NOT NULL,
  PRIMARY KEY (`FD_DRIVER_ID`),
  KEY `FK_PARTY_ID` (`FD_PARTY_ID`),
  CONSTRAINT `FK_PARTY_ID` FOREIGN KEY (`FD_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_driver`
--

/*!40000 ALTER TABLE `fms_driver` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_driver` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_task`
--

DROP TABLE IF EXISTS `fms_fleet_task`;
CREATE TABLE `fms_fleet_task` (
  `FL_FLEET_TASK_ID` int(11) NOT NULL,
  `FL_TASK_TITLE` varchar(255) NOT NULL,
  `FL_TASK_DESCRIPTION` text,
  `FL_TASK_ADDED_DATE` date NOT NULL,
  `FL_TASK_STATUS` varchar(50) NOT NULL,
  PRIMARY KEY (`FL_FLEET_TASK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_task`
--

/*!40000 ALTER TABLE `fms_fleet_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_task` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_task_action`
--

DROP TABLE IF EXISTS `fms_fleet_task_action`;
CREATE TABLE `fms_fleet_task_action` (
  `FA_ACTION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FA_ACTION_NAME` varchar(255) NOT NULL,
  `FA_TASK_ID` int(11) NOT NULL,
  PRIMARY KEY (`FA_ACTION_ID`),
  KEY `FA_FLEET_TASK` (`FA_TASK_ID`),
  CONSTRAINT `FA_FLEET_TASK` FOREIGN KEY (`FA_TASK_ID`) REFERENCES `fms_fleet_task` (`FL_FLEET_TASK_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_task_action`
--

/*!40000 ALTER TABLE `fms_fleet_task_action` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_task_action` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_task_driver`
--

DROP TABLE IF EXISTS `fms_fleet_task_driver`;
CREATE TABLE `fms_fleet_task_driver` (
  `FTD_FLEET_TASK_DRIVER_ID` int(11) NOT NULL,
  `FTD_DRIVER_ID` int(11) NOT NULL,
  `FTD_TASK_ID` int(11) NOT NULL,
  PRIMARY KEY (`FTD_FLEET_TASK_DRIVER_ID`),
  KEY `FK_FTD_TASK_ID` (`FTD_TASK_ID`),
  KEY `FK_FTD_DRIVER_ID` (`FTD_DRIVER_ID`),
  CONSTRAINT `FK_FTD_DRIVER_ID` FOREIGN KEY (`FTD_DRIVER_ID`) REFERENCES `fms_driver` (`FD_DRIVER_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_FTD_TASK_ID` FOREIGN KEY (`FTD_TASK_ID`) REFERENCES `fms_fleet_task` (`FL_FLEET_TASK_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_task_driver`
--

/*!40000 ALTER TABLE `fms_fleet_task_driver` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_task_driver` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_task_schedule`
--

DROP TABLE IF EXISTS `fms_fleet_task_schedule`;
CREATE TABLE `fms_fleet_task_schedule` (
  `FS_FLEET_TASK_SCHEDULE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FS_FLEET_START_DATE` date NOT NULL,
  `FS_FLEET_END_DATE` date NOT NULL,
  `FS_PERIODICITY` varchar(20) NOT NULL,
  `FS_FLEET_START_TIME` time DEFAULT NULL,
  `FS_FLEET_END_TIME` time DEFAULT NULL,
  `FS_FLEET_TASK_ID` int(11) NOT NULL,
  PRIMARY KEY (`FS_FLEET_TASK_SCHEDULE_ID`),
  KEY `FK_FLEET_TASK_ID` (`FS_FLEET_TASK_ID`),
  CONSTRAINT `FK_FLEET_TASK_ID` FOREIGN KEY (`FS_FLEET_TASK_ID`) REFERENCES `fms_fleet_task` (`FL_FLEET_TASK_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_task_schedule`
--

/*!40000 ALTER TABLE `fms_fleet_task_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_task_schedule` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_task_user`
--

DROP TABLE IF EXISTS `fms_fleet_task_user`;
CREATE TABLE `fms_fleet_task_user` (
  `FTU_FLEET_TASK_USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FTU_FLEET_TASK_ID` int(11) NOT NULL,
  `FTU_FLEET_USER_ID` int(11) NOT NULL,
  `FTU_FLEET_SERVICE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`FTU_FLEET_TASK_USER_ID`),
  KEY `FK_FTU_FLEET_TASK_ID` (`FTU_FLEET_TASK_ID`),
  KEY `FK_FTU_FLEET_USER_ID` (`FTU_FLEET_USER_ID`),
  KEY `FTU_FLEET_SERVICE_ID` (`FTU_FLEET_SERVICE_ID`),
  CONSTRAINT `FK_FTU_FLEET_TASK_ID` FOREIGN KEY (`FTU_FLEET_TASK_ID`) REFERENCES `fms_fleet_task` (`FL_FLEET_TASK_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_FTU_FLEET_USER_ID` FOREIGN KEY (`FTU_FLEET_USER_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FTU_FLEET_SERVICE_ID` FOREIGN KEY (`FTU_FLEET_SERVICE_ID`) REFERENCES `prod_product` (`PD_PRODUCT_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_task_user`
--

/*!40000 ALTER TABLE `fms_fleet_task_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_task_user` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_task_vehicle`
--

DROP TABLE IF EXISTS `fms_fleet_task_vehicle`;
CREATE TABLE `fms_fleet_task_vehicle` (
  `FVH_FLEET_TASK_VEHICLE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `FVH_TASK_ID` int(11) NOT NULL,
  `FVH_VEHICLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`FVH_FLEET_TASK_VEHICLE_ID`),
  KEY `FVH_TASK_ID` (`FVH_TASK_ID`),
  KEY `FVH_VEHICLE_ID` (`FVH_VEHICLE_ID`),
  CONSTRAINT `FK_FVH_TASK_ID` FOREIGN KEY (`FVH_TASK_ID`) REFERENCES `fms_fleet_task` (`FL_FLEET_TASK_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_FVH_VEHICLE_ID` FOREIGN KEY (`FVH_VEHICLE_ID`) REFERENCES `fms_fleet_vehicle` (`FV_VEHICLE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_task_vehicle`
--

/*!40000 ALTER TABLE `fms_fleet_task_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_task_vehicle` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle`;
CREATE TABLE `fms_fleet_vehicle` (
  `FV_VEHICLE_ID` int(11) NOT NULL,
  `FV_TYPE_ID` int(11) NOT NULL,
  `FV_VEHICLE_MODEL` varchar(255) DEFAULT NULL,
  `FV_VEHICLE_MAKE` varchar(255) DEFAULT NULL,
  `FV_LICENCE_PLATE_NUMBER` varchar(255) NOT NULL,
  `FV_FROM_DATE` date NOT NULL,
  `FV_TO_DATE` date DEFAULT NULL,
  `FV_STATUS` varchar(50) NOT NULL,
  PRIMARY KEY (`FV_VEHICLE_ID`),
  KEY `FK_FLEET_VEHICLE_TYPE` (`FV_TYPE_ID`),
  CONSTRAINT `FK_FLEET_VEHICLE_TYPE` FOREIGN KEY (`FV_TYPE_ID`) REFERENCES `fms_fleet_vehicle_type` (`FT_FLEET_VEHICLE_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle_maint`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle_maint`;
CREATE TABLE `fms_fleet_vehicle_maint` (
  `FM_MAINT_ID` int(11) NOT NULL,
  `FM_MAINT_STATUS` varchar(255) NOT NULL,
  `FM_VEHICLE_ID` int(11) NOT NULL,
  `FM_MAINT_TYPE_ID` int(11) NOT NULL,
  `FM_MAINT_ORDER_ID` int(11) DEFAULT NULL COMMENT 'MAINTENANCE PURCHASE ORDER ID',
  `FM_MAINT_COST` decimal(18,6) DEFAULT NULL,
  PRIMARY KEY (`FM_MAINT_ID`),
  KEY `FK_MT_MAINT_TYPE_ID` (`FM_MAINT_TYPE_ID`),
  CONSTRAINT `FK_MT_MAINT_TYPE_ID` FOREIGN KEY (`FM_MAINT_TYPE_ID`) REFERENCES `fms_fleet_vehicle_maint_type` (`VMT_FLEET_MAINT_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle_maint`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle_maint` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle_maint` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle_maint_type`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle_maint_type`;
CREATE TABLE `fms_fleet_vehicle_maint_type` (
  `VMT_FLEET_MAINT_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `VMT_FLEET_MAINT_TYPE_DESC` varchar(255) NOT NULL,
  `VMT_HAS_TABLE` char(1) DEFAULT NULL,
  `VMT_TABLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VMT_FLEET_MAINT_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle_maint_type`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle_maint_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle_maint_type` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle_sequence`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle_sequence`;
CREATE TABLE `fms_fleet_vehicle_sequence` (
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle_sequence`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle_sequence` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle_std_cost`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle_std_cost`;
CREATE TABLE `fms_fleet_vehicle_std_cost` (
  `SC_VEHICLE_STD_COST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SC_VEHICLE_ID` int(11) NOT NULL,
  `SC_VEHICLE_STD_COST_TYPE_ID` int(11) NOT NULL,
  `SC_AMOUNT` decimal(18,6) NOT NULL,
  `SC_FROM_DATE` datetime NOT NULL,
  `SC_TO_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`SC_VEHICLE_STD_COST_ID`),
  KEY `FK_FLEET_STD_COST_TYPE_ID` (`SC_VEHICLE_STD_COST_TYPE_ID`),
  CONSTRAINT `FK_FLEET_STD_COST_TYPE_ID` FOREIGN KEY (`SC_VEHICLE_STD_COST_TYPE_ID`) REFERENCES `fms_fleet_vehicle_std_cost_type` (`CT_FLEET_STD_COST_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle_std_cost`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle_std_cost` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle_std_cost` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle_std_cost_type`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle_std_cost_type`;
CREATE TABLE `fms_fleet_vehicle_std_cost_type` (
  `CT_FLEET_STD_COST_TYPE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CT_FLEET_STD_COST_TYPE_DESC` varchar(255) NOT NULL,
  `CT_HAS_TABLE` char(1) DEFAULT NULL,
  `CT_TABLE_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CT_FLEET_STD_COST_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle_std_cost_type`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle_std_cost_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle_std_cost_type` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle_type`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle_type`;
CREATE TABLE `fms_fleet_vehicle_type` (
  `FT_FLEET_VEHICLE_TYPE_ID` int(11) NOT NULL,
  `FT_FLEET_TYPE_DESC` varchar(255) NOT NULL,
  PRIMARY KEY (`FT_FLEET_VEHICLE_TYPE_ID`),
  UNIQUE KEY `idx_fms_fleet_vehicle_type` (`FT_FLEET_TYPE_DESC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle_type`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle_type` ENABLE KEYS */;


--
-- Definition of table `fms_fleet_vehicle_type_sequence`
--

DROP TABLE IF EXISTS `fms_fleet_vehicle_type_sequence`;
CREATE TABLE `fms_fleet_vehicle_type_sequence` (
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fms_fleet_vehicle_type_sequence`
--

/*!40000 ALTER TABLE `fms_fleet_vehicle_type_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `fms_fleet_vehicle_type_sequence` ENABLE KEYS */;


--
-- Definition of table `in_inventory_master`
--

DROP TABLE IF EXISTS `in_inventory_master`;
CREATE TABLE `in_inventory_master` (
  `IM_INVENTORY_MASTER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IM_DATE_LR` datetime DEFAULT NULL,
  `IM_ITEM_ID` int(11) DEFAULT NULL,
  `IM_LOCATION` varchar(50) DEFAULT NULL,
  `IM_LOT_NO` varchar(50) DEFAULT NULL,
  `IM_QTY_AV` decimal(19,2) DEFAULT NULL,
  `IM_QTY_CM` decimal(19,2) DEFAULT NULL,
  `IM_QTY_PO` decimal(19,2) DEFAULT NULL,
  `IM_STATUS` varchar(50) DEFAULT NULL,
  `IM_UOM` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IM_INVENTORY_MASTER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `in_inventory_master`
--

/*!40000 ALTER TABLE `in_inventory_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `in_inventory_master` ENABLE KEYS */;


--
-- Definition of table `it_item_master`
--

DROP TABLE IF EXISTS `it_item_master`;
CREATE TABLE `it_item_master` (
  `ITEM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IT_CAT01` varchar(50) DEFAULT NULL,
  `IT_CAT02` varchar(50) DEFAULT NULL,
  `IT_CAT03` varchar(50) DEFAULT NULL,
  `IT_CAT04` varchar(50) DEFAULT NULL,
  `IT_CAT05` varchar(50) DEFAULT NULL,
  `IT_COST` decimal(10,2) DEFAULT NULL,
  `IT_CURCODE` varchar(50) NOT NULL,
  `IT_DESCRIPTION` varchar(255) NOT NULL,
  `IT_NAME` varchar(255) NOT NULL,
  `IT_PERISHABLE` bit(1) NOT NULL,
  `IT_PRICE` decimal(10,2) DEFAULT NULL,
  `IT_SHIP_CHARGES` decimal(10,2) DEFAULT NULL,
  `IT_STATUS` varchar(50) NOT NULL,
  `IT_TYPE` varchar(50) NOT NULL,
  `IT_UOM` varchar(50) NOT NULL,
  `IT_WEIGHT` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`ITEM_ID`),
  UNIQUE KEY `ITEM_ID` (`ITEM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `it_item_master`
--

/*!40000 ALTER TABLE `it_item_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `it_item_master` ENABLE KEYS */;


--
-- Definition of table `party_address`
--

DROP TABLE IF EXISTS `party_address`;
CREATE TABLE `party_address` (
  `PM_PARTY_ID` int(11) NOT NULL,
  `AB_ADDRESS_ID` int(11) NOT NULL,
  PRIMARY KEY (`PM_PARTY_ID`,`AB_ADDRESS_ID`),
  UNIQUE KEY `PM_PARTY_ID` (`PM_PARTY_ID`),
  UNIQUE KEY `AB_ADDRESS_ID` (`AB_ADDRESS_ID`),
  KEY `FK5524CB5B4A806D20` (`AB_ADDRESS_ID`),
  KEY `FK5524CB5B5B2F090D` (`PM_PARTY_ID`),
  CONSTRAINT `FK5524CB5B4A806D20` FOREIGN KEY (`AB_ADDRESS_ID`) REFERENCES `ab_address_book` (`AB_ADDRESS_BOOK_ID`),
  CONSTRAINT `FK5524CB5B5B2F090D` FOREIGN KEY (`PM_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `party_address`
--

/*!40000 ALTER TABLE `party_address` DISABLE KEYS */;
INSERT INTO `party_address` (`PM_PARTY_ID`,`AB_ADDRESS_ID`) VALUES 
 (1,1),
 (2,2);
/*!40000 ALTER TABLE `party_address` ENABLE KEYS */;


--
-- Definition of table `pm_party`
--

DROP TABLE IF EXISTS `pm_party`;
CREATE TABLE `pm_party` (
  `PM_PARTY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PM_DESCRIPTION` longtext,
  `PM_EXTERNAL_ID` varchar(50) DEFAULT NULL,
  `PM_PARTY_TYPE` varchar(100) NOT NULL,
  `PM_PREFERRED_CURRENCY_UOM` varchar(50) DEFAULT NULL,
  `PM_STATUS` varchar(50) NOT NULL,
  PRIMARY KEY (`PM_PARTY_ID`),
  UNIQUE KEY `PM_PARTY_ID` (`PM_PARTY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm_party`
--

/*!40000 ALTER TABLE `pm_party` DISABLE KEYS */;
INSERT INTO `pm_party` (`PM_PARTY_ID`,`PM_DESCRIPTION`,`PM_EXTERNAL_ID`,`PM_PARTY_TYPE`,`PM_PREFERRED_CURRENCY_UOM`,`PM_STATUS`) VALUES 
 (1,NULL,'NA','PERSON','INR','ACTIVE'),
 (2,NULL,'NA','PERSON','INR','ACTIVE');
/*!40000 ALTER TABLE `pm_party` ENABLE KEYS */;


--
-- Definition of table `pm_party_contact_mech`
--

DROP TABLE IF EXISTS `pm_party_contact_mech`;
CREATE TABLE `pm_party_contact_mech` (
  `PM_CONTACT_MECH_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PM_CONTACT_MECH_PURPOSE` varchar(50) NOT NULL,
  `PM_CONTACT_MECH_TYPE` varchar(50) NOT NULL,
  `PM_INFO_STRING` varchar(100) NOT NULL,
  `PM_PARTY_ID` int(11) NOT NULL,
  `CM_CONTACT_MECH_ID` int(11) DEFAULT NULL,
  `CM_CONTACT_MECH_PURPOSE` varchar(50) DEFAULT NULL,
  `CM_CONTACT_MECH_TYPE` varchar(50) DEFAULT NULL,
  `CM_INFO_STRING` varchar(100) DEFAULT NULL,
  `CM_PARTY_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`PM_CONTACT_MECH_ID`),
  UNIQUE KEY `PM_CONTACT_MECH_ID` (`PM_CONTACT_MECH_ID`),
  KEY `FK73E907375B2F090D` (`PM_PARTY_ID`),
  KEY `FK73E90737CB91F540` (`CM_PARTY_ID`),
  CONSTRAINT `FK73E907375B2F090D` FOREIGN KEY (`PM_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`),
  CONSTRAINT `FK73E90737CB91F540` FOREIGN KEY (`CM_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm_party_contact_mech`
--

/*!40000 ALTER TABLE `pm_party_contact_mech` DISABLE KEYS */;
INSERT INTO `pm_party_contact_mech` (`PM_CONTACT_MECH_ID`,`PM_CONTACT_MECH_PURPOSE`,`PM_CONTACT_MECH_TYPE`,`PM_INFO_STRING`,`PM_PARTY_ID`,`CM_CONTACT_MECH_ID`,`CM_CONTACT_MECH_PURPOSE`,`CM_CONTACT_MECH_TYPE`,`CM_INFO_STRING`,`CM_PARTY_ID`) VALUES 
 (1,'DEFAULT','PHONE_Residence','22036583',1,NULL,NULL,NULL,NULL,NULL),
 (2,'DEFAULT','PHONE_Mobile','9819791978',1,NULL,NULL,NULL,NULL,NULL),
 (3,'DEFAULT','EMAIL','hrishi2323@gmail.com',1,NULL,NULL,NULL,NULL,NULL),
 (4,'DEFAULT','EMAIL','hrishikeshjoshi0@gmail.com',1,NULL,NULL,NULL,NULL,NULL),
 (5,'DEFAULT','PHONE_Residence','89898989898',2,NULL,NULL,NULL,NULL,NULL),
 (6,'DEFAULT','PHONE_Residence','67868678',2,NULL,NULL,NULL,NULL,NULL),
 (7,'DEFAULT','EMAIL','nachi1313@gmail.com',2,NULL,NULL,NULL,NULL,NULL),
 (8,'DEFAULT','EMAIL','nachiketb@gmail.com',2,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `pm_party_contact_mech` ENABLE KEYS */;


--
-- Definition of table `pm_party_contact_mech_sequence`
--

DROP TABLE IF EXISTS `pm_party_contact_mech_sequence`;
CREATE TABLE `pm_party_contact_mech_sequence` (
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm_party_contact_mech_sequence`
--

/*!40000 ALTER TABLE `pm_party_contact_mech_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `pm_party_contact_mech_sequence` ENABLE KEYS */;


--
-- Definition of table `pm_party_sequence`
--

DROP TABLE IF EXISTS `pm_party_sequence`;
CREATE TABLE `pm_party_sequence` (
  `value` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm_party_sequence`
--

/*!40000 ALTER TABLE `pm_party_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `pm_party_sequence` ENABLE KEYS */;


--
-- Definition of table `pm_person`
--

DROP TABLE IF EXISTS `pm_person`;
CREATE TABLE `pm_person` (
  `PM_BIRTH_DATE` datetime DEFAULT NULL,
  `PM_COMMENTS` longtext,
  `PM_DECEASED_DATE` datetime DEFAULT NULL,
  `PM_FIRST_NAME` varchar(100) NOT NULL,
  `PM_GENDER` varchar(10) DEFAULT NULL,
  `PM_LAST_NAME` varchar(100) NOT NULL,
  `PM_MARITAL_STATUS` varchar(10) DEFAULT NULL,
  `PM_MIDDLE_NAME` varchar(100) DEFAULT NULL,
  `PM_NICK_NAME` varchar(50) DEFAULT NULL,
  `PM_PASSPORT_EXPIRATION_DATE` datetime DEFAULT NULL,
  `PM_PASSPORT_NUMBER` varchar(50) DEFAULT NULL,
  `PM_SALUTAION` varchar(100) DEFAULT NULL,
  `PM_SSN` varchar(50) DEFAULT NULL,
  `PM_SUFFIX` varchar(50) DEFAULT NULL,
  `PM_PARTY_ID` int(11) NOT NULL,
  PRIMARY KEY (`PM_PARTY_ID`),
  KEY `FKC203BBD75B2F090D` (`PM_PARTY_ID`),
  CONSTRAINT `FKC203BBD75B2F090D` FOREIGN KEY (`PM_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm_person`
--

/*!40000 ALTER TABLE `pm_person` DISABLE KEYS */;
INSERT INTO `pm_person` (`PM_BIRTH_DATE`,`PM_COMMENTS`,`PM_DECEASED_DATE`,`PM_FIRST_NAME`,`PM_GENDER`,`PM_LAST_NAME`,`PM_MARITAL_STATUS`,`PM_MIDDLE_NAME`,`PM_NICK_NAME`,`PM_PASSPORT_EXPIRATION_DATE`,`PM_PASSPORT_NUMBER`,`PM_SALUTAION`,`PM_SSN`,`PM_SUFFIX`,`PM_PARTY_ID`) VALUES 
 ('1987-04-23 00:00:00',NULL,NULL,'Hrishikesh','M','Joshi',NULL,'',NULL,NULL,NULL,'Mr.',NULL,NULL,1),
 ('2004-04-02 00:00:00',NULL,NULL,'Nachiket','M','Bordekar',NULL,'A',NULL,NULL,NULL,'Mr.',NULL,NULL,2);
/*!40000 ALTER TABLE `pm_person` ENABLE KEYS */;


--
-- Definition of table `prod_product`
--

DROP TABLE IF EXISTS `prod_product`;
CREATE TABLE `prod_product` (
  `PD_PRODUCT_ID` int(20) NOT NULL AUTO_INCREMENT,
  `PD_PRODUCT_TYPE_ID` int(11) NOT NULL,
  `PD_INTRODUCTION_DATE` datetime DEFAULT NULL,
  `PD_SUPPORT_DISCONTINUATION_DATE` datetime DEFAULT NULL,
  `PD_SALES_DISCONTINUATION_DATE` datetime DEFAULT NULL,
  `PD_SALES_DISC_WHEN_NOT_AVAIL` bit(1) DEFAULT NULL,
  `PD_INTERNAL_NAME` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_COMMENTS` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_PRODUCT_NAME` varchar(100) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_REQUIRE_INVENTORY` bit(1) DEFAULT NULL,
  `PD_QUANTITY_UOM` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_QUANTITY_INCLUDED` decimal(18,6) DEFAULT NULL,
  `PD_PIECES_INCLUDED` decimal(20,0) DEFAULT NULL,
  `PD_REQUIRE_AMOUNT` bit(1) DEFAULT NULL,
  `PD_FIXED_AMOUNT` decimal(18,2) DEFAULT NULL,
  `PD_AMOUNT_UOM_TYPE` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_WEIGHT_UOM_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_WEIGHT` decimal(18,6) DEFAULT NULL,
  `PD_RETURNABLE` bit(1) DEFAULT NULL,
  `PD_TAXABLE` bit(1) DEFAULT NULL,
  `PD_IS_VIRTUAL` bit(1) DEFAULT NULL,
  `PD_CREATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`PD_PRODUCT_ID`),
  KEY `FK_PROD_PRODUCT_TYPE_ID` (`PD_PRODUCT_TYPE_ID`),
  CONSTRAINT `FK_PROD_PRODUCT_TYPE_ID` FOREIGN KEY (`PD_PRODUCT_TYPE_ID`) REFERENCES `prod_product_type` (`PT_PRODUCT_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `prod_product`
--

/*!40000 ALTER TABLE `prod_product` DISABLE KEYS */;
INSERT INTO `prod_product` (`PD_PRODUCT_ID`,`PD_PRODUCT_TYPE_ID`,`PD_INTRODUCTION_DATE`,`PD_SUPPORT_DISCONTINUATION_DATE`,`PD_SALES_DISCONTINUATION_DATE`,`PD_SALES_DISC_WHEN_NOT_AVAIL`,`PD_INTERNAL_NAME`,`PD_COMMENTS`,`PD_PRODUCT_NAME`,`PD_DESCRIPTION`,`PD_REQUIRE_INVENTORY`,`PD_QUANTITY_UOM`,`PD_QUANTITY_INCLUDED`,`PD_PIECES_INCLUDED`,`PD_REQUIRE_AMOUNT`,`PD_FIXED_AMOUNT`,`PD_AMOUNT_UOM_TYPE`,`PD_WEIGHT_UOM_ID`,`PD_WEIGHT`,`PD_RETURNABLE`,`PD_TAXABLE`,`PD_IS_VIRTUAL`,`PD_CREATED_DATE`) VALUES 
 (1,1,'2012-04-11 22:05:17',NULL,NULL,NULL,'XYZ TRIP','XYZ TRIP','XYZ TRIP','XYZ TRIP',NULL,'PER 1 PERSON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (4,1,'2012-04-14 17:56:18',NULL,NULL,NULL,'Demo1','Demo1','Demo1','Demo1',NULL,'PER 1 PERSON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (5,1,'2012-04-22 00:43:27',NULL,NULL,NULL,'Dapoli Trip','Dapoli Trip','Dapoli Trip','Dapoli Trip',NULL,'PER 1 PERSON',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `prod_product` ENABLE KEYS */;


--
-- Definition of table `prod_product_price`
--

DROP TABLE IF EXISTS `prod_product_price`;
CREATE TABLE `prod_product_price` (
  `PP_PROD_PRODUCT_PRICE_ID` int(11) NOT NULL,
  `PP_PRODUCT_ID` int(11) NOT NULL,
  `PP_PRODUCT_PRICE_TYPE_ID` int(11) NOT NULL,
  `PP_CURRENCY_UOM_ID` varchar(20) DEFAULT 'INR',
  `PP_FROM_DATE` datetime NOT NULL,
  `PP_TO_DATE` datetime DEFAULT NULL,
  `PP_PRICE` decimal(18,3) DEFAULT NULL,
  PRIMARY KEY (`PP_PROD_PRODUCT_PRICE_ID`),
  KEY `PROD_PRICE_PROD` (`PP_PRODUCT_ID`),
  KEY `PROD_PRICE_TYPE` (`PP_PRODUCT_PRICE_TYPE_ID`),
  CONSTRAINT `PROD_PRICE_PROD` FOREIGN KEY (`PP_PRODUCT_ID`) REFERENCES `prod_product` (`PD_PRODUCT_ID`),
  CONSTRAINT `PROD_PRICE_TYPE` FOREIGN KEY (`PP_PRODUCT_PRICE_TYPE_ID`) REFERENCES `prod_product_price_type` (`PT_PRODUCT_PRICE_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `prod_product_price`
--

/*!40000 ALTER TABLE `prod_product_price` DISABLE KEYS */;
INSERT INTO `prod_product_price` (`PP_PROD_PRODUCT_PRICE_ID`,`PP_PRODUCT_ID`,`PP_PRODUCT_PRICE_TYPE_ID`,`PP_CURRENCY_UOM_ID`,`PP_FROM_DATE`,`PP_TO_DATE`,`PP_PRICE`) VALUES 
 (1,1,1,'INR','2012-04-11 22:05:17','2013-04-11 22:05:17','200.000'),
 (5,4,1,'INR','2012-04-14 17:56:18','2013-04-14 17:56:18','100.000'),
 (6,5,1,'INR','2012-04-22 00:43:27','2013-04-22 00:43:27','1000.000');
/*!40000 ALTER TABLE `prod_product_price` ENABLE KEYS */;


--
-- Definition of table `prod_product_price_action_type`
--

DROP TABLE IF EXISTS `prod_product_price_action_type`;
CREATE TABLE `prod_product_price_action_type` (
  `PA_PRODUCT_PRICE_ACTION_TYPE_ID` int(11) NOT NULL,
  `PA_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  PRIMARY KEY (`PA_PRODUCT_PRICE_ACTION_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `prod_product_price_action_type`
--

/*!40000 ALTER TABLE `prod_product_price_action_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_product_price_action_type` ENABLE KEYS */;


--
-- Definition of table `prod_product_price_type`
--

DROP TABLE IF EXISTS `prod_product_price_type`;
CREATE TABLE `prod_product_price_type` (
  `PT_PRODUCT_PRICE_TYPE_ID` int(11) NOT NULL,
  `PT_DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PT_PRODUCT_PRICE_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `prod_product_price_type`
--

/*!40000 ALTER TABLE `prod_product_price_type` DISABLE KEYS */;
INSERT INTO `prod_product_price_type` (`PT_PRODUCT_PRICE_TYPE_ID`,`PT_DESCRIPTION`) VALUES 
 (1,'LIST_PRICE');
/*!40000 ALTER TABLE `prod_product_price_type` ENABLE KEYS */;


--
-- Definition of table `prod_product_type`
--

DROP TABLE IF EXISTS `prod_product_type`;
CREATE TABLE `prod_product_type` (
  `PT_PRODUCT_TYPE_ID` int(11) NOT NULL,
  `PT_PRODUCT_TYPE_DESC` varchar(255) NOT NULL,
  PRIMARY KEY (`PT_PRODUCT_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prod_product_type`
--

/*!40000 ALTER TABLE `prod_product_type` DISABLE KEYS */;
INSERT INTO `prod_product_type` (`PT_PRODUCT_TYPE_ID`,`PT_PRODUCT_TYPE_DESC`) VALUES 
 (1,'SERVICE');
/*!40000 ALTER TABLE `prod_product_type` ENABLE KEYS */;


--
-- Definition of table `so_sales_det`
--

DROP TABLE IF EXISTS `so_sales_det`;
CREATE TABLE `so_sales_det` (
  `SO_DET_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SO_COST` decimal(10,2) DEFAULT NULL,
  `SO_DISCOUNT` decimal(10,2) DEFAULT NULL,
  `SO_ITEM_ID` int(11) NOT NULL,
  `SO_LINE_NO` int(11) NOT NULL,
  `SO_LOCATION` varchar(255) DEFAULT NULL,
  `SO_LOT_NO` varchar(255) DEFAULT NULL,
  `SO_ORD_TYPE` varchar(50) NOT NULL,
  `SO_PRICE` decimal(10,2) DEFAULT NULL,
  `SO_QTY_ORD` decimal(10,2) DEFAULT NULL,
  `SO_UOM` varchar(50) NOT NULL,
  `SO_WEIGHT` decimal(10,2) DEFAULT NULL,
  `SO_SALES_ID` int(11) NOT NULL,
  `SD_DET_ID` int(11) DEFAULT NULL,
  `SD_COST` decimal(10,2) DEFAULT NULL,
  `SD_DISCOUNT` decimal(10,2) DEFAULT NULL,
  `SD_ITEM_ID` int(11) DEFAULT NULL,
  `SD_LINE_NO` int(11) DEFAULT NULL,
  `SD_LOCATION` varchar(255) DEFAULT NULL,
  `SD_LOT_NO` varchar(255) DEFAULT NULL,
  `SD_ORD_TYPE` varchar(50) DEFAULT NULL,
  `SD_PRICE` decimal(10,2) DEFAULT NULL,
  `SD_QTY_ORD` decimal(10,2) DEFAULT NULL,
  `SD_UOM` varchar(50) DEFAULT NULL,
  `SD_WEIGHT` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`SO_DET_ID`),
  KEY `FKB99EF3FDD1B57600` (`SO_SALES_ID`),
  CONSTRAINT `FKB99EF3FDD1B57600` FOREIGN KEY (`SO_SALES_ID`) REFERENCES `so_sales_hdr` (`SO_SALES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `so_sales_det`
--

/*!40000 ALTER TABLE `so_sales_det` DISABLE KEYS */;
/*!40000 ALTER TABLE `so_sales_det` ENABLE KEYS */;


--
-- Definition of table `so_sales_hdr`
--

DROP TABLE IF EXISTS `so_sales_hdr`;
CREATE TABLE `so_sales_hdr` (
  `SO_SALES_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SO_CAN_DATE` datetime DEFAULT NULL,
  `SO_CARRIER` varchar(50) DEFAULT NULL,
  `SO_CUR_CODE` varchar(50) NOT NULL,
  `SO_MODE_PAY` varchar(50) DEFAULT NULL,
  `SO_ORD_DATE` datetime NOT NULL,
  `SO_ORD_TYPE` varchar(50) NOT NULL,
  `SO_PARTY_ID` int(11) NOT NULL,
  `SO_SHIP_CHARGES` double DEFAULT NULL,
  `SO_SHIP_DATE` datetime DEFAULT NULL,
  `SO_SHIP_TYPE` varchar(50) DEFAULT NULL,
  `SO_STATUS` varchar(50) NOT NULL,
  `SO_TOT_AMT` double DEFAULT NULL,
  `SO_TOT_QTY` double DEFAULT NULL,
  `SO_TOT_TAX` double DEFAULT NULL,
  `SO_TOT_WEIGHT` double DEFAULT NULL,
  PRIMARY KEY (`SO_SALES_ID`),
  UNIQUE KEY `SO_SALES_ID` (`SO_SALES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `so_sales_hdr`
--

/*!40000 ALTER TABLE `so_sales_hdr` DISABLE KEYS */;
/*!40000 ALTER TABLE `so_sales_hdr` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
