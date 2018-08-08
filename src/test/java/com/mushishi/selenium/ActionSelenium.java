 package com.mushishi.selenium;

import java.awt.Desktop.Action;
import java.rmi.activation.ActivationGroup;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionSelenium {
	//初始化driver
	public WebDriver driver;
	//初始化方法

    public void InitDriver(){
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\百场汇\\.ssh\\workspace\\muke\\selenium\\src\\Tools\\chromedriver.exe");
	 //最大化窗口
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--start-maximized");
    driver = new ChromeDriver(chromeOptions);
    driver.get("https://www.imooc.com/user/newlogin/from_url/");
   // driver.get("https://www.imooc.com");
	  this.Sleep(2000);	   
   }	
    //输入框讲解
    public void InputBox(){
    //获取账号输入框元素
      WebElement user = driver.findElement(By.name("email"));
    	user.sendKeys("850512700@qq.com");
    	user.clear();
    	user.sendKeys("850512700@qq.com");
    	//获取文本框中的隐藏提示
    	String user_info = user.getAttribute("placeholder");
    	System.out.println(user_info);
    	String user_value = user.getAttribute("value");
    	System.out.println(user_value);
    	//判断是否可以确认
    	boolean enable = user.isEnabled();
    	System.out.println(enable);
    	WebElement password =driver.findElement(By.name("password"));
    	password.sendKeys("shan6500333jing");
    	//点击登录
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/div[1]/div/div/form/div[5]/input")).click();
    	//driver.findElement(By.className("btn_red")).click();
        Wait();
    }
    //单选框操作
    public void RdioBox(){
    	//直接跳转到个人中心页面
    	driver.get("https://www.imooc.com/user/setprofile");
    	
    	//点击编辑按钮
    	driver.findElement(By.className("pull-right")).click();
    	WebElement sex_node =driver.findElement(By.xpath("//*[@id='profile']/div[4]/div"));
    	Wait();
    	//字符节点定位
    	//WebElement sex_node = driver.findElement(By.className("moco-control-input"));
    	//WebElement sex_node = driver.findElement(By.className("moco-control-input rlf-group rlf-radio-group"));
    	List<WebElement> list_sex = sex_node.findElements(By.tagName("input"));
    	for(WebElement sex :list_sex){
    		boolean flag = sex.isSelected();
    		if(flag == true){
    			continue; 
    			
    		}else{
    			//元素属性高不可见无法点击element not visible
    			
    			sex.click();
    			break;
    		}
    	}
    	
    	
    }
    //多选框操作
    public void CheckBox(){
    	//7天自动登录按钮
    	WebElement check = driver.findElement(By.id("auto-signin"));
    	Wait();
    	check.click();
    	boolean is_select = check.isSelected();
    	System.out.println(is_select);
    	boolean is_enabled = check.isSelected();
    	System.out.println(is_enabled);
    	
    }
    //按钮的处理
    public void Button(){
    	
    	
    }
    //表单
    public void Web_form(){
    	driver.findElement(By.id("signup-form")).submit();
    	//表单提交后，url变化了就无法提交成功
    	System.out.println("提交表单");
    }
    //上传头像
    public void UpFile_001(){
    	//直接跳转到个人中心页面
    	driver.get("https://www.imooc.com/user/setprofile");
    	Wait();
    	//设置js,显示更换头像按钮
    	String jsString = "document.getElementsByClassName('update-avator')[0].style.bottom='0';";
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript(jsString);
    	//点击更换头像
    	Wait();
    	driver.findElement(By.className("js-avator-link")).click();
    	Wait();
    	//找到"上传头像"id发送图片路径
    	driver.findElement(By.id("upload")).sendKeys("C:\\MySql\\1.jpg");
    	System.out.println("头像001111");
    	 
    }
    public void UpFile_002(){
    	//直接跳转到个人中心页面
    	driver.get("https://www.imooc.com/user/setprofile");
       this.Wait();
       //获取更改头像的className
       WebElement header = driver.findElement(By.className("avator-img"));
       //模拟鼠标移动事件，悬浮
       Actions actions = new Actions(driver);
       //移动到元素上，并提交
       actions.moveToElement(header).perform();
       driver.findElement(By.className("js-avator-link")).click();
   	   Wait();
     	//找到"上传头像"id发送图片路径，上传的标签必须是input才能sendkey
   	   driver.findElement(By.id("upload")).sendKeys("C:\\MySql\\1.jpg");
   	  System.out.println("头像002");
    }
    //下拉框多选
    public void DowmSlectBox(){
    	//直接跳转到个人中心页面
    	driver.get("https://www.imooc.com/user/setprofile");
    	//点击职业下拉框
    	driver.findElement(By.className("pull-right")).click();
        this.Sleep(2000);
        //进入form弹框
        WebElement formElement =  driver.findElement(By.id("profile"));
        //寻找职业
        WebElement job = formElement.findElement(By.id("job"));
        //创建下拉框控制对象
        Select downList = new Select(job);
        //三种方法
        downList.selectByIndex(2);
        //downList.selectByValue("1");
       // downList.selectByVisibleText("学生");
        /*取消多选的选项，单选不能取消
        downList.deselectByIndex(2);
        downList.deselectAll();
        downList.deselectByValue(arg0);
        downList.deselectByVisibleText(arg0);*/
        //获取下拉列表属性信息getSelectedOption()也是操作多选
        String info = downList.getFirstSelectedOption().getText();
        System.out.println(info);
        List<WebElement> list = downList.getAllSelectedOptions();
        for(WebElement option:list){
        	System.out.println(option.getText());
        }
        
    }
    //等待函数
    public void Wait(){
    	 System.out.println("等待3S");
    	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void Sleep(int sleeptime){
   	 System.out.println(sleeptime);
   	try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
    
    public void Quit(){
    	 //关闭并退出浏览器    
       driver.quit();
        System.out.println("关闭浏览器");
    }
    /**
     * 鼠标事件
     * 操作首页登录
     * */
    public void MoseAction(){
    	Actions actions = new Actions(driver);
    
    	/*登录的id
    	WebElement login = driver.findElement(By.id("js-signin-btn"));
    	
    	//单机操作
    	//actions.click(login).perform();
    	this.Sleep(2000);
    	//双击操作
    	actions.doubleClick(login).perform();
    	this.Sleep(2000);
    	//右击操作
    	actions.contextClick(login).perform();
    	*/
    	//悬停显示列表
    	this.Sleep(2000);
    	//获取某端开发的父节点class
    	WebElement menuContent = driver.findElement(By.className("menuContent"));
    	//根据下标定位节点
    	List<WebElement> item = menuContent.findElements(By.className("item"));
    	//悬浮停留在前端开发
    	actions.moveToElement(item.get(1)).perform();
    	//点击Htmlcss
    	driver.findElement(By.linkText("HTML/CSS")).click();
    	
    }
    /**
     * iframe切换
     * 
     * 
     * */
    public void Iframe(){
    	//进入wiki文本编辑页面
    	driver.get("https://www.imooc.com/wiki/create");
    	//找到iframe 的定位信息
    	WebElement iframe = driver.findElement(By.id("ueditor_0"));
    	driver.switchTo().frame(iframe);
    	driver.findElement(By.tagName("body")).sendKeys("this is test");
    }
    /**
     * 窗口切换，获取handle去循环比对
     * */
    public void WindowsHandle(){
    //点击前沿技术分类
    	driver.findElement(By.linkText("前沿技术")).click();
    	System.out.println("前沿技术");
    	//获取此页面的handle
    	String handle001 = driver.getWindowHandle();
    	System.out.println(handle001);
    	this.Sleep(2000);
    	//点击"个性化推荐算法实战入门必修课"，会新窗口打开一个页面
    	driver.findElement(By.xpath("//*[@id='main']/div[2]/div[2]/div/div/div[1]/a/div[2]/h3")).click();
    	this.Sleep(2000);
    	//driver.findElement(By.linkText("同学笔记")).click();

	   	Set<String>  handles = driver.getWindowHandles();
	   	for(String s:handles){
	   		if(s.equals(handle001)){
	   			continue;
	   		}
	   		driver.switchTo().window(s);
	   		System.out.println(s);
	   	}
   	     //点击同学笔记
    	driver.findElement(By.xpath("//*[@id='noteOn']")).click(); 	
    }
    public void waitforElement(){

        //设置隐性等待时间  
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);  
    	WebDriverWait wt = new WebDriverWait(driver, 5);
    	wt.until(ExpectedConditions.presenceOfElementLocated(By.id("test")));
    }
	public static void main(String[] args) {
		ActionSelenium   as = new ActionSelenium();
		as.InitDriver();
	   // as.CheckBox();
		as.InputBox();
		//as.DowmSlectBox();
		//as.UpFile_002();
//      as.Web_form();
//		as.RdioBox();
		//as.Quit();
		//as.MoseAction();
		//as.Iframe();
		as.WindowsHandle();
		
	}

}
