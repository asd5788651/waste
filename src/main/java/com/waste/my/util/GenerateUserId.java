package com.waste.my.util;


/**
 * @Author 10447
 * @Date 2022/3/12 11:12
 * @Version 1.0
 */
public class GenerateUserId {
    public static String generate() {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boolean[] flags = new boolean[letters.length];
        char[] chs = new char[8];
        for (int i = 0; i < chs.length; i++) {
            int index;
            do {
                    index = (int) (Math.random() * (letters.length));
            }
// 判断生成的字符是否重复
            while (flags[index]);
            chs[i] = letters[index];
            flags[index] = true;
        }
        return String.valueOf(chs);
    }

}
