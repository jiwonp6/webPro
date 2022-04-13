--[III] JOIN : ���̺� 2�� �̻��� �����Ͽ� �˻�
SELECT * FROM EMP 
    WHERE ENAME = 'SCOTT';    --�μ���ȣ(DEPTNO=20)
SELECT * FROM DEPT;
--CROSS JOIN(FROM���� ���̺� 2�� �̻�)
SELECT * FROM EMP, DEPT 
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;  -----������--1��, 4��
SELECT * FROM EMP, DEPT; --14*4=56��

--�� 1. EQUI JOIN(���� JOIN : �����ʵ忣 DEPTNO���� ��ġ�Ǵ� ���Ǹ� JOIN)
SELECT * FROM EMP, DEPT
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, EMP.DEPTNO, DNAME, LOC
    FROM EMP, DEPT
    WHERE ENAME = 'SCOTT' AND EMP.DEPTNO = DEPT.DEPTNO;
    --���̺��� ��Ī�� ������ ��Ī���θ� ���̺� �׼��� ����
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, E.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO;
    
    --EX.�޿��� 2000�̻��� ������ �̸�, ��å, �޿�, �μ���, �ٹ��� ���
SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND SAL >= 2000;
    --EX.LOC�� 'CHICAGO'�� ����� �̸�, ����, �޿�, �μ���ȣ, �ٹ����� ���
SELECT E.ENAME, JOB, SAL, D.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND LOC = 'CHICAGO';
    --EX.�μ���ȣ 10���̰ų� 20���� ����� �̸�, ����, �ٹ���, �޿�. (�޿��� ����)
SELECT E.ENAME, JOB, LOC, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND D.DEPTNO IN (10, 20)
    ORDER BY SAL;
    --EX.JOB�� SALESMAN�̰ų� MANAGER�� ����� �̸�, �޿�, ��, ����((SAL+COMM)*12), �μ���,
        --�ٹ����� ���(������ ū������ ����)
SELECT ENAME, SAL, COMM, (SAL+NVL(COMM,0))*12 ANNUAL_SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB IN('SALESMAN', 'MANAGER') 
    ORDER BY ANNUAL_SAL DESC;

    --EX.COMM�� NULL�̰� �޿��� 1200�̻��� ����� �̸�, �޿�, �Ի���, �μ���ȣ, �μ��� ���(�μ����, �޿�ū�� ����)
SELECT ENAME, SAL, HIREDATE, D.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NULL AND SAL >=1200
    ORDER BY DNAME, SAL DESC;
    
--EX.źź
    --1.'NEW YORK'���� �ٹ��ϴ� ����� �̸��� �޿� ���
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND LOC = 'NEW YORK';
    --2.'ACCOUNTING'�μ� �Ҽ��� ����̸��� �Ի��� ���
SELECT ENAME, HIREDATE
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = 'ACCOUNTING';
    --3.����(JOB)�� MANAGER�� ����� �̸�, �μ��� ���
SELECT ENAME, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER';
    --4.COMM�� NULL�� �ƴ� ����� �̸�, �޿�, �μ���ȣ, �ٹ��� ���
SELECT ENAME, SAL, D.DEPTNO, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL;
    
    --�� 2. NON-EQUI JOIN
SELECT * 
    FROM EMP 
    WHERE ENAME = 'SCOTT';    --�������
SELECT * 
    FROM SALGRADE; --�޿� ��� ����
SELECT * 
    FROM EMP, SALGRADE 
    WHERE ENAME = 'SCOTT';  --CROSS JOIN = EMP�� 1�� *SALGRADE�� 5��
SELECT * 
    FROM EMP E, SALGRADE S
    WHERE ENAME = 'SCOTT' AND E.SAL BETWEEN S.LOSAL AND S.HISAL  ;
    --EX.��� ����� ���, �̸�, JOB, �����, �޿�, �޿����(1���, 2���,...)
SELECT EMPNO, ENAME, JOB, MGR, SAL, GRADE ||'���' GRADE  --Ÿ��Ʋ�� Ư������ �ȳֱ� ���� �ڿ� GRADE�ٿ���
    FROM EMP E, SALGRADE S
    WHERE SAL BETWEEN LOSAL AND HISAL;
    
