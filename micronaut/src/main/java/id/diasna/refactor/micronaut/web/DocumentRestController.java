package id.diasna.refactor.micronaut.web;

import id.diasna.refactor.adapter.controller.document.DocumentController;
import id.diasna.refactor.adapter.controller.document.model.CreateDocumentRequestModel;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

@Controller
public class DocumentRestController {
    private final DocumentController documentController;

    public DocumentRestController(DocumentController documentController) {
        this.documentController = documentController;
    }

    @Post(value = "documents", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Void> createDocument(@Body CreateDocumentRequestModel createDocumentRequestModel) {
        documentController.create(createDocumentRequestModel);
        return HttpResponse.ok();
    }
}
