package io.pivotal.tg;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
public class DojoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DojoApplication.class, args);
	}

	private Log log = LogFactory.getLog(getClass());

	@Bean
	CommandLineRunner seed(TechniqueRepo rr) {
		return args -> {

			rr.deleteAll();

			Arrays.asList("omoplata,bjj","de la riva,bjj", "seoi nage,judo").stream()
					.map(s -> s.split(","))
					.forEach(namePair -> rr.save(new Technique(namePair[0], namePair[1])));

			log.info("Loaded techniques.");
		};
	}
}
