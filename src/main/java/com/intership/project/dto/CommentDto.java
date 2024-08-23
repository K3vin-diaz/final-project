package com.intership.project.dto;

import com.intership.project.model.User;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.intership.project.model.Comment}
 */
@Value
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CommentDto implements Serializable {
    Long id;
    ItemDto item;
    User user;
    String content;
    LocalDateTime createdAt;
}