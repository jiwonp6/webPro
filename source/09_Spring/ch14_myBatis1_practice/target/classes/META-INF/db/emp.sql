--empList
	SELECT * FROM EMP;
--deptList
	SELECT * FROM DEPT;
--emp 특정인 출력(이름/직업/부서)
	SELECT * FROM EMP WHERE 1=1
    	AND ENAME LIKE '%'||'A'||'%'
    	AND JOB LIKE '%'||'C'||'%'
    	AND DEPTNO=10;