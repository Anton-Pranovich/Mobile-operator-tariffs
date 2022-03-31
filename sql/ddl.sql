CREATE DATABASE Mobile_operator_tariffs;

USE Mobile_operator_tariffs;

CREATE TABLE if not exists tariffs (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
operator VARCHAR(100),
subscriptionFee DECIMAL(15,2),
call_Cost DECIMAL(15,2),
sms_Cost DECIMAL(15,2),
number_of_megabytes DECIMAL(15,2), 
description TEXT
);


CREATE TABLE if not exists orders (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
tariff_name VARCHAR(100),
operator VARCHAR(100),
first_name VARCHAR(100),
last_name VARCHAR(100),
phone_number VARCHAR(100)
);
