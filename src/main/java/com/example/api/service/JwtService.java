package com.example.api.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {

    /**
     * Extracts the username from the provided token.
     *
     * @param token the JWT token
     * @return the username extracted from the token
     */
    public String extractUsername(String token);

    /**
     * Generates a new token for a user.
     *
     * @param userDetails the user details for whom the token is generated
     * @return the generated JWT token
     */
    public String generateToken(UserDetails userDetails);

    /**
     * Validates the token for a specific user based on its expiration and other criteria.
     *
     * @param token the JWT token to validate
     * @param userDetails the user details to validate the token against
     * @return {@code true} if the token is valid, otherwise {@code false}
     */
    public boolean isTokenValid(String token, UserDetails userDetails);

    /**
     * Extracts specific claims from the provided token using the given function.
     *
     * @param <T> the type of the claim to extract
     * @param token the JWT token
     * @param claimsTFunction a function to extract the desired claim
     * @return the extracted claim
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction);
}
