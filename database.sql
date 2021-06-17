-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2021 at 11:01 AM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `evidencija_putovanja`
--

-- --------------------------------------------------------

--
-- Table structure for table `destinacija`
--

CREATE TABLE `destinacija` (
  `DestinacijaID` int(11) NOT NULL,
  `Naziv` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `destinacija`
--

INSERT INTO `destinacija` (`DestinacijaID`, `Naziv`) VALUES
(1, 'Santorini'),
(2, 'Parga'),
(3, 'Hurgada'),
(4, 'Kusadasi'),
(5, 'Zanzibar'),
(6, 'Sveti Stefan'),
(7, 'Plitvicka jezera'),
(8, 'Brijuni'),
(9, 'Alanja'),
(10, 'Izola'),
(11, 'Portoroz'),
(12, 'Tasos'),
(13, 'Ohrid'),
(14, 'Izmir'),
(15, 'Efes'),
(16, 'Atina'),
(17, 'Bali'),
(18, 'Nica'),
(19, 'Aja Napa'),
(21, 'Budva'),
(22, 'Dolina kraljeva');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `Ime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Prezime` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnickoIme` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Lozinka` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `KorisnikID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`Ime`, `Prezime`, `KorisnickoIme`, `Lozinka`, `KorisnikID`) VALUES
('Nikola', 'Markovic', 'nmarkovic', 'lozinka123', 1),
('Jelena', 'Nikolic', 'jnikolic', 'lozinka321', 2),
('Dragana', 'Jovanovic', 'djovanovic', 'lozinka456', 3),
('Marko', 'Stefanovic', 'mstefanovic', 'lozinka654', 4),
('Nemanja', 'Kovacevic', 'nkovacevic', 'lozinka789', 8),
('Ana', 'Bozovic', 'abozovic', 'lozinka987', 9),
('Tamara', 'Novakovic', 'tnovakovic', 'lozinka111', 10),
('Jovana', 'Jankovic', 'jjankovic', 'lozinka222', 11),
('Nikolina', 'Martinovic', 'nmartinovic', 'lozinka777', 12);

-- --------------------------------------------------------

--
-- Table structure for table `prevoz`
--

CREATE TABLE `prevoz` (
  `PrevozID` int(11) NOT NULL,
  `Vrsta` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Autobus'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `prevoz`
--

INSERT INTO `prevoz` (`PrevozID`, `Vrsta`) VALUES
(16, 'Avion'),
(17, 'Autobus');

-- --------------------------------------------------------

--
-- Table structure for table `putovanje`
--

CREATE TABLE `putovanje` (
  `PID` int(11) NOT NULL,
  `PutnikID` int(11) NOT NULL,
  `DestinacijaID` int(11) NOT NULL,
  `VremePolaska` date NOT NULL,
  `VremeDolaska` date NOT NULL,
  `DuzinaPuta` double NOT NULL,
  `CenaPuta` double NOT NULL,
  `PrevozID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `putovanje`
--

INSERT INTO `putovanje` (`PID`, `PutnikID`, `DestinacijaID`, `VremePolaska`, `VremeDolaska`, `DuzinaPuta`, `CenaPuta`, `PrevozID`) VALUES
(1, 1, 3, '2021-05-12', '2021-05-22', 2283.5, 550, 16),
(4, 3, 2, '2021-08-10', '2021-08-19', 942, 400, 17),
(5, 4, 5, '2021-04-17', '2021-04-26', 5968.4, 1500, 16),
(6, 8, 11, '2021-06-17', '2021-06-27', 638, 150, 17),
(7, 4, 16, '2021-05-11', '2021-05-20', 1349, 300, 16),
(8, 3, 19, '2021-05-11', '2021-06-16', 1580, 1500, 16),
(9, 1, 13, '2021-06-17', '2021-06-20', 613, 100, 17),
(10, 2, 12, '2021-08-18', '2021-08-28', 566, 1050, 16),
(11, 8, 18, '2021-11-17', '2021-11-24', 1057, 750, 16),
(12, 9, 21, '2021-06-10', '2021-06-18', 532, 100, 17),
(13, 11, 15, '2021-04-15', '2021-04-17', 2000, 1000, 16),
(15, 10, 2, '2021-08-10', '2021-08-19', 942, 400, 17),
(17, 3, 22, '2021-06-09', '2021-06-23', 2500, 355, 16),
(20, 12, 21, '2021-06-16', '2021-06-25', 532, 100, 17);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `destinacija`
--
ALTER TABLE `destinacija`
  ADD PRIMARY KEY (`DestinacijaID`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`KorisnikID`);

--
-- Indexes for table `prevoz`
--
ALTER TABLE `prevoz`
  ADD PRIMARY KEY (`PrevozID`);

--
-- Indexes for table `putovanje`
--
ALTER TABLE `putovanje`
  ADD PRIMARY KEY (`PID`),
  ADD KEY `PutnikID` (`PutnikID`,`DestinacijaID`,`PrevozID`),
  ADD KEY `PrevozID` (`PrevozID`),
  ADD KEY `DestinacijaID` (`DestinacijaID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `destinacija`
--
ALTER TABLE `destinacija`
  MODIFY `DestinacijaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `KorisnikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `prevoz`
--
ALTER TABLE `prevoz`
  MODIFY `PrevozID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `putovanje`
--
ALTER TABLE `putovanje`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `putovanje`
--
ALTER TABLE `putovanje`
  ADD CONSTRAINT `putovanje_ibfk_1` FOREIGN KEY (`PrevozID`) REFERENCES `prevoz` (`PrevozID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `putovanje_ibfk_2` FOREIGN KEY (`DestinacijaID`) REFERENCES `destinacija` (`DestinacijaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `putovanje_ibfk_3` FOREIGN KEY (`PutnikID`) REFERENCES `korisnik` (`KorisnikID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
