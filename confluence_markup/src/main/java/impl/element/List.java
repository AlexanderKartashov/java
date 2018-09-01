package impl.element;

import interfaces.IElement;
import interfaces.elements.IList;

import java.util.Optional;

class List extends ElementsCollection implements IList
{
	public List()
	{
		super(Optional.empty());
	}

	@Override
	public void addItem(IElement item)
	{
		add(item);
	}
}
