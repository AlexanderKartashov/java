package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.ITableRow;
import interfaces.elements.TableRowStyle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
		ITableRow row = new TableRow(2, TableRowStyle.NotNew);
		assertThrows(PreconditionError.class, ()->row.addItem(null));
		row.addItem(new IElement(){});
		row.addItem(new IElement(){});
		assertThrows(PreconditionError.class, ()->row.addItem(new IElement(){}));
	}
}