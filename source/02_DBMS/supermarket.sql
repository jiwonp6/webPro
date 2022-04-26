-- TABLE생성
DROP TABLE CUS_LEVELS;
CREATE TABLE CUS_LEVELS(
    LEVELNAME VARCHAR2(20) PRIMARY KEY,
    LOW NUMBER(10),
    HIGH NUMBER(10)
);
INSERT INTO CUS_LEVELS VALUES ('GREEN', 0, 200000);
INSERT INTO CUS_LEVELS VALUES ('SILVER', 200001, 1000000);
INSERT INTO CUS_LEVELS VALUES ('GOLD', 1000001, 2000000);
INSERT INTO CUS_LEVELS VALUES ('VVIP', 2000001, 9999999999);

DROP SEQUENCE SUP_SEQ;
CREATE SEQUENCE SUP_SEQ
    MAXVALUE 9999
    NOCACHE 
    NOCYCLE;
DROP TABLE SUPERMARKET;
CREATE TABLE SUPERMARKET(
    ID NUMBER(6) PRIMARY KEY,
    cTEL VARCHAR2(20),
    cNAME VARCHAR2(30),
    cPOINT NUMBER(10) DEFAULT 1000,
    cAMOUNT NUMBER(10) DEFAULT 0,
    LEVELNAME VARCHAR2(20) DEFAULT 'GREEN'
);
INSERT INTO SUPERMARKET VALUES(SUP_SEQ.NEXTVAL, '010-9999-9999', '강가가', 1035, 35000, 'GREEN');
INSERT INTO SUPERMARKET VALUES(SUP_SEQ.NEXTVAL, '010-8888-8888', '나나', 2000, 80000, 'GREEN');
INSERT INTO SUPERMARKET VALUES(SUP_SEQ.NEXTVAL, '010-7777-7777', '다다당', 2000, 80000, 'GREEN');
INSERT INTO SUPERMARKET VALUES(SUP_SEQ.NEXTVAL, '010-6666-6666', '라라', 2000, 3000000, 'VVIP');
SELECT * 
    FROM SUPERMARKET;
-- 0. 레벨이름들 검색 : public Vector<String> getLevelNames()
SELECT LEVELNAME 
    FROM CUS_LEVELS 
    ORDER BY HIGH DESC;
-- 1. cId로 검색 : public CustomerDto cIdGetCustomer(int cId)
SELECT * 
    FROM SUPERMARKET
    WHERE ID = 5;

-- 2. 폰뒤4자리(FULL) 검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
-- public ArrayList<CustomerDto> cTelGetCustomers(String cTel);
SELECT * 
    FROM SUPERMARKET
    WHERE cTEL LIKE '%9090';
-- SUBSTR(cTEL,-4)='9090' OR cTEL = '010-9090-9090'
-- 3. 고객이름검색 - CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을 위한 쓸 돈
-- public ArrayList<CustomerDto> cNameGetCustomers(String cName);
SELECT *
    FROM SUPERMARKET
    WHERE cNAME = '강가가';

-- 4. 포인트로만 구매(1000원짜리를 포인트로만 구매) : public int buyWithPoint(int cAmount, int cId)
UPDATE SUPERMARKET
    SET cPOINT = cPOINT-100
    WHERE ID = 5;
-- 5. 물품구매 (100000원짜리를 구매할 경우. 포인트는 구매금액의 5%)
-- 물품구매시 UPDATE 2회 필요(구매누적금액 UPDATE와 LEVELNO UPDATE)
-- public int buy(int cAmount, int cId)
SELECT * FROM SUPERMARKET;
UPDATE SUPERMARKET
    SET cAMOUNT = cAMOUNT + 100000,
        cPOINT = cPOINT + 100000*0.05
    WHERE ID = 5;
UPDATE SUPERMARKET
    SET LEVELNAME = (SELECT CL.LEVELNAME FROM SUPERMARKET S, CUS_LEVELS CL WHERE S.cAMOUNT BETWEEN CL.LOW AND CL.HIGH AND ID=5)
    WHERE ID=5;
-- 6. 등급별출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈  
-- public ArrayList<CustomerDto> levelNameGetCustomers(String levelName)
SELECT S.*,(SELECT HIGH-CAMOUNT+1 FROM SUPERMARKET WHERE ID=S.ID AND LEVELNAME !='VVIP') forLEVELUP
    FROM SUPERMARKET S, CUS_LEVELS L
    WHERE S.LEVELNAME=L.LEVELNAME AND S.LEVELNAME = 'GREEN';
-- 7.전체출력 - CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, 레벨업을위한쓸돈 
-- public ArrayList<CustomerDto> getCustomers()
SELECT S.*,(SELECT HIGH-CAMOUNT+1 FROM SUPERMARKET WHERE ID=S.ID AND LEVELNAME !='VVIP') forLEVELUP
    FROM SUPERMARKET S, CUS_LEVELS L
    WHERE S.LEVELNAME=L.LEVELNAME;
    
SELECT S2.*, A.PLUSMONEY
    FROM SUPERMARKET S2, (SELECT CL.HIGH+1-S.cAMOUNT PLUSMONEY FROM SUPERMARKET S, CUS_LEVELS CL WHERE S.LEVELNAME = CL.LEVELNAME) A
    WHERE S2.ID = 5;
    
-- 8. 회원가입(고객전화와 고객이름은 입력받아 INSERT)
-- public int insertCustomer(String cTel, String cName)
INSERT INTO SUPERMARKET (ID, cTEL, cNAME) VALUES (SUP_SEQ.NEXTVAL, '010-7777-7777', '다다당');
-- 9. 번호수정 : public int updateCustomer(String cTel, int cId)
UPDATE SUPERMARKET
    SET cTEL = '010-9090-9090'
    WHERE ID = 5;
-- 10. 회원탈퇴 : public int deleteCustomer(String cTel)
DELETE FROM SUPERMARKET WHERE ID = '7';