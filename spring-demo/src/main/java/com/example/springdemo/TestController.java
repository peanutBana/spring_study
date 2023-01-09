package com.example.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
	
	@GetMapping(value = "/test")
	public UserDto test() {
		UserDto userDto = new UserDto();
		userDto.setName("이미나");
		userDto.setAge(20); 
		System.out.println("객체 정보: " + userDto.toString());
		return userDto;
	}
}	
