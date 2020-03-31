package com.authentication.authservice.dto;

import lombok.Data;

@Data
public class UserDto {
	
    private long userId;
	private String orgId;
    private String userName;
    private String password;
    private String contact;
}
