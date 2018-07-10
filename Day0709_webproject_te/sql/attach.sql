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

    
    
 ----------------------------------------------------------------------------------   
    
    
    select * 
	  from (select rownum as rnum,
		       b1.num,
		       b1.title,
		       b1.content,
		       b1.email,
		       b1.name,
		       b1.readcount,
		       b1.writedate,
		       b1.rcount  
		  from (select b.num, b.title, b.content,b.email,b.name,b.readcount,b.writedate, count(r.replynum) as rcount 
		  		  from board b left join reply r
		            on b.num = r.boardnum
		         group by (b.num, b.title, b.content,b.email,b.name,b.readcount,b.writedate)
		         order by num desc) b1 )   
	 where  rnum between 11 and 13
    

