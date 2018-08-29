package com.yilin.app.mapper;

import com.yilin.app.domain.Poster;
import com.yilin.app.mapper.base.IBaseMapper;

import java.util.Map;

public interface PosterMapper extends IBaseMapper<Poster> {

    String[] selectContent(Map<String, Object> map) throws Exception;
}