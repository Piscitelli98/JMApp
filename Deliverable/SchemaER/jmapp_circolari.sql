-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Mag 18, 2017 alle 08:41
-- Versione del server: 10.1.16-MariaDB
-- Versione PHP: 7.0.9

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
-- Struttura della tabella `categoria`
--

CREATE TABLE `categoria` (
  `nomeCategoria` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `circolare`
--

CREATE TABLE `circolare` (
  `numero` int(32) NOT NULL,
  `nome` varchar(64) NOT NULL,
  `privacy` enum('pubblica','privata') DEFAULT 'privata',
  `descrizione` varchar(128) DEFAULT NULL,
  `testo` varchar(64) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `nomeCategoria` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `destinatari`
--

CREATE TABLE `destinatari` (
  `nomeDestinatario` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `riguarda`
--

CREATE TABLE `riguarda` (
  `nomeDestinatario` varchar(64) NOT NULL,
  `numeroCircolare` int(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `username` varchar(32) NOT NULL,
  `psw` char(32) NOT NULL,
  `amministratore` enum('si','no') DEFAULT 'no',
  `nome` varchar(32) NOT NULL,
  `cognome` varchar(32) NOT NULL,
  `email` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`nomeCategoria`);

--
-- Indici per le tabelle `circolare`
--
ALTER TABLE `circolare`
  ADD PRIMARY KEY (`numero`);

--
-- Indici per le tabelle `destinatari`
--
ALTER TABLE `destinatari`
  ADD PRIMARY KEY (`nomeDestinatario`);

--
-- Indici per le tabelle `riguarda`
--
ALTER TABLE `riguarda`
  ADD PRIMARY KEY (`nomeDestinatario`,`numeroCircolare`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `circolare`
--
ALTER TABLE `circolare`
  MODIFY `numero` int(32) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
