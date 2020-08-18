package com.bikash.bikashBackend.Service;


import com.bikash.bikashBackend.View.Response;
import com.bikash.bikashBackend.dto.LoginDto;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
    Response login(LoginDto loginDto, HttpServletRequest request);
}