--EX.źź������
    ��- 1.Comm�� null�� �ƴ� ����� �̸�, �޿�, ���, �μ���ȣ, �μ��̸�, �ٹ����� ����Ͻÿ�.
SELECT ENAME, SAL, GRADE, D.DEPTNO, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE SAL BETWEEN LOSAL AND HISAL AND E.DEPTNO=D.DEPTNO AND COMM IS NOT NULL;
    --2.�̸�, �޿�, �Ի���, �޿����
SELECT ENAME, SAL, HIREDATE, GRADE 
    FROM EMP, SALGRADE 
    WHERE SAL BETWEEN LOSAL AND HISAL;
    --3.�̸�, �޿�, �Ի���, �޿����, �μ���, �ٹ���
SELECT ENAME, SAL, HIREDATE, GRADE, DNAME, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL;
    --4.�̸�, �޿�, ���, �μ��ڵ�, �ٹ���. �� comm �� null�ƴ� ���
SELECT ENAME, SAL, GRADE, E.DEPTNO, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND COMM IS NOT NULL;
    --5.�̸�, �޿�, �޿����, ����, �μ���, (�μ��� ���, �μ��� ������ ������ ����). 
        --����=(sal+comm)*12 comm�� null�̸� 0
SELECT ENAME, SAL, GRADE, (SAL+NVL(COMM, 0))*12 "ANNUAL_SAL", DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, ANNUAL_SAL DESC;
    --6.�̸�, ����, �޿�, ���, �μ��ڵ�, �μ��� ���. �޿��� 1000~3000����. 
        --�������� : �μ���, �μ������� ������, ���������� �޿� ū��
SELECT ENAME, JOB, SAL, GRADE, D.DEPTNO, DNAME
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO = D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND SAL BETWEEN 1000 AND 3000
    ORDER BY DNAME, JOB, SAL DESC;
    
    --7.�̸�, �޿�, ���, �Ի���, �ٹ���. 81�⿡ �Ի��� ���. ��� ū��
SELECT ENAME, SAL, GRADE, HIREDATE, LOC
    FROM EMP E, DEPT D, SALGRADE
    WHERE E.DEPTNO=D.DEPTNO AND SAL BETWEEN LOSAL AND HISAL AND HIREDATE LIKE "%81%"
    ORDER BY GRADE DESC;
    
--�� 3. SELF JOIN
SELECT EMPNO ���, ENAME �̸�, MGR �����
    FROM EMP
    WHERE ENAME = 'SMITH';  --SMITH ����� :7902
SELECT EMPNO, ENAME FROM EMP WHERE EMPNO = 7902;
SELECT WORKER.EMPNO, WORKER.ENAME, WORKER.MGR, MANAGER.EMPNO, MANAGER.ENAME
    FROM EMP WORKER, EMP MANAGER
    WHERE WORKER.MGR=MANAGER.EMPNO AND WORKER.ENAME='SMITH';
    --EX.��� ����� ���, �̸�, ����� ���, ����̸� (13�� - KING�� MGR�� NULL�̶� KING ��¾ȵ�)
SELECT W.EMPNO ���, W.ENAME �̸�, W.MGR �����, M.ENAME ����̸�
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    --EX.'SMITH�� ���� FORD�̴�' �������� ������� ���
SELECT W.ENAME ||'�� ���� '||M.ENAME||'�̴�.'
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
--EX.źź������
    ��-1.SCOTT�� ������ �μ���ȣ���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�
SELECT * 
    FROM EMP 
    WHERE ENAME = 'SCOTT';
SELECT ENAME 
    FROM EMP 
    WHERE DEPTNO = 20 AND ENAME!= 'SCOTT';
 
SELECT E.ENAME
    FROM EMP E_SCOTT, EMP E
    WHERE E_SCOTT.ENAME = 'SCOTT' AND E_SCOTT.DEPTNO = E.DEPTNO AND E.ENAME != 'SCOTT';

    ��-2.SCOTT�� ������ �ٹ���(DALLAS)���� �ٹ��ϴ� ����� �̸��� ����Ͻÿ�(2�ܰ� ��������)
