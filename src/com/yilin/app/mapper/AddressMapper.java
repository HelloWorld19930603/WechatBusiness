package com.yilin.app.mapper;

import com.yilin.app.domain.Address;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper extends IBaseMapper<Address>{

    Address selectDefault(@Param("userId") int userId);

    void updateByUserId(@Param("userId") int userId);

    void deleteOne(@Param("id") int id, @Param("userId") int userId);
}