package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Member;

public interface MemberMapper {
	
	@Insert("insert into member values(member_seq.nextval,#{id},#{pw},#{name},#{email},sysdate)")
	public int insertMember(Member member);
	
	@Update("update member set id = #{id}, name = #{name}, email = #{email} where num= #{num}")
	public int updateMember(Member member);
	
	@Delete("delte from member where id = #{id}")
	public int deleteMember(String id);
	
	
	@Results({
		@Result(property = "id",column ="id"),
		@Result(property = "pw",column = "pw"),
		@Result(property = "email",column = "email")
	
	})
	
	@Select("select * from member where id =#{id}")
	public Member selectOne(String id);
	
	
	@Results({
		@Result(property = "id",column ="id"),
		@Result(property = "pw",column = "pw"),
		@Result(property = "email",column = "email")
	
	})
	
	@Select("select * from member")
	public List<Member> selectAll();

}
