package com.firstdevelop.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstdevelop.boot.entity.UserEntity;
import com.firstdevelop.boot.mapper.UserMapper;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/list")
	public String selectAll(Model model) {
		
		List<UserEntity> list = userMapper.selectAll();
		model.addAttribute("title", "ユーザー一覧");
		model.addAttribute("userList", list);
		return "userList";
	}
}
