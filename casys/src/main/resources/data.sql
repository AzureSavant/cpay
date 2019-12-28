DROP TABLE IF EXISTS CREDIT_CARD;

CREATE TABLE CREDIT_CARD (
  ID INT AUTO_INCREMENT ,
  CREDIT_CARD_NUMBER VARCHAR(250) NOT NULL PRIMARY KEY,
  CREDIT_CARD_TYPE VARCHAR(250) NOT NULL,
  EXPIRATION_YEAR INT DEFAULT NULL,
  EXPIRATION_MONTH INT DEFAULT NULL,
  NAME VARCHAR(250) NOT NULL,
  SECURITY_CODE INT NOT NULL
);

INSERT INTO CREDIT_CARD (CREDIT_CARD_NUMBER, CREDIT_CARD_TYPE, EXPIRATION_MONTH, EXPIRATION_YEAR, NAME, SECURITY_CODE) VALUES
  ('4865439069438923', 'Discover', 9, 2021, 'William Roberts', 683 ),
  ('4983217189917621', 'American Express', 12, 2019, 'Tyler Parker', 172 ),
  ('4893125808820200', 'Visa', 12, 2022, 'Etha Roberts', 347 ),
  ('4893125808820201', 'Visa', 1, 2018, 'Robert Valire', 123),
  ('400000000000000', 'Master Card', 12, 2024, 'John Snow', 220);


DROP TABLE IF EXISTS CLIENT;

CREATE TABLE CLIENT (
  ID INT AUTO_INCREMENT ,
  EMAIL VARCHAR(250) NOT NULL ,
  NAME VARCHAR(250) NOT NULL,
  PHONENUMBER VARCHAR(250) DEFAULT NULL,
  CREDIT_CARD_ID VARCHAR(250) NOT NULL PRIMARY KEY
);

INSERT INTO CLIENT ( EMAIL, NAME , PHONENUMBER, CREDIT_CARD_ID) VALUES
  ('william.roberts@mail.com', 'William Roberts',null , '4865439069438923' ),
  ('tylerParker@mail.com', 'Tyler Parker',null , '4983217189917621' ),
  ('etha.roberts@mail.com', 'Etha Roberts','077123456', '4893125808820200' ),
  ('Snowjohn@mail.com',  'John Snow','070654321', '4000000000000000'),
  ('robert.valire@mail.com', 'Robert Valire','075789456', '4893125808820201');
