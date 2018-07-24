package com.yilin.app.service;

import com.yilin.app.common.Page;

/**
 * Created by cc on 2018/7/24.
 */
public interface ICollegeService {

    Page findPage(int start, int pageSize) throws Exception;
}
