package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV3 {

    public static void main(String[] args) throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream(FILE_NAME);
                BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);
        ) {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < FILE_SIZE; i++) {
                bos.write(1);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("File size = " + FILE_SIZE / 1024 / 1024 + "(MB)");
            System.out.println("runningTime = " + (endTime - startTime) + "(ms)");
        }
    }
}
/* 실행결과
File size = 10(MB)
runningTime = 178(ms)
 */