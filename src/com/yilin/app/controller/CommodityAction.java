package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Commodity;
import com.yilin.app.service.ICommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("commodity")
public class CommodityAction {


    @Resource
    ICommodityService commodityService;


    @RequestMapping("findPage")
    @ResponseBody
    public ResultJson findPage(Integer type,Integer userId,Integer serise,int start,int pageSize){
        ResultJson result;
        try {
            Page page = commodityService.selectPage(type,userId,serise,start,pageSize);
            result = new ResultJson(true,"查询商品分页成功",page);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询商品分页失败");
        }
        return result;
    }


    @RequestMapping("findOne")
    @ResponseBody
    public ResultJson findOne(int commId,int userId){
        ResultJson result;
        try {
            Commodity commodity = commodityService.selectById(commId,userId);
            result = new ResultJson(true,"查询商品详情成功",commodity);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询商品详情失败");
        }
        return result;
    }

    @RequestMapping("findPrice")
    @ResponseBody
    public ResultJson findPrice(int commId,Integer userId){
        ResultJson result;
        try {
            Float price= commodityService.getPrice(commId,userId);
            result = new ResultJson(true,"查询订货价成功",price);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询订货价失败");
        }
        return result;
    }

    @RequestMapping("findCount")
    @ResponseBody
    public ResultJson findCount(Integer type,Integer serise){
        ResultJson result;
        try {
            int total = commodityService.getCount(type,serise);
            result = new ResultJson(true,"查询商品数量成功",total);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false,"查询商品数量失败");
        }
        return result;
    }
}