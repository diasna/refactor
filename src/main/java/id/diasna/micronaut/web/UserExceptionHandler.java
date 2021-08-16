/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.web;

import javax.inject.Singleton;

import id.diasna.micronaut.usecase.exception.NotAllowedException;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
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