package com.yilin.app.service.impl;

import com.yilin.app.domain.Address;
import com.yilin.app.mapper.AddressMapper;
import com.yilin.app.service.IAddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/7/17.
 */
@Service
public class AddressService implements IAddressService {

    @Resource
    AddressMapper addressMapper;

    @Override
    public List<Address> findAllByUserId(Integer userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        return addressMapper.selectAll(map);
    }

    @Override
    public Address findDefault(int userId) throws Exception {

        return addressMapper.selectDefault(userId);
    }

    @Override
    public Address findAddress(int id) throws Exception {

        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateDefault(int id, int userId) throws Exception{
        addressMapper.updateByUserId(userId);
        Address address = new Address();
        address.setId(id);
        address.setStatus(true);
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void updateAddress(Address address) throws Exception{
        addressMapper.updateByPrimaryKey(address);
    }

    @Override
    public void addAddress(Address address) throws Exception{
        addressMapper.insertSelective(address);
    }

    @Override
    public void removeAddress(int id) throws Exception{
        addressMapper.deleteByPrimaryKey(id);
    }
}
