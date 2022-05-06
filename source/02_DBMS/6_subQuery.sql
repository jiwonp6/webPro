--[VI]SUB QUERY : QUERY�ȿ� QUERY�� ����
--SELECT �ʵ�1, �ʵ�2, (SELECT �ʵ� FROM ���̺� WHERE ����)
--  FROM ���̺�
--  WHERE ����

--��1.���� ���� ����(�ʿ伺)
-- �޿��� ���� ���� �޴� ����� ���, �̸�, ��å, �޿�
SELECT MAX(SAL) 
    FROM EMP;
SELECT EMPNO, MAX(SAL) 
    FROM EMP
    GROUP BY EMPNO; --������
SELECT MAX(SAL) --��������
    FROM EMP;
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) 
                    FROM EMP);  --��������(���������� ��ȣ�� �����־����)
--���������� ����(1) ������ ��������(�������� ����� ������) : =, >, >=, <, <=, !=
    --EX.SCOTT�� �ٹ��ϴ� �μ��̸� ���
    --��������
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';   --����
SELECT DNAME FROM DEPT WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');   --����
    --JOIN�̿�
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO= D.DEPTNO AND ENAME ='SCOTT';
--���������� ����(2) ������ ��������(�������� ��� 2���̻�) : IN, ANY, EXITSTS
    --EX.JOB�� MANAGER�� ����� �μ��̸�
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';   --��������
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');
--��2. ������ ��������
    --�Ʒ� ���� ��ó��
    
SELECT E.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME = 'SCOTT';
INSERT INTO DEPT VALUES(50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'ȫ�浿', 50);
SELECT*FROM DEPT;
SELECT*FROM EMP WHERE EMPNO=9999;
    --EX1.SCOTT�� ���� �μ��� ����� �̸��� �޿�
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';--����
SELECT ENAME, SAL FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT') AND ENAME !='SCOTT';  --����(���길 �����ų�� F9Ű)
    --EX2  .SCOTT�� ���� �ٹ����� ����� �̸��� �޿�
SELECT LOC FROM EMP E, DEPT D WHERE ENAME = 'SCOTT' AND E.DEPTNO = D.DEPTNO;   --����
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE ENAME = 'SCOTT' AND E.DEPTNO = D.DEPTNO)
        AND ENAME!='SCOTT';
ROLLBACK;   --������ �߰� ���(DML-�������߰�, ����, ������ ���)
SELECT * FROM EMP WHERE EMPNO=9999;
SELECT * FROM DEPT;
    --EX.�����Ի��ϰ� �ּ��Ի��� ����̸�
SELECT MIN(HIREDATE) FROM EMP;  --������ ��������
SELECT HIREDATE "FIRST", ENAME "FIRSTMAN" FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);   --��������
    --EX.�ֱ��Ի��ϰ� �ֱ��Ի��� ����̸�
SELECT MAX(HIREDATE) FROM EMP;  --������ ��������
SELECT HIREDATE "LAST", ENAME "LASTMAN" FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);   --��������
    --EX.�����Ի��ϰ� �����Ի��� ����̸�, �ֱ��Ի��ϰ� �ֱ��Ի��� ��� �̸�
SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    --EX.SCOTT�� ���� �μ��� �ٹ��ϴ� ������� �޿���
SELECT DEPTNO
    FROM EMP
    WHERE ENAME='SCOTT';    --����
SELECT SUM(SAL)
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME='SCOTT');   --����
    --EX.SCOTT�� ������ ��å(JOB)�� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE JOB = (SELECT JOB
                    FROM EMP
                    WHERE ENAME = 'SCOTT')
        AND ENAME != 'SCOTT';
    --EX.DALLAS���� �ٹ��ϴ� ����� �̸�, �μ���ȣ
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM DEPT
                    WHERE LOC = 'DALLAS');
    --EX.'KING'�� ���ӻ���� ����� �̸��� �޿�
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                        FROM EMP
                        WHERE ENAME = 'KING');
SELECT W.ENAME, W.SAL
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME = 'KING';--SELF JOIN�̿�

    --EX1. ��� �޿� ���Ϸ� �޴� ����� �̸��� �޿��� ���
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL) FROM EMP);
    --EX2.��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿� ���
