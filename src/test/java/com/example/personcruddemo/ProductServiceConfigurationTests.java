
package com.example.personcruddemo;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.personcruddemo.service.PersonService;

@Configuration

@SpringBootTest
class ProductServiceConfigurationTests {

	@Bean
	@Primary
	public PersonService productService() {
		return Mockito.mock(PersonService.class);
	}
}
