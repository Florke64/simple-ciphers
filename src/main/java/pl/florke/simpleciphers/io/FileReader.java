package pl.florke.simpleciphers.io;

import pl.florke.simpleciphers.exceptions.FileException;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileReader {
    public static String read(String filePath) throws FileException {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new FileException("Error reading file: " + filePath, e);
        }
    }

    public static Collection<String> directoryContentsList(String filePath) throws FileException {
        List<String> fileNames = new ArrayList<>();
        Path directoryPath = Paths.get(filePath);

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directoryPath)) {
            for (Path path : directoryStream) {
                fileNames.add(path.getFileName().toString());
            }
        } catch (IOException e) {
            throw new FileException("Error reading file: " + filePath, e);
        }

        return fileNames;
    }
}