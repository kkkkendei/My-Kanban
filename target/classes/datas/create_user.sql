DROP TABLE IF EXISTS  `user`;

CREATE TABLE `user`(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR (20) NOT NULL,
    `pwd` VARCHAR(32) NOT NULL,
    `nick_name` VARCHAR(20) NOT NULL,
    `avatar` VARCHAR(200) ,
    `gmt_created` datetime NOT NULL,
    `gmt_modified` datetime NOT NULL,
    PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
