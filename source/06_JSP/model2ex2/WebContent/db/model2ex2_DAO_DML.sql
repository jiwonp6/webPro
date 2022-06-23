--MEMBER
    --(1)로그인
    SELECT * FROM MEMBER WHERE mID='aaa' and mPW='1';
    --(2)mID로 mDTO가져오기
    SELECT * FROM MEMBER WHERE mID='aaa';
    --(3)mID 중복체크
    SELECT * FROM MEMBER WHERE mID='aaa';
    --(4)mEMAIL 중복체크
    SELECT * FROM MEMBER WHERE mEMAIL='aaa@aaa.com';
    --(5)MEMBER 가입
    INSERT INTO MEMBER (mID, mPW, mNAME, mEMAIL, mPHOTO, mBIRTH, mADDRESS)
        VALUES ('aaa','1','홍길동','hong@naver.com','NOIMG.JPG','1998/12/12','강남');
    --(6)MEMBER 정보 수정
    UPDATE MEMBER SET mPW = '1',
                    mNAME = 'HONG',
                    mEMAIL = 'yi@naver.com',
                    mPHOTO = 'NOIMG.JPG',
                    mBIRTH = '1991/12/12',
                    mADDRESS = '서울'
        WHERE mId='aaa';
    --(7)MEMBER LIST(top-N)
    SELECT * FROM (SELECT ROWNUM RN, A.* FROM 
                        (SELECT * FROM MEMBER ORDER BY mRDATE DESC) A)
        WHERE RN BETWEEN 3 AND 5;
    --(8)MEMBER COUNT
    SELECT COUNT(*) mCNT FROM MEMBER;
    --(9)MEMBER 탈퇴
    DELETE FROM MEMBER WHERE mID = 'bbb';
--ADMIN
    --(1)로그인
    SELECT * FROM ADMIN WHERE aID='adminA' and mPW='1';
    --(2)aID로 aDTO가져오기
    SELECT * FROM ADMIN WHERE aID='adminA';
--FILEBOARD
    --(1)글개수
    SELECT COUNT(*) fCNT FROM FILEBOARD;
    --(2)글목록(최신글이 위로)
    SELECT * FROM FILEBOARD ORDER BY fGROUP DESC;
    --(3)글쓰기(원글)
    INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
        VALUES ( FBOARD_SEQ.NEXTVAL, 'aaa', '글제목1', '본문입니다\n금요일방가', NULL, FBOARD_SEQ.NEXTVAL, 0, 0, '192.168.10.3');
    --(4)fID로 fDTO가져오기
    SELECT * FROM FILEBOARD WHERE fID=1;
    --(5)fHIT 올리기
    UPDATE FILEBOARD SET fHIT = fHIT+1 WHERE fID=1;
    --(6)글 수정
    UPDATE FILEBOARD SET fTITLE = '수정된제목1',
                     fCONTENT = '수정된 본문입니다\n와우',
                     fFILENAME = 'NOTHING.JPG',
                     fIP = '127.0.0.1'
                 WHERE fID=1;
    --(7)글 삭제
    DELETE FROM FILEBOARD WHERE fID=1;
    --(8)페이징(top-N)
    SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP; -- 1단계
    SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A; -- 2단계
    SELECT *
        FROM (SELECT ROWNUM RN, A.* 
                FROM (SELECT * FROM FILEBOARD ORDER BY fGROUP DESC, fSTEP) A)
        WHERE RN BETWEEN 11 AND 20; -- 최종 TOP-N구문 
    --(9)글쓰기(답변)
        -- 답변글 저장전 해야할 STEP(엑셀의 ⓐ STEP)
        UPDATE FILEBOARD SET fSTEP = fSTEP+1 WHERE fGROUP=150 AND fSTEP>0;
    INSERT INTO FILEBOARD (fID, mID, fTITLE, fCONTENT, fFILENAME, fGROUP, fSTEP, fINDENT, fIP)
        VALUES (151, '답변자','글150-1','본문','NOTHING.JPG', 150, 1, 1, '192.168.1.12');
    --(10)글 상세보기
    SELECT * FROM FILEBOARD WHERE fID = 1;