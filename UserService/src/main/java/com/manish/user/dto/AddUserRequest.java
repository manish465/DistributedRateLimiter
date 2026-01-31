package com.manish.user.dto;

import lombok.Data;

@Data
public class AddUserRequest {
    private String name;
    private String email;
}
