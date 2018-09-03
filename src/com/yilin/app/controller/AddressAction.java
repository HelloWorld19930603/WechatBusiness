package com.yilin.app.controller;

import com.yilin.app.common.Permission;
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
public class AddressAction {

    @Resource
    AddressService addressService;


    @RequestMapping("findList")
    @ResponseBody
    public ResultJson findList(String token){
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            List list = addressService.findAllByUserId(userId);
            result = new ResultJson(true,"查询成功",list);
        } catch (Exception e) {
            result = new ResultJson(false,"查询失败");
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("setDefault")
    @ResponseBody
    public ResultJson setDefault(int addrId,String token){
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            addressService.updateDefault(addrId,userId);
            result = new ResultJson(true,"设置成功");
        } catch (Exception e) {
            result = new ResultJson(false,"设置失败");
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("getDefault")
    @ResponseBody
    public ResultJson getDefault(String token){
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            Address address = addressService.findDefault(userId);
            result = new ResultJson(true,"获取默认地址成功",address);
        } catch (Exception e) {
            result = new ResultJson(false,"获取默认地址失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("getAddress")
    @ResponseBody
    public ResultJson getAddress(String token){
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
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
    public ResultJson updateOne(Address address,String token){
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            address.setUserId(userId);
            addressService.updateAddress(address);
            result = new ResultJson(true,"更新地址成功");
        } catch (Exception e) {
            result = new ResultJson(false,"更新地址失败");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("addOne")
    @ResponseBody
    public ResultJson addOne(Address address,String token){
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            address.setUserId(userId);
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
    public ResultJson removeAddr(int addrId,String token){
        ResultJson result;
        try {
            int userId = Permission.getUserId(token);
            addressService.removeAddress(addrId,userId);
            result = new ResultJson(true,"删除地址成功");
        } catch (Exception e) {
            result = new ResultJson(false,"删除地址失败");
            e.printStackTrace();
        }
        return result;
    }
}
