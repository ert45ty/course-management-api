package vn.ert45ty.coursemanagement.presentation.controller.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.ert45ty.coursemanagement.application.service.user.CreateUserService;
import vn.ert45ty.coursemanagement.presentation.dto.request.CreateUserRequest;
import vn.ert45ty.coursemanagement.presentation.dto.response.ResponseData;
import vn.ert45ty.coursemanagement.presentation.dto.response.ResponseError;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "User Controller")
@RequestMapping("/api/user")
public class UserController {
    private final CreateUserService createUserService;

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
}
