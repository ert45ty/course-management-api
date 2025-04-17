package vn.ert45ty.coursemanagement.application.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.domain.usecase.UpdateUserUseCase;
import vn.ert45ty.coursemanagement.presentation.advice.ResourceNotFoundException;
import vn.ert45ty.coursemanagement.presentation.dto.request.UpdateUserRequest;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateUserService implements UpdateUserUseCase {
    private final UserRepository userRepository;

    @Override
    public void excecute(long userId, UpdateUserRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setName(request.getName());
        userRepository.updateUser(user);
        log.info("Update user successfully with userId ={}", userId);
    }
}
