create table post(
	pnum int primary key,
	writer varchar(30) not null,
	title varchar(30) not null,
	content varchar(200) not null,
	wdate date default sysdate,
	member int,
	foreign key (member) references member(mnum) on delete cascade
);

create table member(
	mnum int primary key,
	id varchar(30),
	pw varchar(30)
);

drop table post;
drop table member;

delete from post;
delete from member;

select * from post;
select * from member;

insert into member values(1,'가렌','1111');
insert into member values(2,'티모','2222');
/* 샘플데이터 : 일반적으로 서비스 될때에는 샘플데이터 有! */

select * from all_tables;

