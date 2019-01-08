package com.yilin.app.mapper;

import com.yilin.app.domain.UserRole;
import com.yilin.app.mapper.base.IBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper extends IBaseMapper<UserRole>{

    void updateLevel(@Param("userId") int userId, @Param("serise") int serise, @Param("level") int level);
}