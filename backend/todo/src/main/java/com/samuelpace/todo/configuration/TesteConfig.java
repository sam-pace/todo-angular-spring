package com.samuelpace.todo.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.samuelpace.todo.services.DbService;


@Configuration
@Profile("test")
public class TesteConfig {

	@Autowired
	private DbService dbService;

	@Bean
	public boolean instancia() throws ParseException {
		this.dbService.instanciaBaseDeDados();
		return true;
	}
	
	
}
