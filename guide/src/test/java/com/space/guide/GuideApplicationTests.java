package com.space.guide;

import com.space.guide.config.GalaxySymbolProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuideApplicationTests {

	@Autowired
	private GalaxySymbolProperties galaxySymbolProperties;

	@Test
	public void contextLoads() {

		final Integer symbolC = galaxySymbolProperties.getSymbolC();

		System.out.println(symbolC);

	}

}
