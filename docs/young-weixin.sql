CREATE DATABASE `young-weixin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE `weixin_subscribe_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `createtime` varchar(20) DEFAULT NULL,
  `updatetime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

