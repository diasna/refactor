/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.adapter.controller.model;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
public class LoginRequestModel {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
