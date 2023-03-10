package com.myshop.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@DisplayName("상품 등록 페이지 권한 테스트")
	@WithMockUser(username = "admin", roles = "ADMIN") //유저가 로그인된 상태로 테스트 할 수 있게 해준다.
	public void itemFormTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new"))
        .andDo(print())		//요청과 응답 메세지를 콘솔에서 출력
        .andExpect(status().isOk());		//응답 상태 코드가 정상인지 확인
		
	}
	
	@Test
	@DisplayName("상품 등록 페이지 일반회원 접근 테스트")
	@WithMockUser(username = "user", roles = "USER") //유저가 로그인된 상태로 테스트 할 수 있게 해준다.
	public void itemFormAdminTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/item/new"))
        .andDo(print())		//요청과 응답 메세지를 콘솔에서 출력	
        .andExpect(status().isForbidden());		//status = 403 forbidden 에외가 발생하면 테스트가 성공적으로 통과된다.
		
	}

}
