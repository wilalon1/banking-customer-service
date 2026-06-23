package com.banking.customerservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
		classes = CustomerServiceApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.NONE,
		properties = {
				"spring.cloud.config.enabled=false",
				"eureka.client.enabled=false",
				"spring.autoconfigure.exclude=" +
						"org.springframework.cloud.netflix.eureka.EurekaClientAutoConfiguration," +
						"org.springframework.cloud.config.client.ConfigClientAutoConfiguration," +
						"org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration"
		}
)
class CustomerServiceApplicationTests {

	@Test
	void contextLoads() {
	}
}