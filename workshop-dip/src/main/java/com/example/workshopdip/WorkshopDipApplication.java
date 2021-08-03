package com.example.workshopdip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WorkshopDipApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(WorkshopDipApplication.class, args);
		System.out.println("Bean count=" + context.getBeanDefinitionCount());

		GenerateIdService service = context.getBean(GenerateIdService.class);
		String id = service.get();
		System.out.println("ID=" + id);
	}
}
