-- 테이블 drop & create
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY,    --글번호
    WRITER VARCHAR2(30) NOT NULL,   --글작성자
    SUBJECT VARCHAR2(100) NOT NULL, --글제목
    CONTENT VARCHAR2(4000) NOT NULL,    --글내용
    EMAIL VARCHAR2(30), --작성자 이메일
    READCOUNT NUMBER(5) DEFAULT 0,   --글 HIT수(조회수)
    PW VARCHAR2(20) NOT NULL,   --글 삭제시 쓸 비밀번호
    REF NUMBER(5) NOT NULL, --글그룹(원글일 경우, 글번호로/답변글일 경우 원글의 글번호로)
    RE_STEP NUMBER NOT NULL,    --그룹내 출력 순서(원글 0)
    RE_INDENT NUMBER NOT NULL,  --글 LIST 출력시 제목 들여쓰기 정도(원글 0)
    IP VARCHAR(20) NOT NULL,    --글작성시 컴퓨터 IP주소
    RDATE DATE DEFAULT SYSDATE NOT NULL --글쓴 시점(날짜 + 시간)
);
SELECT * FROM BOARD;
-- 