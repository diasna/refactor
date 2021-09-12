package id.diasna.refactor.adapter.repository.entities.mapper;

import id.diasna.refactor.adapter.repository.entities.DocumentEntity;
import id.diasna.refactor.entities.Document;

public class DocumentEntityMapper {
    public DocumentEntity from(Document document) {
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setId(document.getId());
        documentEntity.setName(document.getName());
        documentEntity.setContent(document.getContent());
        return documentEntity;
    }

    public Document to(DocumentEntity documentEntity) {
        Document document = new Document();
        document.setId(documentEntity.getId());
        document.setName(documentEntity.getName());
        document.setContent(documentEntity.getContent());
        return document;
    }
}
