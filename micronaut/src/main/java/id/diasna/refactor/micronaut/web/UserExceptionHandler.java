package id.diasna.refactor.micronaut.web;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import id.diasna.refactor.usecase.exception.NotAllowedException;

import javax.inject.Singleton;

import static org.slf4j.LoggerFactory.getLogger;

@Produces
@Singleton
public class UserExceptionHandler
        implements ExceptionHandler<NotAllowedException, HttpResponse<Void>> {
    @Override
    public HttpResponse<Void> handle(HttpRequest request,
                                     NotAllowedException exception) {
        return HttpResponse.unauthorized();
    }

}