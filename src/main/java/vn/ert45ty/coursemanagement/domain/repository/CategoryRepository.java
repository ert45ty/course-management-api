package vn.ert45ty.coursemanagement.domain.repository;

import vn.ert45ty.coursemanagement.presentation.dto.request.category.CreateCategoryRequest;

public interface CategoryRepository {
    Long create(CreateCategoryRequest request);

    void update();

    void delete(long id);

}
