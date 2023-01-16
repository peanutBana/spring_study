package com.myshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration		//스프링에서 설정 클래스로 사용하겠다는 annotation
@EnableWebSecurity	//springSecurityFilterChain이 자동으로 포함됨
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//http 요청에 대한 보안 설정 ex) 페이지 권한 설정, 로그인 페이지 설정, 로그아웃 메소드 등에 대한 설정
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {		//비밀번호 암호화를 위해서 사용하는 Bean
		return new BCryptPasswordEncoder();
	}
	
	
}
