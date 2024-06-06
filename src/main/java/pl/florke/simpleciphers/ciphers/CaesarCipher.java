package pl.florke.simpleciphers.ciphers;

public class CaesarCipher implements Cipher {
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plaintext) {
        // Implementation of Caesar encryption
        return "";
    }

    @Override
    public String decrypt(String ciphertext) {
        // Implementation of Caesar decryption
        return "";
    }
}
