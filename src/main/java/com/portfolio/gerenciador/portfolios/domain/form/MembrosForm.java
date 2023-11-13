package com.portfolio.gerenciador.portfolios.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MembrosForm {

    String nome;
    String cargo;
}
