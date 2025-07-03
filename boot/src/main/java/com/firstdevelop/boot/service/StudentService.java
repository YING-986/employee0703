package com.firstdevelop.boot.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.entity.Student;
import com.firstdevelop.boot.form.StudentForm;
import com.firstdevelop.boot.mapper.StudentMapper;

@Service
public class StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> searchAll() {
		return studentMapper.searchAll();
	}
	
	public void regist(StudentForm form) {
		
		Student student = new Student();
		student.setAge(Integer.parseInt(form.getAge()));
		student.setScore(Integer.parseInt(form.getScore()));
		student.setClassid(Integer.parseInt(form.getClassid()));
		student.setName(form.getName());
		student.setBirthday(Timestamp.valueOf(form.getBirthday()));
	
		studentMapper.regist(student);
	}
	
	public void delete(Integer studentId) {
		
		Student student = new Student();
		student.setId(studentId);
		studentMapper.delete(student);
	}
	
	
}
