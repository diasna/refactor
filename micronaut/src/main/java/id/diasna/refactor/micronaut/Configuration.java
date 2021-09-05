package id.diasna.refactor.micronaut;

import adapter.JugIdGenerator;
import adapter.controller.AnonymousController;
import adapter.repository.InMemoryUserRepository;
import io.micronaut.context.annotation.Factory;
import usecase.LoginUser;
import usecase.RegisterUser;
import usecase.port.IdGenerator;
import usecase.port.UserRepository;

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
    public UserRepository userRepository() {
        return inMemoryUserRepository;
    }

    @Singleton
    public AnonymousController anonymousController(final UserRepository userRepository, final IdGenerator idGenerator) {
        return new AnonymousController(
                new LoginUser(userRepository),
                new RegisterUser(userRepository, idGenerator)
        );
    }
}
