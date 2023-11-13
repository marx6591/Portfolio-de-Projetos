package com.portfolio.gerenciador.portfolios.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RiscoEnum {
    BAIXO("baixo risco"),
    MEDIO("medio risco"),
    ALTO("alto risco");

    @Getter
    private String value;
}
