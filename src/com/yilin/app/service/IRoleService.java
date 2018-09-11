package com.yilin.app.service;

import com.yilin.app.domain.Role;
import com.yilin.app.domain.UserRole;

import java.util.List;

/**
 * Created by cc on 2018/8/23.
 */
public interface IRoleService {

    List<UserRole> selectRoles(int userId) throws Exception;

    void addOne(UserRole userRole)throws Exception;

    UserRole selectRole(int userId, int serise) throws Exception;
}
