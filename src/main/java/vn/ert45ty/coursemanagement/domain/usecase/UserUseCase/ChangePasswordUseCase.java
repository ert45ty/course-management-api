package vn.ert45ty.coursemanagement.domain.usecase.UserUseCase;

import vn.ert45ty.coursemanagement.presentation.dto.request.user.ChangePasswordRequest;

public interface ChangePasswordUseCase {
    void execute(long id, ChangePasswordRequest request);
}
