<<<<<<< HEAD
--scott2�� ���� ��ųʸ� �� Ȯ��
SHOW USER;
SELECT * FROM USER_TABLES;  --SCOTT2�� ������ �ִ� ���̺�(�ƹ��͵� ����)
SELECT * FROM ALL_TABLES;   --SCOTT2�� ���ٰ����� ���̺�
SELECT * FROM ALL_TABLES WHERE TABLE_NAME IN ('DEPT', 'EMP'); --(EMP, DEPT���� �����°�)
SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D WHERE E.DEPTNO = D.DEPTNO;
EXIT;






=======
--scott2�� ���� ��ųʸ� �� Ȯ��
SHOW USER;
SELECT * FROM USER_TABLES;  --SCOTT2�� ������ �ִ� ���̺�(�ƹ��͵� ����)
SELECT * FROM ALL_TABLES;   --SCOTT2�� ���ٰ����� ���̺�
SELECT * FROM ALL_TABLES WHERE TABLE_NAME IN ('DEPT', 'EMP'); --(EMP, DEPT���� �����°�)
SELECT * FROM SCOTT.EMP E, SCOTT.DEPT D WHERE E.DEPTNO = D.DEPTNO;
EXIT;






>>>>>>> 96d58a64e5ebb5b1e4ae407f3b35890afe1e7606
