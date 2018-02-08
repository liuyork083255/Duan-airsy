CREATE DATABASE `airsy` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE airsy;
CREATE TABLE `air_data` (
  `dataid` VARCHAR(32),
  `pmtwo` VARCHAR(20) DEFAULT '',
  `pmten` VARCHAR(20) DEFAULT '',
  `noise` VARCHAR(20) DEFAULT '',
  `speed` VARCHAR(20) DEFAULT '',
  `direction` VARCHAR(20)DEFAULT '',
  `temperature` VARCHAR(20) DEFAULT '',
  `humidity` VARCHAR(20) DEFAULT '',
  `power` VARCHAR(20) DEFAULT '',
  `snid` VARCHAR(32) DEFAULT '',
  `datetime` VARCHAR(30) DEFAULT '',
  PRIMARY KEY (`dataid`)
);

CREATE TABLE `air_usd` (
  `snid` VARCHAR(32),
  `company` VARCHAR(200) DEFAULT '',
  `worksite` VARCHAR(200) DEFAULT '',
  `sn` VARCHAR(32) DEFAULT '',
  `userid` VARCHAR(32) DEFAULT '',
  `snname` VARCHAR(50) DEFAULT '',
  PRIMARY KEY (`snid`)
) ;

CREATE TABLE `air_user` (
  `userid` VARCHAR(32),
  `username` VARCHAR(20) DEFAULT '',
  `password` VARCHAR(50) DEFAULT '',
  `priority` VARCHAR(2) DEFAULT '',
  `info` VARCHAR(100) DEFAULT '',
  `email` VARCHAR(50) DEFAULT '',
  PRIMARY KEY (`userid`)
)  ;

CREATE TABLE `air_sn` (
  `sn` VARCHAR(32),
  `state` VARCHAR(2) DEFAULT ''
) ;

INSERT INTO air_user VALUES('BAF538FEFF0448FDA71359590FB6D388','admin','e10adc3949ba59abbe56e057f20f883e','zlbyjzkjyxgs@163.com','0','管理员');

-- http://url:port/airsy/html/index.html
-- http://url:port/airsy/login

