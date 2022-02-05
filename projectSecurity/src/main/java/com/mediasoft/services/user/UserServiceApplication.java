package com.mediasoft.services.user;

import com.mediasoft.services.user.domain.Role;
import com.mediasoft.services.user.domain.User;
import com.mediasoft.services.user.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
//
//	@Bean
//	CommandLineRunner run(UserService userService) {
//		return args -> {
//			userService.saveRole(new Role(null, "ROLE_USER"));
//			userService.saveRole(new Role(null, "ROLE_ADMIN"));
//			userService.saveRole(new Role(null, "ROLE_MANAGER"));
//
//			userService.saveUser(new User(null, "Caspar Lee", "casplee@yahoo.com","marklee","1234",new ArrayList<>()));
//			userService.saveUser(new User(null, "Zoe Sugg", "zoesugg@gmail.com","zoesugg","password2",new ArrayList<>()));
//			userService.saveUser(new User(null, "Pew Die Pie", "pewdiepie@yahoo.com","pewdiepie","password3",new ArrayList<>()));
//			userService.saveUser(new User(null, "Jenna Marbles", "jennamar@gmail.com","manager1234","manager1", new ArrayList<>()));
//			userService.saveUser(new User(null, "Joe Sugg", "joesugg@yahoo.com","admin1234","admin1",new ArrayList<>()));
//
//			userService.addRoleToUser("marklee", "ROLE_USER");
//
//			userService.addRoleToUser("zoesugg", "ROLE_USER");
//
//			userService.addRoleToUser("pewdiepie", "ROLE_MANAGER");
//			userService.addRoleToUser("pewdiepie", "ROLE_USER");
//
//			userService.addRoleToUser("manager1234", "ROLE_MANAGER");
//			userService.addRoleToUser("manager1234", "ROLE_USER");
//
//			userService.addRoleToUser("admin1234", "ROLE_ADMIN");
//			userService.addRoleToUser("admin1234", "ROLE_USER");
//
//
//
//		};
//	}
}
