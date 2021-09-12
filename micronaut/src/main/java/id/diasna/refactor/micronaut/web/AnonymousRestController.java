package id.diasna.refactor.micronaut.web;

import id.diasna.refactor.adapter.controller.anonymous.AnonymousController;
import id.diasna.refactor.adapter.controller.anonymous.model.RegisterRequestModel;
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

    @Post(value = "register", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Void> register(
            @Body RegisterRequestModel registerRequestModel) {
        anonymousController.register(registerRequestModel);
        return HttpResponse.ok();
    }
}
