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
  `estado` int(2) NOT NULL,
  PRIMARY KEY (`documento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `usuario` (`documento`, `nombre`, `profesion`, `edad`, `direccion`, `telefono`, `tipo`, `password`, estado)
VALUES
('1094044519', 'Administrador', '', 0, '', '', 1, '1234', 1),
('22222', 'Ruth Ballesteros', 'La mejor madre', 47, 'la isabela', '3323', 2, 'ruka', 1),
('33333', 'mariana', 'nose', 20, 'la isa', '1212', 3, 'mari', 1);
