package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.IElementVisitor;
import interfaces.elements.immutable.IText;
import interfaces.elements.TextStyle;

class Text implements IText
{
	private final String _text;
	private final TextStyle _style;

	@Requires({"text != null", "text.length() > 0", "style != null"})
	public Text(String text, TextStyle style)
	{
		_text = text;
		_style = style;
	}

	@Override
	public TextStyle style()
	{
		return _style;
	}

	@Override
	public String text()
	{
		return _text;
	}

	@Override
	public void accept(IElementVisitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public Iterable<IElement> subElements()
	{
		return null;
	}
}
