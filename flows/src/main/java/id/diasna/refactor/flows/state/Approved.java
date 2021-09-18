package id.diasna.refactor.flows.state;

import id.diasna.refactor.flows.Document;

public class Approved extends State {
    @Override
    public String getType() {
        return "APPROVED";
    }

    public Approved(Document document) {

    }
}
