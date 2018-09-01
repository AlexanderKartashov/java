package impl.element;

import interfaces.IElement;
import interfaces.IElementFactory;
import interfaces.elements.ListStyle;
import interfaces.elements.TextStyle;
import interfaces.elements.ToggleButtonState;
import interfaces.elements.immutable.IText;
import interfaces.elements.immutable.IToggleButton;
import interfaces.elements.mutable.IMutableList;
import interfaces.elements.mutable.IMutableTable;

public class ElementFactory implements IElementFactory
{
	@Override
	public IMutableTable createTable(IElement[] columns)
	{
		return new Table(columns);
	}

	@Override
	public IToggleButton createButton(ToggleButtonState state)
	{
		return new ToggleButton(state);
	}

	@Override
	public IText createText(String text, TextStyle style)
	{
		return new Text(text, style);
	}

	@Override
	public IMutableList createList(ListStyle style)
	{
		return new List(style);
	}
}
