package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path directory = Path.of("temp/exampleDir");

        System.out.println("File exists: " + Files.exists(file));

        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + " File already exists.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException e) {
            System.out.println(file + " Directory already exists.");
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Files.delete(file);

        System.out.println("Is regular file: " + Files.isRegularFile(file));
        System.out.println("Is directory: " + Files.isDirectory(file));
        System.out.println("File name: " + file.getFileName());
        System.out.println("File size: " + Files.size(file));

        Path newFile = Path.of("temp/newExample.txt");
        Files.move(file, newFile, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File moved/renamed");

        System.out.println("Last modified: " + Files.getLastModifiedTime(newFile));

        BasicFileAttributes basicFileAttributes = Files.readAttributes(newFile, BasicFileAttributes.class);
        System.out.println("=== ATTRIBUTES ===");
        System.out.println("basicFileAttributes = " + basicFileAttributes.creationTime());
        System.out.println("basicFileAttributes = " + basicFileAttributes.isDirectory());
        System.out.println("basicFileAttributes = " + basicFileAttributes.isRegularFile());
        System.out.println("basicFileAttributes = " + basicFileAttributes.isSymbolicLink());
    }
}