package vn.ert45ty.coursemanagement.application.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.domain.usecase.UserUseCase.ChangePasswordUseCase;
import vn.ert45ty.coursemanagement.presentation.advice.PasswordNotMatchException;
import vn.ert45ty.coursemanagement.presentation.advice.ResourceNotFoundException;
import vn.ert45ty.coursemanagement.presentation.dto.request.user.ChangePasswordRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChangePasswordService implements ChangePasswordUseCase {
    private final UserRepository userRepository;

    @Override
    public void execute(long id, ChangePasswordRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        if (!user.getEmail().equals(request.getEmail())){
            throw new ResourceNotFoundException("Email does not match");
        }
        if (!user.getPassword().equals(request.getOldPassword())){
            throw new PasswordNotMatchException("Your old password does not match");
        }
        if (!request.getPassword().equals(request.getRePassword())){
            throw new PasswordNotMatchException("Your password does not match");
        }
        user.setPassword(request.getPassword());
        userRepository.updateUser(user);
        log.info("Update password successfully!");
    }
}