INSERT INTO DEPT VALUES (50, 'IT', 'DALLAS');   --���������� DALLAS�ٹ��� �μ��� �ϳ� �߰�
SELECT *FROM DEPT;
SELECT *FROM EMP; --���������� 50�� �μ� ��� �߰�
INSERT INTO EMP VALUES (9999, 'ȫ�浿', NULL, NULL, NULL, 9000, 900, 50);
SELECT * FROM EMP;
ROLLBACK;   --ȫ�浿 �ٽ� ��

SELECT
    *FROM DEPT D, EMP E
    WHERE E.ENAME = 'SCOTT' AND E.DEPTNO=D.DEPTNO;

SELECT E.ENAME
    FROM EMP E_SCOTT, EMP E, DEPT D_SCOTT, DEPT D
    WHERE E_SCOTT.DEPTNO=D_SCOTT.DEPTNO AND E_SCOTT.ENAME = 'SCOTT'
        AND D_SCOTT.LOC = D.LOC AND D.DEPTNO= E.DEPTNO AND E.ENAME != 'SCOTT';
    
    ��-3.��簡 KING�� ������� �̸��� ������ ����Ͻÿ�
SELECT W.ENAME �̸�, W.JOB ����
    FROM EMP W, EMP M
    WHERE M.ENAME = 'KING' AND W.MGR = M.EMPNO;

--�� 4.OUTER JOIN : ���ν� ���ǿ� �������� ���� ����� ��Ÿ����
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);   --�����Ͱ� ������ �ʿ� (+)
SELECT ENAME, D.DEPTNO, DNAME
    FROM EMP E, DEPT D  --40�� �μ� ����
    WHERE E.DEPTNO(+) = D.DEPTNO;  --E.DEPTNO���� 40�� �μ� ����
--���� ����� �̸� ���
SELECT W.EMPNO, W.ENAME, W.MGR, M.ENAME
    FROM EMP W, EMP M
    WHERE W.MGR(+) = M.EMPNO AND W.EMPNO IS NULL;
    
-- �� <��������> PART1
    --1. �̸�, ���ӻ��
SELECT W.ENAME �̸�, M.ENAME ���ӻ��
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;

    --2. �̸�, �޿�, ����, ���ӻ��
SELECT W.ENAME �̸�, W.SAL �޿�, W.JOB ����, M.ENAME ���ӻ��
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO;
    
    --3. �̸�, �޿�, ����, ���ӻ��. (��簡 ���� �������� ��ü ���� �� ���.
         --��簡 ���� �� '����'���� ���)
SELECT W.ENAME �̸�, W.SAL �޿�, W.JOB ����, NVL(M.ENAME, '����') ���ӻ��
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+) ;

    --4. �̸�, �޿�, �μ���, ���ӻ���
SELECT W.ENAME �̸�, W.SAL �޿�, DNAME �μ���, M.ENAME ���ӻ��
    FROM EMP W, EMP M, DEPT D
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO;
    
    --5. �̸�, �޿�, �μ��ڵ�, �μ���, �ٹ���, ���ӻ���, (��簡 ���� �������� ��ü ���� �� ���)
SELECT W.ENAME �̸�, W.SAL �޿�, W.DEPTNO �μ��ڵ�, DNAME �μ���, LOC �ٹ���, M.ENAME ���ӻ��
    FROM EMP W, EMP M, DEPT D
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO;
    
    --6. �̸�, �޿�, ���, �μ���, ���ӻ���. �޿��� 2000�̻��� ���
SELECT W.ENAME �̸�, W.SAL �޿�, GRADE ���, W.DEPTNO �μ��ڵ�, DNAME �μ���, M.ENAME ���ӻ��
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO AND W.SAL BETWEEN LOSAL AND HISAL AND W.SAL>=2000;
    
    --7. �̸�, �޿�, ���, �μ���, ���ӻ���, (���ӻ�簡 ���� �������� ��ü���� �μ��� �� ����)
