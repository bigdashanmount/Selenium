package com.mushishi.utils;

import java.io.*;
import java.util.Properties;

public class ProUtil {
    private  Properties prop;
    private  String filepath;
    //构造方法
    public ProUtil(String filepath){
        this.filepath = filepath;
        this.prop = readProperties();

    }
    private Properties readProperties(){
        Properties properties = new Properties();

        try {
            InputStream  inputstream =  new FileInputStream(filepath);
            BufferedInputStream in = new BufferedInputStream(inputstream);
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
           return properties;

    }

    public String getPro(String key) throws Exception{
        if (prop.containsKey(key)){
            String username = prop.getProperty(key);
            return username;
        }else {
            System.out.println("配置文件的key不正确，无法获取value!");
            return" ";
        }
    }
    /**
     * 写入内容
     * */
    public void writePro(String key,String value){
        Properties pro = new Properties();
        try {
            FileOutputStream file = new FileOutputStream(filepath);
            pro.setProperty(key, value);
            pro.store(file, key);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
