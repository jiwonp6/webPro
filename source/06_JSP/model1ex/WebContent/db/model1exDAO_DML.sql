-- DAO쿼리
-- 고객(CUSTOMER) ?��?���? DAO
    -- 1. ?��?���??��?�� CID 중복체크
    SELECT * FROM CUSTOMER WHERE CID='aaa';
    -- 2. ?��?���??��
    INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CGENDER, CBIRTH)
        VALUES('abc', '111', '?��?��', '010-5555-5555', 'somsom@som.com', '경기?�� ?��?��?��', 'w', '1999-09-09');
    -- 3. 로그?��(CID/CPW)
    SELECT * FROM CUSTOMER WHERE CID='abc' AND CPW='111';
    -- 4. CID�? DTO �??��?���?
    SELECT * FROM CUSTOMER WHERE CID='abc';
    -- 5. ?��?��?���? ?��?��
    UPDATE CUSTOMER
        SET CPW = '111',
            CNAME = '?��?��?��',
            CTEL = '010-5858-5858',
            CEMAIL = 'somsomtang@som.com',
            CADDRESS = '경기?�� ?��?��?��',
            CGENDER = 'w',
            CBIRTH = '1999-09-19'
        WHERE CID='abc';
    -- 6. ?��?��리스?�� 출력(첫화�? main.jsp?��?�� ?��?��?�� �?�? -> top-N)
    SELECT * FROM (SELECT ROWNUM RN, CID, CPW, CEMAIL, CADDRESS 
                        FROM (SELECT * FROM CUSTOMER ORDER BY CID))
        WHERE RN BETWEEN 4 AND 6;
    -- 7. ?��록된 ?��?��?��
    SELECT COUNT(*) TOTCNT FROM CUSTOMER;
-- ?��?��(BOOK) ?��?���? DAO
    --1. �? ?���?
    INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
        VALUES (BOOK_SEQ.NEXTVAL, '?��것�? ?��바다', 30000, 'noImg.png', 'NOTHING.JPG', '책설�?', 20);
    --2. �? 목록(?���? LIST) -- ?��간도?�� ?��?���? 출력
    SELECT * FROM BOOK ORDER BY bRDATE DESC;
    --3. �? 목록(top-N구문)
    SELECT * 
        FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A)
        WHERE RN BETWEEN 2 AND 3;
    --4. ?��록된 �? 개수
    SELECT COUNT(*) CNT FROM BOOK;
    --5. �? ?��?��보기(bID�? dtO�??��?���?)
    SELECT * FROM BOOK
        WHERE bID = 1;
-- ?��?��첨�?게시?��(FILEBOARD) ?��?���? DAO
    -- 1. �?목록(startRow~endRow)
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
    -- 2. ?��록된 �? ?��
    SELECT COUNT(*) COUNT FROM FILEBOARD;
    -- 3. ?���??���?
    INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'aaa', '�?1', '본문1', NULL, '111', FILEBOARD_SEQ.CURRVAL, 0, 0, '126.12.12.1');
    SELECT * FROM FILEBOARD WHERE FNUM = 10; -- �? ?�� ?���?(10�?)
    -- 4. ?���?�? ?���? ?�� step A   -- 10번�??�� ???�� ?���?�? ?���? ?��?��?��
    UPDATE FILEBOARD
        SET FRE_STEP = FRE_STEP+1
        WHERE FREF = 10 AND FRE_STEP>0;
    -- 5. 답글쓰기
    INSERT INTO FILEBOARD (FNUM, CID, FSUBJECT, FCONTENT, FFILENAME, FPW, FREF, FRE_STEP, FRE_LEVEL, FIP)
        VALUES (FILEBOARD_SEQ.NEXTVAL, 'bbb', '글1-1', '글글글', NULL, '111', 10, 1, 1, '192.168.10.10');
    SELECT * FROM FILEBOARD;
    -- 6. 글 상세보기(fnum으로 dto가져오기)
    SELECT * FROM FILEBOARD WHERE FNUM = 10;
    SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID = C.CID AND FNUM=2;
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
    select * from fileboard;
    
    select * from fileboard where fref=435;

