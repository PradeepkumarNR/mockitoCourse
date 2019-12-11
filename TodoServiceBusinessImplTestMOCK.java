package com.sg.mockito.business;

import static org.hamcrest.CoreMatchers.is;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import com.sg.mockito.api.TodoService;
import com.sg.mockito.api.TodoServiceStubbed;

public class TodoServiceBusinessImplTestMOCK {

	@Test
	public void testretrievedotolistusingMockForSpring() {

		TodoService todoservicemocked = mock(TodoService.class);
		List<String> expectedTodos = Arrays.asList("Spring zone", "Spring hight", "Springlime");

		when(todoservicemocked.retrieveTodos("anyone")).thenReturn(expectedTodos);

		TodoBusinessImpl todobusinessimpl = new TodoBusinessImpl(todoservicemocked);

		List<String> resultedList = todobusinessimpl.retrieveTodosRelatedToSpring("anyone");
		assertEquals(3, resultedList.size());
	}

	@Test
	public void toDoServiceinterfaceTestforSpringUsingBDD() {

		// Given
		TodoService todoservicemocked = mock(TodoService.class);
		List<String> expectedTodos = Arrays.asList("Spring zone", "Spring hight", "Springlime");

		given(todoservicemocked.retrieveTodos("anyone")).willReturn(expectedTodos);

		TodoBusinessImpl todobusinessimpl = new TodoBusinessImpl(todoservicemocked);
		// when
		List<String> resultedList = todobusinessimpl.retrieveTodosRelatedToSpring("anyone"); // then
		assertThat(resultedList.size(), is(3));
	}

	@Test
	public void testdeletetodothingsforNonSpringUsingBDD() {

		// Given
		TodoService todoservicemocked = mock(TodoService.class);
		List<String> expectedTodos = Arrays.asList("art", "Spring zone", "Spring hight", "Springlime", "notbelonging",
				"learn Spring mvc");
		given(todoservicemocked.retrieveTodos("anyone")).willReturn(expectedTodos);
		TodoBusinessImpl todobusinessimpl = new TodoBusinessImpl(todoservicemocked);

		// when
		todobusinessimpl.deleteToDoThingsNotRelatedToSprings("anyone");

		// then
		verify(todoservicemocked).deleteToDoThings("notbelonging");
		verify(todoservicemocked, never()).deleteToDoThings("Spring hight");

		// then in BDD way
		then(todoservicemocked).should().deleteToDoThings("notbelonging");
		then(todoservicemocked).should(never()).deleteToDoThings("Spring hight");

	}

	@Test
	public void testdeletetodothingsforNonSpringUsingBDDUsingArgumentCapture() {

		// Given
		ArgumentCaptor<String> stringargumentcaptor = ArgumentCaptor.forClass(String.class);
		TodoService todoservicemocked = mock(TodoService.class);
		List<String> expectedTodos = Arrays.asList( "Spring zone", "Spring hight", "Springlime", "notbelonging",
				"learn Spring mvc");
		given(todoservicemocked.retrieveTodos("anyone")).willReturn(expectedTodos);
		TodoBusinessImpl todobusinessimpl = new TodoBusinessImpl(todoservicemocked);

		// when
		todobusinessimpl.deleteToDoThingsNotRelatedToSprings("anyone");

		// then BDD way
		then(todoservicemocked).should().deleteToDoThings(stringargumentcaptor.capture());
		assertThat(stringargumentcaptor.getValue(), is("notbelonging"));

	}

	@Test
	public void testDeleteToDoThingsUsingAruguementCaptureForMultipleValues() {
		ArgumentCaptor<String> stringArguementCaptor = ArgumentCaptor.forClass(String.class);
		TodoService todoservicemocked = mock(TodoService.class);
		List<String> expectedList = Arrays.asList("art","Spring zone", "Spring hight", "Springlime", "notbelonging",
				"learn Spring mvc" );
		given(todoservicemocked.retrieveTodos("anyone")).willReturn(expectedList);
		TodoBusinessImpl todobusimpl= new TodoBusinessImpl(todoservicemocked);
		todobusimpl.deleteToDoThingsNotRelatedToSprings("anyone");
		then(todoservicemocked).should(times(2)).deleteToDoThings(stringArguementCaptor.capture());
		assertThat(stringArguementCaptor.getAllValues().size(),is(2));
		
		
	}
	}
