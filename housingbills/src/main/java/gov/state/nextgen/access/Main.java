package gov.state.nextgen.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import gov.state.nextgen.access.business.rules.MessageTableService;

@SpringBootApplication
@Configuration
public class Main implements ApplicationRunner {

	@Autowired
	MessageTableService messageService;

	public static void main(String[] args) {
		System.setProperty("deployment.env.name", "loc");
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		messageService.loadMessageTable();

	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

}