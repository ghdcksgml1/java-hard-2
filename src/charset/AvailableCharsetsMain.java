package charset;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.SortedMap;

public class AvailableCharsetsMain {

    public static void main(String[] args) {
        // 이용 가능한 모든 Charset 자바 + OS
        SortedMap<String, Charset> charsets = Charset.availableCharsets();
        for (String charsetName : charsets.keySet()) {
            System.out.println("charsetName = " + charsetName);
        }

        System.out.println("=====");
        Charset ms949 = Charset.forName("MS949");
        System.out.println("ms949 = " + ms949);

        // 별칭 조회
        Set<String> aliases = ms949.aliases();
        for (String alias : aliases) {
            System.out.println("alias = " + alias);
        }

        // UTF-8 문자로 조회
        Charset utf8 = StandardCharsets.UTF_8;
        System.out.println("utf8 = " + utf8);

        // 시스템의 기본 Charset 조회
        Charset defaultCharset = Charset.defaultCharset();
        System.out.println("defaultCharset = " + defaultCharset);
    }
}

/* 실행결과
charsetName = Big5
charsetName = Big5-HKSCS
charsetName = CESU-8
charsetName = EUC-JP
charsetName = EUC-KR
charsetName = GB18030
charsetName = GB2312
charsetName = GBK
charsetName = IBM-Thai
charsetName = IBM00858
charsetName = IBM01140
charsetName = IBM01141
charsetName = IBM01142
charsetName = IBM01143
charsetName = IBM01144
charsetName = IBM01145
charsetName = IBM01146
charsetName = IBM01147
charsetName = IBM01148
charsetName = IBM01149
charsetName = IBM037
charsetName = IBM1026
charsetName = IBM1047
charsetName = IBM273
charsetName = IBM277
charsetName = IBM278
charsetName = IBM280
charsetName = IBM284
charsetName = IBM285
charsetName = IBM290
charsetName = IBM297
charsetName = IBM420
charsetName = IBM424
charsetName = IBM437
charsetName = IBM500
charsetName = IBM775
charsetName = IBM850
charsetName = IBM852
charsetName = IBM855
charsetName = IBM857
charsetName = IBM860
charsetName = IBM861
charsetName = IBM862
charsetName = IBM863
charsetName = IBM864
charsetName = IBM865
charsetName = IBM866
charsetName = IBM868
charsetName = IBM869
charsetName = IBM870
charsetName = IBM871
charsetName = IBM918
charsetName = ISO-2022-CN
charsetName = ISO-2022-JP
charsetName = ISO-2022-JP-2
charsetName = ISO-2022-KR
charsetName = ISO-8859-1
charsetName = ISO-8859-13
charsetName = ISO-8859-15
charsetName = ISO-8859-16
charsetName = ISO-8859-2
charsetName = ISO-8859-3
charsetName = ISO-8859-4
charsetName = ISO-8859-5
charsetName = ISO-8859-6
charsetName = ISO-8859-7
charsetName = ISO-8859-8
charsetName = ISO-8859-9
charsetName = JIS_X0201
charsetName = JIS_X0212-1990
charsetName = KOI8-R
charsetName = KOI8-U
charsetName = Shift_JIS
charsetName = TIS-620
charsetName = US-ASCII
charsetName = UTF-16
charsetName = UTF-16BE
charsetName = UTF-16LE
charsetName = UTF-32
charsetName = UTF-32BE
charsetName = UTF-32LE
charsetName = UTF-8
charsetName = windows-1250
charsetName = windows-1251
charsetName = windows-1252
charsetName = windows-1253
charsetName = windows-1254
charsetName = windows-1255
charsetName = windows-1256
charsetName = windows-1257
charsetName = windows-1258
charsetName = windows-31j
charsetName = x-Big5-HKSCS-2001
charsetName = x-Big5-Solaris
charsetName = x-euc-jp-linux
charsetName = x-EUC-TW
charsetName = x-eucJP-Open
charsetName = x-IBM1006
charsetName = x-IBM1025
charsetName = x-IBM1046
charsetName = x-IBM1097
charsetName = x-IBM1098
charsetName = x-IBM1112
charsetName = x-IBM1122
charsetName = x-IBM1123
charsetName = x-IBM1124
charsetName = x-IBM1129
charsetName = x-IBM1166
charsetName = x-IBM1364
charsetName = x-IBM1381
charsetName = x-IBM1383
charsetName = x-IBM29626C
charsetName = x-IBM300
charsetName = x-IBM33722
charsetName = x-IBM737
charsetName = x-IBM833
charsetName = x-IBM834
charsetName = x-IBM856
charsetName = x-IBM874
charsetName = x-IBM875
charsetName = x-IBM921
charsetName = x-IBM922
charsetName = x-IBM930
charsetName = x-IBM933
charsetName = x-IBM935
charsetName = x-IBM937
charsetName = x-IBM939
charsetName = x-IBM942
charsetName = x-IBM942C
charsetName = x-IBM943
charsetName = x-IBM943C
charsetName = x-IBM948
charsetName = x-IBM949
charsetName = x-IBM949C
charsetName = x-IBM950
charsetName = x-IBM964
charsetName = x-IBM970
charsetName = x-ISCII91
charsetName = x-ISO-2022-CN-CNS
charsetName = x-ISO-2022-CN-GB
charsetName = x-iso-8859-11
charsetName = x-JIS0208
charsetName = x-JISAutoDetect
charsetName = x-Johab
charsetName = x-MacArabic
charsetName = x-MacCentralEurope
charsetName = x-MacCroatian
charsetName = x-MacCyrillic
charsetName = x-MacDingbat
charsetName = x-MacGreek
charsetName = x-MacHebrew
charsetName = x-MacIceland
charsetName = x-MacRoman
charsetName = x-MacRomania
charsetName = x-MacSymbol
charsetName = x-MacThai
charsetName = x-MacTurkish
charsetName = x-MacUkraine
charsetName = x-MS932_0213
charsetName = x-MS950-HKSCS
charsetName = x-MS950-HKSCS-XP
charsetName = x-mswin-936
charsetName = x-PCK
charsetName = x-SJIS_0213
charsetName = x-UTF-16LE-BOM
charsetName = X-UTF-32BE-BOM
charsetName = X-UTF-32LE-BOM
charsetName = x-windows-50220
charsetName = x-windows-50221
charsetName = x-windows-874
charsetName = x-windows-949
charsetName = x-windows-950
charsetName = x-windows-iso2022jp
*/