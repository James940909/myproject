create table testBoard(
	bnum int primary key,
	title varchar(100),
	content varchar(4000),
	writer varchar(30),
	pdate date default sysdate
);

create table testMember(
	id varchar(200) primary key,
	pw varchar(30) not null,
	name varchar(30)
);

select * from all_tables;
select * from testBoard;
select * from testMember;

delete TESTBOARD where BNUM=9;

drop table testBoard;

insert into TESTBOARD (bnum, title, content, writer) values (0,'�׽�Ʈ ����', '�׽�Ʈ����', '�׽�Ʈ�ۼ���');
insert into TESTMEMBER (id, pw, name) values ('abc', '123', '�׽�Ʈ���̵�');