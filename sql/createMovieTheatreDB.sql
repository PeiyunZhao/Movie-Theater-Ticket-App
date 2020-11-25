DROP DATABASE IF EXISTS movieTheatre;
CREATE DATABASE movieTheatre; 
USE movieTheatre;

DROP TABLE IF EXISTS registered_user;
CREATE TABLE registered_user (
  uid			char(9) not null,
  uname	        varchar(50) not null, 
  uemail	        varchar(50) not null, 
  uregdate	        varchar(50) not null, 
  ucard  		char(10) not null,
  primary key (uid)
);

DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
  mid			char(9) not null,
  mname         varchar(50) not null,
  mtype         varchar(30) not null,
  mtime         varchar(60) not null,
  mroom         varchar(20) not null,
  mprice	    float,
  primary key (mid)
  
);
