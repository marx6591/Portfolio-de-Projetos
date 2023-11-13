package com.portfolio.gerenciador.portfolios.service;

import com.portfolio.gerenciador.portfolios.domain.Pessoa;
import com.portfolio.gerenciador.portfolios.domain.form.PessoaForm;
import com.portfolio.gerenciador.portfolios.exception.ExceptionNotFound;
import com.portfolio.gerenciador.portfolios.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public Pessoa create(PessoaForm pessoaForm) {

        Boolean funcionario = pessoaForm.getFuncionario();

        if(funcionario == null) {
            funcionario = false;
        }

        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaForm.getNome())
                .datanascimento(pessoaForm.getDataNascimento())
                .cpf(pessoaForm.getCpf())
                .funcionario(funcionario).build();

        return repository.save(pessoa);

    }

    public Pessoa searchById(long id) {
        return repository.findById(id).orElseThrow(() -> new ExceptionNotFound(Long.toString(id), "ID PESSOA INEXISTENTE"));
    }
}
