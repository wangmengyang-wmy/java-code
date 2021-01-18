package com.alibaba.characterstream;

import java.io.*;

public class FileWriterDemo {

    private static FileWriter fileWriter = null;

    static {
        try {
            // 默认是覆盖的形式，true：追加，false：覆盖
            // 创建一个FileWriter对象。该对象一被初始化就必须要明确被操作的文件。
            // 而且该文件会被创建到指定目录下。如果该目录下已有同名文件，将被覆盖。
            // 其实该步就是在明确数据要存放的目的地。
            File file = new File("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/demo.txt");
            fileWriter = new FileWriter("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/demo.txt",false);
//            fileWriter = new FileWriter(file,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // 调用write方法，将字符串写入到流中。
            fileWriter.write("\nabcde");
            //刷新流对象中的缓冲中的数据。
            //将数据刷到目的地中。
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                //关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据。
                //将数据刷到目的地中。
                //和flush区别：flush刷新后，流可以继续使用，close刷新后，会将流关闭。
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
