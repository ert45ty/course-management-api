package vn.ert45ty.coursemanagement.application.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.domain.usecase.CreateUserUseCase;
import vn.ert45ty.coursemanagement.infrastructure.persistence.mapper.UserMapper;
import vn.ert45ty.coursemanagement.presentation.advice.EmailAlreadyExistException;
import vn.ert45ty.coursemanagement.presentation.advice.PasswordNotMatchException;
import vn.ert45ty.coursemanagement.presentation.dto.request.CreateUserRequest;
import vn.ert45ty.coursemanagement.presentation.dto.response.UserResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUserService implements CreateUserUseCase {
    private final UserRepository userRepository;

    @Override
    public Long execute(CreateUserRequest request) {

        if (!request.getPassword().equals(request.getRePassword())){
            throw new PasswordNotMatchException();
        }
        if (userRepository.existByEmail(request.getEmail())){
            throw new EmailAlreadyExistException();
        }
        User user = UserMapper.createDtoToDomain(request);
        Long id = userRepository.create(user);
        log.info("User has save!");
        return id;
    }
}
