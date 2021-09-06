package id.diasna.refactor.flows.state;

import id.diasna.refactor.flows.Input;
import id.diasna.refactor.flows.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class State {

    public abstract String getType();

    private Map<Integer, Function<Input, Status>> actionToHandler = new HashMap<>();

    public void on(int action, Function<Input, Status> handler) {
        actionToHandler.put(action, handler);
    }

    public Status handle(int action, Input input) {
        return actionToHandler.get(action).apply(input);
    }
}