package vn.ert45ty.coursemanagement.presentation.dto.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import vn.ert45ty.coursemanagement.domain.common.StatusCourse;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public class CourseResponse extends BaseResponse{
    private String title;
    private String description;
    private BigDecimal price;
    private Long teacherId;
    private Long categoryId;
    private StatusCourse status;
    private String reason;
}
