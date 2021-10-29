create table users(
	u_num int primary key,
	id varchar(200),
	pw varchar(200) not null,
	u_name varchar(100),
	u_gender varchar(30),
	u_height number(4,1),
	u_weight number(4,1),
	successCnt int default 0,
	u_profile varchar(2000)
);

create table meal(
	m_num int primary key,
	m_name varchar(200),
	m_weight number(5,1),
	m_unit varchar(50),
	m_kcal number(5,1)
);

create table daymeal(
	d_num int primary key,
	d_name varchar(100),
	d_date date default sysdate,
	d_category varchar(100),
	d_daykcal number(5,1),
	d_userskcal number(5,1),
	d_users int,
	foreign key (d_users) references users(u_num) on delete cascade
);
INSERT INTO daymeal (d_num, d_date, d_category, d_daykcal, d_userskcal, d_users) VALUES ((SELECT nvl(max(d_num),0)+1 from daymeal),sysdate,'¾ÆÄ§',2345.85,310.0,1);
select * from all_tables;
select * from users;
select * from meal;
select * from daymeal;

select m_kcal from meal where m_name='½Ò¹ä';


delete TESTBOARD where BNUM=9;
delete USERS where U_NUM=1;

drop table users;
drop table daymeal;

insert into meal (m_num, m_name, m_weight, m_unit, m_kcal)
values (5, '±è¹ä', 200.0, 'g', 318.0);


insert into USERS (u_num, id, pw, u_name, u_gender, u_height, u_weight, successCnt)
values (1, 'admin', '123','°ü¸®ÀÚ', '³²¼º', 180.2, 82.3, 1);

