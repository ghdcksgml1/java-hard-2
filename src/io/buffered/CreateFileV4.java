package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class CreateFileV4 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[FILE_SIZE];
        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[i] = 1;
        }
        fos.write(buffer);
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("File size = " + FILE_SIZE / 1024 / 1024 + "(MB)");
        System.out.println("runningTime = " + (endTime - startTime) + "(ms)");
    }
}
/* 실행결과
File size = 10(MB)
runningTime = 11(ms)
 */