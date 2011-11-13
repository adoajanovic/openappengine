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
---DROP TABLE IF EXISTS `CO_CURRENCY`;
DROP TABLE IF EXISTS `CO_CURRENCY`;

CREATE TABLE `CO_CURRENCY` (
  `CU_CURRENCY_ID` int(11) NOT NULL auto_increment,
  `CU_CLIENT_ID` int(11) NOT NULL,
  `CU_ORGANIZATION_ID` int NOT NULL,
  `CU_IS_ACTIVE` char(1) NOT NULL DEFAULT 'Y',
  `CU_ISO_CODE` varchar(3),
  `CU_CURRENCY_SYMBOL` varchar (10) NOT NULL,
  `CU_DESCRIPTION` varchar (255),
  `CU_STANDARD_PRECISION` decimal(10,2),
  `CU_COSTING_PRECISION` decimal(10,2),
  `CU_PRICE_PRECISION` decimal(10,2),
  `CU_IS_SYMBOL_RIGHT_SIDE` char(1) NOT NULL DEFAULT 'Y',
  PRIMARY KEY  (`CU_CURRENCY_ID`)
);

