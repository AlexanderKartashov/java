package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.IElementVisitor;
import interfaces.elements.ListStyle;
import interfaces.elements.mutable.IMutableList;

import java.util.Optional;

class List extends ElementsCollection implements IMutableList
{
	private final ListStyle _style;

	@Requires("style != null")
	public List(ListStyle style)
	{
		super(Optional.empty());
		_style = style;
	}

	@Override
	public void addItem(IElement item)
	{
		add(item);
	}

	@Override
	public ListStyle style()
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
