package com.yilin.system.service;

import com.yilin.app.domain.DataTmp;

import java.util.List;

/**
 * Created by cc on 2018/11/11.
 */
public interface IDataTmpService {

    void addOne(DataTmp dataTmp) throws Exception;

    void updateOne(DataTmp dataTmp) throws Exception;


    List<DataTmp> selectList(Integer status, Long time) throws Exception;
}
