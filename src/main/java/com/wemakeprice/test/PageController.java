package com.wemakeprice.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Page Controller
 * 
 * @author Jung Chul
 *
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
}
