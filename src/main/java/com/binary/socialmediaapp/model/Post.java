package com.binary.socialmediaapp.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {
    private Integer id;

    @NotNull(message = "The title is required")
    private String title;

    @NotNull(message = "The description is required")
    private String description;

    @NotNull(message = "The body is required")
    private String body;

    @Size(min = 10, message = "It should be at least 10 characters")
    @Size(max = 100, message = "It should not exceed 100 characters")
    private String postStatus;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<Comment> comments;
}
