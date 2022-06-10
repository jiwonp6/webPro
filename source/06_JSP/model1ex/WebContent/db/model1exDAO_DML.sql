-- DAO쿼리
-- 고객(CUSTOMER) 테이블 DAO
    -- 1. 회원가입시 CID 중복체크
    SELECT * FROM CUSTOMER WHERE CID='aaa';
    -- 2. 회원가입
    INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
        VALUES('abc', '111', '솜솜', '010-5555-5555', 'somsom@som.com', '경기도 안양시', 'w', '1999-09-09');
    -- 3. 로그인(CID/CPW)
    SELECT * FROM CUSTOMER WHERE CID='abc' AND CPW='111';
    -- 4. CID로 DTO 가져오기
    SELECT * FROM CUSTOMER WHERE CID='abc';
    -- 5. 회원정보 수정
    UPDATE CUSTOMER
        SET CPW = '111',
            CNAME = '솜솜탱',
            CTEL = '010-5858-5858',
            CEMAIL = 'somsomtang@som.com',
            CADDRESS = '경기도 안양시',
            CGENDER = 'w',
            CBIRTH = '1999-09-19'
        WHERE CID='abc';
    -- 6. 회원리스트 출력(첫화면 main.jsp에서 사용할 부분 -> top-N)
    SELECT * FROM (SELECT ROWNUM RN, CID, CPW, CEMAIL, CADDRESS 
                        FROM (SELECT * FROM CUSTOMER ORDER BY CID))
        WHERE RN BETWEEN 4 AND 6;
    -- 7. 등록된 회원수
    SELECT COUNT(*) TOTCNT FROM CUSTOMER;
-- 도서(BOOK) 테이블 DAO
    --1. 책 등록
    INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
        VALUES (BOOK_SEQ.NEXTVAL, '이것은 자바다', 30000, 'noImg.png', 'NOTHING.JPG', '책설명', 20);
    --2. 책 목록(전체 LIST) -- 신간도서 순으로 출력
    SELECT * FROM BOOK ORDER BY bRDATE DESC;
    --3. 책 목록(top-N구문)
    SELECT * 
        FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A)
        WHERE RN BETWEEN 2 AND 3;
    --4. 등록된 책 개수
    SELECT COUNT(*) CNT FROM BOOK;
    --5. 책 상세보기(bID로 dtO가져오기)
    SELECT * FROM BOOK
        WHERE bID = 1;
-- 파일첨부게시판(FILEBOARD) 테이블 DAO
    -- 1. 글목록(startRow~endRow)
    SELECT F.*
        FROM FILEBOARD F, CUSTOMER C 
        WHERE F.CID=C.CID
        ORDER BY FREF DESC, FRE_STEP;
    SELECT * 
        FROM (SELECT ROWNUM RN, A.*
                FROM (SELECT F.*, CNAME, CEMAIL
                        FROM FILEBOARD F, CUSTOMER C 
                        WHERE F.CID=C.CID
                        ORDER BY FREF DESC, FRE_STEP) A)
        WHERE RN BETWEEN 2 AND 3;
    -- 2. 등록된 글 수
    SELECT COUNT(*) COUNT FROM FILEBOARD;
    -- 3. 원글쓰기
    INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '글1', '본문1', NULL, '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '126.12.12.1');
    SELECT * FROM FILEBOARD WHERE FNUM = 10; -- 막 쓴 원글(10번)
    -- 4. 답변글 쓰기 전 step A   -- 10번글에 대한 답변글 쓰기 전작업
    UPDATE FILEBOARD
        SET FRE_STEP = FRE_STEP+1
        WHERE FREF = 10 AND FRE_STEP>0;
    -- 5. 답변 글 쓰기
    INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글1-1', '답', NULL, '111', 10, 1, 1, '192.168.10.10');
    SELECT * FROM FILEBOARD;
    -- 6. 글 상세보기(fNUM으로 dto가져오기)
    SELECT * FROM FILEBOARD WHERE FNUM = 10;
    -- 7. 조회수 올리기
    UPDATE FILEBOARD 
        SET FHIT = FHIT+1 
        WHERE FNUM='10';
    -- 8. 글 수정하기
    UPDATE FILEBOARD
        SET FSUBJECT = '수정된제목',
            FCONTENT = '수정된 본문',
            FFILENAME = NULL,
            FPW = '111',
            FIP = '192.168.10.30'
        WHERE FNUM = 2;
    -- 9. 글 삭제하기
    DELETE FROM FILEBOARD WHERE FNUM=1 AND FPW='111';
    COMMIT;
    

