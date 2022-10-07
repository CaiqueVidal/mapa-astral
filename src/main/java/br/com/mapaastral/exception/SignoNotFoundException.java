package br.com.mapaastral.exception;

public class SignoNotFoundException extends RuntimeException{
    public SignoNotFoundException() {
        super("Signo não encontrado");
    }
}
