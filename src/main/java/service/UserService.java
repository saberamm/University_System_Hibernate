package service;

import base.service.BaseService;
import entity.User;
import entity.dto.SimpleUser;

public interface UserService extends BaseService<User, Long> {
    SimpleUser findUserByUsername(String username);

    User userAuthentication(String user_name, String password);
}