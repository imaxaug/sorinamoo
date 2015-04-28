-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.6.24-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  9.1.0.4940
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 aromabloom.cart 구조 내보내기
DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `cart_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `product_id` varchar(20) DEFAULT NULL,
  `product_count` int(11) DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `price` int(11) DEFAULT NULL COMMENT '합계 금액',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`cart_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.cart:~0 rows (대략적) 내보내기
DELETE FROM `cart`;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;


-- 테이블 aromabloom.color_size 구조 내보내기
DROP TABLE IF EXISTS `color_size`;
CREATE TABLE IF NOT EXISTS `color_size` (
  `color` varchar(10) NOT NULL,
  `size` varchar(10) NOT NULL,
  `price` int(11) NOT NULL,
  `extra_price` int(11) NOT NULL DEFAULT '0',
  `use_yn` varchar(1) NOT NULL DEFAULT 'Y',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.color_size:~60 rows (대략적) 내보내기
DELETE FROM `color_size`;
/*!40000 ALTER TABLE `color_size` DISABLE KEYS */;
INSERT INTO `color_size` (`color`, `size`, `price`, `extra_price`, `use_yn`, `create_date`, `last_update`) VALUES
	('000000', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('000000', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('000000', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('000000', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('000000', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('000000', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('022954', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('022954', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('022954', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('022954', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('022954', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('022954', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('304dc2', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('304dc2', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('304dc2', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('304dc2', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('304dc2', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('304dc2', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('8bdfff', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('8bdfff', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('8bdfff', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('8bdfff', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('8bdfff', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('8bdfff', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('c3bfbe', 'SZ007', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('c3bfbe', 'SZ008', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('c3bfbe', 'SZ009', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('c3bfbe', 'SZ010', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('c3bfbe', 'SZ011', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('c3bfbe', 'SZ012', 15000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('d02933', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('d02933', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('d02933', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('d02933', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('d02933', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('d02933', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('dc3c78', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('dc3c78', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('dc3c78', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('dc3c78', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('dc3c78', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('dc3c78', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('f8d6d5', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('f8d6d5', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('f8d6d5', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('f8d6d5', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('f8d6d5', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('f8d6d5', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffee49', 'SZ007', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffee49', 'SZ008', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffee49', 'SZ009', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffee49', 'SZ010', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffee49', 'SZ011', 13000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffee49', 'SZ012', 15000, 5000, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffffff', 'SZ007', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffffff', 'SZ008', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffffff', 'SZ009', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffffff', 'SZ010', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffffff', 'SZ011', 13000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09'),
	('ffffff', 'SZ012', 15000, 0, 'Y', '2015-04-28 15:06:09', '2015-04-28 15:06:09');
/*!40000 ALTER TABLE `color_size` ENABLE KEYS */;


-- 테이블 aromabloom.common_code 구조 내보내기
DROP TABLE IF EXISTS `common_code`;
CREATE TABLE IF NOT EXISTS `common_code` (
  `code_class_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `code_class` varchar(20) NOT NULL,
  `code_key` varchar(10) NOT NULL,
  `code_value` varchar(200) DEFAULT NULL,
  `code_order` int(11) DEFAULT NULL,
  `code_desc` varchar(5000) DEFAULT NULL,
  `use_yn` varchar(1) DEFAULT 'Y',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`code_class_id`,`code_class`,`code_key`),
  UNIQUE KEY `code_class_id_UNIQUE` (`code_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.common_code:~111 rows (대략적) 내보내기
DELETE FROM `common_code`;
/*!40000 ALTER TABLE `common_code` DISABLE KEYS */;
INSERT INTO `common_code` (`code_class_id`, `code_class`, `code_key`, `code_value`, `code_order`, `code_desc`, `use_yn`, `create_date`, `last_update`) VALUES
	(1, 'DESIGN', 'IT001', '텍스트 / 슬로건', 1, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:16'),
	(2, 'DESIGN', 'IT002', '커플/ I ♥ / 가족', 2, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:17'),
	(3, 'DESIGN', 'IT003', '게임 / 취미 / 스포츠', 3, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:19'),
	(4, 'DESIGN', 'IT004', '군대 / 종교', 4, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:20'),
	(5, 'DESIGN', 'IT005', '이벤트 / 기념일', 5, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:22'),
	(6, 'DESIGN', 'IT006', '캐릭터', 6, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:24'),
	(7, 'DESIGN', 'IT007', '해골', 7, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:25'),
	(8, 'DESIGN', 'IT008', '나라 / 장소', 8, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:27'),
	(9, 'DESIGN', 'IT009', '동물 / 식물', 9, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:28'),
	(10, 'DESIGN', 'IT010', '패션 / 빈티지', 10, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:31'),
	(11, 'DESIGN', 'IT011', '액자', 11, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:33'),
	(12, 'DESIGN', 'IT012', '리본 / 배너 / 꾸미기', 12, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:34'),
	(13, 'DESIGN', 'IT013', '아트 / 일러스트', 13, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:36'),
	(14, 'DESIGN', 'IT014', '말풍선 / 화살표', 14, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:38'),
	(15, 'DESIGN', 'IT015', '유머 / 패러디 / 시사', 15, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:40'),
	(16, 'DESIGN', 'IT016', '음식', 16, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:42'),
	(17, 'DESIGN', 'IT017', '음악 / 댄스 / 힙합', 17, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:44'),
	(18, 'DESIGN', 'IT018', '타투 / 트라이벌', 18, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:45'),
	(19, 'DESIGN', 'IT019', '한글 디자인 / 캘리그라피', 19, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:47'),
	(20, 'DESIGN', 'IT020', '앰블럼 / 로고', 20, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:49'),
	(21, 'DESIGN', 'IT021', '자동차 / 탈것', 21, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:51'),
	(22, 'DESIGN', 'IT022', '패턴 / 무늬 / 문양', 22, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:53'),
	(23, 'DESIGN', 'IT023', '스마일', 23, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:56'),
	(24, 'PRICE', '1000', '1000원', 1, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:06'),
	(25, 'PRICE', '2000', '2000원', 2, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:08'),
	(26, 'PRICE', '3000', '3000원', 3, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:11'),
	(27, 'PRICE', '4000', '4000원', 4, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:13'),
	(28, 'CATALOG', 'CAT001', '반팔', 1, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(29, 'CATALOG', 'CAT006', '긴팔 / 맨투맨', 2, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(30, 'CATALOG', 'CAT003', '후드 / 집업후드', 3, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(31, 'CATALOG', 'CAT004', '폴로 / PK 티셔츠', 4, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(32, 'CATALOG', 'CAT005', '베이스볼/나그랑', 5, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(33, 'CATALOG', 'CAT002', '남여공용', 6, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(34, 'CATALOG', 'CAT009', '민소매', 7, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(35, 'CATALOG', 'CAT010', '아동/키즈 티셔츠', 8, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(36, 'CATALOG', 'CAT008', '스포츠의류', 9, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(37, 'CATALOG', 'CAT007', '자수 제작 상품 ★', 10, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(38, 'CATALOG', 'CAT011', '머그컵', 11, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(39, 'CATALOG', 'CAT012', '캔버스백', 12, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36'),
	(40, 'CATALOG', 'CAT013', '모자', 13, NULL, 'Y', '2015-04-23 16:13:37', '2015-04-23 16:13:37'),
	(41, 'CATALOG', 'CAT014', '앞치마', 14, NULL, 'Y', '2015-04-23 16:13:37', '2015-04-23 16:13:37'),
	(42, 'TOPIC', 'TP008', '★HOT 상품', 1, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:53'),
	(43, 'TOPIC', 'TP001', '매장 유니폼', 2, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:55'),
	(44, 'TOPIC', 'TP002', '동호회 반티 과티', 3, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:57'),
	(45, 'TOPIC', 'TP003', '팀복 스트릿', 4, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:58'),
	(46, 'TOPIC', 'TP004', '가족 커플', 5, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:00'),
	(47, 'TOPIC', 'TP005', '공연 행사 이벤트', 6, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:03'),
	(48, 'TOPIC', 'TP006', '교회 단체티', 7, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:05'),
	(49, 'TOPIC', 'TP009', '베스트 상품', 8, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:06'),
	(50, 'SIZE', 'SZ001', 'XS(85)', 1, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58'),
	(51, 'SIZE', 'SZ002', 'S(90~95)', 2, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58'),
	(52, 'SIZE', 'SZ003', 'M(100)', 3, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58'),
	(53, 'SIZE', 'SZ004', 'L(105)', 4, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58'),
	(54, 'SIZE', 'SZ005', 'XL(110)', 5, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58'),
	(55, 'SIZE', 'SZ006', '2XL(120)', 6, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58'),
	(56, 'SIZE', 'SZ007', 'S(85)', 7, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58'),
	(57, 'SIZE', 'SZ008', 'M(90)', 8, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(58, 'SIZE', 'SZ009', 'L(95)', 9, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(59, 'SIZE', 'SZ010', 'XL(100)', 10, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(60, 'SIZE', 'SZ011', '2XL(105)', 11, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(61, 'SIZE', 'SZ012', '3XL(110)', 12, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(62, 'SIZE', 'SZ013', 'M(95)', 13, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(63, 'SIZE', 'SZ014', 'L(100)', 14, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(64, 'SIZE', 'SZ015', 'XL(105)', 15, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(65, 'SIZE', 'SZ016', '3~6개월', 16, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(66, 'SIZE', 'SZ017', '12~18개월', 17, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(67, 'SIZE', 'SZ018', '24개월(3호)', 18, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(68, 'SIZE', 'SZ019', '2~3살(5호)', 19, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(69, 'SIZE', 'SZ020', '4~5살(7호)', 20, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(70, 'SIZE', 'SZ021', '1T(1살)', 21, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(71, 'SIZE', 'SZ022', '2T(2살)', 22, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(72, 'SIZE', 'SZ023', '3T(12개월)', 23, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(73, 'SIZE', 'SZ024', '4T(3~4살)', 24, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59'),
	(74, 'SIZE', 'SZ025', '14호(5-6세)', 25, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(75, 'SIZE', 'SZ026', '15호(7-8세)', 26, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(76, 'SIZE', 'SZ027', '16호(9-10세)', 27, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(77, 'SIZE', 'SZ028', '17호(11-12세)', 28, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(78, 'SIZE', 'SZ029', '18호(13-14세)', 29, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(79, 'SIZE', 'SZ030', 'Free', 30, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(80, 'SIZE', 'SZ031', '11oz', 31, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(81, 'SIZE', 'SZ032', 'XS(80)', 32, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(82, 'SIZE', 'SZ033', 'S(85)', 33, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(83, 'SIZE', 'SZ034', 'M(90)', 34, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(84, 'SIZE', 'SZ035', 'L(95)', 35, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(85, 'SIZE', 'SZ036', 'XL(100)', 36, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(86, 'SIZE', 'SZ037', '2XL(110)', 37, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(87, 'SIZE', 'SZ038', 'S(75)', 38, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(88, 'SIZE', 'SZ039', 'M(80)', 39, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(89, 'SIZE', 'SZ040', 'L(85)', 40, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(90, 'SIZE', 'SZ041', 'XL(90)', 41, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00'),
	(91, 'SIZE', 'SZ042', 'XS(60)', 42, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01'),
	(92, 'SIZE', 'SZ043', 'S(65)', 43, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01'),
	(93, 'SIZE', 'SZ044', 'M(70)', 44, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01'),
	(94, 'SIZE', 'SZ045', 'L(75)', 45, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01'),
	(95, 'SIZE', 'SZ046', 'XL(85)', 46, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01'),
	(96, 'SIZE', 'SZ047', '3XL(120)', 47, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01'),
	(97, 'COLOR', '000000', '블랙   ', 1, NULL, 'Y', '2015-04-24 11:29:52', '2015-04-24 11:29:52'),
	(98, 'COLOR', '022954', '네이비 ', 2, NULL, 'Y', '2015-04-24 11:29:52', '2015-04-24 11:29:52'),
	(99, 'COLOR', '304dc2', '블루   ', 3, NULL, 'Y', '2015-04-24 11:29:52', '2015-04-24 11:29:52'),
	(100, 'COLOR', '8bdfff', '소라   ', 4, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53'),
	(101, 'COLOR', 'c3bfbe', '그레이 ', 5, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53'),
	(102, 'COLOR', 'd02933', '레드   ', 6, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53'),
	(103, 'COLOR', 'dc3c78', '핫핑크 ', 7, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53'),
	(104, 'COLOR', 'f8d6d5', '연핑크 ', 8, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53'),
	(105, 'COLOR', 'ffee49', '노랑   ', 9, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53'),
	(106, 'COLOR', 'ffffff', '화이트 ', 10, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53'),
	(107, 'TYPE', 'FT001', '앞면', 1, NULL, 'Y', '2015-04-27 18:14:00', '2015-04-27 18:14:00'),
	(108, 'TYPE', 'FT002', '뒷면', 2, NULL, 'Y', '2015-04-27 18:14:00', '2015-04-27 18:14:00'),
	(109, 'TYPE', 'FT008', '티셔츠 목뒤', 3, NULL, 'Y', '2015-04-27 18:14:00', '2015-04-27 18:14:00'),
	(110, 'TYPE', 'FT005', '왼쪽 사진', 4, NULL, 'Y', '2015-04-27 18:14:00', '2015-04-27 18:14:00'),
	(111, 'TYPE', 'FT006', '오른쪽 사진', 5, NULL, 'Y', '2015-04-27 18:14:01', '2015-04-27 18:14:01');
/*!40000 ALTER TABLE `common_code` ENABLE KEYS */;


-- 테이블 aromabloom.design 구조 내보내기
DROP TABLE IF EXISTS `design`;
CREATE TABLE IF NOT EXISTS `design` (
  `design_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `design_name` varchar(300) DEFAULT NULL,
  `file_path` varchar(500) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL COMMENT '디자인 금액',
  `premium_yn` varchar(1) DEFAULT NULL COMMENT '유/무료 구분',
  `description` varchar(2000) DEFAULT NULL,
  `seller_id` varchar(45) DEFAULT NULL,
  `use_yn` varchar(1) DEFAULT NULL,
  `best` int(11) DEFAULT '0',
  `category` varchar(10) DEFAULT NULL,
  `loc_width` int(11) DEFAULT NULL,
  `loc_height` int(11) DEFAULT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.design:~19 rows (대략적) 내보내기
DELETE FROM `design`;
/*!40000 ALTER TABLE `design` DISABLE KEYS */;
INSERT INTO `design` (`design_id`, `design_name`, `file_path`, `price`, `premium_yn`, `description`, `seller_id`, `use_yn`, `best`, `category`, `loc_width`, `loc_height`, `create_date`, `last_update`) VALUES
	(1, '복싱선수', '/up/design/3169483538_6_thumbnail.png', '1000', 'Y', '복싱선수', 'dylee', 'Y', 0, 'IT001', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(2, '복싱선수', '/up/design/3169483538_6_thumbnail.png', '2000', 'Y', '복싱선수', 'dylee', 'Y', 0, 'IT002', NULL, NULL, '2015-04-23 12:24:31', '2015-04-26 14:10:50'),
	(3, '복싱선수', '/up/design/3169483538_6_thumbnail.png', '3000', 'Y', '복싱선수', 'dylee', 'Y', 0, 'IT003', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(4, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', 0, 'IT004', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(5, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', 0, 'IT005', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(6, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', 0, 'IT006', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(7, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', 0, 'IT002', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(8, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', 0, 'IT003', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(9, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', 0, 'IT004', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(10, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱2', 'dylee', 'Y', 0, 'IT001', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(11, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱2', 'dylee', 'Y', 0, 'IT003', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(12, '복싱장갑', '/up/design/3169483538_4_thumbnail.png', '1000', 'Y', '복싱장갑', 'dylee', 'Y', 0, 'IT005', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(13, '복싱장갑', '/up/design/3169483538_3_thumbnail.png', '1000', 'Y', '복싱장갑', 'dylee', 'Y', 0, 'IT006', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(14, '복싱', '/up/design/3169483538_2_thumbnail.png', '2000', 'N', '복싱', 'dylee', 'Y', 0, 'IT003', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:28:07'),
	(15, '복싱', '/up/design/169483538_2_thumbnail.png', '2000', 'N', '복싱', 'dylee', 'Y', 0, 'IT009', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:36:19'),
	(16, '역도', '/up/design/169483538_1_thumbnail.png', '2000', 'N', '역도', 'dylee', 'Y', 0, 'IT009', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:36:21'),
	(17, '역도', '/up/design/156307142_5_thumbnail.png', '3000', 'Y', '역도', 'dylee', 'Y', 0, 'IT009', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:36:22'),
	(18, '역도', '/up/design/156307142_4_thumbnail.png', '3000', 'Y', '역도', 'dylee', 'Y', 0, 'IT009', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:36:24'),
	(19, '역도', '/up/design/156307142_3_thumbnail.png', '3000', 'Y', '역도', 'dylee', 'Y', 0, 'IT009', NULL, NULL, '2015-04-23 12:24:31', '2015-04-23 14:36:26');
/*!40000 ALTER TABLE `design` ENABLE KEYS */;


-- 테이블 aromabloom.login_history 구조 내보내기
DROP TABLE IF EXISTS `login_history`;
CREATE TABLE IF NOT EXISTS `login_history` (
  `hist_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `cntr_ip_addr` varchar(45) DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `log_out_date` datetime DEFAULT NULL,
  PRIMARY KEY (`hist_seq`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.login_history:~1 rows (대략적) 내보내기
DELETE FROM `login_history`;
/*!40000 ALTER TABLE `login_history` DISABLE KEYS */;
INSERT INTO `login_history` (`hist_seq`, `user_id`, `cntr_ip_addr`, `login_date`, `log_out_date`) VALUES
	(1, 'test@gmail.com', '0:0:0:0:0:0:0:1', '2015-04-28 15:28:20', NULL);
/*!40000 ALTER TABLE `login_history` ENABLE KEYS */;


-- 테이블 aromabloom.message 구조 내보내기
DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `mesg_key` varchar(40) NOT NULL,
  `mesg_cont` varchar(500) DEFAULT NULL,
  `lang_code` varchar(3) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`mesg_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.message:~2 rows (대략적) 내보내기
DELETE FROM `message`;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
INSERT INTO `message` (`mesg_key`, `mesg_cont`, `lang_code`, `create_date`, `last_update`) VALUES
	('validate.as.required', '아이디/비밀번호는 필수입력입니다.', 'KR', '2015-04-28 15:25:47', '2015-04-28 15:25:47'),
	('validate.user.not.login', '로그인 정보가 없습니다.', 'KR', '2015-04-28 15:25:08', '2015-04-28 15:25:08');
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


-- 테이블 aromabloom.order 구조 내보내기
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_num` varchar(20) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `order_dtm` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.order:~0 rows (대략적) 내보내기
DELETE FROM `order`;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


-- 테이블 aromabloom.product 구조 내보내기
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `hit_count` int(11) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `use_yn` varchar(1) DEFAULT 'Y',
  `display_yn` varchar(1) DEFAULT 'Y',
  `hot` varchar(10) DEFAULT NULL,
  `best` varchar(10) DEFAULT NULL,
  `desc_title` varchar(500) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `extra_price` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `file_path` varchar(100) DEFAULT NULL,
  `catalog` varchar(10) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `size_file_path` varchar(100) DEFAULT NULL,
  `size_file_name` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.product:~47 rows (대략적) 내보내기
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`product_id`, `product_name`, `hit_count`, `like_count`, `use_yn`, `display_yn`, `hot`, `best`, `desc_title`, `description`, `color`, `size`, `price`, `extra_price`, `type`, `file_path`, `catalog`, `category`, `size_file_path`, `size_file_name`, `create_date`, `last_update`) VALUES
	(1, 'Value 반팔 [20수]', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/1/ValueS_Yellow_F.png', 'CAT001', 'TP001', '/up/base_product/21/CM_Size.jpg', 'CM_Size.jpg', NULL, '2015-04-26 14:36:23'),
	(2, 'Value 긴팔 [20수]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/20/ValueL_Black_F.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(3, 'Gildan 76000 프리미엄 반팔', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/2d8ddf0e6d7373b452c9f673857607f6.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(4, 'Gildan 63000 소프트 반팔', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/ebd16fb6405c8a2e494442e757d191bc.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(5, '보카시 반팔 [20수]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/2/VH_Red_F.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(6, 'Gildan 73800 이지케어 여성 폴로반팔', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/9e4fbcf13936f6f1563adafe8a332641.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(7, 'Gildan 73800 이지케어 폴로반팔', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/00938fb9bccb0a6c89087c9a040d12fc.PNG', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(8, 'Gildan 76000 프리미엄 여성 반팔', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/34f78d9c24a5584cfc395dc437836f7e.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(9, '나그랑 반팔 [20수]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/3/ValueB_Purple_F.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(10, '나그랑 긴팔 [20수]', 2, NULL, 'Y', 'Y', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/15/ValueBL_Red_F.png', 'CAT001', 'TP001', NULL, NULL, NULL, '2015-04-24 09:26:33'),
	(11, 'AAA 1301 반팔 [수입]', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/4/AAAS_Cream_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(12, 'AAA 1701 슬림반팔 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/5/AAA1701S_Navy_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(13, 'AAA 1304 긴팔 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/19/AAAL_Blue_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(14, 'AAA V넥 반팔 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/6/AAAV_White_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(15, 'AAA  베이스볼 [수입]', 2, NULL, 'Y', 'Y', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/8d798dded79acdebf6169ed7cb546b1e.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(16, 'Basic V넥 반팔', 2, NULL, 'Y', 'Y', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/3364dbc9e54fa944985c6f3107b2a5e4.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(17, '아메리칸어페럴 베이스볼 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/17/AABB453_BWhite_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(18, 'AAA  머슬티 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/28/AAAM_Black_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(19, 'AAA 탱크탑 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/29/AAA_Tang_White_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(20, 'AAA 링어 반팔 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/10/AAAR_BBlue_F.png', 'CAT002', 'TP002', NULL, NULL, NULL, '2015-04-24 09:26:37'),
	(21, '아메리칸어페럴 반팔 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, '100% 국내제작상품. 100% 면. <br>기본스타일의 양면원단 크루넥 맨투맨입니다. <br>두툼한 원단과 늘어나지 않는 시보리밴드로 착용감이 좋은 단체티셔츠 상품입니다.<br>', NULL, NULL, NULL, NULL, NULL, '/up/base_product/14/AA2001_Rasberry_F.png', 'CAT003', 'TP003', '/up/base_product/21/CM_Size.jpg', 'CM_Size.jpg', NULL, '2015-04-24 14:25:31'),
	(22, 'PK 폴로 반팔 [20수]', 2, NULL, 'Y', 'Y', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/7/PKS_Wine_F.png', 'CAT003', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(23, 'PK 폴로 긴팔 [20수]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/18/PKL_Hpink_F.png', 'CAT003', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(24, 'Basic 라운드넥 반팔', 2, NULL, 'Y', 'Y', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/1f81f66fe0454d38d9af6f0b227e8038.png', 'CAT003', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(25, '스판텍스 반팔', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/12/KS306_Lgreen_F.png', 'CAT003', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(26, '쿨론 반팔', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/13/KS301_Blue_F.png', 'CAT004', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(27, '특양면 맨투맨', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/21/CM_Pink_F.png', 'CAT004', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(28, '특양면 후드', 2, NULL, 'Y', 'Y', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/28c30bd57ae2dedb1efcc994c3914bf0.png', 'CAT004', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(29, '특양면 집업후드', 2, NULL, 'Y', 'Y', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/9bbd5ee75bcd2871347300c8814800f4.png', 'CAT004', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(30, 'Basic 맨투맨 [기모]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/22/BM_Navy_F.png', 'CAT004', 'TP003', NULL, NULL, NULL, '2015-04-24 09:26:43'),
	(31, 'Basic 후드 [기모]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/23/BH_Chacol_F.png', 'CAT005', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(32, 'Basic 집업후드 [기모]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/27/BZ_Orange_F.png', 'CAT005', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(33, 'SHAKA 맨투맨 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/25/Shaka_Chacol_F.png', 'CAT005', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(34, 'AAA 후드 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/24/AAAH_Navy_F.png', 'CAT005', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(35, 'AAA 집업후드 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/26/AAAZ_Red_F.png', 'CAT005', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(36, '키즈 Creeper', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/33/KID_creeper_F.png', 'CAT006', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(37, '헤인즈 키즈 반팔', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/35/HKS_Pink_F.png', 'CAT006', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(38, '아메리칸어페럴 키즈베이스볼 [수입]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/34/AABB053_WBlack_F.png', 'CAT006', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(39, 'Basic 아동 반팔', 2, NULL, 'Y', 'Y', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/4efb9dbd22eb995e477857c09995d24b.png', 'CAT006', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(40, 'Value 아동 반팔 [ 20수]', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/31/ValueKS_Sora_F.png', 'CAT006', 'TP004', NULL, NULL, NULL, '2015-04-24 09:26:49'),
	(41, 'Gildan 76000 프리미엄 키즈 반팔', 2, NULL, 'Y', 'Y', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/e89d0d1b994aea11dc2b92862e814fc9.PNG', 'CAT007', 'TP005', NULL, NULL, NULL, '2015-04-24 09:26:56'),
	(42, '캔버스 스쿨가방', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/36/CSB_F.png', 'CAT007', 'TP005', NULL, NULL, NULL, '2015-04-24 09:26:56'),
	(43, '캔버스 토트가방', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/37/CTB_F.png', 'CAT007', 'TP005', NULL, NULL, NULL, '2015-04-24 09:26:56'),
	(44, '머그컵', 2, NULL, 'Y', 'Y', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/38/Mug_F.png', 'CAT007', 'TP005', NULL, NULL, NULL, '2015-04-24 09:26:56'),
	(45, '앞치마', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/11425c165963cb5c8b6183514bcf5532.png', 'CAT007', 'TP005', NULL, NULL, NULL, '2015-04-24 09:26:56'),
	(46, '매쉬캡', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/40/MS_brown.png', 'CAT007', 'TP005', NULL, NULL, NULL, '2015-04-24 09:26:56'),
	(47, '스냅백', 2, NULL, 'Y', 'Y', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/9a06ef6d5fb3f499c2460d7d93b4f7bf.png', 'CAT007', 'TP005', NULL, NULL, NULL, '2015-04-24 09:26:56');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- 테이블 aromabloom.product_color 구조 내보내기
DROP TABLE IF EXISTS `product_color`;
CREATE TABLE IF NOT EXISTS `product_color` (
  `product_id` int(11) NOT NULL,
  `color` varchar(10) NOT NULL,
  `extra_price` int(11) NOT NULL DEFAULT '0',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`,`color`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.product_color:~10 rows (대략적) 내보내기
DELETE FROM `product_color`;
/*!40000 ALTER TABLE `product_color` DISABLE KEYS */;
INSERT INTO `product_color` (`product_id`, `color`, `extra_price`, `create_date`, `last_update`) VALUES
	(21, '000000', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:12'),
	(21, '022954', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:13'),
	(21, '304dc2', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:14'),
	(21, '8bdfff', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:16'),
	(21, 'c3bfbe', 0, '2015-04-28 15:09:01', '2015-04-28 15:09:01'),
	(21, 'd02933', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:18'),
	(21, 'dc3c78', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:20'),
	(21, 'f8d6d5', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:21'),
	(21, 'ffee49', 5000, '2015-04-28 15:09:01', '2015-04-28 15:48:23'),
	(21, 'ffffff', 0, '2015-04-28 15:09:01', '2015-04-28 15:09:01');
/*!40000 ALTER TABLE `product_color` ENABLE KEYS */;


-- 테이블 aromabloom.product_image 구조 내보내기
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE IF NOT EXISTS `product_image` (
  `product_id` int(11) NOT NULL,
  `image` varchar(300) DEFAULT NULL COMMENT '기본 이미지',
  `list` varchar(300) DEFAULT NULL COMMENT '전체 상품 리스트 이미지',
  `cart` varchar(300) DEFAULT NULL COMMENT '장바구니 이미지',
  `front_img` varchar(300) DEFAULT NULL COMMENT '전면',
  `back_img` varchar(300) DEFAULT NULL,
  `left_img` varchar(300) DEFAULT NULL,
  `right_img` varchar(300) DEFAULT NULL,
  `hat_left_img` varchar(300) DEFAULT NULL,
  `hat_right_img` varchar(300) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.product_image:~0 rows (대략적) 내보내기
DELETE FROM `product_image`;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;


-- 테이블 aromabloom.product_size 구조 내보내기
DROP TABLE IF EXISTS `product_size`;
CREATE TABLE IF NOT EXISTS `product_size` (
  `product_id` int(11) NOT NULL,
  `size` varchar(10) NOT NULL,
  `price` int(11) NOT NULL DEFAULT '0',
  `extra_price` int(11) NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`,`size`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.product_size:~6 rows (대략적) 내보내기
DELETE FROM `product_size`;
/*!40000 ALTER TABLE `product_size` DISABLE KEYS */;
INSERT INTO `product_size` (`product_id`, `size`, `price`, `extra_price`, `create_date`, `last_update`) VALUES
	(21, 'SZ007', 13000, 5000, '2015-04-28 15:09:57', '2015-04-28 15:46:41'),
	(21, 'SZ008', 13000, 5000, '2015-04-28 15:09:57', '2015-04-28 15:46:45'),
	(21, 'SZ009', 13000, 5000, '2015-04-28 15:09:57', '2015-04-28 15:46:47'),
	(21, 'SZ010', 13000, 5000, '2015-04-28 15:09:57', '2015-04-28 15:46:49'),
	(21, 'SZ011', 13000, 5000, '2015-04-28 15:09:57', '2015-04-28 15:46:51'),
	(21, 'SZ012', 15000, 5000, '2015-04-28 15:09:57', '2015-04-28 15:46:53');
/*!40000 ALTER TABLE `product_size` ENABLE KEYS */;


-- 테이블 aromabloom.product_type 구조 내보내기
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE IF NOT EXISTS `product_type` (
  `product_id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL,
  `file_type` varchar(10) DEFAULT NULL,
  `loc_top` int(11) DEFAULT NULL,
  `loc_left` int(11) DEFAULT NULL,
  `loc_width` int(11) DEFAULT NULL,
  `loc_height` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `only_vector` varchar(1) DEFAULT NULL,
  `file_path` varchar(100) DEFAULT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.product_type:~5 rows (대략적) 내보내기
DELETE FROM `product_type`;
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT INTO `product_type` (`product_id`, `type`, `file_type`, `loc_top`, `loc_left`, `loc_width`, `loc_height`, `price`, `only_vector`, `file_path`, `file_name`, `sort`, `create_date`, `last_update`) VALUES
	(21, 'MAIN', 'FT001', 115, 162, 340, 220, 6000, 'N', '/up/base_product/21/CM_White_F.png', 'CM_White_F.png', 1, '2015-04-28 15:10:30', '2015-04-28 15:10:30'),
	(21, 'MAIN', 'FT002', 110, 160, 340, 220, 6000, 'N', '/up/base_product/21/CM_White_B.png', 'CM_White_B.png', 2, '2015-04-28 15:10:30', '2015-04-28 15:10:30'),
	(21, 'MAIN', 'FT005', 110, 115, 180, 290, 3000, 'Y', '/up/base_product/21/CM_White_N.png', 'CM_White_N.png', 3, '2015-04-28 15:10:30', '2015-04-28 15:10:30'),
	(21, 'MAIN', 'FT006', 160, 240, 330, 100, 3000, 'Y', '/up/base_product/21/CM_White_L.png', 'CM_White_L.png', 4, '2015-04-28 15:10:30', '2015-04-28 15:10:30'),
	(21, 'MAIN', 'FT008', 160, 210, 330, 100, 3000, 'Y', '/up/base_product/21/CM_White_R.png', 'CM_White_R.png', 5, '2015-04-28 15:10:30', '2015-04-28 15:10:30');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;


-- 테이블 aromabloom.type_size 구조 내보내기
DROP TABLE IF EXISTS `type_size`;
CREATE TABLE IF NOT EXISTS `type_size` (
  `product_type` varchar(10) DEFAULT NULL,
  `product_size` varchar(10) DEFAULT NULL,
  `loc_top` int(11) DEFAULT NULL,
  `loc_left` int(11) DEFAULT NULL,
  `loc_width` int(11) DEFAULT NULL,
  `loc_height` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `use_yn` varchar(1) DEFAULT NULL,
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.type_size:~31 rows (대략적) 내보내기
DELETE FROM `type_size`;
/*!40000 ALTER TABLE `type_size` DISABLE KEYS */;
INSERT INTO `type_size` (`product_type`, `product_size`, `loc_top`, `loc_left`, `loc_width`, `loc_height`, `product_id`, `use_yn`, `create_date`, `last_update`) VALUES
	('FT001', 'SZ007', 3, 5, 34, 38, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT001', 'SZ007', 3, 5, 34, 38, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT001', 'SZ008', 3, 5, 34, 38, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT001', 'SZ009', 3, 5, 36, 40, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT001', 'SZ010', 3, 5, 36, 40, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT001', 'SZ011', 3, 5, 38, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT001', 'SZ012', 3, 5, 38, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT002', 'SZ007', 7, 5, 34, 38, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT002', 'SZ008', 7, 5, 34, 38, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT002', 'SZ009', 7, 5, 36, 40, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT002', 'SZ010', 7, 5, 36, 40, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT002', 'SZ011', 7, 5, 38, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT002', 'SZ012', 7, 5, 38, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT005', 'SZ007', 1, 1, 12, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT005', 'SZ008', 1, 1, 12, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT005', 'SZ009', 1, 1, 12, 44, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT005', 'SZ010', 1, 1, 12, 46, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT005', 'SZ011', 1, 1, 12, 46, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT005', 'SZ012', 1, 1, 12, 48, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT006', 'SZ007', 1, 1, 12, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT006', 'SZ008', 1, 1, 12, 42, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT006', 'SZ009', 1, 1, 12, 44, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT006', 'SZ010', 1, 1, 12, 46, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT006', 'SZ011', 1, 1, 12, 46, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT006', 'SZ012', 1, 1, 12, 48, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT008', 'SZ007', 1, 1, 12, 7, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT008', 'SZ008', 1, 1, 12, 7, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT008', 'SZ009', 1, 1, 12, 7, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT008', 'SZ010', 1, 1, 12, 7, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT008', 'SZ011', 1, 1, 12, 7, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02'),
	('FT008', 'SZ012', 1, 1, 12, 7, 21, 'Y', '2015-04-28 15:23:02', '2015-04-28 15:23:02');
/*!40000 ALTER TABLE `type_size` ENABLE KEYS */;


-- 테이블 aromabloom.user 구조 내보내기
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(50) NOT NULL COMMENT '아이디(이메일)',
  `password` varchar(100) NOT NULL COMMENT '비밀번호(DB 암호화)',
  `hp_num` varchar(45) DEFAULT NULL COMMENT '휴대폰번호(자바 암호화)',
  `birth_date` varchar(8) DEFAULT NULL COMMENT '생년월일',
  `recv_email_yn` varchar(1) DEFAULT 'N' COMMENT '이메일 수신 동의',
  `recv_sms_yn` varchar(1) DEFAULT 'N' COMMENT 'SMS 수신 동의',
  `recv_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '수신 동의 일자',
  `access_terms_yn` varchar(1) DEFAULT 'N' COMMENT '이용약관 동의 YN',
  `personal_terms_yn` varchar(1) DEFAULT 'N' COMMENT '개인정보 취급 동의 YN',
  `alias_id` int(11) NOT NULL,
  `nick_name` varchar(45) DEFAULT NULL COMMENT '닉네임',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자',
  `last_update` datetime DEFAULT NULL COMMENT '수정일자',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `alias_id_UNIQUE` (`alias_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 aromabloom.user:~1 rows (대략적) 내보내기
DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `password`, `hp_num`, `birth_date`, `recv_email_yn`, `recv_sms_yn`, `recv_date`, `access_terms_yn`, `personal_terms_yn`, `alias_id`, `nick_name`, `create_date`, `last_update`) VALUES
	('test@gmail.com', 'B9CDBC8EE8FF0AA78B2C6928F8C30080', '', '', 'N', 'N', '2015-04-28 15:27:57', 'N', 'N', 64757167, '', '2015-04-28 15:27:57', NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
