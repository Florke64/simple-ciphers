package pl.florke.simpleciphers.ciphers;

public class CaesarCipher implements Cipher {
    private int shift;

    public CaesarCipher(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String plaintext) {
        // Implementation of Caesar encryption
        final char[] chars = plaintext.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + shift);
        }

        return new String(chars);
    }

    @Override
    public String decrypt(String ciphertext) {
        // Implementation of Caesar decryption
        final char[] chars = ciphertext.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - shift);
        }

        return new String(chars);
    }
}
