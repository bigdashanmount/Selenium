package com.mushishi.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
            System.out.println("获取可以值不对");
            return" ";
        }
    }

}
