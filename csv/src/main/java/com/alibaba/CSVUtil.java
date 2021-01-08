package com.alibaba;

import org.jumpmind.symmetric.csv.CsvReader;
import org.jumpmind.symmetric.csv.CsvWriter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {
    public static void main(String[] args) {

        List<String[]> read = readCSV("/Users/wangmengyang/wmy-repositories/java-code/csv/src/csv/trd_date.csv");
        assert read != null;
        for (String []item:read) {
            for (String s : item) {
                System.out.println(s);
            }
        }
        writeCSV("/Users/wangmengyang/wmy-repositories/java-code/csv/src/csv/target.csv",read);

    }
    public static List<String[]> readCSV(String file_path){
        File file = new File(file_path);
        if (file.exists() && file.isFile()) {
            List<String[]> csvList= new ArrayList<>();
            InputStream in = null;
            try {
                in = new FileInputStream(file);
                CsvReader reader = new CsvReader(in,',', StandardCharsets.UTF_8);
//                reader.readHeaders(); // 跳过表头,不跳可以注释掉
                while(reader.readRecord()){
                    csvList.add(reader.getValues()); //按行读取，每行会返回一个String数组对象，并把每一行的数据添加到list集合
                }
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != in) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return csvList;
        }
        return null;
    }

    public static void writeCSV(String file_path, List<String[]> source){
        File file = new File(file_path);
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            CsvWriter csvWriter = new CsvWriter(outputStream, ',', StandardCharsets.UTF_8);
            for (String []item:source) {
                csvWriter.writeRecord(item);
            }
            csvWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
