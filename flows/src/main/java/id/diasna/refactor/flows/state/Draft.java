package id.diasna.refactor.flows.state;

import id.diasna.refactor.flows.Document;
import id.diasna.refactor.flows.Action;
import id.diasna.refactor.flows.Status;

public class Draft extends State {
    @Override
    public String getType() {
        return "DRAFT";
    }

    public Draft(Document document) {
        this.on(Action.REVIEW, input -> {
            document.setContent(input.getContent());
            document.setCurrentState(new InReview(document));
            return new Status();
        });
        this.on(Action.APPROVE, input -> new Status(true, "The document cannot be approved if it is in DRAFT state."));

        this.on(Action.REJECT, input -> new Status(true, "The document cannot be rejected if it is in DRAFT state."));

        this.on(Action.CLOSED, input -> new Status(true, "The document cannot be closed if it is in DRAFT state."));
    }
}