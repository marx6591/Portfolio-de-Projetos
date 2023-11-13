package com.portfolio.gerenciador.portfolios.controller;

import com.portfolio.gerenciador.portfolios.domain.Pessoa;
import com.portfolio.gerenciador.portfolios.domain.form.PessoaForm;
import com.portfolio.gerenciador.portfolios.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
@Slf4j
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> create(@RequestBody PessoaForm pessoaForm) {
        log.info("class=PessoaController method=create step=start");

        Pessoa pessoa = service.create(pessoaForm);

        log.info("class=PessoaController method=create step=end");

        return new ResponseEntity<>(pessoa, HttpStatus.CREATED);
    }
}
