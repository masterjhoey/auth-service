package com.authentication.authservice.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.authentication.authservice.dto.UserDto;
import com.authentication.authservice.model.User;

@Mapper(componentModel="spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	UserDto userToUserDto(User entity);
	User userDtoToUser(UserDto dto);
	
	List<User> userDtosToUsers(List<UserDto> dto);
	List<UserDto> usersToUserDtos(List<User> dto);

	
}
