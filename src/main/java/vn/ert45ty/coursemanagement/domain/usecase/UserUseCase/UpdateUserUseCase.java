package vn.ert45ty.coursemanagement.domain.usecase.UserUseCase;

import vn.ert45ty.coursemanagement.presentation.dto.request.user.UpdateUserRequest;

public interface UpdateUserUseCase {
    void excecute(long userId, UpdateUserRequest request);
}
