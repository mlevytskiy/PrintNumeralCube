package com.printnumeralcube;

import android.text.TextUtils;
import android.util.Log;

/**
 * Created by max on 16.06.16.
 */
public class PrintCubeUtils {

    private static final String TAG = PrintCubeUtils.class.getSimpleName();

    public static void printCube(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Incorrect n = " + n);
        }
        println("Ввод: " + n);
        println("Вывод:");
        StringBuilder strBuilder = new StringBuilder();
        Integer[] biggestLine = getBiggestLine(n);
        for (int i = 1; i < n; i++) {
            println( getLine(biggestLine, i, n, strBuilder) );
        }
        println( TextUtils.join("", biggestLine) );
        for (int i = n-1; i > 0; i--) {
            println( getLine(biggestLine, i, n, strBuilder) );
        }
    }

    private static String getLine(Integer[] biggestLine, int lineNumber, int maxValueInCube, StringBuilder strBuilder) {
        strBuilder.setLength(0); //prepare strBuilder for reuse
        for (int i = 0; i < biggestLine.length; i++) {
            int value = biggestLine[i] - (maxValueInCube - lineNumber);
            strBuilder.append( value > 0 ? value : " " );
        }
        return strBuilder.toString();
    }

    private static Integer[] getBiggestLine(int n) {
        Integer[] result = new Integer[2*n - 1];
        for (int i = 0; i < n; i++) {
            result[i] = result[2*n - 2 - i] = i+1;
        }
        return result;
    }

    private static void println(String str) {
        Log.println(Log.INFO, TAG, str);
    }

}
