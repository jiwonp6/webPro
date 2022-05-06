--[IV] ������ �Լ� : �����Լ�, SQL �ֿ��Լ�
           --�Լ� = �������Լ� + �׷��Լ�(�����Լ�)

    --�������Լ�(INPUT 1�� -> OUTPUT 1��)
SELECT HIREDATE, TO_CHAR(HIREDATE, ' YY"��" MM"��" DD"��" ')
    FROM EMP;   --�������Լ�
SELECT ENAME, INITCAP(ENAME)
    FROM EMP;   --�������Լ�
    
    --�׷��Լ�(INPUT N�� -> OUTPUT 1��)
SELECT SUM(SAL), AVG(SAL)
    FROM EMP;   --��ü SAL ��
SELECT DEPTNO, SUM(SAL) 
    FROM EMP
    GROUP BY DEPTNO;    --�μ��� SAL ��
    
-- �ٴ������Լ� ���� : ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ�(�����), ����ȯ�Լ�, NVL( ), ETC, ...
            --�������Լ��� �׽�Ʈ�ϱ����� ���̺� : DUAL �� ���(1��, 1��¥�� dummy table)  (cf)DUMMY
DESC DUAL;
DESC DUMMY;
--1. ���ڰ����Լ�
    --(1)���� ABS
SELECT -9, ABS(-9) 
    FROM DUAL; 
    --(2)����(�Ҽ�������) FLOOR
SELECT FLOOR(34.5678) 
    FROM DUAL;
SELECT FLOOR(34.5678*100)/100 
    FROM DUAL;    --�Ҽ��� ��ġ ����
    --(3)����(�Ҽ�������) TRUNC
SELECT TRUNC(34.5678, 2) 
    FROM DUAL;
SELECT TRUNC(34.5678) 
    FROM DUAL;
SELECT TRUNC(34.5678, -1) 
    FROM DUAL;    --���� �ڸ����� ����
        --EX.EMP���̺��� �̸�, �޿�(���� �ڸ����� ����)
SELECT ENAME, TRUNC(SAL, -2)
    FROM EMP;
    --(4)�ø�(�Ҽ�������) CEIL
SELECT CEIL(34.5678)
    FROM DUAL; 
SELECT CEIL(34.5678*100)/100
    FROM DUAL;   
    --(5)�ݿø�(�Ҽ�������) ROUND
SELECT ROUND(34.5678)
    FROM DUAL;
SELECT ROUND(34.5678, 2)
    FROM DUAL;
SELECT ROUND(34.5678, -1)
    FROM DUAL;
    --(6)������ MOD
SELECT MOD(9,2) 
    FROM DUAL;
        --EX.����� Ȧ���� ����� ��� �ʵ� ���
SELECT * 
    FROM EMP
    WHERE MOD(EMPNO,2) = 1;
        --EX.Ȧ���޿� �Ի��� ����� ��� �ʵ� ���
SELECT * 
    FROM EMP
    WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2)=1;

--2. ���ڰ����Լ�
    --(1)��ҹ��ڰ��� UPPER/LOWER/INITCAP
SELECT UPPER('ABCabc')
    FROM DUAL;
SELECT LOWER('abcABC')
    FROM DUAL;
SELECT INITCAP('WELCOME TO ORACLE')
    FROM DUAL;
        --EX. JOB�� 'manager'�� ������ ��� �ʵ� ���
SELECT * 
    FROM EMP
    WHERE UPPER(JOB) = 'MANAGER';
SELECT * 
    FROM EMP
    WHERE LOWER(JOB) = 'manager';
SELECT * 
    FROM EMP
    WHERE INITCAP(JOB) = 'Manager';
    --(2)���ڿ��� CONCAT/||������
SELECT 'AB'||'CD'||'EF'||'GH'
    FROM DUAL;
SELECT CONCAT('AB', 'CD')   --�ݵ�� CONCAT�� �Ű����� 2���� ����
    FROM DUAL;
SELECT CONCAT('AB', 'CD'), CONCAT('EF', 'GH')
    FROM DUAL;
        --EX."�ƹ����� XX(JOB)�̴�" �������� EMP���̺� ���� ���
SELECT CONCAT(CONCAT(ENAME,'�� '), CONCAT(JOB, '�̴�(��)')) 
    FROM EMP;
SELECT ENAME ||'�� '||JOB||'�̴�(��)'
    FROM EMP;
    --(3)SUBSTR(STR, ������ġ, ���ڰ���) ù��°��ġ�� 1, ������ġ ��������
       --SUBSTRB(STR, ���۹���Ʈ��ġ, ���ڹ���Ʈ��)
--  O  R  A  C  L  E
--  1  2  3  4  5  6 
-- -6 -5 -4 -3 -2 -1
SELECT SUBSTR('ORACLE', 3, 2) 
    FROM DUAL;    --3��° ���ں��� 2���� ����
