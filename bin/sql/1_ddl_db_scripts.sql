-- decimal for price
CREATE TABLE `hibernate_tables`.`products` (
  `pid` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(50) NOT NULL DEFAULT '',
  `price` DECIMAL NOT NULL DEFAULT 0,
  PRIMARY KEY(`pid`)
)
-- numeric for price
CREATE TABLE `hibernate_tables`.`products` (
  `pid` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(50) NOT NULL DEFAULT '',
  `price` numeric NOT NULL DEFAULT 0,
  PRIMARY KEY(`pid`)
)
-- float for price 
CREATE TABLE `hibernate_tables`.`products` (
  `pid` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  `pname` VARCHAR(50) NOT NULL DEFAULT '',
  `price` FLOAT NOT NULL DEFAULT 0,
  PRIMARY KEY(`pid`)
)