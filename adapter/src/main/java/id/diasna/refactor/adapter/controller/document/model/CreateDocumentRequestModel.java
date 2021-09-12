package id.diasna.refactor.adapter.controller.document.model;

public class CreateDocumentRequestModel {
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public CreateDocumentRequestModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CreateDocumentRequestModel setContent(String content) {
        this.content = content;
        return this;
    }
}
