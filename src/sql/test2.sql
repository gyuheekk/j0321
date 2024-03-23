show tables;

create table insarok (
	idx			int not null auto_increment primary key, 	/* 고유번호 */
	buser 	varchar(10) not null, 										/* 부서명 */
	name		varchar(20) not null, 										/* 부서원(성명) */
	jikwl 	varchar(10) not null default '사원', 				/* 직위 */
	gender 	char(2) not null default '남자', 						/* 성별 */
	age			int default 25, 													/* 나이 */
	ipsail  datetime not null default now(), 					/* 입사일(기본값: 오늘날짜) / now()->오늘날짜를 알려주는 함수 */
	address varchar(50) 															/* 주소(공백 허용) */
	/* primary key(idx) */
);
desc insarok;
-- drop table insarok;

insert into insarok values (default,'인사과','홍길동','과장',default,38,'1995-1-5','서울');
insert into insarok values (default,'총무과','김말숙','부장',default,45,'1990-11-5','청주');
insert into insarok values (default,'영업과','이기자','사원',default,28,'2015-4-15','부산');
insert into insarok values (default,'자재과','강감찬','대리',default,33,'2003-11-5','대구');
insert into insarok values (default,'영업과','대나무','사원',default,25,'2020-3-19','울산');
insert into insarok values (default,'인사과','오하늘','대리',default,32,'2002-1-14','제주');
insert into insarok values (default,'영업과','탁민아','과장',default,34,'2001-1-29','인천');
insert into insarok values (default,'인사과','김기자','부장',default,45,'1999-10-5','수원');
insert into insarok values (default,'영업과','이순신','대리',default,33,'2004-7-25','제주');
insert into insarok values (default,'영업과','고인돌','과장',default,39,'1998-6-25','충주');
insert into insarok values (default,'영업과','감나무','사원',default,26,'2019-3-16','진천');
insert into insarok values (default,'영업과','나도야','과장',default,42,'1997-2-11','청주');
insert into insarok values (default,'영업과','나라다','과장',default,39,'1998-5-25','인천');
insert into insarok values (default,'총무과','최민아','부장',default,38,'1993-3-14','서울');
insert into insarok values (default,'영업과','조현서','과장',default,37,'1996-2-14','부산');
insert into insarok values (default,'총무과','손흥민','과장',default,35,'1997-9-23','대구');
insert into insarok values (default,'자재과','김연아','대리',default,33,'1998-12-3','대전');
insert into insarok values (default,'영업과','홍길동','사원',default,31,'2013-6-20','광주');
insert into insarok values (default,'총무과','최소영','사원',default,27,'2013-3-8','서울');
insert into insarok values (default,'인사과','안소은','대리',default,29,'2005-4-5','청주');
insert into insarok values (default,'자재과','김도완','사원',default,27,'2007-12-2','제주');

select * from insarok;

-- insarok테이블의 성명/직위/주소 필드만 모든 자료 표시?
select name,jikwl,address from insarok;

--홍길동 레코드만 출력?
select * from insarok where name='홍길동';

--'서울'에 사는 '홍길동' 레코드만 출력?
select * from insarok where address='서울' and name='홍길동';

--홍길동 사원만 출력?
select * from insarok where address='서울' and jikwi='사원';

--'서울'에 사는 모든 사람?
select * from insarok where address='서울';

-- 입사년도가 2000년 이전에 입사한 직원을 보여주시오?
select * from insarok where ipsail < '2000-1-1';

--'서울'에 살지 않는 직원?
select * from insarok where address != '서울';
select * from insarok where address <> '서울';

-- 입사년도가 2000년~2010년에 입사한 직원을 보여주시오?
select * from insarok where ipsail >= '2000-1-1' and ipsail <= '2010-12-31';
--앞의 범위 연산자 대신에 between~and 변경 가능
select * from insarok where ipsail between '2000-1-1' and '2010-12-31';

--30대 회사원 출력?
select * from insarok where age >= 30 and age <= 39;
select * from insarok where age between 30 and 39;

--'서울/부산'에 사는 직원?
select * from insarok where address='서울' or address='부산';
-- 앞의 or연산자는 in()으로 변경 가능
select * from insarok where address in('서울','부산');

--'서울/부산'에 사는 사원?
select * from insarok where jikwl='사원' and address in('서울','부산');

--'김'씨만 출력?
select * from insarok where name like '홍%';

--나무로 끝나는 이름을 가진 직원 출력?
select * from insarok where name like '%나무';

-- '나라다'를 '김민규'로 이름 변경?
update insarok set name='나라다' where name='김민규';
update insarok set name='고인돌' where name='재다라';

-- 이름중에서 '민'라는 글자를 포함한 직원의 직급을 '과장'으로 변경하시오?
select * from insarok where name like '%민%';
update insarok set jikwl='과장' where name like '%민%';

--이름 중 2번째 글자가 '나'인 직원은?
select * from insarok where name like '_나%';

--이름중에서 민이라는 글자를 포함한 직원 중에서 서울에 사는 직원의 입사일?
select name,ipsail from insarok where name like '%민%' and address='서울';

--이름중에서 '민'이라는 글자가 포함된 직원 중에서 '서울'사는 직원 중 나이가 37이상인 사람을 퇴사시키시오?
select * from insarok where name like '%민%' and address='서울';
delete from insarok where name like '%민%' and address='서울' and age >= 37;

--'최소영'성별을 여자로 변경?
update insarok set gender='여자' where name='최소영';

--이름 오름차순으로 출력? (순서 : order by ~~, 오름차순:asc(생략가능), 내림차순: desc)
select * from insarok order by name;
select * from insarok order by name desc;

--남자인 자료 중에서 나이 오름차순으로 출력?
select * from insarok where gender='남자' order by age;

--남자인 자료중에서 나이 오름차순으로, 같은 나이면 입사일 내립차순 출력?
select * from insarok where gender='남자' order by age, ipsail desc;
select * from insarok where gender='남자' order by age;

--전체자료중에서 5명만 출력하시오? (입력순서 중 앞에서 5개)
select * from insarok limit 5;

--뒤에서 5명(나중에 입력한 회원)만 출력?
select * from insarok order by idx desc limit 5;

--남자회원 5명만 나이 내림차순으로 보여주시오.(limit 출력개수)
select * from insarok where gender='남자' order by age desc limit 5;

--남자회원중 앞에서 2명을 빼고, 5명만 출력하시오? (limit인덱스 번호, 출력개수)
select * from insarok where gender='남자' order by idx limit 2,5;
