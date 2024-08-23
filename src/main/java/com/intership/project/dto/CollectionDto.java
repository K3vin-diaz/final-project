package com.intership.project.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.intership.project.model.Collection}
 */
@Value
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CollectionDto implements Serializable {
    Long id;
    String name;
    String description;
    String imageUrl;
    UserDto user;
    String category;
    String customString1Name;
    Boolean customString1State;
}