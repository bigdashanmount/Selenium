package com.mushishi.base_control_page;

import com.mushishi.base_serve_driver.DriverBase;

public class CoursePagePro {
    public DriverBase driver;
    public CoursePageHandle coursePageHandle;
    public CoursePagePro(DriverBase driver){
        this.driver = driver;
        coursePageHandle = new CoursePageHandle(driver);
    }
    public void addCart() throws Exception {
        //购物车是空的，数量为0
        int afterNum;
        int beforeNum = 0;
        //添加过的购物车商品数量
        String  aftercoursenum;
        String courseNum = coursePageHandle.getShopCartNum();
        try {
            beforeNum = Integer.valueOf(courseNum);
            System.out.println(beforeNum);
        }catch (Exception e){
            beforeNum = 0;
        }
        //点击添加购物车
        coursePageHandle.clickAddCart();
        //点击的商品如果已经添加到购物车,显示提示弹框
        try {
            driver.switchToMode();
            //点击弹框确认

            coursePageHandle.clickReadBuy();
            //点击了添加购物车,如果不等待,数值还没传递过去,获取值的操作就结束了.
            Thread.sleep(2000);
        }catch (Exception e){

        }

        //添加购物车后获取购物车里商品的数量
       aftercoursenum = coursePageHandle.getShopCartNum();
       try{
            afterNum = Integer.valueOf(aftercoursenum);
            System.out.println(afterNum);
       }catch (Exception e){
           afterNum = beforeNum;
       }
       Thread.sleep(4000);
       if (afterNum == beforeNum+1){
           System.out.println("afterNum == beforeNum+1添加购物车成功！！！");
           //点击查看购物车
           coursePageHandle.chickShopCart();
       }else if (afterNum>0){
           //点击添加购物车
           coursePageHandle.chickShopCart();
           System.out.println("afterNum>0添加购物车成功！！！");
       }else if (afterNum==0){
           //点击添加购物车
           coursePageHandle.chickShopCart();
           System.out.println("购物车为空,首次添加,初始值0,1没传进来就获取了！！！");
       }
    }
    /**
     * 点击立即购买
     * */
        public void buyNow() throws Exception {
            coursePageHandle.clickBuyNow();
        }
}
