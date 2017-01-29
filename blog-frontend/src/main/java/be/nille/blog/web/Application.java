package be.nille.blog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class})
@ComponentScan(basePackages = {"be.nille.blog.web"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
