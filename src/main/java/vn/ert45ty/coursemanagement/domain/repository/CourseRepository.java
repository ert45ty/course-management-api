package vn.ert45ty.coursemanagement.domain.repository;

import vn.ert45ty.coursemanagement.domain.common.StatusCourse;
import vn.ert45ty.coursemanagement.presentation.dto.request.course.CreateCourseRequest;

public interface CourseRepository {
    Long createCourse(CreateCourseRequest request);

    void updateCourse();

    void changeStatusCourse(long id, StatusCourse status);

    void deleteCourse(long id);

}
