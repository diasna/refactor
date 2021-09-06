package adapter.repository;

import entities.Token;
import usecase.port.TokenRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryTokenRepository implements TokenRepository {
    private final Map<String, Token> inMemoryDb = new HashMap<>();

    @Override
    public Optional<Token> findByToken(String token) {
        return inMemoryDb.values().stream()
                .filter(t -> t.getToken().equals(token))
                .findAny();
    }

    @Override
    public Token createToken(Token token) {
        return inMemoryDb.put(token.getUserId(), token);
    }
}
