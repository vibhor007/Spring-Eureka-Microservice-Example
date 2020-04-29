package com.example.springeureka.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springeureka.client.model.Student;
/**
 * 
 * @author vibhor
 *
 */
@RestController
public class StudentServiceController {

	private static Map<String, List<Student>> schooDB = new HashMap<String, List<Student>>();

	static {
		schooDB = new HashMap<String, List<Student>>();

		List<Student> lst = new ArrayList<Student>();
		Student std = new Student("Sachin", "Class IV");
		lst.add(std);
		std = new Student("Dhoni", "Class V");
		lst.add(std);

		schooDB.put("oxfordschool", lst);

		lst = new ArrayList<Student>();
		std = new Student("Yuvraj", "Class III");
		lst.add(std);
		std = new Student("Prasant", "Class VI");
		lst.add(std);

		schooDB.put("qwertyschool", lst);

	}

	@RequestMapping(value = "/getStudentDetailsForSchool/{schoolname}", method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolname) {
		System.out.println("Getting Student details for " + schoolname);

		List<Student> studentList = schooDB.get(schoolname);
		if (studentList == null) {
			studentList = new ArrayList<Student>();
			Student std = new Student("Not Found", "N/A");
			studentList.add(std);
		}
		return studentList;
	}
}
