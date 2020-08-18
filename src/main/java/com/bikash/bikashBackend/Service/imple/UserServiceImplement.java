package com.bikash.bikashBackend.Service.imple;

import com.bikash.bikashBackend.dto.UserDto;
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
    public User getUserByPhone(String phone) {
        return null;
    }

    @Override
    public Response getAllusers() {
        return null;
    }
}
