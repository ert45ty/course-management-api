package vn.ert45ty.coursemanagement.domain.usecase;

import vn.ert45ty.coursemanagement.presentation.dto.request.ChangePasswordRequest;

public interface ChangePasswordUseCase {
    void execute(long id, ChangePasswordRequest request);
}
