package com.yilin.app.controller;

import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Commodity;
import com.yilin.app.service.ICommodityService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/23.
 */
@Controller
@RequestMapping("poster")
public class PosterAction {

    @Autowired
    ICommodityService commodityService;

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
        map.put("popularity",2);
        map.put("star",3);
        result = new ResultJson(true,"查询成功",map);
        return result;
    }

    @RequestMapping("findPopularity")
    @ResponseBody
    public ResultJson findPopularity(String token){
        ResultJson result;
        Integer userId = token == null ? null : Permission.getUserId(token);
        try {
            Commodity commodity = commodityService.selectById(2, userId);
            List<String> details = commodityService.selectDetails(2);
            Map<String,Object> map = new HashedMap();
            map.put("commodity",commodity);
            map.put("details",details);
            result = new ResultJson(true,"查询成功",map);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(true,"查询失败");
        }

        return result;
    }

    @RequestMapping("findStar")
    @ResponseBody
    public ResultJson findStar(String token){
        ResultJson result;
        Integer userId = token == null ? null : Permission.getUserId(token);
        try {
            Commodity commodity = commodityService.selectById(3, userId);
            List<String> details = commodityService.selectDetails(3);
            Map<String,Object> map = new HashedMap();
            map.put("commodity",commodity);
            map.put("details",details);
            result = new ResultJson(true,"查询成功",map);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(true,"查询失败");
        }

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
