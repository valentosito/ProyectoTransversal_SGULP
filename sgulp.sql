-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-10-2026 a las 17:18:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sgulp`
--
CREATE DATABASE IF NOT EXISTS `sgulp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `sgulp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `fecNac` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`idAlumno`, `dni`, `nombre`, `apellido`, `fecNac`, `estado`) VALUES
(1, '45123456', 'Melisa', 'Rodríguez', '1989-09-10', 0),
(2, '42345678', 'Valentina', 'Toso', '1995-12-27', 1),
(3, '46789123', 'Aimé', 'Olivares', '1999-11-03', 1),
(4, '39876543', 'Joaquín', 'Viarruel', '2002-02-17', 1),
(5, '41234567', 'Lucas', 'Sosa', '2000-07-29', 1),
(6, '30111222', 'Hernán', 'López', '2000-05-15', 1),
(7, '31222333', 'Brenda', 'Martínez', '2001-08-20', 1),
(8, '32333444', 'Martín', 'García', '1999-03-10', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencia`
--

CREATE TABLE `asistencia` (
  `idAsistencia` int(11) NOT NULL,
  `idCursada` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `presente` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `asistencia`
--

INSERT INTO `asistencia` (`idAsistencia`, `idCursada`, `fecha`, `presente`) VALUES
(1, 1, '2025-04-07', 1),
(2, 1, '2025-04-14', 1),
(3, 1, '2025-04-21', 0),
(4, 2, '2026-04-06', 1),
(5, 2, '2026-04-13', 1),
(6, 2, '2026-04-20', 1),
(7, 3, '2026-04-07', 0),
(8, 3, '2026-04-14', 1),
(9, 3, '2026-04-21', 1),
(10, 4, '2026-04-08', 1),
(11, 4, '2026-04-15', 1),
(12, 4, '2026-04-22', 0),
(13, 5, '2026-08-04', 1),
(14, 5, '2026-08-11', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursada`
--

CREATE TABLE `cursada` (
  `idCursada` int(11) NOT NULL,
  `idAlumno` int(11) NOT NULL,
  `idMateria` int(11) NOT NULL,
  `anio` year(4) NOT NULL,
  `cuatrimestre` tinyint(4) NOT NULL CHECK (`cuatrimestre` in (1,2)),
  `condicion` tinyint(4) NOT NULL CHECK (`condicion` in (1,2,3)),
  `recursante` tinyint(1) NOT NULL,
  `notaFinal` decimal(3,1) DEFAULT NULL CHECK (`notaFinal` between 0 and 10),
  `asistencia` tinyint(4) NOT NULL CHECK (`asistencia` between 0 and 100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursada`
--

INSERT INTO `cursada` (`idCursada`, `idAlumno`, `idMateria`, `anio`, `cuatrimestre`, `condicion`, `recursante`, `notaFinal`, `asistencia`) VALUES
(1, 1, 101, '2025', 1, 1, 1, 2.5, 45),
(2, 1, 101, '2026', 1, 3, 1, 8.5, 87),
(3, 2, 102, '2026', 1, 1, 0, NULL, 90),
(4, 3, 103, '2026', 1, 3, 0, 9.0, 95),
(5, 4, 104, '2026', 2, 1, 0, NULL, 80);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `idMateria` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`idMateria`, `nombre`, `estado`) VALUES
(101, 'Laboratorio 1', 1),
(102, 'Programación 1', 1),
(103, 'Matemática 1', 1),
(104, 'Inglés 1', 1),
(105, 'Base de Datos 1', 1),
(106, 'Laboratorio 2', 1),
(107, 'Programación 2', 1),
(108, 'Matemática 2', 1),
(109, 'Inglés 2', 1),
(110, 'Base de Datos 2', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD PRIMARY KEY (`idAsistencia`),
  ADD UNIQUE KEY `idCursada` (`idCursada`,`fecha`);

--
-- Indices de la tabla `cursada`
--
ALTER TABLE `cursada`
  ADD PRIMARY KEY (`idCursada`),
  ADD UNIQUE KEY `idAlumno` (`idAlumno`,`idMateria`,`anio`,`cuatrimestre`),
  ADD KEY `idMateria` (`idMateria`);

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`idMateria`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `asistencia`
--
ALTER TABLE `asistencia`
  MODIFY `idAsistencia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `cursada`
--
ALTER TABLE `cursada`
  MODIFY `idCursada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `idMateria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=111;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencia`
--
ALTER TABLE `asistencia`
  ADD CONSTRAINT `asistencia_ibfk_1` FOREIGN KEY (`idCursada`) REFERENCES `cursada` (`idCursada`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cursada`
--
ALTER TABLE `cursada`
  ADD CONSTRAINT `cursada_ibfk_1` FOREIGN KEY (`idAlumno`) REFERENCES `alumno` (`idAlumno`),
  ADD CONSTRAINT `cursada_ibfk_2` FOREIGN KEY (`idMateria`) REFERENCES `materia` (`idMateria`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
