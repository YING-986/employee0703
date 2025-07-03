package com.firstdevelop.boot.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.firstdevelop.boot.entity.EmployeeList;

@Mapper
public interface  EmployeeListMapper {
	List<EmployeeList> searchAll();
	
	void insert(EmployeeList employee);
	
	void deleteById(String id);
}
