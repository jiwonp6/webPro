-- customer DAO 쿼리
--1. 고객 회원가입 cid 중복체크
SELECT * FROM CUSTOMER WHERE CID='aaa';
--2. 고객 회원가입
INSERT INTO CUSTOMER (cID, cPW, cNAME, cEMAIL, cFILE, cADDRESS, cBIRTH)
    VALUES ('aaa', '111', '박박박', 'park@park.com', 'file.jpg', '서울', '1999-09-09');
--3. 로그인(cID, cPW)
SELECT * FROM CUSTOMER WHERE cID='aaa' AND cPW='111';
--4. cID로 DTO 가져오기(회원 정보 수정 전)
SELECT * FROM CUSTOMER WHERE cID='aaa';
--5. 회원 정보 수정
UPDATE CUSTOMER 
    SET cPW = '111',
        cNAME = '백백백',
        cEMAIL = 'peak@peak.com',
        cFILE = 'file2.jpg',
        cADDRESS = '서울서울',
        cBIRTH = '1999-09-19'
    WHERE cID = 'aaa';
-- admin DAO 쿼리
--1. 관리자 등록 aID 중복체크
SELECT * FROM ADMIN WHERE AID='bbb';
--2. 관리자 등록
INSERT INTO ADMIN (aID, aPW, aNAME)
    VALUES ('bbb', '111', '신신신');
--3. 관리자 로그인
SELECT * FROM ADMIN WHERE AID='bbb' AND APW='111';
--FILEBOARD DAO 쿼리
--1. 원글쓰기
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FB_SEQ.NEXTVAL, 'aaa', '글1', '본문1', 'file.jpg', '1', FB_SEQ.CURRVAL, 0,0,'126.12.12.1'); 
--2. 답글쓰기
INSERT INTO FILEBOARD (fNUM, aID, fSUBJECT, fCONTENT, fFILENAME, fPW, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FB_SEQ.NEXTVAL, 'bbb', '글1-1','답',null, '1', 3, 1, 1, '192.168.10.10');
    --확인
    SELECT * FROM FILEBOARD WHERE fREF = 3
        ORDER BY FRE_STEP;
--3. 글목록   
        --SELECT F.*, C.CNAME NAME
        --    FROM FILEBOARD F, CUSTOMER C
        --    WHERE F.CID=C.CID AND F.AID IS NULL; 
        --SELECT F.*, A.ANAME NAME
        --    FROM FILEBOARD F, ADMIN A
        --    WHERE F.AID=A.AID AND F.CID IS NULL; 
        --
        --SELECT FNUM, NAME
        --    FROM (SELECT FNUM, NAME
        --                FROM(SELECT F.*, A.ANAME NAME
        --                        FROM FILEBOARD F, ADMIN A
        --                        WHERE F.AID=A.AID AND F.AID IS NULL)),
        --            (SELECT FNUM, NAME
        --                    FROM(SELECT F.*, C.CNAME NAME
        --                            FROM FILEBOARD F, CUSTOMER C
        --                         WHERE F.CID=C.CID AND F.AID IS NULL)); 
        --SELECT F.*
        --    FROM FILEBOARD F, CUSTOMER C, ADMIN AD
        --    WHERE (F.CID=C.CID AND F.AID IS NULL) OR (F.AID=AD.AID AND F.CID IS NULL)
        --    ORDER BY FREF DESC, FRE_STEP; 
--요놈입니다...
SELECT *
    FROM (SELECT ROWNUM RN, A.* 
            FROM (SELECT FNUM, NVL2(CID, CNAME, ANAME) NAME, FSUBJECT, FHIT, FRDATE, FIP 
                        FROM FILEBOARD F, (SELECT A.ANAME FROM FILEBOARD F, ADMIN A WHERE F.AID=A.AID ), (SELECT C.CNAME FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID )
                        ORDER BY FREF DESC, FRE_STEP) A )
    WHERE RN BETWEEN 1 AND 5;

        --SELECT *
        --    FROM (SELECT ROWNUM RN, A.* 
        --            FROM (SELECT F.*
        --                        FROM FILEBOARD F, CUSTOMER C, ADMIN AD
        --                        WHERE F.CID = C.CID OR F.AID = AD.AID
        --                        ORDER BY FREF DESC, FRE_STEP) A )
        --    WHERE RN BETWEEN 1 AND 2;
        --
        --SELECT A.ANAME NAME
        --    FROM FILEBOARD F, ADMIN A
        --    WHERE A.AID = F.AID AND F.AID='bbb';
        --SELECT C.CNAME NAME
        --    FROM FILEBOARD F, CUSTOMER C
        --    WHERE C.CID = F.CID AND F.CID='aaa';

--4-1. 원글상세보기
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID AND fNUM=3;
--4-2. 답글상세보기
SELECT F.*, ANAME FROM FILEBOARD F, ADMIN A WHERE F.AID=A.AID AND fNUM=7;
--5. 글 수정
UPDATE FILEBOARD SET fSUBJECT = '수정된 제목',
                    fCONTENT = '수정된 본문',
                    fFILENAME = NULL,
                    fPW = '111',
                    fIP = '192.168.10.30'
                WHERE fNUM=1;
COMMIT;
--6. 글 삭제
DELETE FROM FILEBOARD WHERE fNUM=2 AND fPW='111';