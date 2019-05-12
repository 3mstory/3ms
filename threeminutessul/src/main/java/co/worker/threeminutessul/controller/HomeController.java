package co.worker.threeminutessul.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.worker.threeminutessul.service.HomeServiceIF;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HomeServiceIF service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.tmssul", method = RequestMethod.GET)
	public String home(HttpServletRequest req, HttpServletResponse resp, String id, String pw) {
		String nickname = service.auth(id,pw);
		req.setAttribute("nickname", nickname);
		return "home";
	}
	
}
