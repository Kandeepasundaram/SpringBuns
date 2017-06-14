package com.bfly.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/ux")
public class RouteController {
	
	@RequestMapping
	public String index()
	{
		return "home";
	}
}