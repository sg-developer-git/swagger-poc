package com.sg.poc.swagger.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.poc.swagger.pojo.Student;
import com.sg.poc.swagger.pojo.StudentRes;
import com.sg.poc.utility.config.UtilsConstant;
import com.sg.poc.utility.exception.model.ApiStatus;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/swagger/v1/student")
@RestController
public class Controller {

	@Operation(
			summary =" Add Student",
			description = "This API adds new student",
			tags = "Student")
	@ApiResponses(value= {
			@ApiResponse(
					responseCode = "201",
					description = "Student added"
			),
			@ApiResponse(
					responseCode = "400/500/503",
					description = "Validation Error / Service Error / Unhandled Error ",
					content = {
							@Content(
									mediaType = "application/json",
									schema = @Schema(implementation = ApiStatus.class))
			})
	})
	@PostMapping(
			path="/add",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentRes> addNewStudent(@Valid @RequestBody Student student){
		
		StudentRes response = new StudentRes();
		response.setStatus(new ApiStatus(null, "201", UtilsConstant.STATUS_SUCCESS, "Student Added", null));
		response.setStudent(student);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(response);
	}
}
