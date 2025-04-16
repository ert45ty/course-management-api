package vn.ert45ty.coursemanagement.infrastructure.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import vn.ert45ty.coursemanagement.domain.common.Role;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "users")
@ToString
public class UserEntity extends BaseEntity{

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
