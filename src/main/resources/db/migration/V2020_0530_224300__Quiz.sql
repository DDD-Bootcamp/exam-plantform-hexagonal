DROP TABLE IF EXISTS `quiz`;
CREATE TABLE `quiz` (
   `id` char(36) NOT NULL,
   `content` varchar(255) NOT NULL,
   `referenceAnswer` varchar(255) NOT NULL,
   `score` smallint NOT NULL,
   `teacherId` char(36) NOT NULL,
   `createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `updateTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
);