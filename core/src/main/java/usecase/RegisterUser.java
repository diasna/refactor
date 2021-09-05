/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package usecase;

import entities.User;
import usecase.port.IdGenerator;
import usecase.port.UserRepository;
import usecase.validator.RegisterUserValidator;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
public class RegisterUser {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;

    public RegisterUser(UserRepository userRepository,
                        IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    public void register(String email, String fullName) {
        RegisterUserValidator.validateRegisterUser(email, fullName);
        User user = new User();
        user.setId(idGenerator.generate());
        user.setEmail(email);
        user.setFullName(fullName);
        userRepository.createUser(user);
    }

}
