package org.example;

public class NombreFicheroIncorrectoException
        extends Exception{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param mensaje the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public NombreFicheroIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
