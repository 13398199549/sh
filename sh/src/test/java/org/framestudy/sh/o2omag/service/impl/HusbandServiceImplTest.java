package org.framestudy.sh.o2omag.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.framestudy.sh.bean.PagerBean;
import org.framestudy.sh.o2omag.HusbandBean;
import org.framestudy.sh.o2omag.WifeBean;
import org.framestudy.sh.o2omag.service.IHusbandService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class HusbandServiceImplTest {

	@Resource
	private IHusbandService husbandServiceImpl;
	
	
	@Test
	public void listHusbandByParams2PagerBean() {
		
		Map params = new HashMap<>();
		params.put("wifeName", "小");
		PagerBean pager = new PagerBean(1, 5);
		pager = husbandServiceImpl.listHusbandByParams2PagerBean(params, pager);
		
		System.out.println(pager);
		
	}
	
	@Test
	public void listHusbandByWifeName() {
		String wifeName = "小";
		List<?> list = husbandServiceImpl.listHusbandByWifeName(wifeName);
		System.out.println(list);
		
	}
	
	
	@Test
	public void deleteHusband() {
		HusbandBean husband = husbandServiceImpl.getHusbandById("4028816164b577630164b577690a0000");
		Assert.assertNotNull(husband);
		husbandServiceImpl.deleteHusband(husband);
	}
	
	
	@Test
	public void updateHusband() {
		HusbandBean husband = husbandServiceImpl.getHusbandById("4028816164b577630164b577690a0000");
		
		
		Assert.assertNotNull(husband);
		WifeBean wife = husband.getWife();
		wife.setWifeName("小杨");
		husbandServiceImpl.udpateHusband(husband);
	}
	
	
	@Test
	public void saveHusband (){
		HusbandBean husband = new HusbandBean();
		husband.setHusbandName("小王2");
		
		WifeBean wife = new WifeBean();
		wife.setWifeName("小马2");
		
		//建立妻子和丈夫之间的关系
		husband.setWife(wife);
		wife.setHusband(husband);
		
		husbandServiceImpl.saveHusband(husband);
		
		
		
		
	}
	
	
	
}
