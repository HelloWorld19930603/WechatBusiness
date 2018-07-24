package com.yilin.app.mapper.base;

import java.util.List;
import java.util.Map;

/**
 * 数据持久化base接口
 *
 * @param <T>
 */
public interface IBaseMapper<T> {
	/**
	 * 新增
	 * @param record 数据对象
	 */
    int insert(T record)throws Exception;

    int insertSelective(T record) throws Exception;
	/**
	 * 修改
	 * @param record 数据对象
	 */
    int updateByPrimaryKey(T record) throws Exception;

    int updateByPrimaryKeySelective(T record) throws Exception;

	/**
	 * 删除
	 * @param id
	 */
    int deleteByPrimaryKey(Integer id) throws Exception;

	/**
	 * 根据id查询详情
	 * @param id 数据对象
	 */
    T selectByPrimaryKey(Integer id) throws Exception;

    T selectOne(Map<String,Object> param) throws Exception;
	/**
	 * 分页查询
	 * @param param 数据对象
	 */
	 List<T> selectPage(Map<String, Object> param) throws Exception;

    /**
     * 查询全部
     * @param param 数据对象
     */
    List<T> selectAll(Map<String, Object> param) throws Exception;

	/**
	 * 查询记录数
	 * @param param
	 * @return
	 */
	 int count(Map<String, Object> param) throws Exception;



}
