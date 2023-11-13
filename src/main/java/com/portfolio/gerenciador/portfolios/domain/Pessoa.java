package com.portfolio.gerenciador.portfolios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private Date datanascimento;

    @Column
    private String cpf;

    @Column
    private Boolean funcionario;

}
