package id.diasna.refactor.micronaut;

import id.diasna.refactor.adapter.JugIdGenerator;
import id.diasna.refactor.adapter.Sha256PasswordEncoder;
import id.diasna.refactor.adapter.controller.anonymous.AnonymousController;
import id.diasna.refactor.adapter.controller.document.DocumentController;
import id.diasna.refactor.adapter.repository.DocumentJpaRepository;
import id.diasna.refactor.adapter.repository.entities.mapper.DocumentEntityMapper;
import id.diasna.refactor.port.DocumentRepository;
import id.diasna.refactor.port.IdGenerator;
import id.diasna.refactor.port.PasswordEncoder;
import id.diasna.refactor.port.UserRepository;
import id.diasna.refactor.usecase.RegisterUser;
import id.diasna.refactor.usecase.document.CreateDocument;
import io.micronaut.context.annotation.Factory;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Factory
public class Configuration {
    private final JugIdGenerator jugIdGenerator = new JugIdGenerator();

    @PersistenceContext
    private EntityManager entityManager;

    @Singleton
    public DocumentRepository documentRepository() {
        return new DocumentJpaRepository(entityManager, new DocumentEntityMapper());
    }

    @Singleton
    public IdGenerator idGenerator() {
        return jugIdGenerator;
    }

    @Singleton
    public PasswordEncoder passwordEncoder() {
        return new Sha256PasswordEncoder();
    }

    @Singleton
    public DocumentController documentController(final DocumentRepository documentRepository,
                                                 final IdGenerator idGenerator) {
        return new DocumentController(new CreateDocument(documentRepository, idGenerator));
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
