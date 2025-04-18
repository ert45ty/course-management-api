package vn.ert45ty.coursemanagement.presentation.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.ert45ty.coursemanagement.application.service.user.*;
import vn.ert45ty.coursemanagement.domain.model.PageDomain;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.infrastructure.persistence.mapper.PageMapper;
import vn.ert45ty.coursemanagement.infrastructure.persistence.mapper.UserMapper;
import vn.ert45ty.coursemanagement.presentation.dto.request.ChangePasswordRequest;
import vn.ert45ty.coursemanagement.presentation.dto.request.CreateUserRequest;
import vn.ert45ty.coursemanagement.presentation.dto.request.UpdateUserRequest;
import vn.ert45ty.coursemanagement.presentation.dto.response.PageResponse;
import vn.ert45ty.coursemanagement.presentation.dto.response.ResponseData;
import vn.ert45ty.coursemanagement.presentation.dto.response.ResponseError;
import vn.ert45ty.coursemanagement.presentation.dto.response.UserResponse;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "User Controller")
@RequestMapping("/api/user")
public class UserController {
    private final CreateUserService createUserService;
    private final UpdateUserService updateUserService;
    private final ChangePasswordService changePasswordService;
    private final DeleteUserService deleteUserService;
    private final GetUserService getUserService;
    private final GetListUserService getListUserService;

    @Operation(summary = "Add user", description = "API create new user for user")
    @PostMapping("/create")
    public ResponseData<?> createUser(@Valid @RequestBody CreateUserRequest request){
        log.info("Request create user");
        try {
            Long id = createUserService.execute(request);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "create user successfully!", id);
        }catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "create user fail");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseData<Void> updateUser(@Valid @RequestBody UpdateUserRequest request,
                                         @PathVariable Long id){
        log.info("Request update user with userId={}", id);
        try {
            updateUserService.excecute(id, request);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "update user successfully!");
        }catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Update user fail");
        }
    }

    @PatchMapping("/changePassword/{id}")
    public ResponseData<Void> changePassword(@Valid @RequestBody ChangePasswordRequest request,
                                             @PathVariable Long id){
        log.info("Request change password, userId={}", id);
        try {
            changePasswordService.execute(id, request);
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "Change password successfully");
        }catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Change password fail");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseData<Void> deleteUser(@PathVariable Long id){
        log.info("Request delete user with id={}", id);
        try {
            deleteUserService.execute(id);
            return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "Delete user successfully");
        }catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Delete user fail");
        }
    }

    @GetMapping("/{id}")
    public ResponseData<UserResponse> getUserDetail(@PathVariable Long id){
        log.info("Request get detail user with id={}", id);
        try {
            User user = getUserService.execute(id);
            UserResponse response = UserMapper.domainToResponse(user);
            return new ResponseData<>(HttpStatus.OK.value(), "detail user", response);
        }catch (Exception e){
            log.error("errorMessage={}", e.getMessage(), e.getCause());
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Get detail user fail");
        }
    }

    @GetMapping("/list-users-with-search-and-sort")
    public ResponseData<?> userListWithSearchAndSort(@Min(1) @RequestParam(defaultValue = "1") int pageNo,
                                                     @RequestParam(defaultValue = "20") int pageSize,
                                                     @RequestParam(required = false) String search,
                                                     @RequestParam(required = false) String sortBy){
        log.info("Request get all of users");
        PageDomain<User> page = getListUserService.execute(pageNo, pageSize, sortBy, search);
        PageResponse<UserResponse> response = PageMapper.map(page, UserMapper::domainToResponse);
        return new ResponseData<>(HttpStatus.OK.value(), "list user", response);
    }


}
