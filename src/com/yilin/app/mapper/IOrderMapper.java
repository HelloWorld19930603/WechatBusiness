package com.yilin.app.mapper;

import com.yilin.app.domain.Orders;

import java.util.List;

/**
 * Created by Administrator on 2018/7/9.EnterpriseInfoMapper.xml
 */
public interface IOrderMapper {


    public List<Orders> selectAll();


    public void update(Orders orders);
}
