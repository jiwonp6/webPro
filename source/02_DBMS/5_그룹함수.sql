--[V]그룹함수 : SUM, AVG, MIN, MAX, COUNT, STDDEV(표준편차), VARIANCE(분산)

SELECT ENAME, ROUND(SAL, -3)    --단일행함수(4장) 
    FROM EMP;
SELECT MAX(SAL)
    FROM EMP;   --그룹함수(5장)
SELECT DEPTNO, MAX(SAL) --DEPTNO별로 MAX(SAL) 출력
    FROM EMP
    GROUP BY DEPTNO;
SELECT ENAME, MAX(SAL)  -에러(단일행과 다중행 같이 써서) 최대급여를 받는 사람의 이름(6장.서브쿼리)
    FROM EMP;
    
--☆1.그룹함수들 실습
    --(1)
SELECT ROUND(AVG(SAL),2)    --그룹함수 결과가 단일행이라 단일행 함수가능
    FROM EMP;
SELECT COUNT(*)     --EMP 테이블의 행(ROW)수 
    FROM EMP; 
SELECT ROUND(AVG(SAL),2), ROUND(SUM(SAL)/COUNT(SAL), 2)
    FROM EMP;
--모든 그룹함수는 NULL값을 제외!
SELECT COMM     --NULL값이 있는 COMM
    FROM EMP;
SELECT SUM(COMM)    --자동으로 NULL빼줌
    FROM EMP;
SELECT AVG(COMM), COUNT(COMM), MIN(COMM), MAX(COMM)
    FROM EMP;
--SAL의 평균, 합, 최소급여, 최대급여, 급여분산, 급여표준편차, 갯수
SELECT ROUND(AVG(SAL),2), SUM(SAL), MIN(SAL), MAX(SAL), ROUND(VARIANCE(SAL),2), ROUND(STDDEV(SAL),2)
    FROM EMP;
SELECT SQRT(VARIANCE(SAL)), STDDEV(SAL) --SQRT제곱근
    FROM EMP;
--그룹함수 MIN, MAX, COUNT는 숫자형, 문자형, 날짜형 모두 사용가능
SELECT MIN(ENAME), MAX(ENAME), COUNT(ENAME) ENAME갯수, COUNT(COMM) COMM갯수
    FROM EMP;
SELECT MIN(HIREDATE) 최초입사일, MAX(HIREDATE)최근입사일, COUNT(HIREDATE)
    FROM EMP;
    
    --  탄탄1.가장 최근에 입사한 사원의 입사일과 입사한지 가장 오래된 사원의 입사일을 출력. 
SELECT MIN(HIREDATE) 최초입사일, MAX(HIREDATE)최근입사일
    FROM EMP;   

    --  탄탄2.82/01/12 최근입사일 : XX,XXX일 근무, 80/12/17 최초입사일 : XX,XXX일 근무
SELECT MAX(HIREDATE)||' 최근입사일 : '||TO_CHAR(SYSDATE-MAX(HIREDATE)+1, '999,999') ||'일 근무, '
        ||MIN(HIREDATE)||' 최초입사일 : '||TO_CHAR(SYSDATE-MIN(HIREDATE)+1, '999,999') ||'일 근무'
    FROM EMP;
SELECT MAX(HIREDATE)||' 최근입사일 : '||TO_CHAR(MIN(SYSDATE-HIREDATE)+1, '99,999')||'일 근무, '
        ||MIN(HIREDATE)||' 최초입사일 : '||TO_CHAR(MAX(SYSDATE-HIREDATE)+1, '99,999')||'일 근무'
    FROM EMP;
--10번 부서 소속의 사원 급여평균
SELECT ROUND(AVG(SAL), 2) 
    FROM EMP
    WHERE DEPTNO = 10;
--☆2.GROUP BY 절
    --부서번호별 최대급여, 최소급여, 급여평균, 급여합
        --GROUP BY 절에는 컬럼의 별칭 사용 불가
SELECT DEPTNO 부서, MAX(SAL), MIN(SAL), AVG(SAL), SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO;
    --EX.SAL이 5000미만인 사원에 대해서만 부서번호별 사원수, 최대급여, 최소급여, 평균급여(부서번호순 정렬)
