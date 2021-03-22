package com.tmo.bootcamp.bootcamppreassessment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmo.bootcamp.model.AddTenResponse;

@RestController
public class AppController {
	
	
	
	@GetMapping(value = "/")
	public String hello() {
		return "Hello Math Genius!!<br><br><br>"
				+ "Use /{number} to add 10<br><br>"
				+ "OR<br><br>"
				+ "Use /{number1}/{number2} to add them<br>";
	}

	@GetMapping(value = "/{number}")
	@ResponseBody
	public AddTenResponse addTen(@PathVariable("number") int number) {

		AddTenResponse response = new AddTenResponse();
		response.setSum(number + 10);

		return response;

	}
	
	@GetMapping(value = "/{num1}/{num2}")
	@ResponseBody
	public AddTenResponse addTwoParam(@PathVariable("num1") int num1, @PathVariable("num2") int num2) {

		AddTenResponse response = new AddTenResponse();
		response.setSum(num1 + num2);

		return response;

	}
	
	@ExceptionHandler(value = Throwable.class)
	   public ResponseEntity<Object> exception(Throwable exception) {
		  String text = "Please use a valid URL and make sure to use only integers in the input";
	      return new ResponseEntity<>(text, HttpStatus.NOT_FOUND);
	   }
}
