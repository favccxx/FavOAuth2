package com.favccxx.favauth.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T> {
	
	/**
	 * 根据Id获取对象实例
	 * 
	 * @param id
	 * @return
	 */
	public T load(Serializable id);

	/**
	 * 查询所有的对象列表
	 * 
	 * @return
	 */
	public List<T> loadAll();

	/**
	 * 新增对象实例
	 * 
	 * @param entity
	 */
	public void save(T entity);

	/**
	 * 删除对象实例
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 更新对象实例
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 新增或保存对象实例
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * HQL查询
	 * @param hql
	 * @return
	 */
	public List<?> find(String hql);

	/**
	 * 带参数的HQL查询
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<?> find(String hql, Object... params);

}
