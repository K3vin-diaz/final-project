package com.intership.project.dto;

import com.intership.project.model.Collection;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link com.intership.project.model.Item}
 */
@Value
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ItemDto implements Serializable {
    Long id;
    String name;
    List<String> tags;
    Collection collection;
    String customString1Value;
}