package com.telusko;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.service.AddService;
@Controller
public class AddController {

	
		@RequestMapping("/add")
		public ModelAndView add(HttpServletRequest request,HttpServletResponse response)
		{
			int i=Integer.parseInt(request.getParameter("t1"));
			int j=Integer.parseInt(request.getParameter("t2"));
			AddService addService=new AddService();
			int k=addService.add(i, j);
			ModelAndView view=new ModelAndView();
			view.setViewName("display.jsp");
			view.addObject("result",k);
			return view;
		
		}
		
		
		@RequestMapping("/get")
		public ModelAndView getData()
		{
			ModelAndView view=new ModelAndView();
			view.setViewName("MySpring2.jsp");
			view.addObject("name","Vamsha");
			return view;
		}
		
		@RequestMapping("/sample")
		public ModelAndView display()
		{
			ModelAndView view=new ModelAndView();
			view.setViewName("MySpring2.jsp");
			view.addObject("name","Vamsha");
			return view;
			
		}
}
