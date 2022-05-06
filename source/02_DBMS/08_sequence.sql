<<<<<<< HEAD
--[VIII] SEQUENCE : ������ȣ ������, ��κ� �������� PK ��� �뵵
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ  --������ �����
    START WITH 1   --DEFAULT�� = 1
    INCREMENT BY 1  --1�� ����, DEFAULT�� = 1
    MAXVALUE 9999
    MINVALUE 1  --DEFAULT�� = 1
    NOCACHE --�̸� 20������ �׿��ִ� CACHE�޸𸮸� ������� �ʰڴ�!
    NOCYCLE;
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL; 
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;    
DROP TABLE FRIEND;
CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY,  --������ �̿�
    NAME VARCHAR2(10) NOT NULL,
    TEL VARCHAR2(30) UNIQUE,    --NULL���, ������ ��
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE
    );
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', NULL, '����� ������');
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', '010-9999-9999', '����� ��걸');
SELECT * FROM FRIEND;   --�������� �������� �����Ѵ�!!!
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) VALUES ( FRIEND_SEQ.NEXTVAL, '�ű浿', '010-8888-8888', '����� ��������');
SELECT FRIEND_SEQ.CURRVAL FROM DUAL;    --�����������
COMMIT;

--EX.�ʱⰪ 101���� �ִ밪 999,999���� 1�� �����ϴ� test_seq �������� ����
DROP SEQUENCE TEST_SEQ;
CREATE SEQUENCE TEST_SEQ
    START WITH 101
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL;  --������ ���� ���� ��� ����
SELECT TEST_SEQ.NEXTVAL FROM DUAL;
    
--��������
--EX1.
DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ
    MAXVALUE 9999
    NOCACHE 
    NOCYCLE;
DROP TABLE MEMBER_LEVEL;
CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(3) PRIMARY KEY,
    LEVELNAME VARCHAR2(50)
);
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    mNO NUMBER(4) PRIMARY KEY,  --�������̿�
    mNAME VARCHAR2(50) NOT NULL,
    mPW VARCHAR2(50) CHECK(LENGTH(mPW)>0 AND LENGTH(mPW)<9),
    mEMAIL VARCHAR2(50) UNIQUE,
    mPOINT NUMBER(10) CHECK(mPOINT>=0),
    mRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(3) REFERENCES MEMBER_LEVEL(LEVELNO)
    );
INSERT INTO MEMBER_LEVEL VALUES (-1, 'BLACK');
INSERT INTO MEMBER_LEVEL VALUES (0, '�Ϲ�');
INSERT INTO MEMBER_LEVEL VALUES (1, '�ǹ�');
INSERT INTO MEMBER_LEVEL VALUES (2, '���');
SELECT * FROM MEMBER_LEVEL;
SELECT * FROM MEMBER;
SELECT MEMBER_SEQ.CURRVAL FROM DUAL; 
INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, LEVELNO) 
    VALUES (MEMBER_SEQ.NEXTVAL, 'ȫ�浿', 'aa', 'hong@hong.com', 0, 0);
INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, LEVELNO) 
    VALUES (MEMBER_SEQ.NEXTVAL, '�ű浿', 'bb', 'sin@sin.com', 1000, 1);
SELECT mNO, mNAME, TO_CHAR(mRDATE,'YYYY-MM-DD') "mRDATE", mEMAIL, mPOINT "point", LEVELNAME ||'����' "levelname"
    FROM MEMBER_LEVEL "ML", MEMBER M
    WHERE ML.LEVELNO = M.LEVELNO;

  
=======
--[VIII] SEQUENCE : ������ȣ ������, ��κ� �������� PK ��� �뵵
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ  --������ �����
    START WITH 1   --DEFAULT�� = 1
    INCREMENT BY 1  --1�� ����, DEFAULT�� = 1
    MAXVALUE 9999
    MINVALUE 1  --DEFAULT�� = 1
    NOCACHE --�̸� 20������ �׿��ִ� CACHE�޸𸮸� ������� �ʰڴ�!
    NOCYCLE;
SELECT FRIEND_SEQ.NEXTVAL FROM DUAL; 
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    MAXVALUE 9999
    NOCACHE
    NOCYCLE;    
DROP TABLE FRIEND;
CREATE TABLE FRIEND(
    NUM NUMBER(4) PRIMARY KEY,  --������ �̿�
    NAME VARCHAR2(10) NOT NULL,
    TEL VARCHAR2(30) UNIQUE,    --NULL���, ������ ��
    ADDRESS VARCHAR2(300),
    LAST_MODIFYED DATE DEFAULT SYSDATE
    );
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', NULL, '����� ������');
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) 
    VALUES (FRIEND_SEQ.NEXTVAL, 'ȫ�浿', '010-9999-9999', '����� ��걸');
SELECT * FROM FRIEND;   --�������� �������� �����Ѵ�!!!
INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS) VALUES ( FRIEND_SEQ.NEXTVAL, '�ű浿', '010-8888-8888', '����� ��������');
SELECT FRIEND_SEQ.CURRVAL FROM DUAL;    --�����������
COMMIT;

--EX.�ʱⰪ 101���� �ִ밪 999,999���� 1�� �����ϴ� test_seq �������� ����
DROP SEQUENCE TEST_SEQ;
CREATE SEQUENCE TEST_SEQ
    START WITH 101
    MAXVALUE 999999
    NOCACHE
    NOCYCLE;
SELECT TEST_SEQ.CURRVAL FROM DUAL;  --������ ���� ���� ��� ����
SELECT TEST_SEQ.NEXTVAL FROM DUAL;
    
--��������
--EX1.
DROP SEQUENCE MEMBER_SEQ;
CREATE SEQUENCE MEMBER_SEQ
    MAXVALUE 9999
    NOCACHE 
    NOCYCLE;
DROP TABLE MEMBER_LEVEL;
CREATE TABLE MEMBER_LEVEL(
    LEVELNO NUMBER(3) PRIMARY KEY,
    LEVELNAME VARCHAR2(50)
);
DROP TABLE MEMBER;
CREATE TABLE MEMBER(
    mNO NUMBER(4) PRIMARY KEY,  --�������̿�
    mNAME VARCHAR2(50) NOT NULL,
    mPW VARCHAR2(50),
    mEMAIL VARCHAR2(50) UNIQUE,
    mPOINT NUMBER(10) CHECK(mPOINT>=0),
    mRDATE DATE DEFAULT SYSDATE,
    LEVELNO NUMBER(3) REFERENCES MEMBER_LEVEL(LEVELNO)
    );
INSERT INTO MEMBER_LEVEL VALUES (-1, 'BLACK');
INSERT INTO MEMBER_LEVEL VALUES (0, '�Ϲ�');
INSERT INTO MEMBER_LEVEL VALUES (1, '�ǹ�');
INSERT INTO MEMBER_LEVEL VALUES (2, '���');
SELECT * FROM MEMBER_LEVEL;
SELECT * FROM MEMBER;
SELECT MEMBER_SEQ.CURRVAL FROM DUAL; 
INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, LEVELNO) 
    VALUES (MEMBER_SEQ.NEXTVAL, 'ȫ�浿', 'aa', 'hong@hong.com', 0, 0);
INSERT INTO MEMBER (mNO, mNAME, mPW, mEMAIL, mPOINT, LEVELNO) 
    VALUES (MEMBER_SEQ.NEXTVAL, '�ű浿', 'bb', 'sin@sin.com', 1000, 1);
SELECT * FROM MEMBER;
--EX2.
    
    
    
    
    
    
    
    
    
    
    
    
    
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606