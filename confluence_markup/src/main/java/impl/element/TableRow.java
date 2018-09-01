package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.ITableRow;
import interfaces.elements.TableRowStyle;

import java.util.Optional;

class TableRow extends ElementsCollection implements ITableRow
{
	private final TableRowStyle _style;

	@Requires({"maxRowsNumber > 0", "style != null"})
	public TableRow(int maxRowsNumber, TableRowStyle style)
	{
		super(Optional.of(maxRowsNumber));
		_style = style;
	}

	@Override
	public void addItem(IElement element)
	{
		add(element);
	}
}
