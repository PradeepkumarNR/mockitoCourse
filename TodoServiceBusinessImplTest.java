package com.sg.mockito.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.sg.mockito.api.TodoService;
import com.sg.mockito.api.TodoServiceStubbed;

public class TodoServiceBusinessImplTest {

	@Test
	public void test() {
		
		TodoService todoserviceisStubbed = new TodoServiceStubbed();
		
		TodoBusinessImpl todobusinessimpl = new TodoBusinessImpl(todoserviceisStubbed);
		
		List <String> resultedList= todobusinessimpl.retrieveTodosRelatedToSpring("anyone");
		assertEquals(3, resultedList.size());
	}

}
