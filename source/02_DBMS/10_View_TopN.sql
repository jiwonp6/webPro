<<<<<<< HEAD
--[X] VIEW, INLINE VIEW, TOP-N����
    --1. VIEW : ������ ���̺� (1)�ܼ��� (2)���պ�
    --(1)�ܼ��� : �ϳ��� ���̺�� ������ ��
        -- EMPv0�̶�� VIEW ���� �Ǵ� ���� ---> EMP���̺� �Ϻ� �ʵ带 ���� ������ ���̺�
SELECT * FROM USER_VIEWS;   --������ ��ųʸ� �� Ȯ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;    --DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ����
SELECT * FROM USER_VIEWS;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', 7369, SYSDATE, 40);   --VIEW�� INSERT
SELECT * FROM EMP;  --EMP ���̺��� INSERT��
UPDATE EMPv0 SET JOB = 'MANAGER' WHERE EMPNO =1111; --EMPv0�� UPDATE������ EMP���̺� UPDATE��
DELETE FROM EMPv0 WHERE EMPNO = '1111'; --EMPv0�� DELETE������ EMP���̺� DELETE��

        --EMPv0�̶�� VIEW : EMP���̺��� 30�� �μ��ุ
CREATE OR REPLACE VIEW EMPv0    --EMPv0 ������
    AS SELECT * 
        FROM EMP 
        WHERE DEPTNO = 30;
DESC EMPv0;
SELECT * FROM EMPv0;
SELECT * FROM EMP;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE,9000, 900, 30);    --30�� �μ� INSERT
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE-1,9000, 900, 40);  --40�� �μ� INSERT ---> �Է��� ���������� �������� ����
DELETE FROM EMPv0 WHERE EMPNO IN(1111,1112);    --30�� �μ��� 1111�� DELETE��
DELETE FROM EMP WHERE EMPNO=1112; 

        --EMPv0 VIEW ���� : ENAME, JOB, HIREDATE������ ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB, HIREDATE
        FROM EMP;
INSERT INTO EMPv0 VALUES ('ȫ', 'SALESMAN', SYSDATE);    --PRIMARY KEY�� EMPNO�� NULL�� �Ǿ� INSERT �Ұ���       
SELECT *
    FROM EMPv0;
    
COMMIT;

    --VIEW�� ���� ����   (1)���� ���� (2)�б�����
    --WITH CHECK OPTION�� ������ ��� ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����
    --WITH READ ONLY�� ������ ��� �б� ���� ��
        --EMPv0 : EMP ���̺��� 30�� �μ���
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * 
        FROM EMP 
        WHERE DEPTNO = 30
    WITH CHECK OPTION;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 30);   --30�� �μ��� INSERT
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE, 9000, 900, 40);   --WHERE ���ǿ� �������� ������ �Ұ�
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE ENAME = 'SMITH';    --20�� �μ� SMITH DELETE �� ��
DELETE FROM EMPv0 WHERE EMPNO = 1111;   --30�� �μ� DELETE
        --EMPv0 : �б����� ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO 
        FROM EMP
    WITH READ ONLY;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, 40);   --����(�б����� ��)
    --(2)���պ� : 2�� �̻��� ���̺�� ������ ���̰ų� ������ �ʵ�� �並 ���� ���. DML���� ���������� ���
    --�� 2�� �̻��� ���̺�� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'MANAGER', 'RESEARCH', 'DALLAS');  --���պ�� ���� �Ұ�
    --�� ������ �ʵ�� �� : �÷��� ��Ī(������, ����, _)�� �̿��Ͽ� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL*12 "YEAR_SAL"
        FROM EMP
        WHERE DEPTNO=10;
CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL)   --���� ����(�Ǵٸ� ��Ī���� ���)
    AS SELECT EMPNO, ENAME, SAL*12
        FROM EMP
        WHERE DEPTNO=10;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 2400); --���պ�� ���� �Ұ�
--EX. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ DEPTv1 �並 ����
CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), ROUND(AVG(SAL),2)
        FROM EMP
        GROUP BY DEPTNO;
SELECT * FROM DEPTv1;
--EX. ��å, �μ��� ������ EMPv0 �並 ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DNAME 
        FROM DEPT D, EMP E
        WHERE D.DEPTNO = E.DEPTNO
        ORDER BY DNAME;
SELECT * FROM EMPv0;   
INSERT INTO EMPv0 VALUES ('CLERK', 10);    --DISTINCT�� ������ ��� �б� ����

--2. INLINE VIEW : FROM�� ���� ���������� INLINE VIEW��� ��, FROM���� ���� ���������� VIEWó�� ����
    --EX.�޿��� 2000�� �ʰ��ϴ� ����� ��ձ޿�
SELECT AVG(SAL)
    FROM EMP
    WHERE SAL>2000;
