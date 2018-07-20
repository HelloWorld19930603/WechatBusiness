package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.ResultJson;
import com.yilin.app.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cc on 2018/7/9.
 */
@Controller
@RequestMapping("order")
public class OrderContorller {

    @Autowired
    IOrderService orderService;


    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(Integer userId,int index,int pageSize)  {
        ResultJson result;
        try {
            if(userId != null) {
                Page page = orderService.selectPage(userId, index, pageSize);
                result = new ResultJson(true, "查询成功", page);
            }else {
                result = new ResultJson(false,"userId不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询失败");
        }
        return result;
    }

}
