--[II]SELECT 문-가장많이 쓰이는 DML(Data Manipulation Language); 검색 기능
--1. SELECT문장 작성법
--현재 계정(실행 : ctrl + Enter)
SHOW USER;
SELECT * FROM TAB;--현 계정(scott)이 가지고 있는 테이블
SELECT * FROM EMP;--EMP 테이블의 모든 열(필드), 모든 행
SELECT * FROM DEPT;--DEPT 테이블의 모든 열, 모든 행
--EMP 테이블의 구조
DESC EMP;
DESC DEPT;

--2. SQL문 실행 (특정 열만 출력)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "사 번", ENAME AS "이 름", SAL AS "급 여", JOB FROM EMP; --별칭
SELECT EMPNO AS 사번, ENAME AS 이름, SAL AS 급여, JOB FROM EMP;
SELECT EMPNO 사번, ENAME 이름, SAL 급여, JOB FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP;   --TITLE : NO, NAME, SALARY

--3. 특정행 출력 : WHERE 절(조건)-비교연산자; 같다(=), 크거나같다(>=)..다르다(!=, ^=, <>)
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL = 3000;  --같다
SELECT EMPNO "사번", ENAME "이름", SAL "급여" FROM EMP WHERE SAL != 3000; --다르다
DESC EMP;
    --비교연산자는 숫자, 문자, 날짜형 모두 가능
    --EX. 사원이름(ENAME)이 'A', 'B', 'C'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME < 'D';  --별칭 쓸 때만 " "사용, 문자는 ' '
    --EX. 81년도 이전에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
    --EX. 10번 부서번호(deptno)인 사원의 모든 필드를 출력
SELECT * FROM EMP WHERE DEPTNO = '10';
    --EX. 이름(ENAME)이 FORD인 직원의 EMPNO, ENAME, MGR(상사의 사번)을 출력
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD'; --데이터는 대소문자 구분

--4. 논리연산자 : AND, OR, NOT
    --EX. 급여(SAL)가 2000이상 3000이하인 직원의 모든 필드
SELECT * FROM EMP WHERE SAL >=2000 AND SAL<=3000;
    --EX. 82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';
    --날짜 표기법 세팅(현재 : YY/MM/DD OR RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YY';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; --한글 윈도우즈 위에 INSTALL
SELECT ENAME, HIREDATE FROM EMP;
    --연봉이 2400 이상인 직원의 ENAME, SAL, 연봉 출력(연봉 = SAL*12)
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12 > 2400;
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE 연봉 > 2400;    --WHERE절에는 별칭X
SELECT ENAME, SAL, SAL*12 "연봉" FROM EMP WHERE SAL*12>2400 ORDER BY 연봉;  --ORDER BY절은 별칭가능
    --10번 부서(DEPTNO)이거나 직책(JOB)이 MANAGER인 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
    --부서번호가 10번이 아닌 사람의 모든 필드
SELECT * FROM EMP WHERE DEPTNO != 10;
SELECT * FROM EMP WHERE NOT DEPTNO = 10;

--5. 산술표현식
SELECT ENAME, SAL "현재급여", SAL+100 "올릴급여" FROM EMP WHERE DEPTNO = 10;
    --EX. 모든 사원의 이름(ENAME), 월급(SAL), 상여(COMM), 연봉(SAL*12+COMM)
    --산술연산의 결과는 NULL포함하면 결과도 NULL!
    --NVL(NULL일 수도 있는 필드명, 대치값) 반드시 매겨변수 둘은 타입 같아야 함
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;  --틀린 답
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;
    --모든 사원의 사원명(ENAME), 상사의 사번(MGR)을 출력(상사 없으면 0)
SELECT ENAME, NVL(MGR, 0) FROM EMP;
SELECT ENAME, NVL(MGR, '없음') FROM EMP; --NVL 매개변수 타입 불일치 에러

--6. 연결연산자(||) : 열이나 문자를 연결
SELECT ENAME || '은' || JOB "EMPLOYEES" FROM EMP;
    --EX. "SMITH : 연봉 = XXX"과 같이 모든 행 출력(연봉 = SAL*12+COMM)
SELECT ENAME || ' : 연봉 = ' || (SAL*12+NVL(COMM, 0)) FROM EMP;

--7. 중복제거(DISTINCT)
SELECT JOB FROM EMP;
SELECT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

--8. SQL 연산자(BETWEEN, IN, LIKE, IS NULL)
    --(1)BETWEEN
        --EX. SAL이 1500이상 3000이하인 사번 이름 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500;  --X
        --EX. 1500미만, 3000초과하는 모든 필드 출력
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;

--★ 연습문제 꼭 풀기!
    --1. emp 테이블의 구조 출력 (오라클에서만 가능)
DESC EMP;

    --2. emp 테이블의 모든 내용을 출력 
SELECT * FROM EMP;

    --3. 현 scott 계정에서 사용가능한 테이블 출력
SHOW USER;  --SCOTT으로 접속돼있는지 확인
SELECT * FROM TAB; --현재 계정이 가지고 있는 테이블

    --4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;

    --5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;

    --6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE >= '81/02/01' ;
    --#날짜설정(YYYY 년도4자리/RR 년도2자리/M월/D일)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR' 
    --#날짜형->문자형으로 변환하는 함수 : TO_CHAT(날짜형데이터, 패턴)
    --#문자형->날짜형으로 변환하는 함수 : TO_DATE(문자형데이터, 패턴)
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '81/02/01' ;  --단일행함수(4장 참조)
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE >= TO_DATE('81/02/01', 'RR/MM/DD') ;  --단일행함수(4장 참조)
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'  --원상복귀^^

    --7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB = 'SALESMAN';

    --8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';

    --9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL <= 3000;

    --10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;

    --11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;

    --12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'MANAGER' AND SAL >= 2500;

    --13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT ENAME || '은 ' || JOB ||'업무이고 연봉은 ' ||(SAL*12+NVL(COMM,0))||'이다' FROM EMP;
    --(COMM은 상여금, NULL일 수 있기때문에 NVL붙여줘야함)




