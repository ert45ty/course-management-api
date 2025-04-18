package vn.ert45ty.coursemanagement.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.infrastructure.persistence.entity.UserEntity;
import vn.ert45ty.coursemanagement.infrastructure.persistence.mapper.UserMapper;
import vn.ert45ty.coursemanagement.infrastructure.persistence.repository.springdata.SpringDataUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @Override
    public List<User> getListUser(int pageNo, int pageSize, String sortBy, String search) {
        List<Sort.Order> order = new ArrayList<>();

        if (StringUtils.hasLength(sortBy)){
            Pattern pattern = Pattern.compile("(\\w+?)(:)(.*)");
            Matcher matcher = pattern.matcher(sortBy);
            if (matcher.find()){
                if (matcher.group(3).equalsIgnoreCase("asc")){
                    order.add(new Sort.Order(Sort.Direction.ASC, matcher.group(1)));
                }else {
                    order.add(new Sort.Order(Sort.Direction.DESC, matcher.group(1)));
                }
            }
        }
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(order));

        return springDataUserRepository.findAllWithSearchAndSort(search, pageable).stream().map(UserMapper::entityToDomain).collect(Collectors.toList());
    }

    @Override
    public Long countUsers(String search) {
        return springDataUserRepository.countUsers(search);
    }
}
