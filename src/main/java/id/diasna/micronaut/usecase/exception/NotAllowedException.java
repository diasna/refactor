/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.usecase.exception;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
public class NotAllowedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotAllowedException(String msg) {
        super(msg);
    }
}
