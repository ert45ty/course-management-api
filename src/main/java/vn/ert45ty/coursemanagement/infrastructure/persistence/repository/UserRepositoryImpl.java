package vn.ert45ty.coursemanagement.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.infrastructure.persistence.entity.UserEntity;
import vn.ert45ty.coursemanagement.infrastructure.persistence.mapper.UserMapper;
import vn.ert45ty.coursemanagement.infrastructure.persistence.repository.springdata.SpringDataUserRepository;
import vn.ert45ty.coursemanagement.presentation.advice.ResourceNotFoundException;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Long create(User user) {
        return null;
    }

    @Override
    public Boolean existByEmail(String email) {
        return springDataUserRepository.existsByEmail(email);
    }

    @Override
    public void updateUser(User user) {
        UserEntity userEntity = UserMapper.domainToEntity(user);
        springDataUserRepository.save(userEntity);
    }

    @Override
    public Optional<User> findById(long userId) {
        return springDataUserRepository.findById(userId).map(UserMapper::entityToDomain);
    }

    @Override
    public void delete(long id) {
        springDataUserRepository.deleteById(id);
    }
}
