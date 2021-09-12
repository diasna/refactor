package id.diasna.refactor.adapter.controller.anonymous;

import id.diasna.refactor.adapter.controller.anonymous.model.RegisterRequestModel;
import id.diasna.refactor.usecase.RegisterUser;

public class AnonymousController {
    private final RegisterUser registerUser;

    public AnonymousController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    public void register(RegisterRequestModel registerRequestModel) {
        registerUser.register(
                registerRequestModel.getEmail(),
                registerRequestModel.getFullName(),
                registerRequestModel.getPassword());
    }

}
