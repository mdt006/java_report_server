/*
Navicat MySQL Data Transfer

Source Server         : 10.10.200.255
Source Server Version : 50505
Source Host           : 10.10.200.255:3306
Source Database       : report_center

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-09-15 14:04:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ag_pull_record_log`
-- ----------------------------
DROP TABLE IF EXISTS `ag_pull_record_log`;
CREATE TABLE `ag_pull_record_log` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`ag_path`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`date_path`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`filename`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`file_size`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`last_update_time`  bigint(20) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='AG拉取日志记录'
AUTO_INCREMENT=55027

;

-- ----------------------------
-- Records of ag_pull_record_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `api_agent`
-- ----------------------------
DROP TABLE IF EXISTS `api_agent`;
CREATE TABLE `api_agent` (
`agent`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`hashcode`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`site_id`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`agent`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='对外代理配置中心'

;

-- ----------------------------
-- Records of api_agent
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `api_agent_ip`
-- ----------------------------
DROP TABLE IF EXISTS `api_agent_ip`;
CREATE TABLE `api_agent_ip` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='代理IP配置'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of api_agent_ip
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `api_info`
-- ----------------------------
DROP TABLE IF EXISTS `api_info`;
CREATE TABLE `api_info` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一 id ' ,
`hashcode`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '唯一的 hashCode 标示' ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '网站名称' ,
`site_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`prefix`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目前缀' ,
`agent`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对接的代理' ,
`web_url`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`reporturl`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求视讯的路径 ' ,
`remark`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`ip`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '允许访问的 IP' ,
`keyB`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  smallint(6) NULL DEFAULT NULL COMMENT '0：未启用\r\n            50：正常\r\n            -50：已删除' ,
`live_id`  int(11) NULL DEFAULT NULL COMMENT '2:AG视讯厅\r\n            3:OG视讯厅\r\n            11:BBIN视讯厅\r\n            12:DS视讯厅\r\n            ' ,
`live_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`live_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='第三方平台API配置'
AUTO_INCREMENT=60659

;

-- ----------------------------
-- Records of api_info
-- ----------------------------
BEGIN;
INSERT INTO `api_info` VALUES ('105', '', '99999', '鼎盛测试', 'cs', '', '', '', '', '', '', '50', '2', 'ag', ''), ('106', '', '99999', '鼎盛测试', 'cs', '', '', 'http://test.com/', '', '', '', '0', '11', 'bbin', 'testkey'), ('107', '', '99999', '鼎盛测试', 'cs', '', '', 'http://test.com/', '', '', '', '50', '12', 'ds', 'testkey'), ('108', '', '99999', '鼎盛测试', 'cs', '3r01', '', 'http://test.com/', '', '', '', '50', '13', 'h8', 'testkey'), ('219', '', '99999', '鼎盛测试', 'cs', '', '', 'http://test.com/', '', '', '', '50', '15', 'mg', 'testkey'), ('50000', '', '99999', '鼎盛测试', 'cs', 'ddi88', '', 'http://test.com/', '', '', '', '50', '3', 'og', 'dsh$-$*!@-testkey'), ('50007', '', '99999', 'PT测试', 'as', 'dgf2', '', '', '', '', 'testkey', '50', '16', 'PT', 'testkey'), ('50103', '', '99999', '鼎盛测试', 'cs', '', '', 'http://test.com/', '', '', 'testkey', '50', '17', 'pmg', 'testkey'), ('50199', '', '99999', 'LMG测试', 'cs', '', '', 'http://test.com/', '', '', '', '50', '18', 'lmg', 'stkey'), ('50200', '', '99999', '鼎盛测试', 'cs', '15306', '', 'http://test.com/', '', '', '', '0', '90', 'ky', ''), ('50203', '', '99999', '鼎盛测试', 'cs', '', '', 'http://test.com/', '', '', '', '50', '19', 'SGS', ''), ('50214', '', '99999', 'KKWDS测试', 'cs', '', '', 'http://test.com/', '', '', '', '0', '30', 'kkwds', 'testkey');
COMMIT;

-- ----------------------------
-- Table structure for `audit_total_99999`
-- ----------------------------
DROP TABLE IF EXISTS `audit_total_99999`;
CREATE TABLE `audit_total_99999` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`live_id`  int(5) NULL DEFAULT NULL ,
`order_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`bet_time`  datetime NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`valid_amount`  decimal(18,2) NULL DEFAULT 0.00 ,
`pay_amount`  decimal(18,2) NULL DEFAULT NULL ,
`type`  int(11) NOT NULL ,
`game_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='稽核分表数据'
AUTO_INCREMENT=63385

;

-- ----------------------------
-- Records of audit_total_99999
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `c_live_id_config`
-- ----------------------------
DROP TABLE IF EXISTS `c_live_id_config`;
CREATE TABLE `c_live_id_config` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`table_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`live_id`  int(11) NULL DEFAULT NULL ,
`game_kind`  int(11) NULL DEFAULT NULL ,
`game_kind_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_type`  int(11) NULL DEFAULT 0 COMMENT '0:美东    1:北京' ,
`table_game_kind`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`table_bet_time`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注时间字段数据的对应名称' ,
`table_bet_amount`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注金额字段' ,
`table_validate_amount`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效投注的字段' ,
`table_win_lose_amount`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库输赢字段' ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=13

;

-- ----------------------------
-- Records of c_live_id_config
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `c_report_detail_config`
-- ----------------------------
DROP TABLE IF EXISTS `c_report_detail_config`;
CREATE TABLE `c_report_detail_config` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`state`  tinyint(4) NOT NULL ,
`memo`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`gameKind`  int(11) NOT NULL ,
`select_sql`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=33

;

-- ----------------------------
-- Records of c_report_detail_config
-- ----------------------------
BEGIN;
INSERT INTO `c_report_detail_config` VALUES ('1', '50', 'AG视讯', '21', 'SELECT COUNT(*)  AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.valid_bet_amount) AS validamount,SUM(a.net_amount) AS winlose\r\nFROM ds_ag_live a WHERE a.username=\'param_username\' and a.bet_time >= \'param_startTime\' AND a.bet_time <= \'param_endTime\' \r\nand a.win_loss_type!=4 and a.game_kind=\'21\' and a.site_id=param_siteId \r\nand a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('2', '50', 'AG电子', '22', 'SELECT COUNT(*) AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.valid_bet_amount) AS validamount,SUM(a.net_amount) AS winlose\r\nFROM ds_ag_live a WHERE a.username=\'param_username\' and a.bet_time >= \'param_startTime\' AND a.bet_time <= \'param_endTime\' \r\nand a.win_loss_type!=4 and a.game_kind=\'22\' and a.site_id=param_siteId \r\nand a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('3', '50', 'DS视讯', '41', 'SELECT COUNT(*) AS betCount,SUM(a.stake_amount) AS betamount,\r\nSUM(a.valid_stake) AS validamount,SUM(a.win_loss) AS winlose\r\nFROM ds_live a WHERE a.username=\'param_username\' and a.end_time >= \'param_startTime\' AND a.end_time <= \'param_endTime\' \r\nand a.site_id=param_siteId \r\nand a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('5', '50', 'BBIN电游', '5', 'SELECT COUNT(*) AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.commissionable) AS validamount,SUM(a.pay_off) AS winlose\r\nFROM ds_bbin_jilv a WHERE a.user_name=\'param_username\' and a.wagers_date >= \'param_startTime\' AND a.wagers_date <= \'param_endTime\' \r\nand a.site_id=param_siteId and a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('6', '50', 'BBIN视讯', '3', 'SELECT COUNT(*) AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.commissionable) AS validamount,SUM(a.pay_off) AS winlose\r\nFROM ds_bbin_live a WHERE a.user_name=\'param_username\' and a.wagers_date >= \'param_startTime\' AND a.wagers_date <= \'param_endTime\' \r\nand a.site_id=param_siteId and a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)\r\n'), ('7', '50', 'BBIN体育', '1', 'SELECT COUNT(*) AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.commissionable) AS validamount,SUM(a.pay_off) AS winlose\r\nFROM ds_bbin_sport a WHERE a.user_name=\'param_username\' and a.wagers_date >= \'param_startTime\' AND a.wagers_date <= \'param_endTime\' \r\nand a.site_id=param_siteId and a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('8', '50', 'h8体育', '42', 'SELECT COUNT(*) AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.commission_amount) AS validamount,SUM(a.win_amount) AS winlose\r\nFROM ds_m8_sport a WHERE a.username=\'param_username\' and a.transaction_date >= \'param_startTime\' AND a.transaction_date <= \'param_endTime\' \r\nand a.site_id=param_siteId '), ('13', '50', 'MG电子游戏', '60', 'SELECT COUNT(*) AS betCount,SUM(a.amount) AS betamount,\r\nSUM(a.validate_amount) AS validamount,SUM(a.payoff) AS winlose\r\nFROM ds_mg_game a WHERE a.username=\'param_username\' and a.transaction_timestamp_date >= \'param_startTime\' AND a.transaction_timestamp_date <= \'param_endTime\'  \r\nAND a.win_lose_type<>-1 and a.siteId=param_siteId and a.game_key=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('14', '50', '蛮牛', '80', 'SELECT COUNT(*) AS betCount,SUM(a.bet_money) AS betamount,\r\nSUM(a.bet_money) AS validamount,SUM(a.pay_off) AS winlose\r\nFROM ds_manniu_bet a WHERE a.username=\'param_username\' and a.create_time >= \'param_startTime\' AND a.create_time <= \'param_endTime\' \r\nand a.site_id=param_siteId and a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('15', '50', 'OG视讯', '70', 'SELECT COUNT(*) AS betCount,SUM(a.betting_amount) AS betamount,\r\nSUM(a.valid_amount) AS validamount,SUM(a.win_lose_amount) AS winlose\r\nFROM ds_og_live a WHERE a.username=\'param_username\' and a.add_time >= \'param_startTime\' AND a.add_time <= \'param_endTime\' \r\nand a.site_id=param_siteId and a.game_name_id=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('17', '50', 'AG捕鱼', '23', 'SELECT COUNT(*) AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.valid_bet_amount) AS validamount,SUM(a.net_amount) AS winlose\r\nFROM ds_ag_hunter a WHERE a.username=\'param_username\' and a.bet_time >= \'param_startTime\' AND a.bet_time <= \'param_endTime\' and a.site_id=param_siteId'), ('18', '50', 'PC28', '57', 'SELECT COUNT(*) AS betCount,SUM(a.jiner) AS betamount,\r\nSUM(a.jinerb) AS validamount,SUM(a.win) AS winlose\r\nFROM ds_jingdian_lottery a WHERE a.user=\'param_username\' and a.report_time >= \'param_startTime\' AND a.report_time <= \'param_endTime\'\r\nAND a.win_lose_type<>4  and a.siteid=param_siteId and a.lid=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('19', '50', 'DS经典时时彩', '58', 'SELECT COUNT(*) AS betCount,SUM(a.jiner) AS betamount,\r\nSUM(a.jinerb) AS validamount,SUM(a.win) AS winlose\r\nFROM ds_jingdian_lottery a WHERE a.user=\'param_username\' and a.report_time >= \'param_startTime\' AND a.report_time <= \'param_endTime\'\r\nAND a.win_lose_type<>4  and a.siteid=param_siteId and a.lid=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('20', '50', 'DS经典香港彩', '59', 'SELECT COUNT(*) AS betCount,SUM(a.jiner) AS betamount,\r\nSUM(a.jinerb) AS validamount,SUM(a.win) AS winlose\r\nFROM ds_jingdian_lottery a WHERE a.user=\'param_username\' and a.report_time >= \'param_startTime\' AND a.report_time <= \'param_endTime\'\r\nAND a.win_lose_type<>4  and a.siteid=param_siteId and a.lid=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('21', '50', 'DS官方彩', '56', 'SELECT COUNT(*) AS betCount,SUM(a.amount) AS betamount,\r\nSUM(a.amount) AS validamount,SUM(a.wins) AS winlose\r\nFROM ds_guangfang_lottery a WHERE a.user_name=\'param_username\' and a.report_time >= \'param_startTime\' AND a.report_time <= \'param_endTime\'\r\nAND a.win_lose_type<>4  and a.siteid=param_siteId and a.lid=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('23', '50', 'PT电子', '16', 'SELECT COUNT(1) AS betCount,SUM(a.bet) AS betamount,\r\nSUM(a.bet) AS validamount,SUM(a.win) AS winlose\r\nFROM dt_pt_game a WHERE a.username=\'param_username\' and a.gamedate >= \'param_startTime\' AND a.gamedate <= \'param_endTime\' and a.site_id=param_siteId and a.gamename=(select b.out_game_code from ds_game_type b where b.parent_id=16 and b.id=param_gameType)'), ('25', '50', 'PMG电子', '65', 'SELECT COUNT(1) AS betCount,SUM(a.amount) AS betamount,\r\nSUM(a.validate_amount) AS validamount,SUM(a.payoff) AS winlose\r\nFROM dt_mg_game_record a WHERE a.username=\'param_username\' and a.bet_time >= \'param_startTime\' AND a.bet_time <= \'param_endTime\' and a.site_id=param_siteId \r\nand a.game_code=(select b.out_game_code from ds_game_type b where b.parent_id=65 and b.id=param_gameType)'), ('27', '50', 'LMG视讯', '18', 'SELECT COUNT(*) AS betCount,SUM(a.stake_amount) AS betamount,\r\nSUM(a.valid_stake) AS validamount,SUM(a.win_loss) AS winlose\r\nFROM ds_lmg_live a WHERE a.username=\'param_username\' and a.end_time >= \'param_startTime\' AND a.end_time <= \'param_endTime\' \r\nand a.site_id=param_siteId \r\nand a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('28', '50', '开元棋牌', '90', 'SELECT COUNT(1) AS betCount,SUM(a.all_bet) AS betamount,\r\nSUM(a.cell_score) AS validamount,SUM(a.profit) AS winlose\r\nFROM ds_ky_chess a WHERE a.account=\'param_username\' and a.game_end_time >= \'param_startTime\' AND a.game_end_time <= \'param_endTime\' \r\nand a.site_id=param_siteId \r\nand a.kind_id=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)'), ('29', '50', 'AG体育', '24', 'SELECT COUNT(*)  AS betCount,SUM(a.bet_amount) AS betamount,\r\nSUM(a.valid_bet_amount) AS validamount,SUM(a.net_amount) AS winlose\r\nFROM ds_ag_sport a WHERE a.username=\'param_username\' and a.bet_time >= \'param_startTime\' AND a.bet_time <= \'param_endTime\' \r\nand a.win_loss_type!=4 and a.site_id=param_siteId \r\n'), ('30', '50', 'SGS视讯', '95', 'SELECT COUNT(*)  AS betCount,SUM(a.riskamt) AS betamount,\r\nSUM(a.validbet) AS validamount,SUM(a.winloss) AS winlose\r\nFROM ds_sgs_live a WHERE a.username=\'param_username\' AND a.bet_on >= \'param_startTime\' AND a.bet_on <= \'param_endTime\' \r\nAND a.win_loss_type!=4 AND a.site_id=param_siteId \r\nAND a.game_id=(SELECT b.out_game_code FROM ds_game_type b WHERE b.parent_id=param_game_kind AND b.id=param_gameType)'), ('31', '50', 'SGS电子', '96', 'SELECT COUNT(*)  AS betCount,SUM(a.riskamt) AS betamount,\r\nSUM(a.validbet) AS validamount,SUM(a.winloss) AS winlose\r\nFROM ds_sgs_game a WHERE a.username=\'param_username\' AND a.bet_on >= \'param_startTime\' AND a.bet_on <= \'param_endTime\' \r\nAND a.win_loss_type!=4 AND a.site_id=param_siteId \r\nAND a.game_id=(SELECT b.out_game_code FROM ds_game_type b WHERE b.parent_id=param_game_kind AND b.id=param_gameType)'), ('32', '50', 'KKWDS视讯', '30000', 'SELECT COUNT(*) AS betCount,SUM(a.stake_amount) AS betamount,\r\nSUM(a.valid_stake) AS validamount,SUM(a.win_loss) AS winlose\r\nFROM ds_live a WHERE a.username=\'param_username\' and a.end_time >= \'param_startTime\' AND a.end_time <= \'param_endTime\' \r\nand a.site_id=param_siteId \r\nand a.game_type=(select b.out_game_code from ds_game_type b where b.parent_id=param_game_kind and b.id=param_gameType)');
COMMIT;

-- ----------------------------
-- Table structure for `c_total_audit_config`
-- ----------------------------
DROP TABLE IF EXISTS `c_total_audit_config`;
CREATE TABLE `c_total_audit_config` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`source_table_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`select_bet_table_sql`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`temp_table_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`insert_temp_sql`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of c_total_audit_config
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `c_total_report_config`
-- ----------------------------
DROP TABLE IF EXISTS `c_total_report_config`;
CREATE TABLE `c_total_report_config` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`source_table_name`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`select_bet_table_sql`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`temp_table_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`insert_temp_sql`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`validate_report_select_sql`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`vaildate_detail_table_select_sql`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`delete_report_sql`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`delete_temp_table_sql`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='报表统计SQL配置'
AUTO_INCREMENT=35

;

-- ----------------------------
-- Records of c_total_report_config
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `dictionary_table`
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_table`;
CREATE TABLE `dictionary_table` (
`id`  int(10) NOT NULL AUTO_INCREMENT ,
`status_code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '×´Ì¬Âë' ,
`status_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '×´Ì¬ÀàÐÍ' ,
`status_remark`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status_desc`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '×´Ì¬ÃèÊö' ,
`old_lotto_id`  int(10) NULL DEFAULT NULL ,
`parent_id`  int(10) NULL DEFAULT NULL COMMENT '¸¸½Úµãid' ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='字典'
AUTO_INCREMENT=945

;

-- ----------------------------
-- Records of dictionary_table
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_ag_file_record`
-- ----------------------------
DROP TABLE IF EXISTS `ds_ag_file_record`;
CREATE TABLE `ds_ag_file_record` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`type`  tinyint(2) NULL DEFAULT NULL COMMENT '类型，1：AGIN，2：HUNTER，3：XIN，4：YOPLAY，5：SBTA' ,
`file_json`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='AG拉取文件信息'
AUTO_INCREMENT=9

;

-- ----------------------------
-- Records of ds_ag_file_record
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_ag_hunter`
-- ----------------------------
DROP TABLE IF EXISTS `ds_ag_hunter`;
CREATE TABLE `ds_ag_hunter` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`data_type`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`agent_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`namepre`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`transfer_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`trade_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`platform_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`scene_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '場景號' ,
`player_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '玩家账户' ,
`platform_id`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`device_type`  tinyint(5) NULL DEFAULT NULL COMMENT '设备类型' ,
`type`  tinyint(5) NULL DEFAULT NULL COMMENT '转账类别 (1=場景捕魚, 2=抽獎, 7=捕魚王獎勵)' ,
`scene_start_time`  datetime NULL DEFAULT NULL COMMENT 'SceneStartTime:場景開始時間' ,
`scene_end_time`  datetime NULL DEFAULT NULL ,
`roomid`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '房间号' ,
`roombet`  decimal(20,0) NULL DEFAULT NULL COMMENT '房間倍率' ,
`cost`  decimal(18,3) NULL DEFAULT NULL COMMENT '投注金额，花费子弹金额' ,
`earn`  decimal(18,3) NULL DEFAULT NULL COMMENT '派彩金额，打中鱼金额' ,
`net_amount`  decimal(18,3) NULL DEFAULT NULL COMMENT '输赢金额' ,
`jackpotcomm`  decimal(18,3) NULL DEFAULT NULL COMMENT 'Jackpotcomm:場景彩池投注' ,
`previous_amount`  decimal(18,3) NULL DEFAULT NULL COMMENT '转账前额度' ,
`current_amount`  decimal(18,3) NULL DEFAULT NULL COMMENT '当前额度' ,
`valid_bet_amount`  decimal(18,3) NULL DEFAULT NULL ,
`bet_amount`  decimal(18,3) NULL DEFAULT NULL ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`exchange_rate`  tinyint(4) NULL DEFAULT NULL COMMENT '汇率' ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flag`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`remark`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`transfer_type`  tinyint(4) NULL DEFAULT NULL COMMENT '转账类别' ,
`fish_id_start`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`fish_id_end`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_time`  datetime NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='AG捕鱼数据'
AUTO_INCREMENT=297297

;

-- ----------------------------
-- Records of ds_ag_hunter
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_ag_live`
-- ----------------------------
DROP TABLE IF EXISTS `ds_ag_live`;
CREATE TABLE `ds_ag_live` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`user_pre`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`player_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`bill_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`agent_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`net_amount`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`game_kind`  tinyint(4) NULL DEFAULT NULL ,
`game_kind_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`bet_time`  datetime NULL DEFAULT NULL ,
`valid_bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`flag`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`play_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`table_code`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`login_ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`recalcu_time`  datetime NULL DEFAULT NULL ,
`platform_id`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`platform_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`remark`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`round`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result`  varchar(900) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`before_credit`  decimal(18,2) NULL DEFAULT NULL ,
`device_type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`ag_flag`  tinyint(4) NULL DEFAULT NULL ,
`last_json`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`slottype`  int(11) NULL DEFAULT NULL ,
`mainbillno`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_amount_base`  decimal(18,2) NULL DEFAULT NULL ,
`bet_amount_bonus`  decimal(18,2) NULL DEFAULT NULL ,
`net_amount_base`  decimal(18,2) NULL DEFAULT NULL ,
`net_amount_bonus`  decimal(18,2) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='AG视讯数据'
AUTO_INCREMENT=215151358

;

-- ----------------------------
-- Records of ds_ag_live
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_ag_sport`
-- ----------------------------
DROP TABLE IF EXISTS `ds_ag_sport`;
CREATE TABLE `ds_ag_sport` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`user_pre`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`player_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`bill_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`agent_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`net_amount`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`game_kind`  tinyint(4) NULL DEFAULT NULL ,
`game_kind_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`bet_time`  datetime NULL DEFAULT NULL ,
`valid_bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`flag`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`login_ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`recalcu_time`  datetime NULL DEFAULT NULL ,
`platform_id`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`platform_type`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`remark`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`device_type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='AG电子AG体育注单表'
AUTO_INCREMENT=6375

;

-- ----------------------------
-- Records of ds_ag_sport
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_aghunter_report`
-- ----------------------------
DROP TABLE IF EXISTS `ds_aghunter_report`;
CREATE TABLE `ds_aghunter_report` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`bet_count`  int(11) NULL DEFAULT NULL ,
`betamount`  decimal(18,2) NULL DEFAULT NULL COMMENT '下注金额' ,
`jackpot`  decimal(18,2) NULL DEFAULT NULL COMMENT 'jackpot交收' ,
`winlose`  decimal(18,2) NULL DEFAULT NULL COMMENT '派彩金额' ,
`validamount`  decimal(18,2) NULL DEFAULT NULL COMMENT '有效下注金额' ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '网站名' ,
`live_id`  tinyint(4) NULL DEFAULT NULL COMMENT '视讯id' ,
`live_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视讯名称' ,
`game_kind`  int(11) NULL DEFAULT NULL ,
`game_kind_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  int(11) NULL DEFAULT NULL ,
`game_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_time`  date NULL DEFAULT NULL COMMENT '下注时间  以天为单位统计' ,
`jiesuan_time`  date NULL DEFAULT NULL ,
`agents`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代理' ,
`world`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '总代' ,
`corprator`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '股东' ,
`superior`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '大股东' ,
`company`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`comm_agent`  decimal(18,2) NULL DEFAULT NULL ,
`comm_world`  decimal(18,2) NULL DEFAULT NULL ,
`comm_corprator`  decimal(18,2) NULL DEFAULT NULL ,
`comm_superior`  decimal(18,2) NULL DEFAULT NULL ,
`comm_branch`  decimal(18,2) NULL DEFAULT NULL ,
`last_comm`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
COMMENT='AG捕鱼JACKPOT'
AUTO_INCREMENT=14748

;

-- ----------------------------
-- Records of ds_aghunter_report
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_bbin_jilv`
-- ----------------------------
DROP TABLE IF EXISTS `ds_bbin_jilv`;
CREATE TABLE `ds_bbin_jilv` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`site_id`  int(11) NULL DEFAULT NULL ,
`uppername`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bbin_website`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bbin_game_kind`  tinyint(4) NULL DEFAULT NULL ,
`wagers_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`wagers_date`  datetime NULL DEFAULT NULL ,
`serial_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`round_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`card`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`pay_off`  decimal(18,2) NULL DEFAULT NULL ,
`commission`  decimal(18,2) NULL DEFAULT NULL ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`exchange_rate`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`commissionable`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`modified_date`  datetime NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`flag`  tinyint(4) NULL DEFAULT NULL ,
`last_json`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_date`  date NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='BBIN机率'
AUTO_INCREMENT=520626643

;

-- ----------------------------
-- Records of ds_bbin_jilv
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_bbin_live`
-- ----------------------------
DROP TABLE IF EXISTS `ds_bbin_live`;
CREATE TABLE `ds_bbin_live` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`uppername`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代理' ,
`bbin_website`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`site_id`  int(11) NULL DEFAULT NULL ,
`wagers_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`wagers_date`  datetime NULL DEFAULT NULL ,
`serial_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`round_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  int(11) NULL DEFAULT NULL ,
`game_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`card`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`pay_off`  decimal(18,2) NULL DEFAULT NULL ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`exchange_rate`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`commissionable`  decimal(18,2) NULL DEFAULT NULL ,
`commission`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`modified_date`  datetime NULL DEFAULT NULL ,
`flag`  tinyint(4) NULL DEFAULT NULL ,
`last_json`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='BBIN视讯'
AUTO_INCREMENT=77574839

;

-- ----------------------------
-- Records of ds_bbin_live
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_bbin_page_record`
-- ----------------------------
DROP TABLE IF EXISTS `ds_bbin_page_record`;
CREATE TABLE `ds_bbin_page_record` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`game_kind`  int(11) NULL DEFAULT NULL ,
`page`  int(11) NULL DEFAULT NULL ,
`date`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='BBIN拉取日志记录'
AUTO_INCREMENT=672478

;

-- ----------------------------
-- Records of ds_bbin_page_record
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_bbin_sport`
-- ----------------------------
DROP TABLE IF EXISTS `ds_bbin_sport`;
CREATE TABLE `ds_bbin_sport` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`user_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`site_id`  int(11) NULL DEFAULT NULL ,
`uppername`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bbin_website`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bbin_game_kind`  tinyint(4) NULL DEFAULT NULL ,
`wagers_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`wagers_date`  datetime NULL DEFAULT NULL ,
`serial_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`round_no`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`card`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`pay_off`  decimal(18,2) NULL DEFAULT NULL ,
`commission`  decimal(18,2) NULL DEFAULT NULL ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`exchange_rate`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`commissionable`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`modified_date`  datetime NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`flag`  tinyint(4) NULL DEFAULT NULL ,
`last_json`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`order_date`  datetime NULL DEFAULT NULL COMMENT '赛事时间' ,
`payout_time`  datetime NULL DEFAULT NULL COMMENT '结算时间' ,
`account_date`  datetime NULL DEFAULT NULL COMMENT '账务时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='BBIN体育'
AUTO_INCREMENT=33460

;

-- ----------------------------
-- Records of ds_bbin_sport
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_game_kind_order`
-- ----------------------------
DROP TABLE IF EXISTS `ds_game_kind_order`;
CREATE TABLE `ds_game_kind_order` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`game_kind`  int(11) NULL DEFAULT NULL ,
`game_kind_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`order_asc`  int(11) NULL DEFAULT NULL COMMENT '10X-视讯 20X-电子 30X体育 40X彩票 50X棋牌' ,
`state`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='报表游戏种类排序'
AUTO_INCREMENT=67

;

-- ----------------------------
-- Records of ds_game_kind_order
-- ----------------------------
BEGIN;
INSERT INTO `ds_game_kind_order` VALUES ('43', '0', '总计', '0', '50'), ('45', '3', 'BBIN视讯', '102', '50'), ('46', '21', 'AG视讯', '103', '50'), ('47', '70', 'OG视讯', '104', '50'), ('48', '5', 'BBIN电游', '201', '50'), ('49', '22', 'AG电游', '202', '50'), ('51', '60', 'MG电子', '204', '50'), ('52', '42', 'H8体育', '301', '50'), ('53', '1', 'BBIN体育', '302', '50'), ('54', '57', 'DS经典PC28', '402', '50'), ('55', '58', 'DS经典时时彩', '403', '50'), ('56', '59', 'DS经典香港彩', '404', '50'), ('57', '23', 'AG捕鱼', '205', '50'), ('58', '56', 'DS新官方彩', '405', '50'), ('59', '16', 'PT电游', '206', '50'), ('61', '18', 'LMG视讯', '105', '50'), ('62', '90', '开元棋牌', '501', '50'), ('63', '24', 'AG体育', '303', '50'), ('64', '95', '申博视讯', '106', '50'), ('65', '96', '申博电子', '208', '50'), ('66', '30000', 'KKWDS视讯', '107', '50');
COMMIT;

-- ----------------------------
-- Table structure for `ds_game_type`
-- ----------------------------
DROP TABLE IF EXISTS `ds_game_type`;
CREATE TABLE `ds_game_type` (
`id`  int(11) NOT NULL COMMENT '主键' ,
`game_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏名称' ,
`out_game_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外部平台的游戏代码' ,
`parent_id`  int(11) NULL DEFAULT NULL ,
`fk_live_id`  tinyint(4) NULL DEFAULT NULL COMMENT '对应视讯来源' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='游戏类型'

;

-- ----------------------------
-- Records of ds_game_type
-- ----------------------------
BEGIN;
INSERT INTO `ds_game_type` VALUES ('0', null, null, null, null), ('1', 'BBIN球类', '1', null, '11'), ('3', 'BBIN视讯', '3', null, '11'), ('5', 'BBIN机率', '5', null, '11'), ('12', 'BBIN彩票', '12', null, '11'), ('18', 'LMG视讯', '18', null, '18'), ('21', 'AG视讯', '21', null, '2'), ('22', 'AG机率', '22', null, '2'), ('23', 'AG捕鱼', '23', null, '2'), ('24', 'AG体育', '24', null, '2'), ('42', 'H8体育', '42', null, '13'), ('56', 'DS官方彩', '56', null, '12'), ('57', 'DS经典PC28', '57', null, '12'), ('58', 'DS经典时时彩', '58', null, '12'), ('59', 'DS经典香港彩', '59', null, '12'), ('60', 'MG电子', '60', null, '15'), ('65', 'PMG电子', '65', null, '17'), ('70', 'OG视讯', '70', null, '3'), ('90', '开元棋牌', '90', null, '90'), ('95', '申博视讯', '95', null, '19'), ('96', '申博电子', '96', null, '19'), ('910', '最新游戏910', '910', '90', '90'), ('1001', '篮球', 'BK', '1', '11'), ('1002', '棒球', 'BS', '1', '11'), ('1003', '其他', 'F1', '1', '11'), ('1004', '美足', 'FB', '1', '11'), ('1005', '足球', 'FT', '1', '11'), ('1006', '指数', 'FU', '1', '11'), ('1007', '冰球', 'IH', '1', '11'), ('1008', '冠军', 'SP', '1', '11'), ('1009', '网球', 'TN', '1', '11'), ('1010', '混合过关', 'CB', '1', '11'), ('2400', 'AG体育', '2400', '24', '2'), ('3001', '百家乐', '3001', '3', '11'), ('3002', '二八杠', '3002', '3', '11'), ('3003', '龙虎斗', '3003', '3', '11'), ('3005', '三公', '3005', '3', '11'), ('3006', '温州牌九', '3006', '3', '11'), ('3007', '轮盘', '3007', '3', '11'), ('3008', '骰宝', '3008', '3', '11'), ('3010', '德州扑克', '3010', '3', '11'), ('3011', '色碟', '3011', '3', '11'), ('3012', '牛牛', '3012', '3', '11'), ('3013', '赛本引', '3013', '3', '11'), ('3014', '无限21点', '3014', '3', '11'), ('3015', '番摊', '3015', '3', '11'), ('3016', '鱼虾蟹', '3016', '3', '11'), ('3017', '保险百家乐', '3017', '3', '11'), ('3018', '最新游戏3018', '3018', '3', '11'), ('4200', 'H8体育', '4200', '42', '13'), ('5000', 'BBIN机率', '5000', '5', '11'), ('5004', '足球拉霸', '5004', '5', '11'), ('5005', '惑星战记', '5005', '5', '11'), ('5006', 'Starburst', '5006', '5', '11'), ('5007', '激爆水果盘', '5007', '5', '11'), ('5008', '猴子爬树', '5008', '5', '11'), ('5009', '金剛爬樓', '5009', '5', '11'), ('5010', '外星战记', '5010', '5', '11'), ('5011', '西遊記', '5011', '5', '11'), ('5012', '外星争霸', '5012', '5', '11'), ('5013', '傳統', '5013', '5', '11'), ('5014', '丛林', '5014', '5', '11'), ('5015', 'FIFA2010', '5015', '5', '11'), ('5016', '史前丛林冒险', '5016', '5', '11'), ('5017', '星際大戰', '5017', '5', '11'), ('5018', '齐天大圣', '5018', '5', '11'), ('5019', '水果樂園', '5019', '5', '11'), ('5020', '热带风情', '5020', '5', '11'), ('5025', '法海鬥白蛇', '5025', '5', '11'), ('5026', '2012伦敦奥运', '5026', '5', '11'), ('5027', '功夫龍', '5027', '5', '11'), ('5028', '中秋月光派对', '5028', '5', '11'), ('5029', '聖誕派對', '5029', '5', '11'), ('5030', '幸运财神', '5030', '5', '11'), ('5034', '王牌5PK', '5034', '5', '11'), ('5035', '加勒比扑克', '5035', '5', '11'), ('5039', '魚蝦蟹', '5039', '5', '11'), ('5040', '百搭二王', '5040', '5', '11'), ('5041', '7PK', '5041', '5', '11'), ('5042', '异星战场', '5042', '5', '11'), ('5043', '钻石水果盘', '5043', '5', '11'), ('5044', '明星97II', '5044', '5', '11'), ('5045', '最新游戏5045', '5045', '5', '11'), ('5046', '最新游戏5046', '5046', '5', '11'), ('5047', '屍樂園', '5047', '5', '11'), ('5048', '特务危机', '5048', '5', '11'), ('5049', '玉蒲團', '5049', '5', '11'), ('5050', '战火佳人', '5050', '5', '11'), ('5054', '爆骰', '5054', '5', '11'), ('5057', '明星97', '5057', '5', '11'), ('5058', '疯狂水果盘', '5058', '5', '11'), ('5059', '馬戲團', '5059', '5', '11'), ('5060', '动物奇观五', '5060', '5', '11'), ('5061', '超級7', '5061', '5', '11'), ('5062', '龙在囧途\r', '5062', '5', '11'), ('5063', '水果拉霸\r', '5063', '5', '11'), ('5064', '扑克拉霸', '5064', '5', '11'), ('5065', '筒子拉霸\r', '5065', '5', '11'), ('5066', '足球拉霸（新）', '5066', '5', '11'), ('5067', '大话西游', '5067', '5', '11');
INSERT INTO `ds_game_type` VALUES ('5068', '酷搜马戏团', '5068', '5', '11'), ('5069', '水果擂台', '5069', '5', '11'), ('5070', '黃金大轉輪', '5070', '5', '11'), ('5073', '百家乐大转轮', '5073', '5', '11'), ('5076', '數字大轉輪', '5076', '5', '11'), ('5077', '水果大转轮', '5077', '5', '11'), ('5078', '象棋大轉輪', '5078', '5', '11'), ('5079', '3D数字大转轮', '5079', '5', '11'), ('5080', '樂透轉輪', '5080', '5', '11'), ('5083', '钻石列车', '5083', '5', '11'), ('5084', '聖獸傳說', '5084', '5', '11'), ('5086', '海底派对', '5086', '5', '11'), ('5088', '鬥大', '5088', '5', '11'), ('5089', '红狗', '5089', '5', '11'), ('5090', '金鸡报喜', '5090', '5', '11'), ('5091', '三國拉霸', '5091', '5', '11'), ('5092', '封神榜', '5092', '5', '11'), ('5093', '金瓶梅', '5093', '5', '11'), ('5094', '金瓶梅2', '5094', '5', '11'), ('5095', '鬥雞', '5095', '5', '11'), ('5096', '五行', '5096', '5', '11'), ('5097', '最新游戏5097', '5097', '5', '11'), ('5098', '五福临门', '5098', '5', '11'), ('5099', '金狗旺岁', '5099', '5', '11'), ('5100', '最新游戏5100', '5100', '5', '11'), ('5101', '欧式轮盘', '5101', '5', '11'), ('5102', '美式輪盤', '5102', '5', '11'), ('5103', '彩金轮盘', '5103', '5', '11'), ('5104', '法式輪盤', '5104', '5', '11'), ('5105', '欧式轮盘（新）', '5105', '5', '11'), ('5106', '三国', '5106', '5', '11'), ('5107', '美式轮盘', '5107', '5', '11'), ('5108', '彩金轮盘', '5108', '5', '11'), ('5109', '法式轮盘（新）', '5109', '5', '11'), ('5115', '經典21點', '5115', '5', '11'), ('5116', '西班牙21点', '5116', '5', '11'), ('5117', '維加斯21點', '5117', '5', '11'), ('5118', '奖金21点', '5118', '5', '11'), ('5131', '皇家德州撲克', '5131', '5', '11'), ('5201', '火焰山', '5201', '5', '11'), ('5202', '月光寶盒', '5202', '5', '11'), ('5203', '爱你一万年', '5203', '5', '11'), ('5204', '2014FIFA', '5204', '5', '11'), ('5401', '天山侠侣传\r', '5401', '5', '11'), ('5402', '夜市人生', '5402', '5', '11'), ('5403', '七剑传说', '5403', '5', '11'), ('5404', '沙灘排球', '5404', '5', '11'), ('5405', '暗器之王', '5405', '5', '11'), ('5406', '神舟27', '5406', '5', '11'), ('5407', '大红帽与小野狼', '5407', '5', '11'), ('5601', '秘境冒險', '5601', '5', '11'), ('5701', '连连看', '5701', '5', '11'), ('5703', '發達囉', '5703', '5', '11'), ('5704', '斗牛', '5704', '5', '11'), ('5705', '聚寶盆', '5705', '5', '11'), ('5706', '浓情巧克力', '5706', '5', '11'), ('5707', '金錢豹', '5707', '5', '11'), ('5801', '海豚世界', '5801', '5', '11'), ('5802', '阿基里斯', '5802', '5', '11'), ('5803', '阿兹特克宝藏', '5803', '5', '11'), ('5804', '大明星', '5804', '5', '11'), ('5805', '凯萨帝国', '5805', '5', '11'), ('5806', '奇幻花園', '5806', '5', '11'), ('5808', '浪人武士', '5808', '5', '11'), ('5809', '空戰英豪', '5809', '5', '11'), ('5810', '航海时代', '5810', '5', '11'), ('5811', '狂歡夜', '5811', '5', '11'), ('5821', '国际足球', '5821', '5', '11'), ('5823', '發大財', '5823', '5', '11'), ('5824', '恶龙传说', '5824', '5', '11'), ('5825', '金蓮', '5825', '5', '11'), ('5826', '金矿工', '5826', '5', '11'), ('5827', '老船長', '5827', '5', '11'), ('5828', '霸王龙', '5828', '5', '11'), ('5831', '高球之旅', '5831', '5', '11'), ('5832', '高速卡车', '5832', '5', '11'), ('5833', '沉默武士', '5833', '5', '11'), ('5835', '喜福牛年', '5835', '5', '11'), ('5836', '龍捲風', '5836', '5', '11'), ('5837', '喜福猴年', '5837', '5', '11'), ('5839', '经典高球', '5839', '5', '11'), ('5888', 'JACKPOT', '5888', '5', '11'), ('5901', '連環奪寶', '5901', '5', '11'), ('5902', '糖果派对', '5902', '5', '11'), ('5903', '秦皇祕寶', '5903', '5', '11'), ('5904', '蒸气炸弹', '5904', '5', '11'), ('5905', '麻将连环宝', '5905', '5', '11'), ('5907', '趣味台球', '5907', '5', '11'), ('5908', '糖果派对2', '5908', '5', '11'), ('5909', '开心消消乐', '5909', '5', '11'), ('5910', '魔法元素', '5910', '5', '11'), ('5912', '连环夺宝2', '5912', '5', '11'), ('12000', 'BBIN彩票', '12000', '12', '11'), ('15000', 'BBIN3D厅', '15000', '15', '11'), ('15006', '3D玉蒲团', '15006', '15', '11'), ('15016', '厨王争霸', '15016', '15', '11'), ('15018', '激情243', '15018', '15', '11'), ('15019', '倩女幽魂', '15019', '15', '11'), ('15021', '全民狗仔', '15021', '15', '11'), ('15022', '怒火领空', '15022', '15', '11');
INSERT INTO `ds_game_type` VALUES ('15024', '2014世足赛', '15024', '15', '11'), ('16000', 'PT电子', 'PT', '16', '16'), ('16001', '3个小丑刮刮乐', '3 Clowns Scratch', '16', '16'), ('16002', '三卡吹牛', '3 Card Brag', '16', '16'), ('16003', '真人7席百家乐(一)', '7 Seat Baccarat Live', '16', '16'), ('16004', '真人7席百家乐(二)', '7 Seat Baccarat Live Tie Bet', '16', '16'), ('16005', '狂欢夜', 'A Night Out', '16', '16'), ('16006', '梦游仙境豪华版', 'Adventures in Wonderland', '16', '16'), ('16007', '众神时代', 'Age Of The Gods ™', '16', '16'), ('16008', '众神时代：命运姐妹', 'Fate Sisters', '16', '16'), ('16009', '众神时代：狂暴4', 'Furious Four', '16', '16'), ('16010', '众神时代：智慧女神', 'Goddess of Wisdom', '16', '16'), ('16011', '众神时代：奥林匹斯之王', 'King of Olympus', '16', '16'), ('16012', '众神时代：奥林匹斯王子', 'Prince of Olympus', '16', '16'), ('16013', '众神时代轮盘', 'Age of the Gods™ Roulette', '16', '16'), ('16014', '野生亚马逊', 'Amazon Wild', '16', '16'), ('16015', '美式21点', 'American Blackjack', '16', '16'), ('16016', '弓箭手(一)', 'Archer', '16', '16'), ('16017', '弓箭手(二)', 'Archer Double', '16', '16'), ('16018', '北极宝藏(一)', 'Arctic Treasure', '16', '16'), ('16019', '北极宝藏(二)', 'Arctic Treasure Double', '16', '16'), ('16020', '亚洲幻想', 'Asian Fantasy', '16', '16'), ('16021', '亚特兰蒂斯女王', 'Atlantis Queen', '16', '16'), ('16022', '百家乐(一)', 'Baccarat', '16', '16'), ('16023', '百家乐(二)', 'Baccarat Pair Bet', '16', '16'), ('16024', '百家乐(三)', 'Baccarat Perfect Pair Bet', '16', '16'), ('16025', '百家乐(四)', 'Baccarat Small Bet', '16', '16'), ('16026', '百家乐(五)', 'Baccarat Tie Bet', '16', '16'), ('16027', '百家乐(六)', 'Baccarat Without Sidebets', '16', '16'), ('16028', '真人百家乐(五)', 'Baccarat Live', '16', '16'), ('16029', '真人百家乐(六)', 'Baccarat Live Tie Bet', '16', '16'), ('16030', '白狮', 'Bai Shi', '16', '16'), ('16031', '海滨嘉年华', 'Beach Life', '16', '16'), ('16032', '百慕大三角', 'Bermuda Triangle', '16', '16'), ('16033', '21点(一)', 'Blackjack Multihand 3', '16', '16'), ('16034', '21点(二)', 'Blackjack Multihand 5', '16', '16'), ('16035', '21点(三)', 'Mobile Blackjack', '16', '16'), ('16036', '21点(四)', 'Mobile Blackjack 3-hand', '16', '16'), ('16037', '21点(五)', 'Mobile Blackjack 5-hand', '16', '16'), ('16038', '真人21点(一)', 'Black Jack Live', '16', '16'), ('16039', '真人21点(二)', 'Live Blackjack Behind Seat', '16', '16'), ('16040', '真人21点(三)', 'Black Jack Live 21+3', '16', '16'), ('16041', '真人21点(四)', 'Multi-Hand Blackjack Live Dealer Perfect Pair', '16', '16'), ('16042', '真人21点(五)', 'Multi-Hand Blackjack Live Player Perfect Pair', '16', '16'), ('16043', '多幅投降21点(一)', 'Blackjack Surrender Multihand 3', '16', '16'), ('16044', '多幅投降21点(二)', 'Blackjack Surrender Multihand 5', '16', '16'), ('16045', '多幅投降21点(三)', 'Blackjack Surrender', '16', '16'), ('16046', '熊之舞', 'Bonus Bears', '16', '16'), ('16047', '魔豆赏金', 'Bounty of the Beanstalk', '16', '16'), ('16048', '犎牛闪电突击', 'Buffalo Blitz', '16', '16'), ('16049', '船长的宝藏', 'Captain\'s Treasure', '16', '16'), ('16050', '船长的宝藏 加强版', 'Captain\'s Treasure Pro', '16', '16'), ('16051', '深海大赢家', 'Cash Fish', '16', '16'), ('16052', '猫王战赌城', 'Cat In Vegas', '16', '16'), ('16053', '猫后(一)', 'Cat Queen', '16', '16'), ('16054', '猫后(二)', 'Cat Queen Kiosk', '16', '16'), ('16055', '猫后(三)', 'Cat Queen Kiosk Double', '16', '16'), ('16056', '猫后(四)', 'Cat Queen Double', '16', '16'), ('16057', '娱乐场同花顺', 'Casino Hold \'Em', '16', '16'), ('16058', '真人娱乐场同花顺(一)', 'Casino Hold\'Em Live', '16', '16'), ('16059', '真人娱乐场同花顺(二)', 'Casino Hold\'Em Live AA Bet', '16', '16'), ('16060', '现金魔块', 'Cashblox', '16', '16'), ('16061', '超级 888', 'Chaoji 888', '16', '16'), ('16062', '狂野樱桃(一)', 'Cherry Love', '16', '16'), ('16063', '狂野樱桃(二)', 'Cherry Love Double', '16', '16'), ('16064', '宝箱满满', 'Chests of Plenty', '16', '16'), ('16065', '中式厨房', 'Chinese Kitchen', '16', '16'), ('16066', '经典老虎机刮刮乐', 'Classic Slot Scratch', '16', '16'), ('16067', '警察和土匪', 'Cops N\' Bandits', '16', '16'), ('16068', '牛仔和外星人', 'Cowboys & Aliens', '16', '16'), ('16069', '疯狂之七', 'Crazy 7', '16', '16'), ('16070', '无畏的戴夫', 'Daring Dave & the Eye of Ra', '16', '16'), ('16071', '沙漠财宝', 'Desert Treasure', '16', '16'), ('16072', '沙漠财宝二', 'Desert Treasure II', '16', '16'), ('16073', '钻石山谷 加强版(一)', 'Diamond Valley Pro', '16', '16'), ('16074', '钻石山谷 加强版(二)', 'Diamond Valley Pro Double', '16', '16'), ('16075', 'Dollar Ball sidegame', 'Dollar Ball sidegame', '16', '16'), ('16076', '海豚之梦(一)', 'Dolphin Reef', '16', '16'), ('16077', '海豚之梦(二)', 'Dolphin Reef Double', '16', '16'), ('16078', '龙之国度', 'Dragon Kingdom', '16', '16'), ('16079', '情圣博士', 'Dr Love More', '16', '16'), ('16080', '复活节惊喜(一)', 'Easter Surprise Double', '16', '16'), ('16081', '复活节惊喜(二)', 'Easter Surprise', '16', '16'), ('16082', '欧式轮盘(一)', 'European Roulette', '16', '16'), ('16083', '欧式轮盘(二)', 'Mobile Roulette', '16', '16'), ('16084', '真人 VIP 轮盘', 'Live VIP Roulette', '16', '16'), ('16085', '埃斯梅拉达(一)', 'Esmeralda', '16', '16'), ('16086', '埃斯梅拉达(二)', 'Esmeralda 0.01$', '16', '16'), ('16087', '埃斯梅拉达(三)', 'Esmeralda 0.02$', '16', '16'), ('16088', '埃斯梅拉达(四)', 'Esmeralda 0.04$', '16', '16'), ('16089', '埃斯梅拉达(五)', 'Esmeralda 0.08$', '16', '16'), ('16090', '埃斯梅拉达(六)', 'Esmeralda 0.20$', '16', '16'), ('16091', '埃斯梅拉达(七)', 'Esmeralda 0.40$', '16', '16'), ('16092', '埃斯梅拉达(八)', 'Esmeralda 1$', '16', '16'), ('16093', '埃斯梅拉达(九)', 'Esmeralda Double', '16', '16'), ('16094', '埃斯梅拉达(十)', 'Esmeralda Kiosk', '16', '16'), ('16095', '埃斯梅拉达(十一)', 'Esmeralda Kiosk 0.01$', '16', '16'), ('16096', '埃斯梅拉达(十二)', 'Esmeralda Kiosk 0.02$', '16', '16'), ('16097', '埃斯梅拉达(十三)', 'Esmeralda Kiosk 0.03$', '16', '16'), ('16098', '埃斯梅拉达(十四)', 'Esmeralda Kiosk 0.04$', '16', '16');
INSERT INTO `ds_game_type` VALUES ('16099', '埃斯梅拉达(十五)', 'Esmeralda Kiosk 0.05$', '16', '16'), ('16100', '埃斯梅拉达(十六)', 'Esmeralda Kiosk 0.06$', '16', '16'), ('16101', '埃斯梅拉达(十七)', 'Esmeralda Kiosk 0.08$', '16', '16'), ('16102', '埃斯梅拉达(十八)', 'Esmeralda Kiosk Double', '16', '16'), ('16103', '欢乐积宝彩池(一)', 'Everybody\'s Jackpot', '16', '16'), ('16104', '欢乐积宝彩池(二)', 'Everybody\'s Jackpot Game', '16', '16'), ('16105', '魔镜与公主', 'Fairest of Them All', '16', '16'), ('16106', '翡翠公主(一)', 'Fei Cui Gong Zhu', '16', '16'), ('16107', '翡翠公主(二)', 'Fei Cui Gong Zhu Gamble', '16', '16'), ('16108', '飞龙在天', 'Fei Long Zai Tian', '16', '16'), ('16109', '疯狂麻将', 'Feng Kuang Ma Jiang', '16', '16'), ('16110', '鱼虾蟹', 'Fish Prawn Crab', '16', '16'), ('16111', '五虎将(一)', 'Five Tiger Generals', '16', '16'), ('16112', '五虎将(二)', 'Five Tiger Generals $0.04', '16', '16'), ('16113', '五虎将(三)', 'Five Tiger Generals $0.10', '16', '16'), ('16114', '五虎将(四)', 'Five Tiger Generals $0.20', '16', '16'), ('16115', '五虎将(五)', 'Five Tiger Generals $0.40', '16', '16'), ('16116', '足球嘉年华', 'Football Carnival', '16', '16'), ('16117', '终极足球', 'Football Rules', '16', '16'), ('16118', '惊异之林', 'Forest of Wonder', '16', '16'), ('16119', '五福海盗(一)', 'Fortunate Five', '16', '16'), ('16120', '五福海盗(二)', 'Fortunate Five $0.04', '16', '16'), ('16121', '五福海盗(三)', 'Fortunate Five $0.10', '16', '16'), ('16122', '五福海盗(四)', 'Fortunate Five $0.20', '16', '16'), ('16123', '五福海盗(五)', 'Fortunate Five $0.40', '16', '16'), ('16124', '幸运日 (一)', 'Fortune Day', '16', '16'), ('16125', '幸运日 (二)', 'Fortune Day 1', '16', '16'), ('16126', '幸运日 (三)', 'Fortune Day 2', '16', '16'), ('16127', '幸运日 (四)', 'Fortune Day 3', '16', '16'), ('16128', '幸运日 (五)', 'Fortune Day 4', '16', '16'), ('16129', '幸运日 (六)', 'Fortune Day 5', '16', '16'), ('16130', '狐媚宝藏', 'Fortunes of The Fox', '16', '16'), ('16131', '幸运狮子', 'Fortune Lions', '16', '16'), ('16132', '青春之泉', 'Fountain of Youth', '16', '16'), ('16133', '德托里传奇(一)', 'Frankie Dettori\'s Magic Seven', '16', '16'), ('16134', '德托里传奇(二)', 'Frankie Dettori\'s Magic Seven Double', '16', '16'), ('16135', '德托里传奇积宝游戏(一)', 'Frankie Dettori\'s Magic Seven Jackpot', '16', '16'), ('16136', '德托里传奇积宝游戏(二)', 'Frankie Dettori\'s Magic Seven Jackpot Gamble', '16', '16'), ('16137', '水果狂热(一)', 'Fruit Mania', '16', '16'), ('16138', '水果狂热(二)', 'Fruit Mania 25c', '16', '16'), ('16139', '圆月财富', 'Full Moon Fortunes', '16', '16'), ('16140', '酷炫水果积宝游戏 (一)', 'Funky Fruits Jackpot Game', '16', '16'), ('16141', '酷炫水果积宝游戏 (二)', 'Funky Fruits Jackpot 1$', '16', '16'), ('16142', '酷炫水果积宝游戏 (三)', 'Funky Fruits Jackpot 2$', '16', '16'), ('16143', '酷炫水果积宝游戏 (四)', 'Funky Fruits Jackpot 5$', '16', '16'), ('16144', '酷炫水果积宝游戏 (五)', 'Funky Fruits Jackpot 10$', '16', '16'), ('16145', '酷炫水果农场', 'Funky Fruits Farm', '16', '16'), ('16146', '古怪猴子', 'Funky Monkey', '16', '16'), ('16147', '艺伎故事 ', 'Geisha Story', '16', '16'), ('16148', '艺伎故事积宝游戏 ', 'Geisha Story Jackpot', '16', '16'), ('16149', '宝石女王', 'Gem Queen', '16', '16'), ('16150', '角斗士(一)', 'Gladiator', '16', '16'), ('16151', '角斗士(二)', 'Gladiator Double', '16', '16'), ('16152', '角斗士(三)', 'Gladiator High', '16', '16'), ('16153', '角斗士(四)', 'Gladiator High Double', '16', '16'), ('16154', '角斗士积宝(一)', 'Gladiator Jackpot', '16', '16'), ('16155', '角斗士积宝(二)', 'Gladiator Jackpot Double', '16', '16'), ('16156', '角斗士积宝(三)', 'Gladiator Jackpot Game', '16', '16'), ('16157', '金色召集', 'Gold Rally', '16', '16'), ('16158', '黄金体育竞技场(一)', 'Golden Games', '16', '16'), ('16159', '黄金体育竞技场(二)', 'Golden Games Double', '16', '16'), ('16160', '黄金之旅', 'Golden Tour', '16', '16'), ('16161', '海底探宝(一)', 'Great Blue', '16', '16'), ('16162', '海底探宝(二)', 'Great Blue Double', '16', '16'), ('16163', '最强奥德赛', 'Greatest Odyssey', '16', '16'), ('16164', '好事成双', 'Haoshi Cheng Shuang (haocs)', '16', '16'), ('16165', '万圣节宝藏(一)', 'Halloween Fortune', '16', '16'), ('16166', '万圣节宝藏(二)', 'Halloween Fortune Double', '16', '16'), ('16167', '万圣节宝藏 2', 'Halloween Fortune II', '16', '16'), ('16168', '鬼宅', 'Haunted House', '16', '16'), ('16169', '丛林之心', 'Heart of The Jungle', '16', '16'), ('16170', '武则天', 'Heavenly Ruler', '16', '16'), ('16171', '高速公路之王', 'Highway Kings', '16', '16'), ('16172', '高速公路之王加强版', 'Highway Kings Pro', '16', '16'), ('16173', '炙热宝石', 'Hot Gems', '16', '16'), ('16174', '火热KTV', 'Hot KTV', '16', '16'), ('16175', '浮冰流', 'Ice Run', '16', '16'), ('16176', '印加帝国头奖(一)', 'Inca Jackpot', '16', '16'), ('16177', '印加帝国头奖(二)', 'Inca Jackpot $0.5', '16', '16'), ('16178', '印加帝国头奖(三)', 'Inca Jackpot $1', '16', '16'), ('16179', '印加帝国头奖(四)', 'Inca Jackpot $10', '16', '16'), ('16180', '印加帝国头奖(五)', 'Inca Jackpot $2.5', '16', '16'), ('16181', '印加帝国头奖(六)', 'Inca Jackpot $5', '16', '16'), ('16182', '幸运爱尔兰(一)', 'Irish Luck', '16', '16'), ('16183', '幸运爱尔兰(二)', 'Irish Luck Double', '16', '16'), ('16184', '幸运爱尔兰(三)', 'Irish Luck (GTS)', '16', '16'), ('16185', '奖金巨人(一)', 'Jackpot Giant Jackpot 0.03$', '16', '16'), ('16186', '奖金巨人(二)', 'Jackpot Giant', '16', '16'), ('16187', '奖金巨人(三)', 'Jackpot Giant Jackpot 0.01$', '16', '16'), ('16188', '奖金巨人(四)', 'Jackpot Giant Jackpot 0.02$', '16', '16'), ('16189', '奖金巨人(五)', 'Jackpot Giant Jackpot 0.04$', '16', '16'), ('16190', '奖金巨人(六)', 'Jackpot Giant Jackpot 0.05$', '16', '16'), ('16191', '奖金巨人(七)', 'Jackpot Giant Jackpot 0.08$', '16', '16'), ('16192', '玉皇大帝', 'Jade Emperor', '16', '16'), ('16193', '吉祥 8', 'Ji Xiang 8', '16', '16'), ('16194', '金钱蛙', 'Jin Qian Wa', '16', '16'), ('16195', '约翰韦恩', 'John Wayne', '16', '16'), ('16196', '无敌金刚', 'Kong The Eighth Wonder Of The World', '16', '16'), ('16197', '遍地黄金', 'Land of Gold', '16', '16'), ('16198', '烈焰钻石', 'Lie Yan Zuan Shi', '16', '16');
INSERT INTO `ds_game_type` VALUES ('16199', '真人百家乐(一)', 'Live Baccarat Big Bet', '16', '16'), ('16200', '真人百家乐(二)', 'Live Baccarat Either Pair Bet', '16', '16'), ('16201', '真人百家乐(三)', 'Live Baccarat Small Bet', '16', '16'), ('16202', '真人百家乐(四)', 'Egalite Baccarat Sidebet', '16', '16'), ('16203', '真人法式轮盘', 'Live French Roulette', '16', '16'), ('16204', '真人迷你21点', 'Live Mini Blackjack', '16', '16'), ('16205', '真人迷你轮盘', 'Live Mini Roulette', '16', '16'), ('16206', '龙龙龙', 'Long Long Long', '16', '16'), ('16207', '疯狂乐透', 'Lotto Madness', '16', '16'), ('16208', '幸运熊猫', 'Lucky Panda', '16', '16'), ('16209', '魔力老虎机', 'Magical Stacks', '16', '16'), ('16210', '神奇老虎机(一)', 'MagicSlots', '16', '16'), ('16211', '神奇老虎机(二)', 'MagicSlots 25c', '16', '16'), ('16212', '神奇老虎机(三)', 'MagicSlots $1', '16', '16'), ('16213', '神奇老虎机(四)', 'MagicSlots $5', '16', '16'), ('16214', '神奇老虎机(五)', 'MagicSlots 50c', '16', '16'), ('16215', '玛丽莲梦露', 'Marilyn Monroe', '16', '16'), ('16216', '幸运女士', 'Miss Fortune', '16', '16'), ('16217', '蒙提派森之万世魔星', 'Monty Python\'s Life of Brian', '16', '16'), ('16218', '返利先生(一)', 'Mr. Cashback', '16', '16'), ('16219', '返利先生(二)', 'Mr. Cashback Double', '16', '16'), ('16220', '海王星王国', 'Neptunes Kingdom', '16', '16'), ('16221', '年年有余(一)', 'Nian Nian You Yu', '16', '16'), ('16222', '年年有余(二)', 'Nian Nian You Yu Asia', '16', '16'), ('16223', '真人无佣金7席百家乐', 'No Commission 7 Seat Baccarat Live', '16', '16'), ('16224', '真人无佣金百家乐', 'No Commission Baccarat Live', '16', '16'), ('16225', '月亮下的黑豹(一)', 'Panther Moon', '16', '16'), ('16226', '月亮下的黑豹(二)', 'Panther Moon Double', '16', '16'), ('16227', '派对风景线', 'Party Line', '16', '16'), ('16228', '多幅完美21点', 'Perfect Blackjack Multihand 5', '16', '16'), ('16229', '企鹅度假(一)', 'Penguin Vacation', '16', '16'), ('16230', '企鹅度假(二)', 'Penguin Vacation Double', '16', '16'), ('16231', '法老王的秘密(一)', 'Pharaoh\'s Secrets', '16', '16'), ('16232', '法老王的秘密(二)', 'Pharaoh\'s Secrets Double', '16', '16'), ('16233', '三只小猪与大灰狼', 'Piggies and the Wolf', '16', '16'), ('16234', '粉红豹(一)', 'Pink Panther', '16', '16'), ('16235', '粉红豹(二)', 'Pink Panther Double', '16', '16'), ('16236', '充裕财富', 'Plenty O\'Fortune', '16', '16'), ('16237', '紫色狂热(一)', 'Purple Hot', '16', '16'), ('16238', '紫色狂热(二)', 'Purple Hot $0.01', '16', '16'), ('16239', '紫色狂热(三)', 'Purple Hot $0.02', '16', '16'), ('16240', '紫色狂热(四)', 'Purple Hot $0.03', '16', '16'), ('16241', '紫色狂热(五)', 'Purple Hot $0.04', '16', '16'), ('16242', '紫色狂热(六)', 'Purple Hot $0.05', '16', '16'), ('16243', '紫色狂热(七)', 'Purple Hot $0.06', '16', '16'), ('16244', '紫色狂热(八)', 'Purple Hot $0.1', '16', '16'), ('16245', '紫色狂热(九)', 'Purple Hot $0.2', '16', '16'), ('16246', '紫色狂热(十)', 'Purple Hot $0.4', '16', '16'), ('16247', '紫色狂热(十一)', 'Purple Hot $1', '16', '16'), ('16248', '紫色狂热(十二)', 'Purple Hot $2', '16', '16'), ('16249', '紫色狂热(十三)', 'Purple Hot $5', '16', '16'), ('16250', '紫色狂热(十四)', 'Purple Hot Double', '16', '16'), ('16251', '紫色狂热(十五)', 'Purple Hot Kiosk Double', '16', '16'), ('16252', '紫色狂热(十六)', 'Purple Hot Kiosk', '16', '16'), ('16253', '紫色狂热(十七)', 'Purple Hot Kiosk $0.01', '16', '16'), ('16254', '紫色狂热(十八)', 'Purple Hot Kiosk $0.02', '16', '16'), ('16255', '紫色狂热(十九)', 'Purple Hot Kiosk $0.03', '16', '16'), ('16256', '紫色狂热(二十)', 'Purple Hot Kiosk $0.04', '16', '16'), ('16257', '紫色狂热(二十一)', 'Purple Hot Kiosk $0.05', '16', '16'), ('16258', '紫色狂热(二十二)', 'Purple Hot Kiosk $0.06', '16', '16'), ('16259', '紫色狂热(二十三)', 'Purple Hot Kiosk $0.1', '16', '16'), ('16260', '紫色狂热(二十四)', 'Purple Hot Kiosk $0.2', '16', '16'), ('16261', '紫色狂热(二十五)', 'Purple Hot Kiosk $0.4', '16', '16'), ('16262', '奖金美式轮盘', 'Premium American Roulette', '16', '16'), ('16263', '奖金欧式轮盘', 'Premium European Roulette', '16', '16'), ('16264', '真人威信轮盘', 'Roulette Live', '16', '16'), ('16265', '真人累积百家乐(一)', 'Progressive Live Baccarat Sidebet $5', '16', '16'), ('16266', '真人累积百家乐(二)', 'Progressive Live Baccarat', '16', '16'), ('16267', '真人累积百家乐(三)', 'Progressive Live Baccarat Sidebet $2', '16', '16'), ('16268', '真人累积百家乐(四)', 'Progressive Live Baccarat Sidebet $10', '16', '16'), ('16269', '真人累积百家乐(五)', 'Progressive Live Baccarat Sidebet $20', '16', '16'), ('16270', '真人累积百家乐(六)', 'Progressive Live Baccarat Sidebet', '16', '16'), ('16271', '真人累积百家乐(七)', 'Progressive Live Baccarat Tie Bet', '16', '16'), ('16272', '金字塔女王(一)', 'Queen of Pyramids', '16', '16'), ('16273', '金字塔女王(二)', 'Queen of Pyramids 15c', '16', '16'), ('16274', '金字塔女王(三)', 'Queen of Pyramids 25c', '16', '16'), ('16275', '权杖女王', 'Queen Of Wands', '16', '16'), ('16276', '日日进财(一)', 'Ri Ri Jin Cai', '16', '16'), ('16277', '日日进财(二)', 'Ri Ri Jin Cai 1', '16', '16'), ('16278', '日日进财(三)', 'Ri Ri Jin Cai 2', '16', '16'), ('16279', '日日进财(四)', 'Ri Ri Jin Cai 3', '16', '16'), ('16280', '日日进财(五)', 'Ri Ri Jin Cai 4', '16', '16'), ('16281', '日日进财(六)', 'Ri Ri Jin Cai 5', '16', '16'), ('16282', '日日生财(一)', 'Ri Ri Sheng Cai', '16', '16'), ('16283', '日日生财(二)', 'Ri Ri Sheng Cai 18', '16', '16'), ('16284', '日日生财(三)', 'Ri Ri Sheng Cai 18 VIP', '16', '16'), ('16285', '日日生财(四)', 'Ri Ri Sheng Cai 38', '16', '16'), ('16286', '日日生财(五)', 'Ri Ri Sheng Cai 38 VIP', '16', '16'), ('16287', '日日生财(六)', 'Ri Ri Sheng Cai 68', '16', '16'), ('16288', '日日生财(七)', 'Ri Ri Sheng Cai 68 VIP', '16', '16'), ('16289', '日日生财(八)', 'Ri Ri Sheng Cai 78', '16', '16'), ('16290', '日日生财(九)', 'Ri Ri Sheng Cai 78 VIP', '16', '16'), ('16291', '日日生财(十)', 'Ri Ri Sheng Cai 8', '16', '16'), ('16292', '日日生财(十一)', 'Ri Ri Sheng Cai 88', '16', '16'), ('16293', '日日生财(十二)', 'Ri Ri Sheng Cai 88 VIP', '16', '16'), ('16294', '日日生财(十三)', 'Ri Ri Sheng Cai 8 VIP', '16', '16'), ('16295', '洛奇(一)', 'Rocky', '16', '16'), ('16296', '洛奇(二)', 'Rocky Double', '16', '16'), ('16297', '罗马荣光(一)', 'Rome and Glory', '16', '16'), ('16298', '罗马荣光(二)', 'Rome and Glory Double', '16', '16');
INSERT INTO `ds_game_type` VALUES ('16299', '罗马荣光(三)', 'Rome & Glory', '16', '16'), ('16300', '魔方财富', 'Rubik\'s Riches', '16', '16'), ('16301', '野生狩猎(一)', 'Safari Heat', '16', '16'), ('16302', '野生狩猎(二)', 'Safari Heat Double', '16', '16'), ('16303', '桑巴之舞', 'Samba Brazil', '16', '16'), ('16304', '圣诞老人奇袭(一)', 'Santa Surprise', '16', '16'), ('16305', '圣诞老人奇袭(二)', 'Santa Surprise Double', '16', '16'), ('16306', '大草原现金', 'Savannah Cash', '16', '16'), ('16307', '亚马逊之谜', 'Secrets of the Amazon', '16', '16'), ('16308', '神秘夏洛克', 'Sherlock Mystery', '16', '16'), ('16309', '四象', 'Si Xiang', '16', '16'), ('16310', '真人骰宝', 'Sic Bo Live', '16', '16'), ('16311', '俄式童话加强版(一)', 'Skazka Pro', '16', '16'), ('16312', '俄式童话加强版(二)', 'Skazka Pro Double', '16', '16'), ('16313', '忍者风云(一)', 'Silent Samurai', '16', '16'), ('16314', '忍者风云(二)', 'Silent Samurai Double', '16', '16'), ('16315', '忍者风云积宝游戏(一)', 'Silent Samurai Jackpot', '16', '16'), ('16316', '忍者风云积宝游戏(二)', 'Silent Samurai Jackpot Gamble', '16', '16'), ('16317', '四灵', 'Si Ling', '16', '16'), ('16318', '银弹', 'Silver Bullet', '16', '16'), ('16319', '辛巴达金航记', 'Sinbad\'s Golden Voyage', '16', '16'), ('16320', '斯巴达(一)', 'Sparta', '16', '16'), ('16321', '斯巴达(二)', 'Sparta Double', '16', '16'), ('16322', '欧莱里之黄金大田(一)', 'Spud O\'Reilly\'s Crops of Gold', '16', '16'), ('16323', '欧莱里之黄金大田(二)', 'Spud O\'Reilly\'s Crops of Gold Gamble', '16', '16'), ('16324', '标准五卷轴', 'Standard Fivereel', '16', '16'), ('16325', '幸运直击(一)', 'Streak of Luck Jackpot 0.04$', '16', '16'), ('16326', '幸运直击(二)', 'Streak of Luck Jackpot 0.01$', '16', '16'), ('16327', '幸运直击(三)', 'Streak of Luck', '16', '16'), ('16328', '幸运直击(四)', 'Streak of Luck Jackpot 0.1$', '16', '16'), ('16329', '幸运直击(五)', 'Streak of Luck Jackpot 0.2$', '16', '16'), ('16330', '幸运直击(六)', 'Streak of Luck Jackpot 0.4$', '16', '16'), ('16331', '幸运直击(七)', 'Streak of Luck Jackpot 0.02$', '16', '16'), ('16332', '孙悟空', 'Sun Wukong', '16', '16'), ('16333', '超级狮子', 'Super Lion', '16', '16'), ('16334', '甜蜜派对(一)', 'Sweet Party Jackpot 1$', '16', '16'), ('16335', '甜蜜派对(二)', 'Sweet Party Jackpot 10$', '16', '16'), ('16336', '甜蜜派对(三)', 'Sweet Party Jackpot 5$', '16', '16'), ('16337', '甜蜜派对(四)', 'Sweet Party Jackpot 2$', '16', '16'), ('16338', '泰国梦天堂(一)', 'Thai Paradise', '16', '16'), ('16339', '泰国梦天堂(二)', 'Thai Paradise Double', '16', '16'), ('16340', '泰国佛寺(一)', 'Thai Temple', '16', '16'), ('16341', '泰国佛寺(二)', 'Thai Temple Kiosk', '16', '16'), ('16342', '泰国佛寺(三)', 'Thai Temple $0.01', '16', '16'), ('16343', '泰国佛寺(四)', 'Thai Temple $0.02', '16', '16'), ('16344', '泰国佛寺(五)', 'Thai Temple $0.03', '16', '16'), ('16345', '泰国佛寺(六)', 'Thai Temple $0.04', '16', '16'), ('16346', '泰国佛寺(七)', 'Thai Temple $0.05', '16', '16'), ('16347', '泰国佛寺(八)', 'Thai Temple $0.06', '16', '16'), ('16348', '泰国佛寺(九)', 'Thai Temple $0.08', '16', '16'), ('16349', '泰国佛寺(十)', 'Thai Temple $0.1', '16', '16'), ('16350', '泰国佛寺(十一)', 'Thai Temple $0.2', '16', '16'), ('16351', '泰国佛寺(十二)', 'Thai Temple $0.4', '16', '16'), ('16352', '泰国佛寺(十三)', 'Thai Temple $1', '16', '16'), ('16353', '泰国佛寺(十四)', 'Thai Temple Double', '16', '16'), ('16354', '泰国佛寺(十五)', 'Thai Temple Kiosk $0.01', '16', '16'), ('16355', '泰国佛寺(十六)', 'Thai Temple Kiosk $0.02', '16', '16'), ('16356', '泰国佛寺(十七)', 'Thai Temple Kiosk $0.03', '16', '16'), ('16357', '泰国佛寺(十八)', 'Thai Temple Kiosk $0.04', '16', '16'), ('16358', '泰国佛寺(十九)', 'Thai Temple Kiosk $0.05', '16', '16'), ('16359', '泰国佛寺(二十)', 'Thai Temple Kiosk $0.06', '16', '16'), ('16360', '泰国佛寺(二十一)', 'Thai Temple Kiosk $0.08', '16', '16'), ('16361', '泰国佛寺(二十二)', 'Thai Temple Kiosk $0.1', '16', '16'), ('16362', '泰国佛寺(二十三)', 'Thai Temple Kiosk $0.2', '16', '16'), ('16363', '泰国佛寺(二十四)', 'Thai Temple Kiosk Double', '16', '16'), ('16364', '海上寻宝(一)', 'The Discovery', '16', '16'), ('16365', '海上寻宝(二)', 'The Discovery Double', '16', '16'), ('16366', '爵士俱乐部', 'The Jazz Club', '16', '16'), ('16367', '大明帝国', 'The Great Ming Empire', '16', '16'), ('16368', '恋爱之船(一)', 'The Love Boat Jackpot 2.0$', '16', '16'), ('16369', '恋爱之船(二)', 'The Love Boat Jackpot 5.0$', '16', '16'), ('16370', '恋爱之船(三)', 'The Love Boat Jackpot 20.0$', '16', '16'), ('16371', '恋爱之船(四)', 'The Love Boat Jackpot 25.0$', '16', '16'), ('16372', '恋爱之船(五)', 'The Love Boat Jackpot 50.0$', '16', '16'), ('16373', '恋爱之船(六)', 'The Love Boat Jackpot 1.0$', '16', '16'), ('16374', '恋爱之船(七)', 'The Love Boat Jackpot 0.75$', '16', '16'), ('16375', '恋爱之船(八)', 'The Love Boat Jackpot 0.5$', '16', '16'), ('16376', '恋爱之船(九)', 'The Love Boat Jackpot 0.25$', '16', '16'), ('16377', '恋爱之船(十)', 'The Love Boat Jackpot 0.2$', '16', '16'), ('16378', '恋爱之船(十一)', 'The Love Boat Jackpot 0.1$', '16', '16'), ('16379', '恋爱之船(十二)', 'The Love Boat Jackpot 0.05$', '16', '16'), ('16380', '恋爱之船(十三)', 'The Love Boat Jackpot 0.02$', '16', '16'), ('16381', '恋爱之船(十四)', 'The Love Boat Jackpot 0.01$', '16', '16'), ('16382', '恋爱之船(十五)', 'The Love Boat', '16', '16'), ('16383', '恋爱之船(十六)', 'The Love Boat Jackpot 10.0$', '16', '16'), ('16384', '木乃伊迷城(一)', 'The Mummy Expanding Mummy', '16', '16'), ('16385', '木乃伊迷城(二)', 'The Mummy Expanding Mummy+FG', '16', '16'), ('16386', '木乃伊迷城(三)', 'The Mummy Expanding Mummy+B ', '16', '16'), ('16387', '木乃伊迷城(四)', 'The Mummy Expanding Mummy+FG+B', '16', '16'), ('16388', '木乃伊迷城(五)', 'The Mummy Scarab Attack', '16', '16'), ('16389', '木乃伊迷城(六)', 'The Mummy Scarab Attack+FG', '16', '16'), ('16390', '木乃伊迷城(七)', 'The Mummy Scarab Attack+B ', '16', '16'), ('16391', '木乃伊迷城(八)', 'The Mummy Scarab Attack+FG+B', '16', '16'), ('16392', '木乃伊迷城(九)', 'The Mummy Collapsing Reels ', '16', '16'), ('16393', '木乃伊迷城(十)', 'The Mummy Collapsing Reels+FG', '16', '16'), ('16394', '木乃伊迷城(十一)', 'The Mummy Collapsing Reels+B ', '16', '16'), ('16395', '木乃伊迷城(十二)', 'The Mummy Collapsing Reels+FG+B', '16', '16'), ('16396', '木乃伊迷城(十三)', 'The Mummy Power ', '16', '16'), ('16397', '木乃伊迷城(十四)', 'The Mummy Power+FG', '16', '16'), ('16398', '木乃伊迷城(十五)', 'The Mummy Power+B ', '16', '16');
INSERT INTO `ds_game_type` VALUES ('16399', '木乃伊迷城(十六)', 'The Mummy Power+FG+B', '16', '16'), ('16400', '木乃伊迷城(十七)', 'The Mummy Respin ', '16', '16'), ('16401', '木乃伊迷城(十八)', 'The Mummy Respin+FG ', '16', '16'), ('16402', '木乃伊迷城(十九)', 'The Mummy Respin+B ', '16', '16'), ('16403', '木乃伊迷城(二十)', 'The Mummy Respin+FG+B', '16', '16'), ('16404', '木乃伊迷城(二十一)', 'The Mummy Scorpion Scatter', '16', '16'), ('16405', '木乃伊迷城(二十二)', 'The Mummy Scorpion Scatter+FG', '16', '16'), ('16406', '木乃伊迷城(二十三)', 'The Mummy Scorpion Scatter+B ', '16', '16'), ('16407', '木乃伊迷城(二十四)', 'The Mummy Scorpion Scatter+FG+B', '16', '16'), ('16408', '木乃伊迷城(二十五)', 'The Mummy', '16', '16'), ('16409', '唐吉诃德', 'The Riches of Don Quixote', '16', '16'), ('16410', '三个火枪手', 'The Three Musketeers and The Queen\'s Diamond™', '16', '16'), ('16411', '三门问题', 'Time for a Deal', '16', '16'), ('16412', '捍卫战士', 'Top Gun', '16', '16'), ('16413', '顶级王牌名人游戏(一)', 'Top Trumps Celebs', '16', '16'), ('16414', '顶级王牌名人游戏(二)', 'Top Trumps Celebs Double', '16', '16'), ('16415', '三友行', 'Tres Amigos', '16', '16'), ('16416', '三倍猴子', 'Triple Monkey', '16', '16'), ('16417', '真爱游戏(一)', 'True Love', '16', '16'), ('16418', '真爱游戏(二)', 'True Love Double', '16', '16'), ('16419', '部落生活', 'Ugga Bugga', '16', '16'), ('16420', '真人无限21点(一)', 'Unlimited Blackjack Live', '16', '16'), ('16421', '真人无限21点(二)', 'Unlimited Blackjack Live 21+3', '16', '16'), ('16422', '真人无限21点(三)', 'Unlimited Blackjack Live Dealer Perfect Pair', '16', '16'), ('16423', '真人无限21点(四)', 'Unlimited Blackjack Live Player Perfect Pair', '16', '16'), ('16424', '开心假期', 'Vacation Station', '16', '16'), ('16425', '开心假期豪華版(一)', 'Vacation Station Deluxe', '16', '16'), ('16426', '开心假期豪華版(二)', 'Vacation Station Deluxe Coin 1', '16', '16'), ('16427', '开心假期豪華版(三)', 'Vacation Station Deluxe Coin 2', '16', '16'), ('16428', '开心假期豪華版(四)', 'Vacation Station Deluxe Coin 3', '16', '16'), ('16429', '维京狂热', 'Vikingmania', '16', '16'), ('16430', '真人 VIP 百家乐(一)', 'VIP Baccarat Live', '16', '16'), ('16431', '真人 VIP 百家乐(二)', 'VIP Baccarat Live Tie Bet', '16', '16'), ('16432', '白狮王', 'White King', '16', '16'), ('16433', '野生动物大世界', 'Wild Gambler', '16', '16'), ('16434', '野生世界：北极大冒险', 'Wild Gambler 2: Arctic Adventure', '16', '16'), ('16435', '狂野精灵(一)', 'Wild Spirit', '16', '16'), ('16436', '狂野精灵(二)', 'Wild Spirit Double', '16', '16'), ('16437', '纯金之翼', 'Wings of Gold', '16', '16'), ('16438', '舞龙', 'Wu Long', '16', '16'), ('16439', '舞龙积宝游戏', 'Wu Long Jackpot', '16', '16'), ('16440', '五路财神(一)', 'Wu Lu Cai Shen', '16', '16'), ('16441', '五路财神(二)', 'Wu Lu Cai Shen $0.04', '16', '16'), ('16442', '五路财神(三)', 'Wu Lu Cai Shen $0.10', '16', '16'), ('16443', '五路财神(四)', 'Wu Lu Cai Shen $0.20', '16', '16'), ('16444', '五路财神(五)', 'Wu Lu Cai Shen $0.40', '16', '16'), ('16445', '招财进宝', 'Zhao Cai Jin Bao', '16', '16'), ('16446', '招财进宝积宝财池', 'Zhao Cai Jin Bao Jackpot', '16', '16'), ('16447', '招财童子', 'Zhao Cai Tong Zi', '16', '16'), ('16448', '龙(彩金)', 'Dragon Jackpot', '16', '16'), ('16449', '众神时代(彩金)', 'Age of the Gods Jackpot', '16', '16'), ('16450', '甜蜜派对(五)', 'Sweet Party', '16', '16'), ('16451', '沙漠财宝(手机版)', 'Mobile Desert Treasure', '16', '16'), ('16452', '冒险(彩金)', 'Adventure Jackpot', '16', '16'), ('16453', '水晶鞋', 'The Glass Slipper', '16', '16'), ('16454', '美式轮盘', 'American Roulette', '16', '16'), ('16455', '六福兽', 'Liu Fu Shou', '16', '16'), ('16456', '好事成双', 'Haoshi Cheng Shuang', '16', '16'), ('16457', '职业21点', 'Blackjack Pro', '16', '16'), ('16458', '德托里传奇积宝游戏(三)', 'Frankie Dettori\'s Magic Seven Jackpot Progressive', '16', '16'), ('16459', '黄金武士', 'Warriors Gold', '16', '16'), ('16460', '最新游戏Live Hi-Lo', 'Live Hi-Lo', '16', '16'), ('16461', '最新游戏3 Card Brag Live', '3 Card Brag Live', '16', '16'), ('16462', '最新游戏Sugar Land', 'Sugar Land', '16', '16'), ('16463', '最新游戏Tiao Tiao Mao Mao', 'Tiao Tiao Mao Mao', '16', '16'), ('16464', '最新游戏Age Of The Gods Live Roulette', 'Age Of The Gods Live Roulette', '16', '16'), ('16465', '最新游戏8 Treasures 1 Queen', '8 Treasures 1 Queen', '16', '16'), ('18000', '百家乐', 'BACCARAT', '18', '18'), ('18001', '龙虎', 'DRAGON_TIGER', '18', '18'), ('18002', '轮盘', 'ROULETTE', '18', '18'), ('18004', '骰宝', 'SICBO', '18', '18'), ('18006', '斗牛', 'BULL_BULL', '18', '18'), ('21001', '百家乐', 'BAC', '21', '2'), ('21002', '包桌百家乐', 'CBAC', '21', '2'), ('21003', '连环百家乐', 'LINK', '21', '2'), ('21004', '龙虎', 'DT', '21', '2'), ('21005', '骰宝', 'SHB', '21', '2'), ('21006', '轮盘', 'ROU', '21', '2'), ('21007', '番攤', 'FT', '21', '2'), ('21008', '竞咪百家乐', 'LBAC', '21', '2'), ('21009', '终极德州扑克', 'ULPK', '21', '2'), ('21010', '保险百家乐', 'SBAC', '21', '2'), ('21011', '牛牛', 'NN', '21', '2'), ('21012', '21点', 'BJ', '21', '2'), ('21013', '炸金花', 'ZJH', '21', '2'), ('21014', '斗牛', 'BF', '21', '2'), ('22000', 'AG机率', '22000', '22', '2'), ('22001', '疯狂水果店', 'SL2', '22', '2'), ('22002', '3D水族馆', 'SL3', '22', '2'), ('22003', '视频扑克(杰克高手)', 'PK_J', '22', '2'), ('22004', '极速赛车', 'SL4', '22', '2'), ('22005', '新视频扑克(杰克高手)', 'PKBJ', '22', '2'), ('22006', '水果拉霸', 'FRU', '22', '2'), ('22008', '美女沙排(沙滩排球)', 'SLM1', '22', '2'), ('22009', '运财羊(新年运财羊)', 'SLM2', '22', '2'), ('22010', '武圣传', 'SLM3', '22', '2'), ('22011', '幸运老虎机', 'SC01', '22', '2'), ('22012', '极速幸运轮', 'TGLW', '22', '2'), ('22013', '武则天', 'SLM4', '22', '2'), ('22014', '赌场战争', 'TGCW', '22', '2');
INSERT INTO `ds_game_type` VALUES ('22015', '太空漫游', 'SB01', '22', '2'), ('22016', '复古花园', 'SB02', '22', '2'), ('22017', '关东煮', 'SB03', '22', '2'), ('22018', '牧场咖啡', 'SB04', '22', '2'), ('22019', '甜一甜屋', 'SB05', '22', '2'), ('22020', '日本武士', 'SB06', '22', '2'), ('22021', '巴西世界杯', 'SL1', '22', '2'), ('22022', '麻将老虎机', 'SB08', '22', '2'), ('22023', '西洋棋老虎机', 'SB09', '22', '2'), ('22024', '开心农场', 'SB10', '22', '2'), ('22025', '夏日营地', 'SB11', '22', '2'), ('22026', '海底漫游', 'SB12', '22', '2'), ('22027', '鬼马小丑', 'SB13', '22', '2'), ('22028', '机动乐园', 'SB14', '22', '2'), ('22029', '惊吓鬼屋', 'SB15', '22', '2'), ('22030', '疯狂马戏团', 'SB16', '22', '2'), ('22031', '海洋剧场', 'SB17', '22', '2'), ('22032', '水上乐园', 'SB18', '22', '2'), ('22033', '土地神', 'SB25', '22', '2'), ('22034', '空中戰爭', 'SB19', '22', '2'), ('22035', '搖滾狂迷', 'SB20', '22', '2'), ('22036', '越野機車', 'SB21', '22', '2'), ('22037', '埃及奧秘', 'SB22', '22', '2'), ('22038', '歡樂時光', 'SB23', '22', '2'), ('22039', '侏羅紀', 'SB24', '22', '2'), ('22040', '布袋和尚', 'SB26', '22', '2'), ('22041', '正財神', 'SB27', '22', '2'), ('22042', '武財神', 'SB28', '22', '2'), ('22043', '偏財神', 'SB29', '22', '2'), ('22044', '性感女僕', 'AV01', '22', '2'), ('22045', '龍珠', 'XG01', '22', '2'), ('22046', '幸運 8', 'XG02', '22', '2'), ('22047', '閃亮女郎', 'XG03', '22', '2'), ('22048', '金魚', 'XG04', '22', '2'), ('22049', '中國新年', 'XG05', '22', '2'), ('22050', '海盜王', 'XG06', '22', '2'), ('22051', '鮮果狂熱', 'XG07', '22', '2'), ('22052', '小熊貓', 'XG08', '22', '2'), ('22053', '大豪客', 'XG09', '22', '2'), ('22054', '靈猴獻瑞', 'SB30', '22', '2'), ('22055', '体育', 'FIFA', '22', '2'), ('22057', '水果拉霸 2', 'FRU2', '22', '2'), ('22059', '象棋老虎机', 'SB07', '22', '2'), ('22060', '齐天大圣', 'SB32', '22', '2'), ('22061', '糖果碰碰乐', 'SB33', '22', '2'), ('22062', '冰河世界', 'SB34', '22', '2'), ('22063', '上海百乐门', 'SB37', '22', '2'), ('22064', '美女大格斗', 'XG13', '22', '2'), ('22065', '龙凤呈祥', 'XG14', '22', '2'), ('22066', '黄金对垒', 'XG16', '22', '2'), ('22067', '龙舟竞渡', 'XG10', '22', '2'), ('22068', '红利百搭', 'PKBB', '22', '2'), ('22069', '百搭二王', 'PKBD', '22', '2'), ('22070', '轮盘', 'TA0G', '22', '2'), ('22071', 'Hilo 低额投注', 'TA07', '22', '2'), ('22072', '5 手 Hilo', 'TA0A', '22', '2'), ('22073', '1 手百搭小丑', 'TA17', '22', '2'), ('22074', '1 手杰克高手', 'TA12', '22', '2'), ('22075', '1 手二十一点 低额投注', 'TA04', '22', '2'), ('22076', '10 手百搭小丑', 'TA18', '22', '2'), ('22077', '韩风劲舞', 'XG12', '22', '2'), ('22078', '巴黎茶座', 'TA0X', '22', '2'), ('22079', '10 手杰克高手', 'TA13', '22', '2'), ('22080', '中秋佳节', 'XG11', '22', '2'), ('22081', '法老秘密', 'TA0M', '22', '2'), ('22082', '多手二十一点 高额投注', 'TA03', '22', '2'), ('22083', '3 手 Hilo 高额投注', 'TA0C', '22', '2'), ('22084', '轮盘 高额投注', 'TA0F', '22', '2'), ('22085', '竞技狂热', 'SB38', '22', '2'), ('22086', '捕鱼王者', 'SB36', '22', '2'), ('22087', '1 手二十一点', 'TA05', '22', '2'), ('22088', '多手二十一点', 'TA02', '22', '2'), ('22089', '欧洲轮盘 低额投注移动版', 'TA1P', '22', '2'), ('22090', '欧洲轮盘移动版', 'TA1O', '22', '2'), ('22091', '天空守护者', 'SB31', '22', '2'), ('22092', '50 手杰克高手', 'TA15', '22', '2'), ('22093', '金龙献宝', 'TA0Y', '22', '2'), ('22094', '无法无天', 'TA0L', '22', '2'), ('22095', '海盗夺宝', 'TA0W', '22', '2'), ('22096', '10 手百搭二王', 'TA1D', '22', '2'), ('22097', '欧洲列强争霸', 'SB35', '22', '2'), ('22098', '烈火战车', 'TA0N', '22', '2'), ('22099', '富贵金鸡', 'SV41', '22', '2'), ('22100', '星际大战', 'TA0V', '22', '2'), ('22101', '日与夜', 'TA0Q', '22', '2'), ('22102', '怪兽食坊', 'TA0P', '22', '2'), ('22103', '多手二十一点 低额投注', 'TA01', '22', '2'), ('22104', '25 手百搭二王', 'TA1E', '22', '2'), ('22105', '捕猎季节', 'TA0O', '22', '2'), ('22106', '欧洲轮盘 低额投注(桌面版)', 'TA1M', '22', '2'), ('22107', '经典轿车', 'TA0U', '22', '2'), ('22108', '水果拉霸多人版', 'SX01', '22', '2'), ('22109', '欧洲轮盘(桌面版)', 'TA1L', '22', '2'), ('22110', '5 手百搭二王', 'TA11', '22', '2'), ('22111', '珠光宝气', 'TA0T', '22', '2'), ('22112', '5 手 Hilo 高额投注', 'TA0B', '22', '2'), ('22113', '飛禽走獸', 'YBIR', '22', '2'), ('22114', '百人牛牛', 'YMBN', '22', '2'), ('22115', '森林舞会多人版', 'YMFD', '22', '2'), ('22116', '奔馳寳馬單人', 'YBEN', '22', '2');
INSERT INTO `ds_game_type` VALUES ('22117', '水果派对', 'YFP', '22', '2'), ('22118', '水果拉霸單人版', 'YFR', '22', '2'), ('22119', '猜猜樂單人版', 'YGS', '22', '2'), ('22120', '德州牛仔', 'YDZ', '22', '2'), ('22121', '森林舞會單人版', 'YFD', '22', '2'), ('22122', '極速賽馬單人版', 'YHR', '22', '2'), ('22123', '赛亚烈战', 'YMFR', '22', '2'), ('22124', '多宝水果拉霸', 'YGFS', '22', '2'), ('22125', 'Hilo', 'TA08', '22', '2'), ('22126', '街头烈战', 'SX02', '22', '2'), ('22127', '金拉霸', 'SC03', '22', '2'), ('22128', '彩金水果拉霸', 'YJFS', '22', '2'), ('22129', '足球竞赛', 'TA0S', '22', '2'), ('22130', '50手百搭小丑', 'TA1A', '22', '2'), ('22131', '飞禽走兽多人版', 'YMBI', '22', '2'), ('22132', '猛龙传奇', 'SB45', '22', '2'), ('22133', '封神榜', 'DTAM', '22', '2'), ('22134', '英雄荣耀', 'DTAR', '22', '2'), ('22135', '快乐农庄', 'DTB1', '22', '2'), ('22136', '摇滾之夜', 'DTAZ', '22', '2'), ('22137', '赛亚烈战', 'DTA0', '22', '2'), ('22138', '牛牛对战', 'YMBA', '22', '2'), ('22139', '金龙珠', 'SB49', '22', '2'), ('22140', '50手百搭二王', 'TA1F', '22', '2'), ('22141', '奔驰宝马', 'YMBZ', '22', '2'), ('22142', '1手百搭二王', 'TA1C', '22', '2'), ('22143', '5手杰克高手', 'TA0Z', '22', '2'), ('22144', '动物狂欢', 'YMAC', '22', '2'), ('22145', '财神到', 'DTAF', '22', '2'), ('22146', '五行世界', 'DTA8', '22', '2'), ('22147', '梦幻森林', 'DTAB', '22', '2'), ('22148', '新年到', 'DTAG', '22', '2'), ('22149', '龙凤呈祥', 'DTAQ', '22', '2'), ('22150', '福禄寿', 'DTAT', '22', '2'), ('22151', '最新游戏SB50', 'SB50', '22', '2'), ('22152', '最新游戏SB47', 'SB47', '22', '2'), ('22153', '最新游戏YMJW', 'YMJW', '22', '2'), ('22154', '最新游戏YMJH', 'YMJH', '22', '2'), ('22155', '最新游戏YMJJ', 'YMJJ', '22', '2'), ('22156', '最新游戏YMSG', 'YMSG', '22', '2'), ('22157', '最新游戏YMBF', 'YMBF', '22', '2'), ('22158', '最新游戏EP02', 'EP02', '22', '2'), ('22159', '最新游戏YJTW', 'YJTW', '22', '2'), ('22160', '最新游戏EP03', 'EP03', '22', '2'), ('22161', '最新游戏TA1U', 'TA1U', '22', '2'), ('22162', '最新游戏WH06', 'WH06', '22', '2'), ('22163', '最新游戏TA1Q', 'TA1Q', '22', '2'), ('22164', '最新游戏WH04', 'WH04', '22', '2'), ('22165', '最新游戏SB51', 'SB51', '22', '2'), ('22166', '最新游戏WH11', 'WH11', '22', '2'), ('22167', '最新游戏WH10', 'WH10', '22', '2'), ('22168', '最新游戏YMD2', 'YMD2', '22', '2'), ('23001', '捕鱼王', 'HUNTER', '23', '2'), ('30000', 'KKWDS视讯', '30000', null, '30'), ('30001', '百家乐', 'BACCARAT', '30000', '30'), ('30002', '龙虎', 'DRAGON_TIGER', '30000', '30'), ('30003', '轮盘', 'ROULETTE', '30000', '30'), ('30004', '保险百家乐', 'BACCARAT_INSURANCE', '30000', '30'), ('30005', '骰宝', 'SICBO', '30000', '30'), ('30006', '色碟', 'XOC_DIA', '30000', '30'), ('30007', '斗牛', 'BULL_BULL', '30000', '30'), ('30599', '捕鱼达人', '30599', '5', '11'), ('38001', '捕鱼大师', '38001', '5', '11'), ('56001', '重庆时时彩', '2', '56', '12'), ('56002', 'PK10', '6', '56', '12'), ('56003', '新疆时时彩', '8', '56', '12'), ('56004', '江苏快3', '9', '56', '12'), ('56005', '天津时时彩', '14', '56', '12'), ('56006', '广东11选5', '24', '56', '12'), ('56007', '山东11选5', '26', '56', '12'), ('56008', '江西11选5', '27', '56', '12'), ('56009', '福彩3D', '28', '56', '12'), ('56010', '排列35', '29', '56', '12'), ('56011', '湖北快3', '30', '56', '12'), ('57001', '加拿大PC28', '10', '57', '12'), ('57002', '北京PC28', '11', '57', '12'), ('57003', '重庆PC28', '12', '57', '12'), ('57004', '新疆PC28', '13', '57', '12'), ('57005', '台湾宾果', '31', '57', '12'), ('57006', '加拿大西部keno', '32', '57', '12'), ('57007', '斯洛伐克', '33', '57', '12'), ('57008', '俄勒冈', '34', '57', '12'), ('58002', '重庆时时彩', '2', '58', '12'), ('58003', '幸运农场', '5', '58', '12'), ('58004', '北京赛车', '6', '58', '12'), ('58005', '广东快乐十分', '1', '58', '12'), ('58006', '广西快乐十分', '3', '58', '12'), ('58007', '新疆时时彩', '8', '58', '12'), ('58008', '江苏快3', '9', '58', '12'), ('58013', '天津时时彩', '14', '58', '12'), ('58014', '云南时时彩', '15', '58', '12'), ('58015', '天津快乐十分', '16', '58', '12'), ('58016', '湖南快乐十分', '17', '58', '12'), ('58017', '上海快3', '18', '58', '12'), ('58018', '广西快3', '19', '58', '12'), ('58019', '重庆六合彩', '20', '58', '12'), ('58020', '北京赛车22', '21', '58', '12'), ('58021', '幸运飞艇', '22', '58', '12'), ('58022', '广东11选5', '24', '58', '12'), ('58023', '山东11选5', '26', '58', '12');
INSERT INTO `ds_game_type` VALUES ('58024', '江西11选5', '27', '58', '12'), ('59001', '香港彩', '7', '59', '12'), ('60001', '5卷的驱动器 ', '28114', '60', '15'), ('60002', '王牌和八分', '28116', '60', '15'), ('60003', '王牌和面孔2', '28128', '60', '15'), ('60004', '王牌和面孔', '28122', '60', '15'), ('60005', '宫廷历险', '28134', '60', '15'), ('60006', '大航海时代', '28136', '60', '15'), ('60007', '美女秘探', '28138', '60', '15'), ('60008', '阿拉斯加钓鱼', '28144', '60', '15'), ('60009', '亚历山大在尸乐园', '28148', '60', '15'), ('60010', '所有王牌扑克', '28150', '60', '15'), ('60011', '所有美国', '28152', '60', '15'), ('60012', '美式轮盘', '28204', '60', '15'), ('60013', '极寒鸿运', '28166', '60', '15'), ('60014', '爱丽娜', '28174', '60', '15'), ('60015', '环游世界', '28182', '60', '15'), ('60016', '亚洲美人', '28188', '60', '15'), ('60017', '大西洋城黄金21点', '28192', '60', '15'), ('60018', '阿瓦隆', '28194', '60', '15'), ('60019', '阿瓦隆2', '28198', '60', '15'), ('60020', '百家乐', '28234', '60', '15'), ('60021', '百家乐黄金版', '28236', '60', '15'), ('60022', '篮球巨星', '44751', '60', '15'), ('60023', '太空堡垒', '28240', '60', '15'), ('60024', '啤酒巨星', '28242', '60', '15'), ('60025', '超级厨王', '28248', '60', '15'), ('60026', '大五黄金21点', '28260', '60', '15'), ('60027', '大破', '28266', '60', '15'), ('60028', '厨神', '28268', '60', '15'), ('60029', '征服钱海', '28270', '60', '15'), ('60030', '征服钱海-蛇与梯子', '28272', '60', '15'), ('60031', '马戏篷', '28274', '60', '15'), ('60032', '比基尼派对', '46497', '60', '15'), ('60033', '宾果富豪', '28276', '60', '15'), ('60034', '疯狂奖金局末平分', '28280', '60', '15'), ('60035', '奖金扑克', '28282', '60', '15'), ('60036', '豪华奖金扑克', '28284', '60', '15'), ('60037', '藏宝时间', '28286', '60', '15'), ('60038', '击倒', '28290', '60', '15'), ('60039', '摆脱', '28292', '60', '15'), ('60040', '抢银行 ', '28296', '60', '15'), ('60041', '银行爆破', '28310', '60', '15'), ('60042', '新娘吉拉', '29601', '60', '15'), ('60043', '泡泡富豪', '29591', '60', '15'), ('60044', '兔子锅炉', '28278', '60', '15'), ('60045', '黄金兔子锅炉', '28330', '60', '15'), ('60046', '燃烧的欲望', '28332', '60', '15'), ('60047', '丛林摇摆 ', '28336', '60', '15'), ('60048', '抢劫银行', '29555', '60', '15'), ('60049', '狂欢节', '28350', '60', '15'), ('60050', '现金蚬', '28354', '60', '15'), ('60051', '财运疯狂', '28358', '60', '15'), ('60052', '卡萨努瓦', '28364', '60', '15'), ('60053', '昆虫派对 ', '28368', '60', '15'), ('60054', '昆虫派对 ', '28372', '60', '15'), ('60055', '挥金如土', '28376', '60', '15'), ('60056', '中心球场', '28380', '60', '15'), ('60057', '锁子甲', '28384', '60', '15'), ('60058', '经典黄金21点', '28398', '60', '15'), ('60059', '酷巴克', '28400', '60', '15'), ('60060', '酷狼', '28404', '60', '15'), ('60061', '宇宙猫', '28408', '60', '15'), ('60062', '沙发土豆', '28414', '60', '15'), ('60063', '疯狂的80年代', '28418', '60', '15'), ('60064', '疯狂的变色龙', '28422', '60', '15'), ('60065', '板球明星', '29561', '60', '15'), ('60066', '鳄鱼建城邦', '28424', '60', '15'), ('60067', '国际鱼虾蟹骰宝', '28428', '60', '15'), ('60068', '地穴的远征', '28432', '60', '15'), ('60069', '黄金地穴的远征', '28436', '60', '15'), ('60070', '网络扑克', '28442', '60', '15'), ('60071', '黎明的面包', '28448', '60', '15'), ('60072', '闪亮的圣诞节', '28454', '60', '15'), ('60073', '百搭小丑扑克2', '28466', '60', '15'), ('60074', '百搭小丑扑克', '28460', '60', '15'), ('60075', '万能两点2', '28472', '60', '15'), ('60076', '万能两点', '28470', '60', '15'), ('60077', '恐龙迪诺', '28476', '60', '15'), ('60078', '医生的爱', '28478', '60', '15'), ('60079', '狗爸爸', '28480', '60', '15'), ('60080', '寻访海豚', '28484', '60', '15'), ('60081', '双重奖金扑克', '28486', '60', '15'), ('60082', '换牌扑克', '28492', '60', '15'), ('60083', '双重黄金曝光', '28494', '60', '15'), ('60084', '双百搭2', '28506', '60', '15'), ('60085', '双百搭', '28498', '60', '15'), ('60086', '双魔', '28510', '60', '15'), ('60087', '双重韦密', '28514', '60', '15'), ('60088', '恐怖实验室', '28522', '60', '15'), ('60089', '舞龙', '46494', '60', '15'), ('60090', '龙的鸿运', '28524', '60', '15'), ('60091', '熊峰战争', '28542', '60', '15'), ('60092', '老鹰的翅膀', '28562', '60', '15'), ('60093', '电宾果', '28566', '60', '15'), ('60094', '水果怪兽', '28568', '60', '15'), ('60095', '魔法森林', '28572', '60', '15'), ('60096', '欧洲黄金21点', '28576', '60', '15'), ('60097', '欧式黄金轮盘', '28580', '60', '15'), ('60098', '奇妙7', '28582', '60', '15');
INSERT INTO `ds_game_type` VALUES ('60099', '胖女人辛斯', '28584', '60', '15'), ('60100', '派对鱼', '28586', '60', '15'), ('60101', '超级飞行员', '28588', '60', '15'), ('60102', '泡沫财富', '28590', '60', '15'), ('60103', '足球明星', '28592', '60', '15'), ('60104', '幸运曲奇', '28594', '60', '15'), ('60105', '四乘四', '28596', '60', '15'), ('60106', '冻结模糊球', '28598', '60', '15'), ('60107', '法式轮盘', '28602', '60', '15'), ('60108', '水果老虎机', '28604', '60', '15'), ('60109', '银河舰队', '28606', '60', '15'), ('60110', '网球最终局', '28616', '60', '15'), ('60111', '精灵宝石', '28608', '60', '15'), ('60112', '细菌对对碰', '28614', '60', '15'), ('60113', '礼品包装', '28618', '60', '15'), ('60114', '女孩与枪II', '29449', '60', '15'), ('60115', '女孩与枪', '28622', '60', '15'), ('60116', '黄金海岸', '28624', '60', '15'), ('60117', '黄金工厂', '28626', '60', '15'), ('60118', '黄金龙', '28628', '60', '15'), ('60119', '黄金时代', '28630', '60', '15'), ('60120', '黄金食尸鬼', '28632', '60', '15'), ('60121', '疯狂赛道', '28636', '60', '15'), ('60122', '黄金囊地鼠', '28638', '60', '15'), ('60123', '老太太赛车', '28640', '60', '15'), ('60124', '大狮鹫', '28642', '60', '15'), ('60125', '毛茸茸的仙女', '28646', '60', '15'), ('60126', '万圣节', '28648', '60', '15'), ('60127', '万圣节2', '28650', '60', '15'), ('60128', '肉搏战', '28488', '60', '15'), ('60129', '快乐假日', '45397', '60', '15'), ('60130', '新年快乐', '28490', '60', '15'), ('60131', '哈维斯的晚餐', '28664', '60', '15'), ('60132', '地狱男爵', '28500', '60', '15'), ('60133', '地狱阿嬷', '28502', '60', '15'), ('60134', '六线', '28504', '60', '15'), ('60135', '高限制百家乐', '28508', '60', '15'), ('60136', '欧式高限21点', '28668', '60', '15'), ('60137', '上流社会', '28516', '60', '15'), ('60138', '高速扑克', '28518', '60', '15'), ('60139', '13欧洲 21点黃金桌', '28520', '60', '15'), ('60140', '终极杀手', '28670', '60', '15'), ('60141', '嗬嗬嗬', '28674', '60', '15'), ('60142', '地府烈焰', '28574', '60', '15'), ('60143', '神奇墨水', '28540', '60', '15'), ('60144', '棒球直击', '28534', '60', '15'), ('60145', '酷犬酒店', '28644', '60', '15'), ('60146', '龙之家', '28680', '60', '15'), ('60147', '不朽的爱情', '28548', '60', '15'), ('60148', '刮刮卡20合一', '29450', '60', '15'), ('60149', '爱尔兰眼睛', '28552', '60', '15'), ('60150', '累计奖金快车', '28558', '60', '15'), ('60151', '千斤顶或更好', '28694', '60', '15'), ('60152', '千斤顶或更好', '28686', '60', '15'), ('60153', '判若两人', '28660', '60', '15'), ('60154', '东方珠宝', '28652', '60', '15'), ('60155', '铃儿响叮当', '28654', '60', '15'), ('60156', '小丑扑克2', '28720', '60', '15'), ('60157', '小丑扑克', '28710', '60', '15'), ('60158', '侏罗纪大奖', '28724', '60', '15'), ('60159', '功夫小胖猪', '28726', '60', '15'), ('60160', '卡萨缦都', '28734', '60', '15'), ('60161', '基诺', '28740', '60', '15'), ('60162', '亚瑟王', '28744', '60', '15'), ('60163', '现金之王', '28762', '60', '15'), ('60164', '凯蒂卡巴拉', '28772', '60', '15'), ('60165', '女仕之夜', '28776', '60', '15'), ('60166', '红衣女郎', '28812', '60', '15'), ('60167', '财富阶级', '28780', '60', '15'), ('60168', '遗产L', '28786', '60', '15'), ('60169', '炫富一族', '28790', '60', '15'), ('60170', '海盗王', '28796', '60', '15'), ('60171', '路易斯安那双', '28814', '60', '15'), ('60172', '招财鞭炮', '28800', '60', '15'), ('60173', '幸运的锦鲤', '28794', '60', '15'), ('60174', '妖精的战利品', '28782', '60', '15'), ('60175', '幸运数字', '28778', '60', '15'), ('60176', '幸运双星', '42981', '60', '15'), ('60177', '幸运女巫', '28774', '60', '15'), ('60178', '幸运生肖', '28770', '60', '15'), ('60179', '疯狂的帽子', '28766', '60', '15'), ('60180', '终极破坏', '28758', '60', '15'), ('60181', '星战传奇', '28756', '60', '15'), ('60182', '玛雅宾果', '28748', '60', '15'), ('60183', '玛雅公主', '28738', '60', '15'), ('60184', '银行爆破', '28706', '60', '15'), ('60185', '海底世界 ', '28716', '60', '15'), ('60186', '疯狂的猴子', '28712', '60', '15'), ('60187', '怪物躁狂症', '28696', '60', '15'), ('60188', '月光', '28708', '60', '15'), ('60189', '奥林匹斯山', '28676', '60', '15'), ('60190', '疯狂假面', '28666', '60', '15'), ('60191', '复式黄金轮盘', '28816', '60', '15'), ('60192', '多手21点黄金桌', '28820', '60', '15'), ('60193', '多手21点黄金桌2', '28822', '60', '15'), ('60194', '多手21点黄金桌3', '28678', '60', '15'), ('60195', '多手21点黄金桌4', '28826', '60', '15'), ('60196', '孟买魔术', '28612', '60', '15'), ('60197', '怪兽曼琪肯', '28610', '60', '15'), ('60198', '神秘梦境 ', '28600', '60', '15');
INSERT INTO `ds_game_type` VALUES ('60199', '神秘森林', '28578', '60', '15'), ('60200', '章鱼', '28828', '60', '15'), ('60201', '临门一脚', '28658', '60', '15'), ('60202', '东方财富', '28564', '60', '15'), ('60203', '发现天堂', '28560', '60', '15'), ('60204', '躲猫猫', '42979', '60', '15'), ('60205', '幻影现金', '28570', '60', '15'), ('60206', '法老宾果', '28550', '60', '15'), ('60207', '隔离的宝石', '28842', '60', '15'), ('60208', '小猪财富', '28556', '60', '15'), ('60209', '持枪王者', '28546', '60', '15'), ('60210', '花花公子', '28858', '60', '15'), ('60211', '掠夺之海', '28544', '60', '15'), ('60212', '扑克追求', '28874', '60', '15'), ('60213', '蜜蜂乐园', '28890', '60', '15'), ('60214', '21点黄金桌', '28538', '60', '15'), ('60215', '21点黄金桌', '28536', '60', '15'), ('60216', '多手21点黄金桌', '28532', '60', '15'), ('60217', '超级赛马', '28530', '60', '15'), ('60218', '轮盘', '28528', '60', '15'), ('60219', '轮盘钻石版', '28526', '60', '15'), ('60220', '超级马车赛', '28904', '60', '15'), ('60221', '优质物业', '28910', '60', '15'), ('60222', '纯铂', '28512', '60', '15'), ('60223', '为粉红而战', '28496', '60', '15'), ('60224', '拉美西斯的财富', '28916', '60', '15'), ('60225', '急速转轮', '28482', '60', '15'), ('60226', '红唇诱惑', '28474', '60', '15'), ('60227', '宝石迷阵', '28468', '60', '15'), ('60228', '卷行使价', '28464', '60', '15'), ('60229', '雷电击', '28462', '60', '15'), ('60230', '复古旋转', '28458', '60', '15'), ('60231', '复古卷轴 - 极热', '28456', '60', '15'), ('60232', '复古卷轴钻石耀眼', '28452', '60', '15'), ('60233', '押韵的卷轴 - 心挞', '28450', '60', '15'), ('60234', '押韵的卷轴 - 老国王科尔', '28446', '60', '15'), ('60235', '海滨财富', '28444', '60', '15'), ('60236', '洛伯杰克', '28440', '60', '15'), ('60237', '摇滚船', '28438', '60', '15'), ('60238', '滚德比', '28434', '60', '15'), ('60239', '罗马财富', '28430', '60', '15'), ('60240', '橄榄球明星', '28426', '60', '15'), ('60241', '萨巴宾果', '28420', '60', '15'), ('60242', '圣诞老人的疯狂 ？', '28416', '60', '15'), ('60243', '守财奴', '28412', '60', '15'), ('60244', '秘密崇拜者', '28410', '60', '15'), ('60245', '圣诞老人的秘密', '28406', '60', '15'), ('60246', '宁静', '45399', '60', '15'), ('60247', '射击', '28402', '60', '15'), ('60248', '银芳', '28396', '60', '15'), ('60249', '六位枪手掠夺者黄金版', '28394', '60', '15'), ('60250', '骷髅陷阱', '28392', '60', '15'), ('60251', '猛撞恐惧', '28390', '60', '15'), ('60252', '怪兽多多', '28388', '60', '15'), ('60253', '糖果多多', '28386', '60', '15'), ('60254', '寿司多多', '28382', '60', '15'), ('60255', '动物足球', '28378', '60', '15'), ('60256', '太空逃避物', '28370', '60', '15'), ('60257', '太空逃避物黄金版', '28366', '60', '15'), ('60258', '西班牙21点', '28362', '60', '15'), ('60259', '西班牙21点', '28360', '60', '15'), ('60260', '财富之轮', '28356', '60', '15'), ('60261', '我推', '28352', '60', '15'), ('60262', '春假', '28348', '60', '15'), ('60263', '星尘', '45401', '60', '15'), ('60264', '星梦之吻', '28344', '60', '15'), ('60265', '星云', '28342', '60', '15'), ('60266', '泰坦之藏匿', '28340', '60', '15'), ('60267', '蒸汽朋克英雄', '28338', '60', '15'), ('60268', '纯银3D', '28334', '60', '15'), ('60269', '探索太阳', '28328', '60', '15'), ('60270', '太阳征程', '50193', '60', '15'), ('60271', '跑起来', '28326', '60', '15'), ('60272', '超级奖金宾果', '28322', '60', '15'), ('60273', '超级有趣21', '28320', '60', '15'), ('60274', '超级零点', '28318', '60', '15'), ('60275', '动物冲浪', '28314', '60', '15'), ('60276', '甜蜜的收获', '28312', '60', '15'), ('60277', '泰利嗬', '28308', '60', '15'), ('60278', '数万或更好', '28302', '60', '15'), ('60279', '数万或更好2', '28304', '60', '15'), ('60280', '终结者2', '28300', '60', '15'), ('60281', '蝙蝠侠崛起', '28298', '60', '15'), ('60282', '好日子', '28294', '60', '15'), ('60283', '失落的阿纳斯塔西娅公主', '28246', '60', '15'), ('60284', '鼠包', '28238', '60', '15'), ('60285', '反转马戏团', '28232', '60', '15'), ('60286', '埃及王座', '28230', '60', '15'), ('60287', '雷神', '28228', '60', '15'), ('60288', '雷神2', '28226', '60', '15'), ('60289', '熊虎之战', '28222', '60', '15'), ('60290', '太阳神之许珀里翁', '28112', '60', '15'), ('60291', '太阳神之忒伊亚', '28220', '60', '15'), ('60292', '古墓丽影', '28218', '60', '15'), ('60293', '古墓丽影2', '28216', '60', '15'), ('60294', '图腾宝藏', '28214', '60', '15'), ('60295', '三角', '28212', '60', '15'), ('60296', '三魔法', '28210', '60', '15'), ('60297', '三人德州扑克', '28208', '60', '15'), ('60298', '棒棒乌龟', '28206', '60', '15');
INSERT INTO `ds_game_type` VALUES ('60299', '野性的孟加拉虎', '28202', '60', '15'), ('60300', '狂野之鹰', '28200', '60', '15'), ('60301', '大熊猫', '28196', '60', '15'), ('60302', '野性的狼群', '28190', '60', '15'), ('60303', '拉斯维加斯21点单人黄金桌', '28186', '60', '15'), ('60304', '拉斯维加斯21点', '28180', '60', '15'), ('60305', '拉斯维加斯21点黄金桌', '28184', '60', '15'), ('60306', '维多利亚的恶棍', '28176', '60', '15'), ('60307', '乙烯基倒计时', '28172', '60', '15'), ('60308', '芥末寿司', '28168', '60', '15'), ('60309', '瓜分大奖', '28158', '60', '15'), ('60310', '猫头鹰乐园', '28178', '60', '15'), ('60311', '地球生物', '28154', '60', '15'), ('60312', '水果财富', '28156', '60', '15'), ('60313', '财富转轮特别版', '28146', '60', '15'), ('60314', '白水牛', '28140', '60', '15'), ('60315', '野生捕鱼', '28142', '60', '15'), ('60316', '野生冠军', '28132', '60', '15'), ('60317', '东方珍兽', '50194', '60', '15'), ('60318', '钱来运转', '29573', '60', '15'), ('60319', '赢得向导', '28130', '60', '15'), ('60320', '女巫的财富', '28126', '60', '15'), ('60321', '燃尼巨蟒', '28124', '60', '15'), ('60322', '108好汉', '59065', '60', '15'), ('60323', '三國', '59067', '60', '15'), ('60324', '丛林吉姆-黄金国', '66481', '60', '15'), ('60325', '昆虫派对刮刮乐', '28372----', '60', '15'), ('60326', '帽子里的兔子', '28912', '60', '15'), ('60327', '现金喷射 3轴', '29489\r\n29489\r\n29489', '60', '15'), ('60328', '现金喷射 5轴', '29491', '60', '15'), ('60329', '水果嘉年华 3轴', '29493', '60', '15'), ('60330', '水果嘉年华 5轴', '29495', '60', '15'), ('60331', '现金王', '29497', '60', '15'), ('60332', '战利品 3轴', '29499', '60', '15'), ('60333', '战利品 5轴', '29501', '60', '15'), ('60334', '百万少校', '29503', '60', '15'), ('60335', '百万钞票', '29505', '60', '15'), ('60336', '百万埃及女神', '29507', '60', '15'), ('60337', '尼羅河寶藏', '29509', '60', '15'), ('60338', '关爱财宝', '29511', '60', '15'), ('60339', '哇', '29513', '60', '15'), ('60340', '美国酒吧', '28682', '60', '15'), ('60341', '新娘吉拉', '45529', '60', '15'), ('60342', '埃及女神伊西絲', '28936', '60', '15'), ('60343', '狮子的骄傲', '28946', '60', '15'), ('60344', '夏天', '29050', '60', '15'), ('60345', '冒险之旅', '29453', '60', '15'), ('60346', '老虎之眼', '29118', '60', '15'), ('60347', '图腾宝藏', '29132', '60', '15'), ('60348', '瞧！', '29136', '60', '15'), ('60350', '急冻钻石', '66080', '60', '15'), ('60351', 'K歌乐韵', '65978', '60', '15'), ('60352', '猴子基诺', '66084', '60', '15'), ('60447', '雷电歌后', '61497', '60', '15'), ('60476', '黄金公主', '28634', '60', '15'), ('60530', '幸运的小妖精', '28788', '60', '15'), ('60557', '忍者法宝', '61149', '60', '15'), ('60579', '漂亮猫咪', '61147', '60', '15'), ('60588', '旋转大战', '61495', '60', '15'), ('60679', '开心点心', '61499', '60', '15'), ('60683', '急冻钻石', '66082', '60', '15'), ('60684', 'K歌乐韵', '66078', '60', '15'), ('60685', '5卷的驱动器', '28118', '60', '15'), ('60686', '王牌和八分', '28684', '60', '15'), ('60687', '王牌和面孔', '28690', '60', '15'), ('60688', '宫廷历险', '28688', '60', '15'), ('60689', '大航海时代', '28692', '60', '15'), ('60690', '美女秘探', '28698', '60', '15'), ('60691', '阿拉斯加钓鱼', '28700', '60', '15'), ('60692', '亚洲美人', '45531', '60', '15'), ('60693', '阿瓦隆', '28702', '60', '15'), ('60695', '篮球巨星', '45539', '60', '15'), ('60696', '沙滩宝贝', '28704', '60', '15'), ('60697', '马戏篷', '28714', '60', '15'), ('60698', '比基尼派对', '46810', '60', '15'), ('60699', '疯狂奖金局末平分', '28718', '60', '15'), ('60700', '抢银行', '28722', '60', '15'), ('60701', '银行爆破', '29451', '60', '15'), ('60703', '燃烧的欲望', '28730', '60', '15'), ('60704', '丛林摇摆', '28732', '60', '15'), ('60705', '狂欢节', '28736', '60', '15'), ('60706', '昆虫派对', '28750', '60', '15'), ('60707', '中心球场', '28742', '60', '15'), ('60708', '经典黄金21点', '28746', '60', '15'), ('60709', '沙发土豆', '28768', '60', '15'), ('60710', '闪亮的圣诞节', '28784', '60', '15'), ('60711', '万能两点', '28792', '60', '15'), ('60712', '换牌扑克', '28798', '60', '15'), ('60713', '舞龙', '46704', '60', '15'), ('60714', '老鹰的翅膀', '28802', '60', '15'), ('60715', '欧洲黄金21点', '28808', '60', '15'), ('60716', '欧式黄金轮盘', '28804', '60', '15'), ('60717', '足球明星', '28806', '60', '15'), ('60718', '黄金时代', '45537', '60', '15'), ('60719', '万圣节', '28818', '60', '15'), ('60720', '快乐假日', '45609', '60', '15'), ('60721', '上流社会', '28824', '60', '15'), ('60722', '终极杀手', '28832', '60', '15'), ('60724', '千斤顶或更好', '28942', '60', '15'), ('60725', '卡萨缦都', '28940', '60', '15');
INSERT INTO `ds_game_type` VALUES ('60726', '女仕之夜', '28944', '60', '15'), ('60728', '炫富一族', '28948', '60', '15'), ('60729', '幸运的锦鲤', '45611', '60', '15'), ('60730', '疯狂的帽子', '28950', '60', '15'), ('60731', '玛雅公主', '28952', '60', '15'), ('60732', '海底世界', '28956', '60', '15'), ('60733', '神秘梦境', '28970', '60', '15'), ('60734', '漂亮猫咪', '61151', '60', '15'), ('60735', '纯铂', '28984', '60', '15'), ('60736', '旋转大战', '61557', '60', '15'), ('60737', '雷电击', '29014', '60', '15'), ('60738', '橄榄球明星', '45535', '60', '15'), ('60739', '射击', '61153', '60', '15'), ('60740', '银芳', '29016', '60', '15'), ('60741', '怪兽多多', '45541', '60', '15'), ('60742', '糖果多多', '45545', '60', '15'), ('60743', '寿司多多', '45543', '60', '15'), ('60744', '春假', '29018', '60', '15'), ('60745', '星梦之吻', '29026', '60', '15'), ('60746', '泰坦之藏匿', '29452', '60', '15'), ('60747', '纯银3D', '45533', '60', '15'), ('60749', '太阳征程', '50191', '60', '15'), ('60750', '泰利嗬', '29058', '60', '15'), ('60752', '反转马戏团', '29074', '60', '15'), ('60753', '雷神', '29080', '60', '15'), ('60754', '雷神2', '29454', '60', '15'), ('60756', '古墓丽影', '29126', '60', '15'), ('60758', '大熊猫', '42983', '60', '15'), ('60760', '猫头鹰乐园', '29138', '60', '15'), ('60761', '东方珍兽', '50192', '60', '15'), ('60762', '开心点心', '61501', '60', '15'), ('60763', '现金喷射 3轴', '29489', '60', '15'), ('60777', '丛林吉姆-黄金国', '66605', '60', '15'), ('65001', '杂技群英会', '1892', '65', '17'), ('65002', '糖果巡游', '1893', '65', '17'), ('65003', '城堡建筑师II', '1894', '65', '17'), ('65004', '108好汉', '1302', '65', '17'), ('65005', '10手所有王牌', '1720', '65', '17'), ('65006', '10手疯狂奖金局末平分', '1799', '65', '17'), ('65007', '10手奖金扑克', '1746', '65', '17'), ('65008', '10手加倍双重奖金扑克', '1724', '65', '17'), ('65009', '10手千斤顶或更好', '1818', '65', '17'), ('65010', '100手王牌和面孔', '1772', '65', '17'), ('65011', '100手奖金扑克', '1730', '65', '17'), ('65012', '100手百搭小丑扑克', '1695', '65', '17'), ('65013', '100手万能两点', '1775', '65', '17'), ('65014', '100手加倍双重奖金扑克', '1722', '65', '17'), ('65015', '100手双倍小丑', '1728', '65', '17'), ('65016', '100手千斤顶或更好', '1713', '65', '17'), ('65017', '三國', '1109', '65', '17'), ('65018', '4手王牌和面孔', '1087', '65', '17'), ('65019', '4手百搭小丑扑克', '1219', '65', '17'), ('65020', '4手万能两点', '1077', '65', '17'), ('65021', '4手双百搭', '1276', '65', '17'), ('65022', '4手千斤顶或更好', '1046', '65', '17'), ('65023', '4手小丑扑克', '1149', '65', '17'), ('65024', '4手数万或更好', '1419', '65', '17'), ('65025', '5卷的驱动器', '1035', '65', '17'), ('65026', '50手王牌和面孔', '1778', '65', '17'), ('65027', '50手奖金扑克', '1819', '65', '17'), ('65028', '50手百搭小丑扑克', '1706', '65', '17'), ('65029', '50手万能两点', '1754', '65', '17'), ('65030', '50手加倍双重奖金扑克', '1760', '65', '17'), ('65031', '50手双倍小丑', '1770', '65', '17'), ('65032', '王牌和八面', '1324', '65', '17'), ('65033', '王牌和面孔', '1413', '65', '17'), ('65034', '冒险宫殿', '1010', '65', '17'), ('65035', '史地大发现', '1246', '65', '17'), ('65036', '特务珍金', '1155', '65', '17'), ('65037', '阿拉斯加捕捞', '1004', '65', '17'), ('65038', '亚里尸乐园', '1299', '65', '17'), ('65039', '所有王牌扑克', '1034', '65', '17'), ('65040', '所有美国', '1092', '65', '17'), ('65041', '胡同猫', '1773', '65', '17'), ('65042', '美国轮盘', '1248', '65', '17'), ('65043', '极寒鸿运', '1304', '65', '17'), ('65044', '爱丽娜', '1021', '65', '17'), ('65045', '环游世界', '1065', '65', '17'), ('65046', '亚洲美人', '1384', '65', '17'), ('65047', '大西洋城21点', '1690', '65', '17'), ('65048', '大西洋城黄金21点', '1191', '65', '17'), ('65049', '阿瓦隆', '1013', '65', '17'), ('65050', '阿瓦隆2', '1079', '65', '17'), ('65051', '百家乐', '1042', '65', '17'), ('65052', '百家乐黄金版', '1329', '65', '17'), ('65053', '黑绵羊咩咩叫', '1753', '65', '17'), ('65054', '黑绵羊咩咩叫5轴', '1788', '65', '17'), ('65055', '美国酒吧', '1257', '65', '17'), ('65056', '篮球巨星', '1159', '65', '17'), ('65057', '太空堡垒', '1372', '65', '17'), ('65058', '沙滩宝贝', '1263', '65', '17'), ('65059', '美丽骷髅', '1890', '65', '17'), ('65060', '啤酒巨星', '1076', '65', '17'), ('65061', '超级厨王', '1367', '65', '17'), ('65062', '大五黄金21点', '1337', '65', '17'), ('65063', '大破', '1206', '65', '17'), ('65064', '厨神', '1140', '65', '17'), ('65065', '征服钱海', '1399', '65', '17'), ('65066', '征服钱海-蛇与梯子', '1256', '65', '17'), ('65067', '马戏篷', '1133', '65', '17');
INSERT INTO `ds_game_type` VALUES ('65068', '比基尼派对', '1290', '65', '17'), ('65069', '宾果富豪', '1073', '65', '17'), ('65070', '奖金21点', '1840', '65', '17'), ('65071', '疯狂奖金局末平分', '1148', '65', '17'), ('65072', '奖金扑克', '1123', '65', '17'), ('65073', '豪华奖金扑克', '1144', '65', '17'), ('65074', '搏击怪物', '1733', '65', '17'), ('65075', '藏宝时间', '1375', '65', '17'), ('65076', '击倒', '1344', '65', '17'), ('65077', '冰球突破', '1229', '65', '17'), ('65078', '抢银行', '1023', '65', '17'), ('65079', '银行爆破', '1097', '65', '17'), ('65080', '伴娘', '1360', '65', '17'), ('65081', '新娘吉拉', '1341', '65', '17'), ('65082', '泡泡富豪', '1050', '65', '17'), ('65083', '靶心', '1718', '65', '17'), ('65084', '兔子锅炉', '1402', '65', '17'), ('65085', '黄金兔子锅炉', '1003', '65', '17'), ('65086', '燃烧的欲望', '1318', '65', '17'), ('65087', '丛林摇摆', '1173', '65', '17'), ('65088', '抢劫银行', '1204', '65', '17'), ('65089', '车舱发烧', '1781', '65', '17'), ('65090', '梦果子乐园', '1886', '65', '17'), ('65091', '狂欢节', '1117', '65', '17'), ('65092', '现金蚬', '1181', '65', '17'), ('65093', '财运疯狂', '1393', '65', '17'), ('65094', '卡萨努瓦', '1178', '65', '17'), ('65095', '昆虫派对', '1366', '65', '17'), ('65096', '昆虫派对(刮刮卡)', '1396', '65', '17'), ('65097', '挥金如土', '1197', '65', '17'), ('65098', '赌场战争', '1767', '65', '17'), ('65099', '中心球场', '1291', '65', '17'), ('65100', '锁子甲', '1106', '65', '17'), ('65101', '锁子甲2', '1749', '65', '17'), ('65102', '巧克力工厂', '1789', '65', '17'), ('65103', '经典243', '1879', '65', '17'), ('65104', '经典黄金21点', '1052', '65', '17'), ('65105', '运财酷儿', '1187', '65', '17'), ('65106', '运财酷儿-5卷轴', '1884', '65', '17'), ('65107', '酷狼', '1084', '65', '17'), ('65108', '宇宙猫', '1016', '65', '17'), ('65109', '沙发土豆', '1327', '65', '17'), ('65110', '饼干杰克', '1704', '65', '17'), ('65111', '疯狂的80年代', '1057', '65', '17'), ('65112', '疯狂变色龙', '1202', '65', '17'), ('65113', '板球明星', '1075', '65', '17'), ('65114', '鳄鱼建城邦', '1064', '65', '17'), ('65115', '国际鱼虾蟹骰宝', '1303', '65', '17'), ('65116', '地穴的远征', '1174', '65', '17'), ('65117', '黄金地穴的远征', '1390', '65', '17'), ('65118', '网络扑克', '1249', '65', '17'), ('65119', '黎明的面包', '1119', '65', '17'), ('65120', '闪亮的圣诞节？', '1234', '65', '17'), ('65121', '百搭小丑扑克', '1414', '65', '17'), ('65122', '万能两点', '1415', '65', '17'), ('65123', '恐龙迪诺', '1185', '65', '17'), ('65124', '医生的爱', '1069', '65', '17'), ('65125', '狗爸爸', '1082', '65', '17'), ('65126', '寻访海豚', '1309', '65', '17'), ('65127', '海豚故事', '1836', '65', '17'), ('65128', '双重奖金扑克', '1025', '65', '17'), ('65129', '换牌扑克', '1240', '65', '17'), ('65130', '双曝光21点', '1779', '65', '17'), ('65131', '双重黄金曝光', '1342', '65', '17'), ('65132', '双百搭', '1416', '65', '17'), ('65133', '双魔', '1143', '65', '17'), ('65134', '双O現金', '1793', '65', '17'), ('65135', '双重韦密', '1102', '65', '17'), ('65136', '恐怖实验室', '1319', '65', '17'), ('65137', '舞龙', '1037', '65', '17'), ('65138', '龙的鸿运', '1022', '65', '17'), ('65139', '幸运龙宝贝', '1424', '65', '17'), ('65140', '熊峰战争', '1272', '65', '17'), ('65141', '老鹰的翅膀', '1236', '65', '17'), ('65142', '雷电歌后', '1104', '65', '17'), ('65143', '电宾果', '1040', '65', '17'), ('65144', '水果怪兽', '1137', '65', '17'), ('65145', '青龙出海', '1882', '65', '17'), ('65146', '魔法森林', '1292', '65', '17'), ('65147', '欧式21点', '1739', '65', '17'), ('65148', '歐式21点黄金桌', '1051', '65', '17'), ('65149', '欧式黄金21点', '1698', '65', '17'), ('65150', '欧式轮盘', '1085', '65', '17'), ('65151', '欧式轮盘黄金桌', '1199', '65', '17'), ('65152', '奇妙7', '1017', '65', '17'), ('65153', '胖女人辛斯', '1125', '65', '17'), ('65154', '派对鱼', '1113', '65', '17'), ('65155', '超级飞行员', '1192', '65', '17'), ('65156', '泡沫财富', '1316', '65', '17'), ('65157', '足球明星', '1186', '65', '17'), ('65158', '禁忌王座', '1887', '65', '17'), ('65159', '幸运曲奇', '1282', '65', '17'), ('65160', '金库甜心', '1888', '65', '17'), ('65161', '四乘四', '1237', '65', '17'), ('65162', '自由精神之轮财富', '1691', '65', '17'), ('65163', '冻结模糊球', '1015', '65', '17'), ('65164', '法式轮盘', '1288', '65', '17'), ('65165', '急冻钻石', '1165', '65', '17'), ('65166', '水果老虎机', '1285', '65', '17'), ('65167', '水果VS糖果', '1878', '65', '17');
INSERT INTO `ds_game_type` VALUES ('65168', '银河舰队', '1311', '65', '17'), ('65169', '权力的游戏(15线)', '1800', '65', '17'), ('65170', '权力的游戏(243线)', '1817', '65', '17'), ('65171', '网球最终局', '1089', '65', '17'), ('65172', '精灵宝石', '1083', '65', '17'), ('65173', '细菌对对碰', '1259', '65', '17'), ('65174', '礼品包装', '1225', '65', '17'), ('65175', '女孩与枪II', '1322', '65', '17'), ('65176', '女孩与枪', '1313', '65', '17'), ('65177', '角斗士', '1823', '65', '17'), ('65178', '黄金海岸', '1066', '65', '17'), ('65179', '黄金工厂', '1267', '65', '17'), ('65180', '黄金龙', '1138', '65', '17'), ('65181', '黄金时代', '1041', '65', '17'), ('65182', '黄金食尸鬼', '1044', '65', '17'), ('65183', '金鹅糖果', '1700', '65', '17'), ('65184', '金鹅图腾珍宝', '1794', '65', '17'), ('65185', '金鹅获奖向导', '1815', '65', '17'), ('65186', '黄金公主', '1190', '65', '17'), ('65187', '疯狂赛道', '1055', '65', '17'), ('65188', '黄金囊地鼠', '1216', '65', '17'), ('65189', '老太太赛车', '1112', '65', '17'), ('65190', '大狮鹫', '1347', '65', '17'), ('65191', '吉普賽女王', '1689', '65', '17'), ('65192', '毛茸茸的仙女', '1182', '65', '17'), ('65193', '万圣节', '1047', '65', '17'), ('65194', '万圣节(刮刮卡)', '1014', '65', '17'), ('65195', '肉搏战', '1086', '65', '17'), ('65196', '快乐假日', '1072', '65', '17'), ('65197', '新年快乐', '1145', '65', '17'), ('65198', '哈维斯的晚餐', '1139', '65', '17'), ('65199', '地狱男爵', '1081', '65', '17'), ('65200', '地狱阿嬷', '1252', '65', '17'), ('65201', '六线', '1335', '65', '17'), ('65202', '高5', '1841', '65', '17'), ('65203', '高限制百家乐', '1265', '65', '17'), ('65204', '多手完美对子21点黄金桌', '1326', '65', '17'), ('65205', '上流社会', '1163', '65', '17'), ('65206', '高速扑克', '1203', '65', '17'), ('65207', '13欧洲21点黃金桌', '1281', '65', '17'), ('65208', '终极杀手', '1321', '65', '17'), ('65209', '嗬嗬嗬', '1296', '65', '17'), ('65210', '地府烈焰', '1261', '65', '17'), ('65211', '神奇墨水', '1376', '65', '17'), ('65212', '棒球直击', '1177', '65', '17'), ('65213', '酷犬酒店', '1063', '65', '17'), ('65214', '龙之家', '1067', '65', '17'), ('65215', '轩辕帝传', '1849', '65', '17'), ('65216', '不朽情缘', '1103', '65', '17'), ('65217', '刮刮卡20合一', '1331', '65', '17'), ('65218', '爱尔兰眼睛', '1361', '65', '17'), ('65219', '埃及女神伊西絲', '1250', '65', '17'), ('65220', '累计奖金快车', '1071', '65', '17'), ('65221', '千斤顶或更好', '1417', '65', '17'), ('65222', '判若两人', '1068', '65', '17'), ('65223', '东方珠宝', '1005', '65', '17'), ('65224', '铃儿响叮当', '1205', '65', '17'), ('65225', '小丑扑克', '1418', '65', '17'), ('65226', '丛林7s', '1719', '65', '17'), ('65227', '丛林吉姆', '1694', '65', '17'), ('65228', '丛林吉姆-黄金国', '1244', '65', '17'), ('65229', '侏罗纪大奖', '1297', '65', '17'), ('65230', '侏罗记公园', '1764', '65', '17'), ('65231', '侏罗纪世界', '1891', '65', '17'), ('65232', 'K歌乐韵', '1053', '65', '17'), ('65233', '功夫小胖猪', '1258', '65', '17'), ('65234', '卡萨缦都', '1151', '65', '17'), ('65235', '基诺', '1262', '65', '17'), ('65236', '亚瑟王', '1048', '65', '17'), ('65237', '现金之王', '1400', '65', '17'), ('65238', '凯蒂卡巴拉', '1286', '65', '17'), ('65239', '女仕之夜', '1389', '65', '17'), ('65240', '红衣女郎', '1124', '65', '17'), ('65241', '财富阶级', '1378', '65', '17'), ('65242', '遗产L', '1279', '65', '17'), ('65243', '富裕人生', '1851', '65', '17'), ('65244', '狮子的骄傲', '1049', '65', '17'), ('65245', '液体黄金', '1756', '65', '17'), ('65246', '炫富一族', '1245', '65', '17'), ('65247', '海盗王', '1135', '65', '17'), ('65248', '迷失拉斯维加斯', '1420', '65', '17'), ('65249', '路易斯安那双', '1059', '65', '17'), ('65250', '招财鞭炮', '1126', '65', '17'), ('65251', '幸运的锦鲤', '1060', '65', '17'), ('65252', '幸运的小妖精', '1212', '65', '17'), ('65253', '妖精的战利品', '1235', '65', '17'), ('65254', '幸运数字', '1224', '65', '17'), ('65255', '幸运双星', '1283', '65', '17'), ('65256', '幸运女巫', '1129', '65', '17'), ('65257', '幸运生肖', '1273', '65', '17'), ('65258', '疯狂的帽子', '1314', '65', '17'), ('65259', '魔法', '1826', '65', '17'), ('65260', '狂欢节热', '1755', '65', '17'), ('65261', '终极破坏', '1115', '65', '17'), ('65262', '星战传奇', '1223', '65', '17'), ('65263', '玛雅宾果', '1061', '65', '17'), ('65264', '玛雅公主', '1343', '65', '17'), ('65265', '巨额现金乘数', '1885', '65', '17'), ('65266', '巨型旋转双魔法', '1792', '65', '17'), ('65267', '巨型旋转高5', '1750', '65', '17');
INSERT INTO `ds_game_type` VALUES ('65268', '银行爆破', '1373', '65', '17'), ('65269', '海底世界', '1308', '65', '17'), ('65270', '疯狂的猴子', '1184', '65', '17'), ('65271', '猴子基诺', '1269', '65', '17'), ('65272', '怪物躁狂症', '1006', '65', '17'), ('65273', '月光', '1007', '65', '17'), ('65274', '奥林匹斯山', '1158', '65', '17'), ('65275', '非常大', '1809', '65', '17'), ('65276', '疯狂假面', '1338', '65', '17'), ('65277', '多手大西洋城大酒杯', '1758', '65', '17'), ('65278', '多手大五大酒杯金子', '1842', '65', '17'), ('65279', '多手21点黄金桌', '1762', '65', '17'), ('65280', '多手双重曝光21点', '1751', '65', '17'), ('65281', '多手欧洲21点黄金桌', '1108', '65', '17'), ('65282', '多手完美对子21点黄金桌', '1332', '65', '17'), ('65283', '多手浮舟金', '1787', '65', '17'), ('65284', '多手超级21点黄金桌', '1270', '65', '17'), ('65285', '多手西班牙21点', '1693', '65', '17'), ('65286', '多手西班牙黄金21点', '1827', '65', '17'), ('65287', '多手拉斯维加斯市区21点', '1822', '65', '17'), ('65288', '多手拉斯维加斯市区黄金21点', '1141', '65', '17'), ('65289', '多手拉斯维加斯大道21点', '1843', '65', '17'), ('65290', '多手拉斯维加斯大道黄金21点', '1742', '65', '17'), ('65291', '多手大西洋城黄金21点', '1696', '65', '17'), ('65292', '多轮欧洲轮盘黄金桌', '1832', '65', '17'), ('65293', '复式黄金轮盘', '1090', '65', '17'), ('65294', '孟买魔术', '1353', '65', '17'), ('65295', '怪兽曼琪肯', '1008', '65', '17'), ('65296', '神秘梦境', '1254', '65', '17'), ('65297', '神秘森林', '1371', '65', '17'), ('65298', '忍者法宝', '1315', '65', '17'), ('65299', '章鱼', '1340', '65', '17'), ('65300', '临门一脚', '1078', '65', '17'), ('65301', '东方财富', '1221', '65', '17'), ('65302', '发现天堂', '1334', '65', '17'), ('65303', '派对岛', '1737', '65', '17'), ('65304', '躲猫猫', '1147', '65', '17'), ('65305', '幻影现金', '1251', '65', '17'), ('65306', '法老宾果', '1260', '65', '17'), ('65307', '隔离的宝石', '1355', '65', '17'), ('65308', '小猪财富', '1101', '65', '17'), ('65309', '持枪王者', '1160', '65', '17'), ('65310', '花花公子', '1188', '65', '17'), ('65311', '掠夺之海', '1226', '65', '17'), ('65312', '扑克追求', '1369', '65', '17'), ('65313', '蜜蜂乐园', '1176', '65', '17'), ('65314', '花粉之国', '1881', '65', '17'), ('65315', '浮桥黄金桌', '1820', '65', '17'), ('65316', '超级高低21点黄金桌', '1074', '65', '17'), ('65317', '超级高条纹21点黄金桌', '1392', '65', '17'), ('65318', '多手超级欧式21点黄金桌', '1036', '65', '17'), ('65319', '超级赛马', '1033', '65', '17'), ('65320', '轮盘', '1233', '65', '17'), ('65321', '轮盘钻石版', '1213', '65', '17'), ('65322', '超级马车赛', '1107', '65', '17'), ('65323', '漂亮猫咪', '1045', '65', '17'), ('65324', '优质物业', '1024', '65', '17'), ('65325', '纯铂', '1312', '65', '17'), ('65326', '帽子里的兔子', '1275', '65', '17'), ('65327', '为粉红而战', '1195', '65', '17'), ('65328', '拉美西斯的财富', '1362', '65', '17'), ('65329', '急速转轮', '1278', '65', '17'), ('65330', '红唇诱惑', '1247', '65', '17'), ('65331', '宝石迷阵', '1207', '65', '17'), ('65332', '旋转大战', '1294', '65', '17'), ('65333', '卷行使价', '1157', '65', '17'), ('65334', '雷电击', '1293', '65', '17'), ('65335', '复古旋转', '1110', '65', '17'), ('65336', '复古卷轴-极热', '1189', '65', '17'), ('65337', '复古卷轴钻石耀眼', '1100', '65', '17'), ('65338', '押韵的卷轴-乔治波尔吉', '1782', '65', '17'), ('65339', '押韵的卷轴-心挞', '1009', '65', '17'), ('65340', '押韵的卷轴-老国王科尔', '1268', '65', '17'), ('65341', '海滨财富', '1359', '65', '17'), ('65342', '洛伯杰克', '1132', '65', '17'), ('65343', '摇滚船', '1305', '65', '17'), ('65344', '滚德比', '1146', '65', '17'), ('65345', '罗马财富', '1377', '65', '17'), ('65346', '橄榄球明星', '1287', '65', '17'), ('65347', '萨巴宾果', '1156', '65', '17'), ('65348', '圣诞之掌', '1785', '65', '17'), ('65349', '圣诞老人的疯狂？', '1095', '65', '17'), ('65350', '守财奴', '1030', '65', '17'), ('65351', '秘密崇拜者', '1325', '65', '17'), ('65352', '秘密爱慕者', '1877', '65', '17'), ('65353', '圣诞老人的秘密', '1381', '65', '17'), ('65354', '宁静', '1300', '65', '17'), ('65355', '上海美人', '1421', '65', '17'), ('65356', '射击', '1274', '65', '17'), ('65357', '银芳', '1062', '65', '17'), ('65358', '六位枪手掠夺者黄金版', '1266', '65', '17'), ('65359', '蝎子', '1825', '65', '17'), ('65360', '骷髅陷阱', '1368', '65', '17'), ('65361', '猛撞恐惧', '1196', '65', '17'), ('65362', '潜行医生', '1806', '65', '17'), ('65363', '潜行者英雄', '1821', '65', '17'), ('65364', '怪兽多多', '1001', '65', '17'), ('65365', '糖果多多', '1374', '65', '17'), ('65366', '寿司多多', '1032', '65', '17'), ('65367', '动物足球', '1218', '65', '17');
INSERT INTO `ds_game_type` VALUES ('65368', '太空逃避物', '1231', '65', '17'), ('65369', '太空逃避物黄金版', '1336', '65', '17'), ('65370', '西班牙21点', '1215', '65', '17'), ('65371', '西班牙黄金21点', '1098', '65', '17'), ('65372', '财富之轮', '1031', '65', '17'), ('65373', '法術', '1721', '65', '17'), ('65374', '我推', '1217', '65', '17'), ('65375', '春假', '1002', '65', '17'), ('65376', '星尘', '1404', '65', '17'), ('65377', '星梦之吻', '1167', '65', '17'), ('65378', '星云', '1118', '65', '17'), ('65379', '泰坦之藏匿', '1320', '65', '17'), ('65380', '蒸汽朋克英雄', '1162', '65', '17'), ('65381', '纯银', '1170', '65', '17'), ('65382', '纯银3D', '1317', '65', '17'), ('65383', '夏日假期', '1784', '65', '17'), ('65384', '夏天', '1130', '65', '17'), ('65385', '探索太阳', '1127', '65', '17'), ('65386', '太阳征程', '1150', '65', '17'), ('65387', '跑起来', '1289', '65', '17'), ('65388', '超级奖金宾果', '1088', '65', '17'), ('65389', '超级有趣21点', '1193', '65', '17'), ('65390', '超级有趣黄金21点', '1810', '65', '17'), ('65391', '超级零点', '1029', '65', '17'), ('65392', '必胜', '1711', '65', '17'), ('65393', '动物冲浪', '1039', '65', '17'), ('65394', '甜蜜的收获', '1153', '65', '17'), ('65395', '泰利嗬', '1395', '65', '17'), ('65396', '泰山', '1847', '65', '17'), ('65397', '数万或更好', '1253', '65', '17'), ('65398', '终结者2', '1070', '65', '17'), ('65399', '好日子', '1200', '65', '17'), ('65400', '冒险之旅', '1169', '65', '17'), ('65401', '热力四射', '1883', '65', '17'), ('65402', '失落的阿纳斯塔西娅公主', '1121', '65', '17'), ('65403', '鼠包', '1398', '65', '17'), ('65404', '反转马戏团', '1386', '65', '17'), ('65405', '埃及王座', '1394', '65', '17'), ('65406', '雷神', '1028', '65', '17'), ('65407', '雷神2', '1330', '65', '17'), ('65408', '熊虎之战', '1277', '65', '17'), ('65409', '老虎之眼', '1232', '65', '17'), ('65410', '太阳神之许珀里翁', '1208', '65', '17'), ('65411', '太阳神之忒伊亚', '1385', '65', '17'), ('65412', '古墓丽影', '1122', '65', '17'), ('65413', '古墓丽影2', '1383', '65', '17'), ('65414', '古墓丽影秘密之剑', '1726', '65', '17'), ('65415', '图腾宝藏', '1354', '65', '17'), ('65416', '财宝宫殿', '1020', '65', '17'), ('65417', '三角', '1096', '65', '17'), ('65418', '三魔法', '1131', '65', '17'), ('65419', '三人德州扑克', '1105', '65', '17'), ('65420', '棒棒乌龟', '1161', '65', '17'), ('65421', '扭曲', '1701', '65', '17'), ('65422', '野性的孟加拉虎', '1111', '65', '17'), ('65423', '狂野之鹰', '1357', '65', '17'), ('65424', '大熊猫', '1222', '65', '17'), ('65425', '野性的狼群', '1091', '65', '17'), ('65426', '拉斯維加斯3卡拉姆金', '1699', '65', '17'), ('65427', '拉斯维加斯市区21点', '1801', '65', '17'), ('65428', '拉斯维加斯市区黄金21点', '1716', '65', '17'), ('65429', '拉斯维加斯21点单人桌', '1744', '65', '17'), ('65430', '拉斯维加斯21点单人黄金桌', '1363', '65', '17'), ('65431', '拉斯维加斯21点', '1243', '65', '17'), ('65432', '拉斯维加斯21点黄金桌', '1295', '65', '17'), ('65433', '维多利亚的恶棍', '1271', '65', '17'), ('65434', '乙烯基倒计时', '1306', '65', '17'), ('65435', '瞧！', '1241', '65', '17'), ('65436', '芥末寿司', '1328', '65', '17'), ('65437', '瓜分大奖', '1403', '65', '17'), ('65438', '猫头鹰乐园', '1171', '65', '17'), ('65439', '地球生物', '1388', '65', '17'), ('65440', '财富转轮', '1198', '65', '17'), ('65441', '财富转轮特别版', '1175', '65', '17'), ('65442', '白水牛', '1043', '65', '17'), ('65443', '野生捕鱼', '1152', '65', '17'), ('65444', '野生冠军', '1301', '65', '17'), ('65445', '东方珍兽', '1164', '65', '17'), ('65446', '钱来运转', '1228', '65', '17'), ('65447', '开心点心', '1345', '65', '17'), ('65448', '赢得向导', '1242', '65', '17'), ('65449', '女巫的财富', '1255', '65', '17'), ('65450', '世界杯狂熱', '1829', '65', '17'), ('65451', '燃尼巨蟒', '1382', '65', '17'), ('65473', '最新游戏1026', '1026', '65', '17'), ('65520', '最新游戏1210', '1210', '65', '17'), ('70001', '百家乐', '11', '70', '3'), ('70002', '龙虎', '12', '70', '3'), ('70003', '轮盘', '13', '70', '3'), ('70004', '骰宝', '14', '70', '3'), ('70005', '德州扑克', '15', '70', '3'), ('70006', '番摊', '16', '70', '3'), ('90000', '大厅', '0', '90', '90'), ('90001', '德州扑克', '620', '90', '90'), ('90002', '二八杠', '720', '90', '90'), ('90003', '抢庄牛牛', '830', '90', '90'), ('90004', '炸金花', '220', '90', '90'), ('90005', '三公', '860', '90', '90'), ('90006', '押庄龙虎', '900', '90', '90'), ('90007', '21 点', '600', '90', '90');
INSERT INTO `ds_game_type` VALUES ('90008', '通比牛牛', '870', '90', '90'), ('90009', '欢乐红包', '880', '90', '90'), ('90010', '极速炸金花', '230', '90', '90'), ('90011', '抢庄牌九', '730', '90', '90'), ('90012', '十三水', '630', '90', '90'), ('90013', '幸运五张', '380', '90', '90'), ('90014', '斗地主', '610', '90', '90'), ('95001', '百家乐 01', '1', '95', '19'), ('95002', '百家乐 02', '2', '95', '19'), ('95003', '百家乐 03', '3', '95', '19'), ('95004', '百家乐 04', '4', '95', '19'), ('95005', '百家乐 05', '5', '95', '19'), ('95006', '百家乐 06', '6', '95', '19'), ('95007', '星级百家乐 01', '51', '95', '19'), ('95008', '星级百家乐 02', '52', '95', '19'), ('95009', '星级百家乐 03', '53', '95', '19'), ('95010', '星级百家乐 04', '54', '95', '19'), ('95011', '星级百家乐 05', '55', '95', '19'), ('95012', '星级百家乐 06', '56', '95', '19'), ('95013', '龙虎', '35', '95', '19'), ('95014', '骰宝', '20', '95', '19'), ('95015', '轮盘', '38', '95', '19'), ('95016', '斗牛', '42', '95', '19'), ('95017', '三公', '30', '95', '19'), ('95018', '雀九', '25', '95', '19'), ('95019', '申博真人娱乐馆', 'sunbetlobby', '95', '19'), ('95020', '自选多合一', '82', '95', '19'), ('95021', '咪牌百家乐', '91', '95', '19'), ('96001', '功夫神话', 'WildFight', '96', '19'), ('96002', '凤凰涅槃', 'RedPhoenixRising', '96', '19'), ('96003', '斯巴达勇士', 'WildSpartans', '96', '19'), ('96004', '华夏祥瑞', 'ChineseTreasures', '96', '19'), ('96005', '恭贺新禧', 'FortuneFest', '96', '19'), ('96006', '珠光宝器', 'JadeCharms', '96', '19'), ('96007', '深海宝藏', 'OceanFortune', '96', '19'), ('96008', '财神', 'GodOfWealth', '96', '19'), ('96009', '圣兽传奇', 'DivineWays', '96', '19'), ('96010', '铃儿响叮当', 'JingleBells', '96', '19'), ('96011', '金莲呈祥', 'GoldenLotus', '96', '19'), ('96012', '五福临门', 'MagicGate', '96', '19'), ('96013', '西游寻宝', 'EpicJourney', '96', '19'), ('96014', '幸运魔法师', 'LuckyWizard', '96', '19'), ('96015', '精灵童话', 'WinterWonders', '96', '19'), ('96016', '神灯之谜', 'GoldenLamps', '96', '19'), ('96017', '麒麟送宝', 'GoldenOffer', '96', '19'), ('96018', '蓝钻风暴', 'BlueDiamond', '96', '19'), ('96019', '幸运五星', 'FiveStar', '96', '19'), ('96020', '翡翠王', 'MegaJade', '96', '19'), ('96021', '三国争霸', 'ThreeKingdoms', '96', '19'), ('96022', '富贵金蟾', 'GoldenToad', '96', '19'), ('96023', '靴猫剑客', 'PussNBoots', '96', '19'), ('96024', '摇滚星', 'GoldStar', '96', '19'), ('96025', '宝石暴走', 'GemsGoneWild', '96', '19'), ('96026', '寻找法老', 'AncientScript', '96', '19'), ('96027', '金殿丽影', 'TempleOfGold', '96', '19'), ('96028', '百家乐', 'PuntoBanco', '96', '19'), ('96029', '彩虹的祝福', 'RainbowJackpots', '96', '19'), ('96030', '财富满屋', 'FortuneHouse', '96', '19'), ('96031', '幸运万圣节', 'LuckyHalloween', '96', '19'), ('96032', '梦想好声音', 'Stage888', '96', '19'), ('96033', '珍兽秘境', 'ChineseWilds', '96', '19'), ('96034', '波斯宝藏', 'PersianFortune', '96', '19'), ('96035', '狂野西部诱惑', 'WildWildChest', '96', '19'), ('96036', '招财猫', 'LuckyFortuneCat', '96', '19'), ('96037', '甄妃传奇', 'ImperialPalace', '96', '19'), ('96038', '甜蜜情人节', 'LuckyValentine', '96', '19'), ('96039', '水果大爆炸', 'ArcadeBomb', '96', '19'), ('96040', '魔箭精灵', 'ElvenMagic', '96', '19'), ('96041', '金象探宝', 'ElephantTreasure', '96', '19'), ('96042', '雄狮纳财', 'LionDance', '96', '19'), ('96043', '幸运大转盘', 'GrandWheel', '96', '19'), ('96044', '兔子的彩蛋', 'LuckyEaster', '96', '19'), ('96045', '妖神传说', 'TenElements', '96', '19'), ('96046', '图腾的秘密', 'TotemLightning', '96', '19'), ('96047', '灰姑娘', 'Cinderella', '96', '19'), ('96048', '三剑客', 'ThreeMusketeers', '96', '19'), ('96049', '轮盘赌', 'EuropeanRoulette', '96', '19'), ('96050', '拉神的恩赐', 'RasLegend', '96', '19'), ('96051', '赤壁', '1', '96', '19'), ('96052', '中国美人', '613', '96', '19'), ('96053', '招财进宝', '623', '96', '19'), ('96054', '英雄', '218', '96', '19'), ('96055', '楚汉春秋', '619', '96', '19'), ('96056', '貂蝉', '5', '96', '19'), ('96057', '封神哪吒', '612', '96', '19'), ('96058', '金瓶梅', '215', '96', '19'), ('96059', '大三元', '626', '96', '19'), ('96060', '西游记', '611', '96', '19'), ('96061', '运财熊猫北京', '627', '96', '19'), ('96062', '运财熊猫澳门', '624', '96', '19'), ('96063', '运财熊猫上海', '622', '96', '19'), ('96064', '魔幻宝石', '620', '96', '19'), ('96065', '魔幻宝石II', '625', '96', '19'), ('96066', '花木兰', '616', '96', '19'), ('96067', '扑克王', '604', '96', '19'), ('96068', '赵云救主', '614', '96', '19'), ('96069', '肉蒲团', '621', '96', '19'), ('96070', '桃园结义', '203', '96', '19'), ('96071', '百乐门', '628', '96', '19'), ('96072', '今晚打老虎', '629', '96', '19');
INSERT INTO `ds_game_type` VALUES ('96073', '飞龙舞凤', '630', '96', '19'), ('96074', '大四喜', '203001031', '96', '19'), ('96075', '世界杯', '203001032', '96', '19'), ('96076', '剑魂诀', '203001033', '96', '19'), ('96077', '斗转星移', '203001034', '96', '19'), ('96078', '鲤跃龙门', '203001035', '96', '19'), ('96079', '天降财神', '203001039', '96', '19'), ('96080', '赌城大亨', '203001040', '96', '19'), ('96081', '环游世界', '203001038', '96', '19'), ('96082', '红孩儿', '203001037', '96', '19'), ('96083', '祥狮献瑞', '203001041', '96', '19'), ('96084', '火焰山', '203001043', '96', '19'), ('96085', '聚宝盆', '203001044', '96', '19'), ('96086', '金龙戏珠', '203001047', '96', '19'), ('96087', '混战叁张', '1011', '96', '19'), ('96088', '鱼虾蟹', '1009', '96', '19'), ('96089', '极速撲克', '1010', '96', '19'), ('96090', '百家乐', '1012', '96', '19'), ('96091', '龙七百家乐', '1013', '96', '19'), ('96092', '甩牌百家乐', '1016', '96', '19'), ('96093', '搓牌百家乐', '1017', '96', '19'), ('96094', '富贵叁宝', '1015', '96', '19'), ('96095', '多门傑克高手', '1004', '96', '19'), ('96096', '单门傑克高手', '1008', '96', '19'), ('96097', '拉斯维加斯21点', '1018', '96', '19'), ('96098', '免佣百家乐', '204001019', '96', '19'), ('96099', '轮盘', '204001020', '96', '19'), ('96100', '发发发', '204001021', '96', '19'), ('96101', '捕鱼王', '75608', '96', '19'), ('96102', '红钻风暴', 'RedDiamond', '96', '19'), ('96103', '淘气的神灯', 'CrazyGenie', '96', '19'), ('96104', '神秘水果', 'MysteryFruit', '96', '19'), ('96105', '矿洞奇遇', 'TreasureMine', '96', '19'), ('96106', '澳门赛车', 'MacauRacing', '96', '19'), ('96107', '火辣辣', 'RedHotSlot', '96', '19'), ('96108', '假面舞会', 'Masquerade', '96', '19'), ('96109', '追击劫匪', 'ReelHeist', '96', '19'), ('96110', '诺德英雄传', 'WildNords', '96', '19'), ('96111', '白雪派对', 'SnowWildAndThe7Features', '96', '19'), ('96112', '绿钻风暴', 'EmeraldDiamond', '96', '19'), ('96113', '点石成金', 'MidasGold', '96', '19'), ('96114', '火箭对决', 'RocketMen', '96', '19'), ('96115', '狂欢亡灵节', 'EsqueletoMariachi', '96', '19'), ('96116', '镭射水果', 'LaserFruit', '96', '19'), ('96117', '龙之谕', 'DragonsLuck', '96', '19'), ('504051', '最新游戏190', '190', '60', '15'), ('504627', '最新游戏71523', '71523', '60', '15');
COMMIT;

-- ----------------------------
-- Table structure for `ds_guangfang_lottery`
-- ----------------------------
DROP TABLE IF EXISTS `ds_guangfang_lottery`;
CREATE TABLE `ds_guangfang_lottery` (
`tid`  bigint(20) NOT NULL AUTO_INCREMENT ,
`id`  bigint(20) NULL DEFAULT NULL COMMENT '注单拉取id' ,
`siteid`  int(11) NULL DEFAULT NULL ,
`nid`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注单号' ,
`lid`  int(11) NULL DEFAULT NULL COMMENT '彩种id' ,
`uid`  int(11) NULL DEFAULT NULL COMMENT '用户ID' ,
`user_name`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名' ,
`top1`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代理用户名' ,
`top2`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '总代理用户名' ,
`top3`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '股东用户名' ,
`top4`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分公司用户名' ,
`proportion1`  int(11) NULL DEFAULT NULL COMMENT '代理占成' ,
`proportion2`  int(11) NULL DEFAULT NULL COMMENT '总代理占成' ,
`proportion3`  int(11) NULL DEFAULT NULL COMMENT '股东占成' ,
`proportion4`  int(11) NULL DEFAULT NULL COMMENT '分公司占成' ,
`proportion5`  int(11) NULL DEFAULT NULL COMMENT '总公司占成' ,
`pan`  char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盘口' ,
`issue`  bigint(20) NULL DEFAULT NULL COMMENT '期数' ,
`mg_id`  bigint(20) NULL DEFAULT NULL COMMENT '玩法组ID' ,
`trace_id`  bigint(20) NULL DEFAULT NULL COMMENT '追号ID' ,
`single_num`  int(11) NULL DEFAULT NULL COMMENT '总单倍注数' ,
`multiple`  int(11) NULL DEFAULT NULL COMMENT '倍投' ,
`modes`  decimal(20,5) NULL DEFAULT NULL COMMENT '模式' ,
`odd`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '赔率' ,
`amount`  decimal(13,5) NULL DEFAULT NULL COMMENT '订单总金额(倍投*注数*模式)元' ,
`amount1`  decimal(13,5) NULL DEFAULT NULL COMMENT '代理占成金额' ,
`amount2`  decimal(13,5) NULL DEFAULT NULL COMMENT '总代占成金额' ,
`amount3`  decimal(13,5) NULL DEFAULT NULL COMMENT '股东占成金额' ,
`amount4`  decimal(13,5) NULL DEFAULT NULL COMMENT '分公司占成金额' ,
`amount5`  decimal(13,5) NULL DEFAULT NULL COMMENT '总公司占成金额' ,
`wins`  decimal(15,5) NULL DEFAULT NULL COMMENT '会员输赢' ,
`win1`  decimal(15,5) NULL DEFAULT NULL COMMENT '代理实占输赢' ,
`win2`  decimal(15,5) NULL DEFAULT NULL COMMENT '总代实占输赢' ,
`win3`  decimal(15,5) NULL DEFAULT NULL COMMENT '股东实占输赢' ,
`win4`  decimal(15,5) NULL DEFAULT NULL COMMENT '分公司实占输赢' ,
`win5`  decimal(15,5) NULL DEFAULT NULL COMMENT '总公司实占输赢' ,
`hit_detail`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '中奖详情' ,
`proxy_ip`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代理服务器IP' ,
`u_ip`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户IP' ,
`server_ip`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务器IP' ,
`hash_value`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注单校验' ,
`code`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '下注内容' ,
`update_time`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新时间' ,
`draw_time`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开奖时间' ,
`send_prize_time`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '派彩时间' ,
`add_time`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注时间' ,
`jiesuan_time`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结算时间' ,
`cancel_time`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '撤单时间' ,
`is_take`  int(11) NULL DEFAULT NULL COMMENT '扣钱(0未扣钱 1已扣钱)' ,
`is_cancel`  int(11) NULL DEFAULT NULL COMMENT '撤单状态(0未撤单 1用户撤单 2追中撤单 3出号撤单 4未开撤单 5结算前检查撤销  9管理员撤单)' ,
`is_jiesuan`  int(11) NULL DEFAULT NULL COMMENT '中奖状态(0未判断 1中奖 2未中奖)' ,
`is_pay`  int(11) NULL DEFAULT NULL COMMENT '派彩状态(0未派彩 1已派彩)' ,
`cancel_admin_id`  int(11) NULL DEFAULT NULL COMMENT '撤单者ID' ,
`bet_time`  datetime NULL DEFAULT NULL ,
`win_lose_type`  tinyint(4) NULL DEFAULT NULL ,
`report_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`tid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='官方彩'
AUTO_INCREMENT=4009527

;

-- ----------------------------
-- Records of ds_guangfang_lottery
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_ip_game`
-- ----------------------------
DROP TABLE IF EXISTS `ds_ip_game`;
CREATE TABLE `ds_ip_game` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of ds_ip_game
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_jingdian_lottery`
-- ----------------------------
DROP TABLE IF EXISTS `ds_jingdian_lottery`;
CREATE TABLE `ds_jingdian_lottery` (
`tid`  bigint(20) NOT NULL AUTO_INCREMENT ,
`id`  bigint(20) NOT NULL ,
`siteid`  int(11) NOT NULL ,
`nid`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`lid`  tinyint(4) NOT NULL ,
`user`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_type`  tinyint(4) NOT NULL ,
`user1`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user2`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user3`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user4`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pan`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`qishu`  bigint(20) NOT NULL ,
`pid`  tinyint(4) NULL DEFAULT NULL ,
`oid`  smallint(6) NULL DEFAULT NULL ,
`project`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`itmes`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`content`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`odds`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`jiner`  int(11) NOT NULL ,
`jiner1`  decimal(13,5) NOT NULL ,
`jiner2`  decimal(13,2) NOT NULL ,
`jiner3`  decimal(13,2) NOT NULL ,
`jiner4`  decimal(13,2) NOT NULL ,
`jiner5`  decimal(13,2) NOT NULL ,
`jinerb`  decimal(13,2) NOT NULL ,
`share1`  tinyint(4) NOT NULL ,
`share2`  tinyint(4) NOT NULL ,
`share3`  tinyint(4) NOT NULL ,
`share4`  tinyint(4) NOT NULL ,
`share5`  tinyint(4) NOT NULL ,
`win_dream`  decimal(13,2) NOT NULL ,
`win`  decimal(13,2) NOT NULL ,
`win1`  decimal(13,2) NOT NULL ,
`win2`  decimal(13,2) NOT NULL ,
`win3`  decimal(13,2) NOT NULL ,
`win4`  decimal(13,2) NOT NULL ,
`win5`  decimal(13,2) NOT NULL ,
`bonus`  decimal(4,1) NOT NULL ,
`bonus1`  decimal(4,1) NOT NULL ,
`bonus2`  decimal(4,1) NOT NULL ,
`bonus3`  decimal(4,1) NOT NULL ,
`bonus4`  decimal(4,1) NOT NULL ,
`bonus5`  decimal(4,1) NOT NULL ,
`tuishui`  decimal(13,2) NOT NULL ,
`tuishui1`  decimal(13,2) NOT NULL ,
`tuishui2`  decimal(13,2) NOT NULL ,
`tuishui3`  decimal(13,2) NOT NULL ,
`tuishui4`  decimal(13,2) NOT NULL ,
`tuishui5`  decimal(13,2) NOT NULL ,
`ip`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hash`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`stataus`  tinyint(4) NOT NULL ,
`time_draw`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_in`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_add`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`time_jiesuan`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_pay`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_cancel`  bit(1) NOT NULL ,
`cancel_content`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_time`  timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ,
`win_lose_type`  tinyint(4) NOT NULL ,
`report_time`  timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ,
PRIMARY KEY (`tid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='经典彩'
AUTO_INCREMENT=1490531947

;

-- ----------------------------
-- Records of ds_jingdian_lottery
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_jingdian_lottery_99999`
-- ----------------------------
DROP TABLE IF EXISTS `ds_jingdian_lottery_99999`;
CREATE TABLE `ds_jingdian_lottery_99999` (
`tid`  bigint(20) NOT NULL AUTO_INCREMENT ,
`id`  bigint(20) NOT NULL ,
`game_kind`  int(11) NOT NULL ,
`nid`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`lid`  tinyint(4) NOT NULL ,
`user`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_type`  tinyint(4) NOT NULL ,
`user1`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user2`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user3`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user4`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`pan`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`qishu`  bigint(20) NOT NULL ,
`pid`  tinyint(4) NULL DEFAULT NULL ,
`oid`  smallint(6) NULL DEFAULT NULL ,
`project`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`itmes`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`content`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`odds`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`jiner`  int(11) NOT NULL ,
`jiner1`  decimal(13,5) NOT NULL ,
`jiner2`  decimal(13,2) NOT NULL ,
`jiner3`  decimal(13,2) NOT NULL ,
`jiner4`  decimal(13,2) NOT NULL ,
`jiner5`  decimal(13,2) NOT NULL ,
`jinerb`  decimal(13,2) NOT NULL ,
`share1`  tinyint(4) NOT NULL ,
`share2`  tinyint(4) NOT NULL ,
`share3`  tinyint(4) NOT NULL ,
`share4`  tinyint(4) NOT NULL ,
`share5`  tinyint(4) NOT NULL ,
`win_dream`  decimal(13,2) NOT NULL ,
`win`  decimal(13,2) NOT NULL ,
`win1`  decimal(13,2) NOT NULL ,
`win2`  decimal(13,2) NOT NULL ,
`win3`  decimal(13,2) NOT NULL ,
`win4`  decimal(13,2) NOT NULL ,
`win5`  decimal(13,2) NOT NULL ,
`bonus`  decimal(4,1) NOT NULL ,
`bonus1`  decimal(4,1) NOT NULL ,
`bonus2`  decimal(4,1) NOT NULL ,
`bonus3`  decimal(4,1) NOT NULL ,
`bonus4`  decimal(4,1) NOT NULL ,
`bonus5`  decimal(4,1) NOT NULL ,
`tuishui`  decimal(13,2) NOT NULL ,
`tuishui1`  decimal(13,2) NOT NULL ,
`tuishui2`  decimal(13,2) NOT NULL ,
`tuishui3`  decimal(13,2) NOT NULL ,
`tuishui4`  decimal(13,2) NOT NULL ,
`tuishui5`  decimal(13,2) NOT NULL ,
`ip`  varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hash`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`stataus`  tinyint(4) NOT NULL ,
`time_draw`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_in`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_add`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`time_jiesuan`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_pay`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_cancel`  bit(1) NOT NULL ,
`cancel_content`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_time`  timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ,
`win_lose_type`  tinyint(4) NOT NULL ,
`report_time`  timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ,
PRIMARY KEY (`tid`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='经典彩siteId分表'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_jingdian_lottery_99999
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_jpgame`
-- ----------------------------
DROP TABLE IF EXISTS `ds_jpgame`;
CREATE TABLE `ds_jpgame` (
`id`  bigint(11) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`wagersid`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注单号码' ,
`jptypeid`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '奖项' ,
`playname`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帐号' ,
`wagersdate`  datetime NULL DEFAULT NULL COMMENT '下注时间' ,
`jpamount`  decimal(18,2) NULL DEFAULT NULL COMMENT '中奖金额' ,
`agents`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`world`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`corprator`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`superior`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`admin`  varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`live_id`  int(4) NULL DEFAULT NULL ,
`live_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_jpgame
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_ky_chess`
-- ----------------------------
DROP TABLE IF EXISTS `ds_ky_chess`;
CREATE TABLE `ds_ky_chess` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '站点id' ,
`game_id`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '游戏局号' ,
`account`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家帐号' ,
`server_id`  int(11) NULL DEFAULT NULL COMMENT '房间ID' ,
`kind_id`  int(11) NULL DEFAULT NULL COMMENT '游戏ID' ,
`table_id`  int(11) NULL DEFAULT NULL COMMENT '桌子号' ,
`chair_id`  int(11) NULL DEFAULT NULL COMMENT '椅子号' ,
`user_count`  int(11) NULL DEFAULT NULL COMMENT '玩家数量' ,
`card_value`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手牌公共牌' ,
`cell_score`  decimal(20,5) NULL DEFAULT NULL COMMENT '有效下注' ,
`all_bet`  decimal(20,5) NULL DEFAULT NULL COMMENT '总下注' ,
`profit`  decimal(20,5) NULL DEFAULT NULL COMMENT '盈利' ,
`revenue`  decimal(20,5) NULL DEFAULT NULL COMMENT '抽水' ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL COMMENT '输赢类型，1：输，2：赢，3：和' ,
`game_start_time`  datetime NULL DEFAULT NULL COMMENT '游戏开始时间' ,
`game_end_time`  datetime NULL DEFAULT NULL COMMENT '游戏结束时间' ,
`channel_id`  int(11) NULL DEFAULT NULL COMMENT '渠道ID' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='开元棋牌注单表'
AUTO_INCREMENT=1073

;

-- ----------------------------
-- Records of ds_ky_chess
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_ky_record_time`
-- ----------------------------
DROP TABLE IF EXISTS `ds_ky_record_time`;
CREATE TABLE `ds_ky_record_time` (
`agent`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`last_get_record_time`  datetime NULL DEFAULT NULL ,
`last_update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`agent`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='ky注单拉取时间记录表'

;

-- ----------------------------
-- Records of ds_ky_record_time
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_live`
-- ----------------------------
DROP TABLE IF EXISTS `ds_live`;
CREATE TABLE `ds_live` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`billno`  bigint(20) NULL DEFAULT NULL ,
`billno_modify_id`  bigint(20) NULL DEFAULT NULL ,
`username`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`site_id`  int(11) NULL DEFAULT NULL ,
`currency`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`table_info_id`  int(11) NULL DEFAULT NULL ,
`show_info_id`  int(11) NULL DEFAULT NULL ,
`table_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_info_id`  int(11) NULL DEFAULT NULL ,
`banker_result`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result_list`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`poker_list`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`stake_amount`  decimal(18,2) NULL DEFAULT NULL ,
`valid_stake`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`comm`  decimal(18,2) NULL DEFAULT NULL ,
`balance_after`  decimal(18,2) NULL DEFAULT NULL ,
`end_time`  datetime NULL DEFAULT NULL ,
`adjustment_time`  datetime NULL DEFAULT NULL ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`live_member_report_details`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`result_img_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flag`  tinyint(4) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`sequence_no`  bigint(20) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='DS视讯表'
AUTO_INCREMENT=124659

;

-- ----------------------------
-- Records of ds_live
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_live_tips`
-- ----------------------------
DROP TABLE IF EXISTS `ds_live_tips`;
CREATE TABLE `ds_live_tips` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`site_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`user_pre`  varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`player_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`outer_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`agent_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`transfer_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`trade_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`platform_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`platform_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`transfer_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`transfer_amount`  decimal(18,2) NULL DEFAULT NULL ,
`previous_amount`  decimal(18,2) NULL DEFAULT NULL ,
`current_amount`  decimal(18,2) NULL DEFAULT NULL ,
`currency`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`exchange_rate`  decimal(18,2) NULL DEFAULT NULL ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flag`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`creation_time`  datetime NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ds_live_type`  int(11) NULL DEFAULT NULL ,
`ds_live_type_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=7129755

;

-- ----------------------------
-- Records of ds_live_tips
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_live_type`
-- ----------------------------
DROP TABLE IF EXISTS `ds_live_type`;
CREATE TABLE `ds_live_type` (
`id`  tinyint(4) NOT NULL COMMENT '主键' ,
`live_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='2:AG视讯厅  3:OG视讯厅 11:BBIN视讯厅 12:DS视讯厅'

;

-- ----------------------------
-- Records of ds_live_type
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lmg_live`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lmg_live`;
CREATE TABLE `ds_lmg_live` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`billno`  bigint(20) NULL DEFAULT NULL ,
`billno_modify_id`  bigint(20) NULL DEFAULT NULL ,
`username`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`site_id`  int(11) NULL DEFAULT NULL ,
`currency`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`table_info_id`  int(11) NULL DEFAULT NULL ,
`show_info_id`  int(11) NULL DEFAULT NULL ,
`table_name`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_info_id`  int(11) NULL DEFAULT NULL ,
`banker_result`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`result_list`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`poker_list`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`stake_amount`  decimal(18,2) NULL DEFAULT NULL ,
`valid_stake`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss`  decimal(18,2) NULL DEFAULT NULL ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL ,
`comm`  decimal(18,2) NULL DEFAULT NULL ,
`balance_after`  decimal(18,2) NULL DEFAULT NULL ,
`end_time`  datetime NULL DEFAULT NULL ,
`adjustment_time`  datetime NULL DEFAULT NULL ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`live_member_report_details`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`result_img_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flag`  tinyint(4) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`sequence_no`  bigint(20) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='LMG视讯表'
AUTO_INCREMENT=46

;

-- ----------------------------
-- Records of ds_lmg_live
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lottery_bet`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lottery_bet`;
CREATE TABLE `ds_lottery_bet` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`billno`  bigint(20) NULL DEFAULT NULL COMMENT '游戏平台记录 begin_id' ,
`site_id`  int(25) NULL DEFAULT NULL COMMENT '网站编号' ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`tray`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏盘口类型: A,B,C' ,
`bet_time`  datetime NULL DEFAULT NULL COMMENT '下注时间' ,
`bet_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注code唯一值' ,
`lottery_game_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_info_id`  int(11) NULL DEFAULT NULL COMMENT '游戏类型 1:广东快乐十分 2:重庆时时彩3:北京赛车 4:江苏骰宝 5:幸运农场' ,
`game_no`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期号' ,
`bet_on`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注类型' ,
`bet_type`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注类型详细' ,
`odds`  double(8,3) NULL DEFAULT NULL COMMENT '赔率' ,
`bet_detail`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注明细' ,
`stake_amount`  double(18,2) NULL DEFAULT NULL COMMENT '下注额' ,
`valid_stake`  double(18,2) NULL DEFAULT NULL COMMENT '有效下注额' ,
`win_loss`  double(18,2) NULL DEFAULT NULL COMMENT '输赢' ,
`win_loss_type`  tinyint(3) NULL DEFAULT NULL COMMENT '输赢类型' ,
`ip`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户下注时的ip' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '修改时间' ,
`sequence_no`  bigint(20) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_lottery_bet
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lottery_bet_on`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lottery_bet_on`;
CREATE TABLE `ds_lottery_bet_on` (
`id`  int(11) NOT NULL DEFAULT 0 ,
`game_info_id`  int(11) NULL DEFAULT NULL ,
`bet_on`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_on_explain`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of ds_lottery_bet_on
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lottery_bet_type`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lottery_bet_type`;
CREATE TABLE `ds_lottery_bet_type` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`game_info_id`  int(11) NULL DEFAULT NULL ,
`bet_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_type_explain`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_lottery_bet_type
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lottery_config`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lottery_config`;
CREATE TABLE `ds_lottery_config` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`lottery_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`lottery_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_lottery_config
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lotto_bet`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lotto_bet`;
CREATE TABLE `ds_lotto_bet` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`billno`  bigint(20) NULL DEFAULT NULL COMMENT '游戏平台记录 begin_id' ,
`site_id`  int(8) NULL DEFAULT NULL COMMENT '网站 id' ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`tray`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏盘口类型  A,B,C,D' ,
`bet_time`  datetime NULL DEFAULT NULL COMMENT '下注时间' ,
`bet_id`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注时唯一 code' ,
`game_no`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期数' ,
`bet_on_id`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注类型 id' ,
`bet_type_id`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注类型详细 id' ,
`bet_details_id`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注类型详细' ,
`odds`  double(8,3) NULL DEFAULT NULL COMMENT '赔率' ,
`stake_amount`  double(18,2) NULL DEFAULT NULL COMMENT '下注额' ,
`valid_stake`  double(18,2) NULL DEFAULT NULL COMMENT '有效下注额' ,
`win_loss`  double(18,2) NULL DEFAULT NULL COMMENT '输赢' ,
`odds2`  double(8,3) NULL DEFAULT NULL COMMENT '赔率2 针对三中二中三，二中特中特' ,
`win_loss_type`  tinyint(5) NULL DEFAULT NULL COMMENT '输赢类型' ,
`ip`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP 限制' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '修改时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_lotto_bet
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lotto_bet_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lotto_bet_detail`;
CREATE TABLE `ds_lotto_bet_detail` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`bet_detail_id`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_detail_id_expain`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_lotto_bet_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lotto_bet_on`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lotto_bet_on`;
CREATE TABLE `ds_lotto_bet_on` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`bet_on_id`  int(11) NULL DEFAULT NULL ,
`bet_on_id_expain`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_lotto_bet_on
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_lotto_bet_type`
-- ----------------------------
DROP TABLE IF EXISTS `ds_lotto_bet_type`;
CREATE TABLE `ds_lotto_bet_type` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`bet_type_id`  int(11) NULL DEFAULT NULL ,
`bet_type_id_expain`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_lotto_bet_type
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_m8_sport`
-- ----------------------------
DROP TABLE IF EXISTS `ds_m8_sport`;
CREATE TABLE `ds_m8_sport` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`fetch_id`  bigint(20) NULL DEFAULT NULL ,
`bet_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`site_id`  int(11) NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`win_amount`  decimal(18,2) NULL DEFAULT NULL ,
`commission_amount`  decimal(18,2) NULL DEFAULT NULL ,
`commission`  decimal(18,2) NULL DEFAULT NULL COMMENT 'Commission % (value = 0.4 means 0.4%)' ,
`win_lose_type`  int(11) NULL DEFAULT NULL ,
`result`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'P:NotMatchOver WA:WinAll LA:LostAll WH:WinHalf LH:LostHalf D:Draw（和局）' ,
`last_modify_time`  datetime NULL DEFAULT NULL ,
`league`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`home`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`away`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`status`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`odds`  decimal(18,3) NULL DEFAULT NULL ,
`side`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`info`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`half`  tinyint(4) NULL DEFAULT NULL COMMENT '// 0:Full Time, 1:First Half' ,
`transaction_date`  datetime NULL DEFAULT NULL ,
`workdate`  datetime NULL DEFAULT NULL ,
`matchdate`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`runscore`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`score`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`htscore`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`first_last_goal`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sportstype`  int(11) NULL DEFAULT NULL ,
`ip`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`league_name`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`home_name`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`away_name`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flag`  tinyint(5) NULL DEFAULT 0 COMMENT '标示有没有统计到 ds_report 记录中' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='H8体育'
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of ds_m8_sport
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_member`
-- ----------------------------
DROP TABLE IF EXISTS `ds_member`;
CREATE TABLE `ds_member` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '网站名称' ,
`site_name`  varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外接代理名称' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`agents`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`world`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`corprator`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`superior`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`company`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`comm_agent`  decimal(18,2) NULL DEFAULT NULL ,
`comm_world`  decimal(18,2) NULL DEFAULT NULL ,
`comm_corprator`  decimal(18,2) NULL DEFAULT NULL ,
`comm_superior`  decimal(18,2) NULL DEFAULT NULL ,
`comm_branch`  decimal(18,2) NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='会员代理信息'
AUTO_INCREMENT=1953265

;

-- ----------------------------
-- Records of ds_member
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_mg_game`
-- ----------------------------
DROP TABLE IF EXISTS `ds_mg_game`;
CREATE TABLE `ds_mg_game` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`siteId`  int(11) NULL DEFAULT NULL ,
`username`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`playername`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hor_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_col_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`win_col_ids`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`win_lose_type`  int(11) NULL DEFAULT NULL ,
`hor_ne_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mbr_ne_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_trans_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_key`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`transaction_timestamp`  bigint(20) NULL DEFAULT NULL ,
`transaction_timestamp_date`  datetime NULL DEFAULT NULL ,
`amount`  decimal(20,5) NULL DEFAULT NULL ,
`validate_amount`  decimal(20,5) NULL DEFAULT NULL ,
`payoff`  decimal(20,5) NULL DEFAULT NULL ,
`mbr_code`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mbr_alias`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_casino_id`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`game_poker_id`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`game_poker_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ref_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ref_key`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`after_tx_wallet_amount`  decimal(20,5) NULL DEFAULT NULL ,
`mgs_game_id`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mgs_action_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`clrng_amnt`  decimal(20,5) NULL DEFAULT NULL ,
`game_platform_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`last_update_time`  datetime NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='MG电子'
AUTO_INCREMENT=31983

;

-- ----------------------------
-- Records of ds_mg_game
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_mg_game_config`
-- ----------------------------
DROP TABLE IF EXISTS `ds_mg_game_config`;
CREATE TABLE `ds_mg_game_config` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`agent_id`  bigint(20) NULL DEFAULT NULL ,
`agent_code`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`agent_pre`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`p_usm`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`p_pwd`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='MG电子配置'
AUTO_INCREMENT=8

;

-- ----------------------------
-- Records of ds_mg_game_config
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_mg_game_detail`
-- ----------------------------
DROP TABLE IF EXISTS `ds_mg_game_detail`;
CREATE TABLE `ds_mg_game_detail` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`siteId`  int(11) NULL DEFAULT NULL ,
`username`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`playername`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`hor_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_col_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`win_col_ids`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`win_lose_type`  int(11) NULL DEFAULT NULL ,
`hor_ne_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mbr_ne_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_trans_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_key`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_code`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`transaction_timestamp`  bigint(20) NULL DEFAULT NULL ,
`transaction_timestamp_date`  datetime NULL DEFAULT NULL ,
`amount`  decimal(20,5) NULL DEFAULT NULL ,
`validate_amount`  decimal(20,5) NULL DEFAULT NULL ,
`payoff`  decimal(20,5) NULL DEFAULT NULL ,
`mbr_code`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mbr_alias`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_casino_id`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`game_poker_id`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`game_poker_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ref_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ref_key`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`after_tx_wallet_amount`  decimal(20,5) NULL DEFAULT NULL ,
`mgs_game_id`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`mgs_action_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`clrng_amnt`  decimal(20,5) NULL DEFAULT NULL ,
`game_platform_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`last_update_time`  datetime NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=40671

;

-- ----------------------------
-- Records of ds_mg_game_detail
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_mg_record_time`
-- ----------------------------
DROP TABLE IF EXISTS `ds_mg_record_time`;
CREATE TABLE `ds_mg_record_time` (
`agent`  varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`last_get_record_time`  datetime NULL DEFAULT NULL ,
`last_update_time`  datetime NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`agent`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of ds_mg_record_time
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_og_live`
-- ----------------------------
DROP TABLE IF EXISTS `ds_og_live`;
CREATE TABLE `ds_og_live` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`product_id`  bigint(20) NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`play_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`betting_amount`  decimal(18,5) NULL DEFAULT NULL ,
`valid_amount`  decimal(18,5) NULL DEFAULT NULL ,
`win_lose_amount`  decimal(18,5) NULL DEFAULT NULL ,
`win_lose_type`  int(11) NULL DEFAULT NULL ,
`game_record_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`order_number`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`table_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`stage`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`inning`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_name_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_betting_kind`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_betting_content`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL ,
`result_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`compensate_rate`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`balance`  decimal(18,5) NULL DEFAULT NULL ,
`add_time`  datetime NULL DEFAULT NULL ,
`platform_id`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`vendor_id`  bigint(20) NULL DEFAULT NULL ,
`game_result`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`memo`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='OG视讯'
AUTO_INCREMENT=2501693

;

-- ----------------------------
-- Records of ds_og_live
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_report`
-- ----------------------------
DROP TABLE IF EXISTS `ds_report`;
CREATE TABLE `ds_report` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`bet_count`  int(11) NULL DEFAULT NULL ,
`betamount`  decimal(18,2) NULL DEFAULT NULL COMMENT '下注金额' ,
`winlose`  decimal(18,2) NULL DEFAULT NULL COMMENT '派彩金额' ,
`validamount`  decimal(18,2) NULL DEFAULT NULL COMMENT '有效下注金额' ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '网站名' ,
`live_id`  tinyint(4) NULL DEFAULT NULL COMMENT '视讯id' ,
`live_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视讯名称' ,
`game_kind`  int(11) NULL DEFAULT NULL ,
`game_kind_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`game_type`  int(11) NULL DEFAULT NULL ,
`game_name`  varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_time`  date NULL DEFAULT NULL COMMENT '下注时间  以天为单位统计' ,
`jiesuan_time`  date NULL DEFAULT NULL ,
`agents`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代理' ,
`world`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '总代' ,
`corprator`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '股东' ,
`superior`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '大股东' ,
`company`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`comm_agent`  decimal(18,2) NULL DEFAULT NULL ,
`comm_world`  decimal(18,2) NULL DEFAULT NULL ,
`comm_corprator`  decimal(18,2) NULL DEFAULT NULL ,
`comm_superior`  decimal(18,2) NULL DEFAULT NULL ,
`comm_branch`  decimal(18,2) NULL DEFAULT NULL ,
`last_comm`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='注单统计报表'
AUTO_INCREMENT=16058437

;

-- ----------------------------
-- Records of ds_report
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_report_site_day`
-- ----------------------------
DROP TABLE IF EXISTS `ds_report_site_day`;
CREATE TABLE `ds_report_site_day` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '网站名' ,
`bet_count`  int(11) NULL DEFAULT NULL ,
`betamount`  decimal(18,2) NULL DEFAULT NULL COMMENT '下注金额' ,
`winlose`  decimal(18,2) NULL DEFAULT NULL COMMENT '派彩金额' ,
`validamount`  decimal(18,2) NULL DEFAULT NULL COMMENT '有效下注金额' ,
`live_id`  tinyint(4) NULL DEFAULT NULL COMMENT '视讯id' ,
`live_name`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视讯名称' ,
`game_kind`  int(11) NULL DEFAULT NULL ,
`game_kind_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_time`  date NULL DEFAULT NULL COMMENT '下注时间  以天为单位统计' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='（报表总计）注单统计报表'
AUTO_INCREMENT=2063016

;

-- ----------------------------
-- Records of ds_report_site_day
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_sgs_config`
-- ----------------------------
DROP TABLE IF EXISTS `ds_sgs_config`;
CREATE TABLE `ds_sgs_config` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`client_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`client_secret`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`url`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='申博配置'
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of ds_sgs_config
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_sgs_game`
-- ----------------------------
DROP TABLE IF EXISTS `ds_sgs_game`;
CREATE TABLE `ds_sgs_game` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '站点id' ,
`ugs_bet_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内部唯一注单号' ,
`txid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外部注单号' ,
`bet_on`  datetime NULL DEFAULT NULL COMMENT '下注时间' ,
`bet_closed_on`  datetime NULL DEFAULT NULL COMMENT '下注结束时间' ,
`bet_updated_on`  datetime NULL DEFAULT NULL COMMENT '下注更新时间' ,
`timestamp`  datetime NULL DEFAULT NULL ,
`roundid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`round_status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：New，Open，Closed' ,
`userid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家id' ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家名称' ,
`riskamt`  decimal(20,2) NULL DEFAULT NULL COMMENT '下注金额' ,
`winamt`  decimal(20,2) NULL DEFAULT NULL COMMENT '盈利' ,
`winloss`  decimal(20,2) NULL DEFAULT NULL COMMENT '净额' ,
`beforebal`  decimal(20,2) NULL DEFAULT NULL COMMENT '下注前额度' ,
`postbal`  decimal(20,2) NULL DEFAULT NULL COMMENT '下注后额度' ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL COMMENT '输赢类型，1：输，2：赢，3：和，4：注单取消' ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货币' ,
`game_provider`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏提供者名称' ,
`game_provider_code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏提供者代码' ,
`game_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏名称' ,
`game_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏类型' ,
`platform_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏平台，Desktop，Mobile' ,
`ip_address`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址' ,
`bet_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注类型' ,
`play_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩游戏类型' ,
`player_type`  tinyint(2) NULL DEFAULT NULL COMMENT '玩家类型，1：正式玩家，2：测试玩家' ,
`turnover`  decimal(20,3) NULL DEFAULT NULL COMMENT '总盈利' ,
`validbet`  decimal(20,3) NULL DEFAULT NULL COMMENT '总有效下注' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='SGS电子注单详情表'
AUTO_INCREMENT=59

;

-- ----------------------------
-- Records of ds_sgs_game
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_sgs_live`
-- ----------------------------
DROP TABLE IF EXISTS `ds_sgs_live`;
CREATE TABLE `ds_sgs_live` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '站点id' ,
`ugs_bet_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内部唯一注单号' ,
`txid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bet_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '外部注单号' ,
`bet_on`  datetime NULL DEFAULT NULL COMMENT '下注时间' ,
`bet_closed_on`  datetime NULL DEFAULT NULL COMMENT '下注结束时间' ,
`bet_updated_on`  datetime NULL DEFAULT NULL COMMENT '下注更新时间' ,
`timestamp`  datetime NULL DEFAULT NULL ,
`roundid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`round_status`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态：New，Open，Closed' ,
`userid`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家id' ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家名称' ,
`riskamt`  decimal(20,2) NULL DEFAULT NULL COMMENT '下注金额' ,
`winamt`  decimal(20,2) NULL DEFAULT NULL COMMENT '盈利' ,
`winloss`  decimal(20,2) NULL DEFAULT NULL COMMENT '净额' ,
`beforebal`  decimal(20,2) NULL DEFAULT NULL COMMENT '下注前额度' ,
`postbal`  decimal(20,2) NULL DEFAULT NULL COMMENT '下注后额度' ,
`win_loss_type`  tinyint(4) NULL DEFAULT NULL COMMENT '输赢类型，1：输，2：赢，3：和，4：注单取消' ,
`currency`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货币' ,
`game_provider`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏提供者名称' ,
`game_provider_code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏提供者代码' ,
`game_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏名称' ,
`game_id`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏类型' ,
`platform_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏平台，Desktop，Mobile' ,
`ip_address`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址' ,
`bet_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下注类型' ,
`play_type`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩游戏类型' ,
`player_type`  tinyint(2) NULL DEFAULT NULL COMMENT '玩家类型，1：正式玩家，2：测试玩家' ,
`turnover`  decimal(20,3) NULL DEFAULT NULL COMMENT '总盈利' ,
`validbet`  decimal(20,3) NULL DEFAULT NULL COMMENT '总有效下注' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_time`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='SGS视讯注单详情表'
AUTO_INCREMENT=27

;

-- ----------------------------
-- Records of ds_sgs_live
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_sgs_record_time`
-- ----------------------------
DROP TABLE IF EXISTS `ds_sgs_record_time`;
CREATE TABLE `ds_sgs_record_time` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`client_secret`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`last_get_record_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='SGS注单拉取时间记录表'
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of ds_sgs_record_time
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `ds_xiaoyu_lotto_ip`
-- ----------------------------
DROP TABLE IF EXISTS `ds_xiaoyu_lotto_ip`;
CREATE TABLE `ds_xiaoyu_lotto_ip` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`ip`  varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=36

;

-- ----------------------------
-- Records of ds_xiaoyu_lotto_ip
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `dt_pt_game`
-- ----------------------------
DROP TABLE IF EXISTS `dt_pt_game`;
CREATE TABLE `dt_pt_game` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL COMMENT '网站id' ,
`username`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`playername`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家帐号' ,
`windowcode`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当时打开游戏游戏界面的数量' ,
`gameid`  int(11) NULL DEFAULT NULL COMMENT '游戏次数' ,
`gamecode`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '流水号' ,
`gametype`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏种类' ,
`gamename`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '游戏名称' ,
`sessionid`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就是登陆session' ,
`bet`  decimal(18,2) NULL DEFAULT NULL COMMENT '下注 ' ,
`win`  decimal(18,2) NULL DEFAULT NULL COMMENT '当局游戏的赢额' ,
`progressivebet`  decimal(18,2) NULL DEFAULT NULL COMMENT '累积奖金游戏的下注' ,
`progressivewin`  decimal(18,2) NULL DEFAULT NULL COMMENT '累积奖金的赢利' ,
`balance`  decimal(18,2) NULL DEFAULT NULL COMMENT '玩家的余额' ,
`currentbet`  decimal(18,2) NULL DEFAULT NULL COMMENT '如果大于0的话就代表有未完成的游戏赌注' ,
`rnum`  int(11) NULL DEFAULT NULL COMMENT '注单数量' ,
`gamedate`  datetime NULL DEFAULT NULL ,
`livenetwork`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现场荷官游戏游戏的备注' ,
`win_lose_type`  int(11) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='PT电子'
AUTO_INCREMENT=22076549

;

-- ----------------------------
-- Records of dt_pt_game
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `dt_pt_page_record`
-- ----------------------------
DROP TABLE IF EXISTS `dt_pt_page_record`;
CREATE TABLE `dt_pt_page_record` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`agent`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`page`  int(11) NULL DEFAULT NULL ,
`page_size`  int(11) NULL DEFAULT NULL ,
`last_page_check_times`  int(11) NULL DEFAULT NULL ,
`yesterday_check_status`  int(11) NULL DEFAULT NULL ,
`rounddate`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`begin_time`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`end_time`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`time_index`  int(11) NULL DEFAULT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='PT电子拉取日志'
AUTO_INCREMENT=10561

;

-- ----------------------------
-- Records of dt_pt_page_record
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `gf_lottery_info`
-- ----------------------------
DROP TABLE IF EXISTS `gf_lottery_info`;
CREATE TABLE `gf_lottery_info` (
`user`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理账户' ,
`siteId`  int(20) NULL DEFAULT NULL ,
`level`  int(20) NULL DEFAULT NULL ,
`record_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(20) NULL DEFAULT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='官方彩拉取配置'

;

-- ----------------------------
-- Records of gf_lottery_info
-- ----------------------------
BEGIN;
INSERT INTO `gf_lottery_info` VALUES ('99999', '99999', '4', 'http://test.com', '50');
COMMIT;

-- ----------------------------
-- Table structure for `lottery_info`
-- ----------------------------
DROP TABLE IF EXISTS `lottery_info`;
CREATE TABLE `lottery_info` (
`user`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理账户' ,
`siteId`  int(20) NOT NULL ,
`level`  int(20) NOT NULL ,
`record_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`state`  int(20) NOT NULL 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='经典彩拉取配置'

;

-- ----------------------------
-- Records of lottery_info
-- ----------------------------
BEGIN;
INSERT INTO `lottery_info` VALUES ('99999', '99999', '4', 'http://test.com', '50');
COMMIT;

-- ----------------------------
-- Table structure for `site_id_info`
-- ----------------------------
DROP TABLE IF EXISTS `site_id_info`;
CREATE TABLE `site_id_info` (
`site_id`  int(11) NOT NULL DEFAULT 0 ,
`site_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`state`  int(11) NULL DEFAULT NULL ,
`create_time`  date NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`site_id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='网站配置'

;

-- ----------------------------
-- Records of site_id_info
-- ----------------------------
BEGIN;
INSERT INTO `site_id_info` VALUES ('99999', '鼎泰技术测试', '50', '2017-07-05', '');
COMMIT;

-- ----------------------------
-- Table structure for `temp_audit_mg_game`
-- ----------------------------
DROP TABLE IF EXISTS `temp_audit_mg_game`;
CREATE TABLE `temp_audit_mg_game` (
`id`  bigint(20) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin

;

-- ----------------------------
-- Records of temp_audit_mg_game
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `temp_audit_total`
-- ----------------------------
DROP TABLE IF EXISTS `temp_audit_total`;
CREATE TABLE `temp_audit_total` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`site_id`  int(11) NULL DEFAULT NULL ,
`live_id`  int(5) NULL DEFAULT NULL ,
`order_no`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`bet_time`  datetime NULL DEFAULT NULL ,
`pay_amount`  decimal(18,2) NULL DEFAULT NULL ,
`bet_amount`  decimal(18,2) NULL DEFAULT NULL ,
`valid_amount`  decimal(18,2) NULL DEFAULT 0.00 ,
`type`  int(11) NOT NULL COMMENT '1:视讯 2:体育 3:彩票 4:机率 5:棋牌' ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='稽核总表'
AUTO_INCREMENT=38

;

-- ----------------------------
-- Records of temp_audit_total
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `temp_audit_video_game_wager`
-- ----------------------------
DROP TABLE IF EXISTS `temp_audit_video_game_wager`;
CREATE TABLE `temp_audit_video_game_wager` (
`id`  int(11) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of temp_audit_video_game_wager
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `temp_video_game_wager`
-- ----------------------------
DROP TABLE IF EXISTS `temp_video_game_wager`;
CREATE TABLE `temp_video_game_wager` (
`id`  bigint(20) NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of temp_video_game_wager
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `video_game_trans_record`
-- ----------------------------
DROP TABLE IF EXISTS `video_game_trans_record`;
CREATE TABLE `video_game_trans_record` (
`transId`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键' ,
`transMoney`  decimal(18,5) NULL DEFAULT NULL COMMENT '转账金额' ,
`gameSetId`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家游戏局的唯一标识' ,
`type`  int(2) NULL DEFAULT NULL COMMENT '该局游戏是否结束' ,
`createTime`  datetime NULL DEFAULT NULL COMMENT '0:下注   1：赔付' ,
PRIMARY KEY (`transId`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of video_game_trans_record
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for `video_game_wager`
-- ----------------------------
DROP TABLE IF EXISTS `video_game_wager`;
CREATE TABLE `video_game_wager` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键' ,
`siteId`  int(11) NULL DEFAULT NULL ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`accountId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`betAmount`  decimal(18,2) NULL DEFAULT NULL COMMENT '下单金额' ,
`winLose`  decimal(18,2) NULL DEFAULT NULL ,
`commissonAmount`  decimal(18,2) NULL DEFAULT NULL ,
`winLoseType`  int(11) NULL DEFAULT NULL ,
`gameKey`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家下注的游戏ID' ,
`gameSetId`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家游戏局的唯一标识' ,
`money`  decimal(18,2) NULL DEFAULT NULL COMMENT '原来账户钱数' ,
`currency`  varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '玩家币种' ,
`isFinal`  smallint(6) NULL DEFAULT NULL ,
`createTime`  datetime NULL DEFAULT NULL ,
`lastUpdateTime`  datetime NULL DEFAULT NULL ,
`memo`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`flag`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=1

;

-- ----------------------------
-- Records of video_game_wager
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Indexes structure for table ag_pull_record_log
-- ----------------------------
CREATE UNIQUE INDEX `path_index` ON `ag_pull_record_log`(`ag_path`, `date_path`, `filename`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ag_pull_record_log`
-- ----------------------------
ALTER TABLE `ag_pull_record_log` AUTO_INCREMENT=55027;

-- ----------------------------
-- Indexes structure for table api_agent_ip
-- ----------------------------
CREATE UNIQUE INDEX `ip` ON `api_agent_ip`(`ip`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `api_agent_ip`
-- ----------------------------
ALTER TABLE `api_agent_ip` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `api_info`
-- ----------------------------
ALTER TABLE `api_info` AUTO_INCREMENT=60659;

-- ----------------------------
-- Indexes structure for table audit_total_99999
-- ----------------------------
CREATE UNIQUE INDEX `order_no_2` ON `audit_total_99999`(`order_no`, `game_name`) USING BTREE ;
CREATE INDEX `live_id` ON `audit_total_99999`(`live_id`) USING BTREE ;
CREATE INDEX `order_no` ON `audit_total_99999`(`order_no`) USING BTREE ;
CREATE INDEX `username` ON `audit_total_99999`(`username`) USING BTREE ;
CREATE INDEX `index_name` ON `audit_total_99999`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `audit_total_99999`
-- ----------------------------
ALTER TABLE `audit_total_99999` AUTO_INCREMENT=63385;

-- ----------------------------
-- Auto increment value for `c_live_id_config`
-- ----------------------------
ALTER TABLE `c_live_id_config` AUTO_INCREMENT=13;

-- ----------------------------
-- Auto increment value for `c_report_detail_config`
-- ----------------------------
ALTER TABLE `c_report_detail_config` AUTO_INCREMENT=33;

-- ----------------------------
-- Auto increment value for `c_total_audit_config`
-- ----------------------------
ALTER TABLE `c_total_audit_config` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `c_total_report_config`
-- ----------------------------
ALTER TABLE `c_total_report_config` AUTO_INCREMENT=35;

-- ----------------------------
-- Auto increment value for `dictionary_table`
-- ----------------------------
ALTER TABLE `dictionary_table` AUTO_INCREMENT=945;

-- ----------------------------
-- Auto increment value for `ds_ag_file_record`
-- ----------------------------
ALTER TABLE `ds_ag_file_record` AUTO_INCREMENT=9;

-- ----------------------------
-- Indexes structure for table ds_ag_hunter
-- ----------------------------
CREATE UNIQUE INDEX `trade_no_index` ON `ds_ag_hunter`(`trade_no`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_ag_hunter`(`site_id`) USING BTREE ;
CREATE INDEX `username` ON `ds_ag_hunter`(`username`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_ag_hunter`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_ag_hunter`
-- ----------------------------
ALTER TABLE `ds_ag_hunter` AUTO_INCREMENT=297297;

-- ----------------------------
-- Indexes structure for table ds_ag_live
-- ----------------------------
CREATE UNIQUE INDEX `bill_no_index` ON `ds_ag_live`(`bill_no`) USING BTREE ;
CREATE INDEX `user_pre_index` ON `ds_ag_live`(`user_pre`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_ag_live`(`site_id`) USING BTREE ;
CREATE INDEX `game_kind` ON `ds_ag_live`(`game_kind`) USING BTREE ;
CREATE INDEX `username` ON `ds_ag_live`(`username`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_ag_live`(`bet_time`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_ag_live`(`game_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_ag_live`
-- ----------------------------
ALTER TABLE `ds_ag_live` AUTO_INCREMENT=215151358;

-- ----------------------------
-- Indexes structure for table ds_ag_sport
-- ----------------------------
CREATE UNIQUE INDEX `bill_no_index` ON `ds_ag_sport`(`bill_no`) USING BTREE ;
CREATE INDEX `user_pre_index` ON `ds_ag_sport`(`user_pre`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_ag_sport`(`site_id`) USING BTREE ;
CREATE INDEX `game_kind` ON `ds_ag_sport`(`game_kind`) USING BTREE ;
CREATE INDEX `username` ON `ds_ag_sport`(`username`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_ag_sport`(`bet_time`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_ag_sport`(`game_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_ag_sport`
-- ----------------------------
ALTER TABLE `ds_ag_sport` AUTO_INCREMENT=6375;

-- ----------------------------
-- Indexes structure for table ds_aghunter_report
-- ----------------------------
CREATE UNIQUE INDEX `username_2` ON `ds_aghunter_report`(`username`, `site_id`, `game_type`, `bet_time`) USING BTREE ;
CREATE INDEX `username` ON `ds_aghunter_report`(`username`) USING BTREE ;
CREATE INDEX `live_id` ON `ds_aghunter_report`(`live_id`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_aghunter_report`(`site_id`) USING BTREE ;
CREATE INDEX `game_kind` ON `ds_aghunter_report`(`game_kind`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_aghunter_report`(`game_type`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_aghunter_report`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_aghunter_report`
-- ----------------------------
ALTER TABLE `ds_aghunter_report` AUTO_INCREMENT=14748;

-- ----------------------------
-- Indexes structure for table ds_bbin_jilv
-- ----------------------------
CREATE UNIQUE INDEX `wagers_id` ON `ds_bbin_jilv`(`wagers_id`) USING BTREE ;
CREATE INDEX `bbin_game_kind_index` ON `ds_bbin_jilv`(`bbin_game_kind`) USING BTREE ;
CREATE INDEX `wagers_id_index` ON `ds_bbin_jilv`(`wagers_id`) USING BTREE ;
CREATE INDEX `bet_date` ON `ds_bbin_jilv`(`bet_date`) USING BTREE ;
CREATE INDEX `win_loss_type` ON `ds_bbin_jilv`(`win_loss_type`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_bbin_jilv`(`site_id`) USING BTREE ;
CREATE INDEX `user_name` ON `ds_bbin_jilv`(`user_name`) USING BTREE ;
CREATE INDEX `wagers_date` ON `ds_bbin_jilv`(`wagers_date`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_bbin_jilv`(`game_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_bbin_jilv`
-- ----------------------------
ALTER TABLE `ds_bbin_jilv` AUTO_INCREMENT=520626643;

-- ----------------------------
-- Indexes structure for table ds_bbin_live
-- ----------------------------
CREATE INDEX `wagers_id_index` ON `ds_bbin_live`(`wagers_id`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_bbin_live`(`game_type`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_bbin_live`(`site_id`) USING BTREE ;
CREATE INDEX `user_name` ON `ds_bbin_live`(`user_name`) USING BTREE ;
CREATE INDEX `wagers_date` ON `ds_bbin_live`(`wagers_date`) USING BTREE ;
CREATE INDEX `win_loss_type` ON `ds_bbin_live`(`win_loss_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_bbin_live`
-- ----------------------------
ALTER TABLE `ds_bbin_live` AUTO_INCREMENT=77574839;

-- ----------------------------
-- Indexes structure for table ds_bbin_page_record
-- ----------------------------
CREATE INDEX `i_siteid_gamekind_date` ON `ds_bbin_page_record`(`site_id`, `game_kind`, `date`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_bbin_page_record`
-- ----------------------------
ALTER TABLE `ds_bbin_page_record` AUTO_INCREMENT=672478;

-- ----------------------------
-- Indexes structure for table ds_bbin_sport
-- ----------------------------
CREATE UNIQUE INDEX `wagers_id_index` ON `ds_bbin_sport`(`wagers_id`) USING BTREE ;
CREATE INDEX `bbin_game_kind_index` ON `ds_bbin_sport`(`bbin_game_kind`) USING BTREE ;
CREATE INDEX `user_name` ON `ds_bbin_sport`(`user_name`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_bbin_sport`(`site_id`) USING BTREE ;
CREATE INDEX `wagers_date` ON `ds_bbin_sport`(`wagers_date`) USING BTREE ;
CREATE INDEX `i_payout_date` ON `ds_bbin_sport`(`payout_time`) USING BTREE ;
CREATE INDEX `i_order_date` ON `ds_bbin_sport`(`order_date`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_bbin_sport`
-- ----------------------------
ALTER TABLE `ds_bbin_sport` AUTO_INCREMENT=33460;

-- ----------------------------
-- Indexes structure for table ds_game_kind_order
-- ----------------------------
CREATE UNIQUE INDEX `order` ON `ds_game_kind_order`(`order_asc`) USING BTREE ;
CREATE INDEX `game_kind` ON `ds_game_kind_order`(`game_kind`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_game_kind_order`
-- ----------------------------
ALTER TABLE `ds_game_kind_order` AUTO_INCREMENT=67;

-- ----------------------------
-- Indexes structure for table ds_game_type
-- ----------------------------
CREATE INDEX `out_game_code` ON `ds_game_type`(`out_game_code`) USING BTREE ;
CREATE INDEX `parent_id` ON `ds_game_type`(`parent_id`) USING BTREE ;
CREATE INDEX `fk_live_id` ON `ds_game_type`(`fk_live_id`) USING BTREE ;

-- ----------------------------
-- Indexes structure for table ds_guangfang_lottery
-- ----------------------------
CREATE UNIQUE INDEX `nid` ON `ds_guangfang_lottery`(`nid`) USING BTREE ;
CREATE UNIQUE INDEX `id` ON `ds_guangfang_lottery`(`id`) USING BTREE ;
CREATE INDEX `siteid` ON `ds_guangfang_lottery`(`siteid`) USING BTREE ;
CREATE INDEX `user` ON `ds_guangfang_lottery`(`user_name`) USING BTREE ;
CREATE INDEX `issue` ON `ds_guangfang_lottery`(`issue`) USING BTREE ;
CREATE INDEX `report_time` ON `ds_guangfang_lottery`(`report_time`) USING BTREE ;
CREATE INDEX `lid` ON `ds_guangfang_lottery`(`lid`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_guangfang_lottery`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_guangfang_lottery`
-- ----------------------------
ALTER TABLE `ds_guangfang_lottery` AUTO_INCREMENT=4009527;

-- ----------------------------
-- Indexes structure for table ds_ip_game
-- ----------------------------
CREATE UNIQUE INDEX `ip` ON `ds_ip_game`(`ip`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_ip_game`
-- ----------------------------
ALTER TABLE `ds_ip_game` AUTO_INCREMENT=2;

-- ----------------------------
-- Indexes structure for table ds_jingdian_lottery
-- ----------------------------
CREATE UNIQUE INDEX `nid` ON `ds_jingdian_lottery`(`nid`) USING BTREE ;
CREATE UNIQUE INDEX `id` ON `ds_jingdian_lottery`(`id`) USING BTREE ;
CREATE INDEX `siteid` ON `ds_jingdian_lottery`(`siteid`) USING BTREE ;
CREATE INDEX `user` ON `ds_jingdian_lottery`(`user`) USING BTREE ;
CREATE INDEX `report_time` ON `ds_jingdian_lottery`(`report_time`) USING BTREE ;
CREATE INDEX `lid` ON `ds_jingdian_lottery`(`lid`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_jingdian_lottery`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_jingdian_lottery`
-- ----------------------------
ALTER TABLE `ds_jingdian_lottery` AUTO_INCREMENT=1490531947;

-- ----------------------------
-- Indexes structure for table ds_jingdian_lottery_99999
-- ----------------------------
CREATE UNIQUE INDEX `nid` ON `ds_jingdian_lottery_99999`(`nid`) USING BTREE ;
CREATE UNIQUE INDEX `id` ON `ds_jingdian_lottery_99999`(`id`) USING BTREE ;
CREATE INDEX `user` ON `ds_jingdian_lottery_99999`(`user`) USING BTREE ;
CREATE INDEX `report_time` ON `ds_jingdian_lottery_99999`(`report_time`) USING BTREE ;
CREATE INDEX `lid` ON `ds_jingdian_lottery_99999`(`lid`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_jingdian_lottery_99999`(`bet_time`) USING BTREE ;
CREATE INDEX `game_ind` ON `ds_jingdian_lottery_99999`(`game_kind`) USING BTREE ;
CREATE INDEX `qishu` ON `ds_jingdian_lottery_99999`(`qishu`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_jingdian_lottery_99999`
-- ----------------------------
ALTER TABLE `ds_jingdian_lottery_99999` AUTO_INCREMENT=1;

-- ----------------------------
-- Indexes structure for table ds_jpgame
-- ----------------------------
CREATE UNIQUE INDEX `wagersid` ON `ds_jpgame`(`wagersid`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_jpgame`
-- ----------------------------
ALTER TABLE `ds_jpgame` AUTO_INCREMENT=1;

-- ----------------------------
-- Indexes structure for table ds_ky_chess
-- ----------------------------
CREATE UNIQUE INDEX `game_id_index` ON `ds_ky_chess`(`game_id`) USING BTREE ;
CREATE INDEX `i_win_loss_type` ON `ds_ky_chess`(`win_loss_type`) USING BTREE ;
CREATE INDEX `i_site_id` ON `ds_ky_chess`(`site_id`) USING BTREE ;
CREATE INDEX `i_account` ON `ds_ky_chess`(`account`) USING BTREE ;
CREATE INDEX `i_kind_id` ON `ds_ky_chess`(`kind_id`) USING BTREE ;
CREATE INDEX `i_game_end_time` ON `ds_ky_chess`(`game_end_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_ky_chess`
-- ----------------------------
ALTER TABLE `ds_ky_chess` AUTO_INCREMENT=1073;

-- ----------------------------
-- Indexes structure for table ds_live
-- ----------------------------
CREATE UNIQUE INDEX `billno` ON `ds_live`(`billno`) USING BTREE ;
CREATE INDEX `win_loss_type` ON `ds_live`(`win_loss_type`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_live`(`site_id`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_live`(`game_type`) USING BTREE ;
CREATE INDEX `username` ON `ds_live`(`username`) USING BTREE ;
CREATE INDEX `end_time` ON `ds_live`(`end_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_live`
-- ----------------------------
ALTER TABLE `ds_live` AUTO_INCREMENT=124659;

-- ----------------------------
-- Indexes structure for table ds_live_tips
-- ----------------------------
CREATE INDEX `trade_no` ON `ds_live_tips`(`trade_no`) USING BTREE ;
CREATE INDEX `ds_live_type` ON `ds_live_tips`(`ds_live_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_live_tips`
-- ----------------------------
ALTER TABLE `ds_live_tips` AUTO_INCREMENT=7129755;

-- ----------------------------
-- Indexes structure for table ds_lmg_live
-- ----------------------------
CREATE UNIQUE INDEX `billno` ON `ds_lmg_live`(`billno`) USING BTREE ;
CREATE INDEX `win_loss_type` ON `ds_lmg_live`(`win_loss_type`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_lmg_live`(`site_id`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_lmg_live`(`game_type`) USING BTREE ;
CREATE INDEX `username` ON `ds_lmg_live`(`username`) USING BTREE ;
CREATE INDEX `end_time` ON `ds_lmg_live`(`end_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_lmg_live`
-- ----------------------------
ALTER TABLE `ds_lmg_live` AUTO_INCREMENT=46;

-- ----------------------------
-- Indexes structure for table ds_lottery_bet
-- ----------------------------
CREATE INDEX `billno` ON `ds_lottery_bet`(`billno`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_lottery_bet`(`site_id`) USING BTREE ;
CREATE INDEX `lottery_game_type` ON `ds_lottery_bet`(`lottery_game_type`) USING BTREE ;
CREATE INDEX `bet_id_index` ON `ds_lottery_bet`(`bet_id`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_lottery_bet`
-- ----------------------------
ALTER TABLE `ds_lottery_bet` AUTO_INCREMENT=1;

-- ----------------------------
-- Indexes structure for table ds_lottery_bet_type
-- ----------------------------
CREATE UNIQUE INDEX `game_info_id` ON `ds_lottery_bet_type`(`game_info_id`, `bet_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_lottery_bet_type`
-- ----------------------------
ALTER TABLE `ds_lottery_bet_type` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ds_lottery_config`
-- ----------------------------
ALTER TABLE `ds_lottery_config` AUTO_INCREMENT=1;

-- ----------------------------
-- Indexes structure for table ds_lotto_bet
-- ----------------------------
CREATE INDEX `bet_id_index` ON `ds_lotto_bet`(`bet_id`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_lotto_bet`(`site_id`) USING BTREE ;
CREATE INDEX `username` ON `ds_lotto_bet`(`username`) USING BTREE ;
CREATE INDEX `win_loss_type` ON `ds_lotto_bet`(`win_loss_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_lotto_bet`
-- ----------------------------
ALTER TABLE `ds_lotto_bet` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ds_lotto_bet_detail`
-- ----------------------------
ALTER TABLE `ds_lotto_bet_detail` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ds_lotto_bet_on`
-- ----------------------------
ALTER TABLE `ds_lotto_bet_on` AUTO_INCREMENT=1;

-- ----------------------------
-- Auto increment value for `ds_lotto_bet_type`
-- ----------------------------
ALTER TABLE `ds_lotto_bet_type` AUTO_INCREMENT=1;

-- ----------------------------
-- Indexes structure for table ds_m8_sport
-- ----------------------------
CREATE INDEX `bet_id` ON `ds_m8_sport`(`bet_id`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_m8_sport`(`site_id`) USING BTREE ;
CREATE INDEX `flag` ON `ds_m8_sport`(`flag`) USING BTREE ;
CREATE INDEX `username` ON `ds_m8_sport`(`username`) USING BTREE ;
CREATE INDEX `transaction_date` ON `ds_m8_sport`(`transaction_date`) USING BTREE ;
CREATE INDEX `workdate` ON `ds_m8_sport`(`workdate`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_m8_sport`
-- ----------------------------
ALTER TABLE `ds_m8_sport` AUTO_INCREMENT=1;

-- ----------------------------
-- Indexes structure for table ds_member
-- ----------------------------
CREATE UNIQUE INDEX `username` ON `ds_member`(`username`, `site_id`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_member`
-- ----------------------------
ALTER TABLE `ds_member` AUTO_INCREMENT=1953265;

-- ----------------------------
-- Indexes structure for table ds_mg_game
-- ----------------------------
CREATE UNIQUE INDEX `col_id` ON `ds_mg_game`(`bet_col_id`) USING BTREE ;
CREATE INDEX `siteId` ON `ds_mg_game`(`siteId`) USING BTREE ;
CREATE INDEX `username` ON `ds_mg_game`(`username`) USING BTREE ;
CREATE INDEX `win_lose_type` ON `ds_mg_game`(`win_lose_type`) USING BTREE ;
CREATE INDEX `type` ON `ds_mg_game`(`type`) USING BTREE ;
CREATE INDEX `game_code` ON `ds_mg_game`(`game_code`) USING BTREE ;
CREATE INDEX `transaction_timestamp` ON `ds_mg_game`(`transaction_timestamp`) USING BTREE ;
CREATE INDEX `playername` ON `ds_mg_game`(`playername`) USING BTREE ;
CREATE INDEX `mgs_game_id` ON `ds_mg_game`(`mgs_game_id`) USING BTREE ;
CREATE INDEX `transaction_timestamp_date` ON `ds_mg_game`(`transaction_timestamp_date`) USING BTREE ;
CREATE INDEX `payoff` ON `ds_mg_game`(`payoff`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_mg_game`
-- ----------------------------
ALTER TABLE `ds_mg_game` AUTO_INCREMENT=31983;

-- ----------------------------
-- Auto increment value for `ds_mg_game_config`
-- ----------------------------
ALTER TABLE `ds_mg_game_config` AUTO_INCREMENT=8;

-- ----------------------------
-- Indexes structure for table ds_mg_game_detail
-- ----------------------------
CREATE INDEX `col_id` ON `ds_mg_game_detail`(`bet_col_id`) USING BTREE ;
CREATE INDEX `siteId` ON `ds_mg_game_detail`(`siteId`) USING BTREE ;
CREATE INDEX `username` ON `ds_mg_game_detail`(`username`) USING BTREE ;
CREATE INDEX `win_lose_type` ON `ds_mg_game_detail`(`win_lose_type`) USING BTREE ;
CREATE INDEX `type` ON `ds_mg_game_detail`(`type`) USING BTREE ;
CREATE INDEX `game_code` ON `ds_mg_game_detail`(`game_code`) USING BTREE ;
CREATE INDEX `transaction_timestamp` ON `ds_mg_game_detail`(`transaction_timestamp`) USING BTREE ;
CREATE INDEX `playername` ON `ds_mg_game_detail`(`playername`) USING BTREE ;
CREATE INDEX `mgs_game_id` ON `ds_mg_game_detail`(`mgs_game_id`) USING BTREE ;
CREATE INDEX `transaction_timestamp_date` ON `ds_mg_game_detail`(`transaction_timestamp_date`) USING BTREE ;
CREATE INDEX `payoff` ON `ds_mg_game_detail`(`payoff`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_mg_game_detail`
-- ----------------------------
ALTER TABLE `ds_mg_game_detail` AUTO_INCREMENT=40671;

-- ----------------------------
-- Indexes structure for table ds_og_live
-- ----------------------------
CREATE UNIQUE INDEX `product_id` ON `ds_og_live`(`product_id`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_og_live`(`site_id`) USING BTREE ;
CREATE INDEX `vendor_id` ON `ds_og_live`(`vendor_id`) USING BTREE ;
CREATE INDEX `username` ON `ds_og_live`(`username`) USING BTREE ;
CREATE INDEX `game_name_id` ON `ds_og_live`(`game_name_id`) USING BTREE ;
CREATE INDEX `add_time` ON `ds_og_live`(`add_time`) USING BTREE ;
CREATE INDEX `win_lose_type` ON `ds_og_live`(`win_lose_type`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_og_live`
-- ----------------------------
ALTER TABLE `ds_og_live` AUTO_INCREMENT=2501693;

-- ----------------------------
-- Indexes structure for table ds_report
-- ----------------------------
CREATE UNIQUE INDEX `username_2` ON `ds_report`(`username`, `site_id`, `game_type`, `bet_time`) USING BTREE ;
CREATE INDEX `username` ON `ds_report`(`username`) USING BTREE ;
CREATE INDEX `live_id` ON `ds_report`(`live_id`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_report`(`site_id`) USING BTREE ;
CREATE INDEX `game_kind` ON `ds_report`(`game_kind`) USING BTREE ;
CREATE INDEX `game_type` ON `ds_report`(`game_type`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_report`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_report`
-- ----------------------------
ALTER TABLE `ds_report` AUTO_INCREMENT=16058437;

-- ----------------------------
-- Indexes structure for table ds_report_site_day
-- ----------------------------
CREATE UNIQUE INDEX `site_gamekind` ON `ds_report_site_day`(`site_id`, `game_kind`, `bet_time`) USING BTREE ;
CREATE INDEX `live_id` ON `ds_report_site_day`(`live_id`) USING BTREE ;
CREATE INDEX `site_id` ON `ds_report_site_day`(`site_id`) USING BTREE ;
CREATE INDEX `game_kind` ON `ds_report_site_day`(`game_kind`) USING BTREE ;
CREATE INDEX `bet_time` ON `ds_report_site_day`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_report_site_day`
-- ----------------------------
ALTER TABLE `ds_report_site_day` AUTO_INCREMENT=2063016;

-- ----------------------------
-- Auto increment value for `ds_sgs_config`
-- ----------------------------
ALTER TABLE `ds_sgs_config` AUTO_INCREMENT=2;

-- ----------------------------
-- Indexes structure for table ds_sgs_game
-- ----------------------------
CREATE UNIQUE INDEX `i_ugs_bet_id` ON `ds_sgs_game`(`ugs_bet_id`) USING BTREE ;
CREATE INDEX `i_win_loss_type` ON `ds_sgs_game`(`win_loss_type`) USING BTREE ;
CREATE INDEX `i_site_id` ON `ds_sgs_game`(`site_id`) USING BTREE ;
CREATE INDEX `i_username` ON `ds_sgs_game`(`username`) USING BTREE ;
CREATE INDEX `i_game_id` ON `ds_sgs_game`(`game_id`) USING BTREE ;
CREATE INDEX `i_game_provider_code` ON `ds_sgs_game`(`game_provider_code`) USING BTREE ;
CREATE INDEX `i_bet_on` ON `ds_sgs_game`(`bet_on`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_sgs_game`
-- ----------------------------
ALTER TABLE `ds_sgs_game` AUTO_INCREMENT=59;

-- ----------------------------
-- Indexes structure for table ds_sgs_live
-- ----------------------------
CREATE UNIQUE INDEX `i_ugs_bet_id` ON `ds_sgs_live`(`ugs_bet_id`) USING BTREE ;
CREATE INDEX `i_win_loss_type` ON `ds_sgs_live`(`win_loss_type`) USING BTREE ;
CREATE INDEX `i_site_id` ON `ds_sgs_live`(`site_id`) USING BTREE ;
CREATE INDEX `i_username` ON `ds_sgs_live`(`username`) USING BTREE ;
CREATE INDEX `i_game_id` ON `ds_sgs_live`(`game_id`) USING BTREE ;
CREATE INDEX `i_game_provider_code` ON `ds_sgs_live`(`game_provider_code`) USING BTREE ;
CREATE INDEX `i_bet_on` ON `ds_sgs_live`(`bet_on`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_sgs_live`
-- ----------------------------
ALTER TABLE `ds_sgs_live` AUTO_INCREMENT=27;

-- ----------------------------
-- Auto increment value for `ds_sgs_record_time`
-- ----------------------------
ALTER TABLE `ds_sgs_record_time` AUTO_INCREMENT=2;

-- ----------------------------
-- Indexes structure for table ds_xiaoyu_lotto_ip
-- ----------------------------
CREATE UNIQUE INDEX `ip` ON `ds_xiaoyu_lotto_ip`(`ip`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `ds_xiaoyu_lotto_ip`
-- ----------------------------
ALTER TABLE `ds_xiaoyu_lotto_ip` AUTO_INCREMENT=36;

-- ----------------------------
-- Indexes structure for table dt_pt_game
-- ----------------------------
CREATE UNIQUE INDEX `gamecode` ON `dt_pt_game`(`gamecode`) USING BTREE ;
CREATE INDEX `site_id` ON `dt_pt_game`(`site_id`) USING BTREE ;
CREATE INDEX `username` ON `dt_pt_game`(`username`) USING BTREE ;
CREATE INDEX `gamedate` ON `dt_pt_game`(`gamedate`) USING BTREE ;
CREATE INDEX `gamename` ON `dt_pt_game`(`gamename`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `dt_pt_game`
-- ----------------------------
ALTER TABLE `dt_pt_game` AUTO_INCREMENT=22076549;

-- ----------------------------
-- Indexes structure for table dt_pt_page_record
-- ----------------------------
CREATE INDEX `i_agent_rounddate` ON `dt_pt_page_record`(`agent`, `rounddate`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `dt_pt_page_record`
-- ----------------------------
ALTER TABLE `dt_pt_page_record` AUTO_INCREMENT=10561;

-- ----------------------------
-- Indexes structure for table temp_audit_total
-- ----------------------------
CREATE INDEX `site_id` ON `temp_audit_total`(`site_id`) USING BTREE ;
CREATE INDEX `live_id` ON `temp_audit_total`(`live_id`) USING BTREE ;
CREATE INDEX `order_no` ON `temp_audit_total`(`order_no`) USING BTREE ;
CREATE INDEX `username` ON `temp_audit_total`(`username`) USING BTREE ;
CREATE INDEX `index_name` ON `temp_audit_total`(`bet_time`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `temp_audit_total`
-- ----------------------------
ALTER TABLE `temp_audit_total` AUTO_INCREMENT=38;

-- ----------------------------
-- Indexes structure for table video_game_wager
-- ----------------------------
CREATE INDEX `username` ON `video_game_wager`(`username`) USING BTREE ;
CREATE INDEX `gameKey` ON `video_game_wager`(`gameKey`) USING BTREE ;
CREATE INDEX `gameSetId` ON `video_game_wager`(`gameSetId`) USING BTREE ;
CREATE INDEX `createTime` ON `video_game_wager`(`createTime`) USING BTREE ;
CREATE INDEX `winLoseType` ON `video_game_wager`(`winLoseType`) USING BTREE ;
CREATE INDEX `lastUpdateTime` ON `video_game_wager`(`lastUpdateTime`) USING BTREE ;

-- ----------------------------
-- Auto increment value for `video_game_wager`
-- ----------------------------
ALTER TABLE `video_game_wager` AUTO_INCREMENT=1;
