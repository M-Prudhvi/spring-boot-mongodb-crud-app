package com.example.mongoDB.springbootmongodbapp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMongodbAppApplicationTests {

	@Test
	void contextLoads() {
		Assert.assertTrue(true);
	}

}
