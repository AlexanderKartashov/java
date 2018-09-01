package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.IElementVisitor;
import interfaces.elements.TableRowStyle;
import interfaces.elements.immutable.ITableRow;
import interfaces.elements.mutable.IMutableTable;
import interfaces.elements.mutable.IMutableTableRow;

import java.util.Arrays;
import java.util.Optional;

class Table extends ElementsCollection implements IMutableTable
{
	private final IElement[] _columns;

	@Requires({"columns != null", "columns.length > 0"})
	public Table(IElement[] columns)
	{
		super(Optional.empty());
		_columns = columns;
	}

	@Override
	public IMutableTableRow addRow(TableRowStyle style)
	{
		final IMutableTableRow row = new TableRow(_columns.length, style);
		add(row);
		return row;
	}

	@Override
	public Iterable<IElement> subElements()
	{
		return super.elements();
	}

	@Override
	public void accept(IElementVisitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public Iterable<IElement> columns()
	{
		return Arrays.asList(_columns);
	}
}
