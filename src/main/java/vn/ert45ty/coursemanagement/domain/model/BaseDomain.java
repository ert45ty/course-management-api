package vn.ert45ty.coursemanagement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder
@Setter
@NoArgsConstructor
public abstract class BaseDomain {
    private Long id;
    private Date created_at;
    private Date updated_at;
}
