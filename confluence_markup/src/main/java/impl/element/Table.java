package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.ITable;
import interfaces.elements.ITableRow;
import interfaces.elements.TableRowStyle;

import java.util.Optional;

class Table extends ElementsCollection implements ITable
{
	private final IElement[] _columns;

	@Requires({"columns != null", "columns.length > 0"})
	public Table(IElement[] columns)
	{
		super(Optional.empty());
		_columns = columns;
	}

	@Override
	public ITableRow addRow(TableRowStyle style)
	{
		final ITableRow row = new TableRow(_columns.length, style);
		add(row);
		return row;
	}
}
