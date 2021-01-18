package com.alibaba.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

    private static FileInputStream fis;

    static {
        try {
            fis = new FileInputStream("/Users/wangmengyang/wmy-repositories/java-code/io/src/main/resources/buf.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        readFile_1();
//        readFile_2();
        readFile_3();
    }


    private static void readFile_1() {
        try {
            //available()返回从此输入流中可以读取（或跳过）的剩余字节数的估计值，而不会被下一次调用此输入流的方法阻塞。
            byte[] buf = new byte[fis.available()];//定义一个刚刚好的缓冲区。不用在循环了。
            int len = fis.read(buf);

            System.out.println(new String(buf,0,len));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFile_2() {
        try {
            byte[] buf = new byte[1024];
            int len;
            while ((len=fis.read(buf))!=-1){
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFile_3() {
        try {
            int len;
            while((len=fis.read())!=-1)
            {
                System.out.println((char)len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
