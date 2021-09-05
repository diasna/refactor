package flows;

import flows.state.Draft;
import flows.state.State;

public class Document {

    private State currentState;
    private String content;

    public Document() {
        this.currentState = new Draft(this);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Status handle(int action, Input input) {
        return this.currentState.handle(action, input);
    }
}