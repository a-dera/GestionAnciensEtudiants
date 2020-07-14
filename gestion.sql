-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 09 juil. 2020 à 11:05
-- Version du serveur :  10.4.13-MariaDB
-- Version de PHP : 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion`
--

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `matricule` text NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telephone` varchar(30) DEFAULT NULL,
  `lieuResidence` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



--
-- Structure de la table `diplome`
--

CREATE TABLE `diplome` (
  `matricule` varchar(30) NOT NULL,
  `filiereL` varchar(30) DEFAULT NULL,
  `filiereM` varchar(30) DEFAULT NULL,
  `noteSoutenanceL` float DEFAULT NULL,
  `noteSoutenanceM` float DEFAULT NULL,
  `promotionAnnee` int(8) NOT NULL,
  `anneeObtentionL` int(8) DEFAULT NULL,
  `anneeObtentionM` int(8) DEFAULT NULL,
  `detientLicence` tinyint(1) DEFAULT NULL,
  `detientMaster` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `matricule` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `sexe` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Structure de la table `travail`
--

CREATE TABLE `travail` (
  `matricule` varchar(30) NOT NULL,
  `posteActuel` varchar(50) DEFAULT NULL,
  `lieuTravail` varchar(50) DEFAULT NULL,
  `possedeTravail` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Index pour les tables déchargées
--

--
-- Index pour la table `diplome`
--
ALTER TABLE `diplome`
  ADD UNIQUE KEY `matricule` (`matricule`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`matricule`),
  ADD UNIQUE KEY `matricule` (`matricule`);

--
-- Index pour la table `travail`
--
ALTER TABLE `travail`
  ADD UNIQUE KEY `matricule` (`matricule`);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
