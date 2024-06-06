package pl.florke.simpleciphers.ciphers;

public class VigenereCipher implements Cipher {
    private char[] key;

    public VigenereCipher(String key) {
        this.key = key.toCharArray();
    }

    @Override
    public String encrypt(String plaintext) {
        // Implementation of Vigenere encryption
        final char[] chars = plaintext.toCharArray();

        int loopIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key[loopIndex]);
            loopIndex++;
            if (loopIndex >= key.length) {
                loopIndex = 0;
            }
        }

        return new String(chars);
    }

    @Override
    public String decrypt(String ciphertext) {
        // Implementation of Vigenere decryption
        final char[] chars = ciphertext.toCharArray();

        int loopIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - key[loopIndex]);
            loopIndex++;
            if (loopIndex >= key.length) {
                loopIndex = 0;
            }
        }

        return new String(chars);
    }
}
