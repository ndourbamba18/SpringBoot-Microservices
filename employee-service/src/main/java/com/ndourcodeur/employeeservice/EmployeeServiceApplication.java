package com.ndourcodeur.employeeservice;

import com.ndourcodeur.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class EmployeeServiceApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
		return args -> {
			employeeRepository.save(new Employee(null, "Bamba", "Ndour", "ndourbamba@gmail.com", "+221778542104", "UI", "Dakar"));
			employeeRepository.save(new Employee(null, "Khadim", "Diouf", "dioufkhadim@test.io", "+221778542145", "Dev Ops", "Dakar"));
			employeeRepository.save(new Employee(null, "Ndour", "Codeur", "ndourcodeur@gmail.com", "+221776532666", "Backend Developer", "Dakar, Senegal"));
			employeeRepository.save(new Employee(null, "Maimouna", "Badje", "badjemaimouna@test.io", "+221776548921", "Java Developer", "Dakar"));
			employeeRepository.save(new Employee(null, "Camou", "Sanokho", "sanokhocamou@test.io", "+22178542654", "Frontend Developer", "Dakar, Senegal"));
		};
	}*/

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
