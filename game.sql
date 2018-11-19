-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2018 at 03:31 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `game`
--

-- --------------------------------------------------------

--
-- Table structure for table `detail`
--

CREATE TABLE `detail` (
  `id_detail` int(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `id_genre` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail`
--

INSERT INTO `detail` (`id_detail`, `nama`, `publisher`, `id_genre`) VALUES
(1, 'gta san andreas vii', 'rockstar games', 4);

-- --------------------------------------------------------

--
-- Stand-in structure for view `gabung`
-- (See below for the actual view)
--
CREATE TABLE `gabung` (
`id_detail` int(10)
,`nama` varchar(100)
,`publisher` varchar(100)
,`kategori` varchar(100)
,`keterangan` varchar(100)
);

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `id_genre` int(10) NOT NULL,
  `kategori` varchar(100) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`id_genre`, `kategori`, `keterangan`) VALUES
(1, 'action', 'game action'),
(2, 'sport', 'game tentang olahraga'),
(3, 'Horror', 'game hantu, menyeramkan, jumpscare'),
(4, 'Strategi', 'game strategi peperangan');

-- --------------------------------------------------------

--
-- Structure for view `gabung`
--
DROP TABLE IF EXISTS `gabung`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `gabung`  AS  select `detail`.`id_detail` AS `id_detail`,`detail`.`nama` AS `nama`,`detail`.`publisher` AS `publisher`,`genre`.`kategori` AS `kategori`,`genre`.`keterangan` AS `keterangan` from (`detail` join `genre` on((`detail`.`id_genre` = `genre`.`id_genre`))) ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
