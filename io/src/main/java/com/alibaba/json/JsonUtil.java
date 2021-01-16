package com.alibaba.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonUtil {

    /**
     * 将json对象写入到文件中
     * @param jsonFilePath json文件路径
     * @param jsonObject 待写入的json数据，这个json对象可以是单独的json对象({"FLAG": 1,"NAME": "example"})，
     *                   也可以是包含有JSONArray的json对象({ "FLAG": 1, "NAME": "example", "ARRAYS":[{ "Name":"array1",
     *                   "String":"哈哈哒1" },{ "Name":"array2", "String":"哈哈哒2" },{"Name":"array3","String":"哈哈哒3"}
     *                   ,{ "Name":"array4","String":"哈哈哒4" }]})
     * @throws Exception 异常信息
     */
    public static void writeJson(String jsonFilePath, JSONObject jsonObject) throws Exception {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(jsonFilePath), StandardCharsets.UTF_8);
        osw.write(jsonObject.toString());
        osw.flush();//清空缓冲区，强制输出数据
        osw.close();//关闭输出流
    }

    /**
     * 在构造含有JSONArray的json对象时，需要先构造一个JSONArray对象，然后将这个JSONArray对象put进json对象中
     * @param jsonFilePath json文件路径
     * @throws Exception 异常信息
     */
    public static void writeJsonArray(String jsonFilePath) throws Exception {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(jsonFilePath), StandardCharsets.UTF_8);

        JSONObject obj=new JSONObject();//创建JSONObject对象
        obj.put("FLAG","1");
        JSONArray jsonArray = new JSONArray();//创建JSONArray对象
        for(int i = 1; i<4; i++) {
            JSONObject subObj=new JSONObject();//创建对象数组里的子对象
            subObj.put("Name","array"+i);
            subObj.put("String","小白"+i);
            jsonArray.add(subObj);
        }
        obj.put("ARRAYS",jsonArray);
        System.out.println(obj.toString());
        osw.write(obj.toString());
        osw.flush();//清空缓冲区，强制输出数据
        osw.close();//关闭输出流
    }

    /**
     * 在开发中如果使用json文件作为标识：例如你要使用spark每天定时读一个hive表，但存在hive表为空的情况，
     * 这个时候就可以先去count一下数量然后将这个数量写入到本地json文件中，然后由脚本去读取这个json文件，
     * 判断当天的数量是否为零，再做是否跑spark的操作，因为这个任务是每天只跑一次的，所以在写入某一天的数
     * 量的时候需要检查一下今天是否已经写入
     * @param jsonFilePath json文件路径
     * @param time 当天时间
     * @return 返回当天是否已经写过的布尔值
     */
    public static Boolean checkJson(String jsonFilePath,String time){
        String jsonStr = readJson(jsonFilePath);
        if (null!=jsonStr&&!jsonStr.isEmpty()){
            JSONObject jsonObject= JSON.parseObject(jsonStr);
            return jsonObject.containsKey(time);
        }else {
            return false;
        }
    }

    /**
     * 读取json文件
     * @param jsonFilePath json文件路径
     * @return json字符串
     */
    public static String readJson(String jsonFilePath){
        String jsonStr = "";
        try {
            File jsonFile = new File(jsonFilePath);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8);
            int ch;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
