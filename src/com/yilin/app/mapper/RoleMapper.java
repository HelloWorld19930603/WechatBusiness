package com.yilin.app.mapper;

import com.yilin.app.domain.Role;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.Map;

public interface RoleMapper  extends IBaseMapper<Role> {

    Integer findRole(Map<String, Object> map) throws Exception;
}