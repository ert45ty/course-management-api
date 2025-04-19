package vn.ert45ty.coursemanagement.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.ert45ty.coursemanagement.domain.common.StatusCourse;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class CourseEntity extends BaseEntity{

    private String title;

    private String description;

    private BigDecimal price;

    private Long teacherId;

    private Long categoryId;

    @Enumerated(EnumType.STRING)
    private StatusCourse status;

    private String reason;
}
