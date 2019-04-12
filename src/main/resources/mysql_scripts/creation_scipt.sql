DROP SCHEMA IF EXISTS `family_db`;
CREATE SCHEMA `family_db`;

#
DROP TABLE IF EXISTS `family_db`.`person`;
CREATE TABLE  `family_db`.`person` (
  `person_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `birth_mother_id` int(11) DEFAULT NULL,
  `birth_father_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `name_UNIQUE` (`user_name`),
  FOREIGN KEY (birth_mother_id)
      REFERENCES `family_db`.`person`(person_id)
      ON UPDATE CASCADE ON DELETE RESTRICT,
      
  FOREIGN KEY (birth_father_id)
      REFERENCES `family_db`.`person`(person_id)
      ON UPDATE CASCADE ON DELETE RESTRICT,
      
	INDEX idx_birth_mother_id(birth_mother_id),
    INDEX idx_birth_father_id(birth_father_id)  
      
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
DROP TABLE IF EXISTS `family_db`.`phone_number`;
CREATE TABLE `family_db`.`phone_number` (
  `person_id` INT NOT NULL,
  `phone_number` VARCHAR(11) NOT NULL,  
  PRIMARY KEY (`person_id`),
  
  FOREIGN KEY (person_id)
      REFERENCES `family_db`.`person`(person_id)
      ON UPDATE CASCADE ON DELETE RESTRICT
  
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
DROP TABLE IF EXISTS `family_db`.`email_address`;
CREATE TABLE `family_db`.`email_address` (
  `person_id` INT NOT NULL,
  `email_address` VARCHAR(255) NOT NULL,  
  PRIMARY KEY (`person_id`),
  
  FOREIGN KEY (person_id)
      REFERENCES `family_db`.`person`(person_id)
      ON UPDATE CASCADE ON DELETE RESTRICT
      
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

#
DROP PROCEDURE IF EXISTS `family_db`.`add_person`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `family_db`.`add_person`( IN UserName varchar (45), IN BirthMother int(11), IN BirthFather int(11) )
BEGIN
	
    declare FirstName varchar(256);
    declare LastName varchar(256);	
    declare PhoneNumber varchar(11);	
    declare EmailAddress varchar(256);	
       
    SET @FirstName := concat( UserName, '_first_name');
    SET @LastName := concat( UserName, '_last_name');
    SET @PhoneNumber := '12345678900';
    SET @EmailAddress := concat( UserName, '_email_address');
    
	insert into `family_db`.`person` (user_name, first_name, last_name, birth_mother_id, birth_father_id) values ( UserName, @FirstName, @LastName, BirthMother, BirthFather);
    
    insert into `family_db`.`phone_number` (person_id, phone_number) values ( LAST_INSERT_ID(), @PhoneNumber );
    
    insert into `family_db`.`email_address` (person_id, email_address) values ( LAST_INSERT_ID(), @EmailAddress );
    
    select null;
END //
DELIMITER ;