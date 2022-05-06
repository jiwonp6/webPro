--[V]�׷��Լ� : SUM, AVG, MIN, MAX, COUNT, STDDEV(ǥ������), VARIANCE(�л�)

SELECT ENAME, ROUND(SAL, -3)    --�������Լ�(4��) 
    FROM EMP;
SELECT MAX(SAL)
    FROM EMP;   --�׷��Լ�(5��)
SELECT DEPTNO, MAX(SAL) --DEPTNO���� MAX(SAL) ���
    FROM EMP
    GROUP BY DEPTNO;
SELECT ENAME, MAX(SAL)  -����(������� ������ ���� �Ἥ) �ִ�޿��� �޴� ����� �̸�(6��.��������)
    FROM EMP;
    
--��1.�׷��Լ��� �ǽ�
    --(1)
SELECT ROUND(AVG(SAL),2)    --�׷��Լ� ����� �������̶� ������ �Լ�����
    FROM EMP;
SELECT COUNT(*)     --EMP ���̺��� ��(ROW)�� 
    FROM EMP; 
SELECT ROUND(AVG(SAL),2), ROUND(SUM(SAL)/COUNT(SAL), 2)
    FROM EMP;
--��� �׷��Լ��� NULL���� ����!
SELECT COMM     --NULL���� �ִ� COMM
    FROM EMP;
SELECT SUM(COMM)    --�ڵ����� NULL����
    FROM EMP;
SELECT AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM)
    FROM EMP;
--SAL�� ���, ��, �ּұ޿�, �ִ�޿�, �޿��л�, �޿�ǥ������, ����
SELECT ROUND(AVG(SAL),2), SUM(SAL), MIN(SAL), MAX(SAL), ROUND(VARIANCE(SAL),2), ROUND(STDDEV(SAL),2)
    FROM EMP;
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) --SQRT������
    FROM EMP;
--�׷��Լ� MIN, MAX, COUNT�� ������, ������, ��¥�� ��� ��밡��
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) ENAME����, COUNT(COMM) COMM����
    FROM EMP;
SELECT MIN(HIREDATE) �����Ի���, MAX(HIREDATE)�ֱ��Ի���, COUNT(HIREDATE)
    FROM EMP;
    
    --  źź1.���� �ֱٿ� �Ի��� ����� �Ի��ϰ� �Ի����� ���� ������ ����� �Ի����� ���. 
SELECT MIN(HIREDATE) �����Ի���, MAX(HIREDATE)�ֱ��Ի���
    FROM EMP;   

    --  źź2.82/01/12 �ֱ��Ի��� : XX,XXX�� �ٹ�, 80/12/17 �����Ի��� : XX,XXX�� �ٹ�
SELECT MAX(HIREDATE)||' �ֱ��Ի��� : '||TO_CHAR(SYSDATE-MAX(HIREDATE)+1, '999,999') ||'�� �ٹ�, '
        ||MIN(HIREDATE)||' �����Ի��� : '||TO_CHAR(SYSDATE-MIN(HIREDATE)+1, '999,999') ||'�� �ٹ�'
    FROM EMP;
SELECT MAX(HIREDATE)||' �ֱ��Ի��� : '||TO_CHAR(MIN(SYSDATE-HIREDATE)+1, '99,999')||'�� �ٹ�, '
        ||MIN(HIREDATE)||' �����Ի��� : '||TO_CHAR(MAX(SYSDATE-HIREDATE)+1, '99,999')||'�� �ٹ�'
    FROM EMP;
--10�� �μ� �Ҽ��� ��� �޿����
SELECT ROUND(AVG(SAL), 2) 
    FROM EMP
    WHERE DEPTNO = 10;
--��2.GROUP BY ��
    --�μ���ȣ�� �ִ�޿�, �ּұ޿�, �޿����, �޿���
        --GROUP BY ������ �÷��� ��Ī ��� �Ұ�
SELECT DEPTNO �μ�, MAX(SAL), MIN(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO;
    --EX.SAL�� 5000�̸��� ����� ���ؼ��� �μ���ȣ�� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�(�μ���ȣ�� ����)
SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)  --SELECT�������� �ʵ� ��Ī ��� ����
    FROM EMP
    WHERE SAL<5000  --WHERE�������� �ʵ� ��Ī ���Ұ�
    GROUP BY DEPTNO   --GROUP BY �������� �ʵ� ��Ī ���Ұ�
    ORDER BY DEPTNO;  --ORDER BY �������� �ʵ� ��Ī ��밡��
    --EX.�μ��� �����, �ִ�޿�, �ּұ޿�, ��ձ޿�(�Ҽ��� 2�ڸ�)
SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY COUNT(*) DESC;

--��3.HAVING �� : �׷��Լ� ����� ����
--�μ���ȣ�� ��� �޿�(��� �޿��� 2000�̻��� �μ��� ���)
SELECT DEPTNO, ROUND(AVG(SAL),2) "AVG"
    FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL)>=2000   --HAVING������ �ʵ� ��Ī ��� �Ұ�
    ORDER BY AVG;
