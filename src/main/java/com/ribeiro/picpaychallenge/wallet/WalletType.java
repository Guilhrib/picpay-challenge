package com.ribeiro.picpaychallenge.wallet;

import lombok.Getter;

@Getter
public enum WalletType {
    COMUM(1), LOJISTA(2);

    private final int value;

    WalletType(int value) {
        this.value = value;
    }
}
