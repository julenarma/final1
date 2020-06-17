-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2019 a las 13:52:26
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `1aw3_vehicles`
--
CREATE DATABASE IF NOT EXISTS `1aw3_vehicles` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `1aw3_vehicles`;

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `getColors`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getColors` ()  NO SQL
SELECT vehicles.color FROM vehicles GROUP BY vehicles.color$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
  `idCustomer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  PRIMARY KEY (`idCustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `customers`
--

INSERT INTO `customers` (`idCustomer`, `name`, `surname`, `telephone`) VALUES
(1, 'Danny', 'De Vito', '900899874'),
(2, 'Jennifer', 'Lawrence', '562526396'),
(3, 'Jude', 'Law', '522457844');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE IF NOT EXISTS `vehicles` (
  `plate` varchar(7) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `color` varchar(255) NOT NULL,
  `customer` int(11) NOT NULL,
  PRIMARY KEY (`plate`),
  KEY `customer` (`customer`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `vehicles`
--

INSERT INTO `vehicles` (`plate`, `brand`, `model`, `color`, `customer`) VALUES
('8903HGG', 'Nissan', 'Juke', 'White', 3),
('9001KHH', 'Seat', 'Ibiza', 'White', 2),
('9005GHH', 'Ford', 'Focus', 'Blue', 3);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `vehicles_ibfk_1` FOREIGN KEY (`customer`) REFERENCES `customers` (`idCustomer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
