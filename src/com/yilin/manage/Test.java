package com.yilin.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/7/9.
 */
@Controller
public class Test {


    @RequestMapping("/test")
    public String test(){
        System.out.println("hello");
        return "test";
    }
}
