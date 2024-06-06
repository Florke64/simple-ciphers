package pl.florke.simpleciphers.io;

import pl.florke.simpleciphers.exceptions.FileException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {
    public static void write(String filePath, String content) throws FileException {
        try {
            Files.write(Paths.get(filePath), content.getBytes());
        } catch (IOException e) {
            throw new FileException("Error writing file: " + filePath, e);
        }
    }
}