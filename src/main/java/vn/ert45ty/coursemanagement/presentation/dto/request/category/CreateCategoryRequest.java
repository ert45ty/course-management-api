package vn.ert45ty.coursemanagement.presentation.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateCategoryRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, message = "Name must be greater than 3 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 10, message = "Description must be greater than 10 characters")
    private String description;

    @NotBlank(message = "Slug is required")
    @Size(min = 2, message = "Slug must be greater than 2 characters")
    private String slug;
}
