/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package usecase.port;

import java.util.Optional;

import entities.User;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
public interface UserRepository {
    Optional<User> findByEmail(String email);

    User createUser(User user);
}
