package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.elements.TextStyle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TextTest
{
	@Test
	void testConstructorContract()
	{
		assertThrows(PreconditionError.class, ()-> new Text(null, null));
		assertThrows(PreconditionError.class, ()-> new Text(null, TextStyle.Header));
		assertThrows(PreconditionError.class, ()-> new Text("", null));
		assertThrows(PreconditionError.class, ()-> new Text("", TextStyle.Header));
		new Text("text", TextStyle.Header);
	}
}