SELECT SUBSTRB('ORACLE', 3, 2) 
    FROM DUAL;   --3��° ����Ʈ���� 2����Ʈ ����
SELECT SUBSTR('�����ͺ��̽�', 4, 3) 
    FROM DUAL;  --4��° ���ں��� 3���� ����
SELECT SUBSTRB('�����ͺ��̽�', 4, 3) 
    FROM DUAL;   --4��° ����Ʈ���� 3����Ʈ ����, �ѱ� 1����(3BYTE)
SELECT SUBSTRB('ȫ�浿', 3, 4) 
    FROM DUAL;
SELECT SUBSTR('ABCDXD', -1, 1)
    FROM DUAL;
SELECT SUBSTR(123, 2, 1)
    FROM DUAL;  --���ڵ� ����
        --EX. 9���� �Ի��� ����� ��� �ʵ�(��, DATE ��� FORMAT 'RR/MM/DD')
SELECT *
    FROM EMP
    WHERE SUBSTR(HIREDATE, 4, 2) = 09;
        --EX. 9�Ͽ� �Ի��� ����� ��� �ʵ�(��, DATE ��� FORMAT 'RR/MM/DD')
SELECT *
    FROM EMP
    WHERE SUBSTR(HIREDATE, -1, 2) = 09;   --�ڿ������� 2����
    --(4)���ڼ�(LENGTH) VS ����Ʈ��(LENGTHB)
SELECT LENGTH('ABC')
    FROM DUAL;
SELECT LENGTHB('ABC')
    FROM DUAL;
SELECT LENGTH('����Ŭ')
    FROM DUAL;
SELECT LENGTHB('����Ŭ')
    FROM DUAL;
    --(5)INSTR(STR, ã������) : STR���� ã�� ������ ��ġ(ù��° 1), ������ 0
       --INSTR(STR, ã������, ������ġ) : STR���� ������ġ���� ã�Ƽ� ã�� ������ ��ġ, ��ġ�� ������ �ڿ�������
SELECT INSTR('ABCABC', 'B')
    FROM DUAL;
SELECT INSTR('ABCABC', 'B', 3)
    FROM DUAL;
SELECT INSTR('ABCABC', 'B', -1)
    FROM DUAL;
        --EX.9���� �Ի��� ����� ��� �ʵ�(INSTR)
SELECT *
    FROM EMP
    WHERE INSTR(HIREDATE, '09', 4) = 4; 
        --EX.9�Ͽ� �Ի��� ����� ��� �ʵ�(INSTR)   09/09/09    7��°���� ã�� ���ڰ� 7��°�� ��ġ�ϳ�?
SELECT *
    FROM EMP
    WHERE INSTR(HIREDATE, '09', 7) = 7;
            --EX.9���� �ƴ� �� �Ի��� ����� ��� �ʵ�(INSTR) 
SELECT *
    FROM EMP
    WHERE INSTR(HIREDATE, '09', 7) = 0;
SELECT *
    FROM EMP
    WHERE NOT INSTR(HIREDATE, '09', 7) = 7;
    --(6)LPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���� ���
       --RPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ä�� ���� ���
SELECT LPAD('ORACLE', 10, '#') 
    FROM DUAL;
SELECT RPAD('ORACLE', 10, '#')
    FROM DUAL;
SELECT ENAME, SAL, LPAD(SAL, 6, '*')
    FROM EMP;
        --EX1. ���, �̸�(7788 S****)
