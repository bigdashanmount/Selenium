package com.mushishi.testCase;

import com.mushishi.utils.ProUtil;

public class Test001 {



    public static void main(String[] args) throws Exception {

        ProUtil pro= new ProUtil("cookie.properties");
        String value = pro.getPro("apsid");
       System.out.println(value);

    }

}
