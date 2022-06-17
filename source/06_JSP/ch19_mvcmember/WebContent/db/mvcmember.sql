-- DROP & CREATE TABLE
DROP TABLE MVC_MEMBER;
CREATE TABLE MVC_MEMBER(
    mID VARCHAR2(30) PRIMARY KEY,
    mPW VARCHAR2(30) NOT NULL,
    mNAME VARCHAR2(30) NOT NULL,
    mEMAIL VARCHAR2(30),
    mPHOTO VARCHAR2(30) NOT NULL,
    mBIRTH DATE NOT NULL,
    mADDRESS VARCHAR2(30),
    mRDATE DATE DEFAULT SYSDATE NOT NULL
);
-- DUMMY DATA
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gayun','1','김가연','gayun@naver.com','gayun.jpg','1972/09/09','광주광역시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('gico','1','지코','gico@naver.com','gico.jpg','1992/09/14','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('go','1','고소영','go@naver.com','go.jpg','1972/10/06','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('ham','1','함소원','ham@naver.com','ham.jpg','1976/06/16','서울시');
INSERT INTO MVC_MEMBER (mID, mPw, mName, mEmail, mPhoto, mBirth, mAddress)
    VALUES ('han','1','한지민','han@naver.com','han.jpg','1982/11/05','서울시');
-- query
-- (1)로그인
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa' AND MPW = '1';
-- (2)MID로 DTO 가져오기(로그인 성공시 SESSION에 넣기 위함)
SELECT * FROM MVC_MEMBER WHERE MID = 'aaa';
-- (3)회원 ID 중복체크
SELECT mID FROM MVC_MEMBER WHERE MID='aaa';
-- (4)회원가입
INSERT INTO MVC_MEMBER (mID, mPW, mNAME, mEMAIL, mPHOTO, mBIRTH, mADDRESS) 
    VALUES ('aaa', '1', '박박박', 'park@park.com', 'NOIMG.JPG', '1988-08-08', '서울 강남구');
-- (5)회원정보 수정
UPDATE MVC_MEMBER
    SET mPW = '111',
        mNAME = '박박',
        mEMAIL = 'park@park.com',
        mPHOTO = 'NOIMG.JPG',
        mBIRTH = '1988-08-08',
        mADDRESS = '서울 강남구'
    WHERE mID = 'aaa';
-- (6)회원리스트(TOP-N구문)
SELECT *
    FROM (SELECT ROWNUM RN, A.* FROM (SELECT mID, mNAME, mPHOTO FROM MVC_MEMBER ORDER BY mRDATE DESC) A)
    WHERE RN BETWEEN 2 AND 3;
-- (7)회원수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
commit;