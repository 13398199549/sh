package org.framestudy.sh.usermag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.sh.bean.PagerBean;
import org.framestudy.sh.bean.UserBean;
import org.framestudy.sh.usermag.dao.IUserDao;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层实现类
 * 
 * @author puxubo
 *
 */
@Repository
public class UserDaoImpl implements IUserDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
	}

	@Override
	public void updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(user);
	}

	@Override
	public void deleteUserBean(UserBean user) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(user);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return (UserBean) hibernateTemplate.get(UserBean.class, id);
	}

	@Override
	public UserBean loadUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return (UserBean) hibernateTemplate.load(UserBean.class, id);
	}

	@Override
	public List<?> listUserBeanByUserNameAndLoginName(String userName, String loginName) {
		// TODO Auto-generated method stub
		// 按照参数位置传值方案（起始位置:0）

		String hql = "from UserBean as u where u.userName like CONCAT(?,'%') and u.loginName = ?";
		return hibernateTemplate.find(hql, new Object[] { userName, loginName });
		
		// 按照参数别名的方式来完成传值
		// String hql = "from UserBean as u where u.userName like CONCAT(:userName,'%')
		// and u.loginName = :loginName";
		
		
		// return hibernateTemplate.findByNamedParam(hql,new String[] {"userName","loginName"},new
		// Object[] {userName,loginName});
	}
	/**
	 * 如果是按照“参数命名”的方式，来完成参数的设置的话，那么请调用findByNamedParam()
	 */
	@Override
	public List<?> listUserBeanByObject(UserBean user) {
		// TODO Auto-generated method stub
		String hql = "from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
		return hibernateTemplate.findByNamedParam(hql, new String[] {"userName","loginName"},new Object[] {user.getUserName(),user.getLoginName()});
		
	}

	@Override
	public List<?> listUserBeanByParams(Map params) {
		// TODO Auto-generated method stub
		// 不推荐（缺陷：需要过多的维护构造函数）
		// String hql = "select new UserBean(u.id,u.userName) from UserBean as u where
		// u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";

		String hql = "select new map(u.id as id,u.userName as userName) from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
		return hibernateTemplate.findByNamedParam(hql, new String[] {"userName","loginName"},new Object[] {params.get("userName"),params.get("loginName")});
	}

	@SuppressWarnings("unchecked")
	@Override
	public PagerBean listUserBeanByParams2PagerBean(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		return (PagerBean) hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "select count(*) from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
				Query query = session.createQuery(hql);// 预编译
				query.setProperties(params);

				// 根据id得类型，来定义总条数的类型
				long totalRows = (long) query.uniqueResult();// 总条数
				List<?> datas = null;
				if (totalRows != 0) {
					// -----------------查询具体的数据------------------
					hql = "select new map(u.id as id,u.userName as userName) from UserBean as u where u.userName like CONCAT(:userName,'%') and u.loginName = :loginName";
					query = session.createQuery(hql);// 预编译
					query.setProperties(params);

					query.setFirstResult(pager.getIndex());// 分页的起始位置
					query.setMaxResults(pager.getRows());// 分页的每页行数
					datas = query.list();// 具体的数据
				}
				pager.setTotalRows((int) totalRows);
				pager.setDatas(datas);
				return pager;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public PagerBean listUserBeanByParmas2PagerBean4CriteriaDemo(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		return (PagerBean) hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Criteria criteria = session.createCriteria(UserBean.class);
				// ----------添加查询条件----------
				criteria.add(Restrictions.like("userName", params.get("userName").toString(), MatchMode.START)); // where
																													// asdfsadf
				criteria.add(Restrictions.eq("loginName", params.get("loginName").toString()));
				criteria.add(Restrictions.between("id", 20L, 60L));
				criteria.addOrder(Order.desc("createTime"));
				// ----------添加查询条件 end----------
				// ----------添加统计投影--------------
				criteria.setProjection(Projections.rowCount());

				// 根据id得类型，来定义总条数的类型,得到满足条件的总条数
				long totalRows = (long) criteria.uniqueResult();
				List<?> datas = null;
				if (totalRows != 0) {
					criteria.setProjection(null);// 去掉统计投影
					criteria.setFirstResult(pager.getIndex());// 分页的起始位置
					criteria.setMaxResults(pager.getRows());// 分页的每页行数
					datas = criteria.list();
				}

				pager.setTotalRows((int) totalRows);
				pager.setDatas(datas);
				
				return pager;
			}
			
		});
	}

	@Override
	public List<?> listUserBeanByIdcard(String idcard) {
		// TODO Auto-generated method stub
		// left join fetch 代表将"被关联对象"，作为关联对象的属性，而不需要作为一个需要被返回的独立对象
		// String hql = "From UserBean as u left join fetch u.userInfo as ui where
		// ui.idCard like CONCAT(?,'%') ";
		
		// 但是如果需要实现按需查询，需要去掉fetch
		String hql = "select new map(u.userName as userName,ui.idCard as idCard) From UserBean as u left join u.userInfo as ui where ui.idCard like CONCAT(?,'%')";
		return hibernateTemplate.find(hql, idcard);
	}

}
