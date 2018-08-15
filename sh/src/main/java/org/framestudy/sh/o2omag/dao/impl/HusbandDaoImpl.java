package org.framestudy.sh.o2omag.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.sh.bean.PagerBean;
import org.framestudy.sh.o2omag.HusbandBean;
import org.framestudy.sh.o2omag.dao.IHusbandDao;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class HusbandDaoImpl implements IHusbandDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveHusband(HusbandBean husband) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(husband);
	}

	@Override
	public void udpateHusband(HusbandBean husband) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(husband);
	}

	@Override
	public void deleteHusband(HusbandBean husband) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(husband);
	}

	@Override
	public HusbandBean getHusbandById(String id) {
		// TODO Auto-generated method stub
		return (HusbandBean) hibernateTemplate.get(HusbandBean.class, id);
	}

	@Override
	public List<?> listHusbandByWifeName(String wifeName) {
		// TODO Auto-generated method stub
		String hql = "From HusbandBean as h left join fetch h.wife w where w.wifeName like CONCAT(?,'%')";		
		return hibernateTemplate.find(hql, wifeName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PagerBean listHusbandByParams2PagerBean(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		//使用count()请删除掉fetch,fetch在装载返回对象的时候，必须要有：关联对象，以及被关联的对象存在
		
		return (PagerBean) hibernateTemplate.execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				String hql = "select count(h) From HusbandBean as h left join h.wife w where w.wifeName like CONCAT(?,'%')";		
				Query query = session.createQuery(hql);
				query.setString(0, params.get("wifeName").toString());
				long totalRows = (long) query.uniqueResult();
				List<?> datas = null;
				if(totalRows > 0) {
					hql = "From HusbandBean as h left join fetch h.wife w where w.wifeName like CONCAT(?,'%')";		
					query = session.createQuery(hql);
					query.setString(0, params.get("wifeName").toString());
					query.setFirstResult(pager.getIndex());
					query.setMaxResults(pager.getRows());
					datas = query.list();
				}
				pager.setTotalRows((int)totalRows);
				pager.setDatas(datas);
				return pager;
			}
		});
		
		
		
		
	}

}