SELECT ENAME, SAL, (SELECT ROUND(AVG(SAL),2) FROM EMP) "��ձ޿�"
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL) FROM EMP);
    --EX3.��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��հ� ���̸� ���
SELECT ENAME, SAL, ROUND(ABS((SELECT AVG(SAL) FROM EMP)-SAL), 1) "IDEF"    --ABS : ����
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL) FROM EMP);
    
--������ ���߿� �������� : SCOTT�̶� JOB�� DEPTNO�� ���� ������ ��� �ʵ� ���
SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT';  --��������(������ ���߿�)
SELECT * 
    FROM EMP
    WHERE (JOB, DEPTNO) = (SELECT JOB, DEPTNO FROM EMP WHERE ENAME = 'SCOTT') AND ENAME<> 'SCOTT';
    
-- �� �� ��������-1
--1. ������̺��� ���� ���� �Ի��� ����� �̸�, �޿�, �Ի���
SELECT ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);
    
-- 2. ȸ�翡�� ���� �޿��� ���� ����� �̸�, �޿�
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL = (SELECT MIN(SAL) FROM EMP);
    
-- 3. ȸ�� ��պ��� �޿��� ���� �޴� ����� �̸�, �޿�, �μ��ڵ�
SELECT ENAME, SAL, DEPTNO
    FROM EMP
    WHERE SAL >=(SELECT AVG(SAL) FROM EMP);

--4. ȸ�� ��� ������ �޿��� �޴� ����� �̸�, �޿�, �μ���
SELECT ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL <= (SELECT AVG(SAL) FROM EMP);

--5. SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���
SELECT ENAME, E.SAL, HIREDATE, GRADE
    FROM EMP E, SALGRADE
    WHERE E.SAL BETWEEN LOSAL AND HISAL AND HIREDATE <(SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT');

--6. 5��(SCOTT���� ���� �Ի��� ����� �̸�, �޿�, �Ի���, �޿� ���)�� �μ��� �߰��ϰ� �޿��� ū �� ����
SELECT ENAME, DNAME, E.SAL, HIREDATE, GRADE
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.SAL BETWEEN LOSAL AND HISAL AND HIREDATE <(SELECT HIREDATE FROM EMP WHERE ENAME = 'SCOTT')
    ORDER BY E.SAL;

--7. BLAKE ���� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL > (SELECT SAL FROM EMP WHERE ENAME = 'BLAKE');

--8. MILLER���� �ʰ� �Ի��� ����� ���, �̸�, �Ի���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE HIREDATE > (SELECT HIREDATE FROM EMP WHERE ENAME = 'MILLER');

--9. �����ü ��� �޿����� �޿��� ���� ������� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE SAL >= ( SELECT AVG(SAL) FROM EMP);

--10. CLARK�� ���� �μ���ȣ�̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'CLARK') AND SAL >(SELECT SAL FROM EMP WHERE EMPNO = '7698');

--11.  �����ȭ. CLARK�� ���� �μ����̸�, ����� 7698�� ������ �޿����� ���� �޿��� �޴� ����� ���, �̸�, �޿�
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = (SELECT DNAME FROM EMP E1, DEPT D1  WHERE ENAME = 'CLARK' AND E1.DEPTNO = D1.DEPTNO) 
        AND SAL >(SELECT SAL FROM EMP WHERE EMPNO = '7698');

--12. BLAKE�� ���� �μ��� �ִ� ��� ����� �̸��� �Ի�����
SELECT ENAME, HIREDATE
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'BLAKE');

--13. ��� �޿� �̻��� �޴� ��� �������� ���ؼ� �����ȣ�� �̸� (�� �޿��� ���� ������ ���)
SELECT EMPNO, ENAME
    FROM EMP E, DEPT D
    WHERE SAL > (SELECT AVG(SAL) FROM EMP) AND D.DEPTNO = E.DEPTNO
    ORDER BY SAL DESC;
    
--��3. ������ �������� : IN, ALL, ANY=SOME, EXISTS    
    --(1) IN : �������� ��� �� �ϳ��� ��ġ�ϸ� ��
    --EX. �μ����� �Ի����� ���� ���� ����� �̸�, �Ի���, �μ���ȣ
