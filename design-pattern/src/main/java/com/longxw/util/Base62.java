package com.longxw.util;

import java.io.ByteArrayOutputStream;

public class Base62 {

    private static final char[] encodes = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };

    private static byte[] decodes = new byte[256];

    static {
        for (int i = 0; i < encodes.length; i++) {
            decodes[encodes[i]] = (byte) i;
        }
    }

    /**
     * 将data编码成Base62的字符串
     * @param data
     * @return
     */
    public static String encodeBase62(byte[] data) {
        return "";
    }

    /**
     * 将字符串解码成byte数组
     * @param string
     * @return
     */
    public static byte[] decodeBase62(String string) {
        if(string==null){
            return null;
        }
        char[] data=string.toCharArray();
        ByteArrayOutputStream baos = new ByteArrayOutputStream(string.toCharArray().length);
        int pos = 0, val = 0;
        for (int i = 0; i < data.length; i++) {
            char c = data[i];
            if (c == 'i') {
                c = data[++i];
                c =
                        c == 'a' ? 'i' :
                                c == 'b' ? '+' :
                                        c == 'c' ? '/' : data[--i];
            }
            val = (val << 6) | decodes[c];
            pos += 6;
            while (pos > 7) {
                baos.write(val >> (pos -= 8));
                val &= ((1 << pos) - 1);
            }
        }
        return baos.toByteArray();
    }

    public static String encode(long val){
        return "";
    }
}
