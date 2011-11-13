------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- OPENAPPENGINE DB SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- HELP
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- MONEY : DECIMAL(10,2)
-- RANGE : DATE

------------------------------------------------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CO : COMMON SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---
--- CO : CURRENCY
---
CREATE TABLE `CO_CURRENCY` (
  `CU_CURRENCY_ID int(11) NOT NULL auto_increment
  `CU_CLIENT_ID` int(11) NOT NULL,
  `CU_ORGANIZATION_ID` int(11) NOT NULL,
  `CU_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `CU_ISO_CODE` varchar(3),
  `CU_CURRENCY_SYMBOL` varchar (10) NOT NULL,
  `CU_DESCRIPTION` varchar (255),
  `CU_STANDARD_PRECISION` double (10),
  `CU_COSTING_PRECISION` double (10),
  `CU_PRICE_PRECISION` double (10),
  `CU_IS_SYMBOL_RIGHT_SIDE` char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY  (`CU_CURRENCY_ID`)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CFG : CONFIGURATION SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--
-- CFG : NAVIGATION MENU
--
CREATE TABLE `CFG_NAVIGATION_MENU` (
  `NM_NAVIGATION_MENU_ID` int(11) NOT NULL auto_increment,
  `NM_NAVIGATION_MENU_VALUE` varchar(255) NOT NULL,
  `NM_NAVIGATION_MENU_TITLE` varchar(255) NOT NULL,
  `NM_NAVIGATION_MENU_ACTION` varchar(255) NOT NULL,
  PRIMARY KEY  (`NL_NAVIGATION_MENU_ID`)
);

--
-- CFG : NAVIGATION MENU ITEM
--
CREATE TABLE `CFG_NAVIGATION_MENU_ITEM` (
  `NM_NAVIGATION_MENU_ITEM_ID` int(11) NOT NULL auto_increment,
  `NM_NAVIGATION_PARENT_MENU_ID` int(11) NOT NULL,
  `NM_NAVIGATION_PARENT_MENU_ITEM_ID` int(11) NOT NULL,
  `NM_HAS_CHILDREN` char(1) NOT NULL DEFAULT 'N',
  `NM_NAVIGATION_MENU_ITEM_VALUE` varchar(255) NOT NULL,
  `NM_NAVIGATION_MENU_ITEM_TITLE` varchar(255) NOT NULL,
  `NM_NAVIGATION_MENU_ITEM_ACTION` varchar(255) NOT NULL,
  PRIMARY KEY  (`NM_NAVIGATION_MENU_ITEM_ID`)
);

--
-- CFG : DATABASE VERSION
--
CREATE TABLE `CFG_DB_VERSION` (
  `DV_DB_VERSION_ID` int(11) NOT NULL auto_increment,
  `DV_IS_ACTIVE` char(1) NOT NULL DEFAULT 'N',
  `DV_VERSION_NUMBER` varchar(255) NOT NULL,
  `DV_ADDED_BY` varchar(255) NOT NULL,
  `DV_ADDED_ON` varchar(255) NOT NULL,
  `DV_ADD_COMMENT` varchar(255) NOT NULL,
  PRIMARY KEY  (`DV_DB_VERSION_ID`)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- CL : CLIENT SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--
-- CL : CLIENT
--
CREATE TABLE `CL_CLIENT` (
  `CL_CLIENT_ID` int(11) NOT NULL auto_increment,
  `CL_ORGANIZATION_ID` int(11) NOT NULL,
  `CL_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `CL_VALUE` varchar(40) NOT NULL,
  `CL_NAME` varchar (60) NOT NULL,
  `CL_DESCRIPTION` varchar (255),
  `CL_SMTPHOST` varchar (60),
  `CL_REQUEST_EMAIL` varchar (60),
  `CL_REQUEST_USER` varchar (20),
  `CL_REQUESTUSER_PASSWORD` varchar (60),
  `CL_REQUESTUSER_FOLDER` varchar (20),
  `CL_LANGUAGE` varchar (6),
  `CL_IS_MULTILINGUAL_DOCUMENT` char(1) NOT NULL DEFAULT 'Y',
  `CL_IS_SMTP_AUTHORIZATION` char(1) NOT NULL DEFAULT 'Y',
  `CL_CURRENCYID` varchar (6),
   PRIMARY KEY  (`CL_CLIENT_ID`)
);

--
-- CL : CLIENT ORGANIZATION
--
CREATE TABLE `CL_CLIENT_ORGANIZATION` (
  `CO_ORGANIZATION_ID` int(11) NOT NULL auto_increment,
  `CO_CLIENT_ID` int(11) NOT NULL,
  `CO_IS_ACTIVE` char(1) NOT NULL DEFAULT 'N',
  `CO_ORGANIZATION_NAME` varchar(60) NOT NULL,
  `CO_ORGANIZATION_DESCRIPTION` varchar(255) NOT NULL,
  `CO_ORGANIZATION_TYPE_ID` int(11) NOT NULL,
  `CO_IS_READY` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY  (`CO_ORGANIZATION_ID`)
);

--
-- CL : CLIENT ORGANIZATION TYPE
--
CREATE TABLE `CL_ORGANIZATION_TYPE` (
  `OT_ORGANIZATION_TYPE_ID` int(11) NOT NULL auto_increment,
  `OT_ORGANIZATION_TYPE_NAME` varchar(60) NOT NULL,
  `OT_ORGANIZATION_TYPE_DESCRIPTION` varchar(255) NOT NULL,
   PRIMARY KEY  (`OT_ORGANIZATION_TYPE_ID`)
);

--
-- CL : USER
--
CREATE TABLE `CL_USER` (
  `CU_USER_ID` int(11) NOT NULL auto_increment,
  `CU_CLIENT_ID` int(11) NOT NULL,
  `CU_ORGANIZATION_ID` int(11) NOT NULL,
  `CU_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `CU_USER_NAME` varchar(60) NOT NULL,
  `CU_USER_DESCRIPTION` varchar(255) NOT NULL,
  `CU_EMAIL_ADDRESS` varchar (60),
  `CU_USER_PASSWORD` varchar (255),
  `CU_EMAIL_USER` varchar (60),
  `CU_EMAIL_SERVER_PASSWORD` varchar (60),
  `CU_SUPERVISOR_ID` int(11),
  `CU_PROCESSING` char(1) NOT NULL DEFAULT 'Y',
  `CU_TITLE` varchar(40) NOT NULL,
  `CU_COMMENTS` varchar(2000) NOT NULL,
  `CU_PHONE` varchar (40),
  `CU_PHONE2` varchar (40),
  `CU_FAX` varchar (40),
  `CU_BIRTHDATE` varchar (40),
  `CU_FIRST_NAME` varchar (40),
  `CU_LAST_NAME` varchar (40),
  `CU_ROLE_ID` varchar (40),
  `CU_IS_LOCKED` char(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY  (`CU_USER_ID`)
);
  
--
-- CL : ROLE
--
CREATE TABLE `CL_ROLE` (
  `CR_ROLE_ID` int(11) NOT NULL auto_increment,
  `CR_CLIENT_ID` int(11) NOT NULL,
  `CR_ORGANIZATION_ID` int(11) NOT NULL,
  `CR_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `CR_ROLE_NAME` varchar(60) NOT NULL,
  `CR_ROLE_DESCRIPTION` varchar(255) NOT NULL,
  `CR_ROLE_LEVEL` varchar(60) NOT NULL,
  `CR_AMOUNT_APPROVAL` NUMBER,
  PRIMARY KEY  (`CR_ROLE_ID`)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- PLM : PRODUCT LIFECYCLE MANAGEMENT SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--
-- PLM PRODUCT MASTER
--
CREATE TABLE `PLM_PRODUCT` (
  `PD_PRODUCT_ID` int(11) NOT NULL auto_increment,
  `PD_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `PD_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `PD_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PD_NAME` varchar(100) NOT NULL,
  `PD_DESCRIPTION` varchar(255) NULL,
  `PD_DOCUMENT_NOTE` varchar(255) NULL,
  `PD_HELP_TXT` varchar(255) NULL,
  `PD_BAR_CODE` varchar(1000) NULL,
  `PD_UOM_ID` int(11) NOT NULL,
  `PD_IS_STOCKED` char(1) NOT NULL DEFAULT 'N',
  `PD_IS_PURCHASED` char(1) NOT NULL DEFAULT 'N',
  `PD_IS_SOLD` char(1) NOT NULL DEFAULT 'N',
  `PD_IS_BOM` char(1) NOT NULL DEFAULT 'N',
  `PD_PRINT_DETAILS_ON_INVOICE` char(1) NOT NULL DEFAULT 'N',
  `PD_PRINT_DETAILS_ON_PICK_LIST` char(1) NOT NULL DEFAULT 'N',
  `PD_IS_BOM_VERIFIED` char(1) NOT NULL DEFAULT 'N',
  `PD_PRODUCT_CATEGORY_ID` int(11) NOT NULL,
  `PD_PRODUCT_VOLUME` double NULL DEFAULT 0.0,
  `PD_PRODUCT_WEIGHT` double NULL DEFAULT 0.0,
  `PD_PRODUCT_SHELF_HEIGHT` double NULL DEFAULT 0.0,
  `PD_PRODUCT_SHELF_WIDTH` double NULL DEFAULT 0.0,
  `PD_PRODUCT_SHELF_DEPTH` double NULL DEFAULT 0.0,
  `PD_TAX_CATEGORY_ID` int(11) NOT NULL,
  `PD_IS_DISCONTINUED` char(1) NOT NULL DEFAULT 'N',
  `PD_DISCONTINUED_BY` varchar(255) NOT NULL,
  `PD_EXPENSE_REPORT_TYPE_ID` int(11) NOT NULL,
  `PD_PRODUCT_TYPE_TYPE_ID` int(11) NOT NULL, --    PLM_PRODUCT_TYPE : E (Expense type),I (Item),O (Online),R (Resource),S (Service) 
  `PD_IMAGE_URL` varchar(255) NULL,
  `PD_GUARANTEE_DAYS` int(11) NOT NULL DEFAULT 0,
  `PD_VERSION_NUMBER` varchar(255) NULL,
  `PD_FREIGHT_CATEGORY_ID` int(11) NOT NULL DEFAULT 0,
  `PD_LOCATOR_ID` int(11) NOT NULL DEFAULT 0, -- PLM_PRODUCT_LOCATOR 
  `PD_COST_TYPE_ID` int(11) NOT NULL DEFAULT 0, --  PLM_COST_TYPE :  AV (Average),ST (Standard) 
  `PD_STANDARD_COST` double NULL DEFAULT 0.0,
  `PD_QUANTITY_MAX` double NULL DEFAULT 0.0,
  `PD_QUANTITY_MIN` double NULL DEFAULT 0.0,
  `PD_QUANTITY_STD` double NULL DEFAULT 0.0,
  `PD_QUANTITY_SAFETY_STOCK` double NULL DEFAULT 0.0,
  PRIMARY KEY  (`PD_PRODUCT_ID`)
);

--
-- PLM : LOT
--
CREATE TABLE `PLM_LOT` (
  `LT_LOT_ID` int(11) NOT NULL auto_increment,
  `LT_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `LT_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `LT_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `LT_NAME` varchar(60) NOT NULL,
  `LT_DESCRIPTION` varchar(255) NOT NULL,
  `LT_PRODUCT_ID` int(11) NOT NULL DEFAULT 0, --PLM_PRODUCT
  PRIMARY KEY  (`LT_LOT_ID`)
);

--
-- PLM : PRODUCT CATEGORY
--
CREATE TABLE `PLM_PRODUCT_CATEGORY` (
  `PC_PRODUCT_CATEGORY_ID` int(11) NOT NULL auto_increment,
  `PC_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `PC_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `PC_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PC_VALUE` varchar(100) NOT NULL,
  `PC_NAME` varchar(100) NOT NULL,
  `PC_DESCRIPTION` varchar(100) NOT NULL,
  PRIMARY KEY  (`PC_PRODUCT_CATEGORY_ID`)
);

--
-- PLM : COST TYPE
--
CREATE TABLE `PLM_COST_TYPE` (
  `CT_COST_TYPE_ID` int(11) NOT NULL auto_increment,
  `CT_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `CT_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `CT_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `CT_COST_TYPE_CODE` varchar(100) NOT NULL,
  `CT_COST_TYPE_VALUE` varchar(100) NOT NULL,
  `CT_COST_TYPE_DESCRIPTION` varchar(100) NOT NULL,
  PRIMARY KEY  (`CT_COST_TYPE_ID`)
);

--
-- PLM : PRODUCT TYPE
--
CREATE TABLE `PLM_PRODUCT_TYPE` (
  `PT_PRODUCT_TYPE_ID` int(11) NOT NULL auto_increment,
  `PT_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `PT_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `PT_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PT_PRODUCT_TYPE_CODE` varchar(100) NOT NULL,
  `PT_PRODUCT_TYPE_VALUE` varchar(100) NOT NULL,
  `PT_PRODUCT_TYPE_DESCRIPTION` varchar(100) NOT NULL,
  PRIMARY KEY  (`PT_PRODUCT_TYPE_ID`)
);

--
-- PLM PRODUCT LOCATOR
--
CREATE TABLE `PLM_PRODUCT_LOCATOR` (
  `PL_PRODUCT_LOCATOR_ID` int(11) NOT NULL auto_increment,
  `PL_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `PL_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `PL_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PL_LOCATOR_VALUE` varchar(100) NOT NULL,
  `PL_LOCATOR_X_ROW` varchar(100) NOT NULL,
  `PL_LOCATOR_Y_STACK` varchar(100) NOT NULL,
  `PL_LOCATOR_Z_LEVEL` varchar(100) NOT NULL,
  PRIMARY KEY  (`PL_PRODUCT_LOCATOR_ID`)
);

--
-- PLM : WAREHOUSE
--
CREATE TABLE `PLM_WAREHOUSE` (
  `WH_WAREHOUSE_ID` int(11) NOT NULL auto_increment,
  `WH_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `WH_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `WH_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `WH_VALUE` varchar(100) NOT NULL,
  `WH_NAME` varchar(100) NOT NULL,
  `WH_DESCRIPTION` varchar(255) NOT NULL,
  `WH_LOCATION_ID` int(11) NOT NULL DEFAULT 0, -- REFERENCES TO THE ADDRESS BOOK
  `WH_IS_SHIPPER` char(1) NOT NULL DEFAULT 'N',
  `WH_FROM_DOCUMENT_NUMBER` varchar(255) NOT NULL,
  `WH_TO_DOCUMENT_NUMBER` varchar(255) NOT NULL,
  PRIMARY KEY  (`WH_WAREHOUSE_ID`)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- FM : FINANCIAL MANAGEMENT SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---
--- FINANIAL MANAGEMENT : PAYMENT TERM
---
CREATE TABLE `FM_PAYMENT_TERMS` (
  `PYT_PAYMENT_TERM_ID int(11) NOT NULL auto_increment
  `PYT_CLIENT_ID` int(11) NOT NULL,
  `PYT_ORGANIZATION_ID` int(11) NOT NULL,
  `PYT_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PYT_NAME` varchar (60) NOT NULL,
  `PYT_DESCRIPTION` varchar (255),
  `PYT_DOCUMENT_NOTE` varchar (2000),
  `PYT_IS_DUE_FIXED` char(1) NOT NULL DEFAULT 'Y',
  `PYT_NET_DAYS` double (10) NOT NULL,
  `PYT_FIXED_MONTH_DAY` double (10),
  `PYT_FIXED_MONTH_OFFSET` double (10),
  `PYT_IS_NEXT_BUSINESS_DAY` char(1) DEFAULT 'Y',
  `PYT_IS_DEFAULT` char(1) DEFAULT 'Y',
  `PYT_VALUE` varchar (40) NOT NULL,
  `PYT_NET_DAY` varchar (60) ,
  `PYT_IS_VALID` char(1) DEFAULT 'Y',   
  `PYT_FIXED_MONTH_DAY2` double (10),
  `PYT_FIXED_MONTH_DAY3` double (10)
);

--
-- ORDER
--
CREATE TABLE `FM_ORDER` (
  `OR_ORDER_ID` int(11) NOT NULL auto_increment,
  `OR_PARTY_ID` varchar(50) NOT NULL,
  `OR_ORGANIZATION_ID` varchar(50) NOT NULL,
  `OR_IS_ACTIVE` char(1) NOT NULL DEFAULT 'T',
  `OR_IS_ORDER_TRX` char(1) NOT NULL DEFAULT 'F',
  `OR_DOCUMENT_NUMBER` varchar(50) NOT NULL,
  `OR_DOCUMENT_STATUS` varchar(50) NOT NULL,
  `OR_DOCUMENT_ACTION` varchar(50) NULL,
  `OR_IS_PROCESSED_NOW` char(1) NOT NULL DEFAULT 'F',
  `OR_IS_PROCESS_COMPLETE` char(1) NOT NULL DEFAULT 'F',
  `OR_DOCUMENT_TYPE_ID` int(11) NOT NULL,
  `OR_DOCUMENT_TYPE_TARGET_ID` int(11) NOT NULL,
  `OR_DESCRIPTION` varchar(255) NOT NULL,
  `OR_IS_DELIVERED` char(1) NOT NULL DEFAULT 'F',
  `OR_IS_INVOICED` char(1) NOT NULL DEFAULT 'F',
  `OR_IS_SELECTED` char(1) NOT NULL DEFAULT 'F',
  `OR_SALES_REP_ID` int(11) NULL,
  `OR_DATE_ORDERED` datetime DEFAULT NOT NULL,
  `OR_DATE_PROMISED` datetime DEFAULT NULL,
  `OR_DATE_PRINTED` datetime DEFAULT NULL,
  `OR_DATE_ACCTG` datetime DEFAULT NULL,
  `OR_BUS_PARTNER_ID` int(11) NOT NULL,
  `OR_BILL_TO_ID` int(11) NOT NULL,
  `OR_BUS_PARTNER_LOC_ID` int(11) NOT NULL,
  `OR_PO_REFERENCE` varchar(255) NOT NULL,
  `OR_IS_DISCOUNT_PRINTED` char(1) NOT NULL DEFAULT 'F',
  `OR_CURRENCY_ID` int(11) NOT NULL,
  `OR_PAYMENT_RULE_ID` int(11) NOT NULL,
  `OR_PAYMENT_TERM_ID` int(11) NOT NULL,
  `OR_INVOICE_RULE_ID` int(11) NOT NULL,
  `OR_DELIVERY_RULE_ID` int(11) NOT NULL,
  `OR_FREIGHT_COST_RULE_ID` int(11) NOT NULL,
  `OR_DELIVERY_METHOD_ID` int(11) NOT NULL,
  `OR_DELIVERY_SHIPPER_ID` int(11) NULL,
  `OR_CHARGE` double NULL,
  `OR_CHARGE_AMOUNT` double NOT NULL DEFAULT 0.0,
  `OR_PRIORITY_VALUE` int(11) NOT NULL DEFAULT 2,
  `OR_SUMMED_LINE_AMOUNT` double NOT NULL DEFAULT 0.0,
  `OR_GRAND_TOTAL` double NOT NULL DEFAULT 0.0,
  `OR_PRICE_LIST_ID` int(11) NOT NULL,
  `OR_IS_TAX_INCLUDED` char(1) NOT NULL DEFAULT 'N',
  `OR_CAMPAIGN_ID` int(11) NOT NULL DEFAULT 0,
  `OR_PROJECT_ID` int(11) NOT NULL DEFAULT 0,
  `OR_ACTIVITY_ID` int(11) NOT NULL DEFAULT 0,
  `OR_IS_POSTED` char(1) NOT NULL DEFAULT 'N',
  `OR_COPY_FROM_ORDER_ID` int(11) NOT NULL DEFAULT 0,
  `OR_DROP_SHIP_PARTNER_ID` int(11) NOT NULL DEFAULT 0,
  `OR_DROP_SHIP_LOCATION_ID` int(11) NOT NULL DEFAULT 0,
  `OR_DROP_SHIP_CONTACT_ID` int(11) NOT NULL DEFAULT 0,
  `OR_ORG_TRX_ID` int(11) NOT NULL DEFAULT 0,
  `OR_DELIVERY_NOTES` varchar(255) NULL,
  `OR_INCO_TERMS_ID` int(11) NOT NULL DEFAULT 0,
  `OR_GENERATE_TEMPLATE` char(1) NOT NULL DEFAULT 'N',
  `OR_BUSINESS_PARTNER_LOCATION_ID` int(11) NOT NULL DEFAULT 0,
  `OR_COPY_FROM_PO_ID` int(11) NOT NULL DEFAULT 0,
  `OR_PAYMENT_METHOD_ID` int(11) NOT NULL DEFAULT 0,
  `OR_PAYMENT_PRIORITY_ID` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY  (`OR_ORDER_ID`)
);

--
-- ORDER LINES
--
CREATE TABLE `FM_ORDER_LINE` (
  `OL_ORDER_LINE_ID int(11) NOT NULL auto_increment
  `OL_CLIENT_ID` int(11) NOT NULL,
  `OL_ORGANIZATION_ID` int(11) NOT NULL,
  `OL_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `OL_ORDER_ID` int(11) NOT NULL,
  `OL_LINE` double(10) NOT NULL,
  `OL_BPARTNER_ID` int(11) NOT NULL,
  `OL_BPARTNER_LOCATION_ID` int(11) NOT NULL,
  `OL_DATE_ORDERED` datetime NOT NULL,
  `OL_DATE_PROMISED` datetime,
  `OL_DATE_DELIVERED` datetime,
  `OL_DATE_INVOICED` datetime,
  `OL_DESCRIPTION` varchar (2000),
  `OL_PRODUCT_ID` int(11) DEFAULT NULL,
  `OL_WAREHOUSE_ID` int(11) DEFAULT NULL,
  `OL_DIRECT_SHIP` char(1) NOT NULL DEFAULT 'Y',
  `OL_UOM_ID` int(11) NOT NULL,
  `OL_QUANTITY_ORDERED` int(11) NOT NULL,
  `OL_QUANTITY_RESERVED` int(11) NOT NULL,
  `OL_QUANTITY_DELIVERED` int(11) NOT NULL,
  `OL_QUANTITY_INVOICED` int(11) NOT NULL,
  `OL_SHIPPER_ID` int(11),
  `OL_CURRENCY_ID` int(11),
  `OL_PRIICE_LIST` int(11) NOT NULL,
  `OL_PRICE_ACTUAL` double(10) NOT NULL,
  `OL_PRICE_LIMIT` double(10) NOT NULL,
  `OL_LINE_NET_AMOUNT` double(10) NOT NULL,
  `OL_DISCOUNT` double(10),
  `OL_FREIGHT_AMOUNT` double(10) NOT NULL,
  `OL_CHARGE_ID` int(11),
  `OL_CHARGE_AMOUNT` double(10),
  `OL_TAX_ID` int(11) NOT NULL,
  `OL_RESOURCE_ASSIGNMENT_ID` int(11),
  `OL_REFERENCE_ORDER_LINE_ID` int(11),
  `OL_ATTRIBUTE_SET_INSTANCE_ID` int(11),
  `OL_IS_DESCRIPTION` char(1) NOT NULL DEFAULT 'Y',
  `OL_QUANTITY_ORDER` int(11),
  `OL_PRODUCT_UOM_ID` int(11),
  `OL_OFFER_ID` int(11),
  `OL_PRICE_STANDARD` int(11) NOT NULL,
  `OL_CANCEL_PRICED` char(1) DEFAULT 'Y',
  `OL_ORDER_DISCOUNT_ID` int(11) DEFAULT NULL,
  `OL_IS_EDIT_LINE_ITEM_AMT` char(1) DEFAULT 'Y',
  `OL_TAX_BASE_AMOUNT` int(11),
  PRIMARY KEY  (`OL_ORDER_LINE_ID`)
);

--
-- PAYMENT PRIORITY
--
CREATE TABLE `FM_PAYMENT_PRIORITY` (
  `PP_PAYMENT_PRIORITY_ID` int(11) NOT NULL auto_increment,
  `PP_CLIENT_ID` int(11) NOT NULL,
  `PP_ORGANIZATION_ID` int(11) NOT NULL,
  `PP_IS_ACTIVE` char(1) NOT NULL,
  `PP_PRIORITY` int(11) NOT NULL,
  `PP_NAME` varchar(50) NOT NULL,
  `PP_DESCRIPTION` varchar(255) NOT NULL,
  `PP_IS_DEFAULT` char(1) NOT NULL DEFAULT 'N',
  `PP_COLOR` varchar(255) NOT NULL,
  PRIMARY KEY  (`PP_PAYMENT_PRIORITY_ID`)
);

--
-- DOCUMENT SEQUENCE
--
CREATE TABLE `FM_DOCUMENT_SEQUENCE` (
  `DS_SEQUENCE_ID` int(11) NOT NULL auto_increment,
  `DS_CLIENT_ID` int(11) NOT NULL,
  `DS_ORGANIZATION_ID` int(11) NOT NULL,
  `DS_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `DS_SEQUENCE_NAME` varchar(100) NOT NULL,
  `DS_SEQUENCE_DESCRIPTION` varchar(255) NOT NULL,
  `DS_INCREMENT_NUMBER` int(11) NOT NULL,
  `DS_START_NUMBER` int(11) NOT NULL,
  `DS_NEXT_SEQUENCE_NUMBER` int(11) NOT NULL,
  `DS_SEQUENCE_PREFIX` varchar(100) NOT NULL,
  `DS_SEQUENCE_SUFFIX` varchar(100) NOT NULL,
  `DS_START_NEW_YEAR` char(1) NOT NULL DEFAULT 'Y',
  `DS_FROM_DATE` datetime NOT NULL,
  `DS_TO_DATE` datetime NOT NULL,
   PRIMARY KEY  (`DS_SEQUENCE_ID`)
);

--
-- PRICE LIST
--
CREATE TABLE `FM_PRICE_LIST` (
  `PL_PRICE_LIST_ID` int(11) NOT NULL auto_increment,
  `PL_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `PL_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `PL_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PL_NAME` varchar(100) NOT NULL,
  `PL_DESCRIPTION` varchar(255) NOT NULL,
  `PL_BASE_PRICE_LIST_ID` varchar(255) NOT NULL, --IF PRODUCT NOT FOUND ON THIS PRICE LIST, USE BASE PRICE LIST ID
  `PL_IS_TAX_INCLUDED` char(1) NOT NULL DEFAULT 'N',
  `PL_IS_SO_PRICE_LIST` char(1) NOT NULL DEFAULT 'Y',
  `PL_IS_DEFAULT` char(1) NOT NULL DEFAULT 'N',
  `PL_CURRENCY_ID` int(11) NOT NULL DEFAULT 0,
  `PL_ENFORCE_PRICE_LIMIT` char(1) NOT NULL DEFAULT 'Y', -- DO NOT ALLOW PRICE BELOW THIS LIMIT
  PRIMARY KEY  (`PL_PRICE_LIST_ID`)
);

--
-- PRICE LIST VERSION
--
CREATE TABLE `FM_PRICE_VERSION` (
  `PV_PRICE_LIST_VERSION_ID` int(11) NOT NULL auto_increment,
  `PV_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `PV_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `PV_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PV_NAME` varchar(100) NOT NULL,
  `PV_DESCRIPTION` varchar(255) NULL,
  `PV_PRICE_LIST_ID` int(11) NOT NULL, 
  `PV_DISCOUNT_SCHEMA_ID` int(11) NOT NULL,
  `PV_VALID_FROM` datetime NOT NULL,
  `PV_PRICE_LIST_VERSION_BASE_ID` int(11) NOT NULL,
  PRIMARY KEY  (`PV_PRICE_LIST_VERSION_ID`)
);

--
-- PRODUCT PRICE LIST
--
CREATE TABLE `FM_PRODUCT_PRICE` (
  `PR_PRODUCT_PRICE_ID` int(11) NOT NULL auto_increment,
  `PR_CLIENT_ID` int(11) NOT NULL DEFAULT 0,
  `PR_ORGANIZATION_ID` int(11) NOT NULL DEFAULT 0,
  `PR_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `PR_LIST_PRICE` double NOT NULL, 
  `PR_STANDARD_PRICE` double NOT NULL,
  `PR_LIMIT_PRICE` double NOT NULL,
  `PR_PRICE_LIST_VERSION_BASE_ID` int(11) NOT NULL,
  PRIMARY KEY  (`PR_PRODUCT_PRICE_ID`)
);

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- PM : PARTY MANAGER MANAGEMENT SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--
--  PM : PARTY
--
CREATE TABLE `PM_PARTY` (
  `PM_PARTY_ID` int(11) NOT NULL auto_increment,
  `PM_DESCRIPTION` longtext,
  `PM_EXTERNAL_ID` varchar(50) default NULL,
  `PM_PARTY_TYPE` varchar(100) NOT NULL,
  `PM_PREFERRED_CURRENCY_UOM` varchar(50) default NULL,
  `PM_STATUS` varchar(50) NOT NULL,
  PRIMARY KEY  (`PM_PARTY_ID`),
  INDEX (`PM_PERSON_ID`),
  UNIQUE KEY `PM_PARTY_ID` (`PM_PARTY_ID`)
);


--
--  PM : PERSON
--
CREATE TABLE `PM_PERSON` (
  `PM_PERSON_ID` int(11) NOT NULL,
  `PM_BIRTH_DATE` datetime default NULL,
  `PM_COMMENTS` longtext,
  `PM_DECEASED_DATE` datetime default NULL,
  `PM_FIRST_NAME` varchar(100) NOT NULL,
  `PM_GENDER` bit(1) NULL,
  `PM_LAST_NAME` varchar(100) NOT NULL,
  `PM_MARITAL_STATUS` varchar(10) default NULL,
  `PM_MIDDLE_NAME` varchar(100) default NULL,
  `PM_NICK_NAME` varchar(50) default NULL,
  `PM_PASSPORT_EXPIRATION_DATE` datetime default NULL,
  `PM_PASSPORT_NUMBER` varchar(50) default NULL,
  `PM_SALUTAION` varchar(100) NULL,
  `PM_SSN` varchar(50) default NULL,
  `PM_SUFFIX` varchar(50) default NULL,
  PRIMARY KEY  (`PM_PERSON_ID`),
  INDEX (`PM_PERSON_ID`),
  FOREIGN KEY (`PM_PERSON_ID`) REFERENCES PM_PARTY (`PM_PARTY_ID`)
);

--
--  PM : PARTY CONTACT MECH
--
CREATE TABLE `PM_PARTY_CONTACT_MECH` (
  `CM_CONTACT_MECH_ID` int(11) NOT NULL auto_increment,
  `CM_CONTACT_MECH_PURPOSE` varchar(50) NOT NULL,
  `CM_CONTACT_MECH_TYPE` varchar(50) NOT NULL,
  `CM_INFO_STRING` varchar(100) NOT NULL,
  `CM_PARTY_ID` int(11) NOT NULL,
  PRIMARY KEY  (`CM_CONTACT_MECH_ID`),
  FOREIGN KEY `FK_PARTY_ID` (`CM_PARTY_ID`) REFERENCES `PM_PARTY`(`PM_PARTY_ID`)
);


--
--  PM : PARTY ADDRESS
--
CREATE TABLE `PARTY_ADDRESS` (
  `PM_PARTY_ID` int(11) NOT NULL,
  `AB_ADDRESS_ID` int(11) NOT NULL,
  PRIMARY KEY  (`PM_PARTY_ID`,`AB_ADDRESS_ID`),
  UNIQUE KEY `PM_PARTY_ID` (`PM_PARTY_ID`),
  UNIQUE KEY `AB_ADDRESS_ID` (`AB_ADDRESS_ID`),
  FOREIGN KEY `FK_ADDRESS_ID` (`AB_ADDRESS_ID`) REFERENCES `AB_ADDRESS_BOOK` (`AB_ADDRESS_ID`),
  FOREIGN KEY `FK_PARTY_ID` (`PM_PARTY_ID`) REFERENCES `PM_PARTY` (`PM_PARTY_ID`)
);


------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- AB : ADDRESS BOOK MANAGEMENT SCHEMA
------------------------------------------------------------------------------------------------------------------------------------------------------------------------

--
--  PM : ADDRESS BOOK
--
CREATE TABLE `AB_ADDRESS_BOOK` (
  `AB_ADDRESS_BOOK_ID` int(11) NOT NULL auto_increment,
  `AB_ADDRESS_1` varchar(100) NOT NULL,
  `AB_ADDRESS_2` varchar(100) default NULL,
  `AB_ATTN_NAME` varchar(100) NOT NULL,
  `AB_CITY` varchar(100) NOT NULL,
  `AB_COUNTRY` varchar(100) NOT NULL,
  `AB_DIRECTIONS` varchar(100) default NULL,
  `AB_POSTAL_CODE` varchar(100) NOT NULL,
  `AB_POSTAL_CODE_EXT` varchar(100) default NULL,
  `AB_STATE_PROVINCE` varchar(100) NOT NULL,
  `AB_TO_NAME` varchar(100) NOT NULL,
  PRIMARY KEY  (`AB_ADDRESS_BOOK_ID`)
);

--
--  PM : ADDRESS BOOK TYPE
--
CREATE TABLE `AB_TYPE` (
  `AB_ADDRESS_TYPE_ID` int(11) NOT NULL,
  `AB_TYPE_VALUE` varchar(100) NOT NULL,
  `AB_TYPE_FROM_DATE` datetime NOT NULL,
  `AB_TYPE_TO_DATE` datetime NOT NULL,
  PRIMARY KEY  (`AB_ADDRESS_TYPE_ID`),
  INDEX(`AB_ADDRESS_TYPE_ID`)
);

--
--  PM : ADDRESS BOOK - TYPE
--
CREATE TABLE `AB_ADDRESS_TYPE` (
  `AT_ADDRESS_TYPE_ID` int(11) NOT NULL,
  `AT_ADDRESS_BOOK_ID` int(11) NOT NULL,
  PRIMARY KEY  (`AT_ADDRESS_TYPE_ID`,`AT_ADDRESS_BOOK_ID`),
  INDEX(`AT_ADDRESS_BOOK_ID`),
  FOREIGN KEY `FK_AT_ADDRESS_TYPE_ID` (`AT_ADDRESS_TYPE_ID`) REFERENCES AB_TYPE(`AB_ADDRESS_TYPE_ID`),
  FOREIGN KEY `FK_AT_ADDRESS_BOOK_ID` (`AT_ADDRESS_BOOK_ID`) REFERENCES AB_ADDRESS_BOOK(`AB_ADDRESS_ID`)
);