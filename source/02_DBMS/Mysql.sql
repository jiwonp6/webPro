-- DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
-- DDL(제약조건, 시퀀스 없음)
-- DML(outer join, AND->&&, OR->||, 일부단일행함수)
-- java에서 쓸 데이터 넣고 연습해보기

show databases;	-- database 리스트 보기

-- ★ ★ ★ DCL(계정생성, 권한부여, 권한박탈, 계정삭제)
create user user01 identified by 'password';	-- 계정생성
grant all on *.* to user01;	-- 권한부여
revoke all on *.* from user01;	-- 권한 박탈
drop user user01;	-- 계정제거
-- 데이터베이스로 들어감
show databases;
create database parkdb;	-- 새로운 parkdb 데이터베이스 생성
use parkdb;	-- parkdb 데이터베이스로 들어감
select database();	-- 현재 들어와 있는 데이터베이스
use world;	-- world 데이터베이스로 들어감
use parkdb;	-- parkdb 데이터베이스로 들어감
show tables;	-- 오라클의 select * from tab;

-- ★ ★ ★ DDL(테이블 생성, 제약조건, 시퀀스 없음)
create table emp(
		empno numeric(4) primary key,
        ename varchar(20) not null,
        nickname varchar(20) unique,
        sal numeric(7, 2) check(sal>0),
        hiredate datetime default now(),
		comm numeric(7, 2) default 0
);
select * from emp;
-- Major (mCode(시퀀스같은 순차번호) : PK, mName, mOffice)
-- Student (sNo : PK, sName, mCode)

create table major(
	mCode int primary key auto_increment,	-- auto_increment일 경우 int
	mName varchar(20),
    mOffice varchar(50)
);
create table student(
	sNo int primary key,
    sName varchar(20),
    mCode int references major(mCode)
);
insert into major(mName, mOffice) values ('컴공', '402호');
insert into major(mName, mOffice) values ('경영', '502호');
insert into major(mName, mOffice) values ('경제', '301호');
select * from major;
insert into student values (1111, '홍',1);
insert into student values (2222, '이',2);
insert into student values (3333, '박',3);
insert into student values (4444, '김',4);
select * from student;
drop table if exists major;
drop table if exists student;

create table major(
	mCode int auto_increment,
    mName varchar(30) not null,
    mOffice varchar(30),
    primary key (mCode));
create table student(
	sNo int,
    sName varchar(20),
    mCode int,
    primary key(sNO),
    foreign key(mCode) references major(mCode)
);    
insert into major(mName, mOffice) values ('컴공', '402호');
insert into major(mName, mOffice) values ('경영', '502호');
insert into major(mName, mOffice) values ('경제', '301호');
select * from major;
insert into student values (1111, '홍',1);
insert into student values (2222, '이',2);
insert into student values (3333, '박',3);
insert into student values (4444, '김',4);
select * from student;

-- 학번, 이름, 학과코드, 학과명, 사무실
select sNo, sName, s.mCode, mName, mOffice
	from student s, major m
    where s.mCode = m.mCode;
    
-- 자바(JDBC) 수업시간에 쓸 테이블
drop table if exists personal;	-- emp 테이블 유사
drop table if exists division;	-- dept 테이블 유사
create table division(
	dNo int, -- 부서번호
    dName varchar(20),	-- 부서이름
    phone varchar(20),	-- 부서전화
    position varchar(20),	-- 부서위치
    primary key(dNo) );
insert into division values (10, 'finance', '02-545-5555', '강남');
insert into division values (20, 'research', '02-777-7777', '회현');
insert into division values (30, 'sales', '02-333-3333', '서초');
insert into division values (40, 'marketing', '02-666-6666', '과천');
select * from division;

create table personal(
	pNo int,	-- 사번
    pName varchar(20) not null,	-- 사원명
    job varchar(20) not null,	-- 직책
    manager int,	-- 상사의 사번
    startdate date,	-- 입사일
    pay int,	-- 급여
    bonus int,	-- 상여
    dNo int,	-- 부서번호
    primary key(pNo),
    foreign key(dNo) references division(dNo)
);

insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
commit;
select * from division;
select * from personal;
-- ★ DML 연습문제(outer join, 단일행함수 일부, top-N구문, and->&&, or->||)
-- 1. 사번, 이름, 급여를 출력
select pNo, pName, pay
	from personal;

-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select *
	from personal
    where pay between 2000 and 5000;

-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pNo, pName, dNo
	from personal
    where dNo in (10, 20);

-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pNo, pName, pay
	from personal
    where bonus is null
    order by pay desc;

-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pNo, pName, dNo, pay
	from personal
    order by dNo, pay desc;

-- 6. 사번, 이름, 부서명
select pNo, pName, dName
	from personal p, division d
    where p.dNo=d.dNo;

-- 7. 사번, 이름, 상사이름
select w.pNo, w.pName, m.pName
	from personal w, personal m
    where w.manager = m.pNo;

