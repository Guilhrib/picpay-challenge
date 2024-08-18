package com.ribeiro.picpaychallenge.transaction;

import com.ribeiro.picpaychallenge.authorization.AuthorizerService;
import com.ribeiro.picpaychallenge.notification.NotificationService;
import com.ribeiro.picpaychallenge.transaction.exception.InvalidTransactionException;
import com.ribeiro.picpaychallenge.transaction.exception.InvalidValueException;
import com.ribeiro.picpaychallenge.wallet.Wallet;
import com.ribeiro.picpaychallenge.wallet.exception.WalletNotFoundException;
import com.ribeiro.picpaychallenge.wallet.WalletRepository;
import com.ribeiro.picpaychallenge.wallet.WalletType;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final AuthorizerService authorizerService;
    private final NotificationService notificationService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    @Transactional
    public TransactionDto create(TransactionDto dto) {
        validate(dto);
        var newTransaction = transactionRepository.save(dto.toEntity());
        debitPayerWallet(dto);
        creditPayeeWallet(dto);
        authorizerService.authorize(newTransaction);
        notificationService.send(newTransaction);
        logger.info("transaction created {}", newTransaction);
        return TransactionDto.fromEntity(newTransaction);
    }

    private void validate(TransactionDto dto) {
        logger.info("validating transaction {}", dto);
        if (dto.value().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidValueException();
        }

        walletRepository.findById(dto.payee())
            .map(payee -> walletRepository.findById(dto.payer())
                .map(payer -> isTransactionValid(dto, payer) ? dto : null)
                .orElseThrow(() -> new InvalidTransactionException(dto)))
            .orElseThrow(() -> new InvalidTransactionException(dto));
    }

    private boolean isTransactionValid(TransactionDto dto, Wallet payer) {
        return payer.type() == WalletType.COMUM.getValue() &&
                payer.balance().compareTo(dto.value()) >= 0 &&
                !payer.id().equals(dto.payee());
    }

    private void debitPayerWallet(TransactionDto dto) {
        logger.info("debiting payer");
        var walletPayer = walletRepository.findById(dto.payer())
                .orElseThrow(() -> new WalletNotFoundException(TransactionType.PAYER));
        walletRepository.save(walletPayer.debit(dto.value()));
        logger.info("payer debited {}", walletPayer);
    }

    private void creditPayeeWallet(TransactionDto dto) {
        logger.info("crediting payee");
        var walletPayee = walletRepository.findById(dto.payee())
                .orElseThrow(() -> new WalletNotFoundException(TransactionType.PAYEE));
        walletRepository.save(walletPayee.credit(dto.value()));
        logger.info("payee credited {}", walletPayee);
    }
}
