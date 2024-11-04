package com.dangquocdat.TodoApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TodoDto {
    Long id;
    String title;
    String description;

    @JsonProperty("isCompleted")
    boolean isCompleted;

}
