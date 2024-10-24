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
    precio DECIMAL(10,2) NOT NULL,
    categoria VARCHAR(50),
    stock INT NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS `compra` (
  id INT AUTO_INCREMENT PRIMARY KEY,
  documento_usuario VARCHAR(11) NOT NULL,
  id_producto INT NOT NULL,
  precio VARCHAR(10) NOT NULL,
  FOREIGN KEY (documento_usuario) REFERENCES usuario(documento) ON DELETE CASCADE,
  FOREIGN KEY (id_producto) REFERENCES producto(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `usuario` (`documento`, `nombre`, `profesion`, `edad`, `direccion`, `telefono`, `tipo`, `password`, estado)
VALUES
('admin', 'Administrador', '', 0, '', '', 1, 'admin', 1),
('22222', 'Ruth Ballesteros', 'La mejor madre', 47, 'la isabela', '3323', 1, 'ruka', 1),
('usuario', 'usuario', 'nose', 20, 'la isa', '1212', 2, 'usuario', 1),
('secretaria', 'secretaria', 'nose', 20, 'la isa', '1212', 3, 'secretaria', 1);

INSERT INTO producto (nombre, precio, categoria, stock) VALUES
('Camiseta Deportiva', 19.99, 'Ropa', 50),
('Zapatillas Running', 79.99, 'Calzado', 30),
('Bicicleta de Montaña', 499.99, 'Deportes', 10),
('Auriculares Inalámbricos', 59.99, 'Tecnología', 25),
('Smartwatch', 149.99, 'Tecnología', 15);
