package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.elements.ToggleButtonState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToggleButtonTest
{
	@Test
	public void testConstructorContract()
	{
		assertThrows(PreconditionError.class, ()->new ToggleButton(null));
		new ToggleButton(ToggleButtonState.Red);
	}
}