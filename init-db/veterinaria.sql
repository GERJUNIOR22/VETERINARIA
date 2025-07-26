-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-07-2025 a las 22:06:32
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
-- Base de datos: `veterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `albergues`
--

CREATE TABLE `albergues` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `encargado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `albergues`
--

INSERT INTO `albergues` (`id`, `nombre`, `direccion`, `telefono`, `encargado`) VALUES
(1, 'Refugio Huellitas', 'Av. Los Álamos 123', '999111222', 'Sandra Ruiz'),
(2, 'Patitas Felices', 'Calle Sol 456', '988776655', 'Marco Díaz'),
(3, 'Amigos Peludos', 'Jr. Esperanza 789', '977665544', 'Carla Fernández');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `nombre`, `apellido`, `dni`, `correo`, `telefono`, `direccion`, `usuario_id`) VALUES
(1, 'Juan', 'Pérez', '12345678', 'juan.perez@email.com', '987654321', 'Av. Los Pinos 123', NULL),
(2, 'Lucía', 'Ramírez', '87654321', 'lucia.ramirez@email.com', '912345678', 'Calle Las Flores 456', NULL),
(3, 'Carlos', 'Torres', '11223344', 'carlos.torres@email.com', '998877665', 'Jr. Primavera 789', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascotas`
--

CREATE TABLE `mascotas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `especie` varchar(255) DEFAULT NULL,
  `raza` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `albergue_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`id`, `nombre`, `especie`, `raza`, `edad`, `estado`, `cliente_id`, `albergue_id`) VALUES
(1, 'Max', 'Perro', 'Labrador', 3, 'Adoptado', 1, NULL),
(2, 'Mia', 'Gato', 'Siames', 2, 'Disponible', NULL, NULL),
(3, 'Rocky', 'Perro', 'Pitbull', 4, 'Adoptado', 2, NULL),
(4, 'Luna', 'Gato', 'Persa', 1, 'Disponible', NULL, NULL),
(5, 'Toby', 'Perro', 'Poodle', 5, 'Adoptado', 3, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `rol` varchar(20) NOT NULL,
  `estado` varchar(20) NOT NULL DEFAULT 'ACTIVO',
  `nombre_completo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`, `rol`, `estado`, `nombre_completo`) VALUES
(1, 'admin1', 'admin123', 'ADMIN', 'ACTIVO', 'Frank Gonzales'),
(2, 'usuario1', 'usuario123', 'USER', 'ACTIVO', 'Lucía Ramírez'),
(3, 'voluntario1', 'voluntario123', 'VOLUNTARIO', 'INACTIVO', 'Carlos Torres'),
(4, 'Ger22', '123456', 'USER', 'ACTIVO', 'German Suyon');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `albergues`
--
ALTER TABLE `albergues`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `UK96x1n5ut15ns1xhkm87y7qhnd` (`usuario_id`);

--
-- Indices de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente_id` (`cliente_id`),
  ADD KEY `FK2okhclnhuwfs249c3vbl534ot` (`albergue_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `albergues`
--
ALTER TABLE `albergues`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `FKk6iwsq3kts1bblivkjy6epajx` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD CONSTRAINT `FK2okhclnhuwfs249c3vbl534ot` FOREIGN KEY (`albergue_id`) REFERENCES `albergues` (`id`),
  ADD CONSTRAINT `mascotas_ibfk_1` FOREIGN KEY (`cliente_id`) REFERENCES `clientes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
