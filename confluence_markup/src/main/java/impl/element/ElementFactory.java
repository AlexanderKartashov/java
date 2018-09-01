package impl.element;

import interfaces.IElement;
import interfaces.IElementFactory;
import interfaces.elements.IList;
import interfaces.elements.ITable;
import interfaces.elements.ToggleButtonState;

public class ElementFactory implements IElementFactory
{
	@Override
	public ITable createTable(IElement[] columns)
	{
		return new Table(columns);
	}

	@Override
	public IElement createButton(ToggleButtonState state)
	{
		return new ToggleButton(state);
	}

	@Override
	public IElement createText(String text)
	{
		return new Text(text);
	}

	@Override
	public IList createList()
	{
		return new List();
	}
}
