package com.infoshareacademy.service;

import com.infoshareacademy.dao.UserDao;
import com.infoshareacademy.domain.entity.User;
import com.infoshareacademy.dto.UserDTO;
import com.infoshareacademy.mapper.UserMapperToEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {


    @Inject
    UserDao userDao;

    @Inject
    UserMapperToEntity userMapperToEntity;

    public void addUserToEntity(UserDTO userDTO) {
        User user = userMapperToEntity.mapUserDtoToEntity(userDTO);
        userDao.addUser(user);
    }

}
