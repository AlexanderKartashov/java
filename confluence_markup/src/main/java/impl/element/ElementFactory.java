package impl.element;

import interfaces.IElement;
import interfaces.IElementFactory;
import interfaces.elements.*;

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
	public IElement createText(String text, TextStyle style)
	{
		return new Text(text, style);
	}

	@Override
	public IList createList(ListStyle style)
	{
		return new List(style);
	}
}
