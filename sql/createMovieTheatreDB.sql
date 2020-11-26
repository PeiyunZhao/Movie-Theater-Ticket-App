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
  mtype         varchar(30) not null,
  mreserve      boolean not null,
  mprice	    float,
  primary key (mid)
  
);

DROP TABLE IF EXISTS showtime;
CREATE TABLE showtime (
  showid			char(9) not null,
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


