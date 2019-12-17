drop table if exists customer_order;
CREATE TABLE `customer_order` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
    `customer_mobile` VARCHAR(100) NOT NULL COMMENT '客户手机号',
    `city` VARCHAR(100) NOT NULL COMMENT '客户所在城市',
    `service_list` VARCHAR(1000) NOT NULL DEFAULT '' COMMENT '预约服务列表',
    `ext_info` VARCHAR(1023) NOT NULL DEFAULT '' COMMENT '预留的其它字段',
    `is_deleted` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否已删除,0:未删除,1:已删除',
    `add_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `mod_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
)  ENGINE=INNODB COMMENT='测试表';
