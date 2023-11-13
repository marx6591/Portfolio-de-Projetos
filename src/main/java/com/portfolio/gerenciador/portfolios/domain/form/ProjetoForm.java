package com.portfolio.gerenciador.portfolios.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoForm {

    String nome;
    Date dataPrevisaoFim;
    String descricao;
    Float orcamento;
    long idgerente;
}