SELECT DEPTNO, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)  --SELECT절에서는 필드 별칭 사용 가능
    FROM EMP
    WHERE SAL<5000  --WHERE절에서는 필드 별칭 사용불가
    GROUP BY DEPTNO   --GROUP BY 절에서는 필드 별칭 사용불가
    ORDER BY DEPTNO;  --ORDER BY 절에서는 필드 별칭 사용가능
    --EX.부서명별 사원수, 최대급여, 최소급여, 평균급여(소수점 2자리)
SELECT DNAME, COUNT(*), MAX(SAL), MIN(SAL), ROUND(AVG(SAL),2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    ORDER BY COUNT(*) DESC;

--☆3.HAVING 절 : 그룹함수 결과의 조건
--부서번호별 평균 급여(평균 급여가 2000이상인 부서만 출력)
SELECT DEPTNO, ROUND(AVG(SAL),2) "AVG"
    FROM EMP
    GROUP BY DEPTNO
    HAVING AVG(SAL)>=2000   --HAVING절에는 필드 별칭 사용 불가
    ORDER BY AVG;
--EX.SAL이 5000미만인 사원에 대해 부서명별 최소급여, 최대급여, 평균급여 출력(단, 평균급여가 1800이상인 부서명에 대해서 평균급여순으로 정렬 출력)
SELECT DNAME, ROUND(MIN(SAL),2), ROUND(MAX(SAL), 2), ROUND(AVG(SAL), 2)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND SAL<5000
    GROUP BY DNAME
    HAVING AVG(SAL)>=1800
    ORDER BY AVG(SAL);
    
--☆4. 결과 집계합 내 집계값 생성
--10 MANAGER 2500
--20         3500
--30         7500
--합
SELECT DEPTNO, SUM(SAL)
    FROM EMP
    GROUP BY ROLLUP(DEPTNO);    --집계들의 집계(합계의 합계 출력)
    --부서별, JOB별 급여합
SELECT DEPTNO, JOB, SUM(SAL)
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO;
    --부서별, JOB별 급여합(소계와 전체합 포함)
SELECT DEPTNO, NVL(JOB, '계'), SUM(SAL)
    FROM EMP
    GROUP BY ROLLUP(DEPTNO, JOB);

-- ★<총 연습문제>

-- 1. 인원수,최대 급여,최소 급여,급여의 합을 출력
SELECT COUNT(*) 인원수, MAX(SAL) 최대급여, MIN(SAL) 최소급여, SUM(SAL) 급여합
    FROM EMP;

-- 2. 업무별 인원수를 구하여 출력
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY DEPTNO;

--- 3. 최고 급여와 최소 급여의 차이는 얼마인가 출력
SELECT MAX(SAL)-MIN(SAL)
    FROM EMP;

-- 4. 각 부서별로 인원수, 급여 평균, 최저 급여, 최고 급여, 급여의 합을 출력(급여의 합이 많은 순으로)
SELECT DEPTNO, COUNT(*), ROUND(AVG(SAL),2), MIN(SAL), MAX(SAL), SUM(SAL) "급여합"
    FROM EMP
    GROUP BY DEPTNO
    ORDER BY SUM(SAL) DESC;

-- 5. 부서별, 업무별 그룹하여 결과를 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 출력(부서번호, 업무순으로 오름차순 정렬)
SELECT DEPTNO, JOB, COUNT(*), ROUND(AVG(SAL), 2) 급여평균, SUM(SAL) 급여합
    FROM EMP
    GROUP BY DEPTNO, JOB
    ORDER BY DEPTNO, JOB;

-- 6. 업무별, 부서별 그룹하여 결과를  업무, 부서번호, 인원수, 급여의 평균, 급여의 합을 출력(출력결과는 업무순, 부서번호 순 오름차순 정렬)
SELECT JOB, DEPTNO, COUNT(*), ROUND(AVG(SAL), 2) 급여평균, SUM(SAL) 급여합
    FROM EMP
    GROUP BY JOB, DEPTNO
    ORDER BY JOB, DEPTNO;

--7. 사원수가 5명이상 넘는 부서번호와 사원수를 출력
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=5
    ORDER BY DEPTNO;

-- 8. 사원수가 5명이상 넘는 부서명과 사원수를 출력
SELECT DNAME, COUNT(*)
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO
    GROUP BY DNAME
    HAVING COUNT(*)>=5;

--9. 업무별 급여의 평균이 3000이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, ROUND(AVG(SAL), 2) 평균급여, SUM(SAL) 급여합
    FROM EMP
    GROUP BY JOB
    HAVING AVG(SAL)>=3000;

--10. 급여 합이 5000을 초과하는 각 업무에 대해서 업무와 급여합을 출력(급여 합계순 내림차순 정렬)
SELECT JOB, SUM(SAL) 급여합
    FROM EMP
    GROUP BY JOB
    HAVING SUM(SAL)>5000
    ORDER BY SUM(SAL)  DESC;

--11. 부서별 급여평균, 부서별 급여합계, 부서별 최소급여를 출력
SELECT DEPTNO, ROUND(AVG(SAL), 2) 급여평균, SUM(SAL) 급여합계, MIN(SAL) 최소급여
    FROM EMP
    GROUP BY DEPTNO;

--12. 위의 11번을 수정하여, 부서별 급여평균 최대치, 부서별 급여합의 최대치, 부서별 최소급여의 최대치를 출력
SELECT MAX(ROUND(AVG(SAL), 2)) 급여평균_최대치, MAX(SUM(SAL)) 급여합계_최대치, MAX(MIN(SAL)) 최소급여_최대치
    FROM EMP
    GROUP BY DEPTNO;

--13. 사원 테이블에서 아래의 결과를 출력
--   H_YEAR	COUNT(*)	MIN(SAL)	MAX(SAL)	AVG(SAL)	SUM(SAL)
--  80	  1		    800		    800		    800		    800
--	81	 10		    950		    5000	    2282.5	  22825
--	82	  2		    1300	    3000	   2150		   4300
--	83	  1		    1100	    1100	    1100	   1100
SELECT TO_CHAR(HIREDATE, 'RR') H_YEAR, COUNT(*), MIN(SAL), MAX(SAL), ROUND(AVG(SAL),1), SUM(SAL)
    FROM EMP
    GROUP BY TO_CHAR(HIREDATE, 'RR')
    ORDER BY TO_CHAR(HIREDATE, 'RR');

-- 14.  아래의 결과를 출력(입사년도별 사원수)
--  1980     1	
--  1981     10
--  1982     2
--  1983     1
--  total    14	
SELECT NVL(TO_CHAR(HIREDATE, 'YYYY'), 'total')입사년도, COUNT(*) 사원수
    FROM EMP
    GROUP BY ROLLUP(TO_CHAR(HIREDATE, 'YYYY'))
    ORDER BY TO_CHAR(HIREDATE, 'YYYY');

--15. 최대급여, 최소급여, 전체급여합, 평균을 출력
SELECT MAX(SAL), MIN(SAL), SUM(SAL), ROUND(AVG(SAL),2)
    FROM EMP;

--16. 부서별 인원수 출력
SELECT DEPTNO, COUNT(*)
    FROM EMP
    GROUP BY DEPTNO;

--17. 부서별 인원수가 6명이상인 부서번호 출력
SELECT DEPTNO
    FROM EMP
    GROUP BY DEPTNO
    HAVING COUNT(*)>=6;

--18. 급여가 높은 순서대로 등수를 부여하여 다음과 같은 결과가 나오게 하시오. 
-- (힌트 self join, group by, count사용)
--ENAME	    등수
--________________________
--KING		1
--SCOTT		2
--……
SELECT A.ENAME, COUNT(B.ENAME)+1 "등수"
    FROM EMP A, EMP B
    WHERE A.SAL<B.SAL(+)
    GROUP BY A.ENAME
    ORDER BY 등수;
    
SELECT ENAME, RANK() OVER(ORDER BY SAL DESC) "RANK",
        DENSE_RANK() OVER(ORDER BY SAL DESC) "DENSE_RANK",
        ROW_NUMBER() OVER(ORDER BY SAL DESC) "ROW_NUMBER"
    FROM EMP;
    
    
    
    
    
    