package org.backend;

import org.backend.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void run(String... args) throws Exception {

//		Employee employee1 = Employee.builder()
//				.firstName("Хасенов")
//				.lastName("Аскар")
//				.phoneNum("4334324121")
//				.email("askar@mail.ru")
//				.country("Казахстан")
//				.city("Астана")
//				.build();
//
//		Employee employee2 = Employee.builder()
//				.firstName("Кенбаев")
//				.lastName("Арман")
//				.patronymic("")
//				.phoneNum("76545647621")
//				.email("arman@mail.ru")
//				.country("Казахстан")
//				.city("Астана")
//				.build();
//
//		Employee employee3 = Employee.builder()
//				.firstName("Джакупов")
//				.lastName("Ильяс")
//				.patronymic("")
//				.phoneNum("8987747621")
//				.email("ilias@mail.ru")
//				.country("Казахстан")
//				.city("Алматы")
//				.build();
//
//		employeeRepo.save(employee1);
//		employeeRepo.save(employee2);
//		employeeRepo.save(employee3);
	}
}
