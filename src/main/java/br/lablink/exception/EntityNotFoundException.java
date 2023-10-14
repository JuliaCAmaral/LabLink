package br.lablink.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class EntityNotFoundException extends WebApplicationException {

    public EntityNotFoundException(String tipo, String identificador) {
        super(String.format("%s: Registro não encontrado com identificador: %s", tipo, identificador), Response.Status.NOT_FOUND);
    }
}
