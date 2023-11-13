package com.portfolio.gerenciador.portfolios.repository;

import com.portfolio.gerenciador.portfolios.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
