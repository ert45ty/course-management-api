package vn.ert45ty.coursemanagement.domain.usecase.UserUseCase;

import vn.ert45ty.coursemanagement.presentation.dto.request.user.CreateUserRequest;

public interface CreateUserUseCase {
    Long execute(CreateUserRequest request);
}
