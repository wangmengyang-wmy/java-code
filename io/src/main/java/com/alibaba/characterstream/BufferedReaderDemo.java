package com.alibaba.characterstream;

import java.io.*;

/**
 * 字符读取流缓冲区：
 * 该缓冲区提供了一个一次读一行的方法 readLine，方便于对文本数据的获取。
 * 当返回null时，表示读到文件末尾。
 * readLine方法返回的时候只返回回车符之前的数据内容。并不返回回车符。
 */
public class BufferedReaderDemo {

    private static BufferedReader bufferedReader;

    private static BufferedWriter bufferedWriter;

    static {
        try {
            //创建一个读取流对象和文件相关联。
            //为了提高效率。加入缓冲技术。将字符读取流对象作为参数传递给缓冲对象的构造函数。
            bufferedReader = new BufferedReader(new FileReader("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/buf.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static {
        try {
            //创建一个读取流对象和文件相关联。
            //为了提高效率。加入缓冲技术。将字符读取流对象作为参数传递给缓冲对象的构造函数。
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/new-buf.txt",false));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readFile();
        copyFile();
    }


    private static void copyFile() {
        String line;
        try{
            while((line=bufferedReader.readLine())!=null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(bufferedReader!=null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }try {
                if(bufferedWriter!=null)
                    bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void readFile() {
        String line;
        try{
            while((line=bufferedReader.readLine())!=null) {
                System.out.print(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
