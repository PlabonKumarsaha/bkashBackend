package com.bikash.bikashBackend.Service.imple;

import com.bikash.bikashBackend.DTO.UserDto;
import com.bikash.bikashBackend.Model.User;
import com.bikash.bikashBackend.Service.UserService;
import com.bikash.bikashBackend.View.Response;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImplement implements UserService {


    @Override
    public Response createUser(UserDto userDto) {
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        return null;
    }

    @Override
    public Response getAllusers() {
        return null;
    }
}
