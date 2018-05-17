-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-05-2018 a las 09:07:33
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ciber`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `dni` varchar(9) NOT NULL,
  `Nombre` varchar(10) NOT NULL,
  `Apellidos` varchar(10) NOT NULL,
  `Contraseña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`dni`, `Nombre`, `Apellidos`, `Contraseña`) VALUES
('9999', 'Administra', 'Administer', 'aaa111!!!');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `almacenamiento`
--

CREATE TABLE `almacenamiento` (
  `dni` varchar(9) NOT NULL,
  `NombreArchivo` varchar(50) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conexiones`
--

CREATE TABLE `conexiones` (
  `dni` varchar(9) NOT NULL,
  `idOrdenador` int(2) NOT NULL,
  `FechaConexion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumibles`
--

CREATE TABLE `consumibles` (
  `idConsumible` int(4) NOT NULL,
  `Nombre` varchar(10) NOT NULL,
  `Cantidad` int(4) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `consumibles`
--

INSERT INTO `consumibles` (`idConsumible`, `Nombre`, `Cantidad`, `Precio`) VALUES
(0, 'Coca-cola', 50, 2),
(1, 'Fanta', 55, 2),
(2, 'Cerveza', 60, 1.5),
(3, 'Jamon', 1, 50),
(4, 'Galletitas', 70, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenadores`
--

CREATE TABLE `ordenadores` (
  `IdOrdenador` int(2) NOT NULL,
  `procesador` varchar(15) NOT NULL,
  `placaBase` varchar(15) NOT NULL,
  `grafica` varchar(15) NOT NULL,
  `ram` int(2) NOT NULL,
  `discoDuroGB` int(3) NOT NULL,
  `fuente` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `dni` varchar(9) NOT NULL,
  `mesa` int(11) NOT NULL,
  `idConsumible` int(4) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dni` varchar(9) NOT NULL,
  `Nombre` varchar(10) NOT NULL,
  `Apellidos` varchar(10) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `vip` tinyint(1) NOT NULL,
  `primerLog` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `almacenamiento`
--
ALTER TABLE `almacenamiento`
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `conexiones`
--
ALTER TABLE `conexiones`
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `consumibles`
--
ALTER TABLE `consumibles`
  ADD UNIQUE KEY `id` (`idConsumible`);

--
-- Indices de la tabla `ordenadores`
--
ALTER TABLE `ordenadores`
  ADD PRIMARY KEY (`IdOrdenador`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `id` (`idConsumible`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
