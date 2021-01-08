package com.alibaba;

/**
 * Java基础数据类型演示
 */
public class BaseDataType {

    public static void main(String[] args) {
        /**
         * 在Java中char类型是2个字节、16位存储的：00000000 0000000 ~ 11111111 11111111
         * 在Java中int类型是4个字节、32位存储的，因为在Java中int类型是有符号的，即有正数和负数之分，为了区别正数和负数，
         * 就有了一个规定：最高位不用来存储数值（0代表正数，1代表负数），只用来表示数值类型，所以虽然规定了int类型是4个字节、32位的，但是仅仅只有31位存储有效数值
         * ：即取值范围是 10000000 00000000 00000000 00000000 ~  01111111 11111111 11111111 11111111 (一共31位，算上开头的0才一共是32位)
         * 01111111 11111111 11111111 11111111转换成10进制的运算方式是：2^30+2^29+2^28+2^27+。。。。+2^2+2^1+2^0
         * 01111111 11111111 11111111 11111111+00000000 00000000 00000000 00000001[1*2^0]
         * => (2^30+2^29+2^28+2^27+。。。。+2^2+2^1+2^0)+1
         * => 10000000 00000000 00000000 00000000
         * => 2^31
         * 所以: 01111111 11111111 11111111 11111111 == 2^31-1(即整型最大值：2147483647)
         */
        char c=65535;//1111 1111 1111 1111
        String binStr = Integer.toBinaryString(c);
        System.out.println("1、---------"+binStr);
        int i=2147483647; //0111 1111 1111 1111 1111 1111 1111 1111,最高位为0代表正数
        int j=-2147483648;//1000 0000 0000 0000 0000 0000 0000 0000,最高位为1代表负数
        int k=0;
        String binStr2 = Integer.toBinaryString(i);
        System.out.println("2、---------"+binStr2);
        String binStr3 = Integer.toBinaryString(j);
        System.out.println("3、---------"+binStr3);
        String binStr4 = Integer.toBinaryString(k);
        System.out.println("4、---------"+binStr4);

        i=1; //0000 0000 0000 0000 0000 0000 0000 0001
        j=-1;//1111 1111 1111 1111 1111 1111 1111 1111
        binStr2=Integer.toBinaryString(i);
        binStr3=Integer.toBinaryString(j);

        System.out.println("5、---------"+binStr2);
        System.out.println("6、---------"+binStr3);
    }
}
