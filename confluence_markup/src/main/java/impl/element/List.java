package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.IList;
import interfaces.elements.ListStyle;

import java.util.Optional;

class List extends ElementsCollection implements IList
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
}
