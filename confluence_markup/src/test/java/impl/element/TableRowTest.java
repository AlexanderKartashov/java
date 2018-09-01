package impl.element;

import com.google.java.contract.PreconditionError;
import interfaces.IElement;
import interfaces.elements.ITableRow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TableRowTest
{
	@ParameterizedTest
	@ValueSource(ints = {-1, 0})
	void testConstructorContracts(int value)
	{
		assertThrows(PreconditionError.class, ()->new TableRow(value));
	}

	@Test
	void testFixedSizeRow()
	{
		ITableRow row = new TableRow(2);
		assertThrows(PreconditionError.class, ()->row.addItem(null));
		row.addItem(new IElement(){});
		row.addItem(new IElement(){});
		assertThrows(PreconditionError.class, ()->row.addItem(new IElement(){}));
	}
}