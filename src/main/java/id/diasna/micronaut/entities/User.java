/* Copyright (C) 2021 ASYX International B.V. All rights reserved. */
package id.diasna.micronaut.entities;

/**
 * @author diasa
 * @version 1.0, Aug 16, 2021
 * @since
 */
public class User {
    private String id;
    private String email;
    private String fullName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
