package com.example.api.service;

import com.example.api.controller.AuthenticationRequest;
import com.example.api.controller.AuthenticationResponse;
import com.example.api.controller.RegisterRequest;

public interface AuthenticationService {

    /**
     * Registers a new user.
     *
     * @param request the registration request containing user details
     * @return the authentication response containing tokens or related data
     */
    public AuthenticationResponse register(RegisterRequest request);

    /**
     * Authenticates an existing user.
     *
     * @param request the authentication request containing login credentials
     * @return the authentication response containing tokens or related data
     */
    public AuthenticationResponse authenticate(AuthenticationRequest request);
}
