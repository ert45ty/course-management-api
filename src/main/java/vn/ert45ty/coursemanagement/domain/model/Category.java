package vn.ert45ty.coursemanagement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.ert45ty.coursemanagement.domain.common.CategoryStatus;

@Getter
@SuperBuilder
@Setter
@NoArgsConstructor
public class Category extends BaseDomain{
    private String name;
    private String description;
    private String slug;
    private CategoryStatus status;
}
