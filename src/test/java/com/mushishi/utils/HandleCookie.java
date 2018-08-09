package com.mushishi.utils;

import com.mushishi.base_serve_driver.DriverBase;
import org.openqa.selenium.Cookie;

import java.util.Set;



public class HandleCookie {
	public DriverBase driver;
	public ProUtil pro;
	public HandleCookie(DriverBase driver){
		this.driver = driver;
		pro = new ProUtil("cookie.properties");
	}
	public void setCookie() throws Exception {
		String value = pro.getPro("apsid");
		Cookie cookie = new Cookie("apsid",value,"imooc.com","/",null);
		driver.setCookie(cookie);
	}
	/**
	 * 获取cookie
	 * */
	public void writeCookie(){
		Set<Cookie> cookies = driver.getCookie();
		for(Cookie cookie:cookies){
			if(cookie.getName().equals("apsid")){
				pro.writePro(cookie.getName(), cookie.getValue());
			}
		}
	}
}


