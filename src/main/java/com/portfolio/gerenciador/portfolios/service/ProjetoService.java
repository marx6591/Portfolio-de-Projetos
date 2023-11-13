package com.portfolio.gerenciador.portfolios.service;

import com.portfolio.gerenciador.portfolios.domain.Pessoa;
import com.portfolio.gerenciador.portfolios.domain.Projeto;
import com.portfolio.gerenciador.portfolios.domain.enums.RiscoEnum;
import com.portfolio.gerenciador.portfolios.domain.enums.StatusEnum;
import com.portfolio.gerenciador.portfolios.domain.form.ProjetoForm;
import com.portfolio.gerenciador.portfolios.exception.ExceptionNotFound;
import com.portfolio.gerenciador.portfolios.exception.ExceptionUnauthorized;
import com.portfolio.gerenciador.portfolios.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;

    private final PessoaService pessoaService;

    public Projeto create(ProjetoForm projetoForm) {

        Pessoa gerente = pessoaService.searchById(projetoForm.getIdgerente());

        if(!gerente.getFuncionario()) {
            throw new ExceptionUnauthorized("Gerente deve ser um funcionário");
        }

        Projeto projeto = Projeto.builder()
                .nome(projetoForm.getNome())
                .dataPrevisaoFim(projetoForm.getDataPrevisaoFim())
                .descricao(projetoForm.getDescricao())
                .orcamento(projetoForm.getOrcamento())
                .status(StatusEnum.PLANEJADO.getValue())
                .idgerente(gerente).build();

        return repository.save(projeto);

    }

    public Projeto iniciarProjeto(long id) {

        Projeto projeto = searchById(id);

        if(!projeto.getStatus().equals(StatusEnum.PLANEJADO.getValue())) {
            throw new ExceptionUnauthorized("Status do Projeto diferente de Planejado");
        }

        if (projeto.getOrcamento() <= 50000) {
            projeto.setRisco(RiscoEnum.BAIXO.getValue());
        } else if (projeto.getOrcamento() <= 500000) {
            projeto.setRisco(RiscoEnum.MEDIO.getValue());
        } else {
            projeto.setRisco(RiscoEnum.ALTO.getValue());
        }

        projeto.setDataInicio(new Date());
        projeto.setStatus(StatusEnum.INICIADO.getValue());

        return repository.save(projeto);

    }

    public Projeto alterarStatus(long id) {

        Projeto projeto = searchById(id);

        if (projeto.getStatus().equals(StatusEnum.INICIADO.getValue())) {
            projeto.setStatus(StatusEnum.ANALISE.getValue());
        } else if (projeto.getStatus().equals(StatusEnum.ANALISE.getValue())) {
            projeto.setStatus(StatusEnum.REALIZADA.getValue());
        } else if (projeto.getStatus().equals(StatusEnum.REALIZADA.getValue())) {
            projeto.setStatus(StatusEnum.APROVADA.getValue());
        } else if (projeto.getStatus().equals(StatusEnum.APROVADA.getValue())) {
            projeto.setStatus(StatusEnum.ANDAMENTO.getValue());
        } else if (projeto.getStatus().equals(StatusEnum.ANDAMENTO.getValue())) {
            projeto.setStatus(StatusEnum.ENCERRADO.getValue());
            projeto.setDataFim(new Date());
        } else {
            throw new ExceptionUnauthorized("Projeto não permite mais alteração de status");
        }

        return repository.save(projeto);

    }

    public void delete(long id) {

        Projeto projeto = searchById(id);

        if (projeto.getStatus().equals(StatusEnum.INICIADO.getValue()) || projeto.getStatus().equals(StatusEnum.ANDAMENTO.getValue()) || projeto.getStatus().equals(StatusEnum.ENCERRADO.getValue())) {
            throw new ExceptionUnauthorized("Status do projeto não permite ser excluído");
        } else {
            projeto.setStatus(StatusEnum.CANCELADO.getValue());
            repository.save(projeto);
        }
    }

    public Projeto update(ProjetoForm projetoForm, long id) {

        Projeto projeto = searchById(id);

        if (projetoForm.getNome() != null) {
            projeto.setNome(projetoForm.getNome());
        }
        if (projetoForm.getDescricao() != null) {
            projeto.setDescricao(projetoForm.getDescricao());
        }
        if (projetoForm.getDataPrevisaoFim() != null) {
            projeto.setDataPrevisaoFim(projetoForm.getDataPrevisaoFim());
        }
        if (projetoForm.getOrcamento() != null) {
            projeto.setOrcamento(projetoForm.getOrcamento());
        }
        if (Long.valueOf(projetoForm.getIdgerente()) != 0) {
            Pessoa gerente = pessoaService.searchById(projetoForm.getIdgerente());
            projeto.setIdgerente(gerente);
        }

        return repository.save(projeto);

    }

    public Projeto searchById(long id) {
        return repository.findById(id).orElseThrow(() -> new ExceptionNotFound(Long.toString(id), "ID PROJETO INEXISTENTE"));
    }

    public List<Projeto> searchAll() {
        return repository.findAll();
    }
}
