package adapter.controller;

import adapter.controller.model.LoginRequestModel;
import adapter.controller.model.RegisterRequestModel;
import usecase.LoginUser;
import usecase.RegisterUser;

public class AnonymousController {
    private final LoginUser loginUser;
    private final RegisterUser registerUser;

    public AnonymousController(LoginUser loginUser, RegisterUser registerUser) {
        this.loginUser = loginUser;
        this.registerUser = registerUser;
    }

    public void login(LoginRequestModel loginRequestModel) {
        loginUser.login(loginRequestModel.getEmail(),
                loginRequestModel.getPassword());
    }

    public void register(RegisterRequestModel registerRequestModel) {
        registerUser.register(registerRequestModel.getEmail(),
                registerRequestModel.getFullName());
    }

}