SELECT AVG(SAL)
    FROM (SELECT SAL FROM EMP WHERE SAL>2000);
    
    --EX. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�(�������� �������� 24, 25)
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL >(SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
SELECT EMPNO, ENAME, SAL, AVGSAL
    FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL),2) "AVGSAL" FROM EMP GROUP BY DEPTNO) "A"
    WHERE E.DEPTNO = A.DEPTNO AND SAL>AVGSAL;   --INLINE VIEW
--3. TOP-N ����(TOP 1~10��/ TOP 11~20��/ TOP 6~10��) --��� �ߺ�X
--�� ROWNUM : FROM���� ���̺�κ��� ������ ����(������ ����������)
SELECT ROWNUM, ENAME
    FROM EMP 
    WHERE DEPTNO=20;   
SELECT ROWNUM, ENAME
    FROM EMP 
    WHERE DEPTNO=20
    ORDER BY ENAME;   --ORDER BY �ϸ� ���� ���׹��� ����(ROWNUM ������ ���� ����Ǳ� ����)
--���, �̸�, SAL (��ü�࿡ ����)
SELECT ROWNUM, ENAME, SAL 
    FROM EMP
    ORDER BY SAL DESC;  --ROWNUM�� ����� �ƴ� (���̺�κ��� ������ ����)
SELECT ROWNUM "RANK", ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC); --�̸� INLINE VIEW�� ������ ���ؼ� ������(ROWNUM�� ���)
--�Լ��� �̿��� RANK���(����...)   -- TOP-N����X
SELECT RANK() OVER(ORDER BY SAL DESC) RANK, 
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,  
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,   
    ENAME, SAL FROM EMP;

--SAL�������� 1~5��
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 1 AND 5;
--SAL�������� 6~10��
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10;  --������X
--�� TOP-N ���� [1�ܰ�]
SELECT ROWNUM RN, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
--�� TOP-N ���� [2�ܰ�-�ϼ�]
SELECT ROWNUM, RN, ENAME, SAL 
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC))
    WHERE RN BETWEEN 6 AND 10;
--�̸��� ���ĺ� ������� �����ؼ� 6~10��°���� ���(���, �̸�, ���, JOB, MGR, HIREDATE)
SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM(SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;

--�� �� ��������
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME
        FROM DEPT D, EMP E
        WHERE D.DEPTNO = E.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ� 
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME "WORKER", M.ENAME "MANAGER"
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO(+);
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ���� 
SELECT  DEPTNO, SUMSAL, ROWNUM RN
    FROM (SELECT  DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC);

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT *
    FROM(SELECT  DEPTNO, SUMSAL, ROWNUM RN FROM (SELECT  DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC))
    WHERE RN BETWEEN 2 AND 3;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM(SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 1 AND 5;

-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM(SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;
    
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM EMP ORDER BY HIREDATE DESC) "A")
    WHERE RN BETWEEN 6 AND 10;
=======
--[X] VIEW, INLINE VIEW, TOP-N����
    --1. VIEW : ������ ���̺� (1)�ܼ��� (2)���պ�
    --(1)�ܼ��� : �ϳ��� ���̺�� ������ ��
        -- EMPv0�̶�� VIEW ���� �Ǵ� ���� ---> EMP���̺� �Ϻ� �ʵ带 ���� ������ ���̺�
SELECT * FROM USER_VIEWS;   --������ ��ųʸ� �� Ȯ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, DEPTNO FROM EMP;    --DDL�� �����ϸ� ������ ��ųʸ� �ڵ� ����
SELECT * FROM USER_VIEWS;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'ITMANAGER', 7369, SYSDATE, 40);   --VIEW�� INSERT
SELECT * FROM EMP;  --EMP ���̺��� INSERT��
UPDATE EMPv0 SET JOB = 'MANAGER' WHERE EMPNO =1111; --EMPv0�� UPDATE������ EMP���̺� UPDATE��
DELETE FROM EMPv0 WHERE EMPNO = '1111'; --EMPv0�� DELETE������ EMP���̺� DELETE��

        --EMPv0�̶�� VIEW : EMP���̺��� 30�� �μ��ุ
CREATE OR REPLACE VIEW EMPv0    --EMPv0 ������
    AS SELECT * 
        FROM EMP 
        WHERE DEPTNO = 30;
DESC EMPv0;
SELECT * FROM EMPv0;
SELECT * FROM EMP;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE,9000, 900, 30);    --30�� �μ� INSERT
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE-1,9000, 900, 40);  --40�� �μ� INSERT ---> �Է��� ���������� �������� ����
DELETE FROM EMPv0 WHERE EMPNO IN(1111,1112);    --30�� �μ��� 1111�� DELETE��
DELETE FROM EMP WHERE EMPNO=1112; 

        --EMPv0 VIEW ���� : ENAME, JOB, HIREDATE������ ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT ENAME, JOB, HIREDATE
        FROM EMP;
