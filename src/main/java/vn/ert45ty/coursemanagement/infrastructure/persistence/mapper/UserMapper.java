package vn.ert45ty.coursemanagement.infrastructure.persistence.mapper;

import vn.ert45ty.coursemanagement.domain.common.Role;
import vn.ert45ty.coursemanagement.presentation.dto.request.CreateUserRequest;
import vn.ert45ty.coursemanagement.domain.model.User;
import vn.ert45ty.coursemanagement.infrastructure.persistence.entity.UserEntity;
import vn.ert45ty.coursemanagement.presentation.dto.request.UpdateUserRequest;
import vn.ert45ty.coursemanagement.presentation.dto.response.UserResponse;

public class UserMapper {

    // UserEntity -> User
    public static User entityToDomain(UserEntity userEntity){
        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .role(userEntity.getRole())
                .build();
    }

    // User -> UserEntity
    public static UserEntity domainToEntity(User user){
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }

    public static User createDtoToDomain(CreateUserRequest request){
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.STUDENT)
                .build();
    }

    public static UserResponse domainToResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .created_at(user.getCreate_at())
                .build();
    }

}
