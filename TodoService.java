package com.sg.mockito.api;

import java.util.List;

public interface TodoService {
	public List<String> retrieveTodos(String user);
	public void deleteToDoThings(String user);
}