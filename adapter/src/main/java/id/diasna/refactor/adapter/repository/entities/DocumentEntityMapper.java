package id.diasna.refactor.adapter.repository.entities;

import id.diasna.refactor.domain.Document;

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
