package com.yilin.app.controller;

import com.yilin.app.domain.Address;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("address")
public class AddressController {

    @RequestMapping("findList")
    public List<Address> findList(){
        List list = null;
        return list;
    }
}
