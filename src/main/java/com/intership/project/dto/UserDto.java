package com.intership.project.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.intership.project.model.User}
 */
@Value
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UserDto implements Serializable {
    Long id;
    String username;
    String password;
    String email;
    String role;



}