SELECT ENAME, HIREDATE, DEPTNO
    FROM EMP
    WHERE (DEPTNO, HIREDATE) IN (SELECT DEPTNO, MAX(HIREDATE) FROM EMP GROUP BY DEPTNO); 
    --EX.�޿� 3000�̻� �޴� ����� �Ҽӵ� �μ����� �ٹ��ϴ� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE SAL>=3000);
    --(2) ALL : 
    --EX.30�� �μ� �޿��� ��κ��� ū ���    
SELECT SAL FROM EMP WHERE DEPTNO = '30';   --��������(������)
SELECT *
    FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP WHERE DEPTNO = '30');  -- '>'�� ��������� ����Ұ���, ALL����� �Ѵ�!
SELECT MAX(SAL) FROM EMP WHERE DEPTNO = '30';   --���������� �ٲ�
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP WHERE DEPTNO = '30');
    
    --(3) ANY=SOME : �������� ����� �ϳ��� �����ϸ� ��
    --EX.30�� �μ� �޿��� �� �ϳ����̶� ū ���(=30�� �μ� �ּ� �޿����� ū ���) ������ ��� �ʵ�
SELECT *
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP WHERE DEPTNO = 30);    --���������� ������
    --���� QUERY�� ������ ����������
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO =30);
    --(4) EXISTS : �������� ����� �����ϸ� ��
    --EX.���Ӻ��ϰ� �ִ� �������� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL
    FROM EMP MANAGER
    WHERE EXISTS(SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);
SELECT DISTINCT M.EMPNO, M.ENAME, M.SAL --DISTINCT �ߺ�����
    FROM EMP W, EMP M
    WHERE W.MGR = M. EMPNO  
    ORDER BY M.ENAME;   --SELF JOIN �̿�
    --EX.���� ����� ��� �ʵ� ���
SELECT *
    FROM EMP MANAGER
    WHERE NOT EXISTS(SELECT * FROM EMP WHERE MANAGER.EMPNO = MGR);  --�������� �̿�
SELECT M.*
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.ENAME IS NULL;   --SELF JOIN �̿�
    
--źź1. �μ����� ���� �޿��� ���� �޴� ����� ����(��� ��ȣ, ����̸�, �޿�, �μ���ȣ)�� ���(IN ������ �̿�)
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP
    WHERE (DEPTNO, SAL) IN(SELECT DEPTNO, MAX(SAL) FROM EMP GROUP BY DEPTNO);   --��������
--źź2. ����(JOB)�� MANAGER�� ����� ���� �μ��� �μ� ��ȣ�� �μ���� ������ ���(IN)
SELECT DEPTNO, DNAME, LOC
    FROM DEPT
    WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER')
    ORDER BY DEPTNO;
--źź3. ������ 3000�̻��� ����� �� ���� ����� ����� �ش� ��޺� �ְ� ������ �޴� ������� ���, �̸�, ����, �Ի���, �޿�, �޿������ ���
SELECT EMPNO, ENAME, JOB, HIREDATE, SAL, GRADE
    FROM EMP E, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND SAL >=3000
        AND (GRADE, SAL) IN (SELECT GRADE, MAX(SAL) FROM SALGRADE WHERE E.SAL BETWEEN LOSAL AND HISAL GROUP BY GRADE);

--źź4. �����ȭ : �Ի��� �б⺰�� ���� ���� ������ �޴� ������� �б�, ���, �̸�, JOB, �����, �Ի���, �޿�, �󿩸� ����ϼ���   
SELECT HIREDATE, CEIL(TO_CHAR(HIREDATE, 'MM')/3) "QUARTER" FROM EMP;  

SELECT HIREDATE, CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER" 
    FROM EMP;  

SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) 
    FROM EMP
    GROUP BY CEIL(EXTRACT(MONTH FROM HIREDATE)/3);  --��������
    
SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3) "QUARTER", EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM
    FROM EMP
    WHERE (CEIL(EXTRACT(MONTH FROM HIREDATE)/3), SAL) IN (SELECT CEIL(EXTRACT(MONTH FROM HIREDATE)/3), MAX(SAL) FROM EMP GROUP BY (CEIL(EXTRACT(MONTH FROM HIREDATE)/3)))
    ORDER BY QUARTER;

