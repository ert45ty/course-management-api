package vn.ert45ty.coursemanagement.domain.usecase;

import vn.ert45ty.coursemanagement.domain.model.PageDomain;
import vn.ert45ty.coursemanagement.domain.model.User;


public interface GetListUserUseCase {
    PageDomain<User> execute(int pageNo, int pageSize, String sortBy, String search);
}
