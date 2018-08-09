package com.mushishi.utils;

import org.openqa.selenium.By;

public class GetByLocator {
    public static  By GetLocator (String elementkey ) throws Exception{
        ProUtil properties = new ProUtil("element.properties");
        //username 包含定位方式是by.name  定位数值是
        String localtor = properties.getPro(elementkey);
        String localtorType = localtor.split(">")[0];
        String localtorValue = localtor.split(">")[1];
        //用localtorType替换by.其实就是进一步抽取/
        if(localtorType.equals("id")){
            return By.id(localtorValue);
        }else if(localtorType.equals("name")){
            return By.name(localtorValue);
        }else if(localtorType.equals("tagName")){
            return By.tagName(localtorValue);
        }else if(localtorType.equals("linkText")){
            return By.linkText(localtorValue);
        }else if(localtorType.equals("className")){
            return By.className(localtorValue);
        }else{
            return By.xpath(localtorValue);
        }

    }
}
