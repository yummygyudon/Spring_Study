package com.encore.demo.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao ;
	
	public void addBoard(Board b) {
		dao.insert(b);
	}
	
	
	public Board getByNum(int num) {
		return dao.selectByNum(num);
	}
	public ArrayList<Board> getByTitle(String title) {
		return dao.selectByTitle(title);
	}
	public ArrayList<Board> getByWriter(String writer) {
		return dao.selectByWriter(writer);
	}
	public ArrayList<Board> getAll() {
		return dao.selectAll();
	}

	
	public void editBoard(Board b) {
		dao.update(b);
	}
	
	
	public void delBoard(int num) {
		dao.ldelete(num);
	}
}
