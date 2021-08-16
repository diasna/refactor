/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.adapter.controller.model;

import javax.validation.constraints.NotBlank;

import io.micronaut.core.annotation.Introspected;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
@Introspected
public class RegisterRequestModel {
    @NotBlank
    private String email;
    @NotBlank
    private String fullName;

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }
}
