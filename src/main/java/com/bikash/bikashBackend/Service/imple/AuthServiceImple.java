package com.bikash.bikashBackend.Service.imple;

import com.bikash.bikashBackend.Model.User;
import com.bikash.bikashBackend.Service.AuthService;
import com.bikash.bikashBackend.View.Response;
import com.bikash.bikashBackend.View.ResponseBuilder;
import com.bikash.bikashBackend.dto.LoginDto;
import com.bikash.bikashBackend.dto.LoginResponseDto;
import com.bikash.bikashBackend.filter.JwtTokenProvider;
import com.bikash.bikashBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service("authService")
public class AuthServiceImple implements AuthService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public AuthServiceImple(UserRepository userRepository, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public Response login(LoginDto loginDto, HttpServletRequest request) {
        User user = userRepository.findByPhoneAndIsActiveTrue(loginDto.getPhone());
        if (user == null) {
            return ResponseBuilder.getFailureResponce(HttpStatus.UNAUTHORIZED, "Invalid Phone or Password");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getPhone(), loginDto.getPassword()));
        if (authentication.isAuthenticated()) {
            LoginResponseDto loginResponseDto = new LoginResponseDto();
            loginResponseDto.setToken(jwtTokenProvider.generateToken(authentication,request));
            loginResponseDto.setUsername(user.getUsername());
            return ResponseBuilder.getSuccessResponce(HttpStatus.OK, "Logged In Success", loginResponseDto);
        }
        return ResponseBuilder.getFailureResponce(HttpStatus.BAD_REQUEST, "Invalid Phone or Password");
    }
}
