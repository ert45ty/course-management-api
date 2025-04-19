package vn.ert45ty.coursemanagement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.ert45ty.coursemanagement.domain.common.StatusCourse;

import java.math.BigDecimal;

@Getter
@SuperBuilder
@Setter
@NoArgsConstructor
public class Course extends BaseDomain{
    private String title;
    private String description;
    private BigDecimal price;
    private Long teacherId;
    private Long categoryId;
    private StatusCourse status;
    private String reason;
}
