create table users(
	u_num int primary key,
	id varchar(200),
	pw varchar(200) not null,
	u_name varchar(100),
	u_gender varchar(30),
	u_height number(4,1),
	u_weight number(4,1),
	u_daykcal number(5,1) default 0,
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
	d_weight number(5,1),
	d_userskcal number(5,1),
	d_users int,
	foreign key (d_users) references users(u_num) on delete cascade
);

create table totalmeal(
	t_num int,
	t_date date default sysdate,
	t_users varchar(100),
	t_daykcal number(5,1),
	t_userskcal number(5,1),
	t_ox varchar(20),
	foreign key (t_num) references users(u_num) on delete cascade
);

INSERT INTO daymeal (d_num, d_name, d_date, d_category, d_weight, d_userskcal, d_users)
VALUES ((SELECT nvl(max(d_num),0)+1 from daymeal),'±Ëπ‰',sysdate,'æ∆ƒß',318.0,318.0,20);
select * from all_tables;
select * from users;
select * from meal;
select * from daymeal;
select * from totalmeal;

INSERT INTO totalmeal (t_num, t_date, t_users, t_daykcal, t_userskcal, t_ox)
VALUES (15, to_date('11-03-2021 01:00:00','MM-DD-YYYY HH24:MI:SS'), 'ø¿¿œ≥≤', 1994.8, 1917.5, 'O');
INSERT INTO totalmeal (t_num, t_date, t_users, t_daykcal, t_userskcal, t_ox)
VALUES (15, to_date('11-04-2021 01:00:00','MM-DD-YYYY HH24:MI:SS'), 'ø¿¿œ≥≤', 1994.8, 2046.4, 'X');
INSERT INTO totalmeal (t_num, t_date, t_users, t_daykcal, t_userskcal, t_ox)
VALUES (15, to_date('11-05-2021 01:00:00','MM-DD-YYYY HH24:MI:SS'), 'ø¿¿œ≥≤', 1994.8, 2112.3, 'X');
INSERT INTO totalmeal (t_num, t_date, t_users, t_daykcal, t_userskcal, t_ox)
VALUES (15, to_date('11-06-2021 01:00:00','MM-DD-YYYY HH24:MI:SS'), 'ø¿¿œ≥≤', 1994.8, 2434.9, 'X');
INSERT INTO totalmeal (t_num, t_date, t_users, t_daykcal, t_userskcal, t_ox)
VALUES (15, to_date('11-07-2021 01:00:00','MM-DD-YYYY HH24:MI:SS'), 'ø¿¿œ≥≤', 1994.8, 2539.1, 'X');
INSERT INTO totalmeal (t_num, t_date, t_users, t_daykcal, t_userskcal, t_ox)
VALUES (15, to_date('11-08-2021 01:00:00','MM-DD-YYYY HH24:MI:SS'), 'ø¿¿œ≥≤', 1994.8, 2520.4, 'X');









select m_kcal from meal where m_name='Ω“π‰';

UPDATE users SET successCnt=5 WHERE u_num=10;
UPDATE users SET successCnt=6 WHERE u_num=11;
UPDATE users SET successCnt=2 WHERE u_num=12;
UPDATE users SET successCnt=3 WHERE u_num=13;
UPDATE users SET successCnt=4 WHERE u_num=14;
UPDATE users SET successCnt=1 WHERE u_num=15;


delete TESTBOARD where BNUM=9;
delete USERS where U_NUM=1;
delete meal where m_num=18;
delete daymeal where d_users=11;
delete totalmeal where t_num=10;


drop table users;
drop table daymeal;

insert into meal (m_num, m_name, m_weight, m_unit, m_kcal)
values (5, '±Ëπ‰', 200.0, 'g', 318.0);


insert into USERS (u_num, id, pw, u_name, u_gender, u_height, u_weight)
values (0, 'admin', '123','∞¸∏Æ¿⁄', '≥≤º∫', 180.2, 82.3);

