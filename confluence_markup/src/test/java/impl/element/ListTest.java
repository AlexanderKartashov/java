package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.immutable.IList;
import interfaces.elements.ListStyle;
import interfaces.elements.mutable.IMutableList;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ListTest
{
	@Test
	void testConstructorContract()
	{
		assertThrows(PreconditionError.class, ()->new List(null));
	}

	@Test
	void testAddItem()
	{
		IMutableList list = new List(ListStyle.Numbers);
		assertThrows(PreconditionError.class, ()->list.addItem(null));
		for(int i = 0; i < 1000; ++i)
		{
			list.addItem(Mockito.mock(IElement.class));
		}
	}
}