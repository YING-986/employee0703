package com.firstdevelop.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstdevelop.boot.entity.EmployeeList;
import com.firstdevelop.boot.form.EmployeeListForm;
import com.firstdevelop.boot.mapper.EmployeeListMapper;

@Service
public class  EmployeeListService {
	
//  全件取得
//	List<EmployeeList> searchAll();
	
    @Autowired
    private EmployeeListMapper employeeListMapper;
    
    // 全件取得
    public List<EmployeeList> searchAll() {
        return employeeListMapper.searchAll();
    }

    // 登録（新規追加）
    public void insert(EmployeeListForm form) {
        EmployeeList employee = new EmployeeList();

        employee.setId(form.getId());
        employee.setName(form.getName());
        employee.setDepartment(form.getDepartment());
        employee.setEmail(form.getEmail());
        employee.setPhone(form.getPhone());

        employeeListMapper.insert(employee);
    }
    
//    删除
    public void delete(String id) {
        employeeListMapper.deleteById(id);
    }
    
}