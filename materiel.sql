-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 15 fév. 2023 à 16:11
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bdmateriel`
--

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `id` bigint(20) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `date_acquisition` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `etat` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`id`, `date`, `date_acquisition`, `description`, `etat`, `nom`, `reference`) VALUES
(8, NULL, '2022-10-15', 'bon bon comme le bonbon', 'En reparation', 'Iphone', 'refT12'),
(6, NULL, '2022-04-06', 'Core i5 de marque Hp', 'Neuf', 'PC', 'C13'),
(7, NULL, '2022-04-11', 'TECNO CANON 19', 'Neuf', 'Telephone', 'refJ67'),
(5, NULL, '2022-04-21', 'pour laver le sol', 'Neuf', 'Seau', 'S12'),
(9, NULL, '2022-11-15', '1 Téra , marque Toshiba', 'Neuf', 'Disque Dur', 'H21'),
(10, NULL, '2023-01-12', 'VMFLS.LN.E\r\n', 'En panne', 'TECNO', '12');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
