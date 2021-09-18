package id.diasna.refactor.adapter.repository;

import id.diasna.refactor.adapter.repository.entities.DocumentEntityMapper;
import id.diasna.refactor.domain.Document;
import id.diasna.refactor.port.DocumentRepository;

import javax.persistence.EntityManager;

public class DocumentJpaRepository implements DocumentRepository {
    private final EntityManager entityManager;
    private final DocumentEntityMapper documentEntityMapper;

    public DocumentJpaRepository(EntityManager entityManager, DocumentEntityMapper documentEntityMapper) {
        this.entityManager = entityManager;
        this.documentEntityMapper = documentEntityMapper;
    }

    @Override
    public void createDocument(Document document) {
        entityManager.persist(documentEntityMapper.from(document));
    }
}
