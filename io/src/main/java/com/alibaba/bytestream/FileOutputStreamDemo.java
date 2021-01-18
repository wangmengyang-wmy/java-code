package com.alibaba.bytestream;

import java.io.*;

public class FileOutputStreamDemo {

    private static PrintStream printStream;

    static {
        try {
            // 覆盖
            printStream = new PrintStream(new FileOutputStream("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/file.txt",false));
            // 追加
//            printStream = new PrintStream(new FileOutputStream("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/file.txt",true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // 向“文件中”写入"0123456789"+换行符
        printStream.println("0123456789");
        if (printStream != null) {
            printStream.close();
        }
    }
}
