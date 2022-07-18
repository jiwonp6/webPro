package com.lec.ch08.controller;

import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.ch08.vo.MemberDto;

@Controller
@RequestMapping("member")
public class MemberController {
	@ModelAttribute("cnt")		//-> 계속 실행되야하는 로직 : @ModelAttribute로 따로 빼서 처리해줌
	public int cnt() {
		return 5;
	}
	@ModelAttribute("list")
	public ArrayList<String> list() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		return list;
	}
	//방법1
	@RequestMapping(value="join1")	//요청경로 : member/join1
	public String join1(HttpServletRequest request, Model model) {	//입력받기 위해(request안에 입력받은 파라미터들 들어옴)
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	//방법2
	@RequestMapping(value="join2")
	public String join2(@RequestParam("name") String membername, 
						@RequestParam("id") String memberid,
						@RequestParam("pw") String memberpw,
						@RequestParam("age") int memberage,
						@RequestParam("email") String memberemail,
						@RequestParam("address") String memberaddress,
						Model model) {
		model.addAttribute("name", membername);
		model.addAttribute("id", memberid);
		model.addAttribute("pw", memberpw);
		model.addAttribute("age", memberage);
		model.addAttribute("email", memberemail);
		model.addAttribute("address", memberaddress);
		return "member/result1";
	}
	//방법3
	@RequestMapping(value="join3")
	public String join3(String name, String id, String pw, int age, String email, String address, Model model) {	//파라미터 이름 같은게 없으면 null값으로 받음
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		model.addAttribute("age", age);
		model.addAttribute("email", email);
		model.addAttribute("address", address);
		return "member/result1";
	}
	//방법4
	@RequestMapping(value="join4")
	public String join4(MemberDto memberDto, Model model) {
		//자동으로 MemberInfo 객체 생성 -> 속성 setting(setter이용) 
		model.addAttribute("member",memberDto);
		return "member/result4";
	}
	//방법5
	@RequestMapping(value="join5")
	public String input5(MemberDto memberDto) {		//커맨드 객체 이름 가독성↓ --@ModelAttribute 어노테이션 이용--> 이름 change O
		//model.addAttribute("member",memberDto); -> 자동으로 MemberDto 속성에 setting, model에 add
		return "member/result5";
	}
	//방법6
	@RequestMapping(value="join6")
	public String join6(@ModelAttribute("member") MemberDto memberDto) {
		//@ModelAttribute 어노테이션 이용 -> 이름 바꾸기
		return "member/result4";
	}

}
