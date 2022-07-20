-- emp.sql
	SELECT * FROM DEPT;
	SELECT * FROM EMP;
	SELECT * FROM EMP WHERE ENAME LIKE '%'||'A'||'%';
	SELECT * FROM EMP WHERE JOB LIKE '%'||'E'||'%';
	SELECT * FROM EMP WHERE DEPTNO = 20;
-- Dept.xml의 id=deptList
	SELECT * FROM DEPT;
    commit;
-- Emp.xml의 id=empList
	SELECT * FROM EMP 
        WHERE 1=1 AND ENAME LIKE '%'||'A'||'%';
    SELECT * FROM EMP 
        WHERE 1=1   --모두 값이 안들어오면 여기까지 수행
          -- AND 로 엮여진 절은 하나만 들어와도 수행하도록 한줄씩 if문으로 처리
          AND ENAME LIKE '%'||'A'||'%' 
          AND JOB LIKE '%'||'E'||'%'
          AND DEPTNO=20;
