package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.TextStyle;

class Text implements IElement
{
	private final String _text;
	private final TextStyle _style;

	@Requires({"text != null", "text.length() > 0", "style != null"})
	public Text(String text, TextStyle style)
	{
		_text = text;
		_style = style;
	}
}
