package org.framestudy.sh.extendmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.extendmag.DogBean;
import org.framestudy.sh.extendmag.dao.IPetDao;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PetDaoImpl implements IPetDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveDog(DogBean dog) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(dog);
	}

	@Override
	public void updateDog(DogBean dog) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(dog);
	}

	@Override
	public void deleteDog(DogBean dog) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(dog);
	}

	@Override
	public DogBean getDogBeanById(Long id) {
		// TODO Auto-generated method stub
		return (DogBean) hibernateTemplate.get(DogBean.class, id);
	}

	@Override
	public List<?> listAllPet() {
		// TODO Auto-generated method stub
		String hql = "From PetBean as p";
		//没有参数，那么参数位置，直接传递null完事
		return hibernateTemplate.find(hql, null);
	}

	@Override
	public List<?> listPetBeanByPetName(String petName) {
		// TODO Auto-generated method stub
		String hql = "From PetBean as p where p.petName like CONCAT(?,'%')";
		return hibernateTemplate.find(hql, petName);
	}

}
