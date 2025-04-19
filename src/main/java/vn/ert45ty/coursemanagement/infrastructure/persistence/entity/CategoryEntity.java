package vn.ert45ty.coursemanagement.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.ert45ty.coursemanagement.domain.common.CategoryStatus;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    private String name;
    private String description;
    private String slug;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;
}
