package org.framestudy.sh.usermag.service;

import java.util.List;
import java.util.Map;

import org.framestudy.sh.bean.PagerBean;
import org.framestudy.sh.bean.UserBean;

/**
 * 用户业务层接口
 * @author puxubo
 *
 */
public interface IUserService {
	/**
	 * 新增用户
	 * @param user
	 */
	void saveUserBean(UserBean user);
	/**
	 * 修改用户
	 * @param user
	 */
	void updateUserBean(UserBean user);
	/**
	 * 删除用户
	 * @param user
	 */
	void deleteUserBean(UserBean user);
	/**
	 * 查询用户
	 * @param user
	 */
	UserBean getUserBeanById(Long id);
	/**
	 * 查询用户
	 * @param user
	 */
	UserBean loadUserBeanById(Long id);
	
	/**
	 * 根据用户名和登录名查询用户
	 * @param userName
	 * @param loginName
	 * @return
	 */
	List<?> listUserBeanByUserNameAndLoginName(String userName,String loginName);
	/**
	 * 
	 * 根据多参数，完成对用户的查询
	 * @param user
	 * @return
	 */
	List<?> listUserBeanByObject(UserBean user);
	
	/**
	 * 根据多参数，完成对用户的查询
	 * @param params
	 * @return
	 */
	List<?> listUserBeanByParams(Map params);
	/**
	 * 根据多参数，完成对用户的分页查询
	 * @param params
	 * @param pager
	 * @return
	 */
	PagerBean listUserBeanByParams2PagerBean(Map params,PagerBean pager);
	/**
	 * 根据多参数，完成对用户的分页查询
	 * @param params
	 * @param pager
	 * @return
	 */
	PagerBean listUserBeanByParmas2PagerBean4CriteriaDemo(Map params,PagerBean pager);
	
	/**
	 * 根据身份证查询用户
	 * @param idcard
	 * @return
	 */
	List<?> listUserBeanByIdcard(String idcard);
	
	
	
	
	
	
	
}
