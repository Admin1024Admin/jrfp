package com.ky.ct.rzdj.dao;

import com.ky.ct.rzdj.model.PkfAllEntity;
import com.ky.ct.rzdj.model.PkfInformationEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//dao层顶层接口 BaseDao,dao中所有的类都将实现这个接口
public interface BaseDao<T> {

	// 增加
	public boolean add(T t);

	// 删除
	public boolean delete(T t);

	// 根据id删除
	public boolean deleteById(Serializable id);

	//根据cardId删除
	public boolean deleteByCardId(Serializable id);

	// 修改
	public boolean update(T t);

	// 增加或更新
	public boolean saveOrUpdate(T t);

	// 根据id查询
	public T findById(Serializable id);
	public T findByNo(String fieldName,Serializable id);
	// 查询全部
	public List<T> findAll();

	// 根据条件查询全部
	public List<T> findAll(Map<String, Object> condition);

	// 分页查询
	public List<T> findPage(final int page, final int length);

	// 按条件分页模糊查询
	public List<T> findPage(final int page, final int length,
                            Map<String, Object> pram);

	// 按条件准确查询
	public List<T> findPageByCondition(final int page, final int length,
                                       Map<String, Object> pram);
	// 按条件准确分页查询
	public List<T> findByCondition(Map<String, Object> pram);

	// 条件匹配所有字段查询并分页
	public List<T> findPage(final int page, final int length, String pram);

	// 条件匹配所有字段查询并分页,可再自定义一个查询条件
	public List<T> findPage(final int page, final int length, String pram,
                            Map<String, Object> map);

	// 求和
	public Object getCount();

	// 按条件求和
	public Object getCount(Map<String, Object> map);
	
	// 按条件求和
	public Object getCountByConition(Map<String, Object> map);
	
	// 按字段求和
	public Object getCount(String column);
		
	// 按字段求平均
	public Object getAvg(String column);
	
	public Object countBySql(String sql);

	// sql查询
	public T findBySql(String sql, Map<String, Object> condition);

	public T findBySql(String sql);
	
	public Object exec(String sql);
	
	public List<T> findListBySql(String sql);
	//选择字段查询
	public List<T> selectFieldByConition(String sql,List<Object> params);
	//自定义查询单条Sql
	public List<Object[]> findByCustomSql(String sql);



	public List<Object[]> findListBySql2(String sql);
	public List<PkfInformationEntity> findListBySql3(String sql);
	public T findBySql2(String sql);
	public List<PkfAllEntity> findListBySql4(String sql);
	public List findListBySql5(String sql);
	public T findByCardId(String cardId);

}
