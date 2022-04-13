--[VI]SUB QUERY : QUERY안에 QUERY가 내포
--SELECT 필드1, 필드2, (SELECT 필드 FROM 테이블 WHERE 조건)
--  FROM 테이블
--  WHERE 조건

--☆1.서브 쿼리 개념(필요성)
-- 급여를 제일 많이 받는 사람의 사번, 이름, 직책, 급여
SELECT MAX(SAL) 
    FROM EMP;
SELECT EMPNO, MAX(SAL) 
    FROM EMP
    GROUP BY EMPNO; --다찍혀
SELECT MAX(SAL) --서브쿼리
    FROM EMP;
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP
    WHERE SAL = (SELECT MAX(SAL) 
                    FROM EMP);  --메인쿼리(서브쿼리는 괄호로 묶여있어야함)
--서브쿼리의 종류(1) 단일행 서브쿼리(서브쿼리 결과가 단일행) : =, >, >=, <, <=, !=
    --EX.SCOTT이 근무하는 부서이름 출력
    --서브쿼리
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';   --서브
SELECT DNAME FROM DEPT WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT');   --메인
    --JOIN이용
SELECT DNAME FROM EMP E, DEPT D WHERE E.DEPTNO= D.DEPTNO AND ENAME ='SCOTT';
--서브쿼리의 종류(2) 다중행 서브쿼리(서브쿼리 결과 2행이상) : IN, ANY, EXITSTS
    --EX.JOB이 MANAGER인 사람의 부서이름
SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER';   --서브쿼리
SELECT DNAME FROM DEPT
    WHERE DEPTNO IN (SELECT DEPTNO FROM EMP WHERE JOB = 'MANAGER');
--☆2. 단일행 서브쿼리
    --아래 문제 전처리
    
SELECT E.DEPTNO, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO AND ENAME = 'SCOTT';
INSERT INTO DEPT VALUES(50, 'IT', 'DALLAS');
INSERT INTO EMP (EMPNO, ENAME, DEPTNO) VALUES (9999,'홍길동', 50);
SELECT*FROM DEPT;
SELECT*FROM EMP WHERE EMPNO=9999;
    --EX1.SCOTT과 같은 부서인 사람의 이름과 급여
SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT';--서브
SELECT ENAME, SAL FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'SCOTT') AND ENAME !='SCOTT';  --메인(서브만 실행시킬때 F9키)
    --EX2  .SCOTT과 같은 근무지인 사람의 이름과 급여
SELECT LOC FROM EMP E, DEPT D WHERE ENAME = 'SCOTT' AND E.DEPTNO = D.DEPTNO;   --서브
SELECT ENAME, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO 
        AND LOC = (SELECT LOC FROM EMP E, DEPT D WHERE ENAME = 'SCOTT' AND E.DEPTNO = D.DEPTNO)
        AND ENAME!='SCOTT';
ROLLBACK;   --데이터 추가 취소(DML-데이터추가, 수정, 삭제를 취소)
SELECT * FROM EMP WHERE EMPNO=9999;
SELECT * FROM DEPT;
    --EX.최초입사일과 최소입사한 사람이름
SELECT MIN(HIREDATE) FROM EMP;  --단일행 서브쿼리
SELECT HIREDATE "FIRST", ENAME "FIRSTMAN" FROM EMP
    WHERE HIREDATE = (SELECT MIN(HIREDATE) FROM EMP);   --메인쿼리
    --EX.최근입사일과 최근입사한 사람이름
SELECT MAX(HIREDATE) FROM EMP;  --단일행 서브쿼리
SELECT HIREDATE "LAST", ENAME "LASTMAN" FROM EMP
    WHERE HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);   --메인쿼리
    --EX.최초입사일과 최초입사한 사람이름, 최근입사일과 최근입사한 사람 이름
SELECT E1.HIREDATE, E1.ENAME, E2.HIREDATE, E2.ENAME FROM EMP E1, EMP E2
    WHERE E1.HIREDATE = (SELECT MIN(HIREDATE) FROM EMP) AND E2.HIREDATE = (SELECT MAX(HIREDATE) FROM EMP);
    --EX.SCOTT과 같은 부서에 근무하는 사람들의 급여합
SELECT DEPTNO
    FROM EMP
    WHERE ENAME='SCOTT';    --서브
SELECT SUM(SAL)
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                        FROM EMP
                        WHERE ENAME='SCOTT');   --단일
    --EX.SCOTT과 동일한 직책(JOB)을 가진 사원의 모든 필드
SELECT *
    FROM EMP
    WHERE JOB = (SELECT JOB
                    FROM EMP
                    WHERE ENAME = 'SCOTT')
        AND ENAME != 'SCOTT';
    --EX.DALLAS에서 근무하는 사원의 이름, 부서번호
SELECT ENAME, DEPTNO
    FROM EMP
    WHERE DEPTNO = (SELECT DEPTNO
                    FROM DEPT
                    WHERE LOC = 'DALLAS');
    --EX.'KING'이 직속상사인 사원의 이름과 급여
SELECT ENAME, SAL
    FROM EMP
    WHERE MGR = (SELECT EMPNO
                        FROM EMP
                        WHERE ENAME = 'KING');
SELECT W.ENAME, W.SAL
    FROM EMP W, EMP M
    WHERE W.MGR=M.EMPNO AND M.ENAME = 'KING';--SELF JOIN이용

    --EX1. 평균 급여 이하로 받는 사원의 이름과 급여를 출력
SELECT ENAME, SAL
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL)
                    FROM EMP);
    --EX2.평균급여 이하로 받는 사원의 이름, 급여, 평균급여 출력
SELECT ENAME, SAL, (SELECT ROUND(AVG(SAL),2) FROM EMP)
    FROM EMP
    WHERE SAL<=(SELECT AVG(SAL)
                    FROM EMP);
    
    
