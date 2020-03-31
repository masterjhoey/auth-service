package com.authentication.authservice.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authentication.authservice.dto.UserDto;
import com.authentication.authservice.model.User;
import com.authentication.authservice.repository.UserRepository;
import com.authentication.authservice.service.UserService;
import com.authentication.authservice.util.UserMapper;

@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = userRepository.save(userMapper.userDtoToUser(userDto));
		return userMapper.userToUserDto(user);
	}

	@Override
	public UserDto findById(long userId) {
		User user = userRepository.findById(userId).orElseGet(() -> new User());		
		return userMapper.userToUserDto(user);
	}
	
	@Override
	public UserDto findByUserName(String userName) {
		User user = userRepository.findByUserName(userName).orElseGet(() -> new User());
		return userMapper.userToUserDto(user);
	}

	@Override
	public List<UserDto> findAll() {
		List<User> users = userRepository.findAll();
		return userMapper.usersToUserDtos(users);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//TestData
		//$2a$04$DTuuvJO9itvtWjPydyqQhueJ00uhnck19BFSxVEIWE/uThh4hwE5m
		User user = userRepository.findByUserName(username).orElseGet(() -> new User());
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthority());
	}
	
	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
}
