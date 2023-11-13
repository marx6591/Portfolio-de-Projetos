package com.portfolio.gerenciador.portfolios.repository;


import com.portfolio.gerenciador.portfolios.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findPessoaByNome(String nome);

}
