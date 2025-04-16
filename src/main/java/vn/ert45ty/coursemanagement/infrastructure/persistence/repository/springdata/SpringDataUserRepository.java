package vn.ert45ty.coursemanagement.infrastructure.persistence.repository.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.ert45ty.coursemanagement.infrastructure.persistence.entity.UserEntity;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
