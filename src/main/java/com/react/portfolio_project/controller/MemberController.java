package com.react.portfolio_project.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.react.portfolio_project.model.MemberVO;
import com.react.portfolio_project.service.MemberService;

@Controller
public class MemberController {
	// DI 설정
	@Autowired //MemberService와 연결 import랑 다름
	MemberService service;	
	
	//로그인 폼으로 이동
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "/login";
	}
	
	//로그인
	@ResponseBody // 바디객체에 호출
	@RequestMapping("/login")
	public String login(@RequestParam HashMap<String, Object> param,
						HttpSession session) {
		
		// DB에서 아이디 패스워드 확인
		MemberVO resultMember = service.login(param);
		
		String result = "fail";
		
		
		if(resultMember != null) {
			session.setAttribute("sid1", resultMember.getMemId());
			session.setAttribute("sid", resultMember);
			 result = "ok";
			 
		}
		System.out.println(resultMember.getMemId());
		return result;
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		// DB에서 아이디 패스워드 확인

		session.invalidate();

		return "redirect:/";
	}
	
	//회원가입 폼으로 이동
	@RequestMapping("/signupForm")
	public String joinForm() {
		
		return "/signUp";
	}
	
	@RequestMapping("/signUp")
	public String signUp(MemberVO vo) {
		System.out.println("signUp" + vo);
		service.signUp(vo);

		return "redirect:/";
	}
	
	//회원가입 중복확인
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
