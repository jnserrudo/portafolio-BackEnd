-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema backend_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema backend_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `backend_db` DEFAULT CHARACTER SET utf8 ;
USE `backend_db` ;

-- -----------------------------------------------------
-- Table `backend_db`.`domicilio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`domicilio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `domicilio` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url_perfil` VARCHAR(45) NULL,
  `url_linkedin` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `id_domicilio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_persona_domicilio1_idx` (`id_domicilio` ASC) VISIBLE,
  CONSTRAINT `fk_persona_domicilio1`
    FOREIGN KEY (`id_domicilio`)
    REFERENCES `backend_db`.`domicilio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`experiencia_laboral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`experiencia_laboral` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url_logo` VARCHAR(45) NULL,
  `nom_cargo` VARCHAR(45) NULL,
  `tipo_jornada` INT NULL,
  `nom_empresa` VARCHAR(45) NULL,
  `id_domicilio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_experiencia_laboral_domicilio1_idx` (`id_domicilio` ASC) VISIBLE,
  CONSTRAINT `fk_experiencia_laboral_domicilio1`
    FOREIGN KEY (`id_domicilio`)
    REFERENCES `backend_db`.`domicilio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`educacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom_institucion` VARCHAR(45) NULL,
  `url_logo` VARCHAR(45) NULL,
  `id_domicilio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_educacion_domicilio1_idx` (`id_domicilio` ASC) VISIBLE,
  CONSTRAINT `fk_educacion_domicilio1`
    FOREIGN KEY (`id_domicilio`)
    REFERENCES `backend_db`.`domicilio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`persona_exp_lab`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`persona_exp_lab` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fechadesde` DATETIME NULL,
  `fechahasta` DATETIME NULL,
  `id_persona` INT NOT NULL,
  `id_experiencia_laboral` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_persona_exp_lab_persona_idx` (`id_persona` ASC) VISIBLE,
  INDEX `fk_persona_exp_lab_experiencia_laboral1_idx` (`id_experiencia_laboral` ASC) VISIBLE,
  CONSTRAINT `fk_persona_exp_lab_persona`
    FOREIGN KEY (`id_persona`)
    REFERENCES `backend_db`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_exp_lab_experiencia_laboral1`
    FOREIGN KEY (`id_experiencia_laboral`)
    REFERENCES `backend_db`.`experiencia_laboral` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`persona_educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`persona_educacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fechadesde` VARCHAR(45) NULL,
  `fechahasta` VARCHAR(45) NULL,
  `id_educacion` INT NOT NULL,
  `id_persona` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_persona_educacion_educacion1_idx` (`id_educacion` ASC) VISIBLE,
  INDEX `fk_persona_educacion_persona1_idx` (`id_persona` ASC) VISIBLE,
  CONSTRAINT `fk_persona_educacion_educacion1`
    FOREIGN KEY (`id_educacion`)
    REFERENCES `backend_db`.`educacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_educacion_persona1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `backend_db`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`proyecto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nom_proyecto` VARCHAR(45) NULL,
  `url_proy` VARCHAR(45) NULL,
  `fecha` DATETIME NULL,
  `id_persona` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_proyecto_persona1_idx` (`id_persona` ASC) VISIBLE,
  CONSTRAINT `fk_proyecto_persona1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `backend_db`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`usuario` (
  `id` INT NOT NULL,
  `nom_usuario` VARCHAR(45) NULL,
  `contra` VARCHAR(45) NULL,
  `id_persona` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_usuario_persona1_idx` (`id_persona` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_persona1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `backend_db`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`tecnologias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`tecnologias` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `url_logo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `backend_db`.`persona_tecnologia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `backend_db`.`persona_tecnologia` (
  `id` INT NOT NULL,
  `nivel` INT NULL,
  `id_persona` INT NOT NULL,
  `id_tecnologias` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_persona_tecnologia_persona1_idx` (`id_persona` ASC) VISIBLE,
  INDEX `fk_persona_tecnologia_tecnologias1_idx` (`id_tecnologias` ASC) VISIBLE,
  CONSTRAINT `fk_persona_tecnologia_persona1`
    FOREIGN KEY (`id_persona`)
    REFERENCES `backend_db`.`persona` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_persona_tecnologia_tecnologias1`
    FOREIGN KEY (`id_tecnologias`)
    REFERENCES `backend_db`.`tecnologias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
