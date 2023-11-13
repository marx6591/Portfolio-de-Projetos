package com.portfolio.gerenciador.portfolios.controller;

import com.portfolio.gerenciador.portfolios.domain.Membros;
import com.portfolio.gerenciador.portfolios.domain.form.MembrosForm;
import com.portfolio.gerenciador.portfolios.service.MembrosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membros")
@Slf4j
@RequiredArgsConstructor
public class MembrosController {

    private final MembrosService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Membros> create(@RequestBody MembrosForm membrosForm) {
        log.info("class=MembrosController method=create step=start");

        Membros membros = service.cadastro(membrosForm);

        log.info("class=MembrosController method=create step=end");

        return new ResponseEntity<>(membros, HttpStatus.CREATED);
    }
}
