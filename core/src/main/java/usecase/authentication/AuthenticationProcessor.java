package usecase.authentication;

public abstract class AuthenticationProcessor {
    public AuthenticationProcessor nextProcessor;

    public abstract void process(AuthenticationRequest authenticationContext);

    public void setNextProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
}