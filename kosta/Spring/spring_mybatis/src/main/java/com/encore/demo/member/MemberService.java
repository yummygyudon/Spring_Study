package com.encore.demo.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao ;
	
	public void addMember(Member m) { // 회원 가입
		dao.addMemeber(m);
	}
	
	public Member getMember(String id) { // 회원 조회
		return dao.getMember(id);
	}
	
	public ArrayList<Member> getAll() { // 모든 회원 조희
		return dao.getMembers();
	}
	
	public void editMember(Member m) { // 내 정보 수정
		dao.editMember(m);
	}
	
	public void delMember(String id) { // 회원 탈퇴 
		dao.delMember(id);
	}
}
