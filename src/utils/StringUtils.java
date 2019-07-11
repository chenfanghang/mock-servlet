package utils;

import java.util.Arrays;

/**
 * Created by barryfan on 6/17/19.
 */
public class StringUtils {

    public static boolean isNull(String data) {
        return data == null || "".equals(data);
    }

    public static boolean areNull(String... data) {
        return Arrays.stream(data).anyMatch(StringUtils::isNull);
    }

}
