package com.portfolio.gerenciador.portfolios.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusEnum {
    PLANEJADO("planejado"),
    INICIADO("iniciado"),
    ANALISE("em análise"),
    REALIZADA("análise realizada"),
    APROVADA("análise aprovada"),
    ANDAMENTO("em andamento"),
    ENCERRADO("encerrado"),
    CANCELADO("cancelado");

    @Getter
    private String value;
}
