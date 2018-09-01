package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.IElementVisitor;
import interfaces.elements.immutable.ITableRow;
import interfaces.elements.TableRowStyle;
import interfaces.elements.mutable.IMutableTableRow;

import java.util.Optional;

class TableRow extends ElementsCollection implements IMutableTableRow
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

	@Override
	public TableRowStyle style()
	{
		return _style;
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
}
