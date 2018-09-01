package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.ITable;
import interfaces.elements.TableRowStyle;
import org.junit.jupiter.api.Test;

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
		ITable table = new Table(new IElement[]{new IElement() {}});
		table.addRow(TableRowStyle.NotNew);
		assertThrows(PreconditionError.class, ()->table.addRow(null));
	}
}