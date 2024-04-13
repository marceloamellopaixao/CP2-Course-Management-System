package br.com.fiap.main.exception;

public class AssociatedEntitiesNotPersistedException extends RuntimeException {
    public AssociatedEntitiesNotPersistedException(String message) {
        super(message);
    }
}

