--[VII] DDL, DML, DCL
--SQL = DDL(테이블 생성, 테이블 삭제, 테이블 구조변경, 테이블 모든 데이터 제거)
--      DML(SELECT(데이터 검색), INSERT(데이터 추가), UPDATE(데이터 수정), DELETE(데이터 삭제))
--      DCL(사용자계정생성, 사용자권한부여, 권한박탈, 사용자계정삭제, 트랜잭션 명령어 = ROLLBACK, COMMIT)

--☆1.DDL
--1) 테이블 생성(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),           --도서번호
    BOOKNAME VARCHAR2(300),     --책이름(BYTE)
    PUBLISHER VARCHAR2(300),    --출판사
    RDATE DATE,                 --출판일
    PRICE NUMBER(8),            --가격
    PRIMARY KEY(BOOKID) );      --BOOKID는 유일해야 하므로

SELECT * FROM BOOK;