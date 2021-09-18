package id.diasna.refactor.domain;

public class Document {
    private String id;
    private String name;
    private String content;

    public String getId() {
        return id;
    }

    public Document setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Document setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Document setContent(String content) {
        this.content = content;
        return this;
    }
}
