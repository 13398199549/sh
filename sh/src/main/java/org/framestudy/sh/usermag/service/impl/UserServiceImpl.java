package org.framestudy.sh.usermag.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.sh.bean.PagerBean;
import org.framestudy.sh.bean.UserBean;
import org.framestudy.sh.usermag.dao.IUserDao;
import org.framestudy.sh.usermag.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDaoImpl;

	@Override
	public void saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.saveUserBean(user);
	}

	@Override
	public void updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.updateUserBean(user);
	}

	@Override
	public void deleteUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.deleteUserBean(user);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserBeanById(id);
	}

	@Override
	public UserBean loadUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.loadUserBeanById(id);
	}

	@Override
	public List<?> listUserBeanByUserNameAndLoginName(String userName, String loginName) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByUserNameAndLoginName(userName, loginName);
	}

	@Override
	public List<?> listUserBeanByObject(UserBean user) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByObject(user);
	}

	@Override
	public List<?> listUserBeanByParams(Map params) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByParams(params);
	}

	@Override
	public PagerBean listUserBeanByParams2PagerBean(Map params,PagerBean pager) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByParams2PagerBean(params, pager);
	}

	@Override
	public PagerBean listUserBeanByParmas2PagerBean4CriteriaDemo(Map params, PagerBean pager) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByParmas2PagerBean4CriteriaDemo(params, pager);
	}

	@Override
	public List<?> listUserBeanByIdcard(String idcard) {
		// TODO Auto-generated method stub
		return userDaoImpl.listUserBeanByIdcard(idcard);
	}

}