-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)	--outer join(오라클이랑 다름)
select w.pNo, w.pName, ifnull(m.pName, 'ceo')	-- nvl()이랑 같음
	from personal w left outer join personal m
    on w.manager = m.pNo;	-- 오른쪽의 데이터가 부족 -> left outer join
    
select w.pNo, w.pName, if(m.pName is null, 'ceo', m.pName)	-- m.pName is null이면 ceo, 아니면 m.pName
	from personal w left outer join personal m
    on w.manager = m.pNo;	-- 오른쪽의 데이터가 부족 -> left outer join

-- 9. 이름이 s로 시작하는 사원 이름
select pName
	from personal
    where pName like 's%';
-- substr(pName, 1, 1) = 's'

-- 10. 사번, 이름, 급여, 부서명, 상사이름
select w.pNo, w.pName, w.pay, d.dName, m.pName
	from personal w, personal m, division d
	where w.manager = m.pNo and w.dNo = d.dNo;

-- 11. 부서코드, 급여합계, 최대급여
select dNo, sum(pay) "sumpay", max(pay) "maxpay" 
	from personal 
	group by dNo;
-- 12. 부서명, 급여평균, 인원수
select d.dName, round(avg(p.pay), 2), count(pNo)
	from personal p, division d
    where p.dNo = d.dNo
    group by dName;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dNo, sum(pay), count(pNo)
	from personal 
    group by dNo
    having count(pNo)>3;
    
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select p.pNo, p.pName, p.pay
	from personal p, (select max(pay) "maxpay" from personal) p2
    where p.pay = p2.maxpay;

-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select p.pName, p.pay, p.dNo
	from personal p, (select avg(pay) "avgpay" from personal) p2
    where p.pay>p2.avgpay;

-- 16. 15번에 부서명을 추가하고 부서명순 정열 같으면 급여 큰순
select d.dName, p.pName, p.pay, p.dNo
	from division d, personal p, (select avg(pay) "avgpay" from personal) p2
    where d.dNo=p.dNo and p.pay>p2.avgpay
    order by d.dName, p.pay desc;

-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select p.pName, p.pay, p.dNo, roundavgpay
	from personal p, (select dNo, round(avg(pay)) "roundavgpay" from personal group by dNo) p2
    where p.dNo = p2.dNo and p.pay>roundavgpay;

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
select pName, pay, dName
	from personal p, division d, (select min(startdate) "minsd" from personal) p2
    where p.dNo = d.dNo and p.startdate = p2.minsd;

-- 19. 이름, 급여, 해당부서평균
select p.dNo, p.pName, p.pay, avgpay
	from personal p, (select dNo, avg(pay) "avgpay"from personal group by dNo) p2
    where p.dNo = p2.dNo
    order by p.dNo;

-- 20. 이름, 급여, 부서명, 해당부서평균
select p.dNo, p.pName, p.pay, d.dName, avgpay
	from personal p, division d, (select dNo, avg(pay) "avgpay"from personal group by dNo) p2
    where p.dNo = p2.dNo and p.dNo=d.dNo
    order by p.dNo;

-- Oracle에서의 단일행함수와 MySQL 컬럼함수의 다른 부분
select round(789.56, 2);	-- from절 생략가능
-- select pName || '은' || job || '이다' from personal;	--x
select concat(pName, '은', job, '이다') from personal;
-- 날짜 관련 컬럼함수
select year(startdate), month(startdate), day(startdate), 
			hour(startdate), minute(startdate), second(startdate), pName 
    from personal;
-- date_format(날짜형이나 시간형데이터, '포맷')
	-- 포맷글자: 년도2자리(%y), 년도4자리(%Y), 
    -- 월이름(%M), 0X월(%m), 짧은월이름(%b), X(월)(%c), 0X(월)(%d), 
    -- 일2자리(%e), 
    -- 24시간(%H), 12시간(%h), 
    -- 오전오후(%p), 분(%i), 초(%s) 
-- 시스템으로 부터 현재 날짜와 시간
select sysdate();
select now();
-- 시스템으로 현재 날짜
select current_date();
select curdate();
-- 시스템으로부터 현재 시간
select current_time();
select curtime();
select date_format(now(), '%Y년%m월%e일 %p %h시%i분');

-- to_char(날짜형데이터, '포맷') : yy/mm/dd

-- format(숫자데이터) : 3자리마다 콤마 추가
-- format(숫자데이터, 소수점자리수) : 소수점 확보되면서 3자리 콤마 추가
select format(pay, 1) from personal;

-- workbench에서 데이터 삭제하거나 수정(where절에 primary key를 이용한 비교)
insert into personal values (1000, 'hong', 'manager', 1001, curdate(), 9000, 900, 40);
commit;
set sql_safe_updates = 0;
delete from personal where pName = 'hong';

-- TOP-N구문
select rownum, pNo from personal;	-- rownum 없음
select pName, pay 
	from personal 
	order by pay desc; 
-- limit n (1~n등까지)
-- limit m-1이후 부터, n-m+1개 (m~n등까지)
select pName, pay 
	from personal 
	order by pay desc
    limit 2,3;	-- (3~5등까지)
    
    use parkdb;
    select * from personal;







