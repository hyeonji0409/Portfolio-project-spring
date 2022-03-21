package com.react.portfolio_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.portfolio_project.model.MemberVO;
import com.react.portfolio_project.service.MemberService;

@CrossOrigin("*") // http://127.0.0.1 또는 localhost 다 사용하도록
@RestController
public class MemberController {

	@Autowired //MemberService와 연결 import랑 다름
	MemberService service;	
	
	//상품 등록
	@RequestMapping(value="/signup")
	public void signUp(MemberVO vo) {		
		service.signUp(vo);	 
	}
}
