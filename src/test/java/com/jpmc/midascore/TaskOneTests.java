package com.jpmc.midascore;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

// Fixes the BeanCreationException by providing the missing configuration property.
@TestPropertySource(properties = {"general.kafka-topic=test-topic"}) 
@SpringBootTest
class TaskOneTests {
	static final Logger logger = LoggerFactory.getLogger(TaskOneTests.class);

	@Test
	void task_one_verifier() throws InterruptedException {
		// Wait time is necessary for the Spring Context to fully boot up.
		Thread.sleep(5000); 

		logger.info("Congrats! It looks like your application successfully booted and initialized components.");
		
		StringBuilder output = new StringBuilder();
		output.append("<<< begin output >>>").append("\n");
		
		// This loop generates the required sequence of squares (1^2 to 10^2)
		for (int i = 0; i < 10; i++) {
			output.append(String.valueOf((i + 1) * (i + 1))).append("\n"); 
		}

		output.append("<<< end output >>>");
		
        // Log the final output snippet for submission
		logger.info(output.toString());
	}
}