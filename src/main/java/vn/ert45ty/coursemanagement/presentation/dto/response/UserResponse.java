package vn.ert45ty.coursemanagement.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private Date created_at;
}
