package com.yilin.app.service.impl;

import com.yilin.app.domain.UserRole;
import com.yilin.app.mapper.UserRoleMapper;
import com.yilin.app.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/23.
 */
@Service
public class RoleService implements IRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> selectRoles(int userId) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        return userRoleMapper.selectAll(map);
    }
}
