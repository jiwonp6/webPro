-- MEMBER
    -- memberList
    SELECT * FROM MEMBER;
    --get max custno
    SELECT MAX(CUSTNO) MAX FROM MEMBER;
    -- joinMember
    INSERT 
        INTO MEMBER(CUSTNO, CUSTNAME, PHONE, ADDRESS, JOINDATE, GRADE, CITY) 
        VALUES(MEMBER_SEQ.NEXTVAL, '정길동', '010-0000-0000', '서울', TO_DATE('20220727','YYYYMMDD'), 'A', '10' ); 
    -- getMemberDto
    SELECT * FROM MEMBER WHERE CUSTNO = '1001';
    -- modifyMember
    UPDATE MEMBER SET CUSTNAME = '',
                      PHONE = '',
                      ADDRESS = '',
                      GRADE = '',
                      CITY = ''
                  WHERE CUSTNO = '';
    -- salesList
    SELECT * FROM MONEY;
    SELECT * FROM GRADE;
    SELECT CUSTNO, SUM(PRICE) 
        FROM MONEY 
        GROUP BY CUSTNO;
    SELECT M.CUSTNO, M.CUSTNAME, G.GNAME, SUM(MONEY.PRICE) SUM
        FROM MEMBER M, GRADE G, MONEY MONEY
        WHERE M.GRADE = G.GRADE AND MONEY.CUSTNO = M.CUSTNO
        GROUP BY M.CUSTNO, M.CUSTNAME, G.GNAME
        ORDER BY SUM DESC;
    SELECT PCODE, SUM(PRICE) SUM
        FROM MONEY 
        GROUP BY PCODE
        ORDER BY SUM DESC;