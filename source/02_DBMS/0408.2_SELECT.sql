--[II]SELECT ��-���帹�� ���̴� DML(Data Manipulation Language); �˻� ���
--1. SELECT���� �ۼ���
--���� ����(���� : ctrl + Enter)
SHOW USER;
SELECT * FROM TAB;--�� ����(scott)�� ������ �ִ� ���̺�
SELECT * FROM EMP;--EMP ���̺��� ��� ��(�ʵ�), ��� ��
SELECT * FROM DEPT;--DEPT ���̺��� ��� ��, ��� ��
--EMP ���̺��� ����
DESC EMP;
DESC DEPT;

--2. SQL�� ���� (Ư�� ���� ���)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "�� ��", ENAME AS "�� ��", SAL AS "�� ��", JOB FROM EMP; --��Ī
SELECT EMPNO AS ���, ENAME AS �̸�, SAL AS �޿�, JOB FROM EMP;
SELECT EMPNO ���, ENAME �̸�, SAL �޿�, JOB FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP;   --TITLE : NO, NAME, SALARY

--3. Ư���� ��� : WHERE ��(����)-�񱳿�����; ����(=), ũ�ų�����(>=)..�ٸ���(!=, ^=, <>)
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL = 3000;  --����
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL != 3000; --�ٸ���
DESC EMP;
    --�񱳿����ڴ� ����, ����, ��¥�� ��� ����
    --EX. ����̸�(ENAME)�� 'A', 'B', 'C'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME < 'D';  --��Ī �� ���� " "���, ���ڴ� ' '
    --EX. 81�⵵ ������ �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
    --EX. 10�� �μ���ȣ(deptno)�� ����� ��� �ʵ带 ���
SELECT * FROM EMP WHERE DEPTNO = '10';
    --EX. �̸�(ENAME)�� FORD�� ������ EMPNO, ENAME, MGR(����� ���)�� ���
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD'; --�����ʹ� ��ҹ��� ����

--4. �������� : AND, OR, NOT
    --EX. �޿�(SAL)�� 2000�̻� 3000������ ������ ��� �ʵ�
SELECT * FROM EMP WHERE SAL >=2000 AND SAL<=3000;
    --EX. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';
    --��¥ ǥ��� ����(���� : YY/MM/DD OR RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YY';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; --�ѱ� �������� ���� INSTALL
SELECT ENAME, HIREDATE FROM EMP;
    --������ 2400 �̻��� ������ ENAME, SAL, ���� ���(���� = SAL*12)
SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 > 2400;
SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE ���� > 2400;    --WHERE������ ��ĪX
SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12>2400 ORDER BY ����;  --ORDER BY���� ��Ī����
    --10�� �μ�(DEPTNO)�̰ų� ��å(JOB)�� MANAGER�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
    --�μ���ȣ�� 10���� �ƴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10;

--5. ���ǥ����
SELECT ENAME, SAL "����޿�", SAL+100 "�ø��޿�" FROM EMP WHERE DEPTNO = 10;
    --EX. ��� ����� �̸�(ENAME), ����(SAL), ��(COMM), ����(SAL*12+COMM)
    --��������� ����� NULL�����ϸ� ����� NULL!
    --NVL(NULL�� ���� �ִ� �ʵ��, ��ġ��) �ݵ�� �Űܺ��� ���� Ÿ�� ���ƾ� ��
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;  --Ʋ�� ��
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;
    --��� ����� �����(ENAME), ����� ���(MGR)�� ���(��� ������ 0)
SELECT ENAME, NVL(MGR, 0) FROM EMP;
SELECT ENAME, NVL(MGR, '����') FROM EMP; --NVL �Ű����� Ÿ�� ����ġ ����

--6. ���Ῥ����(||) : ���̳� ���ڸ� ����
SELECT ENAME || '��' || JOB "EMPLOYEES" FROM EMP;
    --EX. "SMITH : ���� = XXX"�� ���� ��� �� ���(���� = SAL*12+COMM)
SELECT ENAME || ' : ���� = ' || (SAL*12+NVL(COMM, 0)) FROM EMP;

--7. �ߺ�����(DISTINCT)
SELECT JOB FROM EMP;
SELECT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

--8. SQL ������(BETWEEN, IN, LIKE, IS NULL)
    --(1)BETWEEN
        --EX. SAL�� 1500�̻� 3000������ ��� �̸� �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500;  --X
        --EX. 1500�̸�, 3000�ʰ��ϴ� ��� �ʵ� ���
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;

--�� �������� �� Ǯ��!
    --1. emp ���̺��� ���� ��� (����Ŭ������ ����)
DESC EMP;

    --2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;

    --3. �� scott �������� ��밡���� ���̺� ���
SHOW USER;  --SCOTT���� ���ӵ��ִ��� Ȯ��
SELECT * FROM TAB; --���� ������ ������ �ִ� ���̺�

    --4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;

    --5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;

    --6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >= '81/02/01' ;
    --#��¥����(YYYY �⵵4�ڸ�/RR �⵵2�ڸ�/M��/D��)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR' 
    --#��¥��->���������� ��ȯ�ϴ� �Լ� : TO_CHAT(��¥��������, ����)
    --#������->��¥������ ��ȯ�ϴ� �Լ� : TO_DATE(������������, ����)
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '81/02/01' ;  --�������Լ�(4�� ����)
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE >= TO_DATE('81/02/01', 'RR/MM/DD') ;  --�������Լ�(4�� ����)
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'  --���󺹱�^^

    --7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';

    --8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';

    --9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL <= 3000;

    --10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

    --11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;

    --12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'MANAGER' AND SAL >= 2500;

    --13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME || '�� ' || JOB ||'�����̰� ������ ' ||(SAL*12+NVL(COMM,0))||'�̴�' FROM EMP;
    --(COMM�� �󿩱�, NULL�� �� �ֱ⶧���� NVL�ٿ������)




