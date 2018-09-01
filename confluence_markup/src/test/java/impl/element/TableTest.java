package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.immutable.ITable;
import interfaces.elements.TableRowStyle;
import interfaces.elements.mutable.IMutableTable;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TableTest
{
	@Test
	void testConstructorContract()
	{
		assertThrows(PreconditionError.class, ()->new Table(null));
		assertThrows(PreconditionError.class, ()->new Table(new IElement[]{}));
	}

	@Test
	void testAddRow()
	{
		IMutableTable table = new Table(new IElement[]{ Mockito.mock(IElement.class) });
		table.addRow(TableRowStyle.NotNew);
		assertThrows(PreconditionError.class, ()->table.addRow(null));
	}
}