package org.framestudy.sh.o2mmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.o2mmag.ClassBean;
import org.framestudy.sh.o2mmag.dao.IClassDao;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDaoImpl implements IClassDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(cls);
	}

	@Override
	public void updateClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(cls);
	}

	@Override
	public ClassBean getClassBeanById(Long id) {
		// TODO Auto-generated method stub
		return (ClassBean) hibernateTemplate.get(ClassBean.class, id);
	}

	@Override
	public List<?> listClassBeanByStudentName(String studentName) {
		// TODO Auto-generated method stub
		String hql = "From ClassBean as c left join fetch c.students as s where s.studentName like CONCAT(?,'%')";
		return hibernateTemplate.find(hql, studentName);
	}

}