INSERT INTO EMPv0 VALUES ('ȫ', 'SALESMAN', SYSDATE);    --PRIMARY KEY�� EMPNO�� NULL�� �Ǿ� INSERT �Ұ���       
SELECT *
    FROM EMPv0;
    
COMMIT;

    --VIEW�� ���� ����   (1)���� ���� (2)�б�����
    --WITH CHECK OPTION�� ������ ��� ���� ���ǿ� �ش�Ǵ� �����͸� ����, ����, ���� ����
    --WITH READ ONLY�� ������ ��� �б� ���� ��
        --EMPv0 : EMP ���̺��� 30�� �μ���
CREATE OR REPLACE VIEW EMPv0
    AS SELECT * 
        FROM EMP 
        WHERE DEPTNO = 30
    WITH CHECK OPTION;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, SYSDATE, 9000, 900, 30);   --30�� �μ��� INSERT
INSERT INTO EMPv0 VALUES (1112, '��', NULL, NULL, SYSDATE, 9000, 900, 40);   --WHERE ���ǿ� �������� ������ �Ұ�
SELECT * FROM EMP;
DELETE FROM EMPv0 WHERE ENAME = 'SMITH';    --20�� �μ� SMITH DELETE �� ��
DELETE FROM EMPv0 WHERE EMPNO = 1111;   --30�� �μ� DELETE
        --EMPv0 : �б����� ��
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, MGR, DEPTNO 
        FROM EMP
    WITH READ ONLY;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', NULL, NULL, 40);   --����(�б����� ��)
    --(2)���պ� : 2�� �̻��� ���̺�� ������ ���̰ų� ������ �ʵ�� �並 ���� ���. DML���� ���������� ���
    --�� 2�� �̻��� ���̺�� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, JOB, DNAME, LOC
        FROM EMP E, DEPT D
        WHERE E.DEPTNO = D.DEPTNO;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 'MANAGER', 'RESEARCH', 'DALLAS');  --���պ�� ���� �Ұ�
    --�� ������ �ʵ�� �� : �÷��� ��Ī(������, ����, _)�� �̿��Ͽ� �� ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT EMPNO, ENAME, SAL*12 "YEAR_SAL"
        FROM EMP
        WHERE DEPTNO=10;
CREATE OR REPLACE VIEW EMPv0 (EMPNO, ENAME, YEAR_SAL)   --���� ����(�Ǵٸ� ��Ī���� ���)
    AS SELECT EMPNO, ENAME, SAL*12
        FROM EMP
        WHERE DEPTNO=10;
SELECT * FROM EMPv0;
INSERT INTO EMPv0 VALUES (1111, 'ȫ', 2400); --���պ�� ���� �Ұ�
--EX. �μ���ȣ, �ּұ޿�, �ִ�޿�, �μ���ձ޿��� ������ DEPTv1 �並 ����
CREATE OR REPLACE VIEW DEPTv1 (DEPTNO, MINSAL, MAXSAL, AVGSAL)
    AS SELECT DEPTNO, MIN(SAL), MAX(SAL), ROUND(AVG(SAL),2)
        FROM EMP
        GROUP BY DEPTNO;
SELECT * FROM DEPTv1;
--EX. ��å, �μ��� ������ EMPv0 �並 ����
CREATE OR REPLACE VIEW EMPv0
    AS SELECT DISTINCT JOB, DNAME 
        FROM DEPT D, EMP E
        WHERE D.DEPTNO = E.DEPTNO
        ORDER BY DNAME;
SELECT * FROM EMPv0;   
INSERT INTO EMPv0 VALUES ('CLERK', 10);    --DISTINCT�� ������ ��� �б� ����

--2. INLINE VIEW : FROM�� ���� ���������� INLINE VIEW��� ��, FROM���� ���� ���������� VIEWó�� ����
    --EX.�޿��� 2000�� �ʰ��ϴ� ����� ��ձ޿�
SELECT AVG(SAL)
    FROM EMP
    WHERE SAL>2000;
SELECT AVG(SAL)
    FROM (SELECT SAL FROM EMP WHERE SAL>2000);
    
    --EX. �μ� ��� ���޺��� ���� ����� ���, �̸�, �޿�(�������� �������� 24, 25)
SELECT EMPNO, ENAME, SAL
    FROM EMP E
    WHERE SAL >(SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO);
SELECT EMPNO, ENAME, SAL, AVGSAL
    FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL),2) "AVGSAL" FROM EMP GROUP BY DEPTNO) "A"
    WHERE E.DEPTNO = A.DEPTNO AND SAL>AVGSAL;   --INLINE VIEW
