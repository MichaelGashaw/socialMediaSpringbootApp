package com.binary.socialmediaapp.model;

import lombok.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    private Integer id;

    @NotNull(message = "The author is required")
    private String author;

    @NotNull(message = "The content is required")
    private String content;

    private LocalDateTime createdOn;
}
