package id.diasna.refactor.flows.state;

import id.diasna.refactor.flows.Document;

public class Rejected extends State {
    @Override
    public String getType() {
        return "REJECTED";
    }

    public Rejected(Document document) {
    }
}
