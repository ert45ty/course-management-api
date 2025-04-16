package vn.ert45ty.coursemanagement.domain.usecase;

import vn.ert45ty.coursemanagement.presentation.dto.request.CreateUserRequest;
import vn.ert45ty.coursemanagement.presentation.dto.response.UserResponse;

public interface CreateUserUseCase {
    UserResponse execute(CreateUserRequest request);
}
