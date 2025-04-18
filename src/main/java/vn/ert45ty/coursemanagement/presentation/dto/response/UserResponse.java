package vn.ert45ty.coursemanagement.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder
public class UserResponse extends BaseResponse{
    private String name;
    private String email;
}
