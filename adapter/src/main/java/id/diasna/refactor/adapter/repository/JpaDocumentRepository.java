package id.diasna.refactor.adapter.repository;

import id.diasna.refactor.entities.Document;
import id.diasna.refactor.usecase.port.DocumentRepository;

import java.util.HashMap;
import java.util.Map;

public class JpaDocumentRepository implements DocumentRepository {
    private final Map<String, Document> inMemoryDb = new HashMap<>();

    @Override
    public Document createDocument(Document document) {
        return inMemoryDb.put(document.getId(), document);
    }
}
