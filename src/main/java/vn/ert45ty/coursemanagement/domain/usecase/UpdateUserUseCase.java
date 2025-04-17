package vn.ert45ty.coursemanagement.domain.usecase;

import vn.ert45ty.coursemanagement.presentation.dto.request.UpdateUserRequest;

public interface UpdateUserUseCase {
    void excecute(long userId, UpdateUserRequest request);
}
