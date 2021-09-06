package adapter.repository;

import entities.Document;
import usecase.port.DocumentRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDocumentRepository implements DocumentRepository {
    private final Map<String, Document> inMemoryDb = new HashMap<>();

    @Override
    public Document createDocument(Document document) {
        return inMemoryDb.put(document.getId(), document);
    }
}