--EX.SAL�� 5000�̸��� ����� ���� �μ��� �ּұ޿�, �ִ�޿�, ��ձ޿� ���(��, ��ձ޿��� 1800�̻��� �μ��� ���ؼ� ��ձ޿������� ���� ���)
SELECT DNAME, ROUND(MIN(SAL),2), ROUND(MAX(SAL), 2), ROUND(AVG(SAL), 2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL<5000
    GROUP BY DNAME
    HAVING AVG(SAL)>=1800
    ORDER BY AVG(SAL);
    
--��4. ��� ������ �� ���谪 ����
--10 MANAGER 2500
--20         3500
--30         7500
--��
SELECT DEPTNO, SUM(SAL)
    FROM EMP
    GROUP BY ROLLUP(DEPTNO);    --������� ����(�հ��� �հ� ���)
    --�μ���, JOB�� �޿���
SELECT DEPTNO, JOB, SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO;
    --�μ���, JOB�� �޿���(�Ұ�� ��ü�� ����)
SELECT DEPTNO, NVL(JOB, '��'), SUM(SAL)
    FROM EMP
    GROUP BY ROLLUP(DEPTNO, JOB);

-- ��<�� ��������>

-- 1. �ο���,�ִ� �޿�,�ּ� �޿�,�޿��� ���� ���
SELECT COUNT(*) �ο���, MAX(SAL) �ִ�޿�, MIN(SAL) �ּұ޿�, SUM(SAL) �޿���
    FROM EMP;

-- 2. ������ �ο����� ���Ͽ� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY DEPTNO;

--- 3. �ְ� �޿��� �ּ� �޿��� ���̴� ���ΰ� ���
SELECT MAX(SAL)-MIN(SAL)
    FROM EMP;

-- 4. �� �μ����� �ο���, �޿� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���(�޿��� ���� ���� ������)
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL),2), MIN(SAL), MAX(SAL), SUM(SAL) "�޿���"
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;

-- 5. �μ���, ������ �׷��Ͽ� ����� �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���(�μ���ȣ, ���������� �������� ����)
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL), 2) �޿����, SUM(SAL) �޿���
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;

-- 6. ������, �μ��� �׷��Ͽ� �����  ����, �μ���ȣ, �ο���, �޿��� ���, �޿��� ���� ���(��°���� ������, �μ���ȣ �� �������� ����)
SELECT JOB, DEPTNO, COUNT(*), ROUND(AVG(SAL), 2) �޿����, SUM(SAL) �޿���
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;

--7. ������� 5���̻� �Ѵ� �μ���ȣ�� ������� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=5
    ORDER BY DEPTNO;

-- 8. ������� 5���̻� �Ѵ� �μ���� ������� ���
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*)>=5;

--9. ������ �޿��� ����� 3000�̻��� ������ ���ؼ� ������, ��� �޿�, �޿��� ���� ���
SELECT JOB, ROUND(AVG(SAL), 2) ��ձ޿�, SUM(SAL) �޿���
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL)>=3000;

--10. �޿� ���� 5000�� �ʰ��ϴ� �� ������ ���ؼ� ������ �޿����� ���(�޿� �հ�� �������� ����)
SELECT JOB, SUM(SAL) �޿���
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL)>5000
    ORDER BY SUM(SAL)  DESC;

--11. �μ��� �޿����, �μ��� �޿��հ�, �μ��� �ּұ޿��� ���
SELECT DEPTNO, ROUND(AVG(SAL), 2) �޿����, SUM(SAL) �޿��հ�, MIN(SAL) �ּұ޿�
    FROM EMP
    GROUP BY DEPTNO;

--12. ���� 11���� �����Ͽ�, �μ��� �޿���� �ִ�ġ, �μ��� �޿����� �ִ�ġ, �μ��� �ּұ޿��� �ִ�ġ�� ���
SELECT MAX(ROUND(AVG(SAL), 2)) �޿����_�ִ�ġ, MAX(SUM(SAL)) �޿��հ�_�ִ�ġ, MAX(MIN(SAL)) �ּұ޿�_�ִ�ġ
    FROM EMP
    GROUP BY DEPTNO;

--13. ��� ���̺��� �Ʒ��� ����� ���
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--  80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE, 'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL),1), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY TO_CHAR(HIREDATE, 'RR');

-- 14.  �Ʒ��� ����� ���(�Ի�⵵�� �����)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'total')�Ի�⵵, COUNT(*) �����
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'))
    ORDER BY TO_CHAR(HIREDATE, 'YYYY');

--15. �ִ�޿�, �ּұ޿�, ��ü�޿���, ����� ���
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL),2)
    FROM EMP;

--16. �μ��� �ο��� ���
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;

--17. �μ��� �ο����� 6���̻��� �μ���ȣ ���
SELECT DEPTNO
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=6;

--18. �޿��� ���� ������� ����� �ο��Ͽ� ������ ���� ����� ������ �Ͻÿ�. 
-- (��Ʈ self join, group by, count���)
--ENAME	    ���
--________________________
--KING		1
--SCOTT		2
--����
SELECT A.ENAME, COUNT(B.ENAME)+1 "���"
    FROM EMP A, EMP B
    WHERE A.SAL<B.SAL(+)
    GROUP BY A.ENAME
    ORDER BY ���;
    
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK",
        DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
        ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER"
    FROM EMP;
    
    
    
    
    
    