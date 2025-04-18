package vn.ert45ty.coursemanagement.infrastructure.persistence.repository.springdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.ert45ty.coursemanagement.infrastructure.persistence.entity.UserEntity;

import java.util.Optional;

public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    void deleteById(long id);

    @Query(value = "select u from UserEntity u where :search IS NULL OR :search = '' " +
            "or lower(u.name) like lower(concat('%', :search, '%')) or lower(u.email) like lower(concat('%', :search, '%'))")
    Page<UserEntity> findAllWithSearchAndSort(@Param("search") String search, Pageable pageable);

    @Query(value = "select count(u) from UserEntity u where :search IS NULL OR :search = '' " +
            "or lower(u.name) like lower(concat('%', :search, '%')) or lower(u.email) like lower(concat('%', :search, '%'))")
    Long countUsers(String search);
}
