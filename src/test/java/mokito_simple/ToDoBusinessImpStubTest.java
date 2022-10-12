package mokito_simple;
import static org.junit.Assert.assertEquals;
import java.util.List;

import javax.print.attribute.standard.Sides;

import org.junit.Test;

public class ToDoBusinessImpStubTest {
	private ToDoBusinessImp toDoBusinessImp;

	@Test
	public void usingAStub()
	{
		ToDoService toDoService=new ToDoServiceStub();
		toDoBusinessImp = new ToDoBusinessImp(toDoService);
		List<String> todo=toDoBusinessImp.retriveTodoRelatedToSpring("");
		assertEquals(2,todo.size());
	
	}
}
