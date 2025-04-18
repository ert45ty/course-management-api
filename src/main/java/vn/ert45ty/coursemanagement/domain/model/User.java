package vn.ert45ty.coursemanagement.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import vn.ert45ty.coursemanagement.domain.common.Role;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class User extends BaseDomain{

    private String name;
    private String email;
    private String password;
    private Role role;

}
