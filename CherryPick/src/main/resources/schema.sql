CREATE TABLE `member` (
	`mid` VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',
	`pwd` CHAR(50) NULL DEFAULT '' COLLATE 'utf8_unicode_ci',
	`name` VARCHAR(50) NULL DEFAULT '' COLLATE 'utf8_unicode_ci',
	`phone` CHAR(50) NULL DEFAULT '' COLLATE 'utf8_unicode_ci',
	`email` CHAR(50) NULL DEFAULT '' COLLATE 'utf8_unicode_ci',
	`role` TINYINT(3) NULL DEFAULT '0',
	PRIMARY KEY (`mid`) USING BTREE
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB
;

INSERT INTO member VALUES ('bbb', '1234', 'aaa', '010-1234-5678', 'aaa@aaa.com', 0);