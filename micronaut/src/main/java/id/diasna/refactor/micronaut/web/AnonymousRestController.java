package id.diasna.refactor.micronaut.web;

import adapter.controller.AnonymousController;
import adapter.controller.model.LoginRequestModel;
import adapter.controller.model.RegisterRequestModel;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

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
            @Body RegisterRequestModel registerRequestModel) {
        anonymousController.register(registerRequestModel);
        return HttpResponse.ok();
    }
}
