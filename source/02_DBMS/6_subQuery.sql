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
    WHERE SAL<=(SELECT AVG(SAL)
                    FROM EMP);
    --EX2.��ձ޿� ���Ϸ� �޴� ����� �̸�, �޿�, ��ձ޿� ���
SELECT ENAME, SAL, (SELECT ROUND(AVG(SAL),2) FROM EMP)
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL)
                    FROM EMP);
    
    
