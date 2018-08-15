package org.framestudy.sh.m2mmag.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.m2mmag.GameBean;
import org.framestudy.sh.m2mmag.dao.IGameDao;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameDaoImpl implements IGameDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void saveGame(GameBean game) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(game);
	}

	@Override
	public GameBean getGameBeanById(Long id) {
		// TODO Auto-generated method stub
		return (GameBean) hibernateTemplate.get(GameBean.class, id);
	}

	@Override
	public List<?> listGameBeanByPlayerName(String playerName) {
		// TODO Auto-generated method stub
		String hql = "From GameBean as g left join fetch g.players as p where p.playerName like CONCAT(?,'%')";
		return hibernateTemplate.find(hql, playerName);
	}

}
