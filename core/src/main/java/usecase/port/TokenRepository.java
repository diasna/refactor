package usecase.port;

import entities.Token;

import java.util.Optional;

public interface TokenRepository {
    Optional<Token> findByToken(String token);

    Token createToken(Token token);
}
