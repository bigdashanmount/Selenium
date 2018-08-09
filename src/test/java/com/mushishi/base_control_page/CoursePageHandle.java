package com.mushishi.base_control_page;

import com.mushishi.base_serve_driver.DriverBase;
import org.openqa.selenium.WebElement;

public class CoursePageHandle {
  public DriverBase driver;
  public CoursePage coursepage;
  public CoursePageHandle(DriverBase driver){
      this.driver = driver;
      coursepage = new CoursePage(driver);
  }
  //点击立即购买
    public  void  clickBuyNow() throws Exception {
      coursepage.click(coursepage.getBuytriggerElement());
    }
  //点击添加购物车
    public void clickAddCart() throws Exception {
      coursepage.click(coursepage.getAddCartElement());
    }
    //点击右上角的购物车
    public void chickShopCart() throws Exception {
      coursepage.click(coursepage.getShopCartElement());
    }
    //获取购物车数量
    public String getShopCartNum() throws Exception {
      return coursepage.getShopCartNumElement().getText();
    }
    //获取课程名称
    public String getCourseName() throws Exception {
      WebElement element = coursepage.getCourseNameElement();
      return coursepage.getText(element);
    }
    //点击已经购买弹框的确定按钮
    public void clickReadBuy() throws Exception {
     coursepage.click(coursepage.getReadyBuy());
    }

}
