package com.firstdevelop.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.firstdevelop.boot.entity.UserEntity;

@Mapper
public interface UserMapper {

	List<UserEntity> selectAll();
}
