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

CREATE TABLE IF NOT EXISTS `producto` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2) NOT NULL,
    categoria VARCHAR(50),
    stock INT NOT NULL DEFAULT 0
);


INSERT INTO `usuario` (`documento`, `nombre`, `profesion`, `edad`, `direccion`, `telefono`, `tipo`, `password`, estado)
VALUES
('1094044519', 'Administrador', '', 0, '', '', 1, '1234', 1),
('22222', 'Ruth Ballesteros', 'La mejor madre', 47, 'la isabela', '3323', 2, 'ruka', 1),
('33333', 'mariana', 'nose', 20, 'la isa', '1212', 3, 'mari', 1);

INSERT INTO productos (nombre, descripcion, precio, categoria, stock) VALUES
('Camiseta Deportiva', 'Camiseta para actividades físicas', 19.99, 'Ropa', 50),
('Zapatillas Running', 'Zapatillas para correr de alto rendimiento', 79.99, 'Calzado', 30),
('Bicicleta de Montaña', 'Bicicleta con suspensión delantera', 499.99, 'Deportes', 10),
('Auriculares Inalámbricos', 'Auriculares Bluetooth con cancelación de ruido', 59.99, 'Tecnología', 25),
('Smartwatch', 'Reloj inteligente con monitoreo de salud', 149.99, 'Tecnología', 15);
