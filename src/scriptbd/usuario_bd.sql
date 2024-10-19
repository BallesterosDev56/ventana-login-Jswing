CREATE DATABASE IF NOT EXISTS `usuario_bd`;
USE `usuario_bd`;

CREATE TABLE IF NOT EXISTS `usuario` (
  `documento` VARCHAR(11) NOT NULL,
  `nombre` VARCHAR(80) NOT NULL,
  `profesion` VARCHAR(200) NOT NULL,
  `edad` INT(3) NOT NULL,
  `direccion` VARCHAR(200) NOT NULL,
  `telefono` VARCHAR(10) NOT NULL,
  `tipo` INT(2) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO usuario (documento,nombre,profesion,edad,direccion,telefono,tipo, password) VALUES ("1094044519","Administrador","",0,"","",1, 1234)