package com.ds.dao;
/**
 * 所有dao接口都有的方法
 * @author 光光
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	public void create(T t);
}
