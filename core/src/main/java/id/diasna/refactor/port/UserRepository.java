package id.diasna.refactor.port;

import java.util.Optional;

import id.diasna.refactor.entities.User;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    User createUser(User user);
}
