package com.mushishi.selenium;

import com.mushishi.utils.ProUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * 读取配置文件
 * */
public class LoginProp  {
    //初始化driver
    public WebDriver driver;
    //初始化方法
    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");
        //最大化窗口
       // ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--start-maximized");
       // driver = new ChromeDriver(chromeOptions);
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com");
        driver.manage().window().maximize();


    }
    public void loginScript(String username,String userpassword ) throws Exception {
        //提取用户参数=======================================================
        //账号密码作为用户参数，在调用方法时传入即可
      //  String username = "850512700@qq.com";
       // String userpassword = "shan6500333jing";



        //===============================
        //提取定位方法，将定位方式封装成方法，将定位方法名称写成key value提供给方法调用，方法传入，定位方式和定位值。
       /*   String zero = "id";
            String one = "name";
            String two = "name";
            String three ="xpath";
            String four = "id";
            String five = "classname";
*/



        //首页右上角登录按钮
        //String loginone ="js-signin-btn";
       // String WebElementemail = "email";
        //String WebElementpassword = "password";
       // String WebElementloginButton = "//*[@id=\'signup-form\']/div[5]/input";
        //个人信息
       // String header_info = "header-avator";
        //用户昵称
        //String user_nicheng = "name";

        //首页右上角登录按钮
      //  driver.findElement(By.id(loginone)).click();

       // driver.findElement(this.byStr(zero,loginone)).click();
       // this.element()替换了driver.findElement（）
       this.element(this.byStr("zero")).click();
        Thread.sleep(3000);
           //输入邮箱或者手机号
          //WebElement user = this.element(By.name(WebElementemail));

         // WebElement user = this.element(this.byStr(one,WebElementemail));
           WebElement user = this.element(this.byStr("one"));
           user.isDisplayed();
           //输入密码
           WebElement password = this.element(this.byStr("two"));
           password.isDisplayed();
           //WebElement loginButton = this.element(By.className("btn-red"));
        //登录按钮
           WebElement loginButton = this.element(this.byStr("three"));
           loginButton.isDisplayed();
           user.sendKeys(username);
           password.sendKeys(userpassword);
           loginButton.click();
           Thread.sleep(2000);
           //鼠标悬浮在个人信息
           WebElement header = this.element(this.byStr("four"));
           header.isDisplayed();
        Thread.sleep(1000);
           Actions actions = new Actions(driver);
           actions.moveToElement(header).perform();
           String userInfo = this.element(this.byStr("five")).getText();
           System.out.println(userInfo);
           if(userInfo.equals("qq_big大山mount_03375711")){
               System.out.println("登录成功loginpROP");

           }else {
               System.out.println("登录失败loginProp!");
           }
    }
    /***
     * by封装定位方法
     */
    public By byStr(String elementkey ) throws Exception{
        ProUtil properties = new ProUtil("element.properties");
        //username 包含定位方式是by.name  定位数值是
        String localtor = properties.getPro(elementkey);
        String localtorType = localtor.split(">")[0];
        String localtorValue = localtor.split(">")[1];
        //用localtorType替换by.其实就是进一步抽取/
        if (localtorType.equals("id")){
            return By.id(localtorValue);
        }else  if (localtorType.equals("name")){
            return By.name(localtorValue);
        }else if (localtorType.equals("classname")){
            return  By.className(localtorValue);
        }else {
            return  By.xpath(localtorValue);
        }

     }
     /**
      * 封装driver.findElement()
      *
      * */
     public WebElement element(By by){
         WebElement ele = driver.findElement(by);
         return ele;
     }
    public static void main(String[] args) throws Exception {
        LoginProp loginProp = new LoginProp();
        loginProp.InitDriver();
        loginProp.loginScript("850512700@qq.com","shan6500333jing");

    }

}
