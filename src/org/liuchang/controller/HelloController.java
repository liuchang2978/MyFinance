package org.liuchang.controller;

import org.liuchang.service.finance.IFinanceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private IFinanceDetailService payService;

	@RequestMapping("/hello")
	public String printWelcome(ModelMap model) {
		System.out.println("Hello");
		payService.sayHello();
		//System.out.println(payService.count());
		model.addAttribute("message", "Hello world!");
		return "hello";
	}


}