package vn.ert45ty.coursemanagement.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 24, message = "Name must be between 2 and 24 characters")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email is invalid")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 30, message = "Password must be between 6 and 30 characters")
    private String password;

    @NotBlank(message = "Re-password cannot be blank")
    private String rePassword;
}
