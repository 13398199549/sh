package org.framestudy.sh.m2mmag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.framestudy.sh.m2mmag.GameBean;
import org.framestudy.sh.m2mmag.service.IGameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class GameServiceImplTest {

	@Resource
	private IGameService gameServiceImpl; 
	
	
	@Test
	public void listGameBeanByPlayerName() {
		
		String playerName = "王";
		
		List<?> datas = gameServiceImpl.listGameBeanByPlayerName(playerName);
		System.out.println(datas);
	}
	
	@Test
	public void saveGame() {
		
		GameBean game = new GameBean();
		game.setGameName("王者荣耀");
		
		gameServiceImpl.saveGame(game);
	}
	
	
	
	
	
	
	
	
	
}
