package usecase;

import usecase.exception.NotAllowedException;
import usecase.port.UserRepository;

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