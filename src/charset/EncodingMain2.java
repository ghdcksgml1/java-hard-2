package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.*;

public class EncodingMain2 {
    private static final Charset EUC_KR = Charset.forName("EUC-KR");
    private static final Charset MS949 = Charset.forName("MS949");

    public static void main(String[] args) {
        System.out.println("== 영문 ASCII 인코딩 ==");
        test("A", US_ASCII, US_ASCII);
        test("A", US_ASCII, ISO_8859_1);
        test("A", US_ASCII, EUC_KR);
        test("A", US_ASCII, MS949);
        test("A", US_ASCII, UTF_8);
        test("A", US_ASCII, UTF_16BE);

        System.out.println();
        System.out.println("== 한글 인코딩 - 기본 ==");
        test("가", US_ASCII, US_ASCII);
        test("가", ISO_8859_1, ISO_8859_1);
        test("가", EUC_KR, EUC_KR);
        test("가", MS949, MS949);
        test("가", UTF_8, UTF_8);
        test("가", UTF_16BE, UTF_16BE);

        System.out.println();
        System.out.println("== 한글 인코딩 - 복잡한 문자 ==");
        test("뷁", EUC_KR, EUC_KR);
        test("뷁", MS949, MS949);
        test("뷁", UTF_8, UTF_8);
        test("뷁", UTF_16BE, UTF_16BE);

        System.out.println();
        System.out.println("== 한글 인코딩 - 디코딩이 다른 경우 ==");
        test("가", EUC_KR, MS949);
        test("뷁", MS949, EUC_KR);
        test("가", EUC_KR, UTF_8);
        test("가", MS949, UTF_8);
        test("가", UTF_8, MS949);

        System.out.println();
        System.out.println("== 영문 인코딩 - 디코딩이 다른 경우");
        test("A", EUC_KR, UTF_8);
        test("A", MS949, UTF_8);
        test("A", UTF_8, MS949);
        test("A", UTF_8, UTF_16BE);
    }

    private static void test(String text, Charset encodingCharset, Charset decodingCharset) {
        byte[] bytes = text.getBytes(encodingCharset);
        String decodedString = new String(bytes, decodingCharset);
        System.out.printf("%s -> [%s] 인코딩 -> %s %sbyte -> [%s] 디코딩 -> %s\n", text, encodingCharset, Arrays.toString(bytes), bytes.length, decodingCharset, decodedString);
    }
}

/* 실행결과
== 영문 ASCII 인코딩 ==
A -> [US-ASCII] 인코딩 -> [65] 1byte -> [US-ASCII] 디코딩 -> A
A -> [US-ASCII] 인코딩 -> [65] 1byte -> [ISO-8859-1] 디코딩 -> A
A -> [US-ASCII] 인코딩 -> [65] 1byte -> [EUC-KR] 디코딩 -> A
A -> [US-ASCII] 인코딩 -> [65] 1byte -> [x-windows-949] 디코딩 -> A
A -> [US-ASCII] 인코딩 -> [65] 1byte -> [UTF-8] 디코딩 -> A
A -> [US-ASCII] 인코딩 -> [65] 1byte -> [UTF-16BE] 디코딩 -> �

== 한글 인코딩 - 기본 ==
가 -> [US-ASCII] 인코딩 -> [63] 1byte -> [US-ASCII] 디코딩 -> ?
가 -> [ISO-8859-1] 인코딩 -> [63] 1byte -> [ISO-8859-1] 디코딩 -> ?
가 -> [EUC-KR] 인코딩 -> [-80, -95] 2byte -> [EUC-KR] 디코딩 -> 가
가 -> [x-windows-949] 인코딩 -> [-80, -95] 2byte -> [x-windows-949] 디코딩 -> 가
가 -> [UTF-8] 인코딩 -> [-22, -80, -128] 3byte -> [UTF-8] 디코딩 -> 가
가 -> [UTF-16BE] 인코딩 -> [-84, 0] 2byte -> [UTF-16BE] 디코딩 -> 가

== 한글 인코딩 - 복잡한 문자 ==
뷁 -> [EUC-KR] 인코딩 -> [63] 1byte -> [EUC-KR] 디코딩 -> ?
뷁 -> [x-windows-949] 인코딩 -> [-108, -18] 2byte -> [x-windows-949] 디코딩 -> 뷁
뷁 -> [UTF-8] 인코딩 -> [-21, -73, -127] 3byte -> [UTF-8] 디코딩 -> 뷁
뷁 -> [UTF-16BE] 인코딩 -> [-67, -63] 2byte -> [UTF-16BE] 디코딩 -> 뷁

== 한글 인코딩 - 디코딩이 다른 경우 ==
가 -> [EUC-KR] 인코딩 -> [-80, -95] 2byte -> [x-windows-949] 디코딩 -> 가
뷁 -> [x-windows-949] 인코딩 -> [-108, -18] 2byte -> [EUC-KR] 디코딩 -> ��
가 -> [EUC-KR] 인코딩 -> [-80, -95] 2byte -> [UTF-8] 디코딩 -> ��
가 -> [x-windows-949] 인코딩 -> [-80, -95] 2byte -> [UTF-8] 디코딩 -> ��
가 -> [UTF-8] 인코딩 -> [-22, -80, -128] 3byte -> [x-windows-949] 디코딩 -> 媛�

== 영문 인코딩 - 디코딩이 다른 경우
A -> [EUC-KR] 인코딩 -> [65] 1byte -> [UTF-8] 디코딩 -> A
A -> [x-windows-949] 인코딩 -> [65] 1byte -> [UTF-8] 디코딩 -> A
A -> [UTF-8] 인코딩 -> [65] 1byte -> [x-windows-949] 디코딩 -> A
A -> [UTF-8] 인코딩 -> [65] 1byte -> [UTF-16BE] 디코딩 -> �
 */