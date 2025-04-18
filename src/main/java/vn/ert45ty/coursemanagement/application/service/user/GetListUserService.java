package vn.ert45ty.coursemanagement.application.service.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.ert45ty.coursemanagement.domain.model.PageDomain;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.domain.repository.UserRepository;
import vn.ert45ty.coursemanagement.domain.usecase.GetListUserUseCase;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetListUserService implements GetListUserUseCase {
    private final UserRepository userRepository;

    @Override
    public PageDomain<User> execute(int pageNo, int pageSize, String sortBy, String search) {
        List<User> users = userRepository.getListUser(pageNo, pageSize, sortBy, search);
        Long totalElements = userRepository.countUsers(search);
        int totalPages = (int) Math.ceil(totalElements/pageSize);
        return PageDomain.<User>builder()
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .items(users)
                .build();
    }
}
