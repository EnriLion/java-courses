package dev.danvega.runnerz;

import dev.danvega.runnerz.run.Location;
import dev.danvega.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		//We can add a logger
		SpringApplication.run(Application.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

//		var welcomeMessage = new dev.danvega.runnerz.WelcomeMessage();
//		System.out.println(welcomeMessage.getWelcomeMessage());

//		dev.danvega.runnerz.WelcomeMessage welcomeMessage = context.getBean("welcomeMessage");
//		Object welcomeMessage = context.getBean("welcomeMessage");
//		WelcomeMessage welcomeMessage = (WelcomeMessage) context.getBean("welcomeMessage");
//		System.out.println(welcomeMessage);
//		log.info("Application started successfully!");
//		log.info("Something changed!");

	}
	@Bean
	CommandLineRunner runner(){
		return args -> {
			Run run = new Run(1,"First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS),5,Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}
}

