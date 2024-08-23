package com.intership.project.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.intership.project.model.User}
 */
@Value
@Data
public class UserDto implements Serializable {
    Long id;
    String username;
    String password;
    String email;
    String role;
}

