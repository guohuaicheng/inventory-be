DROP TABLE t_user_auth;
# 租户用户
CREATE TABLE t_user_auth (
  id        VARCHAR(64) PRIMARY KEY,
  username  VARCHAR(64) NOT NULL,
  password  VARCHAR(64) NOT NULL,
  tenant_id INT         NOT NULL
)
  ENGINE = innodb;

INSERT INTO t_user_auth VALUES ('1', 'sysadmin', '123456', 1);
INSERT INTO t_user_auth VALUES ('2', 'bizadmin', '123456', 1);

INSERT INTO t_user_auth VALUES ('3', 'sysadmin', '123456', 2);
INSERT INTO t_user_auth VALUES ('4', 'bizadmin', '123456', 2);

DROP TABLE t_user;
# --租户用户信息
CREATE TABLE t_user (
  id           VARCHAR(64) PRIMARY KEY, #user_auth_id
  username     VARCHAR(64) NOT NULL,
  name         VARCHAR(64) NOT NULL, #真实姓名
  enable_flag  NUMERIC(1) DEFAULT 1, #是否被激活
  created_time DATE,
  created_user VARCHAR(64),
  updated_time DATE,
  updated_user VARCHAR(64),
  description  VARCHAR(200),
  tenant_id    INT         NOT NULL
)
  ENGINE = innodb;
INSERT INTO t_user (id, username, name, tenant_id) VALUES ('1', 'sysadmin', '租户管理员', 1);
INSERT INTO t_user (id, username, name, tenant_id) VALUES ('2', 'bizadmin', '业务管理员', 1);
INSERT INTO t_user (id, username, name, tenant_id) VALUES ('3', 'sysadmin', '租户管理员', 2);
INSERT INTO t_user (id, username, name, tenant_id) VALUES ('4', 'bizadmin', '业务管理员', 2);

DROP TABLE t_role;
#租户角色
CREATE TABLE t_role (
  id          VARCHAR(64) PRIMARY KEY,
  NAME        VARCHAR(64) NOT NULL, #租户管理员 --操作员 （业务管理员, 暂时不用)
  CODE        VARCHAR(20) NOT NULL,
  description VARCHAR(200)
)
  ENGINE = innodb;
INSERT INTO t_role VALUES ('R99991', '系统管理员', 'sysadmin', '11');
INSERT INTO t_role VALUES ('R99992', '业务管理员', 'bizadmin', '11');
INSERT INTO t_role VALUES ('R99993', '普通系统人员', 'sysuser', '11');
INSERT INTO t_role VALUES ('R99994', '普通业务人员', 'bizuser', '11');


DROP TABLE t_role_user;
CREATE TABLE t_role_user (
  id        VARCHAR(64) PRIMARY KEY,
  role_id   VARCHAR(64) NOT NULL,
  user_id   VARCHAR(64) NOT NULL,
  tenant_id INT         NOT NULL
)
  ENGINE = innodb;

INSERT INTO t_role_user VALUES ('1', 'R99991', '1', 1);
INSERT INTO t_role_user VALUES ('2', 'R99992', '2', 1);

INSERT INTO t_role_user VALUES ('3', 'R999911', '3', 2);
INSERT INTO t_role_user VALUES ('4', 'R999921', '4', 2);

DROP TABLE t_vip;
# --租户vip会员
CREATE TABLE t_vip (
  id                 VARCHAR(64) PRIMARY KEY,
  vip_no             VARCHAR(64) NOT NULL,
  name               VARCHAR(64) NOT NULL,
  phone              VARCHAR(20) NOT NULL,
  remain_money       NUMERIC DEFAULT 0, # 帐户剩余钱数
  charge_total_money NUMERIC DEFAULT 0, # 帐户总共充值金额
  charge_count       INT     DEFAULT 0, # 帐户总共充值次数
  created_time       DATE,
  created_user       VARCHAR(64),
  updated_time       DATE,
  updated_user       VARCHAR(64),
  tenant_id          VARCHAR(64)
)
  ENGINE = innodb;

