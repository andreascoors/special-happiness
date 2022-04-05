-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: mysql:3306
-- Erstellungszeit: 05. Apr 2022 um 08:21
-- Server-Version: 8.0.28
-- PHP-Version: 8.0.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Datenbank: `special-happiness`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `arbeitspakete`
--

CREATE TABLE `arbeitspakete` (
  `id` bigint NOT NULL,
  `aufwand` int NOT NULL,
  `beschreibung` longtext,
  `end_datum` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_datum` date DEFAULT NULL,
  `mitarbeiter_id` bigint DEFAULT NULL,
  `projekt_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Daten für Tabelle `arbeitspakete`
--

INSERT INTO `arbeitspakete` (`id`, `aufwand`, `beschreibung`, `end_datum`, `name`, `start_datum`, `mitarbeiter_id`, `projekt_id`) VALUES
(1, 0, 'beschreibung', '2022-04-05', 'name', '2022-04-04', 1, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Daten für Tabelle `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(8);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `mitarbeiter`
--

CREATE TABLE `mitarbeiter` (
  `id` bigint NOT NULL,
  `geburtsdatum` date DEFAULT NULL,
  `nachname` varchar(255) DEFAULT NULL,
  `vorname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Daten für Tabelle `mitarbeiter`
--

INSERT INTO `mitarbeiter` (`id`, `geburtsdatum`, `nachname`, `vorname`) VALUES
(1, '1995-10-15', 'Coors', 'Andreas');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `projekte`
--

CREATE TABLE `projekte` (
  `id` bigint NOT NULL,
  `beschreibung` longtext,
  `end_datum` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_datum` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Daten für Tabelle `projekte`
--

INSERT INTO `projekte` (`id`, `beschreibung`, `end_datum`, `name`, `start_datum`) VALUES
(0, 'Es ist eine Software zu entwickeln, die die Verwaltung von Projekten ermöglicht. Je Projekt werden Angaben zum Zeitraum (Start- und Enddatum), eine Beschreibung und eine Liste zugehöriger Mitarbeiterinnen gespeichert. Nur zugehörige Mitarbeiterinnen können die Projektdaten sehen, wenn sie sich anmelden. Herzstück der Projektdaten stellt die Liste der Arbeitspakete (AP) dar. Je AP werden die Eigenschaften Name, Beschreibung, Start- und Enddatum, Aufwand und verantwortliche Mitarbeiterinnen (1:N) gespeichert. Die Anwendung zeigt angemeldeten Anwenderinnen in der Liste der Projekte die Summe des Aufwand aller zugehörigen Arbeitspakete. Es sind CRUD-Operationen auf alle Entitäten zu realisieren, die für Anwender*innen über die Web-Anwendung erreichbar sind. Dies schließt auch die Pflege von Basislisten ein.', '2022-08-08', 'Planen und realisieren Sie eine Web-Anwendung …', '2022-04-04');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `projekte_mitarbeiter`
--

CREATE TABLE `projekte_mitarbeiter` (
  `projekte_id` bigint NOT NULL,
  `mitarbeiter_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Daten für Tabelle `projekte_mitarbeiter`
--

INSERT INTO `projekte_mitarbeiter` (`projekte_id`, `mitarbeiter_id`) VALUES
(0, 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `arbeitspakete`
--
ALTER TABLE `arbeitspakete`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_17809diouw6se9669hqdwv5hf` (`name`),
  ADD KEY `FK39yk2b0x7h4q43xul3ews8d7e` (`mitarbeiter_id`),
  ADD KEY `FKn67ompwav1fx66fqq111cvccx` (`projekt_id`);

--
-- Indizes für die Tabelle `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `projekte`
--
ALTER TABLE `projekte`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6x668yxb1a4kle6b2xnm8m1pu` (`name`);

--
-- Indizes für die Tabelle `projekte_mitarbeiter`
--
ALTER TABLE `projekte_mitarbeiter`
  ADD UNIQUE KEY `UK_aho02ttms32tavxyn7322kjyb` (`mitarbeiter_id`),
  ADD KEY `FKwn9io5c3cebkao1vm9b4xkpi` (`projekte_id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `arbeitspakete`
--
ALTER TABLE `arbeitspakete`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT für Tabelle `mitarbeiter`
--
ALTER TABLE `mitarbeiter`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `arbeitspakete`
--
ALTER TABLE `arbeitspakete`
  ADD CONSTRAINT `FK39yk2b0x7h4q43xul3ews8d7e` FOREIGN KEY (`mitarbeiter_id`) REFERENCES `mitarbeiter` (`id`),
  ADD CONSTRAINT `FKn67ompwav1fx66fqq111cvccx` FOREIGN KEY (`projekt_id`) REFERENCES `projekte` (`id`);

--
-- Constraints der Tabelle `projekte_mitarbeiter`
--
ALTER TABLE `projekte_mitarbeiter`
  ADD CONSTRAINT `FK8yxp64p4w7m8mtae00fs0vjju` FOREIGN KEY (`mitarbeiter_id`) REFERENCES `mitarbeiter` (`id`),
  ADD CONSTRAINT `FKwn9io5c3cebkao1vm9b4xkpi` FOREIGN KEY (`projekte_id`) REFERENCES `projekte` (`id`);
COMMIT;
