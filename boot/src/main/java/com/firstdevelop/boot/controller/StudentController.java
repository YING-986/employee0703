package com.firstdevelop.boot.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstdevelop.boot.entity.Student;
import com.firstdevelop.boot.form.StudentForm;
import com.firstdevelop.boot.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/searchAll")
	public String searchAll(Model model) {

		List<Student> studentList = studentService.searchAll();

		
		model.addAttribute("studentList", studentList);
		model.addAttribute("title", "ユーザー一覧");
		
		return "/student/studentDetail";
	}
	
	@RequestMapping("/registInit")
	public String registInit() {
		
		return "/student/regist";
	}
	
	@RequestMapping("/regist")
	public String regist(StudentForm form) {
		
		studentService.regist(form);
		return "redirect:searchAll";
	}
	@RequestMapping("/delete/{studentId}")
	public String delete(@PathVariable("studentId") Integer studentId ,Model model) {
		
		studentService.delete(studentId);
		
		List<Student> studentList = studentService.searchAll();
		model.addAttribute("studentList", studentList);
		model.addAttribute("title", "ユーザー一覧");
		return "/student/studentDetail";
		//return "redirect:searchAll";
	}
	
}
