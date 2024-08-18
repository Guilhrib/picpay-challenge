package com.ribeiro.picpaychallenge.transaction;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TransactionDto(
        Long payer,
        Long payee,
        BigDecimal value
) {
    public Transaction toEntity() {
        return Transaction.builder()
                .payer(this.payer)
                .payee(this.payee)
                .value(this.value)
                .build();
    }

    public static TransactionDto fromEntity(Transaction transaction) {
        return TransactionDto.builder()
                .payer(transaction.payer())
                .payee(transaction.payee())
                .value(transaction.value())
                .build();
    }
}
