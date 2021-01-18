package com.alibaba.characterstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

    private static FileReader fileReader = null;

    static {
        try {
            //创建一个文件读取流对象，和指定名称的文件相关联。要保证该文件是已经存在的，如果不存在，会发生异常FileNotFoundException
            fileReader = new FileReader("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/demo.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        method1();
        method2();
    }

    private static void method1() {
        try {
            int ch;
            //调用读取流对象的read方法。
            //read():一次读一个字符。而且会自动往下读。
            while((ch=fileReader.read())!=-1) {
                System.out.println("ch="+(char)ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                //关闭流
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void method2() {
        try {
            //定义一个字符数组。用于存储读到字符。
            //该read(char[])返回的是读到字符个数。
            char[] buf = new char[1024];
            int ch;
            //调用读取流对象的read方法。
            //read():一次读一个字符。而且会自动往下读。
            while((ch=fileReader.read(buf))!=-1) {
                System.out.println(new String(buf,0,ch));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                //关闭流
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
