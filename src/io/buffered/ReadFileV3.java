package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV3 {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream(FILE_NAME);
                BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
        ) {
            long startTime = System.currentTimeMillis();

            int fileSize = 0;
            int data;
            while ((data = bis.read()) != -1) {
                fileSize++;
            }

            long endTime = System.currentTimeMillis();
            System.out.println("File size = " + fileSize / 1024 / 1024 + "(MB)");
            System.out.println("runningTime = " + (endTime - startTime) + "(ms)");
        }
    }
}
/* 실행결과
File size = 10(MB)
runningTime = 167(ms)
 */