package com.portfolio.gerenciador.portfolios.controller;

import com.portfolio.gerenciador.portfolios.domain.Projeto;
import com.portfolio.gerenciador.portfolios.domain.form.ProjetoForm;
import com.portfolio.gerenciador.portfolios.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
@Slf4j
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Projeto> create(@RequestBody ProjetoForm projetoForm) {
        log.info("class=ProjetoController method=create step=start");

        Projeto projeto = service.create(projetoForm);

        log.info("class=ProjetoController method=create step=end");

        return new ResponseEntity<>(projeto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projeto> getProjeto(@PathVariable("id") long id) {
        log.info("class=ProjetoController method=getProjeto step=start");

        Projeto projeto = service.searchById(id);

        log.info("class=ProjetoController method=getProjeto step=end");

        return new ResponseEntity<>(projeto, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Projeto>> findAll() {
        log.info("class=ProjetoController method=findAll step=start");

        List<Projeto> projetos = service.searchAll();

        log.info("class=ProjetoController method=findAll step=end");

        return new ResponseEntity<>(projetos, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projeto> update(@PathVariable("id") long id,
                                          @RequestBody ProjetoForm projetoForm) {
        log.info("class=ProjetoController method=update step=start");

        Projeto projeto = service.update(projetoForm, id);

        log.info("class=ProjetoController method=update step=end");

        return new ResponseEntity<>(projeto, HttpStatus.OK);
    }

    @DeleteMapping(path = {"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> delete(@PathVariable long id) {
        log.info("class=ProjetoController method=delete step=start");

        service.delete(id);

        log.info("class=ProjetoController method=delete step=end");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/iniciar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projeto> iniciarProjeto(@PathVariable("id") long id) {
        log.info("class=ProjetoController method=iniciarProjeto step=start");

        Projeto projeto = service.iniciarProjeto(id);

        log.info("class=ProjetoController method=iniciarProjeto step=end");

        return new ResponseEntity<>(projeto, HttpStatus.OK);
    }

    @PostMapping(value = "/alterarStatus/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Projeto> alterarStatus(@PathVariable("id") long id) {
        log.info("class=ProjetoController method=alterarStatus step=start");

        Projeto projeto = service.alterarStatus(id);

        log.info("class=ProjetoController method=alterarStatus step=end");

        return new ResponseEntity<>(projeto, HttpStatus.OK);
    }
}
