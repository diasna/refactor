/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package adapter.controller.model;

import javax.validation.constraints.NotBlank;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
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