SELECT W.ENAME �̸�, W.SAL �޿�, GRADE ���, DNAME �μ���, M.ENAME ���ӻ��
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO(+)
    ORDER BY DNAME;
    
    --8. �̸�, �޿�, ���, �μ���, ����, ���ӻ���. 
        --����=(�޿�+comm)*12 �� comm�� null�̸� 0
SELECT W.ENAME �̸�, W.SAL �޿�, GRADE ���, DNAME �μ���, (w.SAL+NVL(w.COMM,0))*12 ����, M.ENAME ���ӻ��
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO AND w.SAL BETWEEN LOSAL AND HISAL;

    --9. 8���� �μ��� �� �μ��� ������ �޿��� ū �� ����
SELECT W.ENAME �̸�, W.SAL �޿�, GRADE ���, DNAME �μ���, (w.SAL+NVL(w.COMM,0))*12 ����, M.ENAME ���ӻ��
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.DEPTNO = D.DEPTNO AND W.MGR = M.EMPNO AND w.SAL BETWEEN LOSAL AND HISAL
    ORDER BY DNAME, w.SAL DESC;
    
--�� <��������> PART2
    --1.EMP ���̺��� ��� ����� ���� �̸�, �μ���ȣ, �μ����� ����ϴ� SELECT ������ �ۼ��Ͽ���.
SELECT ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;

    --2. EMP ���̺��� NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ���
SELECT ENAME, JOB, SAL, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO;

    --3. EMP ���̺��� ���ʽ��� �޴� ����� ���Ͽ� �̸�,�μ���,��ġ�� ���
SELECT ENAME, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL OR COMM != 0;

    --4. EMP ���̺��� �̸� �� L�ڰ� �ִ� ����� ���Ͽ� �̸�,����,�μ���,��ġ�� ���
SELECT ENAME, JOB, DNAME, LOC
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%L%';

    --5. ���, �����, �μ��ڵ�, �μ����� �˻��϶�. ������������ ������������
SELECT EMPNO, ENAME, E.DEPTNO, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    ORDER BY ENAME;

    --6. ���, �����, �޿�, �μ����� �˻��϶�. 
        --�� �޿��� 2000�̻��� ����� ���Ͽ� �޿��� �������� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL>=2000
    ORDER BY SAL DESC;

    --7. ���, �����, ����, �޿�, �μ����� �˻��Ͻÿ�. �� ������ MANAGER�̸� �޿��� 2500�̻���
        -- ����� ���Ͽ� ����� �������� ������������ �����Ͻÿ�.
SELECT EMPNO, ENAME, JOB, SAL, DNAME
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND JOB = 'MANAGER' AND SAL>=2500
    ORDER BY EMPNO;  

    --8. ���, �����, ����, �޿�, ����� �˻��Ͻÿ�. ��, �޿����� ������������ �����Ͻÿ�
SELECT EMPNO, ENAME, JOB, E.SAL, GRADE ||'���' GRADE
    FROM EMP E, SALGRADE
    WHERE E.SAL BETWEEN LOSAL AND HISAL
    ORDER BY E.SAL DESC;  

    --9. ������̺��� �����, ����� ��縦 �˻��Ͻÿ�(��簡 ���� �������� ��ü)
 SELECT W.ENAME "���", M.ENAME "�����"
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);    

    --10. �����, ����, ����� ������ �˻��Ͻÿ�
SELECT W.ENAME "���", M.ENAME "�����", MM.ENAME "����� ���"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO(+) AND M.ENAME != W. ENAME AND M.MGR = MM.EMPNO(+) AND MM.ENAME! = M.ENAME;   

    --11. ���� ������� ���� ��簡 ���� ��� ������ �̸��� ��µǵ��� �����Ͻÿ�
SELECT W.ENAME "���", M.ENAME "�����", MM.ENAME "����� ���"
    FROM EMP W, EMP M, EMP MM
    WHERE W.MGR = M.EMPNO(+) AND M.MGR = MM.EMPNO(+);   



