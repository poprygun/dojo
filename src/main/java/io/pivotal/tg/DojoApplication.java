package io.pivotal.tg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojoApplication.class, args);
	}

	private Log log = LogFactory.getLog(getClass());


}
