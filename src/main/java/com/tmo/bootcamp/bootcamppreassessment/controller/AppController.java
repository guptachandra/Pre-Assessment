package com.tmo.bootcamp.bootcamppreassessment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmo.bootcamp.model.AddTenResponse;

@RestController
public class AppController {
		
	
	@GetMapping(value = "/hello")
	public String hello() {
		return "Hello Pre-Assessment";
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
	
}
