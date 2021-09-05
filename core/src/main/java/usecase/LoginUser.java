/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package usecase;

import usecase.exception.NotAllowedException;
import usecase.port.UserRepository;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
public final class LoginUser {
    private final UserRepository userRepository;

    public LoginUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void login(final String email, final String password) {
        userRepository.findByEmail(email)
                .orElseThrow(() -> new NotAllowedException(
                        "Invalid email or password"));
    }
}