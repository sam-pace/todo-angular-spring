package com.samuelpace.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samuelpace.todo.domain.Todo;
import com.samuelpace.todo.repositorys.TodoRepo;

@Service
public class DbService {

	@Autowired
	private TodoRepo todoRepository;

	public void instanciaBaseDeDados() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todo t1 = new Todo(null, "Estudar", "Springboot", sdf.parse("25/03/2023"), true);
		Todo t2 = new Todo(null, "Seila", "AGAGDGADGAGAHSGCHSHGCHAGFJFHAGCHSGHCASFWYUCBSACAFBEIF", sdf.parse("25/03/2023"), true);
		Todo t3 = new Todo(null, "Teste", "Teste", sdf.parse("25/03/2023"), false);
		Todo t4 = new Todo(null, "Teste", "Teste", sdf.parse("26/03/2023"), false);


		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}
