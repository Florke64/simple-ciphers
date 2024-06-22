package pl.florke.simpleciphers;

import pl.florke.simpleciphers.ciphers.*;
import pl.florke.simpleciphers.io.*;
import pl.florke.simpleciphers.exceptions.*;
import pl.florke.simpleciphers.ui.CharacterUserInterface;

public class Main {
    public static void main(String[] args) {
        final CharacterUserInterface ui = new CharacterUserInterface();

        if(args.length == 0) {
            args = ui.mainMenu();
        }

        if (args.length < 4) {
            CharacterUserInterface.printUsageHelp();
            return;
        }

        String cipherType = args[0];
        String mode = args[1];
        String inputFile = args[2];
        String outputFile = args[3];

        String keyOrShift = null;
        try {
            keyOrShift = args.length == 5 ? FileReader.read(args[4]) : null;
        } catch (FileException e) {
            throw new RuntimeException(e);
        }

        try {
            Cipher cipher = createCipher(cipherType, keyOrShift);
            String input = FileReader.read(inputFile);
            String output;

            if ("encrypt".equalsIgnoreCase(mode)) {
                output = cipher.encrypt(input);
            } else if ("decrypt".equalsIgnoreCase(mode)) {
                output = cipher.decrypt(input);
            } else {
                throw new IllegalArgumentException("Niewspierany tryb. Użyj encrypt lub decrypt");
            }

            FileWriter.write(outputFile, output);
            System.out.println("Operacja zakonczona pomyslnie");

        } catch (FileException | CipherException | IllegalArgumentException e) {
            System.err.println("Blad: " + e.getMessage());
        }

        ui.readString("Nacisnij ENTER aby zakonczyc", null);
    }

    private static Cipher createCipher(String cipherType, String keyOrShift) throws CipherException {
        switch (cipherType.toLowerCase()) {
            case "caesar":
                if (keyOrShift == null || !keyOrShift.matches("\\d+")) {
                    throw new IllegalArgumentException("Szyfr Cezara wymaga przesuniecia liczbowego");
                }
                return new CaesarCipher(Integer.parseInt(keyOrShift.strip()));
            case "vigenere":
                if (keyOrShift == null) {
                    throw new IllegalArgumentException("Szfr Vigenere wymaga klucza");
                }
                return new VigenereCipher(keyOrShift);
            default:
                throw new CipherException("Niewspierany typ szyfrowania: " + cipherType + ". Uzyj caesar lub vigenere");
        }
    }
}
