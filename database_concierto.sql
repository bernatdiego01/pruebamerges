CREATE DATABASE CONCIERTOMUSICA;

CREATE TABLE CONCIERTO (
    ID int NOT NULL AUTO_INCREMENT,
    CANTANTE varchar(30) ,
    FECHA date,
    ENTRADAS_DISPONIBLES int(5),
    PRIMARY KEY (ID)
);