package com.wcf20221124;

import java.util.Random;

public class codeUtil {
    private codeUtil() {
    }

    public static String getcode() {
        char[] arr = new char[52];//a-z  97-122  65-90 48-57
        for (int i = 0; i < arr.length; i++) {
            if (i < 26)
                arr[i] = (char) (97 + i);
            else arr[i] = (char) (65 + i - 26);
        }
        Random r = new Random();
        char[] code = new char[3];
        for (int i = 0; i < 3; i++) {
            int index = r.nextInt(52);
            code[i] = arr[index];
        }
        int a = r.nextInt(10);
        String s = new String(code);
        s += a;
        char[] c = s.toCharArray();
        int index = r.nextInt(3);
        char temp = c[index];
        c[index] = c[c.length - 1];
        c[c.length - 1] = temp;
        return new String(c);
    }
}

