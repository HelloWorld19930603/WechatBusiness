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
	 * @param param 数据对象
	 */
	public void insert(T param) throws Exception;
	/**
	 * 修改
	 * @param param 数据对象
	 */
	public void modify(T param) throws Exception;
	/**
	 * 删除
	 * @param param 数据对象
	 */
	public void delete(int param) throws Exception;
	/**
	 * 查询所有数据
	 * @param param 数据对象
	 */
	public List<T> selectAll(Map<String, Object> param) throws Exception;
	/**
	 * 分页查询
	 * @param param 数据对象
	 */
	public List<T> selectPage(Map<String, Object> param) throws Exception;
	/**
	 * 查询详情
	 * @param param 数据对象
	 */
	public T selectOne(Map<String, Object> param) throws Exception;
	
	/**
	 * 查询记录数
	 * @param param
	 * @return
	 */
	public int count(Map<String, Object> param) throws Exception;

	
}
