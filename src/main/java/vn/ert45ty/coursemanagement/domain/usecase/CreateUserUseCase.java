package vn.ert45ty.coursemanagement.domain.usecase;

import vn.ert45ty.coursemanagement.presentation.dto.request.CreateUserRequest;

public interface CreateUserUseCase {
    Long execute(CreateUserRequest request);
}
