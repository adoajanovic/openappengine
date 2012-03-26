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
-- Create schema openapps_d01
--

CREATE DATABASE IF NOT EXISTS openapps_d01;
USE openapps_d01;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ab_address_book`
--

/*!40000 ALTER TABLE `ab_address_book` DISABLE KEYS */;
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
INSERT INTO `co_code_type` (`CT_CODE_TYPE_ID`,`CT_CODE_TYPE_VALUE`) VALUES 
 (18,'Errors1'),
 (19,'Teams'),
 (20,'asdada'),
 (21,'1111'),
 (23,'Hrishikesh'),
 (24,'Mom');
/*!40000 ALTER TABLE `co_code_type` ENABLE KEYS */;


--
-- Definition of table `fm_invoice`
--

DROP TABLE IF EXISTS `fm_invoice`;
CREATE TABLE `fm_invoice` (
  `IN_INVOICE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IN_INVOICE_TYPE_ID` int(11) DEFAULT NULL,
  `IN_PARTY_ID_FROM` int(11) DEFAULT NULL,
  `IN_PARTY_ID` int(11) DEFAULT NULL,
  `IN_ROLE_TYPE_ID` int(11) DEFAULT NULL,
  `IN_STATUS_DESC` varchar(255) COLLATE latin1_general_cs NOT NULL,
  `IN_BILLING_ACCOUNT_ID` int(11) DEFAULT NULL,
  `IN_CONTACT_MECH_ID` int(11) DEFAULT NULL,
  `IN_INVOICE_DATE` datetime DEFAULT NULL,
  `IN_DUE_DATE` datetime DEFAULT NULL,
  `IN_PAID_DATE` datetime DEFAULT NULL,
  `IN_INVOICE_MESSAGE` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_REFERENCE_NUMBER` varchar(60) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_RECURRENCE_INFO_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  PRIMARY KEY (`IN_INVOICE_ID`),
  KEY `INVOICE_INVTYP` (`IN_INVOICE_TYPE_ID`),
  KEY `INVOICE_PARTY_FRM` (`IN_PARTY_ID_FROM`),
  KEY `INVOICE_PARTY` (`IN_PARTY_ID`),
  KEY `INVOICE_ROLETYP` (`IN_ROLE_TYPE_ID`),
  KEY `INVOICE_STTSITM` (`IN_STATUS_DESC`),
  KEY `INVOICE_BILLACCT` (`IN_BILLING_ACCOUNT_ID`),
  KEY `INVOICE_CMECH` (`IN_CONTACT_MECH_ID`),
  CONSTRAINT `FK_IN_FROM_PARTY_ID` FOREIGN KEY (`IN_PARTY_ID_FROM`) REFERENCES `pm_party` (`PM_PARTY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_IN_PARTY_CONTACT_MECH` FOREIGN KEY (`IN_CONTACT_MECH_ID`) REFERENCES `pm_party_contact_mech` (`PM_CONTACT_MECH_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_IN_PARTY_ID` FOREIGN KEY (`IN_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_invoice`
--

/*!40000 ALTER TABLE `fm_invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_invoice` ENABLE KEYS */;


--
-- Definition of table `fm_invoice_item`
--

DROP TABLE IF EXISTS `fm_invoice_item`;
CREATE TABLE `fm_invoice_item` (
  `IT_INVOICE_ID` int(11) NOT NULL,
  `IT_INVOICE_ITEM_SEQ_ID` int(11) NOT NULL,
  `IT_INVOICE_ITEM_TYPE_ID` int(11) DEFAULT NULL,
  `IT_INVENTORY_ITEM_ID` int(20) DEFAULT NULL,
  `IT_PRODUCT_ID` int(11) DEFAULT NULL,
  `IT_PRODUCT_FEATURE_ID` int(11) DEFAULT NULL,
  `IT_TAXABLE_FLAG` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `IT_QUANTITY` decimal(18,6) DEFAULT NULL,
  `IT_AMOUNT` decimal(18,3) DEFAULT NULL,
  `IT_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  PRIMARY KEY (`IT_INVOICE_ID`,`IT_INVOICE_ITEM_SEQ_ID`),
  CONSTRAINT `FK_INVOICE_ID` FOREIGN KEY (`IT_INVOICE_ID`) REFERENCES `fm_invoice` (`IN_INVOICE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `fm_invoice_item`
--

/*!40000 ALTER TABLE `fm_invoice_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `fm_invoice_item` ENABLE KEYS */;


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
INSERT INTO `fms_fleet_vehicle` (`FV_VEHICLE_ID`,`FV_TYPE_ID`,`FV_VEHICLE_MODEL`,`FV_VEHICLE_MAKE`,`FV_LICENCE_PLATE_NUMBER`,`FV_FROM_DATE`,`FV_TO_DATE`,`FV_STATUS`) VALUES 
 (25,10,'Model1','Make1','MH01-1234-8765','2012-03-26','2013-03-26','ACTIVE');
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
INSERT INTO `fms_fleet_vehicle_sequence` (`value`) VALUES 
 (0);
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
INSERT INTO `fms_fleet_vehicle_type` (`FT_FLEET_VEHICLE_TYPE_ID`,`FT_FLEET_TYPE_DESC`) VALUES 
 (6,' Varad1'),
 (17,'2'),
 (19,'A'),
 (18,'asdasd'),
 (20,'B'),
 (9,'Bus'),
 (14,'Hi1'),
 (15,'Hrishikesh'),
 (23,'Nachi'),
 (24,'NachiketB'),
 (16,'Sumedh1'),
 (13,'Sumo'),
 (22,'Tanmay'),
 (10,'Tempo'),
 (12,'Truck');
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
INSERT INTO `fms_fleet_vehicle_type_sequence` (`value`) VALUES 
 (25);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm_party`
--

/*!40000 ALTER TABLE `pm_party` DISABLE KEYS */;
INSERT INTO `pm_party` (`PM_PARTY_ID`,`PM_DESCRIPTION`,`PM_EXTERNAL_ID`,`PM_PARTY_TYPE`,`PM_PREFERRED_CURRENCY_UOM`,`PM_STATUS`) VALUES 
 (1,'awd','1000000','CUSTOMER','INR','Active');
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pm_party_contact_mech`
--

/*!40000 ALTER TABLE `pm_party_contact_mech` DISABLE KEYS */;
/*!40000 ALTER TABLE `pm_party_contact_mech` ENABLE KEYS */;


--
-- Definition of table `pm_person`
--

DROP TABLE IF EXISTS `pm_person`;
CREATE TABLE `pm_person` (
  `PM_BIRTH_DATE` datetime DEFAULT NULL,
  `PM_COMMENTS` text,
  `PM_DECEASED_DATE` datetime DEFAULT NULL,
  `PM_FIRST_NAME` varchar(100) NOT NULL,
  `PM_GENDER` bit(1) DEFAULT NULL,
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
  `PD_SALES_DISC_WHEN_NOT_AVAIL` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_INTERNAL_NAME` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_COMMENTS` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_PRODUCT_NAME` varchar(100) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_REQUIRE_INVENTORY` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_QUANTITY_UOM_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_QUANTITY_INCLUDED` decimal(18,6) DEFAULT NULL,
  `PD_PIECES_INCLUDED` decimal(20,0) DEFAULT NULL,
  `PD_REQUIRE_AMOUNT` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_FIXED_AMOUNT` decimal(18,2) DEFAULT NULL,
  `PD_AMOUNT_UOM_TYPE_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_WEIGHT_UOM_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_WEIGHT` decimal(18,6) DEFAULT NULL,
  `PD_RETURNABLE` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_TAXABLE` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_IS_VIRTUAL` char(1) COLLATE latin1_general_cs DEFAULT NULL,
  `PD_CREATED_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`PD_PRODUCT_ID`),
  KEY `FK_PROD_PRODUCT_TYPE_ID` (`PD_PRODUCT_TYPE_ID`),
  CONSTRAINT `FK_PROD_PRODUCT_TYPE_ID` FOREIGN KEY (`PD_PRODUCT_TYPE_ID`) REFERENCES `prod_product_type` (`PT_PRODUCT_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

--
-- Dumping data for table `prod_product`
--

/*!40000 ALTER TABLE `prod_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_product` ENABLE KEYS */;


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
