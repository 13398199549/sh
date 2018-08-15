package org.framestudy.sh.o2mmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.o2mmag.ClassBean;
import org.framestudy.sh.o2mmag.dao.IClassDao;
import org.framestudy.sh.o2mmag.service.IClassService;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements IClassService {

	@Resource
	private IClassDao classDaoImpl;
	
	@Override
	public void saveClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		classDaoImpl.saveClassBean(cls);
	}

	@Override
	public void updateClassBean(ClassBean cls) {
		// TODO Auto-generated method stub
		classDaoImpl.updateClassBean(cls);
	}

	@Override
	public ClassBean getClassBeanById(Long id) {
		// TODO Auto-generated method stub
		return classDaoImpl.getClassBeanById(id);
	}

	@Override
	public List<?> listClassBeanByStudentName(String studentName) {
		// TODO Auto-generated method stub
		return classDaoImpl.listClassBeanByStudentName(studentName);
	}

}
