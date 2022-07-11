package com.encore.demo.board;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService service ;
	
	@GetMapping("/list")
	public void list(Map<String, ArrayList<Board>> map) { // list 페이지 보여주기
		ArrayList<Board> list = service.getAll();
		map.put("list", list) ;
	}
	
	@GetMapping("/write")
	public void writeForm() {
	}
	
	@PostMapping("/write")
	public String write(Board b) {
		service.addBoard(b);
		return "redirect:/board/list";
	}
	
	// url 뒤에 붙는 Path의 값을 가져올 수 있다. (PathVariable : Path 변수)
	@GetMapping("/detail/{num}")
	public String detail(@PathVariable("num") int num, Map<String, Board> map){
		Board b = service.getByNum(num);
		map.put("b", b) ;
		return "board/detail"; // detail이라는 페이지 양식에 매번 매개변수로 들어간 map의 b값을 참조해서 내용은 페이지에서 완성시키는 방식
	}
	
	@PostMapping("/detail")
	public String edit(Board b) {
		service.editBoard(b);
		return "redirect:/board/list";
	}
		
	@GetMapping("/del/{num}")
	public String delete(@PathVariable("num") int num) {
		service.delBoard(num);
		return "redirect:/board/list";
	}
}
