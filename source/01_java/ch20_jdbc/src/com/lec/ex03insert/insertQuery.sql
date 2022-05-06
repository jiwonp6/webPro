--
INSERT INTO DEPT VALUES (50, 'IT', 'SEOUL');
ROLLBACK;
COMMIT;
-- 부서번호 중복체크
SELECT * FROM DEPT WHERE DEPT = 70; --rs.next()결과가 T(중복출력)/F(부서명, 부서위치 입력받아 계속진행)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;  --부서가 있으면 부서 갯수를 샐 수 있으니 0이 아님
--입력
INSERT INTO DEPT VALUES (70, 'IT', 'SEOUL');
ROLLBACK;

INSERT INTO DEPT VALUES (55, 'IT', 'SEOUL');
DELETE FROM DEPT WHERE DEPTNO = 55;
DELETE FROM DEPT WHERE DEPTNO = 66;
SELECT * FROM DEPT;

-- 수정
UPDATE DEPT SET DNAME = 'ABC', LOC = 'SEOUL' WHERE DEPTNO = '55';
commit;

-- 삭제
DELETE FROM DEPT WHERE DEPTNO = 55;

-- 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME = UPPER('sales');



