package com.intership.project.dto;

import com.intership.project.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.intership.project.model.Comment}
 */
@Value
@Getter
@Setter
@Data
public class CommentDto implements Serializable {
    Long id;
    ItemDto item;
    User user;
    String content;
    LocalDateTime createdAt;
}