package com.favccxx.favauth.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.favccxx.favauth.dao.IBaseDao;

public class BaseDaoImpl<T> implements IBaseDao<T> {
	
	private Class<T> entityClass;

	@Autowired
	protected HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType genType = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass = (Class<T>) genType.getActualTypeArguments()[0];
	}

	@Override
	public T load(Serializable id) {
		return (T) hibernateTemplate.load(entityClass, id);
	}

	@Override
	public List<T> loadAll() {
		return hibernateTemplate.loadAll(entityClass);
	}

	@Override
	public void save(T entity) {
		hibernateTemplate.save(entity);
	}

	@Override
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void update(T entity) {
		hibernateTemplate.update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	@Override
	public List<?> find(String hql) {
		return hibernateTemplate.find(hql);
	}

	
	@Override
	public List<?> find(String hql, Object... params) {
		return hibernateTemplate.find(hql, params);
	}

	
	

}
