package usecase.port;

import java.util.Optional;

import entities.User;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    User createUser(User user);
}
