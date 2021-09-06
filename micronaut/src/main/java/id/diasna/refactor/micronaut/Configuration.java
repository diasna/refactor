package id.diasna.refactor.micronaut;

import adapter.JugIdGenerator;
import adapter.Sha256PasswordEncoder;
import adapter.controller.anonymous.AnonymousController;
import adapter.repository.InMemoryTokenRepository;
import adapter.repository.InMemoryUserRepository;
import io.micronaut.context.annotation.Factory;
import usecase.RegisterUser;
import usecase.authentication.AuthenticationRequest;
import usecase.port.IdGenerator;
import usecase.port.PasswordEncoder;
import usecase.port.TokenRepository;
import usecase.port.UserRepository;

import javax.inject.Singleton;

@Factory
public class Configuration {
    private final JugIdGenerator jugIdGenerator = new JugIdGenerator();
    private final InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
    private final InMemoryTokenRepository inMemoryTokenRepository = new InMemoryTokenRepository();

    @Singleton
    public IdGenerator idGenerator() {
        return jugIdGenerator;
    }

    @Singleton
    public PasswordEncoder passwordEncoder() {
        return new Sha256PasswordEncoder();
    }

    @Singleton
    public UserRepository userRepository() {
        return inMemoryUserRepository;
    }

    @Singleton
    public TokenRepository tokenRepository() {
        return inMemoryTokenRepository;
    }

    @Singleton
    public AnonymousController anonymousController(final UserRepository userRepository,
                                                   final TokenRepository tokenRepository,
                                                   final IdGenerator idGenerator,
                                                   final PasswordEncoder passwordEncoder) {
        return new AnonymousController(
                new AuthenticationRequest(userRepository, tokenRepository, passwordEncoder),
                new RegisterUser(userRepository, idGenerator, passwordEncoder())
        );
    }
}
