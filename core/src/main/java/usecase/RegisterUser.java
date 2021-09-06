package usecase;

import entities.User;
import usecase.exception.UserValidationException;
import usecase.port.IdGenerator;
import usecase.port.PasswordEncoder;
import usecase.port.UserRepository;
import usecase.validator.RegisterUserValidator;

public class RegisterUser {
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;
    private final PasswordEncoder passwordEncoder;

    public RegisterUser(UserRepository userRepository,
                        IdGenerator idGenerator,
                        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(String email, String fullName, String password) {
        RegisterUserValidator.validateRegisterUser(email, fullName);
        if (userRepository.findByEmail(email).isPresent())
            throw new UserValidationException(email + " is already registered");
        User user = new User();
        user.setId(idGenerator.generate());
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(passwordEncoder.encode(email + password));
        userRepository.createUser(user);
    }

}