--3. TOP-N ����(TOP 1~10��/ TOP 11~20��/ TOP 6~10��) --��� �ߺ�X
--�� ROWNUM : FROM���� ���̺�κ��� ������ ����(������ ����������)
SELECT ROWNUM, ENAME
    FROM EMP 
    WHERE DEPTNO=20;   
SELECT ROWNUM, ENAME
    FROM EMP 
    WHERE DEPTNO=20
    ORDER BY ENAME;   --ORDER BY �ϸ� ���� ���׹��� ����(ROWNUM ������ ���� ����Ǳ� ����)
--���, �̸�, SAL (��ü�࿡ ����)
SELECT ROWNUM, ENAME, SAL 
    FROM EMP
    ORDER BY SAL DESC;  --ROWNUM�� ����� �ƴ� (���̺�κ��� ������ ����)
SELECT ROWNUM "RANK", ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC); --�̸� INLINE VIEW�� ������ ���ؼ� ������(ROWNUM�� ���)
--�Լ��� �̿��� RANK���(����...)   -- TOP-N����X
SELECT RANK() OVER(ORDER BY SAL DESC) RANK, 
    DENSE_RANK() OVER(ORDER BY SAL DESC) DENSE_RANK,  
    ROW_NUMBER() OVER(ORDER BY SAL DESC) ROW_NUMBER,   
    ENAME, SAL FROM EMP;

--SAL�������� 1~5��
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 1 AND 5;
--SAL�������� 6~10��
SELECT ROWNUM, ENAME, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC)
    WHERE ROWNUM BETWEEN 6 AND 10;  --������X
--�� TOP-N ���� [1�ܰ�]
SELECT ROWNUM RN, ENAME, SAL 
    FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC);
--�� TOP-N ���� [2�ܰ�-�ϼ�]
SELECT ROWNUM, RN, ENAME, SAL 
    FROM (SELECT ROWNUM RN, ENAME, SAL FROM (SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC))
    WHERE RN BETWEEN 6 AND 10;
--�̸��� ���ĺ� ������� �����ؼ� 6~10��°���� ���(���, �̸�, ���, JOB, MGR, HIREDATE)
SELECT RN, ENAME, EMPNO, JOB, MGR, HIREDATE
    FROM (SELECT ROWNUM RN, ENAME, EMPNO, JOB, MGR, HIREDATE FROM(SELECT * FROM EMP ORDER BY ENAME))
    WHERE RN BETWEEN 6 AND 10;

--�� �� ��������
-- 1. �μ���� ������� ����ϴ� �뵵�� ��, DNAME_ENAME_VU �� �ۼ��Ͻÿ�
CREATE OR REPLACE VIEW DNAME_ENAME_VU
    AS SELECT DNAME, ENAME
        FROM DEPT D, EMP E
        WHERE D.DEPTNO = E.DEPTNO;
SELECT * FROM DNAME_ENAME_VU;

-- 2. ������ ���ӻ������ ����ϴ� �뵵�� ��,  WORKER_MANAGER_VU�� �ۼ��Ͻÿ� 
CREATE OR REPLACE VIEW WORKER_MANAGER_VU
    AS SELECT W.ENAME "WORKER", M.ENAME "MANAGER"
        FROM EMP W, EMP M
        WHERE W.MGR=M.EMPNO(+);
SELECT * FROM WORKER_MANAGER_VU;

-- 3. �μ��� �޿��հ� ����� ����Ͻÿ�(�μ���ȣ, �޿��հ�, ���). -- �л� ���� 
SELECT  DEPTNO, SUMSAL, ROWNUM RN
    FROM (SELECT  DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC);

-- 3-1. �μ��� �޿��հ� ����� 2~3���� �μ���ȣ, �޿��հ�, ����� ����Ͻÿ�.
SELECT *
    FROM(SELECT  DEPTNO, SUMSAL, ROWNUM RN FROM (SELECT  DEPTNO, SUM(SAL) "SUMSAL" FROM EMP GROUP BY DEPTNO ORDER BY SUMSAL DESC))
    WHERE RN BETWEEN 2 AND 3;

-- 4. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� ������ �����Ͻÿ�
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    ORDER BY HIREDATE DESC;

-- 5. ������̺��� ���, �����, �Ի����� �Ի����� �ֽſ��� ������ ��� 5���� ����Ͻÿ�
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM(SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 1 AND 5;

-- 6. ��� ���̺��� ���, �����, �Ի����� �ֽź��� ������ ������ 6��°�� ���� ������� 10��° ������� ���
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, EMPNO, ENAME, HIREDATE FROM(SELECT * FROM EMP ORDER BY HIREDATE DESC))
    WHERE RN BETWEEN 6 AND 10;
    
SELECT RN, EMPNO, ENAME, HIREDATE
    FROM (SELECT ROWNUM RN, A.* FROM(SELECT * FROM EMP ORDER BY HIREDATE DESC) "A")
    WHERE RN BETWEEN 6 AND 10;
>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
