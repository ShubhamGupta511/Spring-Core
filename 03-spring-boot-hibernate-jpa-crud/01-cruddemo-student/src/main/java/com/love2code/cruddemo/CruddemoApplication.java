package com.love2code.cruddemo;

import com.love2code.cruddemo.dao.StudentDAO;
import com.love2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

			queryForStudents(studentDAO);
		};
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> sl=studentDAO.findAll();

		// display list of students
		for(Student st:sl){
			System.out.println(st);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a Student Object
		System.out.println("Creating the new Student Object...");
		Student st=new Student("Daffy","Gulfam","DF@TCS@gmail.com");

		// Save the Student
		System.out.println("Saving the student...");
		studentDAO.save(st);

		// display ID of the Saved Student
		int theId=st.getId();
		System.out.println("Saved Student with Id: "+ theId);

		// retreieve student based on the id primary key
		Student std=studentDAO.findById(theId);
		Student myStudent=studentDAO.findById(theId);


		// Display Student
		System.out.println("Found the Student: "+myStudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//Creating 3 Student objects
		System.out.println("Creating 3 Students Object...");
		Student s1=new Student("parul","sharma","ps@cognizant.com");
		Student s2=new Student("alaska","shobhit","as@cognizant.com");
		Student s3=new Student("amrul","dharma","sds@cognizant.com");

		// Saving the 3 Students Object
		studentDAO.save(s1);
		studentDAO.save(s2);
		studentDAO.save(s3);


		// Display the Student Id
		System.out.println("List of Student Id created: "+s1.getId()+" 2nd Student: "+s2.getId()+" 3rd Student"+s3.getId());

	}

	private void createStudent(StudentDAO studentDAO) {
		//Creating s Student
		System.out.println("Creating a Student Object ...");
		Student student=new Student("prakash","Gupta","pk@gmail.com");


		// Saving the Student
		System.out.println("Saving the Student ...");
		studentDAO.save(student);

		// Display ID of the Student
		System.out.println("Saved Student Generted Id: "+student.getId());
	}

}
