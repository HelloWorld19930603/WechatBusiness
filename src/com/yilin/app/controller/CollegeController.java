package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.service.ICollegeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/23.
 */
@Controller
@RequestMapping("college")
public class CollegeController {

    @Resource
    ICollegeService collegeService;

    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(int start, int pageSize){
        ResultJson result;
        try {
            result = new ResultJson(true,"查询学院详情成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询学院详情失败");
        }
        return result;
    }

}
