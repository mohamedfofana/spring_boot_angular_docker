-- CREATE TABLES
CREATE TABLE EMPLOYEE( 	
    ID            				INTEGER NOT NULL,
    FIRSTNAME          			VARCHAR2(50) NOT NULL, 
    LASTNAME        			VARCHAR2(50) NOT NULL, 
    ADDRESS			        	VARCHAR2(150), 
    ZIPCODE           			INTEGER,
    CITY           				VARCHAR2(50),
    COUNTRY           			VARCHAR2(50),
   CONSTRAINT PK_EMPLOYEE PRIMARY KEY (ID) 
 );
 
 
 INSERT INTO EMPLOYEE VALUES (1, 'David', 'JOHNSON', '8456 West Pacific Road',15601, 'Greensburg', 'United States of America');
 