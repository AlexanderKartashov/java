package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.immutable.ITableRow;
import interfaces.elements.TableRowStyle;
import interfaces.elements.mutable.IMutableTableRow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class TableRowTest
{
	@ParameterizedTest
	@ValueSource(ints = {-1, 0})
	void testConstructorContractsInvalidSize(int value)
	{
		assertThrows(PreconditionError.class, ()->new TableRow(value, TableRowStyle.NotNew));
	}

	@Test
	void testConstructorContractStyle()
	{
		assertThrows(PreconditionError.class, ()->new TableRow(1, null));
	}

	@Test
	void testFixedSizeRow()
	{
		IMutableTableRow row = new TableRow(2, TableRowStyle.NotNew);
		assertThrows(PreconditionError.class, ()->row.addItem(null));
		row.addItem(Mockito.mock(IElement.class));
		row.addItem(Mockito.mock(IElement.class));
		assertThrows(PreconditionError.class, ()->row.addItem(Mockito.mock(IElement.class)));
	}
}