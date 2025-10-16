package org.example;

import java.util.Objects;

public class Excepcion {
    public int validarTexto(String texto){
        Objects.requireNonNull(texto, "El texto no puede ser nulo");
        return texto.length();
    }
}
