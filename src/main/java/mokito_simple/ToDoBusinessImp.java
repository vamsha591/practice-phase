package mokito_simple;

import java.util.ArrayList;
import java.util.List;

public class ToDoBusinessImp {
	private ToDoService service;
	public ToDoBusinessImp(ToDoService service) {
		this.service=service;
	}
	
	public List<String> retriveTodoRelatedToSpring(String user)
	{
		List<String> filteredToDo=new ArrayList<String>();
		List<String> allToDo=service.retriveTodo(user);
		for(String toDo:allToDo)
			if(toDo.contains("Spring"))
				filteredToDo.add(toDo);
		return filteredToDo;
		
	}
}
