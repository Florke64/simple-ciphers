package pl.florke.simpleciphers;

import pl.florke.simpleciphers.ciphers.*;
import pl.florke.simpleciphers.io.*;
import pl.florke.simpleciphers.exceptions.*;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 4) {
            showHelp();
            return;
        }

        String cipherType = args[0];
        String mode = args[1];
        String inputFile = args[2];
        String outputFile = args[3];
        String keyOrShift = args.length == 5 ? args[4] : null;

        try {
            Cipher cipher = createCipher(cipherType, keyOrShift);
            String input = FileReader.read(inputFile);
            String output;

            if ("encrypt".equalsIgnoreCase(mode)) {
                output = cipher.encrypt(input);
            } else if ("decrypt".equalsIgnoreCase(mode)) {
                output = cipher.decrypt(input);
            } else {
                throw new IllegalArgumentException("Invalid mode. Use 'encrypt' or 'decrypt'.");
            }

            FileWriter.write(outputFile, output);
            System.out.println("Operation completed successfully.");

        } catch (FileException | CipherException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static Cipher createCipher(String cipherType, String keyOrShift) throws CipherException {
        switch (cipherType.toLowerCase()) {
            case "caesar":
                if (keyOrShift == null || !keyOrShift.matches("\\d+")) {
                    throw new IllegalArgumentException("Caesar cipher requires a numerical shift.");
                }
                return new CaesarCipher(Integer.parseInt(keyOrShift));
            case "vigenere":
                if (keyOrShift == null) {
                    throw new IllegalArgumentException("Vigenere cipher requires a key.");
                }
                return new VigenereCipher(keyOrShift);
            default:
                throw new CipherException("Unsupported cipher type: " + cipherType);
        }
    }

    private static void showHelp() {
        System.out.println("Usage: java -jar SimpleCiphers.jar <cipher> <mode> <inputFile> <outputFile> [key/shift]");
        System.out.println("Example: java -jar SimpleCiphers.jar caesar encrypt input.txt output.txt 3");
        System.out.println("Example: java -jar SimpleCiphers.jar vigenere decrypt input.txt output.txt key");
        System.out.println("Available ciphers: cesar, vigenere | Available modes: encrypt, decrypt");

        final List<String> files = new ArrayList<>();

        // Read working directory content
        try {
            final String workDir = System.getProperty("user.dir");
            files.addAll(FileReader.directoryContentsList(workDir));
        } catch (FileException e) {
            throw new RuntimeException(e);
        }

        final String workDir = System.getProperty("user.dir");
        System.out.print("Text files in workdir(" + workDir + "): ");
        for (String file : files) {
            if (file.endsWith(".txt")) {
                System.out.print(file + " ");
            }
        }

        if (files.isEmpty()) {
            System.out.print("(empty)");
        }

        System.out.println();
    }
}
