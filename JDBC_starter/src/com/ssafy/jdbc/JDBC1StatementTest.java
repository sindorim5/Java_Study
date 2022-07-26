package com.ssafy.jdbc;

import java.sql.*;

/**
 * 
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`user` ;

CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `id`  VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

insert into user (id, password) values ('a01', 'pass01'), ('a02', 'pass02');
commit;

*/

//com.mysql.cj.jdbc.Driver
//jdbc:mysql://127.0.0.1:3306/mydb?serverTimezone=Asia/Seoul&useUniCode=yes&characterEncoding=UTF-8

public class JDBC1StatementTest {
    static final String DRIVER = "";
    static final String ID = "";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        
    
    }
}
