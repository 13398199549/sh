package org.framestudy.sh.extendmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.extendmag.DogBean;
import org.framestudy.sh.extendmag.dao.IPetDao;
import org.framestudy.sh.extendmag.service.IPetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements IPetService {

	@Resource
	private IPetDao petDaoImpl;
	
	@Override
	public void saveDog(DogBean dog) {
		// TODO Auto-generated method stub
		petDaoImpl.saveDog(dog);
	}

	@Override
	public void updateDog(DogBean dog) {
		// TODO Auto-generated method stub
		petDaoImpl.updateDog(dog);
	}

	@Override
	public void deleteDog(DogBean dog) {
		// TODO Auto-generated method stub
		petDaoImpl.deleteDog(dog);
	}

	@Override
	public DogBean getDogBeanById(Long id) {
		// TODO Auto-generated method stub
		return petDaoImpl.getDogBeanById(id);
	}

	@Override
	public List<?> listAllPet() {
		// TODO Auto-generated method stub
		return petDaoImpl.listAllPet();
	}

	@Override
	public List<?> listPetBeanByPetName(String petName) {
		// TODO Auto-generated method stub
		return petDaoImpl.listPetBeanByPetName(petName);
	}

}
