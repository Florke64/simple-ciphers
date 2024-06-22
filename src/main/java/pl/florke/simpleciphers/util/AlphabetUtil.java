package pl.florke.simpleciphers.util;

import pl.florke.simpleciphers.exceptions.UnsupportedCharacterException;

public class AlphabetUtil {

    private static final String ALPHABETH = "abcdefghijklmnopqrstuvwxyz";
    private static final String SPECIALS = "1234567890!@#$%^&*()-={}[]:\";',.></~`?ąęćłóżź";

    public static String getSupportedAlphabet() {
        return ALPHABETH.toLowerCase() + ALPHABETH.toUpperCase(); // + SPECIALS;
    }

    public static char getCharacterByIndex(final int index) {
        final boolean negativeIndex = index < 0;

        int charIndex = index;
        if (negativeIndex) {
            charIndex = getSupportedAlphabet().length() + index;
        }
        return getSupportedAlphabet().charAt(charIndex);
    }

    public static int getIndexByCharacter(final char character) throws UnsupportedCharacterException {
        final int characterIndex = getSupportedAlphabet().indexOf(character);
        if (characterIndex == -1) {
            throw new UnsupportedCharacterException("Character not supported: " + character);
        }

        return characterIndex;
    }

    public static char getCharacterShiftedByIndex(final char character, final int shift) {
        final int characterIndex;
        try {
            characterIndex = getIndexByCharacter(character);
        } catch (UnsupportedCharacterException e) {
            return character;
        }

        final int shiftedCharacterIndex = (characterIndex + shift) % getSupportedAlphabet().length();
        return getCharacterByIndex(shiftedCharacterIndex);
    }

}
