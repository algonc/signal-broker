INSERT INTO roles (id, role_name, description) VALUES (1, 'DEVICE', 'Role for signal sending devices');
INSERT INTO roles (id, role_name, description) VALUES (2, 'ADMIN', 'Role for admin users');

INSERT INTO users (id, first_name, last_name, password, username) VALUES (1, 'Device', '1', '$2a$10$Xm67UkEbiMjw5KlAIN/Ofu1Wpbvrzj6Rw1rHqnhFBzid9XnpNUGA6', 'device1');
INSERT INTO users (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'User', '$2a$10$Xm67UkEbiMjw5KlAIN/Ofu1Wpbvrzj6Rw1rHqnhFBzid9XnpNUGA6', 'admin');

INSERT INTO user_roles(user_id, role_id) VALUES(1,1);
INSERT INTO user_roles(user_id, role_id) VALUES(2,1);
INSERT INTO user_roles(user_id, role_id) VALUES(2,2);

INSERT INTO signals(id, data) VALUES (1, '0x1');
