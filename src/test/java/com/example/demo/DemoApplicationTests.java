package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void sampleTest() {
		int sum = 2 + 2;
		assert(sum == 4);
	}

}
