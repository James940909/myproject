create table users(
	userid varchar(15) primary key,
	name varchar(15),
    passwd varchar(10)
);
create table message(
    mid int primary key,
    userid varchar(15),
    msg varchar(100),
    favcount int default 0,
    replycount int default 0
);
create table reply(
    rid int primary key,
    mid int,
    userid varchar(15),
    rmsg varchar(50),
    constraint msgrp foreign key (mid) references message (mid) on delete cascade
);

create table rreply(
    rrid int primary key,
    rid int,
    userid varchar(15),
    rrmsg varchar(50),
    constraint rmsgrp foreign key (rid) references reply (rid) on delete cascade
);


insert into users values('timo','Ƽ��','1234');
insert into message values(1,'timo','���ۼ�',1,2);
insert into reply values(1,1,'timo','���1');
insert into reply values(2,1,'timo','���2');
insert into message values(2,'timo','����',2,3);
insert into reply values(3,2,'timo','���1');
insert into reply values(4,2,'timo','���2');
insert into reply values(5,2,'timo','���3');
insert into message values(4,'timo','���� ž�� ����',2,1);
insert into message values(5,'garen','ƼȮ��',16,1);
insert into message values(6,'ari','��� ���� ž�� ����',2,1);
insert into reply values(6,4,'timo','���� �߰���');
insert into reply values(7,5,'timo','�Ф�');
insert into reply values(8,6,'garen','?');
select * from reply;
select * from rreply;
select * from message;
select * from users;
select * from all_tables;

drop table reply;
drop table message;
drop table users;


insert into reply(mid,userid,rmsg) values(1,'timo','��������');
