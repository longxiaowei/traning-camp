package com.longxw.graphql.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public class IOUtils {

    public static String readToString(InputStream is, Charset charset) throws IOException {
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        return new String(bytes, charset);
    }

    public static String readToString(InputStream is) throws IOException {
        return readToString(is, Charset.forName("UTF-8"));
    }
}
