-- ���̺�&������ ����
DROP TABLE CUSTOMER;    
DROP TABLE CUS_LEVEL;   --�����ϴ� ���̺��� ���� ��� ���� �Ұ�(cf. CASCADE CONSTRAINTS;)
DROP SEQUENCE CUSTOMER_SEQ;
-- ���̺�&������ ����
CREATE TABLE CUS_LEVEL(
    LEVELNO NUMBER(1,0),    --1�ڸ�, �Ҽ���0�ڸ�
    LEVELNAME VARCHAR2(20),
    LOW NUMBER(9,0),
    HIGH NUMBER(9,0),
    PRIMARY KEY(LEVELNO)
);
CREATE SEQUENCE CUSTOMER_SEQ 
    MAXVALUE 999999
    NOCACHE -- ������ 20���� ���۵��� �ʰ�
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
-- ���̵����� �Է�(CUS_LEVEL)
INSERT INTO CUS_LEVEL VALUES(1, 'NORMAL', 0, 999999);
INSERT INTO CUS_LEVEL VALUES(2, 'SILVER', 1000000, 1999999);
INSERT INTO CUS_LEVEL VALUES(3, 'GOLD', 2000000, 2999999);
INSERT INTO CUS_LEVEL VALUES(4, 'VIP', 3000000, 3999999);
INSERT INTO CUS_LEVEL VALUES(5, 'VVIP', 4000000, 999999999);    --������ ���� ũ��� ����
SELECT * FROM CUS_LEVEL;
-- ���̵����� �Է�(CUSTOMER)
INSERT INTO CUSTOMER (cID, cTEL, cNAME) 
    VALUES(CUSTOMER_SEQ.NEXTVAL, '010-9999-9999', 'ȫ�浿');
INSERT INTO CUSTOMER 
    VALUES(CUSTOMER_SEQ.NEXTVAL, '010-8888-9999', 'ȫ�浿', 0, 4000000, 5);
INSERT INTO CUSTOMER 
    VALUES(CUSTOMER_SEQ.NEXTVAL, '010-7777-7777', '�ű浿', 0, 100000, 1);
--���α׷��� �ʿ��� QUERY
--0.�����̸� �˻� : Vector<String> getLevelNames()
SELECT LEVELNAME FROM CUS_LEVEL;
--1.���̵�˻� : public CustomerDto cIdGetCustomer(int cid)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND cID = 1;
--2.�� ������4�ڸ��˻�(full�� ����) : ArrayList<CustomerDto> cTelGetCustomer(String cTel)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND cTEL LIKE '%'||'9999'
    ORDER BY cAMOUNT DESC;
--3.���̸��˻� : ArrayList<CustomerDto> cNameGetCustomer(String cName)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND cNAME = 'ȫ�浿'
    ORDER BY cAMOUNT DESC;    
--4.����Ʈ�θ� ���� : int buyWithPoint(int cid, int camount)
    --ex. 1(id)�� 100��¥�� ����)
UPDATE CUSTOMER
    SET cPOINT = cPOINT-100,
        cAMOUNT = CAMOUNT +100
    WHERE cID = 1;
--5.��ǰ���� : int buy(int cid, int camount)
    --��ǰ���� update���� cpoint, camount, levelNo�� ����
    --5-1. cpoint, camount ����
UPDATE CUSTOMER
    SET cPOINT = cPOINT + (1000000*0.05),
        cAMOUNT = cAMOUNT + 1000000
    WHERE cID = 1;
SELECT * FROM CUSTOMER;
    --5-2. levelNo ����
SELECT cID, cNAME, C.LEVELNO ������, L.LEVELNO �����ɷ���
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE cAMOUNT BETWEEN LOW AND HIGH AND cID=1;
-- =>    
UPDATE CUSTOMER
    SET LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L 
                    WHERE cAMOUNT BETWEEN LOW AND HIGH AND cID=1)
    WHERE cID =1;  
    --5-1.�� 5-2.�� �Ѳ�����
UPDATE CUSTOMER
    SET cPOINT = cPOINT + (1000000*0.05),
        cAMOUNT = cAMOUNT + 1000000,
        LEVELNO = (SELECT L.LEVELNO 
                    FROM CUSTOMER C, CUS_LEVEL L 
                    WHERE cAMOUNT + 1000000 BETWEEN LOW AND HIGH AND cID=1)
    WHERE cID =1;   --DAO�� �� QURERY
SELECT * FROM CUSTOMER;
--6.��޺���� : ArrayList<CustomerDto> levelNameGetCustomer(String levelName)
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO AND LEVELNAME = 'NORMAL'
    ORDER BY cAMOUNT DESC; 
--7.��ü��� : ArrayList<CustomerDto> getCustomers()
    --cid, ctel, cname, cpoint, camount, levelname, forlevelup
    SELECT cID, cTEL, cNAME, cPOINT, cAMOUNT, LEVELNAME, 
        (SELECT HIGH+1-cAMOUNT FROM CUSTOMER WHERE cID=C.cID AND LEVELNO != 5) FORLEVELUP
    FROM CUSTOMER C, CUS_LEVEL L
    WHERE C.LEVELNO = L.LEVELNO
    ORDER BY cAMOUNT DESC; 
--8.ȸ������ : int insertCustomer(CustomerDto dto)
    --int insertCustomer(String ctel, String cname)
INSERT INTO CUSTOMER (cID, cTEL, cNAME) VALUES (CUSTOMER_SEQ.NEXTVAL, '010-6666-6666', '���浿');
--9.��ȣ���� : int updateCustomer(int cid, String ctel)
UPDATE CUSTOMER
    SET cTEL = '010-5555-5555'
    WHERE cID=4;
--10.ȸ��Ż�� : int deleteCustomer(String ctel)
DELETE 
    FROM CUSTOMER
    WHERE cTEL = '010-5555-5555';
COMMIT;
select * from customer;










