package com.yilin.app.controller;

import com.yilin.app.common.Page;
import com.yilin.app.common.Permission;
import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Commodity;
import com.yilin.app.service.ICommodityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

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
    public ResultJson findPage(Integer type, String token, Integer serise, int start, int pageSize) {
        ResultJson result;
        try {
            Integer userId = token == null ? null : Permission.getUserId(token);
            Page page = commodityService.selectPage(type, userId, serise, start, pageSize);
            result = new ResultJson(true, "查询商品分页成功", page);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询商品分页失败");
        }
        return result;
    }


    @RequestMapping("findOne")
    @ResponseBody
    public ResultJson findOne(int commId, String token) {
        ResultJson result;
        try {
            Integer userId = token == null ? null : Permission.getUserId(token);
            Commodity commodity = commodityService.selectById(commId, userId);
            result = new ResultJson(true, "查询商品信息成功", commodity);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询商品信息失败");
        }
        return result;
    }

    @RequestMapping("findDetails")
    @ResponseBody
    public ResultJson findDetails(int commId) {
        ResultJson result;
        try {
            List<String> details = commodityService.selectDetails(commId);
            result = new ResultJson(true, "查询商品详情图片成功", details);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询商品详情图片失败");
        }
        return result;
    }

    @RequestMapping("findPrice")
    @ResponseBody
    public ResultJson findPrice(int commId, String token) {
        ResultJson result;
        try {
            Integer userId = token == null ? null : Permission.getUserId(token);
            Float price = commodityService.getPrice(commId, userId);
            result = new ResultJson(true, "查询订货价成功", price);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询订货价失败");
        }
        return result;
    }

    @RequestMapping("findCount")
    @ResponseBody
    public ResultJson findCount(Integer type, Integer serise) {
        ResultJson result;
        try {
            int total = commodityService.getCount(type, serise);
            result = new ResultJson(true, "查询商品数量成功", total);
        } catch (Exception e) {
            e.printStackTrace();
            result = new ResultJson(false, "查询商品数量失败");
        }
        return result;
    }
}
