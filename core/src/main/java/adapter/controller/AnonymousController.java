/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package adapter.controller;

import adapter.controller.model.LoginRequestModel;
import adapter.controller.model.RegisterRequestModel;
import usecase.LoginUser;
import usecase.RegisterUser;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
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
