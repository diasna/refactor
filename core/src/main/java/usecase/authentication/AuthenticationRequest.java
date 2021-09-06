package usecase.authentication;

import entities.User;
import usecase.port.PasswordEncoder;
import usecase.port.TokenRepository;
import usecase.port.UserRepository;

public class AuthenticationRequest {
    //Chain
    protected AuthenticationProcessor validateUserProcessor = new ValidateUserProcessor();
    protected AuthenticationProcessor generateTokenProcessor = new GenerateTokenProcessor();

    private String email;
    private String password;

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;

    private User user;

    public AuthenticationRequest(UserRepository userRepository,
                                 TokenRepository tokenRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthenticationRequest processAuthentication() {
        validateUserProcessor.setNextProcessor(generateTokenProcessor);
        generateTokenProcessor.setNextProcessor(null);

        //Start Chain
        validateUserProcessor.process(this);
        return this;
    }

    public User getUser() {
        return user;
    }

    public AuthenticationRequest setUser(User user) {
        this.user = user;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AuthenticationRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthenticationRequest setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public TokenRepository getTokenRepository() {
        return tokenRepository;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}