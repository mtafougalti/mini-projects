package com.mt.mp.myuniversity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mt.mp.myuniversity.repositories.StudentRepository;

@SpringBootApplication
public class MyUniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyUniversityApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(StudentRepository studentRepository) throws Exception {
		CommandLineRunner commandLineRunner = (args) -> {
//			List<Student> list = new ArrayList<>();
//			list.add(new Student("John", "SMITH", LocalDate.of(1990, 1, 25)));
//			list.add(new Student("Olivier", "SIMON", LocalDate.of(1995, 8, 25)));
//			list.add(new Student("Pascal", "LEGRAND", LocalDate.of(1997, 9, 25)));
//			studentRepository.saveAll(list);
		};
		return commandLineRunner;
    }

}
