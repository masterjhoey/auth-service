package com.authentication.authservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
	
	@Id
    @GeneratedValue
    private long userId;
	
	@Column
    private String orgId;
	
	@Column
    private String userName;
	
	@Column
    private String password;
	
	@Column
    private String contact;


}
