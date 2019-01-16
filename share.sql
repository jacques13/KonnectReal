-- phpMyAdmin SQL Dump
-- version 4.4.9
-- http://www.phpmyadmin.net
--
-- Host: 50.62.209.74:3306
-- Generation Time: Sep 05, 2015 at 09:18 AM
-- Server version: 5.5.43-37.2-log
-- PHP Version: 5.5.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `share`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE IF NOT EXISTS `events` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `img` varchar(250) NOT NULL,
  `number` int(254) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`id`, `user_id`, `name`, `date`, `time`, `latitude`, `longitude`, `img`, `number`) VALUES
(17, 3, 'test', '3915-07-17', '13:41:00', -26.1032973, 27.9274355, '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `featured events`
--

CREATE TABLE IF NOT EXISTS `featured events` (
  `id` int(254) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(254) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `img` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `follow`
--

CREATE TABLE IF NOT EXISTS `follow` (
  `id` bigint(11) NOT NULL,
  `user_one` int(11) NOT NULL,
  `user_two` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `follow`
--

INSERT INTO `follow` (`id`, `user_one`, `user_two`) VALUES
(30, 8, 7),
(32, 9, 8),
(33, 10, 8),
(34, 11, 8),
(35, 12, 8),
(36, 13, 8),
(37, 14, 8),
(38, 15, 8),
(39, 16, 8),
(54, 8, 9),
(58, 7, 8),
(59, 7, 3),
(70, 3, 7),
(71, 3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `going`
--

CREATE TABLE IF NOT EXISTS `going` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `going`
--

INSERT INTO `going` (`id`, `user_id`, `event_id`) VALUES
(34, 3, 2),
(36, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `ID` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `permissions` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE IF NOT EXISTS `info` (
  `id` int(254) NOT NULL,
  `user_id` int(254) NOT NULL,
  `facebook` varchar(254) NOT NULL,
  `twitter` varchar(254) NOT NULL,
  `instagram` varchar(254) NOT NULL,
  `pinterest` varchar(254) NOT NULL,
  `tumblr` varchar(254) NOT NULL,
  `linkedin` varchar(254) NOT NULL,
  `vine` varchar(254) NOT NULL,
  `bbm` varchar(254) NOT NULL,
  `whatsapp` varchar(254) NOT NULL,
  `google` varchar(254) NOT NULL,
  `snapchat` varchar(254) NOT NULL,
  `wechat` varchar(254) NOT NULL,
  `mxit` varchar(254) NOT NULL,
  `zoosk` varchar(254) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`id`, `user_id`, `facebook`, `twitter`, `instagram`, `pinterest`, `tumblr`, `linkedin`, `vine`, `bbm`, `whatsapp`, `google`, `snapchat`, `wechat`, `mxit`, `zoosk`) VALUES
(5, 36, 'norshaf@gmail.com', '', '', '', '', '', '', '', '01927278989', 'norshaf@gmail.com', '', 'reen_ahamad', '', ''),
(6, 39, 'reen.agama.5@Facebook.com', 'mama June', 'noreen_aha mad ', '', '', '', '', '', '', '', '', '', '', ''),
(7, 40, 'obuseli obi david', 'trinityflames', 'trinity_flames', '', '', '', '', '', '+2348064595463', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `invites`
--

CREATE TABLE IF NOT EXISTS `invites` (
  `id` int(254) NOT NULL,
  `my_id` int(254) NOT NULL,
  `user_id` int(254) NOT NULL,
  `event_id` int(254) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invites`
--

INSERT INTO `invites` (`id`, `my_id`, `user_id`, `event_id`) VALUES
(111, 3, 32, 17);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(32) NOT NULL,
  `email` varchar(254) NOT NULL,
  `userGroup` int(11) NOT NULL,
  `gender` varchar(6) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `password`, `salt`, `email`, `userGroup`, `gender`) VALUES
(3, 'jacques14', '5693e3ed1d1ec630b8ab038f06abd2554258262826db34d8771938a34000b7d7', ')x/âOˆÚH;yä\0ÕñJù±‡\\ËÇ^ï½`Iœ6Ÿõ¤»', 'jacques.pieterse13@gmail.com', 1, 'female'),
(32, 'Austin Labuschagne', '937799dd50867b6667ba30506de280360cb13eaa7a92b4eaba9693c6ab2e02c7', 'U*ãÏ©µ\r0õËE\n/@{€^/®®mÏ°¸óŸyÝ', 'aalabuschagne@gmail.com', 1, 'male'),
(33, 'andre', 'f9f04a7406da85b2706f2c88e54057b9f5945b513d655b3f7f7d741c87390430', 'û½}æ½Õå·Òã;ç¢“ëÞKQ©õ¯¹&\\lâ', 'andre@gmail.com', 1, 'male'),
(34, 'htreasurechilton', 'd9ddf940b3ddfb6718dc9661d8b7fcf7f4d20fab802cf1e6f50eff73cda2666e', '	ÆñïÎ”+è?r€¾SûÉUÌØb.þ™·\r©q®“µ', 'htreasurech@gmail.com', 1, 'female'),
(35, 'baconmonster24', '9a65f20b90c73feb89761b0779fcd5cd7939b65f2c89113abb6a3b237af33115', 'kE%0µôGÉM=ˆÏD)ÚöâF€øÑ“NáÅc²+±>m', 'bubb', 1, 'male'),
(36, 'brandon.maze978.mark', 'ec06518770621b5931835ac337bab2f59754a9dc6e5e7a850d0d87097b4d2152', 'ë­&*@–†è9¡paæÇ–N¯;-Ÿ´"C‚Uæôþ6<', 'dee99.28.dd@gmail.com', 1, 'male'),
(37, 'victor ', '35930bb45dab3aba2cee71ac2f53bad16a12468c1ac4862b2ee641b70045da5d', 'Ðdé&rŸ®xã8nÎlkðbzx¤~;ÉØ¨›Ç±ê', 'vpimentel311@gmail.com', 1, 'male'),
(38, 'peroljuan', 'ef36c5dbf5358047b490499dcf9f60227949f8af31715cd2b9b896e2c0e8789b', 'ÈªCejÒÚ€{™”oàôw:œ”±,„Ÿb<˜4¢', 'emaqu@hotmail.com', 1, 'male'),
(39, 'spazio', 'c6dc5ae205f7239cc0e63fb07162ab4eebc2db446030ce56c5228fc7e121f308', '\\ÏoÆ¾.¢ëÒ§²^ˆ­‘z©FûLF	†=ŽÜv¨‹', 'dimanafantasia@gmail.com', 1, 'male'),
(40, 'trinityflames', 'a87512d4d2e6599f55b5cb51c7c0df68c24cc5f8966cd5acacc3c9f2f5bfda18', '\\_°F{›—Ô©yç°í¨Ít;™K€ùˆ	±½', 'obuseliobi@gmail.com', 1, 'male'),
(41, 'amgd197549@gmail.com', 'f4efff482f15e81faa8784ad7a011fbc737a19dcac02ed9e647ea678cce3cdfa', 'FÃ)®!+ÍÕÈ‚$ú®<+;mÜ¡b=rw¥Í¡Œ‰î‰&', 'aliali', 1, 'male'),
(42, 'sadek.shareif@gmail.', 'ac4a82ceac85c5f50e1cfa623d2e34caa67804133c6fa55c9fd4110068f8c69f', 'r£¦ÕTÿÅ²ýc¸WcÇŒŒvÊÌŒÜå;‹ù,&a', 'amgdamgd1975', 1, 'male'),
(43, 'Nann', '5cc2b1f974fc425d4ca4550abd3ad536a281c8b14050b08a0f3e4168d9ba5c33', '¬-­•ÏzçÑÍôê\\VI¾ÒU~ÙïDKI¦ÁI®·í', 'jlouque39@gmail.com', 1, 'female'),
(44, 'Satirobig', 'def215a31ee7f3eaeb9aa2e1bda4c9d023b65338926e14101229854c47641ce7', 'ìˆSl¯''áîr˜aÂµUO»³åJÁs#ÜrÖX', 'ricardoluna77@gmail.com', 1, 'male'),
(45, 'misli andrean', 'f317ff68bae78e33690ab4411dff581c68605c19e07390380090a6653f86c52b', 'ÌþÑ8sO¶Xý}tÆ›|HR¤ }VëÆ: ¯‹/Ã¢ð', 'mislianrean@gmail.com', 1, 'male'),
(46, 'Aeli1982', '907d32b218987dea2444cd158f7f7ff5704a1564cdc974da9f91889d8b06de65', '	åý’¹~Cö—þÓÁÍtOpèÞ‘€PñýX1H', 'abiveli1982@gmail.com', 1, 'male'),
(52, 'christymorrow', 'c938f55c6a6e9958f217e1431613e0740185eeeac6da7db92b74dcdd90675d75', 'L¢©ØÎ·é€Ø>µEZUD35Ïï»¬\nNpLrØ½	I', '', 1, 'female'),
(53, 'tonyblackrocks@gmail', 'ef55bcda70afd21b83dab8c665cb937b5c96e7bb92dc41c83c8a3ab6e1691f29', '2£‡_ÅèJÈ¬Yßj7Ã™’ùãªšÛmš½<uB§', 'tonyblackrocks@gmail.com', 1, 'male'),
(55, 'slave4party', '38b5ca07be720a9243fb18a7bc085accbf2b61c6f859f0e0d4e54a67c0b6a22b', '	Á^y¢½–!Æbš˜@ É.†œ¿c]rÙ2–üŠˆí', 'slave4party@gmail.com', 1, 'male'),
(57, 'babybluangel94', '36f86850b568e0c638741af1edeaa9d4c1acbc3d8b1f5ade5533ab9590d0d392', 'tgKêþðr©Jj˜4,_ÆzQ˜•“F@ã³ý´4Ñ§', 'babybluangel94@gmail.com', 1, 'female');

-- --------------------------------------------------------

--
-- Table structure for table `userssessions`
--

CREATE TABLE IF NOT EXISTS `userssessions` (
  `ID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `hash` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userssessions`
--

INSERT INTO `userssessions` (`ID`, `userID`, `hash`) VALUES
(1, 1, 'bc54ec088006b31f8b1dbfe4d1afa9be1061c7f3d886351142');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `featured events`
--
ALTER TABLE `featured events`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `follow`
--
ALTER TABLE `follow`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `going`
--
ALTER TABLE `going`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `invites`
--
ALTER TABLE `invites`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `userssessions`
--
ALTER TABLE `userssessions`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `featured events`
--
ALTER TABLE `featured events`
  MODIFY `id` int(254) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `follow`
--
ALTER TABLE `follow`
  MODIFY `id` bigint(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=72;
--
-- AUTO_INCREMENT for table `going`
--
ALTER TABLE `going`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `info`
--
ALTER TABLE `info`
  MODIFY `id` int(254) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `invites`
--
ALTER TABLE `invites`
  MODIFY `id` int(254) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=112;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT for table `userssessions`
--
ALTER TABLE `userssessions`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
