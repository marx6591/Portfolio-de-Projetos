package com.portfolio.gerenciador.portfolios.service;

import com.portfolio.gerenciador.portfolios.domain.Membros;
import com.portfolio.gerenciador.portfolios.domain.Pessoa;
import com.portfolio.gerenciador.portfolios.domain.form.MembrosForm;
import com.portfolio.gerenciador.portfolios.exception.ExceptionNotFound;
import com.portfolio.gerenciador.portfolios.repository.MembrosRepository;
import com.portfolio.gerenciador.portfolios.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembrosService {

    private final PessoaRepository pessoaRepository;

    private final MembrosRepository repository;

    public Membros cadastro(MembrosForm membrosForm) {

        Pessoa pessoa = pessoaRepository.findPessoaByNome(membrosForm.getNome()).orElseThrow(() -> new ExceptionNotFound(membrosForm.getNome(), "PESSOA INEXISTENTE"));

        if (!membrosForm.getCargo().equals("funcionário") && pessoa.getFuncionario()) {
            throw new ExceptionNotFound(membrosForm.getCargo(), "CARGO INEXISTENTE");
        }

        Membros membros = Membros.builder()
                .idpessoa(pessoa.getId()).build();

        return repository.save(membros);

    }
}
