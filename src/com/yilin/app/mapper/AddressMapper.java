package com.yilin.app.mapper;

import com.yilin.app.domain.Address;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper extends IBaseMapper<Address>{

    Address selectDefault(@Param("user_id") int user_id);

    void updateByUserId(@Param("user_id") int user_id);

}