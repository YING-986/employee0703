package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.firstdevelop.boot.entity.Student;

@Mapper
public interface StudentMapper {
    List<Student> searchAll();
	
	void regist(Student student);
	
	void delete(Student student);
}
