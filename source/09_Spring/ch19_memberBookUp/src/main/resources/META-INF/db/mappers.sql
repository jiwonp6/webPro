--Query
--  Member 테이블(Member.xml | 회원가입, id 중복체크, id로 memberDto 가져오기, 정보수정, 회원탈퇴)
    -- 회원가입(joinMember)
    INSERT INTO MEMBER VALUES ('aaa','1','홍길동','yisy0703@naver.com','12345','서울');
    -- id 중복체크(idConfirm)
    SELECT * FROM MEMBER WHERE mID = 'aaa';
    -- id로 memberDto 가져오기(getDetailMember)
    SELECT * FROM MEMBER WHERE mID = 'aaa';
    -- 정보수정(modifyMember)
    UPDATE MEMBER SET mPW = '111',
                      mNAME='박박박',
                      mMAIL='park65758636@gmail.com',
                      mPOST='12345',
                      mADDR='서울'
                WHERE mID='aaa';
    -- 회원탈퇴(drawalMember)
    DELETE FROM MEMBER WHERE mID='aaa';
commit;
-- Book 테이블(Book.xml | 신규순list(페이징X), 도서List(책이름순, 페이징O), 책개수, 상세보기, 도서등록, 도서수정)
    -- 신규순list(페이징X) (mainList)
    SELECT ROWNUM RM, A.* FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A;
    -- 도서List(책이름순, 페이징O) (bookList)
    SELECT * 
        FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOOK ORDER BY bTITLE) A) 
        WHERE RN BETWEEN 2 AND 4;
    -- 도서 검색
    SELECT *
        
    -- 책개수 (totCntBook)
    SELECT COUNT(*) FROM BOOK;
    -- 상세보기 (getDetailBook)
    SELECT * FROM BOOK WHERE bNUM=2;
    -- 도서등록 (registerBook)
    INSERT INTO BOOK VALUES
        (BOOK_SQ.NEXTVAL, 'Spring','김스프',sysdate, 'noImg.png','noImg.png','좋은스프링책');
    -- 도서수정 (modifyBook)
    UPDATE BOOK SET bTITLE='JSP',
                    bWRITER='박지성',
                    bRDATE='2022-06-26',
                    bIMG1='noImg.png',
                    bIMG2='noImg.png',
                    bINFO='멋있는 JSP'
                WHERE bNUM='2';
    -- 책삭제(deleteBook)
    DELETE FROM BOOK WHERE bNUM='';
commit;