package vn.ert45ty.coursemanagement.presentation.dto.response;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Getter
public abstract class BaseResponse {
    private Long id;
    private Date created_at;
}
