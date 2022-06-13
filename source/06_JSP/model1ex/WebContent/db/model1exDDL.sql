-- ?��?���?/?��???�� drop & create
-- CUSTOMER ?��?���?
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cTEL VARCHAR2(50) NOT NULL,
    cEMAIL VARCHAR2(50),
    cADDRESS VARCHAR2(250),
    cGENDER VARCHAR2(10) NOT NULL,
    cBIRTH DATE NOT NULL,
    cRDATE DATE DEFAULT SYSDATE
);
-- BOOK ?��?���? & ?��???��
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;
CREATE SEQUENCE BOOK_SEQ
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
CREATE TABLE BOOK(
    bID NUMBER(5) PRIMARY KEY,  -- 책번?��
    bTITLE VARCHAR2(100) NOT NULL,   -- 책제�?
    bPRICE NUMBER(7) NOT NULL,  -- 책�?�? 
    bIMAGE1 VARCHAR2(30),    -- �? ???�� ?��미�?(첨�??��?��경우 : noImg.png)
    bIMAGE2 VARCHAR2(30),    -- �? �?�? ?��미�?(첨�??��?��경우 : NOTHING.JPG)
    bCONTENT VARCHAR2(4000),    -- �? ?���?(?���? 1,333�??�� ?��?��)
    bDISCOUNT NUMBER(3) NOT NULL,    -- ?��?��?��(0~100% ?��?��) �??��?��?�� 바보?�� �??��?��?�� 몽총?��?�� ?���?.G1G1
    bRDATE DATE DEFAULT SYSDATE     -- �? ?��록일
);
select * from book;
select * from customer;
-- FILEBOARD ?��?���? & ?��???��
DROP SEQUENCE FILEBOARD_SEQ;
CREATE SEQUENCE FILEBOARD_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;
DROP TABLE FILEBOARD;
CREATE TABLE FILEBOARD(
    fNUM NUMBER(7) PRIMARY KEY, -- �?번호
    cID VARCHAR2(50) REFERENCES CUSTOMER(cID),  -- ?��?��?�� ID
    fSUBJECT VARCHAR2(250) NOT NULL,    -- �? ?���?
    fCONTENT VARCHAR2(4000),    -- 본문
    fFILENAME VARCHAR2(50), -- 첨�??��?���?
    fPW VARCHAR2(50) NOT NULL,  -- 비번
    fHIT NUMBER(7) DEFAULT 0 NOT NULL,    -- 조회?��
    fREF NUMBER(7) NOT NULL,    -- �? 그룹
    fRE_STEP NUMBER(7) NOT NULL,    -- 그룹?�� 출력?��?��
    fRE_LEVEL NUMBER(7) NOT NULL,   -- ?��?��?���? ?��?��
    fIP VARCHAR2(50) NOT NULL,  -- �??�� 컴퓨?�� IP
    fRDATE DATE DEFAULT SYSDATE NOT NULL-- �? ?���? ?��?��
);
COMMIT;