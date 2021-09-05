package flows.state;

import flows.Action;
import flows.Status;
import flows.Document;

public class InReview extends State {
    @Override
    public String getType() {
        return "IN REVIEW";
    }

    public InReview(Document document) {
        this.on(Action.REVIEW, input -> {
            return new Status(true, "The document is already in IN REVIEW state.");
        });
        this.on(Action.APPROVE, input -> {
            document.setCurrentState(new Approved(document));
            return new Status();
        });
        this.on(Action.REJECT, input -> {
            document.setCurrentState(new Rejected(document));
            return new Status();
        });
        this.on(Action.CLOSED, input -> new Status(true, "The document cannot be closed if it is in IN REVIEW state."));
    }
}