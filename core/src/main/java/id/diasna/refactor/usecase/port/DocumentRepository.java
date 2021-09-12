package id.diasna.refactor.usecase.port;

import id.diasna.refactor.entities.Document;

public interface DocumentRepository {
    Document createDocument(Document document);
}
