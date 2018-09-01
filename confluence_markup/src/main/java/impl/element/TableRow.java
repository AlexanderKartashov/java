package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.ITableRow;

import java.util.Optional;

class TableRow extends ElementsCollection implements ITableRow
{
	@Requires("maxRowsNumber > 0")
	public TableRow(int maxRowsNumber)
	{
		super(Optional.of(maxRowsNumber));
	}

	@Override
	public void addItem(IElement element)
	{
		add(element);
	}
}
