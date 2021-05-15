package com.sg.poc.swagger.pojo;

import java.util.List;

import com.sg.poc.utility.exception.model.ApiStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentRes {

	private ApiStatus status;
	private Student student;
	private List<Student> studentList;
}
