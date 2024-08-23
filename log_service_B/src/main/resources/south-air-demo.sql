-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS south_air_demo;

-- 创建表
CREATE TABLE `south_air_demo`.`log` (
                       `id` bigint unsigned NOT NULL COMMENT '雪花算法 id IdGenerate.generateId();',
                       `tag` varchar(1) DEFAULT NULL COMMENT 'tag，有 A 和 B',
                       `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                       PRIMARY KEY (`id`),
                       UNIQUE KEY `coreNo` (`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;