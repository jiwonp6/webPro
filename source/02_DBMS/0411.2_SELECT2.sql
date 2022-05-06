--8. SQL ������(BETWEEN, IN, LIKE, IS NULL)
    --(1)BETWEEN : (����)������ BETWEEN ~ AND ~;
        --EX. SAL�� 1500�̻� 3000������ ��� �̸� �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500;  --X
        --EX. 1500�̸�, 3000�ʰ��ϴ� ��� �ʵ� ���
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
        --EX. 82�⵵�� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';  --(82/01/01���� ũ�ų� ���� 82/12/31���� �۰ų� ����)
        --EX.����̸��� 'A'�� 'B'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME !='C';  --(A���� ũ�ų� ���� C���� ����)
        --EX.����̸��� 'B'�� 'C'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME !='D';

    --(2) IN : (����)������ IN(A, B, C ...);
        --EX.�μ���ȣ�� 10�̰ų� 20�̰ų� 40���� �μ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO =10 OR DEPTNO =20 OR DEPTNO =40;
SELECT * FROM EMP WHERE DEPTNO IN (10, 20, 40);
        --EX.�μ���ȣ�� 10, 20, 40�� �μ��� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO NOT IN (10, 20, 40);
SELECT * FROM EMP WHERE DEPTNO !=10 AND DEPTNO <>20 AND DEPTNO ^=40;
        --EX.����� 7902, 7788, 7566�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);

    --(3) LIKE ���� : (����)������ LIKE ����(%(���ϵ� ī��):0���� �̻�, _:�ѱ���)
        --EX.�̸��� M�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%M%';   --'M' �յڷ� 0���� �̻� �� �� ����
        --EX.�̸��� M���� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE 'M%';    --'M'���� ����
        --EX.�̸��� S�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';    --'S'�� ��
        --EX.SAL�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';     --'5'�� �� 
SELECT * FROM EMP WHERE SAL LIKE '2975';    --(�������� ������ �񱳰���)
        --EX.82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = 82;
        --EX.1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';     --'__/01__'�� ����
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '%/01/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = 01;
        --EX.82�⵵�� �ƴ� �⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';
        --EX.�̸��� S�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S%';
        --EX.%�� �� ��� ��
SELECT * FROM EMP WHERE ENAME LIKE '%%%';   --��� �ʵ�
INSERT INTO EMP VALUES (9999, 'HONG%', NULL, NULL, NULL, 9000, 900, 40);    --������ �Է�
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\'; 
ROLLBACK;   --DML(������ �߰�, ����, ����)�� ������ ������ ���󺹱�(DML���)

    --(4) IS NULL 
SELECT * FROM EMP;
        --EX.�󿩱�(COMM)�� NULL�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL;   --NULL �񱳽� �ݵ�� IS NULL��!
        --EX.�󿩱��� ���� ����� ��� �ʵ�(COMM�� NULL�̰ų� 0)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
        --EX.�󿩱��� �ִ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM != 0;

--9. ����(��������, ��������)
SELECT ENAME, SAL FROM EMP ORDER BY SAL;    --�޿� �������� ����(ASC ����)
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC;    --�޿� �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;   --�޿� �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY ENAME ASC;  --�̸� ���ĺ���(����) ����
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; --�̸� ���ĺ� ����(����) ����
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE ASC;  --��¥ ������� ����
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; --�ֽ� ������� ����
    --EX.�̸�, ����(SAL*12+COMM)�� ���(������ ���� ������, ���� ������ ���� ����� �̸� ���ĺ� ��)
SELECT ENAME, SAL*12+NVL(COMM,0) "ANNUAL_SAL" 
    FROM EMP 
    ORDER BY ANNUAL_SAL DESC, ENAME ASC;    --ORDER BY ������ ��Ī ��� ����(FROM->WHERE->SELECT->ORDER(����))
    --EX.���, �̸�, �Ի���, �޿�, �μ���ȣ(�μ���ȣ��, �μ� ������ �Ի��� ������ ������������ ���)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;

--�� ���� ��������(�� �����ϱ�)
    --1.	EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP 
    WHERE SAL>=3000;
 
    --2.	EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO 
    FROM EMP 
    WHERE EMPNO = '7788';

    --3.	������ 24000�̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL 
    FROM EMP 
    WHERE (SAL*12+NVL(COMM,0))>=24000 
    ORDER BY SAL;

    --4.	DLQ������ 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� �����, ��å, �Ի����� ��� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE 
    FROM EMP 
    WHERE HIREDATE 
    BETWEEN '81/02/20' AND '81/05/01' 
    ORDER BY HIREDATE;

    --5.	deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP 
    WHERE DEPTNO=10 OR DEPTNO=20 
    ORDER BY ENAME;

    --6.	sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
        -- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME "employee", SAL "Monthly Salary" 
    FROM EMP 
    WHERE SAL >= 1500 AND (DEPTNO=10 OR DEPTNO = 30);

    --7.	hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP 
    WHERE HIREDATE LIKE '82/%';

    --8.	�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL 
    FROM EMP 
    WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME !='Q' 
    ORDER BY ENAME;

    --9.	comm�� sal���� 10%�� ���� ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
        --����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, NVL(COMM,0) 
    FROM EMP 
    WHERE NVL(COMM,0) >= SAL*1.1;

    --10.	job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ��� ����� ������ ���
SELECT * FROM EMP 
    WHERE (JOB IN('CLERK', 'ANALYST')) AND (SAL NOT IN(1000, 3000, 5000));

    --11.	ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
        --��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP 
    WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;

    --12.	�Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL 
    FROM EMP 
    WHERE HIREDATE LIKE '81/%';

    --13.	�Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
        -- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL 
    FROM EMP 
    WHERE HIREDATE LIKE '81%' AND JOB !='SALESMAN';

    --14.	���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
        -- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL 
    FROM EMP 
    ORDER BY SAL DESC, HIREDATE;

    --15.	������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME 
    FROM EMP 
    WHERE ENAME LIKE '__N%';

    --16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME 
    FROM EMP 
    WHERE ENAME LIKE '%A%';

    --17.	����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, (SAL*12+NVL(COMM, 0)) "����"
    FROM EMP 
    WHERE (SAL*12+NVL(COMM, 0))>=35000;




