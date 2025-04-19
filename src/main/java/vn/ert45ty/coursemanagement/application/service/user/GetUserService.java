package vn.ert45ty.coursemanagement.application.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.domain.usecase.UserUseCase.GetUserUseCase;
import vn.ert45ty.coursemanagement.presentation.advice.ResourceNotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetUserService implements GetUserUseCase {
    private final UserRepository userRepository;

    @Override
    public User execute(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

}
