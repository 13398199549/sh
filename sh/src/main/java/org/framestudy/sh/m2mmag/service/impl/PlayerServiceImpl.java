package org.framestudy.sh.m2mmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.m2mmag.PlayerBean;
import org.framestudy.sh.m2mmag.dao.IPlayerDao;
import org.framestudy.sh.m2mmag.service.IPlayerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Resource
	private IPlayerDao playerDaoImpl;
	
	
	@Override
	public void savePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		playerDaoImpl.savePlayer(player);
	}

	@Override
	public void updatePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		playerDaoImpl.updatePlayer(player);
	}

	@Override
	public void deletePlayer(PlayerBean player) {
		// TODO Auto-generated method stub
		playerDaoImpl.deletePlayer(player);
	}

	@Override
	public PlayerBean getPlayerBeanById(Long id) {
		// TODO Auto-generated method stub
		return playerDaoImpl.getPlayerBeanById(id);
	}

	@Override
	public List<?> listPlayerBeanByGameName(String gameName) {
		// TODO Auto-generated method stub
		return playerDaoImpl.listPlayerBeanByGameName(gameName);
	}

}
