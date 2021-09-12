package id.diasna.refactor.usecase;

import id.diasna.refactor.entities.User;
import id.diasna.refactor.port.PasswordEncoder;
import id.diasna.refactor.exception.UserValidationException;
import id.diasna.refactor.port.IdGenerator;
import id.diasna.refactor.port.UserRepository;
import id.diasna.refactor.validator.RegisterUserValidator;

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
