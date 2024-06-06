package pl.florke.simpleciphers.ui;

import pl.florke.simpleciphers.crackers.Cracker;
import pl.florke.simpleciphers.exceptions.FileException;
import pl.florke.simpleciphers.io.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterUserInterface {

    public CharacterUserInterface() {
        System.out.println("Author: Daniel Chojnacki");
        System.out.println("122554@student.san.edu.pl");
        System.out.println();
    }

    public String[] mainMenu() {
        printMenuOptions();

        String cipherType = "caesar";
        String mode = "encrypt";

        String selection;
        do {
            selection = readString("Wybierz opcje", null);

            if ("1".equals(selection) || "2".equals(selection)) {
                cipherType = "caesar";
                mode = selection.equals("1") ? "encrypt" : "decrypt";
            }
            else if ("3".equals(selection) || "4".equals(selection)) {
                cipherType = "vigenere";
                mode = selection.equals("3") ? "encrypt" : "decrypt";
            }
            else if ("5".equals(selection)) {
                final Cracker cracker;
            }
            else if ("0".equals(selection)) {
                return new String[]{};
            }

        } while (selection == null || !selection.matches("[0-6]"));

        printTextFilesList(System.getProperty("user.dir"));
        String inputFile = readString("Podaj nazwe pliku wejsciowego", "input.txt");
        String outputFile = readString("Podaj nazwe pliku wyjsciowego", "output.txt");
        String keyOrShift = readString("Podaj " + (cipherType.equals("caesar") ? "przesuniecie" : "klucz"), null);

        return new String[] {cipherType, mode, inputFile, outputFile, keyOrShift};
    }

    public String readString(final String prompt, final String def) {
        System.out.print(prompt);
        if (def != null) System.out.print(" [" + def + "]");
        System.out.print(": ");

        final Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            final String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            }
        }

        return def;
    }

    private void printMenuOptions() {
        System.out.println("Szyfrowanie Cezar & Vigenere");
        System.out.println(" --- --- --- --- --- --- ---");
        System.out.println("1. Szyfr Cezara");
        System.out.println("2. Deszyfracja Szyfru Cezara");
        System.out.println("3. Szyfr Vigenere");
        System.out.println("4. Deszyfracja Szyfru Vigenere");
        System.out.println("5. Łamanie szyfru Vigenere");
//        System.out.println("6. Łamanie szyfru Cezara");

        System.out.println("0. Wyjdz");
        System.out.println();
    }

    public static void printUsageHelp() {
        System.out.println("Uzyj: java -jar SimpleCiphers.jar <cipher> <mode> <inputFile> <outputFile> [key/shift]");
        System.out.println("Brak argumentow uruchomi program w trybie interaktywnym.");
        System.out.println();
        System.out.println("Przyklad: java -jar SimpleCiphers.jar caesar encrypt input.txt output.txt 3");
        System.out.println("Przyklad: java -jar SimpleCiphers.jar vigenere decrypt input.txt output.txt key");
        System.out.println();
        System.out.println("Dostepne szyfry: caesar vigenere | Available modes: encrypt, decrypt");

        printTextFilesList(System.getProperty("user.dir"));
    }

    private static void printTextFilesList(final String workDir) {
        final List<String> files;

        // Read working directory content
        try {
            files = new ArrayList<>(FileReader.directoryContentsList(workDir));
        } catch (FileException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Pliki *.txt w tym folderze [" + workDir + "]: ");
        for (String file : files) {
            if (file.endsWith(".txt")) {
                System.out.print(file + " ");
            }
        }

        if (files.isEmpty()) {
            System.out.print("(brak)");
        }

        System.out.println();
    }

}
