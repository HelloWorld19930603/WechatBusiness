package com.yilin.system.service;

import com.yilin.app.domain.Poster;

import java.util.List;
import java.util.Map;

/**
 * Created by cc on 2018/8/7.
 */
public interface IPosterService {
    int selectNum(String page, Byte status) throws Exception;

    List<Map<String,Object>> selectList(String page, Byte type, int start, int pageSize) throws Exception;

    void insertPoster(Poster poster) throws Exception;

    void removeOne(int id)throws Exception;;

    Poster selectOne(int id) throws Exception;

    void editOne(Poster poster)throws Exception;

    String[] findPosterImg(int type, int status, int page) throws Exception;
}
