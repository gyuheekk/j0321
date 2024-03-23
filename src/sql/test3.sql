show tables;

-- 기본키(primary key) : 테이블을 대표하는 키, 중복을 허용하지 않는다. 기본키는 여러개가 올 수 있다. 
create table test1(
 	idx 		int not null auto_increment primary key,
 	name varchar(20) not null,
 	age int default 20,
 	assress varchar(50)
);
desc test1;
drop table test1;
insert into test1 values (default,'홍길동',default,'서울');
insert into test1 values (default,'김말숙',20,'청주');
insert into test1 values (1,'소나무',55,'제주'); /* 1번이 이미 있기때문에 값이 들어가지 않음 */
select * from test1;

create table test2(
 	idx 			int not null auto_increment primary key,
 	name 			varchar(20) not null,
 	age 			int default 20,
 	test2Code varchar(10) not null
 	/* primary key (idx, test2Code) primary key를 두개 이상 만들기 위해서는 이렇게 만들어야 함. 그러나 사용하기 애매함 */
);
desc test2;
drop table test2;
insert into test2 values (default,'이기자',23,'aaa');
insert into test2 values (default,'김길자',33,'bbb');
insert into test2 values (1,'소나무',55,'ccc'); 			 --o, x
insert into test2 values (default,'소나무',55,'bbb');  --o, o
select * from test2;

/* UNIQUE KEY: 중복불허를 위해 설정하는 키(PRIMARY KER를 대신해서 중복을 불허시키고자 할 때 사용한다.) */
create table test3(
 	idx 			int not null auto_increment,
 	name 			varchar(20) not null,
 	age 			int default 20,
 	job 			varchar(10) not null,
 	address 	varchar(20)	not null,
 	test3Code varchar(10) not null,
 	primary key (idx),
 	UNIQUE KEY(test3Code)
);
desc test3;
drop table test3;
insert into test3 values (default,'소나무',13,'학생','서울','ccc');
insert into test3 values (default,'대나무',43,'회사원','청주','eee');
insert into test3 values (default,'사과나무',27,'군인','대전','ggg');
insert into test3 values (1,'감나무',19,'fff'); 			--x
insert into test3 values (default,'감나무',19,'eee'); --x
select * from test3;

/* 외래키(Foreign key)
  	하나의 테이블에서 다른 테이블의 정보를 찾기 위해 연결해주는 역할을 할때 지정하는 키이다.
  	조건, 현재 테이블의 필드에 외래키로 설정하려 한다면, 반드시 상대쪽 테이블의 해당 필드는 primary key이거나 unique key로 등록되어 있어야 한다.
  	또한, 외래키로 지정하려는 필드는 상대쪽 테이블의 해당 필드 속성과 같아야 한다. 
*/
create table test4 (
 	idx 			int not null auto_increment primary key,
 	gender		char(2) default '남자',
 	test2Idx 	int not null,
 	test3Code varchar(10) not null,
 	foreign key (test2Idx) references test2 (idx),
 	foreign key (test3Code) references test3 (test3Code)
);
desc test4;
drop table test4;
insert into test4 values (default, default, 1, 'ggg');
insert into test4 values (default, default, 1, 'ccc');
select * from test4;

-- select 필드명 from 테이블명 where 조건식 옵션;
select *,gender from test3, test4;
select test3.*,gender from test3, test4;
select test4.Idx,gender from test3, test4;
select t3.idx as 고유번호,t4.gender as 성별 from test3 t3, test4 t4;

select t3.*,t4.gender from test3 t3, test4 t4 where t3.test3Code = t4.test3Code; /*inner join*/