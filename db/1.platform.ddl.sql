DROP TABLE p_datasource;
CREATE TABLE p_datasource (
  id                VARCHAR(64) PRIMARY KEY,
  name              VARCHAR(64)  NOT NULL,
  driver            VARCHAR(64)  NOT NULL,
  url               VARCHAR(128) NOT NULL,
  user              VARCHAR(64)  NOT NULL,
  password          VARCHAR(64)  NOT NULL,
  max_pool_size     NUMERIC,
  min_pool_size     NUMERIC,
  checkout_timeout  NUMERIC,
  initial_pool_size NUMERIC,
  max_idle_time     NUMERIC,
  acquire_increment NUMERIC,
  del_flag          NUMERIC(1) DEFAULT 0,
  enable_flag       NUMERIC(1) DEFAULT 1,
  description       VARCHAR(256),
  created_time      DATE,
  created_user      VARCHAR(64),
  updated_time      DATE,
  updated_user      VARCHAR(64)
)
  ENGINE = innodb;

INSERT INTO p_datasource (id, name, driver, url, user, password, max_pool_size, min_pool_size, checkout_timeout, initial_pool_size, max_idle_time,
                          acquire_increment, del_flag, enable_flag, description)
VALUES ('1', 'aaa', 'com.mysql.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/shop_tenant_1', 'root', 'root',
             15, 3, 1000, 3, 100, 3, 0, 1, '');

INSERT INTO p_datasource (id, name, driver, url, user, password, max_pool_size, min_pool_size, checkout_timeout, initial_pool_size, max_idle_time,
                          acquire_increment , del_flag, enable_flag, description)
VALUES ('2', 'bbb', 'com.mysql.jdbc.Driver', 'jdbc:mysql://127.0.0.1:3306/shop_tenant_2', 'root', 'root',
             15, 3, 1000, 3, 100, 3, 0, 1, '');

DROP TABLE p_apply_tenant;
#租户申请信息， 用户上来申请时填写的信息
CREATE TABLE p_apply_tenant (
  id           VARCHAR(64) PRIMARY KEY,
  name         VARCHAR(64) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  email        VARCHAR(64),
  address      VARCHAR(64),
  state        NUMERIC(1) DEFAULT 0, # 0:申请状态 1:成功状态 2:拒绝状态
  apply_time   DATE, #申请时间
  #deal_time date, # 处理时间
  pass_time    DATE, # 申请通过时间
  description  VARCHAR(200)
)
  ENGINE = innodb;

DROP TABLE p_tenant;
#申请租户成功后的租户正式信息
CREATE TABLE p_tenant (
  id            INT        AUTO_INCREMENT PRIMARY KEY,
  name          VARCHAR(64) NOT NULL,
  domain_url    VARCHAR(11) NOT NULL,
  datasource_id VARCHAR(64) NOT NULL,
  del_flag      NUMERIC(1) DEFAULT 0,
  enable_flag   NUMERIC(1) DEFAULT 1,
  created_time  DATE,
  created_user  VARCHAR(64),
  updated_time  DATE,
  updated_user  VARCHAR(64),
  description   VARCHAR(200)
)
  ENGINE = innodb;
INSERT INTO p_tenant (id, name, domain_url, datasource_id) VALUES (1, 'aaa', 'aaa', '1');
INSERT INTO p_tenant (id, name, domain_url, datasource_id) VALUES (2, 'bbb', 'bbb', '2');

DROP TABLE p_tenant_info;
#租户申请成功后的租户信息
CREATE TABLE p_tenant_info (
  id           VARCHAR(64) PRIMARY KEY,
  tenant_id    INT         NOT NULL,
  owner_name   VARCHAR(64) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  company      VARCHAR(64),
  email        VARCHAR(64),
  address      VARCHAR(64),
  created_time DATE,
  created_user VARCHAR(64),
  updated_time DATE,
  updated_user VARCHAR(64),
  description  VARCHAR(200)
)
  ENGINE = innodb;

INSERT INTO p_tenant_info (id, tenant_id, owner_name, phone_number) VALUES ('1', 1, 'aaa', '11111');
INSERT INTO p_tenant_info (id, tenant_id, owner_name, phone_number) VALUES ('2', 2, 'bbb', '22222');

DROP TABLE p_user_auth;
#平台用户（暂时只有若干平台管理员）
CREATE TABLE p_user_auth (
  id       VARCHAR(64) PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  password VARCHAR(64) NOT NULL
)
  ENGINE = innodb;

INSERT INTO p_user_auth VALUES ('1', 'platadmin', '123456');

DROP TABLE p_user;
#平台用户（平台管理员,如果是类似电商的话，可能需要此表，可以保存消费者信息等）
CREATE TABLE p_user (
  id           VARCHAR(64) PRIMARY KEY, #user_auth_id
  username     VARCHAR(64) NOT NULL,
  name         VARCHAR(64) NOT NULL, #真实姓名
  enable_flag  NUMERIC(1) DEFAULT 1, #是否被激活
  created_time DATE,
  created_user VARCHAR(64),
  updated_time DATE,
  updated_user VARCHAR(64),
  description  VARCHAR(200)
)
  ENGINE = innodb;

INSERT INTO p_user (id, username, name) VALUES ('1', 'platadmin', '平台管理员');

DROP TABLE p_role;
CREATE TABLE p_role (
  id          VARCHAR(64) PRIMARY KEY,
  name        VARCHAR(64) NOT NULL, #平台管理员 #电商会员
  code        VARCHAR(20) NOT NULL,
  description VARCHAR(200)
)
  ENGINE = innodb;
INSERT INTO p_role (id, name, code) VALUES ('R99999', '平台管理员', 'platadmin');

DROP TABLE p_role_user;
CREATE TABLE p_role_user (
  id      VARCHAR(64) PRIMARY KEY,
  role_id VARCHAR(64) NOT NULL,
  user_id VARCHAR(64) NOT NULL
)
  ENGINE = innodb;

INSERT INTO p_role_user VALUES ('1', 'R99999', '1');
