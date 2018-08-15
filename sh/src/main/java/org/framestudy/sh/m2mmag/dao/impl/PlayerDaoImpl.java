package org.framestudy.sh.m2mmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.m2mmag.PlayerBean;
import org.framestudy.sh.m2mmag.dao.IPlayerDao;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDaoImpl implements IPlayerDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void savePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(player);
	}

	@Override
	public void updatePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(player);
	}

	@Override
	public void deletePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(player);
	}

	@Override
	public PlayerBean getPlayerBeanById(Long id) {
		// TODO Auto-generated method stub
		return (PlayerBean) hibernateTemplate.get(PlayerBean.class, id);
	}

	@Override
	public List<?> listPlayerBeanByGameName(String gameName) {
		// TODO Auto-generated method stub
		String hql = "From PlayerBean as p left join fetch p.games as g where g.gameName like CONCAT(?,'%')";
		return hibernateTemplate.find(hql, gameName);
	}

}
