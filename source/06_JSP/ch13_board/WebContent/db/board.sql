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
-- 1.글갯수
SELECT 
    COUNT(*) COUNT 
    FROM BOARD;
-- 2. 글목록(최신글이 위로)
SELECT * 
    FROM BOARD 
    ORDER BY NUM DESC;
SELECT * 
    FROM BOARD 
    ORDER BY REF DESC;    
-- 3.글쓰기(원글쓰기)
    -- 글쓰기 시 글번호 생성
    SELECT NVL(MAX(NUM),0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT,
                    EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '박박박', '제목1', '본문입니둥\n금요일방가', 
                    NULL, '111', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.10.3');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT,
                    EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '김김김', '제목2', '본문쓰', 
                    NULL, '111', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.10.3');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT,
                    EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM),0)+1 FROM BOARD), '이이이', '제목3', '본문입니둥', 
                    NULL, '111', (SELECT NVL(MAX(NUM),0)+1 FROM BOARD), 0, 0, '192.168.10.3');
-- 4.글번호로 글(DTO) 가져오기 = 상세보기
SELECT * FROM BOARD WHERE NUM=1;
-- 5.조회수 올리기
UPDATE BOARD 
    SET READCOUNT=READCOUNT+1 
    WHERE NUM=1;
-- 6.글 수정
UPDATE BOARD 
    SET SUBJECT='수정된제목1',
        CONTENT='수정된본문입니둥\n와우와우',
        EMAIL='mails@mail.com',
        PW='111',
        IP='127.0.0.1'
    WHERE NUM=1;
-- 7.글 삭제(비밀번호)
COMMIT;
DELETE FROM BOARD
    WHERE NUM=3 AND PW='111';
ROLLBACK;
-- 조회수 조작
UPDATE BOARD 
    SET READCOUNT = 12 
    WHERE NUM in (2, 3);
