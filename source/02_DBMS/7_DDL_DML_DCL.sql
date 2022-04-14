--[VII] DDL, DML, DCL
--SQL = DDL(���̺� ����, ���̺� ����, ���̺� ��������, ���̺� ��� ������ ����)
--      DML(SELECT(������ �˻�), INSERT(������ �߰�), UPDATE(������ ����), DELETE(������ ����))
--      DCL(����ڰ�������, ����ڱ��Ѻο�, ���ѹ�Ż, ����ڰ�������, Ʈ����� ��ɾ� = ROLLBACK, COMMIT)

--��1.DDL
--1) ���̺� ����(CREATE TABLE)
CREATE TABLE BOOK(
    BOOKID NUMBER(4),           --������ȣ
    BOOKNAME VARCHAR2(300),     --å�̸�(BYTE)
    PUBLISHER VARCHAR2(300),    --���ǻ�
    RDATE DATE,                 --������
    PRICE NUMBER(8),            --����
    PRIMARY KEY(BOOKID) );      --BOOKID�� �����ؾ� �ϹǷ�

SELECT * FROM BOOK;