package com.portfolio.gerenciador.portfolios.repository;


import com.portfolio.gerenciador.portfolios.domain.Membros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembrosRepository extends JpaRepository<Membros, Long> {

}
