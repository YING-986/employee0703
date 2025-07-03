package com.firstdevelop.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstdevelop.boot.entity.EmployeeList;
import com.firstdevelop.boot.form.EmployeeListForm;
import com.firstdevelop.boot.service.EmployeeListService;

@RestController
@RequestMapping("/api/employee-list")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeListController {

	@Autowired
    private EmployeeListService employeeListService;
	
	@GetMapping("/searchAll")
    public List<EmployeeList> searchAll() {
        return employeeListService.searchAll();
    }
	
    @PostMapping("/insert")
    public void insert(@RequestBody EmployeeListForm form) {
        employeeListService.insert(form);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody List<String> ids) {
        try {
            for (String id : ids) {
                employeeListService.delete(id);
            }
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("削除失敗");
        }
    }
}