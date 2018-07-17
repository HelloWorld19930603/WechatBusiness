package com.yilin.app.mapper;

import com.yilin.app.domain.Address;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper extends IBaseMapper<Address>{

    List<Address> selectByUserId(@Param("user_id")String userId);
}