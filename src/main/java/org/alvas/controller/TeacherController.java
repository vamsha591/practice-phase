package org.alvas.controller;

import java.util.List;

import org.alvas.dto.Teacher;
import org.alvas.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.bytebuddy.matcher.StringMatcher.Mode;

@RestController
public class TeacherController {

	@Autowired
	TeacherService service;
	
	@RequestMapping("/loadTeacher")
	public ModelAndView loadTeacher() {
		
		ModelAndView andView = new ModelAndView("registration-teacher.jsp");
		
	    andView.addObject("teacher",new Teacher());
	    
	    return andView;
	}
	
	@RequestMapping("/saveTeacher")
	public ModelAndView saveTeacher(Teacher teacher) {
		
		ModelAndView andView = new ModelAndView("loadTeacher");
		
		service.saveTecher(teacher);
		
		return andView.addObject("msg","data inserted successfully");
	}
	
	@RequestMapping("/getAllData")
	public ModelAndView getAllData() {
		
		ModelAndView andView = new ModelAndView("display.jsp");
		
		List<Teacher> teacher = service.getAllData();
		
		return andView.addObject("getTeacher", teacher);	
	}
	
	@RequestMapping("/deleteData")
	public ModelAndView deleteData(@RequestParam int id) {
		
		ModelAndView andView = new ModelAndView("getAllData");
		
		 service.deleteById(id);
		
		 return andView;
	} 
	
	@RequestMapping("/editTeacher1")
	public ModelAndView editTeacher(@RequestParam int id) {
		
		ModelAndView andView = new ModelAndView("update.jsp");
		
	   return andView.addObject("editTeacher",service.getById(id));
	}
	
	@RequestMapping("/updateTeacher")
	public ModelAndView updateTeacher(@ModelAttribute Teacher teacher) {
		
		
		ModelAndView andView = new ModelAndView("getAllData");
		
		service.updateTeacher(teacher);
		
		return andView;
		
	}
}
