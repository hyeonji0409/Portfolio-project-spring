package com.react.portfolio_project.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ResponseBody // 바디객체에 호출
	@RequestMapping("/login")
	public String login(MemberVO vo,
	//public String login(@RequestParam HashMap<String, Object> param,
						HttpSession session) {
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("memId", vo.getMemId());
		param.put("memPw", vo.getMemPw());
		
//		System.out.println(param.get("memId"));
//		System.out.println(param.get("memPw"));
		
		// DB에서 아이디 패스워드 확인
		MemberVO resultMember = service.login(param);
		//System.out.println(resultMember.getMemId());
		String result = "fail";
				
		if(resultMember != null) {
			session.setAttribute("sid1", resultMember.getMemId());
//			session.setAttribute("sid", resultMember);
			 result = "ok";			 
		System.out.println("성공");
		}
		//System.out.println(resultMember.getMemId());
		return result;
	}
	
	@RequestMapping("/logout")
	public void logout(HttpSession session) {
		
		// DB에서 아이디 패스워드 확인

		session.invalidate();

	}
	
	@ResponseBody
	@RequestMapping(value = "/idcheck")
	public String idCheck(@RequestParam String id) {

		System.out.println(id);

		String checkVar = "no_use";

		String memId_result = service.memIdCheck(id);
		
		if(memId_result != null) {

			checkVar = "use";
		}
		return checkVar;
	}
}
