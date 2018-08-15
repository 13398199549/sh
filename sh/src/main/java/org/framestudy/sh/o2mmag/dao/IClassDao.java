package org.framestudy.sh.o2mmag.dao;

import java.util.List;

import org.framestudy.sh.o2mmag.ClassBean;

public interface IClassDao {

	void saveClassBean(ClassBean cls);
	
	void updateClassBean(ClassBean cls);
	
	ClassBean getClassBeanById(Long id);
	
	List<?> listClassBeanByStudentName(String studentName);
}
