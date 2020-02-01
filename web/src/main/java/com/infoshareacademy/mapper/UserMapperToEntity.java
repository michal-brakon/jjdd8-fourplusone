package com.infoshareacademy.mapper;


import com.infoshareacademy.domain.entity.User;
import com.infoshareacademy.dto.UserDTO;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserMapperToEntity {

    public User mapUserDtoToEntity(UserDTO userDTO) {

        User user = new User();

        user.setEmail(userDTO.getEmail());

        user.setName(userDTO.getName());

        user.setRole(userDTO.getRole());

        return user;
    }


}
