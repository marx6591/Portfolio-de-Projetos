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
public class PessoaForm {

    String nome;
    Date dataNascimento;
    String cpf;
    Boolean funcionario;
}
