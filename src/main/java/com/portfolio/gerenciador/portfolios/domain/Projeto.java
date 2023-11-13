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
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "data_inicio")
    private Date dataInicio;

    @Column(name = "data_previsao_fim")
    private Date dataPrevisaoFim;

    @Column(name = "data_fim")
    private Date dataFim;

    @Column
    private String descricao;

    @Column
    private String status;

    @Column
    private Float orcamento;

    @Column
    private String risco;

    @ManyToOne
    @JoinColumn(name= "idgerente", referencedColumnName = "id")
    private Pessoa idgerente;
}
