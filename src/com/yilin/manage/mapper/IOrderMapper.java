package com.yilin.manage.mapper;

import com.yilin.manage.domain.Orders;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.EnterpriseInfoMapper.xml
 */
public interface IOrderMapper {


    public List<Orders> selectAll();
}
