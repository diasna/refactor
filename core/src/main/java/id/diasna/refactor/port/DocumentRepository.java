package id.diasna.refactor.port;

import id.diasna.refactor.domain.Document;

public interface DocumentRepository {
    void createDocument(Document document);
}
