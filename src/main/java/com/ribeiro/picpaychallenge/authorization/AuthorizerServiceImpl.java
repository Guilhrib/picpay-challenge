package com.ribeiro.picpaychallenge.authorization;

import com.ribeiro.picpaychallenge.authorization.exception.UnauthorizedTransactionException;
import com.ribeiro.picpaychallenge.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Service
public class AuthorizerServiceImpl implements AuthorizerService {
    private static final Logger logger = LoggerFactory.getLogger(AuthorizerServiceImpl.class);
    private final RestClient restClient;

    public AuthorizerServiceImpl(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl("https://run.mocky.io/v3/5794d450-d2e2-8131-73d0293ac1cc")
                .build();
    }

    @Override
    public void authorize(Transaction transaction) throws UnauthorizedTransactionException {
        logger.info("authorizing transaction {}", transaction);
        var response = restClient.get()
                .retrieve()
                .toEntity(Authorization.class);

        if(response.getStatusCode().isError() || !Objects.requireNonNull(response.getBody()).isAuthorized()) {
            throw new UnauthorizedTransactionException();
        }
        logger.info("transaction authorized {}", transaction);
    }
}
