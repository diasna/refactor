/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.web;

import javax.validation.Valid;

import id.diasna.micronaut.adapter.controller.AnonymousController;
import id.diasna.micronaut.adapter.controller.model.LoginRequestModel;
import id.diasna.micronaut.adapter.controller.model.RegisterRequestModel;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
@Validated
@Controller
public class AnonymousRestController {
    private final AnonymousController anonymousController;

    public AnonymousRestController(AnonymousController anonymousController) {
        this.anonymousController = anonymousController;
    }

    @Post(value = "login", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Void> login(@Body LoginRequestModel loginRequestModel) {
        anonymousController.login(loginRequestModel);
        return HttpResponse.ok();
    }

    @Post(value = "register", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Void> register(
            @Body @Valid RegisterRequestModel registerRequestModel) {
        anonymousController.register(registerRequestModel);
        return HttpResponse.ok();
    }
}
