package id.diasna.refactor.micronaut;

import id.diasna.refactor.adapter.JugIdGenerator;
import id.diasna.refactor.adapter.Sha256PasswordEncoder;
import id.diasna.refactor.adapter.controller.anonymous.AnonymousController;
import id.diasna.refactor.adapter.repository.InMemoryUserRepository;
import io.micronaut.context.annotation.Factory;
import id.diasna.refactor.usecase.RegisterUser;
import id.diasna.refactor.usecase.port.IdGenerator;
import id.diasna.refactor.usecase.port.PasswordEncoder;
import id.diasna.refactor.usecase.port.UserRepository;

import javax.inject.Singleton;

@Factory
public class Configuration {
    private final JugIdGenerator jugIdGenerator = new JugIdGenerator();
    private final InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();

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
    public AnonymousController anonymousController(final UserRepository userRepository,
                                                   final IdGenerator idGenerator,
                                                   final PasswordEncoder passwordEncoder) {
        return new AnonymousController(
                new RegisterUser(userRepository, idGenerator, passwordEncoder())
        );
    }
}
