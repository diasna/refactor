package flows.state;

import flows.Document;

public class Rejected extends State {
    @Override
    public String getType() {
        return "REJECTED";
    }

    public Rejected(Document document) {
    }
}