DROP TABLE t_vip_money_record;
# --租户vip会员钱数变化记录
CREATE TABLE t_vip_money_record (
  id           VARCHAR(64) PRIMARY KEY,
  vip_id       VARCHAR(64) NOT NULL,
  money        NUMERIC DEFAULT 0, # 充值钱数
  type         NUMERIC(1),
  created_time DATE,
  created_user VARCHAR(64),
  updated_time DATE,
  updated_user VARCHAR(64),
  tenant_id    VARCHAR(64)
)
  ENGINE = innodb;

DROP TABLE t_product;
CREATE TABLE t_product (
  id             VARCHAR(64) PRIMARY KEY,
  product_number VARCHAR(64) NOT NULL,
  name           VARCHAR(64) NOT NULL,
  unit_price     NUMERIC DEFAULT 0,
  remain_count   INT     DEFAULT 0,
  created_time   DATE,
  created_user   VARCHAR(64),
  updated_time   DATE,
  updated_user   VARCHAR(64),
  tenant_id      INT         NOT NULL
)
  ENGINE = innodb;

DROP TABLE t_product_in_record;
CREATE TABLE t_product_in_record (#只增加
  id             VARCHAR(64) PRIMARY KEY,
  product_id     VARCHAR(64) NOT NULL,
  previous_count INT DEFAULT 0,
  in_count       INT DEFAULT 0,
  remain_count   INT DEFAULT 0,
  created_time   DATE,
  created_user   VARCHAR(64),
  tenant_id      INT         NOT NULL
)
  ENGINE = innodb;

DROP TABLE t_product_out_record;
CREATE TABLE t_product_out_record (#只增加
  id             VARCHAR(64) PRIMARY KEY,
  product_id     VARCHAR(64) NOT NULL,
  previous_count INT DEFAULT 0,
  out_count      INT DEFAULT 0,
  remain_count   INT DEFAULT 0,
  created_time   DATE,
  created_user   VARCHAR(64),
  tenant_id      INT         NOT NULL
)
  ENGINE = innodb;

DROP TABLE t_order_1;
CREATE TABLE t_order_1 (
  id           VARCHAR(64) PRIMARY KEY,
  vip_id       VARCHAR(64) NOT NULL,
  total_price  NUMERIC DEFAULT 0,
  created_time DATE,
  created_user VARCHAR(64),
  updated_time DATE,
  updated_user VARCHAR(64),
  tenant_id    INT         NOT NULL
)
  ENGINE = innodb;

DROP TABLE t_order_2;
CREATE TABLE t_order_2 (
  id           VARCHAR(64) PRIMARY KEY,
  vip_id       VARCHAR(64) NOT NULL,
  total_price  NUMERIC DEFAULT 0,
  created_time DATE,
  created_user VARCHAR(64),
  updated_time DATE,
  updated_user VARCHAR(64),
  tenant_id    INT         NOT NULL
)
  ENGINE = innodb;

DROP TABLE t_order_detail_1;
CREATE TABLE t_order_detail_1 (
  id          VARCHAR(64) PRIMARY KEY,
  order_id    VARCHAR(64) NOT NULL,
  vip_id      VARCHAR(64) NOT NULL,
  product_id  VARCHAR(64) NOT NULL,
  unit_price  NUMERIC DEFAULT 0,
  count       INT     DEFAULT 0,
  total_price NUMERIC DEFAULT 0,
  tenant_id   INT         NOT NULL
)
  ENGINE = innodb;

DROP TABLE t_order_detail_2;
CREATE TABLE t_order_detail_2 (
  id          VARCHAR(64) PRIMARY KEY,
  order_id    VARCHAR(64) NOT NULL,
  vip_id      VARCHAR(64) NOT NULL,
  product_id  VARCHAR(64) NOT NULL,
  unit_price  NUMERIC DEFAULT 0,
  count       INT     DEFAULT 0,
  total_price NUMERIC DEFAULT 0,
  tenant_id   INT         NOT NULL
)
  ENGINE = innodb;
