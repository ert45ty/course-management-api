package vn.ert45ty.coursemanagement.domain.repository;

import vn.ert45ty.coursemanagement.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    Long create(User user);

    Boolean existByEmail(String email);

    void updateUser(User user);

    Optional<User> findById(long userId);

    void delete(long id);

    List<User> getListUser(int pageNo, int pageSize, String sortBy, String search);

    Long countUsers(String search);

}
