package usecase.authentication;

import org.slf4j.Logger;
import usecase.exception.NotAllowedException;

import static org.slf4j.LoggerFactory.getLogger;

public class ValidateUserProcessor extends AuthenticationProcessor {
    private static final Logger log = getLogger(ValidateUserProcessor.class);

    @Override
    public void process(AuthenticationRequest authenticationContext) {
        var user = authenticationContext.getUserRepository().findByEmail(authenticationContext.getEmail())
                .orElseThrow(() -> new NotAllowedException(
                        "Invalid email or password"));
        var hashedPassword = authenticationContext.getPasswordEncoder()
                .encode(authenticationContext.getEmail() + authenticationContext.getPassword());
        if (!user.getPassword().equals(hashedPassword)) throw new NotAllowedException("Not allowed");
        log.info("User {} logged in", user.getFullName());

        authenticationContext.setUser(user);
        if (nextProcessor != null) nextProcessor.process(authenticationContext);
    }
}
