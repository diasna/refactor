/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.usecase;

import javax.inject.Singleton;

import id.diasna.micronaut.entities.User;
import id.diasna.micronaut.usecase.port.IdGenerator;
import id.diasna.micronaut.usecase.port.UserRepository;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
@Singleton
public class RegisterUser {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;

    public RegisterUser(UserRepository userRepository,
            IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    public void register(String email, String fullName) {
        User user = new User();
        user.setId(idGenerator.generate());
        user.setEmail(email);
        user.setFullName(fullName);
        userRepository.createUser(user);
    }

}
