-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2017 at 08:01 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jmapp_circolari`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorie`
--

CREATE TABLE `categorie` (
  `NomeCategoria` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categorie`
--

INSERT INTO `categorie` (`NomeCategoria`) VALUES
('Conferenze'),
('Debiti'),
('Emergenze'),
('Progetti'),
('Stage'),
('Vacanze');

-- --------------------------------------------------------

--
-- Table structure for table `circolare`
--

CREATE TABLE `circolare` (
  `Cod` int(11) NOT NULL,
  `Categoria` varchar(32) NOT NULL,
  `Autore` int(11) NOT NULL,
  `Descrizione` text,
  `Privacy` varchar(32) DEFAULT NULL,
  `Percorso` varchar(255) NOT NULL,
  `Data` date NOT NULL,
  `Titolo` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `circolare`
--

INSERT INTO `circolare` (`Cod`, `Categoria`, `Autore`, `Descrizione`, `Privacy`, `Percorso`, `Data`, `Titolo`) VALUES
(4, 'Conferenze', 1, 'qwerty', NULL, 'qwertyjkl890', '2017-05-18', 'Conferenza Prof Polimi'),
(5, 'Vacanze', 4, 'qwerty', NULL, 'qwertyjkl890', '2017-05-18', 'Vacanze Pasquali'),
(6, 'Progetti', 1, 'bubu', NULL, 'cvbnm', '2017-05-07', 'EcoSchool');

-- --------------------------------------------------------

--
-- Table structure for table `utente`
--

CREATE TABLE `utente` (
  `Cod` int(11) NOT NULL,
  `Nome` varchar(32) NOT NULL,
  `Cognome` varchar(32) NOT NULL,
  `Email` varchar(64) NOT NULL,
  `Admin` enum('true','false') DEFAULT 'false',
  `Username` varchar(32) NOT NULL,
  `Password` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utente`
--

INSERT INTO `utente` (`Cod`, `Nome`, `Cognome`, `Email`, `Admin`, `Username`, `Password`) VALUES
(1, 'Giuseppe', 'Leggio', 'nome@hotmail.com', 'false', 'BeppeL', 'ciao1'),
(2, 'Federico', 'Piscitelli', 'nome2@dom.com', 'false', 'ChiccoP', 'ciao1'),
(4, 'Michela', 'Parlati', 'nome3@dom.com', 'false', 'MichiP', 'ciao1'),
(5, 'Daniele', 'Perego', 'nome4@dom.com', 'false', 'LeleP', 'ciao1'),
(6, 'Ismail', 'Djebali', 'nome5@dom.com', 'false', 'DjebaI', 'ciao1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`NomeCategoria`);

--
-- Indexes for table `circolare`
--
ALTER TABLE `circolare`
  ADD PRIMARY KEY (`Cod`),
  ADD KEY `Autore` (`Autore`),
  ADD KEY `Categoria` (`Categoria`);

--
-- Indexes for table `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`Cod`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `circolare`
--
ALTER TABLE `circolare`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `utente`
--
ALTER TABLE `utente`
  MODIFY `Cod` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `circolare`
--
ALTER TABLE `circolare`
  ADD CONSTRAINT `circolare_ibfk_1` FOREIGN KEY (`Autore`) REFERENCES `utente` (`Cod`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `circolare_ibfk_2` FOREIGN KEY (`Categoria`) REFERENCES `categorie` (`NomeCategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
