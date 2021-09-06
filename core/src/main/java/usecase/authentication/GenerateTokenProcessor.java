package usecase.authentication;

import entities.Token;
import org.apache.commons.lang.RandomStringUtils;

import java.time.LocalDateTime;

public class GenerateTokenProcessor extends AuthenticationProcessor {

    @Override
    public void process(AuthenticationRequest authenticationContext) {
        var token = new Token();
        token.setUserId(authenticationContext.getUser().getId());
        token.setTimestamp(LocalDateTime.now());
        token.setToken(RandomStringUtils.randomAlphanumeric(20));
        authenticationContext.getTokenRepository().createToken(token);
        if (nextProcessor != null) nextProcessor.process(authenticationContext);
    }
}