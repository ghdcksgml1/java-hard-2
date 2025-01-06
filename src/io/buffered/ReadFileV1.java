package io.buffered;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class ReadFileV1 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = fis.read()) != -1) {
            fileSize++;
        }
        fis.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File size = " + fileSize / 1024 / 1024 + "(MB)");
        System.out.println("runningTime = " + (endTime - startTime) + "(ms)");
    }
}
/* 실행결과
File size = 10(MB)
runningTime = 3891(ms)
 */