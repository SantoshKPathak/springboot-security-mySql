CREATE TABLE springsecuritydemo.users (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  enabled TINYINT NOT NULL,
  PRIMARY KEY (username));
  
  
CREATE TABLE authorities (
  id bigint not null auto_increment,
  users_username VARCHAR(45) NOT NULL,
  authority VARCHAR(45) NOT NULL,
  UNIQUE INDEX idx_username_authority (users_username,authority),
  CONSTRAINT fk_username
    FOREIGN KEY (users_username)
    REFERENCES USERS (username));

  
 