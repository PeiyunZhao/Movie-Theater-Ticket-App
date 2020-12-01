DROP DATABASE IF EXISTS movieTheatre;
CREATE DATABASE movieTheatre; 
USE movieTheatre;

DROP TABLE IF EXISTS registered_user;
CREATE TABLE registered_user (
  uid			varchar(20) not null,
  uname	        varchar(50) not null, 
  upassword	        varchar(50) not null, 
  uaddress	        varchar(50) not null, 
  uemail	        varchar(50) not null, 
  upaiddate	        varchar(50) not null, 
  ucard  		char(30) not null,
  primary key (uid)
);

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
  mid			char(9) not null,
  mname         varchar(50) not null,
  mreserve      boolean not null,
  mprice	    float,
  primary key (mid)
  
);

DROP TABLE IF EXISTS showtime;
CREATE TABLE showtime (
  showid			char(9) not null,
  movieid            char(9) not null,
  #showtime			DATETIME(6) not null,
  showtime			varchar(20) not null,
  showroom         varchar(20) not null,
  primary key (showid)
 
);

DROP TABLE IF EXISTS seat;
CREATE TABLE seat (
  seatid			char(9) not null,
  userid           char(9),
  ticketid        char(9),
  sshowid        varchar(50),
  seatcol         varchar(30) not null,
  seatrow        varchar(60) not null,
  seattaken      boolean not null,
  
  primary key (seatid)
 
);

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket (
  ticketid int(11) NOT NULL,
  mid int(11) DEFAULT NULL,
  userid varchar(20) DEFAULT NULL,
  sshowid int(11) DEFAULT NULL,
  seatid int(11) DEFAULT NULL,
  buyTime datetime DEFAULT NULL,
  PRIMARY KEY (ticketid)
);

DROP TABLE IF EXISTS bankaccount;
CREATE TABLE bankaccount (
  accountId int(11) NOT NULL AUTO_INCREMENT,
  acard char(30) DEFAULT NULL,
  apassword varchar(50) DEFAULT NULL,
  balance decimal(7,2) DEFAULT 1000.00,
  PRIMARY KEY (accountId)
);

DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon (
  couponId int(11) NOT NULL,
  credit decimal(2,0) DEFAULT NULL,
  ucard char(30) DEFAULT NULL,
  createTime datetime DEFAULT current_timestamp(),
  PRIMARY KEY (couponId)
)




