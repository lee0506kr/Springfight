create table reply(
	replyNum number(10) primary key,
	boardNum number(10) not null,
	replyContent varchar2(500) not null,
	replyWriter varchar2(30) not null,
	regDate date default sysdate not null,
	foreign key(boardNum) references board(num)
);
create sequence reply_seq
 start with 1
 increment by 1
 maxvalue 99999999
 cycle;


 
 
 
 
 
 