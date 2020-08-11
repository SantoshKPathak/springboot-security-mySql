INSERT INTO USERS
(username,
password,
enabled)
VALUES
('santosh',
'santosh',
true);

INSERT INTO USERS
(username,
password,
enabled)
VALUES
('admin',
'admin',
true);

Commit;

INSERT INTO AUTHORITIES
(id,
users_username,
authority)
VALUES
(1, 
'santosh',
'ROLE_USER');

INSERT INTO AUTHORITIES
(id,
users_username,
authority)
VALUES
(2,
'admin',
'ROLE_ADMIN');

INSERT INTO AUTHORITIES
(id,
users_username,
authority)
VALUES
(3,
'santosh',
'ROLE_ADMIN');

commit;