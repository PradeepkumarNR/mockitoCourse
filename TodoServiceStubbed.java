package com.sg.mockito.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStubbed implements TodoService{

	public List<String> retrieveTodos(String user) {
		// TODO Auto-generated method stub
		return Arrays.asList("Spring zone", "Spring hight", "Springlime");
	}

	public void deleteToDoThings(String user) {
		// TODO Auto-generated method stub
		
	}
	
	

}
