package com.icin.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.ParseException;

import com.icin.domain.Request;
import com.icin.domain.User;
import com.icin.service.RequestService;
import com.icin.service.UserService;;

@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RequestService requestService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createRequest(Model model) {
		Request request = new Request();
		model.addAttribute("request", request);
		model.addAttribute("dateString", "");
		
		return "appointment";
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public String createRequestPost(@ModelAttribute("request") Request request, @ModelAttribute("dateString") String date, Model model, Principal principal) throws ParseException {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date d1 = format1.parse(date);
		request.setDate(d1);
		
		User user = userService.findByUsername(principal.getName());
		request.setUser(user);
		
		requestService.createRequest(request);
		
		return "redirect:/userFront";
		
	}

}
