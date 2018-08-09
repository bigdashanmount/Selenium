package com.mushishi.base_control_page;

import com.mushishi.base_serve_driver.DriverBase;
import com.mushishi.utils.GetByLocator;
import org.openqa.selenium.WebElement;

//立即购买页面元素封装
public class CoursePage extends BasePage {
    //构造方法
    public CoursePage(DriverBase driver){
        super(driver);
    }
    //获取立即购买按钮element
    public WebElement getBuytriggerElement () throws Exception {
        return element(GetByLocator.GetLocator("buyNow"));
    }
    //获取添加购物车element
    public WebElement getAddCartElement() throws Exception {
        return element(GetByLocator.GetLocator("addCart"));
    }
    //获取右上角购物车element
    public WebElement getShopCartElement() throws Exception {
        return element(GetByLocator.GetLocator("shopCart"));
    }
    //获取购物车数量element

    public WebElement getShopCartNumElement() throws Exception {
        return element(GetByLocator.GetLocator("cartNumxpath"));
    }
    //获取课程详情页面左上角课程名element
    public WebElement getCourseNameElement() throws Exception {
        return element(GetByLocator.GetLocator("courseinfoxpath"));
    }
    //通过子父节点定位已添加购物车弹框内部元素
    public WebElement getReadyBuy() throws Exception {
        return nodeElement(GetByLocator.GetLocator("readybuySure"),GetByLocator.GetLocator("readybuySureNode"));
    }


}
