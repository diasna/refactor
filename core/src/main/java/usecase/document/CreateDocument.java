package usecase.document;

import entities.Document;
import usecase.port.DocumentRepository;
import usecase.port.IdGenerator;

public class CreateDocument {
    private final DocumentRepository documentRepository;
    private final IdGenerator idGenerator;

    public CreateDocument(DocumentRepository documentRepository, IdGenerator idGenerator) {
        this.documentRepository = documentRepository;
        this.idGenerator = idGenerator;
    }

    public void create(String name, String content) {
        Document document = new Document();
        document.setName(name);
        document.setContent(content);
        documentRepository.createDocument(document);
    }
}