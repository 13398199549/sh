package org.framestudy.sh.o2mmag.service;

import java.util.List;

import org.framestudy.sh.o2mmag.StudentBean;

public interface IStudentService {

	void saveStudent(StudentBean student);
	
	void updateStudent(StudentBean student);
	
	void deleteStudent(StudentBean student);
	
	StudentBean getStudentBeanById(Long id);
	
	List<?> listStudentByClassName(String className);
	
}
