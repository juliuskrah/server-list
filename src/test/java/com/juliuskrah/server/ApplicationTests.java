package com.juliuskrah.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.RequiredArgsConstructor;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = { @Autowired })
@ExtendWith(SpringExtension.class)
public class ApplicationTests {
	private final Application application;

	/**
	 * Parameters now accessible in JUnit Jupiter test cases
	 * 
	 * @param applicationContext
	 */
	@Test
	public void contextLoads(ApplicationContext applicationContext) {
		assertNotNull(applicationContext, "ApplicationContext should have been injected by Spring");
		assertEquals(this.application, applicationContext.getBean(Application.class));
	}

}
