package flows.state;

import flows.Document;

public class Approved extends State {
    @Override
    public String getType() {
        return "APPROVED";
    }

    public Approved(Document document) {

    }
}
