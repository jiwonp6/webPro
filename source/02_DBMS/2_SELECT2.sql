--8. SQL 연산자(BETWEEN, IN, LIKE, IS NULL)
    --(1)BETWEEN : (문법)데이터 BETWEEN ~ AND ~;
        --EX. SAL이 1500이상 3000이하인 사번 이름 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500;  --X
        --EX. 1500미만, 3000초과하는 모든 필드 출력
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
        --EX. 82년도에 입사한 직원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';  --(82/01/01보다 크거나 같고 82/12/31보다 작거나 같은)
        --EX.사원이름이 'A'나 'B'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME !='C';  --(A보다 크거나 같고 C보다 작은)
        --EX.사원이름이 'B'나 'C'로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME !='D';

    --(2) IN : (문법)데이터 IN(A, B, C ...);
        --EX.부서번호가 10이거나 20이거나 40번인 부서 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO =10 OR DEPTNO =20 OR DEPTNO =40;
SELECT * FROM EMP WHERE DEPTNO IN (10, 20, 40);
        --EX.부서번호가 10, 20, 40번 부서를 제외한 사원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO NOT IN (10, 20, 40);
SELECT * FROM EMP WHERE DEPTNO !=10 AND DEPTNO <>20 AND DEPTNO ^=40;
        --EX.사번이 7902, 7788, 7566인 사원의 모든 필드
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);

    --(3) LIKE 연산 : (문법)데이터 LIKE 패턴(%(와일드 카드):0글자 이상, _:한글자)
        --EX.이름에 M이 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%M%';   --'M' 앞뒤로 0글자 이상 들어갈 수 있음
        --EX.이름이 M으로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE 'M%';    --'M'으로 시작
        --EX.이름이 S로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';    --'S'로 끝
        --EX.SAL이 5로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE SAL LIKE '%5';     --'5'로 끝 
SELECT * FROM EMP WHERE SAL LIKE '2975';    --(숫자형과 문자형 비교가능)
        --EX.82년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = 82;
        --EX.1월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';     --'__/01__'도 가능
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '%/01/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = 01;
        --EX.82년도가 아닌 년도에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';
        --EX.이름에 S가 들어간 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S%';
        --EX.%가 들어간 모든 것
SELECT * FROM EMP WHERE ENAME LIKE '%%%';   --모든 필드
INSERT INTO EMP VALUES (9999, 'HONG%', NULL, NULL, NULL, 9000, 900, 40);    --데이터 입력
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\'; 
ROLLBACK;   --DML(데이터 추가, 삭제, 수정)로 수정된 데이터 원상복귀(DML취소)

    --(4) IS NULL 
SELECT * FROM EMP;
        --EX.상여금(COMM)이 NULL인 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NULL;   --NULL 비교시 반드시 IS NULL로!
        --EX.상여금이 없는 사원의 모든 필드(COMM이 NULL이거나 0)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
        --EX.상여금이 있는 사원의 모든 필드
SELECT * FROM EMP WHERE COMM IS NOT NULL AND COMM != 0;

--9. 정렬(오름차순, 내림차순)
SELECT ENAME, SAL FROM EMP ORDER BY SAL;    --급여 오름차순 정렬(ASC 생략)
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC;    --급여 오름차순 정렬
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC;   --급여 내림차순 정렬
SELECT ENAME, SAL FROM EMP ORDER BY ENAME ASC;  --이름 알파벳순(오름) 정렬
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; --이름 알파벳 역순(내림) 정렬
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE ASC;  --날짜 순서대로 정렬
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; --최신 순서대로 정렬
    --EX.이름, 연봉(SAL*12+COMM)을 출력(연봉이 높은 순으로, 연봉 같으면 같은 사람의 이름 알파벳 순)
SELECT ENAME, SAL*12+NVL(COMM,0) "ANNUAL_SAL" 
    FROM EMP 
    ORDER BY ANNUAL_SAL DESC, ENAME ASC;    --ORDER BY 절에는 별칭 사용 가능(FROM->WHERE->SELECT->ORDER(순서))
    --EX.사번, 이름, 입사일, 급여, 부서번호(부서번호순, 부서 같으면 입사일 순으로 오름차순으로 출력)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;

--★ 시험 연습문제(꼭 구현하기)
    --1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP 
    WHERE SAL>=3000;
 
    --2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO 
    FROM EMP 
    WHERE EMPNO = '7788';

    --3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL 
    FROM EMP 
    WHERE (SAL*12+NVL(COMM,0))>=24000 
    ORDER BY SAL;

    --4.	DLQ싸일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE 
    FROM EMP 
    WHERE HIREDATE 
    BETWEEN '81/02/20' AND '81/05/01' 
    ORDER BY HIREDATE;

    --5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP 
    WHERE DEPTNO=10 OR DEPTNO=20 
    ORDER BY ENAME;

    --6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
        -- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME "employee", SAL "Monthly Salary" 
    FROM EMP 
    WHERE SAL >= 1500 AND (DEPTNO=10 OR DEPTNO = 30);

    --7.	hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP 
    WHERE HIREDATE LIKE '82/%';

    --8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL 
    FROM EMP 
    WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME !='Q' 
    ORDER BY ENAME;

    --9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 
        --출력하는 SELECT 문을 작성
SELECT ENAME, SAL, NVL(COMM,0) 
    FROM EMP 
    WHERE NVL(COMM,0) >= SAL*1.1;

    --10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP 
    WHERE (JOB IN('CLERK', 'ANALYST')) AND (SAL NOT IN(1000, 3000, 5000));

    --11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
        --모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP 
    WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;

    --12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL 
    FROM EMP 
    WHERE HIREDATE LIKE '81/%';

    --13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
        -- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL 
    FROM EMP 
    WHERE HIREDATE LIKE '81%' AND JOB !='SALESMAN';

    --14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
        -- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL 
    FROM EMP 
    ORDER BY SAL DESC, HIREDATE;

    --15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME 
    FROM EMP 
    WHERE ENAME LIKE '__N%';

    --16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME 
    FROM EMP 
    WHERE ENAME LIKE '%A%';

    --17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.
SELECT EMPNO, ENAME, (SAL*12+NVL(COMM, 0)) "연봉"
    FROM EMP 
    WHERE (SAL*12+NVL(COMM, 0))>=35000;




