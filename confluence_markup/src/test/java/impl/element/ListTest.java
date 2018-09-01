package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.IList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest
{
	@Test
	void testAddItem()
	{
		IList list = new List();
		assertThrows(PreconditionError.class, ()->list.addItem(null));
		for(int i = 0; i < 1000; ++i)
		{
			list.addItem(new IElement(){});
		}
	}
}