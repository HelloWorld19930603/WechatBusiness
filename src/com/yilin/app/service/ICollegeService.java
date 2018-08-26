package com.yilin.app.service;

import com.yilin.app.common.Page;

import java.util.List;

/**
 * Created by cc on 2018/7/24.
 */
public interface ICollegeService {

    Page findPage(Byte type,int start, int pageSize) throws Exception;

    List findList(Byte type, String title, int start, int pageSize) throws Exception;

    int getCount(Byte type) throws Exception;

    void addOne(String title, String content, String img, String video, byte type) throws Exception;
}
