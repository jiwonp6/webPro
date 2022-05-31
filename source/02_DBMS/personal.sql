show databases;
use parkdb;
select * from personal;
drop table if exists personal; -- emp 테이블과 유사
drop table if exists division; -- dept 테이블과 유사
create table division(
	dno   int,         -- 부서번호
    dname varchar(20), -- 부서이름
    phone varchar(20), -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno) );
insert into division values (10, 'finance', '02-545-5555','강남');
insert into division values (20, 'research', '02-777-7777','회현');
insert into division values (30, 'sales', '02-333-3333','서초');
insert into division values (40, 'marketing', '02-666-6666','과천');
create table personal(
	pno   int,                  -- 사번
    pname varchar(20) not null, -- 사원명
    job   varchar(20) not null, -- 직책
    manager int,                -- 상사의 사번
    startdate date,             -- 입사일
    pay      int,               -- 급여
    bonus    int,               -- 상여 
    dno      int,               -- 부서번호
    primary key(pno),
    foreign key(dno) references division(dno)  );

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