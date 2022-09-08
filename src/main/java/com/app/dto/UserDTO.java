package com.app.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
	private String userFirstName;
	private String userLastName;
	private int userAge;
	private String userPhone;
	private String userEmailId;
	private String password;
}
