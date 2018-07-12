create table authorities(
	memberid varchar2(20) not null,
	authority varchar2(20) not null,
	primary key (memberid,authority)
)
insert into authorities (memberid,authority )
   values ('id7','ROLE_USER');
   insert into authorities (memberid,authority )
   values ('id7','ROLE_ADMIN');
   insert into authorities (memberid,authority )
   values ('id7','ROLE_MANGER');