DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT(
  ID INT AUTO_INCREMENT PRIMARY KEY ,
  NAME VARCHAR(20) NOT NULL,
  PRICE INT,
  MANUFACTURER VARCHAR (20) NOT NULL,
  DESCRIPTION VARCHAR (250)
);

INSERT INTO PRODUCT ( NAME, PRICE, MANUFACTURER, DESCRIPTION) VALUES
  ('Nike-Watch S80',4150,'Nike','Glow in the dark wrist watch from Nike.'),
  ('G-Shock 250',3200,'G-shock','Durable underwater wrist watch G-shock Green.'),
  ('Casio Quartz 338',4450,'Casio','Wrist watch LED Display Casio.'),
  ('G-Shock 160Z',2650,'G-Shock','Durable underwater wrist watch LED G-shock Blue'),
  ('1-1813E LONDON',4500,'Jacques Lemans','Classic Jacque Lemands wrist watch Brown Leather.'),
  ('Apple-Watch S08',5999,'Apple','Apple smart watch');



DROP  TABLE  IF EXISTS  TRANSACTION;        

CREATE TABLE TRANSACTION(
  ID INT AUTO_INCREMENT PRIMARY KEY,
  TRANSACTION_CASYS VARCHAR (500) NOT NULL,
);

INSERT  INTO TRANSACTION(TRANSACTION_CASYS) VALUES ('1 ,jonsmo,3000');