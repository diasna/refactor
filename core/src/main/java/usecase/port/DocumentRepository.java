package usecase.port;

import entities.Document;

public interface DocumentRepository {
    Document createDocument(Document document);
}
