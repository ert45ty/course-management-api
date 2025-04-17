package vn.ert45ty.coursemanagement.domain.usecase;

import vn.ert45ty.coursemanagement.domain.model.User;

public interface GetUserUseCase {
    User execute(long id);
}
