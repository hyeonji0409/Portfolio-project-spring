package com.react.portfolio_project.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.react.portfolio_project.model.MemberVO;



public interface IMemberDAO {
	MemberVO login(HashMap<String, Object> map);
	String memIdCheck(String memId);
	void signUp(MemberVO vo);
	ArrayList<MemberVO> getAllMember();
	MemberVO getMember(String sid);
}
