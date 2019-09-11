DROP TABLE IF EXISTS Authorities;
DROP TABLE IF EXISTS Users;

CREATE TABLE Users ( 
	username varchar(255) NOT NULL PRIMARY KEY, 
	password varchar(255) NOT NULL, 
	enabled boolean NOT NULL
);

CREATE TABLE Authorities (
	username varchar(255) NOT NULL,
	authority varchar(255) NOT NULL,
	fk_authorities_users varchar(255),
	FOREIGN KEY (fk_authorities_users) REFERENCES Users(username)
);

INSERT INTO users (username, password, enabled) values ('user', 'pass', true);
INSERT INTO users (username, password, enabled) values ('admin', 'pass', true);
	
INSERT INTO authorities (username, authority) values ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) values ('admin', 'ROLE_ADMIN');