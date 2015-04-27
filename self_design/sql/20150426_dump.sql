-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.6.24-log - MySQL Community Server (GPL)
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 테이블 aromabloom의 구조를 덤프합니다. cart
DROP TABLE IF EXISTS `cart`;
CREATE TABLE IF NOT EXISTS `cart` (
  `cart_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `goods_count` int(11) DEFAULT NULL,
  `goods_code` varchar(20) DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `last_update` datetime DEFAULT NULL,
  `color` varchar(10) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `price` int(11) DEFAULT NULL COMMENT '합계 금액',
  PRIMARY KEY (`cart_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.cart: ~0 rows (대략적)
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. color_size
DROP TABLE IF EXISTS `color_size`;
CREATE TABLE IF NOT EXISTS `color_size` (
  `color` varchar(10) NOT NULL,
  `size` varchar(10) NOT NULL,
  `price` int(11) NOT NULL,
  `extra_price` int(11) NOT NULL DEFAULT '0',
  `use_yn` varchar(1) NOT NULL DEFAULT 'Y'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.color_size: ~60 rows (대략적)
/*!40000 ALTER TABLE `color_size` DISABLE KEYS */;
INSERT IGNORE INTO `color_size` (`color`, `size`, `price`, `extra_price`, `use_yn`) VALUES
	('000000', 'SZ007', 13000, 5000, 'Y'),
	('000000', 'SZ008', 13000, 5000, 'Y'),
	('000000', 'SZ009', 13000, 5000, 'Y'),
	('000000', 'SZ010', 13000, 5000, 'Y'),
	('000000', 'SZ011', 13000, 5000, 'Y'),
	('000000', 'SZ012', 15000, 5000, 'Y'),
	('022954', 'SZ007', 13000, 5000, 'Y'),
	('022954', 'SZ008', 13000, 5000, 'Y'),
	('022954', 'SZ009', 13000, 5000, 'Y'),
	('022954', 'SZ010', 13000, 5000, 'Y'),
	('022954', 'SZ011', 13000, 5000, 'Y'),
	('022954', 'SZ012', 15000, 5000, 'Y'),
	('304dc2', 'SZ007', 13000, 5000, 'Y'),
	('304dc2', 'SZ008', 13000, 5000, 'Y'),
	('304dc2', 'SZ009', 13000, 5000, 'Y'),
	('304dc2', 'SZ010', 13000, 5000, 'Y'),
	('304dc2', 'SZ011', 13000, 5000, 'Y'),
	('304dc2', 'SZ012', 15000, 5000, 'Y'),
	('8bdfff', 'SZ007', 13000, 5000, 'Y'),
	('8bdfff', 'SZ008', 13000, 5000, 'Y'),
	('8bdfff', 'SZ009', 13000, 5000, 'Y'),
	('8bdfff', 'SZ010', 13000, 5000, 'Y'),
	('8bdfff', 'SZ011', 13000, 5000, 'Y'),
	('8bdfff', 'SZ012', 15000, 5000, 'Y'),
	('c3bfbe', 'SZ007', 13000, 0, 'Y'),
	('c3bfbe', 'SZ008', 13000, 0, 'Y'),
	('c3bfbe', 'SZ009', 13000, 0, 'Y'),
	('c3bfbe', 'SZ010', 13000, 0, 'Y'),
	('c3bfbe', 'SZ011', 13000, 0, 'Y'),
	('c3bfbe', 'SZ012', 15000, 0, 'Y'),
	('d02933', 'SZ007', 13000, 5000, 'Y'),
	('d02933', 'SZ008', 13000, 5000, 'Y'),
	('d02933', 'SZ009', 13000, 5000, 'Y'),
	('d02933', 'SZ010', 13000, 5000, 'Y'),
	('d02933', 'SZ011', 13000, 5000, 'Y'),
	('d02933', 'SZ012', 15000, 5000, 'Y'),
	('dc3c78', 'SZ007', 13000, 5000, 'Y'),
	('dc3c78', 'SZ008', 13000, 5000, 'Y'),
	('dc3c78', 'SZ009', 13000, 5000, 'Y'),
	('dc3c78', 'SZ010', 13000, 5000, 'Y'),
	('dc3c78', 'SZ011', 13000, 5000, 'Y'),
	('dc3c78', 'SZ012', 15000, 5000, 'Y'),
	('f8d6d5', 'SZ007', 13000, 5000, 'Y'),
	('f8d6d5', 'SZ008', 13000, 5000, 'Y'),
	('f8d6d5', 'SZ009', 13000, 5000, 'Y'),
	('f8d6d5', 'SZ010', 13000, 5000, 'Y'),
	('f8d6d5', 'SZ011', 13000, 5000, 'Y'),
	('f8d6d5', 'SZ012', 15000, 5000, 'Y'),
	('ffee49', 'SZ007', 13000, 5000, 'Y'),
	('ffee49', 'SZ008', 13000, 5000, 'Y'),
	('ffee49', 'SZ009', 13000, 5000, 'Y'),
	('ffee49', 'SZ010', 13000, 5000, 'Y'),
	('ffee49', 'SZ011', 13000, 5000, 'Y'),
	('ffee49', 'SZ012', 15000, 5000, 'Y'),
	('ffffff', 'SZ007', 13000, 0, 'Y'),
	('ffffff', 'SZ008', 13000, 0, 'Y'),
	('ffffff', 'SZ009', 13000, 0, 'Y'),
	('ffffff', 'SZ010', 13000, 0, 'Y'),
	('ffffff', 'SZ011', 13000, 0, 'Y'),
	('ffffff', 'SZ012', 15000, 0, 'Y');
/*!40000 ALTER TABLE `color_size` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. common_code
DROP TABLE IF EXISTS `common_code`;
CREATE TABLE IF NOT EXISTS `common_code` (
  `code_class` varchar(20) NOT NULL,
  `code_key` varchar(10) NOT NULL,
  `code_value` varchar(200) DEFAULT NULL,
  `code_order` int(11) DEFAULT NULL,
  `code_desc` varchar(5000) DEFAULT NULL,
  `code_use_yn` varchar(1) DEFAULT 'Y',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `code_class_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`code_class_id`,`code_class`,`code_key`),
  UNIQUE KEY `code_class_id_UNIQUE` (`code_class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.common_code: ~106 rows (대략적)
/*!40000 ALTER TABLE `common_code` DISABLE KEYS */;
INSERT IGNORE INTO `common_code` (`code_class`, `code_key`, `code_value`, `code_order`, `code_desc`, `code_use_yn`, `create_date`, `last_update`, `code_class_id`) VALUES
	('DESIGN', 'IT001', '텍스트 / 슬로건', 1, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:16', 1),
	('DESIGN', 'IT002', '커플/ I ♥ / 가족', 2, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:17', 2),
	('DESIGN', 'IT003', '게임 / 취미 / 스포츠', 3, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:19', 3),
	('DESIGN', 'IT004', '군대 / 종교', 4, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:20', 4),
	('DESIGN', 'IT005', '이벤트 / 기념일', 5, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:22', 5),
	('DESIGN', 'IT006', '캐릭터', 6, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:24', 6),
	('DESIGN', 'IT007', '해골', 7, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:25', 7),
	('DESIGN', 'IT008', '나라 / 장소', 8, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:27', 8),
	('DESIGN', 'IT009', '동물 / 식물', 9, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:28', 9),
	('DESIGN', 'IT010', '패션 / 빈티지', 10, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:31', 10),
	('DESIGN', 'IT011', '액자', 11, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:33', 11),
	('DESIGN', 'IT012', '리본 / 배너 / 꾸미기', 12, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:34', 12),
	('DESIGN', 'IT013', '아트 / 일러스트', 13, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:36', 13),
	('DESIGN', 'IT014', '말풍선 / 화살표', 14, NULL, 'Y', '2015-04-23 10:32:42', '2015-04-23 11:00:38', 14),
	('DESIGN', 'IT015', '유머 / 패러디 / 시사', 15, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:40', 15),
	('DESIGN', 'IT016', '음식', 16, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:42', 16),
	('DESIGN', 'IT017', '음악 / 댄스 / 힙합', 17, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:44', 17),
	('DESIGN', 'IT018', '타투 / 트라이벌', 18, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:45', 18),
	('DESIGN', 'IT019', '한글 디자인 / 캘리그라피', 19, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:47', 19),
	('DESIGN', 'IT020', '앰블럼 / 로고', 20, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:49', 20),
	('DESIGN', 'IT021', '자동차 / 탈것', 21, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:51', 21),
	('DESIGN', 'IT022', '패턴 / 무늬 / 문양', 22, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:53', 22),
	('DESIGN', 'IT023', '스마일', 23, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:56', 23),
	('PRICE', '1000', '1000원', 1, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:06', 24),
	('PRICE', '2000', '2000원', 2, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:08', 25),
	('PRICE', '3000', '3000원', 3, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:11', 26),
	('PRICE', '4000', '4000원', 4, NULL, 'Y', '2015-04-23 10:32:43', '2015-04-23 11:00:13', 27),
	('CATALOG', 'CAT001', '반팔', 1, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 28),
	('CATALOG', 'CAT006', '긴팔 / 맨투맨', 2, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 29),
	('CATALOG', 'CAT003', '후드 / 집업후드', 3, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 30),
	('CATALOG', 'CAT004', '폴로 / PK 티셔츠', 4, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 31),
	('CATALOG', 'CAT005', '베이스볼/나그랑', 5, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 32),
	('CATALOG', 'CAT002', '남여공용', 6, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 33),
	('CATALOG', 'CAT009', '민소매', 7, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 34),
	('CATALOG', 'CAT010', '아동/키즈 티셔츠', 8, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 35),
	('CATALOG', 'CAT008', '스포츠의류', 9, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 36),
	('CATALOG', 'CAT007', '자수 제작 상품 ★', 10, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 37),
	('CATALOG', 'CAT011', '머그컵', 11, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 38),
	('CATALOG', 'CAT012', '캔버스백', 12, NULL, 'Y', '2015-04-23 16:13:36', '2015-04-23 16:13:36', 39),
	('CATALOG', 'CAT013', '모자', 13, NULL, 'Y', '2015-04-23 16:13:37', '2015-04-23 16:13:37', 40),
	('CATALOG', 'CAT014', '앞치마', 14, NULL, 'Y', '2015-04-23 16:13:37', '2015-04-23 16:13:37', 41),
	('TOPIC', 'TP008', '★HOT 상품', 1, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:53', 42),
	('TOPIC', 'TP001', '매장 유니폼', 2, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:55', 43),
	('TOPIC', 'TP002', '동호회 반티 과티', 3, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:57', 44),
	('TOPIC', 'TP003', '팀복 스트릿', 4, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:28:58', 45),
	('TOPIC', 'TP004', '가족 커플', 5, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:00', 46),
	('TOPIC', 'TP005', '공연 행사 이벤트', 6, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:03', 47),
	('TOPIC', 'TP006', '교회 단체티', 7, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:05', 48),
	('TOPIC', 'TP009', '베스트 상품', 8, NULL, 'Y', '2015-04-23 16:25:28', '2015-04-23 16:29:06', 49),
	('SIZE', 'SZ001', 'XS(85)', 1, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58', 50),
	('SIZE', 'SZ002', 'S(90~95)', 2, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58', 51),
	('SIZE', 'SZ003', 'M(100)', 3, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58', 52),
	('SIZE', 'SZ004', 'L(105)', 4, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58', 53),
	('SIZE', 'SZ005', 'XL(110)', 5, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58', 54),
	('SIZE', 'SZ006', '2XL(120)', 6, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58', 55),
	('SIZE', 'SZ007', 'S(85)', 7, NULL, 'Y', '2015-04-24 11:25:58', '2015-04-24 11:25:58', 56),
	('SIZE', 'SZ008', 'M(90)', 8, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 57),
	('SIZE', 'SZ009', 'L(95)', 9, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 58),
	('SIZE', 'SZ010', 'XL(100)', 10, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 59),
	('SIZE', 'SZ011', '2XL(105)', 11, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 60),
	('SIZE', 'SZ012', '3XL(110)', 12, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 61),
	('SIZE', 'SZ013', 'M(95)', 13, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 62),
	('SIZE', 'SZ014', 'L(100)', 14, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 63),
	('SIZE', 'SZ015', 'XL(105)', 15, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 64),
	('SIZE', 'SZ016', '3~6개월', 16, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 65),
	('SIZE', 'SZ017', '12~18개월', 17, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 66),
	('SIZE', 'SZ018', '24개월(3호)', 18, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 67),
	('SIZE', 'SZ019', '2~3살(5호)', 19, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 68),
	('SIZE', 'SZ020', '4~5살(7호)', 20, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 69),
	('SIZE', 'SZ021', '1T(1살)', 21, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 70),
	('SIZE', 'SZ022', '2T(2살)', 22, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 71),
	('SIZE', 'SZ023', '3T(12개월)', 23, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 72),
	('SIZE', 'SZ024', '4T(3~4살)', 24, NULL, 'Y', '2015-04-24 11:25:59', '2015-04-24 11:25:59', 73),
	('SIZE', 'SZ025', '14호(5-6세)', 25, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 74),
	('SIZE', 'SZ026', '15호(7-8세)', 26, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 75),
	('SIZE', 'SZ027', '16호(9-10세)', 27, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 76),
	('SIZE', 'SZ028', '17호(11-12세)', 28, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 77),
	('SIZE', 'SZ029', '18호(13-14세)', 29, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 78),
	('SIZE', 'SZ030', 'Free', 30, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 79),
	('SIZE', 'SZ031', '11oz', 31, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 80),
	('SIZE', 'SZ032', 'XS(80)', 32, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 81),
	('SIZE', 'SZ033', 'S(85)', 33, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 82),
	('SIZE', 'SZ034', 'M(90)', 34, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 83),
	('SIZE', 'SZ035', 'L(95)', 35, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 84),
	('SIZE', 'SZ036', 'XL(100)', 36, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 85),
	('SIZE', 'SZ037', '2XL(110)', 37, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 86),
	('SIZE', 'SZ038', 'S(75)', 38, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 87),
	('SIZE', 'SZ039', 'M(80)', 39, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 88),
	('SIZE', 'SZ040', 'L(85)', 40, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 89),
	('SIZE', 'SZ041', 'XL(90)', 41, NULL, 'Y', '2015-04-24 11:26:00', '2015-04-24 11:26:00', 90),
	('SIZE', 'SZ042', 'XS(60)', 42, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01', 91),
	('SIZE', 'SZ043', 'S(65)', 43, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01', 92),
	('SIZE', 'SZ044', 'M(70)', 44, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01', 93),
	('SIZE', 'SZ045', 'L(75)', 45, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01', 94),
	('SIZE', 'SZ046', 'XL(85)', 46, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01', 95),
	('SIZE', 'SZ047', '3XL(120)', 47, NULL, 'Y', '2015-04-24 11:26:01', '2015-04-24 11:26:01', 96),
	('COLOR', '000000', '블랙   ', 1, NULL, 'Y', '2015-04-24 11:29:52', '2015-04-24 11:29:52', 97),
	('COLOR', '022954', '네이비 ', 2, NULL, 'Y', '2015-04-24 11:29:52', '2015-04-24 11:29:52', 98),
	('COLOR', '304dc2', '블루   ', 3, NULL, 'Y', '2015-04-24 11:29:52', '2015-04-24 11:29:52', 99),
	('COLOR', '8bdfff', '소라   ', 4, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53', 100),
	('COLOR', 'c3bfbe', '그레이 ', 5, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53', 101),
	('COLOR', 'd02933', '레드   ', 6, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53', 102),
	('COLOR', 'dc3c78', '핫핑크 ', 7, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53', 103),
	('COLOR', 'f8d6d5', '연핑크 ', 8, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53', 104),
	('COLOR', 'ffee49', '노랑   ', 9, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53', 105),
	('COLOR', 'ffffff', '화이트 ', 10, NULL, 'Y', '2015-04-24 11:29:53', '2015-04-24 11:29:53', 106);
/*!40000 ALTER TABLE `common_code` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. design
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
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `best` int(11) DEFAULT '0',
  `category` varchar(10) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  PRIMARY KEY (`design_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.design: ~19 rows (대략적)
/*!40000 ALTER TABLE `design` DISABLE KEYS */;
INSERT IGNORE INTO `design` (`design_id`, `design_name`, `file_path`, `price`, `premium_yn`, `description`, `seller_id`, `use_yn`, `create_date`, `last_update`, `best`, `category`, `width`, `height`) VALUES
	(1, '복싱선수', '/up/design/3169483538_6_thumbnail.png', '1000', 'Y', '복싱선수', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT001', NULL, NULL),
	(2, '복싱선수', '/up/design/3169483538_6_thumbnail.png', '2000', 'Y', '복싱선수', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-26 14:10:50', 0, 'IT002', NULL, NULL),
	(3, '복싱선수', '/up/design/3169483538_6_thumbnail.png', '3000', 'Y', '복싱선수', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT003', NULL, NULL),
	(4, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT004', NULL, NULL),
	(5, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT005', NULL, NULL),
	(6, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT006', NULL, NULL),
	(7, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT002', NULL, NULL),
	(8, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT003', NULL, NULL),
	(9, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT004', NULL, NULL),
	(10, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱2', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT001', NULL, NULL),
	(11, '복싱2', '/up/design/3169483538_5_thumbnail.png', '1000', 'Y', '복싱2', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT003', NULL, NULL),
	(12, '복싱장갑', '/up/design/3169483538_4_thumbnail.png', '1000', 'Y', '복싱장갑', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT005', NULL, NULL),
	(13, '복싱장갑', '/up/design/3169483538_3_thumbnail.png', '1000', 'Y', '복싱장갑', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT006', NULL, NULL),
	(14, '복싱', '/up/design/3169483538_2_thumbnail.png', '2000', 'N', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:28:07', 0, 'IT003', NULL, NULL),
	(15, '복싱', '/up/design/169483538_2_thumbnail.png', '2000', 'N', '복싱', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:36:19', 0, 'IT009', NULL, NULL),
	(16, '역도', '/up/design/169483538_1_thumbnail.png', '2000', 'N', '역도', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:36:21', 0, 'IT009', NULL, NULL),
	(17, '역도', '/up/design/156307142_5_thumbnail.png', '3000', 'Y', '역도', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:36:22', 0, 'IT009', NULL, NULL),
	(18, '역도', '/up/design/156307142_4_thumbnail.png', '3000', 'Y', '역도', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:36:24', 0, 'IT009', NULL, NULL),
	(19, '역도', '/up/design/156307142_3_thumbnail.png', '3000', 'Y', '역도', 'dylee', 'Y', '2015-04-23 12:24:31', '2015-04-23 14:36:26', 0, 'IT009', NULL, NULL);
/*!40000 ALTER TABLE `design` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. login_history
DROP TABLE IF EXISTS `login_history`;
CREATE TABLE IF NOT EXISTS `login_history` (
  `hist_seq` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `cntr_ip_addr` varchar(45) DEFAULT NULL,
  `login_date` datetime DEFAULT NULL,
  `log_out_date` datetime DEFAULT NULL,
  PRIMARY KEY (`hist_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.login_history: ~0 rows (대략적)
/*!40000 ALTER TABLE `login_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `login_history` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. message
DROP TABLE IF EXISTS `message`;
CREATE TABLE IF NOT EXISTS `message` (
  `mesg_key` varchar(40) NOT NULL,
  `mesg_cont` varchar(500) DEFAULT NULL,
  `lang_code` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`mesg_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.message: ~0 rows (대략적)
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. order
DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_num` varchar(20) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.order: ~0 rows (대략적)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `hit_count` int(11) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `use_yn` varchar(1) DEFAULT 'Y',
  `display_yn` varchar(1) DEFAULT 'Y',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `last_update` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
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
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.product: ~47 rows (대략적)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT IGNORE INTO `product` (`product_id`, `product_name`, `hit_count`, `like_count`, `use_yn`, `display_yn`, `create_date`, `last_update`, `hot`, `best`, `desc_title`, `description`, `color`, `size`, `price`, `extra_price`, `type`, `file_path`, `catalog`, `category`, `size_file_path`, `size_file_name`) VALUES
	(1, 'Value 반팔 [20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-26 14:36:23', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/1/ValueS_Yellow_F.png', 'CAT001', 'TP001', '/up/base_product/21/CM_Size.jpg', 'CM_Size.jpg'),
	(2, 'Value 긴팔 [20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/20/ValueL_Black_F.png', 'CAT001', 'TP001', NULL, NULL),
	(3, 'Gildan 76000 프리미엄 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/2d8ddf0e6d7373b452c9f673857607f6.png', 'CAT001', 'TP001', NULL, NULL),
	(4, 'Gildan 63000 소프트 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/ebd16fb6405c8a2e494442e757d191bc.png', 'CAT001', 'TP001', NULL, NULL),
	(5, '보카시 반팔 [20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/2/VH_Red_F.png', 'CAT001', 'TP001', NULL, NULL),
	(6, 'Gildan 73800 이지케어 여성 폴로반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/9e4fbcf13936f6f1563adafe8a332641.png', 'CAT001', 'TP001', NULL, NULL),
	(7, 'Gildan 73800 이지케어 폴로반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/00938fb9bccb0a6c89087c9a040d12fc.PNG', 'CAT001', 'TP001', NULL, NULL),
	(8, 'Gildan 76000 프리미엄 여성 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/34f78d9c24a5584cfc395dc437836f7e.png', 'CAT001', 'TP001', NULL, NULL),
	(9, '나그랑 반팔 [20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/3/ValueB_Purple_F.png', 'CAT001', 'TP001', NULL, NULL),
	(10, '나그랑 긴팔 [20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:33', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/15/ValueBL_Red_F.png', 'CAT001', 'TP001', NULL, NULL),
	(11, 'AAA 1301 반팔 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/4/AAAS_Cream_F.png', 'CAT002', 'TP002', NULL, NULL),
	(12, 'AAA 1701 슬림반팔 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/5/AAA1701S_Navy_F.png', 'CAT002', 'TP002', NULL, NULL),
	(13, 'AAA 1304 긴팔 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/19/AAAL_Blue_F.png', 'CAT002', 'TP002', NULL, NULL),
	(14, 'AAA V넥 반팔 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/6/AAAV_White_F.png', 'CAT002', 'TP002', NULL, NULL),
	(15, 'AAA  베이스볼 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/8d798dded79acdebf6169ed7cb546b1e.png', 'CAT002', 'TP002', NULL, NULL),
	(16, 'Basic V넥 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/3364dbc9e54fa944985c6f3107b2a5e4.png', 'CAT002', 'TP002', NULL, NULL),
	(17, '아메리칸어페럴 베이스볼 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/17/AABB453_BWhite_F.png', 'CAT002', 'TP002', NULL, NULL),
	(18, 'AAA  머슬티 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/28/AAAM_Black_F.png', 'CAT002', 'TP002', NULL, NULL),
	(19, 'AAA 탱크탑 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/29/AAA_Tang_White_F.png', 'CAT002', 'TP002', NULL, NULL),
	(20, 'AAA 링어 반팔 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:37', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/10/AAAR_BBlue_F.png', 'CAT002', 'TP002', NULL, NULL),
	(21, '아메리칸어페럴 반팔 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 14:25:31', '0', '0', NULL, '100% 국내제작상품. 100% 면. <br>기본스타일의 양면원단 크루넥 맨투맨입니다. <br>두툼한 원단과 늘어나지 않는 시보리밴드로 착용감이 좋은 단체티셔츠 상품입니다.<br>', NULL, NULL, NULL, NULL, NULL, '/up/base_product/14/AA2001_Rasberry_F.png', 'CAT003', 'TP003', '/up/base_product/21/CM_Size.jpg', 'CM_Size.jpg'),
	(22, 'PK 폴로 반팔 [20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/7/PKS_Wine_F.png', 'CAT003', 'TP003', NULL, NULL),
	(23, 'PK 폴로 긴팔 [20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/18/PKL_Hpink_F.png', 'CAT003', 'TP003', NULL, NULL),
	(24, 'Basic 라운드넥 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/1f81f66fe0454d38d9af6f0b227e8038.png', 'CAT003', 'TP003', NULL, NULL),
	(25, '스판텍스 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/12/KS306_Lgreen_F.png', 'CAT003', 'TP003', NULL, NULL),
	(26, '쿨론 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/13/KS301_Blue_F.png', 'CAT004', 'TP003', NULL, NULL),
	(27, '특양면 맨투맨', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/21/CM_Pink_F.png', 'CAT004', 'TP003', NULL, NULL),
	(28, '특양면 후드', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/28c30bd57ae2dedb1efcc994c3914bf0.png', 'CAT004', 'TP003', NULL, NULL),
	(29, '특양면 집업후드', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/9bbd5ee75bcd2871347300c8814800f4.png', 'CAT004', 'TP003', NULL, NULL),
	(30, 'Basic 맨투맨 [기모]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:43', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/22/BM_Navy_F.png', 'CAT004', 'TP003', NULL, NULL),
	(31, 'Basic 후드 [기모]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/23/BH_Chacol_F.png', 'CAT005', 'TP004', NULL, NULL),
	(32, 'Basic 집업후드 [기모]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/27/BZ_Orange_F.png', 'CAT005', 'TP004', NULL, NULL),
	(33, 'SHAKA 맨투맨 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/25/Shaka_Chacol_F.png', 'CAT005', 'TP004', NULL, NULL),
	(34, 'AAA 후드 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/24/AAAH_Navy_F.png', 'CAT005', 'TP004', NULL, NULL),
	(35, 'AAA 집업후드 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/26/AAAZ_Red_F.png', 'CAT005', 'TP004', NULL, NULL),
	(36, '키즈 Creeper', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/33/KID_creeper_F.png', 'CAT006', 'TP004', NULL, NULL),
	(37, '헤인즈 키즈 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/35/HKS_Pink_F.png', 'CAT006', 'TP004', NULL, NULL),
	(38, '아메리칸어페럴 키즈베이스볼 [수입]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/34/AABB053_WBlack_F.png', 'CAT006', 'TP004', NULL, NULL),
	(39, 'Basic 아동 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '1', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/4efb9dbd22eb995e477857c09995d24b.png', 'CAT006', 'TP004', NULL, NULL),
	(40, 'Value 아동 반팔 [ 20수]', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:49', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/31/ValueKS_Sora_F.png', 'CAT006', 'TP004', NULL, NULL),
	(41, 'Gildan 76000 프리미엄 키즈 반팔', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:56', '1', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/e89d0d1b994aea11dc2b92862e814fc9.PNG', 'CAT007', 'TP005', NULL, NULL),
	(42, '캔버스 스쿨가방', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:56', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/36/CSB_F.png', 'CAT007', 'TP005', NULL, NULL),
	(43, '캔버스 토트가방', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:56', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/37/CTB_F.png', 'CAT007', 'TP005', NULL, NULL),
	(44, '머그컵', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:56', '0', '1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/38/Mug_F.png', 'CAT007', 'TP005', NULL, NULL),
	(45, '앞치마', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:56', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/11425c165963cb5c8b6183514bcf5532.png', 'CAT007', 'TP005', NULL, NULL),
	(46, '매쉬캡', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:56', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/40/MS_brown.png', 'CAT007', 'TP005', NULL, NULL),
	(47, '스냅백', 2, NULL, 'Y', 'Y', NULL, '2015-04-24 09:26:56', '0', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '/up/base_product/9a06ef6d5fb3f499c2460d7d93b4f7bf.png', 'CAT007', 'TP005', NULL, NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. product_color
DROP TABLE IF EXISTS `product_color`;
CREATE TABLE IF NOT EXISTS `product_color` (
  `product_id` int(11) NOT NULL,
  `color` varchar(10) NOT NULL,
  PRIMARY KEY (`product_id`,`color`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.product_color: ~10 rows (대략적)
/*!40000 ALTER TABLE `product_color` DISABLE KEYS */;
INSERT IGNORE INTO `product_color` (`product_id`, `color`) VALUES
	(21, '000000'),
	(21, '022954'),
	(21, '304dc2'),
	(21, '8bdfff'),
	(21, 'c3bfbe'),
	(21, 'd02933'),
	(21, 'dc3c78'),
	(21, 'f8d6d5'),
	(21, 'ffee49'),
	(21, 'ffffff');
/*!40000 ALTER TABLE `product_color` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. product_image
DROP TABLE IF EXISTS `product_image`;
CREATE TABLE IF NOT EXISTS `product_image` (
  `product_id` int(11) NOT NULL,
  `image` varchar(300) DEFAULT NULL COMMENT '기본 이미지',
  `list` varchar(300) DEFAULT NULL COMMENT '전체 상품 리스트 이미지',
  `cart` varchar(300) DEFAULT NULL COMMENT '장바구니 이미지',
  `front` varchar(300) DEFAULT NULL COMMENT '전면',
  `back` varchar(300) DEFAULT NULL,
  `left` varchar(300) DEFAULT NULL,
  `right` varchar(300) DEFAULT NULL,
  `hat_left` varchar(300) DEFAULT NULL,
  `hat_right` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.product_image: ~0 rows (대략적)
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. product_size
DROP TABLE IF EXISTS `product_size`;
CREATE TABLE IF NOT EXISTS `product_size` (
  `product_id` int(11) NOT NULL,
  `size` varchar(10) NOT NULL,
  PRIMARY KEY (`product_id`,`size`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.product_size: ~6 rows (대략적)
/*!40000 ALTER TABLE `product_size` DISABLE KEYS */;
INSERT IGNORE INTO `product_size` (`product_id`, `size`) VALUES
	(21, 'SZ007'),
	(21, 'SZ008'),
	(21, 'SZ009'),
	(21, 'SZ010'),
	(21, 'SZ011'),
	(21, 'SZ012');
/*!40000 ALTER TABLE `product_size` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. product_type
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE IF NOT EXISTS `product_type` (
  `product_id` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.product_type: ~5 rows (대략적)
/*!40000 ALTER TABLE `product_type` DISABLE KEYS */;
INSERT IGNORE INTO `product_type` (`product_id`, `type`) VALUES
	(21, 'FT001'),
	(21, 'FT002'),
	(21, 'FT005'),
	(21, 'FT006'),
	(21, 'FT008');
/*!40000 ALTER TABLE `product_type` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. type_size
DROP TABLE IF EXISTS `type_size`;
CREATE TABLE IF NOT EXISTS `type_size` (
  `type` varchar(10) DEFAULT NULL,
  `size` varchar(10) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  `left` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.type_size: ~1 rows (대략적)
/*!40000 ALTER TABLE `type_size` DISABLE KEYS */;
INSERT IGNORE INTO `type_size` (`type`, `size`, `top`, `left`, `width`, `height`, `product_id`) VALUES
	('FT001', 'SZ007', 3, 5, 34, 38, NULL);
/*!40000 ALTER TABLE `type_size` ENABLE KEYS */;


-- 테이블 aromabloom의 구조를 덤프합니다. user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(50) NOT NULL COMMENT '아이디(이메일)',
  `password` varchar(100) NOT NULL COMMENT '비밀번호(DB 암호화)',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '생성일자',
  `last_update` datetime DEFAULT NULL COMMENT '수정일자',
  `hp_num` varchar(45) DEFAULT NULL COMMENT '휴대폰번호(자바 암호화)',
  `birth_date` varchar(8) DEFAULT NULL COMMENT '생년월일',
  `recv_email_yn` varchar(1) DEFAULT 'N' COMMENT '이메일 수신 동의',
  `recv_sms_yn` varchar(1) DEFAULT 'N' COMMENT 'SMS 수신 동의',
  `recv_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '수신 동의 일자',
  `access_terms_yn` varchar(1) DEFAULT 'N' COMMENT '이용약관 동의 YN',
  `personal_terms_yn` varchar(1) DEFAULT 'N' COMMENT '개인정보 취급 동의 YN',
  `alias_id` int(11) NOT NULL,
  `nick_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `alias_id_UNIQUE` (`alias_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table aromabloom.user: ~0 rows (대략적)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
