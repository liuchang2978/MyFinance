package org.liuchang.controller.finance;

import org.liuchang.service.finance.ISearchDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/finance")
public class SearchDataController {

	@Resource
	private ISearchDataService searchDataService;


	@RequestMapping("/getTypeData")
	@ResponseBody
	public String printWelcome(String type) {
		String json = searchDataService.getTypeData(type);
		return json;
	}




}