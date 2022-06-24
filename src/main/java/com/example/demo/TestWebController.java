package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestWebController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	//@ResponseBody
	// 별도의 뷰가 아닌 리턴값을 직접 HTTP 응답 보디에 출력
	@GetMapping("/hello2")
	@ResponseBody
	public String hello2(@RequestParam(value="msg", required=false) String msg) {
		return msg;
	}
	
	@GetMapping("/hello3/{msg}")
	public String hello3(@PathVariable String msg, Model m) {
		m.addAttribute("msg", msg);
		return "hello"; 
	}
	
}
