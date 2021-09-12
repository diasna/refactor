package id.diasna.refactor.port;

import id.diasna.refactor.entities.Document;

public interface DocumentRepository {
    void createDocument(Document document);
}
