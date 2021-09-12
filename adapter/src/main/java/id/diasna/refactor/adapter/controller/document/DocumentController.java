package id.diasna.refactor.adapter.controller.document;

import id.diasna.refactor.adapter.controller.document.model.CreateDocumentRequestModel;
import id.diasna.refactor.usecase.document.CreateDocument;

public class DocumentController {
    private final CreateDocument createDocument;

    public DocumentController(CreateDocument createDocument) {
        this.createDocument = createDocument;
    }

    public void create(CreateDocumentRequestModel model) {
        createDocument.create(model.getName(), model.getContent());
    }
}
