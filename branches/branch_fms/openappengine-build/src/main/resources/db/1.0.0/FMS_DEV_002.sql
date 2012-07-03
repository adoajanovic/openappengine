-- 1
ALTER TABLE fm_order_item ADD (`OI_TAX_PRICE` decimal(18,2) DEFAULT NULL, `OI_LINE_TOTAL_PRICE` decimal(18,2) DEFAULT NULL);

-- 2
DROP TABLE IF EXISTS fm_order_sequence;
CREATE TABLE `fm_order_sequence` (`value` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

DROP TABLE IF EXISTS fm_invoice_sequence;
CREATE TABLE `fm_invoice_sequence` (`value` int(11) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=latin1 ;

insert into fm_order_sequence(value) values(0);
insert into fm_invoice_sequence(value) values(0);

-- 3
CREATE TABLE `prod_product_price_action_type` (
  `PA_PRODUCT_PRICE_ACTION_TYPE_ID` int(11) NOT NULL,
  `PA_DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PA_PRODUCT_PRICE_ACTION_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_cs;

DROP TABLE IF EXISTS `fm_invoice_item`;

DROP TABLE IF EXISTS `fm_invoice`;

CREATE TABLE `fm_invoice` (
  `IN_INVOICE_ID` int(11) COLLATE latin1_general_cs NOT NULL,
  `IN_INVOICE_TYPE_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_PARTY_ID_FROM` int(11) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_PARTY_ID` int(11) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_ROLE_TYPE_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_STATUS_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_BILLING_ACCOUNT_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_CONTACT_MECH_ID` int(11) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_INVOICE_DATE` datetime DEFAULT NULL,
  `IN_DUE_DATE` datetime DEFAULT NULL,
  `IN_PAID_DATE` datetime DEFAULT NULL,
  `IN_INVOICE_MESSAGE` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_REFERENCE_NUMBER` varchar(60) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_DESCRIPTION` varchar(255) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_CURRENCY_UOM_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  `IN_RECURRENCE_INFO_ID` varchar(20) COLLATE latin1_general_cs DEFAULT NULL,
  PRIMARY KEY (`IN_INVOICE_ID`),
  -- KEY `INVOICE_PARTY_FRM` (`IN_PARTY_ID_FROM`),
  KEY `INVOICE_PARTY` (`IN_PARTY_ID`),
  CONSTRAINT `INVOICE_PARTY` FOREIGN KEY (`IN_PARTY_ID`) REFERENCES `pm_party` (`PM_PARTY_ID`)
  -- CONSTRAINT `INVOICE_PARTY_FRM` FOREIGN KEY (`IN_PARTY_ID_FROM`) REFERENCES `pm_party` (`PM_PARTY_ID`)
);

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
  `IT_TAXABLE_FLAG` bit DEFAULT NULL,
  `IT_QUANTITY` decimal(18,6) DEFAULT NULL,
  `IT_AMOUNT` decimal(18,3) DEFAULT NULL,
  `IT_DESCRIPTION` varchar(255) DEFAULT NULL,
  `IT_TAX_AUTH_PARTY_ID` varchar(20)DEFAULT NULL,
  `IT_TAX_AUTH_GEO_ID` varchar(20) DEFAULT NULL,
  `IT_TAX_AUTHORITY_RATE_SEQ_ID` varchar(20) DEFAULT NULL,
  `IT_SALES_OPPORTUNITY_ID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IT_INVOICE_ID`,`IT_INVOICE_ITEM_SEQ_ID`),
  KEY `INVCE_ITM_INVCE` (`IT_INVOICE_ID`),
  KEY `INVCE_ITM_PROD` (`IT_PRODUCT_ID`),
  CONSTRAINT `INVCE_ITM_INVCE` FOREIGN KEY (`IT_INVOICE_ID`) REFERENCES `fm_invoice` (`IN_INVOICE_ID`),
  CONSTRAINT `INVCE_ITM_PROD` FOREIGN KEY (`IT_PRODUCT_ID`) REFERENCES `prod_product` (`PD_PRODUCT_ID`)
);