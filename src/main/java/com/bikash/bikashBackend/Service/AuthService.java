package com.bikash.bikashBackend.Service;


import com.bikash.bikashBackend.View.Response;
import com.bikash.bikashBackend.dto.LoginDto;

public interface AuthService {
    Response login(LoginDto loginDto);
}