--źź5.SALESMAN ��� ����� ���� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ������� �ʴ´�.(ALL�̿�)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ALL(SELECT SAL FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND JOB = 'SALESMAN');  
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > (SELECT MAX(SAL) FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND JOB = 'SALESMAN');  
--źź6.SALESMAN �Ϻ� � �� ������� �޿��� ���� �޴� ������� �̸��� �޿��� ����(��� ����)�� ����ϵ� ���� ����� ���(ANY)
SELECT ENAME, SAL, JOB
    FROM EMP
    WHERE SAL > ANY(SELECT SAL FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND JOB = 'SALESMAN');  
--źź7.������ 3000�̸��� ��� �߿� ���� �ֱٿ� �Ի��� ����� �����ȣ�� �̸�, ����, �Ի����� ���
SELECT EMPNO, ENAME, SAL, HIREDATE
    FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP WHERE SAL<3000);    --��������
--źź8.������ ��SALESMAN���� ����� �޴� �޿��� �ּ� �޿����� ���� �޴� ������� �̸�, �޿�, ����, �μ���ȣ�� ����ϵ� �μ���ȣ�� 20���� ����� �����Ѵ�(ANY ������ �̿�)
SELECT ENAME, SAL, JOB, DEPTNO
    FROM EMP 
    WHERE DEPTNO != 20 AND SAL > ANY(SELECT SAL FROM EMP WHERE JOB = 'SALESMAN'); 
   
-- �� �� ��������-2    
-- 14.  �̸��� ��T���� �ִ� ����� �ٹ��ϴ� �μ����� �ٹ��ϴ� ��� ������ ��� ��ȣ,�̸�,�޿�(�� ��� �� ���)
SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%')
    ORDER BY DEPTNO;

-- 15. �μ� ��ġ�� Dallas�� ��� �������� ���� �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE LOC = 'DALLAS' AND E.DEPTNO = D.DEPTNO;
    
    (SELECT LOC FROM DEPT WHERE LOC = 'DALLAS');

-- 16. EMP ���̺��� King���� �����ϴ� ��� ����� �̸��� �޿�
SELECT ENAME, SAL
    FROM EMP 
    WHERE MGR = (SELECT EMPNO FROM EMP WHERE ENAME = 'KING');

-- 17. SALES�μ� ����� �̸�, ����
SELECT ENAME, JOB
    FROM EMP E, DEPT D
    WHERE  E.DEPTNO = D.DEPTNO AND DNAME = 'SALES';

-- 18. ������ �μ� 30�� ���� ���޺��� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE SAL > (SELECT MIN(SAL) FROM EMP WHERE DEPTNO = 30);

-- 19. �μ� 10���� �μ� 30�� ����� ���� ������ �ð� �ִ� ����� �̸��� ����
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO=10 AND (DEPTNO, JOB) IN (SELECT DEPTNO, JOB FROM EMP WHERE DEPTNO = 30);
    
SELECT ENAME, JOB
    FROM EMP
    WHERE DEPTNO = 10 AND JOB IN (SELECT  JOB FROM EMP WHERE DEPTNO = '30');

-- 20.  FORD�� ������ ���޵� ���� ����� ��� �ʵ�
SELECT *
    FROM EMP
    WHERE (JOB, SAL) IN (SELECT JOB, SAL FROM EMP WHERE ENAME = 'FORD') AND ENAME != 'FORD';

-- 21. �̸��� JONES�� ������ JOB�� ���ų� FORD�� SAL �̻��� �޴� ����� ������ �̸�, ����, �μ���ȣ, �޿�
    -- ��, ������ ���ĺ� ��, ������ ���� ������ ���
SELECT ENAME, JOB, DEPTNO, SAL
    FROM EMP
    WHERE (JOB = (SELECT JOB FROM EMP WHERE ENAME = 'JONES') AND ENAME != 'JONES' ) OR (SAL>= (SELECT SAL FROM EMP WHERE ENAME = 'FORD'))
    ORDER BY JOB, SAL DESC;

