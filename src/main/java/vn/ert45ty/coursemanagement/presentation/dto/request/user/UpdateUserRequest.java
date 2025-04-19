package vn.ert45ty.coursemanagement.presentation.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UpdateUserRequest {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 24, message = "Name must be between 2 and 24 characters")
    private String name;
}
