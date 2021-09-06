package adapter.controller.anonymous;

import adapter.controller.anonymous.model.LoginRequestModel;
import adapter.controller.anonymous.model.RegisterRequestModel;
import usecase.RegisterUser;
import usecase.authentication.AuthenticationRequest;

public class AnonymousController {
    private final AuthenticationRequest authenticationRequest;
    private final RegisterUser registerUser;

    public AnonymousController(AuthenticationRequest authenticationRequest, RegisterUser registerUser) {
        this.authenticationRequest = authenticationRequest;
        this.registerUser = registerUser;
    }

    public void login(LoginRequestModel loginRequestModel) {
        authenticationRequest.processAuthentication();
    }

    public void register(RegisterRequestModel registerRequestModel) {
        registerUser.register(
                registerRequestModel.getEmail(),
                registerRequestModel.getFullName(),
                registerRequestModel.getPassword());
    }

}
