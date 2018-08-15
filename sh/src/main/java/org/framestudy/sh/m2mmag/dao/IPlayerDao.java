package org.framestudy.sh.m2mmag.dao;

import java.util.List;

import org.framestudy.sh.m2mmag.PlayerBean;

public interface IPlayerDao {

	void savePlayer(PlayerBean player);
	
	void updatePlayer(PlayerBean player);
	
	void deletePlayer(PlayerBean player);
	
	PlayerBean getPlayerBeanById(Long id);
	
	List<?> listPlayerBeanByGameName(String gameName);
	
}
