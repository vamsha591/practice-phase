package mokito_simple;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ToDoServiceStub implements ToDoService {

	public List<String> retriveTodo(String user) {
		// TODO Auto-generated method stub
		List<String> array=new ArrayList<String>();
		array.add("Learn Spring core");
		array.add("Learn Spring mvc");
		array.add("Learn Spring boot");
		array.add("Learn Spring boot validation");
		return array;
	
	}

}
