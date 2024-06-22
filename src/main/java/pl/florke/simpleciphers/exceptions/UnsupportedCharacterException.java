package pl.florke.simpleciphers.exceptions;

public class UnsupportedCharacterException extends CipherException {
    public UnsupportedCharacterException(String message) {
        super(message);
    }

    public UnsupportedCharacterException(String message, Throwable cause) {
        super(message, cause);
    }
}