SELECT EMPNO ���, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') �̸�
    FROM EMP
    ORDER BY EMPNO;
        --EX2.���, �̸�, �Ի���(7892/ _____****H/80/12/**) 
SELECT EMPNO ���, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') �̸�
        , RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') �Ի���
    FROM EMP
    ORDER BY �Ի���;
SELECT EMPNO ���, TO_CHAR(HIREDATE, 'RR/MM/')||'**' �Ի���
    FROM EMP;
        --EX3.�̸��� ����° �ڸ��� R�� ����� ��� �ʵ�(LIKE, INSTR, SUBSTR)
SELECT *
    FROM EMP
    WHERE ENAME LIKE '__R%';
SELECT *
    FROM EMP
    WHERE INSTR(ENAME, 'R', 3) = 3; --cf. RARA(R�� 3��°���� �ִ°� �ƴ� �� �ֱ� ������ ,3�� �ʿ���)
SELECT *
    FROM EMP
    WHERE SUBSTR(ENAME, 3, 1) = 'R';
    --(7)��������
SELECT TRIM('      ORACLE DB        ') 
    FROM DUAL;
SELECT RTRIM('      ORACLE DB        ') 
    FROM DUAL;
SELECT LTRIM('      ORACLE DB        ') 
    FROM DUAL;
    --(8)��ü/����
SELECT REPLACE(ENAME, 'A', 'XX')
    FROM EMP;
SELECT REPLACE(HIREDATE, '0', ' ')
    FROM EMP;
--3.��¥�����Լ� �� ����
    --(1)SYSDATE : ����
SELECT SYSDATE 
    FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE 
    FROM DUAL;
SELECT ENAME, HIREDATE 
    FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; --���󺹱�
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS')
    FROM DUAL;
SELECT SYSDATE-1 "���� �� �ð�", SYSDATE "����", SYSDATE+1 "���� �� �ð�"
    FROM DUAL;
    --(2)��¥��� : 14�� ��
SELECT SYSDATE+14 "�ݳ�������" 
    FROM DUAL;
        --EX.�̸�, �Ի���, �ٹ��ϼ�
SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE-1) �ٹ��ϼ�
    FROM EMP;
        --EX.�̸�, �Ի���, �ٹ��ּ�, �ٹ����
SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE-1)/7) �ٹ��ּ�, FLOOR((SYSDATE-HIREDATE-1)/365) �ٹ����
    FROM EMP;
    --(3)MONTHS_BETWEEN(��¥, ��¥) : �� ��¥���� ���� ��
        --EX.�̸�, �Ի���, �ٹ�����
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN (SYSDATE, HIREDATE)) �ٹ����� 
    FROM EMP;
        --EX. �̸�, �Ի��� ���� ���� �޿��� ��(�޿��� �Ŵ� SAL�� �ް�, COMM�� 1�⿡ 2ȸ ����)
SELECT ENAME, TRUNC(MONTHS_BETWEEN (SYSDATE, HIREDATE))*SAL + TRUNC((SYSDATE-HIREDATE-1)/365)*2*NVL(COMM,0) COST
    FROM EMP;
    --(4)ADD_MONTHS(��¥, ������) : Ư���������� ��� ���� ��¥
        --EX.�̸�, �Ի���, ����������(�����Ⱓ�� �Ի��Ϸκ��� 6������ �Ѵ�.)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6)
    FROM EMP;
    --(5)LAST_DAY(��¥) : Ư����¥�� ���� ����
SELECT LAST_DAY(SYSDATE)
    FROM DUAL;
        --EX.�̸�, �Ի���, ù ���޳�(���޳��� ����)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE)
    FROM EMP;
    --(6)ROUND(��¥, XX) : ��¥ �ݿø�/TRUNC(��¥, XX) : ��¥����
SELECT ROUND(SYSDATE, 'YEAR') 
    FROM DUAL;  --��� : ����� 1��1�� ��ȯ
SELECT ROUND(SYSDATE, 'MONTH')
    FROM DUAL;  --��� : ����� 1�� (1~15���� �̹��� 1��, 16�� ���Ĵ� ������ 1��)
SELECT ROUND(SYSDATE, 'DAY')
    FROM DUAL;  --��� : ����� �Ͽ���
SELECT TO_CHAR(ROUND(SYSDATE), 'RR/MM/DD HH24:MI')
    FROM DUAL;  --��� : ����� 0��   
    
SELECT TRUNC(SYSDATE, 'YEAR') 
    FROM DUAL;  --��� : ���� 1��1�� ��ȯ
SELECT TRUNC(SYSDATE, 'MONTH')
    FROM DUAL;  --��� : �̹��� 1�� (1~15���� �̹��� 1��, 16�� ���Ĵ� ������ 1��)
SELECT TRUNC(SYSDATE, 'DAY')
    FROM DUAL;  --��� : ���� �Ͽ���
SELECT TO_CHAR(TRUNC(SYSDATE), 'RR/MM/DD HH24:MI')
    FROM DUAL;  --��� : ���� 0��   
        --EX1. �̸�, �Ի���, ���޳�(���޳��� �Ŵ� 5��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+4 "���޳�"
    FROM EMP; 
        --EX2.�̸�, �Ի���, �Ի��� ���� 16��
SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 "���޳�"
    FROM EMP;     
        --EX3.�̸�, �Ի���, �Ի��� ���� 15��
SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH')+14 "���޳�"
    FROM EMP;
        --EX4.�̸�, �Ի���, ���޳�(���޳��� �Ŵ� 5��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH')+4 "���޳�"
    FROM EMP;    
        --EX5.�̸�, �Ի���, ���޳�(���޳��� �Ŵ� 20��)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH')+19 "���޳�"
    FROM EMP;     
    --(7)NEXT_DAY(��¥, '��') : Ư����¥�κ��� ó�� �����ϴ� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��')
    FROM EMP;
    
--4.����ȯ �Լ�  (����<->����, ����<->��¥)
DESC EMP;
    --(1) TO_CHAR(��¥��������, '�������')
    --YYYY(�⵵4�ڸ�) YY(�⵵2�ڸ�) RR(�⵵2�ڸ�) MM(��) DD(��) DAY(����) DY(���Ͽ��ǥ��)
    --AM/PM(����/����) HH(12�ð�) HH24(24�ð�) MI(��) SS(��)
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" HH24:MI:SS')
    FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" AM HH:MI:SS')
    FROM DUAL;    
    --(2) TO_CHAR(���ڵ�����, '�������')
    --0 : �ڸ���, ��������� �ڸ����� ������ 0���� ä��
    --9 : �ڸ���, ��������� �ڸ����� ���Ƶ� ���ڸ�ŭ�� ���
    --, : ���ڸ����� , ����
    --. : �Ҽ���
    --$ : ��ȭ���� $�� �տ� ���� �� ����
    --L : ������ȭ������ �տ� ���� �� ����
SELECT TO_CHAR(123456, '9,999,999.99')
    FROM DUAL;
SELECT TO_CHAR(123456, '0,000,000.00')
    FROM DUAL;
SELECT TO_CHAR(10000, 'L99,999')
    FROM DUAL;
SELECT ENAME, TO_CHAR(SAL, '$99,999')
    FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$00,999')
    FROM EMP;
DESC EMP;
    --TO_DATE(���ڵ�����, '����')
SELECT TO_DATE('2022-0412', 'YYYY-MMDD')
    FROM DUAL;  --0��0��0�ʷ� ����
    
        --EX.81/5/1~83/5/1���̿� �Ի��� ���� ��� �ʵ�(TO_DATE�̿�)
SELECT *
    FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD') AND TO_DATE('83/05/01', 'RR/MM/DD'); --��¥������ ��
    --(4) TO_NUMBER(����, '����')
SELECT TO_NUMBER('3,456', '9,999')+1
    FROM DUAL;
    
--5.NVL(���ϼ����ִµ�����, ���̸����Ұ�) - �Ű����� 2���� Ÿ����ġ �ؾ���
SELECT ENAME, NVL(COMM,0)
    FROM EMP;
    --EX.�̸�, ����� ���(MGR)�� ����ϵ�, ����� ����� NULL�� ��� 'CEO'�� ��� ���
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO')
    FROM EMP;

--6.ETC
    --(1)EXTRACT(���� ������)
SELECT EXTRACT(YEAR FROM SYSDATE)
    FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY') 
    FROM DUAL;
SELECT EXTRACT(MONTH FROM SYSDATE)
    FROM DUAL;   
SELECT TO_CHAR(SYSDATE, 'MM') 
    FROM DUAL;
SELECT EXTRACT(DAY FROM SYSDATE)
    FROM DUAL; 
        --EX.8���� �Ի��� ������ ��� �ʵ�
SELECT *
    FROM EMP
    WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
SELECT *
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = '02';
SELECT *
    FROM EMP
    WHERE HIREDATE LIKE '__/02/__';
        --EX2.81�⵵�� �Ի��� ������ ��� �ʵ�
SELECT *
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'RR') = '81';
SELECT *
    FROM EMP
    WHERE EXTRACT(YEAR FROM HIREDATE) = 1981;
    --(2)������ ���(������ ���) : LEVEL, START WITH ����(MGR IS NULL), CONNECT BY PRIOR ����(EMPNO=MGR)
SELECT LEVEL, LPAD(' ', LEVEL*2)||ENAME
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO = MGR;

--�� <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date"
    FROM DUAL;

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
-- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "New salary", SAL*0.15 "Increase"
    FROM EMP;

--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6���� �� ��"
    FROM EMP;

--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN (SYSDATE, HIREDATE)) �ٹ�������, SAL �޿�, ROUND(MONTHS_BETWEEN (SYSDATE, HIREDATE)*SAL, 2) �޿��Ѱ�
    FROM EMP;

--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME �̸�, LPAD(SAL, 15, '*') �޿�
    FROM EMP;

--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE �Ի���, TO_CHAR(HIREDATE, 'DY') �Ի����
    FROM EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME), JOB
    FROM EMP
    WHERE LENGTH(ENAME)>5;

--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,0) SAL_COMM
    FROM EMP;

-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT ENAME �����, SUBSTR(ENAME, 2, 3) "����� ����"
    FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
--  �ý��ۿ� ���� DATEFORMAT �ٸ� �� �����Ƿ� �Ʒ��� ����� �˾ƺ���
SELECT EMPNO, ENAME, HIREDATE
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = 12;

--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		       SMITH		*******800
--7499		       ALLEN		******1600
--7521		       WARD		******1250
--����. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿�
    FROM EMP;

-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY"-"MM"-"DD"') �Ի���
    FROM EMP;

--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$999,999') �޿�
    FROM EMP
    WHERE DEPTNO = 20;



    