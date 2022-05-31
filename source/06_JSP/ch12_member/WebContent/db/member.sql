--TABLE DROP & CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS;
    -- CASCADE CONSTRAINTS : 제약조건 무시하고 지움
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    ADDRESS VARCHAR(100),
    RDATE DATE NOT NULL --가입일
);
SELECT * 
    FROM MEMBER;
-- 1. 회원가입 시 ID 중복체크를 위한 SQL : public int confirmId(String id)
SELECT * 
    FROM MEMBER WHERE ID = 'aaa';
-- 2. 회원가입 : public int joinMember(MemberDto dto)
INSERT 
    INTO MEMBER (ID, PW, NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE)
    VALUES('aaa', '111', '박박박', '02', '1111', '1111', 'M', 'PARK@P.COM','1995-12-12', '서울', SYSDATE);
-- 3. 로그인(id/pw) : public int loginCheck(String id, String pw)
SELECT ID, PW 
    FROM MEMBER 
    WHERE ID='aaa';
-- 4. ID로 dto 가져오기 : public MemberDto getMember(String id)
SELECT * 
    FROM MEMBER 
    WHERE ID='aaa';
-- 5. 회원정보 수정
UPDATE MEMBER 
    SET PW='111', 
        NAME='구구구', 
        PHONE1='010', 
        PHONE2='0000', 
        PHONE3='1111', 
        GENDER='w', 
        EMAIL='GUGU@G.COM', 
        BIRTH='2000-09-09', 
        ADDRESS='이태리', 
        RDATE=SYSDATE
    WHERE ID='aaa';
SELECT * 
    FROM MEMBER;
COMMIT;