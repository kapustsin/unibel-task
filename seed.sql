CREATE SCHEMA unibell;


CREATE TABLE unibell.client (
  id                SERIAL        PRIMARY KEY,
  name              VARCHAR(45)   NOT NULL
 );


CREATE TABLE unibell.contact (
  client_id         BIGINT       NOT NULL,
  type              VARCHAR(5)   NOT NULL,
  value             VARCHAR(45)  NOT NULL
);


INSERT INTO unibell.client (name) VALUES ('Капустин Александр Павлович');
INSERT INTO unibell.client (name) VALUES ('Садовский Евгений Григорьевич');
INSERT INTO unibell.client (name) VALUES ('Дегтярев Сергей Петрович');
INSERT INTO unibell.client (name) VALUES ('Борзых Ольга Николаевна');
INSERT INTO unibell.client (name) VALUES ('Кулик Виктор Олегович');
INSERT INTO unibell.client (name) VALUES ('Быстров Денис Александрович');
INSERT INTO unibell.client (name) VALUES ('Купрацевич Леонид Дмитриевич');
INSERT INTO unibell.client (name) VALUES ('Караваев Семен Святославович');


INSERT INTO unibell.contact (client_id, type, value) VALUES (1, 'phone', '+79015680021');
INSERT INTO unibell.contact (client_id, type, value) VALUES (2, 'phone', '+79025890732');
INSERT INTO unibell.contact (client_id, type, value) VALUES (2, 'phone', '+79024102396');
INSERT INTO unibell.contact (client_id, type, value) VALUES (3, 'phone', '+79035556123');
INSERT INTO unibell.contact (client_id, type, value) VALUES (4, 'phone', '+79041136690');
INSERT INTO unibell.contact (client_id, type, value) VALUES (4, 'phone', '+79047902511');
INSERT INTO unibell.contact (client_id, type, value) VALUES (5, 'phone', '+79054023988');


INSERT INTO unibell.contact (client_id, type, value) VALUES (1, 'email', 'kapustsin@mail.ru');
INSERT INTO unibell.contact (client_id, type, value) VALUES (2, 'email', 'sadovsky@mail.ru');
INSERT INTO unibell.contact (client_id, type, value) VALUES (2, 'email', 'eugen_s@gmail.com');
INSERT INTO unibell.contact (client_id, type, value) VALUES (3, 'email', 's_degtyarev@mail.ru');
INSERT INTO unibell.contact (client_id, type, value) VALUES (3, 'email', 'deg_s@gmail.com');
INSERT INTO unibell.contact (client_id, type, value) VALUES (4, 'email', 'borzyh_olga@mail.ru');
INSERT INTO unibell.contact (client_id, type, value) VALUES (6, 'email', 'drkulyuk@gmail.com');