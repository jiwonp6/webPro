--
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
ROLLBACK;
COMMIT;
-- �μ���ȣ �ߺ�üũ
SELECT * FROM DEPT WHERE DEPT = 70; --rs.next()����� T(�ߺ����)/F(�μ���, �μ���ġ �Է¹޾� �������)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;  --�μ��� ������ �μ� ������ �� �� ������ 0�� �ƴ�
--�Է�
INSERT INTO DEPT VALUES (70, 'IT', 'SEOUL');
ROLLBACK;

INSERT INTO DEPT VALUES (55, 'IT', 'SEOUL');
DELETE FROM DEPT WHERE DEPTNO = 55;
DELETE FROM DEPT WHERE DEPTNO = 66;
SELECT * FROM DEPT;

-- ����
UPDATE DEPT SET DNAME = 'ABC', LOC = 'SEOUL' WHERE DEPTNO = '55';
commit;

-- ����
DELETE FROM DEPT WHERE DEPTNO = 55;

-- �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ���
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('sales');



