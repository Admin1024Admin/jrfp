package com.ky.ct.rzdj.dao;

import com.ky.ct.rzdj.model.PkfAllEntity;
import com.ky.ct.rzdj.model.PkfInformationEntity;
import com.ky.ct.rzdj.util.ClassUtil;
import org.hibernate.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Repository("baseDao")
// 持久层自动配置并命名为baseDao
public class BaseDaoImpl<T> implements BaseDao<T> {

	// 装配属性
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private SessionFactory sessionFactory;

	protected Class<T> entityClazz;

	// 在未编译前确定泛型的真实类型
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public BaseDaoImpl() {
		Class c = this.getClass(); // 获取泛型类
		Type t = c.getGenericSuperclass(); // getGenericSuperclass()获得带有泛型的父类，Type是java所有类型的公共接口
		if (t instanceof ParameterizedType) {
			Type[] p = ((ParameterizedType) t).getActualTypeArguments();
			this.entityClazz = (Class<T>) p[0]; // 截取第一个，就是泛型的真实类型
		}
	}

	public boolean add(T t) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			session.save(t);
			trans.commit();
			return true;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}
//	//批量保存
//	public boolean addFpxexd(List<T> t) {
//		Session session = null;
//		Transaction trans = null;
//		try {
//			session = sessionFactory.openSession();
//			trans = session.beginTransaction();
//			for(int i=0;i<t.size();i++){
//
//			}
//			session.save(t);
//			trans.commit();
//			return true;
//		} finally {
//			if (trans.getStatus().canRollback())
//				trans.rollback();
//			if (session != null)
//				session.close();
//		}
//	}

	public boolean delete(T t) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			t = (T) session.merge(t);
			session.delete(t);
			trans.commit();
			return true;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}

	public boolean deleteById(Serializable id) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from "
					+ entityClazz.getSimpleName() + " where id = ?0");
			query.setParameter("0", id);
			T t = (T) query.uniqueResult();
			trans = session.beginTransaction();
			session.delete(t);
			trans.commit();
			return true;
		} finally {
			if (trans != null && trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}

	public boolean deleteByCardId(Serializable id) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from "
					+ entityClazz.getSimpleName() + " where cardId = ?0");
			query.setParameter("0", id);
			T t = (T) query.uniqueResult();
			trans = session.beginTransaction();
			session.delete(t);
			trans.commit();
			return true;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}
	public boolean update(T t) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			session.update(t);
			trans.commit();
			return true;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}

	public boolean saveOrUpdate(T t) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			session.saveOrUpdate(t);
			trans.commit();
			return true;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}

	public T findById(Serializable id) {
		Session session = null;
		Transaction trans = null;
		try {
			session = this.sessionFactory.openSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from " + entityClazz.getSimpleName() + " where id = ?0");
			query.setParameter("0", id);
			T t = (T)query.uniqueResult();
			trans.commit();
			return t;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

	public T findByNo(String fieldName,Serializable id) {
		Session session = null;
		Transaction trans = null;
		try {
			session = this.sessionFactory.openSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from " + entityClazz.getSimpleName() + " where "+fieldName+" = ?0");
			query.setParameter("0", id);
			T t = (T)query.uniqueResult();
			trans.commit();
			return t;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = null;
		Transaction trans = null;
		try {
			session = this.sessionFactory.openSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from " + entityClazz.getSimpleName());
			List<T> result = query.list();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> findPage(final int page, final int length) {
		@SuppressWarnings({ "rawtypes" })
		List<T> list = (List<T>) this.hibernateTemplate.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Query query = session.createQuery("from "
						+ entityClazz.getSimpleName());
				query.setFirstResult((page - 1) * length); // 设置分页页码
				query.setMaxResults(length);
				List list = query.list();
				if (session != null)
					session.close();
				return list;
			}
		});

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<T> findPage(int page, int length, Map<String, Object> pram) {
		List<T> result = null;
		Session session = null;
		try {
			String hql = "from " + this.entityClazz.getSimpleName()
					+ " where 1=1 and "; // 初始化hql
			session = this.sessionFactory.openSession(); // 获取连接
			if (!pram.isEmpty()) // 判断有无条件
			{
				Iterator<String> it = pram.keySet().iterator(); // 迭代map
				while (it.hasNext()) {
					String key = it.next(); // 获取条件map中的key，即条件字段
					hql = hql + key + " like " + "'%" + pram.get(key) + "%'"
							+ " and "; // 将字段和模糊值拼接成hql
				}
			}

			hql += " 2=2"; // 在hql末尾加上 2=2,方便hql再次拼接
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setFirstResult((page - 1) * length); // 设置分页页码
			query.setMaxResults(length); // 设置每页数据长度
			result = query.list(); // 返回结果集

		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (session != null)
				session.close();
		}

		return result;

	}

	// 模糊匹配所有字段
	@SuppressWarnings("unchecked")
	public List<T> findPage(int page, int length, String pram) {
		List<T> result = null;
		Session session = null;
		try {
			String hql = "from " + this.entityClazz.getSimpleName()
					+ " where 1=1 and "; // 初始化hql
			session = this.sessionFactory.openSession(); // 获取连接
			if (!pram.isEmpty()) // 判断有无条件
			{
				String columns = ClassUtil.loadField(this.entityClazz); // 获取类中属性并格式化
				hql = hql + "concat(" + columns + ") like '%" + pram + "%' and";
			}

			hql += " 2=2"; // 在hql末尾加上 2=2,方便hql再次拼接
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setFirstResult((page - 1) * length); // 设置分页页码
			query.setMaxResults(length); // 设置每页数据长度
			result = query.list(); // 返回结果集

		} catch (RuntimeException re)

		{
			throw re;
		} finally {
			if (session != null)
				session.close();
		}

		return result;

	}

	// 多条件分页查询
	public List<T> findPage(int page, int length, String pram,
			Map<String, Object> map) {
		List<T> result = null;
		Session session = null;
		try {
			String hql = "from " + this.entityClazz.getSimpleName()
					+ " where 1=1 and "; // 初始化hql
			session = this.sessionFactory.openSession(); // 获取连接
			if (!pram.isEmpty()) // 判断有无条件
			{
				String columns = ClassUtil.loadField(this.entityClazz); // 获取类中属性并格式化
				hql = hql + "concat(" + columns + ") like '%" + pram
						+ "%' and ";
			}

			if (!map.isEmpty()) // 判断有无条件
			{
				Iterator<String> it = map.keySet().iterator(); // 迭代map
				while (it.hasNext()) {
					String key = it.next(); // 获取条件map中的key，即条件字段
					hql = hql + key + " = " + "'" + map.get(key) + "'"
							+ " and "; // 将字段和模糊值拼接成hql
				}
			}

			hql += " 2=2"; // 在hql末尾加上 2=2,方便hql再次拼接
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setFirstResult((page - 1) * length); // 设置分页页码
			query.setMaxResults(length); // 设置每页数据长度
			result = query.list(); // 返回结果集

		} catch (RuntimeException re)

		{
			throw re;
		} finally {
			if (session != null)
				session.close();
		}

		return result;
	}

	// 普通求和
	public Object getCount() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select count(*) from "
				+ entityClazz.getSimpleName());
		Object result = query.uniqueResult();
		if (session != null)
			session.close();
		return result;
	}

	// 按条件求和
	public Object getCount(Map<String, Object> map) {
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from " + entityClazz.getSimpleName()
				+ " where 1=1 and ";
		if (!map.isEmpty()) // 判断有无条件
		{
			Iterator<String> it = map.keySet().iterator(); // 迭代map
			while (it.hasNext()) {
				String key = it.next(); // 获取条件map中的key，即条件字段
				hql = hql + key + " = " + "'" + map.get(key) + "'" + " and "; // 将字段和模糊值拼接成hql
			}
		}
		hql += " 2=2";
		Query query = session.createQuery(hql);
		Object result = query.uniqueResult();
		if (session != null)
			session.close();
		return result;
	}

	public List<T> findPageByCondition(int page, int length,
			Map<String, Object> pram) {
		List<T> result = null;
		Session session = null;
		try {
			String hql = "from " + this.entityClazz.getSimpleName()
					+ " where 1=1 and "; // 初始化hql
			session = this.sessionFactory.openSession(); // 获取连接
			if (!pram.isEmpty()) // 判断有无条件
			{
				Iterator<String> it = pram.keySet().iterator(); // 迭代map
				while (it.hasNext()) {
					String key = it.next(); // 获取条件map中的key，即条件字段
					hql = hql + key + " = " + "'" + pram.get(key) + "'"
							+ " and "; // 将字段和模糊值拼接成hql
				}
			}

			hql += " 2=2"; // 在hql末尾加上 2=2,方便hql再次拼接
			System.out.println(hql);
			Query query = session.createQuery(hql);
			query.setFirstResult((page - 1) * length); // 设置分页页码
			query.setMaxResults(length); // 设置每页数据长度
			result = query.list(); // 返回结果集

		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (session != null)
				session.close();
		}

		return result;
	}

	/**
	 * 查询条件的所有数据
	 */
	public List<T> findByCondition(Map<String, Object> pram) {
		List<T> result = null;
		Session session = null;
		try {
			String hql = "from " + this.entityClazz.getSimpleName()
					+ " where 1=1 and "; // 初始化hql
			session = this.sessionFactory.openSession(); // 获取连接
			if (!pram.isEmpty()) // 判断有无条件
			{
				Iterator<String> it = pram.keySet().iterator(); // 迭代map
				while (it.hasNext()) {
					String key = it.next(); // 获取条件map中的key，即条件字段
					hql = hql + key + " = " + "'" + pram.get(key) + "'"
							+ " and "; // 将字段和模糊值拼接成hql
				}
			}

			hql += " 2=2"; // 在hql末尾加上 2=2,方便hql再次拼接
			System.out.println(hql);
			Query query = session.createQuery(hql);
			result = query.list(); // 返回结果集

		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (session != null)
				session.close();
		}

		return result;
	}


	public T findBySql(String sql, Map<String, Object> condition) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(entityClazz);
			for (Entry<String, Object> entry : condition.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			T result = (T) query.uniqueResult();
			trans.commit();
			return result;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}

	public T findBySql(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(entityClazz);
			T result = (T) query.uniqueResult();
			trans.commit();
			return result;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}

	public List<T> findAll(Map<String, Object> condition) {
		List<T> result = null;
		Session session = null;
		try {
			String hql = "from " + this.entityClazz.getSimpleName()
					+ " where 1=1 and "; // 初始化hql
			session = this.sessionFactory.openSession(); // 获取连接
			if (!condition.isEmpty()) // 判断有无条件
			{
				Iterator<String> it = condition.keySet().iterator(); // 迭代map
				while (it.hasNext()) {
					String key = it.next(); // 获取条件map中的key，即条件字段
					hql = hql + key + " = " + "'" + condition.get(key) + "'"
							+ " and "; // 将字段和模糊值拼接成hql
				}
			}

			hql += " 2=2"; // 在hql末尾加上 2=2,方便hql再次拼接
			System.out.println(hql);
			Query query = session.createQuery(hql);
			result = query.list(); // 返回结果集

		} catch (RuntimeException re) {
			throw re;
		} finally {
			if (session != null)
				session.close();
		}

		return result;
	}

	public Object getCount(String column) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select sum("+column+") from "
				+ entityClazz.getSimpleName());
		Object result = query.uniqueResult();
		if (session != null)
			session.close();
		return result;
	}

	public Object getAvg(String column) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select avg("+column+") from "
				+ entityClazz.getSimpleName());
		Object result = query.uniqueResult();
		if (session != null)
			session.close();
		return result;
	}

	public Object getCountByConition(Map<String, Object> map) {
		Session session = sessionFactory.openSession();
		String hql = "select count(*) from " + entityClazz.getSimpleName()
				+ " where 1=1 and ";
		if (!map.isEmpty()) // 判断有无条件
		{
			Iterator<String> it = map.keySet().iterator(); // 迭代map
			while (it.hasNext()) {
				String key = it.next(); // 获取条件map中的key，即条件字段
				hql = hql + key + map.get(key) + " and "; // 将字段和模糊值拼接成hql
			}
		}
		hql += " 2=2";
		Query query = session.createQuery(hql);
		Object result = query.uniqueResult();
		if (session != null)
			session.close();
		return result;
	}

	public Object countBySql(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			Object result = query.uniqueResult();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

	public Object exec(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			Object result = query.executeUpdate();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

	@Override
	public List<T> findListBySql(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(entityClazz);
			List<T> result = query.list();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}
	/**
	 * 选择字段查询
	 */
	@Override
	public List<T> selectFieldByConition(String sql,List<Object> params){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		for(int i=0;i<params.size();i++){
			query.setParameter(i,params.get(i));
		}
		List<T> result = query.list();
		if (session != null)
			session.close();
		return result;
	}

	/**
	 * 自定义查询单条Sql
	 * @param sql
	 * @return
	 */
	public List<Object[]> findByCustomSql(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> result = query.list();
			trans.commit();
			return result;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}


	/**
	 * 废弃的
	 */
	@Override
	public List<Object[]> findListBySql2(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			List<Object[]> result = query.list();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

	@Override
	public List<PkfInformationEntity> findListBySql3(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(sql);
			List<PkfInformationEntity> result = query.list();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}
	@Override
	public List<PkfAllEntity> findListBySql4(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			Query query = session.createQuery(sql);
			List<PkfAllEntity> result = query.list();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

	@Override
	public List findListBySql5(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Transformers.aliasToBean(PkfAllEntity.class));
			List result = query.list();
			trans.commit();
			return result;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}
	@Override
	public T findBySql2(String sql) {
		Session session = null;
		Transaction trans = null;
		try {
			session = sessionFactory.openSession();
			trans = session.beginTransaction();
			SQLQuery query = session.createSQLQuery(sql);
			T result = (T) query.uniqueResult();
			trans.commit();
			return result;
		} finally {
			if (trans.getStatus().canRollback())
				trans.rollback();
			if (session != null)
				session.close();
		}
	}
	@Override
	public T findByCardId(String cardId) {
		Session session = null;
		Transaction trans = null;
		try {
			session = this.sessionFactory.openSession();
			trans = session.beginTransaction();
			Query query = session.createQuery("from " + entityClazz.getSimpleName() + " where cardId = ?0");
			query.setParameter("0", cardId);
			T t = (T)query.uniqueResult();
			trans.commit();
			return t;
		}
		finally {
			if (trans.getStatus().canRollback()) trans.rollback();
			if (session != null) session.close();
		}
	}

};
