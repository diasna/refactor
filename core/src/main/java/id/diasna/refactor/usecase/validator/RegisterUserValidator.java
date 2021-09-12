package id.diasna.refactor.usecase.validator;

import org.apache.commons.lang.StringUtils;
import id.diasna.refactor.usecase.exception.UserValidationException;

public class RegisterUserValidator {
    public static void validateRegisterUser(String email, String fullName) {
        if (StringUtils.isBlank(email)) throw new UserValidationException("Email should not be null");
        if (StringUtils.isBlank(fullName)) throw new UserValidationException("Full name should not be null");
    }

    private RegisterUserValidator() {

    }
}
