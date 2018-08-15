package org.framestudy.sh.o2mmag.service;

import java.util.List;

import org.framestudy.sh.o2mmag.ClassBean;

public interface IClassService {

	void saveClassBean(ClassBean cls);
	
	void updateClassBean(ClassBean cls);
	
	ClassBean getClassBeanById(Long id);
	
	List<?> listClassBeanByStudentName(String studentName);
	
}
