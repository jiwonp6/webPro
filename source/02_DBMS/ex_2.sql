-- 테이블 생성
DROP TABLE CUS_LEVEL;
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(10) PRIMARY KEY,
    LEVELNAME VARCHAR2(30) NOT NULL
);
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
    cNO NUMBER(10) PRIMARY KEY,
    cNAME VARCHAR2(30) NOT NULL,
    JOINDATE DATE DEFAULT SYSDATE,
    PHONE VARCHAR2(30) UNIQUE,
    POINT NUMBER(10),
    LEVELNO NUMBER(10) REFERENCES CUS_LEVEL(LEVELNO)
);

-- 시퀀스 생성
DROP SEQUENCE CUS_SQ;
CREATE SEQUENCE CUS_SQ
    MAXVALUE 9999
    NOCACHE 
    NOCYCLE;
    
--더미 데이터
INSERT INTO CUS_LEVEL VALUES (1, 'VVIP');
INSERT INTO CUS_LEVEL VALUES (2, 'VIP');
INSERT INTO CUS_LEVEL VALUES (3, 'NORMAL');
INSERT INTO CUS_LEVEL VALUES (4, 'BLACK');
SELECT * FROM CUS_LEVEL;
INSERT INTO CUSTOMER VALUES (CUS_SQ.NEXTVAL, '홍길동', '22/03/10', '010-9999-9999', 0, 1);
INSERT INTO CUSTOMER VALUES (CUS_SQ.NEXTVAL, '이철수', '22/04/19', '010-8888-8888', NULL, 2);
SELECT * FROM CUSTOMER;

SELECT cNO, cNAME, JOINDATE, PHONE, POINT, LEVELNAME
    FROM CUSTOMER C, CUS_LEVEL CL
    WHERE C.LEVELNO = CL.LEVELNO;
