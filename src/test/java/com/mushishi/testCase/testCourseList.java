package com.mushishi.testCase;

import com.mushishi.base_serve_driver.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class testCourseList extends CaseBase{
    public DriverBase driver;
    public testCourseList(){
        this.driver= InitDriver("chrome");
    }
    @Test
    public void  CounrseList() throws Exception {
        driver.get("https://coding.imooc.com/");
        driver.manage();
        Thread.sleep(2000);
        driver.js(3);

        List<String> listString = this.listElement();

        for(int i=0;i<listString.size();i++){
          //元素如果不显示在浏览器上就无法点击
           driver.findElement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
           System.out.println(i);
           driver.back();
         }

    }

    /**
     * 获取所有课程的list，将课程信息文字描述封装到集合当中
     * */
    public List<String> listElement(){
        List<String> listString = new ArrayList<String>();
        WebElement element = driver.findElement(By.className("shizhan-course-list"));
        List<WebElement> listElement = element.findElements(By.className("shizhan-course-box"));
        for(WebElement el:listElement){
           // el.findElement(By.className("shizan-desc")).getText();
            listString.add(el.findElement(By.className("shizan-desc")).getText());
    }
        return listString;
    }

}
