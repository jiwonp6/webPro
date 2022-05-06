-- 테이블&시퀀스 삭제
DROP TABLE CUSTOMER;    
DROP TABLE CUS_LEVEL;   --참조하는 테이블이 있을 경우 삭제 불가(cf. CASCADE CONSTRAINTS;)
DROP SEQUENCE CUSTOMER_SEQ;
-- 테이블&시퀀스 생성
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(1,0),    --1자리, 소수점0자리
    LEVELNAME VARCHAR2(20),
    LOW NUMBER(9,0),
    HIGH NUMBER(9,0),
    PRIMARY KEY(LEVELNO)
);
CREATE SEQUENCE CUSTOMER_SEQ 
    MAXVALUE 999999
    NOCACHE -- 끄고나면 20부터 시작되지 않게
    NOCYCLE;
CREATE TABLE CUSTOMER(
    cID NUMBER(6,0),
    cTEL VARCHAR2(20),
    cNAME VARCHAR2(30),
    cPOINT NUMBER(9,0) DEFAULT 1000,
    cAMOUNT NUMBER(9,0) DEFAULT 0,
    LEVELNO NUMBER(1,0) DEFAULT 1,
    PRIMARY KEY(cID),
    FOREIGN KEY(LEVELNO) REFERENCES CUS_LEVEL(LEVELNO)
);
-- 더미데이터 입력(CUS_LEVEL)
INSERT INTO CUS_LEVEL VALUES(1, 'NORMAL', 0, 999999);
INSERT INTO CUS_LEVEL VALUES(2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES(3, 'GOLD', 2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES(4, 'VIP', 3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES(5, 'VVIP', 4000000, 999999999);    --마지막 끝이 크기와 같게
SELECT * FROM CUS_LEVEL;
-- 더미데이터 입력(CUSTOMER)
INSERT INTO CUSTOMER (cID, cTEL, cNAME) 
    VALUES(CUSTOMER_SEQ.NEXTVAL, '010-9999-9999', '홍길동');
INSERT INTO CUSTOMER 
    VALUES(CUSTOMER_SEQ.NEXTVAL, '010-8888-9999', '홍길동', 0, 4000000, 5);
INSERT INTO CUSTOMER 
    VALUES(CUSTOMER_SEQ.NEXTVAL, '010-7777-7777', '신길동', 0, 100000, 1);
--프로그램에 필요한 QUERY
--0.레벨이름 검색 : Vector<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL;
--1.아이디검색 : public CustomerDto cIdGetCustomer(int cid)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND cID = 1;
--2.폰 마지막4자리검색(full도 가능) : ArrayList<CustomerDto> cTelGetCustomer(String cTel)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND cTEL LIKE '%'||'9999'
    ORDER BY cAMOUNT DESC;
--3.고객이름검색 : ArrayList<CustomerDto> cNameGetCustomer(String cName)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND cNAME = '홍길동'
    ORDER BY cAMOUNT DESC;    
--4.포인트로만 구매 : int buyWithPoint(int cid, int camount)
    --ex. 1(id)이 100원짜리 구매)
UPDATE CUSTOMER
    SET cPOINT = cPOINT-100,
        cAMOUNT = CAMOUNT +100
    WHERE cID = 1;
--5.물품구매 : int buy(int cid, int camount)
    --물품구매 update에는 cpoint, camount, levelNo가 수정
    --5-1. cpoint, camount 수정
UPDATE CUSTOMER
    SET cPOINT = cPOINT + (1000000*0.05),
        cAMOUNT = cAMOUNT + 1000000
    WHERE cID = 1;
SELECT * FROM CUSTOMER;
    --5-2. levelNo 수정
SELECT cID, cNAME, C.LEVELNO 현레벨, L.LEVELNO 수정될레벨
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE cAMOUNT BETWEEN LOW AND HIGH AND cID=1;
-- =>    
UPDATE CUSTOMER
    SET LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L 
                    WHERE cAMOUNT BETWEEN LOW AND HIGH AND cID=1)
    WHERE cID =1;  
    --5-1.과 5-2.를 한꺼번에
UPDATE CUSTOMER
    SET cPOINT = cPOINT + (1000000*0.05),
        cAMOUNT = cAMOUNT + 1000000,
        LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L 
                    WHERE cAMOUNT + 1000000 BETWEEN LOW AND HIGH AND cID=1)
    WHERE cID =1;   --DAO에 들어갈 QURERY
SELECT * FROM CUSTOMER;
--6.등급별출력 : ArrayList<CustomerDto> levelNameGetCustomer(String levelName)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = 'NORMAL'
    ORDER BY cAMOUNT DESC; 
--7.전체출력 : ArrayList<CustomerDto> getCustomers()
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
    SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO
    ORDER BY cAMOUNT DESC; 
--8.회원가입 : int insertCustomer(CustomerDto dto)
    --int insertCustomer(String ctel, String cname)
INSERT INTO CUSTOMER (cID, cTEL, cNAME) VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666', '유길동');
--9.번호수정 : int updateCustomer(int cid, String ctel)
UPDATE CUSTOMER
    SET cTEL = '010-5555-5555'
    WHERE cID=4;
--10.회원탈퇴 : int deleteCustomer(String ctel)
DELETE 
    FROM CUSTOMER
    WHERE cTEL = '010-5555-5555';
COMMIT;
select * from customer;










