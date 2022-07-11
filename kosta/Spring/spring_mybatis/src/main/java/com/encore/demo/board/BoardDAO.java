package com.encore.demo.board;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;


@Mapper
public interface BoardDAO {
	
	// 나중에 Content 부분은 "BLOB" 타입으로 컬럼을 생성하자
	// BLOB : 모든데이터를 BYTE 형식으로 전환하여 저장하기에 저장데이터 형식과 상관없이 
	// 모든 데이터 저장이 가능 (이미지 , 동영상도 가능)
	@Insert("insert into board2 values( seq_board.nextval, #{writer}, sysdate, #{title}, #{content} )")
	void insert(Board b) ;
	
	@Select("select * from board2")
	ArrayList<Board> selectAll();
	
	@Select("select * from board2 where num = #{num}")
	Board selectByNum(@Param("num") int num);
	
	@Select("select * form board2 where writer = #{writer}")
	ArrayList<Board> selectByWriter(@Param("writer") String writer);
	
	@Select("select * form board2 where title = #{title}")
	ArrayList<Board> selectByTitle(@Param("title") String title);
	
	@Update("update board2 set  title = #{title}, content = #{content} where num = #{num}")
	void update(Board b);
	
	@Transactional
	@Delete("delete board2 where num = #{num}")
	void ldelete(@Param("num") int num);
	
}
