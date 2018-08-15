package org.framestudy.sh.o2mmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.o2mmag.StudentBean;
import org.framestudy.sh.o2mmag.dao.IStudentDao;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDaoImpl implements IStudentDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveStudent(StudentBean student) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(student);
	}

	@Override
	public void updateStudent(StudentBean student) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(student);
	}

	@Override
	public void deleteStudent(StudentBean student) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(student);
	}

	@Override
	public StudentBean getStudentBeanById(Long id) {
		// TODO Auto-generated method stub
		return (StudentBean) hibernateTemplate.get(StudentBean.class, id);
	}

	@Override
	public List<?> listStudentByClassName(String className) {
		// TODO Auto-generated method stub
		String hql = "From StudentBean as s left join fetch s.cls as c where c.className like CONCAT(?,'%')";
		return hibernateTemplate.find(hql, className);
	}

}
