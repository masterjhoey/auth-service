package com.authentication.authservice.service;

import java.util.List;

import com.authentication.authservice.dto.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);
	
	public UserDto findById(long userId); 
	
	public UserDto findByUserName(String userName); 
	
	public List<UserDto> findAll(); 
	
}
