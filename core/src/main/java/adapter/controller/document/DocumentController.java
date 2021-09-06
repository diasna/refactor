package adapter.controller.document;

import adapter.controller.document.model.CreateDocumentRequestModel;
import usecase.document.CreateDocument;

public class DocumentController {
    private final CreateDocument createDocument;

    public DocumentController(CreateDocument createDocument) {
        this.createDocument = createDocument;
    }

    public void create(CreateDocumentRequestModel model) {
        createDocument.create(model.getName(), model.getContent());
    }
}
