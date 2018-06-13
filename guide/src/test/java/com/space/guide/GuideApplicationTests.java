package com.space.guide;

import com.space.guide.config.GalaxySymbol;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuideApplicationTests {


	@Test
	public void contextLoads() throws IOException {



		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("input.txt");

		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader reader = new BufferedReader(inputStreamReader);

		//String string = reader.readLine();

		Stream<String> lines = reader.lines();

	}




}
