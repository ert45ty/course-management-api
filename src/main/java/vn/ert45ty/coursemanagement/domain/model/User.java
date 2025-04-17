package vn.ert45ty.coursemanagement.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import vn.ert45ty.coursemanagement.domain.common.Role;

import java.util.Date;

@Getter
@Setter
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private Date create_at;
}
