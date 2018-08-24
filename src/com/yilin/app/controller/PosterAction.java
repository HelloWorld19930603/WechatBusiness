package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by cc on 2018/8/23.
 */
@Controller
@RequestMapping("poster")
public class PosterAction {


    @RequestMapping("findBanner")
    @ResponseBody
    public ResultJson findBanner(){
        ResultJson result;
        String[] banner = new String[3];
        banner[0] = "/images/home/poster/banner-1.jpg";
        banner[1] = "/images/home/poster/banner-2.jpg";
        banner[2] = "/images/home/poster/banner-3.jpg";
        Map<String,Object> map = new HashedMap();
        map.put("1",banner);
        map.put("2","/images/home/commodity/popularity.png");
        map.put("3","/images/home/commodity/star.png");
        result = new ResultJson(true,"查询成功",map);
        return result;
    }

    @RequestMapping("findPopularity")
    @ResponseBody
    public ResultJson findPopularity(){

        ResultJson result = new ResultJson(true,"查询成功","/images/home/commodity/popularity2.png");
        return result;
    }

    @RequestMapping("findStar")
    @ResponseBody
    public ResultJson findStar(){

        ResultJson result = new ResultJson(true,"查询成功","/images/home/commodity/star2.png");
        return result;
    }

    @RequestMapping("findLogistics")
    @ResponseBody
    public ResultJson findLogistics(){

        ResultJson result = new ResultJson(true,"查询成功","/images/home/commodity/demo.png");
        return result;
    }

    @RequestMapping("findReview")
    @ResponseBody
    public ResultJson findReview(){

        ResultJson result = new ResultJson(true,"查询成功","/images/home/commodity/demo.png");
        return result;
    }

}
