package com.encore.demo.member;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper	
public interface MemberDAO {
	@Insert("insert into member2 values(#{id}, #{pwd}, #{name}, #{email})")
	void addMemeber(Member m);
	
	@Select("select * from member2 where id = #{id}")
	Member getMember(@Param("id") String id);
	
	@Select("select * from member2")
	ArrayList<Member> getMembers();
	
	@Update("update member2 set pwd = #{pwd}, email = #{email} where id = #{id}")
	void editMember(Member m);
	
	
	@Delete("delete member2 where id = #{id}")
	void delMember(@Param("id") String id);
	
}
