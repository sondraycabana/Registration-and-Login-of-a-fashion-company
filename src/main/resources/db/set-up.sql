drop user  if exists 'ayo'@'localhost';
create user 'ayo'@'localhost' identified by  'tailor123';
grant all privileges on fashiondb.* to 'ayo'@'localhost';
flush privileges;

drop database if  exists fashiondb;
create database fashiondb;