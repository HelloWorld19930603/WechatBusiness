package com.yilin.app.controller;

import com.yilin.app.common.ResultJson;
import com.yilin.app.domain.Address;
import com.yilin.app.service.impl.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cc on 2018/7/17.
 */
@Controller
@RequestMapping("address")
public class AddressController {

    @Resource
    AddressService addressService;


    @RequestMapping("findList")
    @ResponseBody
    public ResultJson findList(int userId){
        ResultJson result;
        try {
            List list = addressService.findAllByUserId(userId);
            result = new ResultJson(true,"查询成功",list);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("setDefaultAddress")
    @ResponseBody
    public ResultJson setDefaultAddress(int id,int userId){
        ResultJson result;
        try {
            addressService.updateDefault(id,userId);
            result = new ResultJson(true,"设置成功");
        } catch (Exception e) {
            result = new ResultJson(false,"设置失败");
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("getDefaultAddress")
    @ResponseBody
    public ResultJson getDefaultAddress(int userId){
        ResultJson result;
        try {
            Address address = addressService.findDefault(userId);
            result = new ResultJson(true,"设置成功",address);
        } catch (Exception e) {
            result = new ResultJson(false,"设置失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("updatetAddress")
    @ResponseBody
    public ResultJson updatetAddress(Address address){
        ResultJson result;
        try {
            addressService.updateAddress(address);
            result = new ResultJson(true,"更新成功");
        } catch (Exception e) {
            result = new ResultJson(false,"更新失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("addAddress")
    @ResponseBody
    public ResultJson addAddress(Address address){
        ResultJson result;
        try {
            addressService.addAddress(address);
            result = new ResultJson(true,"添加成功");
        } catch (Exception e) {
            result = new ResultJson(false,"添加失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("removeAddress")
    @ResponseBody
    public ResultJson removeAddress(int id){
        ResultJson result;
        try {
            addressService.removeAddress(id);
            result = new ResultJson(true,"添加成功");
        } catch (Exception e) {
            result = new ResultJson(false,"添加失败");
            e.printStackTrace();
        }
        return result;
    }
}