-- 22. SCOTT �Ǵ� WARD�� ������ ���� ����� ������ �̸�,����,�޿�
SELECT ENAME, JOB, SAL
    FROM EMP
    WHERE ENAME NOT IN ('SCOTT', 'WARD') AND (SAL = (SELECT SAL FROM EMP WHERE ENAME = 'SCOTT') OR SAL = (SELECT SAL FROM EMP WHERE ENAME = 'WARD')) ;

-- 23. CHICAGO���� �ٹ��ϴ� ����� ���� ������ �ϴ� ������� �̸�,����
SELECT ENAME, JOB
    FROM EMP
    WHERE JOB IN (SELECT JOB FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO');

-- 24. �μ����� ������ ��� ���޺��� ���� ����� ���, �̸�, �޿�, �μ���ȣ ��
SELECT EMPNO, ENAME, E.SAL, E.DEPTNO
    FROM EMP E, (SELECT DEPTNO, AVG(SAL)SAL FROM EMP GROUP BY DEPTNO) A
    WHERE E.DEPTNO = A.DEPTNO AND E.SAL > A.SAL
    ORDER BY DEPTNO; 
    
SELECT EMPNO, ENAME, SAL, DEPTNO
    FROM EMP E
    WHERE SAL > (SELECT AVG(SAL) FROM EMP WHERE DEPTNO=E.DEPTNO)
    ORDER BY DEPTNO;
    
        --(�߰�)�ش�μ���պ��� ���� ����� ���� - ���, �̸�, �޿�, �μ���ȣ, �ش�μ��� ���(�Ҽ��� 2�ڸ�)
        SELECT EMPNO, ENAME, SAL, DEPTNO, (SELECT ROUND(AVG(SAL),2) FROM EMP WHERE E.DEPTNO = DEPTNO GROUP BY DEPTNO) "�μ��� ���"
            FROM EMP E
            WHERE SAL >(SELECT AVG(SAL) FROM EMP WHERE E.DEPTNO = DEPTNO GROUP BY DEPTNO);
        SELECT EMPNO, ENAME, SAL, E.DEPTNO AVG
            FROM EMP E, (SELECT DEPTNO, ROUND(AVG(SAL),2) AVG FROM EMP GROUP BY DEPTNO) A
            WHERE E.DEPTNO = A.DEPTNO AND SAL>AVG;  --INLINE VIEW�̿�

-- 25. �������� ��� ���޺��� ���� ������ �޴� ����� �μ���ȣ, �̸�, �޿� ��
SELECT E.DEPTNO, ENAME, E.SAL
    FROM EMP E, (SELECT JOB, AVG(SAL)SAL FROM EMP GROUP BY JOB) A
    WHERE E.JOB = A.JOB AND E.SAL < A.SAL; 
    
SELECT DEPTNO,ENAME,SAL
        FROM EMP E
        WHERE SAL < (SELECT AVG(SAL) FROM EMP WHERE E.JOB = JOB);

-- 26. ��� �� �� �̻����κ��� ���� ���� �� �ִ� ����� ����, �̸�, ���, �μ���ȣ�� ���(��, �μ���ȣ ������ �������� ����)
SELECT JOB, ENAME, EMPNO, DEPTNO
  FROM EMP M
  WHERE EXISTS (SELECT * FROM EMP WHERE MGR=M.EMPNO); --EXISTS ������ �̿�(��������)
SELECT DISTINCT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE EMPNO IN (SELECT MGR FROM EMP)
    ORDER BY DEPTNO;    --IN������ �̿�(��������)
SELECT DISTINCT M.JOB, M.ENAME, M.EMPNO, M.DEPTNO
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO; --SELF JOIN �̿�

-- 27.  ���� ����� ���, �̸�, ����, �μ���ȣ 
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN (SELECT NVL(MGR, 0) FROM EMP);   --MGR�� NULL���� �ֱ⶧���� ���� ó���� �ʿ���
SELECT EMPNO, ENAME, JOB, DEPTNO
    FROM EMP
    WHERE EMPNO NOT IN (SELECT MGR FROM EMP WHERE MGR IS NOT NULL);
