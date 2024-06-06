package pl.florke.simpleciphers.ciphers;

public interface Cipher {

    String encrypt(String plaintext);

    String decrypt(String ciphertext);
}
