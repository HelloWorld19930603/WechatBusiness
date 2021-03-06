package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.College;
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
public class CollegeAction {

    @Resource
    ICollegeService collegeService;

    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(Byte type, int start, int pageSize) {
        ResultJson result;
        try {
            Page page = collegeService.findPage(type, start, pageSize);
            result = new ResultJson(true, "查询学院详情成功", page);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询学院详情失败");
        }
        return result;
    }

    @RequestMapping("findOne")
    @ResponseBody
    public ResultJson findOne(int id) {
        ResultJson result;
        try {
            College college = collegeService.selectOne(id);
            collegeService.readOne(id);
            result = new ResultJson(true, "查询学院详情成功", college);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询学院详情失败");
        }
        return result;
    }

    @RequestMapping("forward")
    @ResponseBody
    public ResultJson forward(int id) {
        ResultJson result;
        collegeService.forwardOne(id);
        result = new ResultJson(true, "修改成功");
        return result;
    }

}
