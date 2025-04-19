package vn.ert45ty.coursemanagement.application.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.domain.usecase.UserUseCase.DeleteUserUseCase;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeleteUserService implements DeleteUserUseCase {
    private final UserRepository userRepository;

    @Override
    public void execute(long id) {
        userRepository.delete(id);
        log.info("Deleted user with userId={}", id);
    }
}
