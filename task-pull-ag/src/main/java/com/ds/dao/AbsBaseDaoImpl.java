package com.ds.dao;

import com.ds.mapper.Mapper;
/**
 * dao接口注入mapper
 * @author 光光
 *
 * @param <T>
 */
public abstract class AbsBaseDaoImpl<T> implements IBaseDao<T> {
	private Mapper<T> mapper;

	public AbsBaseDaoImpl(Mapper<T> mapper) {
		super();
		this.mapper = mapper;
	}

	public Mapper<T> getMapper() {
		return mapper;
	}

	public void setMapper(Mapper<T> mapper) {
		this.mapper = mapper;
	}
	@Override
	public void create(T t) {
		if(t != null) {
			mapper.create(t);
		}
	}
}
