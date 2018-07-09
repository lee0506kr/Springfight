포함되어야 할 내용
파일명

create table attach(
	fullname varchar2(150) primary key,
	num number(10) not null,
	regdate date default sysdate
)

게시글 조회하면서 같이 가져오기

select * 
	from board2 b left join reply r
	on b.num = r.boardnum
	 where b.num
	
	
------------------------------------------------------
	 
	 
	 select b.* , a.fullname
    from board2 b left join attach a
    on b.num = a.num
    where b.num = 42;
        
    
    
    desc attach;
    
    
select b.num, b.title, b.content,b.email,b.name,b.readcount,b.writedate, count(r.replynum) 
	from board2 b left join reply r
	on b.num = r.boardnum 
    where b.num = 42
    group by(b.num,b.title,b.content,b.email,b.name,b.readcount,b.writedate);


