package io.file.copy;

import java.io.FileOutputStream;

public class CreateCopyFile {
    private static final int FILE_SIZE = 200 * 1024 * 1024; // 200MB

    public static void main(String[] args) {
        String fileName = "temp/copy.dat";
        long startTime = System.currentTimeMillis();

        try (FileOutputStream fos = new FileOutputStream(fileName);) {
            byte[] buffer = new byte[FILE_SIZE];
            fos.write(buffer);
        } catch (Exception e) {

        }

        long endTime = System.currentTimeMillis();
        System.out.println("File created: " + fileName);
        System.out.println("File size: " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
