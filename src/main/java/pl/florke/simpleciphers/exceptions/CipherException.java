package pl.florke.simpleciphers.exceptions;

public class CipherException extends Exception {
    public CipherException(String message) {
        super(message);
    }

    public CipherException(String message, Throwable cause) {
        super(message, cause);
    }
}