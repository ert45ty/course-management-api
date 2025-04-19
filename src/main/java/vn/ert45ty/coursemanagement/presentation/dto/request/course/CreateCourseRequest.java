package vn.ert45ty.coursemanagement.presentation.dto.request.course;

import jakarta.validation.constraints.*;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateCourseRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 8, message = "Title must be greater than 8 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 20, message = "Description must be greater than 20 characters")
    private String description;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must be a valid monetary value")
    private BigDecimal price;

    @NotNull
    private Long teacherId;

    @NotNull
    private Long categoryId;

}
