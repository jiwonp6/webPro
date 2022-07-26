--table&sequence drop/create
DROP TABLE BOOK CASCADE CONSTRAINTS;
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP SEQUENCE BOOK_SQ;
CREATE SEQUENCE BOOK_SQ 
    MAXVALUE 99999999 
    NOCYCLE 
    NOCACHE;
CREATE TABLE BOOK(
    bNUM NUMBER(8) PRIMARY KEY,
    bTITLE VARCHAR2(100) NOT NULL,
    bWRITER VARCHAR2(100) NOT NULL,
    bRDATE DATE DEFAULT SYSDATE NOT NULL,
    bIMG1 VARCHAR2(100) DEFAULT 'noImg.png' NOT NULL,
    bIMG2 VARCHAR2(100) DEFAULT 'noImg.png' NOT NULL,
    bINFO VARCHAR2(1000)
);
CREATE TABLE MEMBER(
    mID VARCHAR2(100) PRIMARY KEY,
    mPW VARCHAR2(100) NOT NULL,
    mNAME VARCHAR2(100) NOT NULL,
    mMAIL VARCHAR2(100) NOT NULL,
    mPOST VARCHAR2(100),     -- 우편번호
    mADDR VARCHAR2(100)      -- 주소
);
-- DUMMY DATA
INSERT INTO MEMBER VALUES('kkk', '111', '김김김', 'kim@naver.com', '12345', '서울');
INSERT INTO BOOK VALUES
        (BOOK_SQ.NEXTVAL, '책책','김작가',sysdate, 'noImg.png','noImg.png','김작가의 책책');
INSERT INTO BOOK VALUES
        (BOOK_SQ.NEXTVAL, '북북','김북',sysdate, 'noImg.png','noImg.png','김북의 북북');
INSERT INTO BOOK VALUES
        (BOOK_SQ.NEXTVAL, '북북','김북',sysdate, '김북의 북북');
INSERT INTO BOOK VALUES
        (BOOK_SQ.NEXTVAL, '상실의 시대','무라카미하루키',sysdate, 'noImg.png','noImg.png','무라카미하루키명작');
INSERT INTO BOOK VALUES
        (BOOK_SQ.NEXTVAL, '우리가 빛의 속도로 갈 수 없다면','김초엽',sysdate, 'noImg.png','noImg.png','신인 김초엽작가의 신작');