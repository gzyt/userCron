-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.16 - MySQL Community Server - GPL
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for qz
CREATE DATABASE IF NOT EXISTS `qz` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `qz`;

-- Dumping structure for table qz.user_department
CREATE TABLE IF NOT EXISTS `user_department` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `department_code` varchar(10) DEFAULT NULL COMMENT '部门编码',
  `department_name` varchar(30) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工部门表';

-- Dumping data for table qz.user_department: ~1 rows (大约)
/*!40000 ALTER TABLE `user_department` DISABLE KEYS */;
REPLACE INTO `user_department` (`id`, `department_code`, `department_name`) VALUES
	(1, '0001', '武汉技术开发部');
/*!40000 ALTER TABLE `user_department` ENABLE KEYS */;

-- Dumping structure for table qz.user_info
CREATE TABLE IF NOT EXISTS `user_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(11) NOT NULL COMMENT '用户姓名',
  `password` varchar(50) NOT NULL COMMENT '用户密码',
  `usercode` varchar(30) NOT NULL COMMENT '用户工号',
  `dpartment_code` varchar(30) NOT NULL COMMENT '部门编码',
  `station_code` varchar(50) NOT NULL COMMENT '岗位编码',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- Dumping data for table qz.user_info: ~2 rows (大约)
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
REPLACE INTO `user_info` (`id`, `username`, `password`, `usercode`, `dpartment_code`, `station_code`, `create_time`) VALUES
	(1, '张天旭', '123456', 'YN20190360', '0001', '0001', '2019-09-02 06:21:00'),
	(2, 'admin', '123456', '0001', '0001', '0001', '2019-09-03 15:14:46');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

-- Dumping structure for table qz.user_station
CREATE TABLE IF NOT EXISTS `user_station` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '职位ID',
  `station_name` varchar(50) DEFAULT NULL COMMENT '职位名称',
  `station_code` varchar(50) DEFAULT NULL COMMENT '职位编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工职位';

-- Dumping data for table qz.user_station: ~1 rows (大约)
/*!40000 ALTER TABLE `user_station` DISABLE KEYS */;
REPLACE INTO `user_station` (`id`, `station_name`, `station_code`) VALUES
	(1, 'java开发工程师', '0001');
/*!40000 ALTER TABLE `user_station` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
