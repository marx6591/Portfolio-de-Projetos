package com.portfolio.gerenciador.portfolios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionUnauthorized extends BusinessException {

    private static final long serialVersionUID = 1918184724741319997L;

    public static final String UNAUTHORIZED = "Operação não permitida: {0}";

    public ExceptionUnauthorized(String msg) {

        String description = MessageFormat.format(UNAUTHORIZED, msg);

        super.setMessage(description);
        super.setDescription(description);
        super.setHttpStatusCode(HttpStatus.UNAUTHORIZED);
        super.setCode(String.valueOf(HttpStatus.UNAUTHORIZED.value()));
    }
}
