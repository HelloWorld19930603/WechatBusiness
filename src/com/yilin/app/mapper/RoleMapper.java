package com.yilin.app.mapper;

import com.yilin.app.domain.Role;
import com.yilin.app.mapper.base.IBaseMapper;

public interface RoleMapper  extends IBaseMapper<Role> {

    int findLevel(int userId) throws Exception;
}