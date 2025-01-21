package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try (
                FileInputStream fis = new FileInputStream("temp/copy.dat");
                FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");
        ) {
            fis.transferTo(fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + "ms");
    }
}
