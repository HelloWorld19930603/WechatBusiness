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


    @RequestMapping("setDeafult")
    @ResponseBody
    public ResultJson setDeafult(int addrId,int userId){
        ResultJson result;
        try {
            addressService.updateDefault(addrId,userId);
            result = new ResultJson(true,"设置成功");
        } catch (Exception e) {
            result = new ResultJson(false,"设置失败");
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("getDeafult")
    @ResponseBody
    public ResultJson getDeafult(int userId){
        ResultJson result;
        try {
            Address address = addressService.findDefault(userId);
            result = new ResultJson(true,"获取默认地址成功",address);
        } catch (Exception e) {
            result = new ResultJson(false,"获取默认地址失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("getDefault")
    @ResponseBody
    public ResultJson getAddress(int userId){
        ResultJson result;
        try {
            Address address = addressService.findDefault(userId);
            result = new ResultJson(true,"获取地址成功",address);
        } catch (Exception e) {
            result = new ResultJson(false,"获取地址失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("updateOne")
    @ResponseBody
    public ResultJson updateOne(Address address){
        ResultJson result;
        try {
            addressService.updateAddress(address);
            result = new ResultJson(true,"设置默认地址成功");
        } catch (Exception e) {
            result = new ResultJson(false,"设置默认地址失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("addOne")
    @ResponseBody
    public ResultJson addOne(Address address){
        ResultJson result;
        try {
            addressService.addAddress(address);
            result = new ResultJson(true,"添加地址成功");
        } catch (Exception e) {
            result = new ResultJson(false,"添加地址失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("removeOne")
    @ResponseBody
    public ResultJson removeAddr(int addrId){
        ResultJson result;
        try {
            addressService.removeAddress(addrId);
            result = new ResultJson(true,"删除地址成功");
        } catch (Exception e) {
            result = new ResultJson(false,"删除地址失败");
            e.printStackTrace();
        }
        return result;
    }
}
