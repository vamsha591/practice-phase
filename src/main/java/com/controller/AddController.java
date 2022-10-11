package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.AddService;

@Controller
public class AddController {
	@RequestMapping("/Add")
	public ModelAndView add(@RequestParam("num1") int i,@RequestParam("num2") int j)
	{
//		int i=Integer.parseInt(request.getParameter("num1"));
//		int j=Integer.parseInt(request.getParameter("num2"));
		AddService addService=new AddService();
		int k=addService.addService(i, j);
		ModelAndView view=new ModelAndView();
		view.addObject("C",k);
		view.setViewName("display.jsp");
		return view;
				
	}

}
