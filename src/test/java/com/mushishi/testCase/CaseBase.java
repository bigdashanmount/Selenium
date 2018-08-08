package com.mushishi.testCase;

import com.mushishi.base_serve_driver.DriverBase;


public class CaseBase {

    public DriverBase InitDriver(String browser){
        return new DriverBase(browser);
    }
}
