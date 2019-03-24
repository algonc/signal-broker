CREATE TABLE random_city (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE signals (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  data varchar(255) DEFAULT NULL,
  timestamp TIMESTAMP DEFAULT NOW(),
  PRIMARY KEY (id)
);

CREATE TABLE roles (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_roles (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FK_USER_ROLES_USER FOREIGN KEY (user_id) REFERENCES users (id),
  CONSTRAINT FK_USER_ROLES_ROLE FOREIGN KEY (role_id) REFERENCES roles (id)
);