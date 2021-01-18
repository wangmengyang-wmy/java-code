package com.alibaba.characterstream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterDemo {

    private static BufferedWriter bufferedWriter;

    static {
        try {
            //创建一个读取流对象和文件相关联。
            //为了提高效率。加入缓冲技术。将字符读取流对象作为参数传递给缓冲对象的构造函数。
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/buf.txt",false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            char[] c={'a','b','c','d','e'};
            bufferedWriter.write(c,0,4);

            //换行
            bufferedWriter.newLine();

            //再次写入
            bufferedWriter.write(c,2,2);

            //刷新流
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    //其实关闭缓冲区，就是在关闭缓冲区中的流对象。
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
