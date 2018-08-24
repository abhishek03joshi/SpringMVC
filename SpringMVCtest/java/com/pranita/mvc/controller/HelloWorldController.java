package com.pranita.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")

public class HelloWorldController {

	@RequestMapping(value="/hello", method = RequestMethod.GET)
	public String sayHello(ModelMap model)
	{
		model.addAttribute("greeting", "Hello World");
		return "welcome";
	}
	
	  @RequestMapping("/user")
	    public String userInfo(ModelMap model,
	            @RequestParam(value = "name", defaultValue = "admin") String name) {
	   
	        model.addAttribute("name", name);
	   
	        if ("admin".equals(name)) {
	            model.addAttribute("email", "admin@example.com");
	        } else {
	            model.addAttribute("email", "Not set");
	        }
	        return "userInfo";
	 
	}
	  @RequestMapping(value = "/saveResult")
	  @ResponseBody
	    public String authorInfo(Model model) {
	        return "saved";
	    }
	  
}
