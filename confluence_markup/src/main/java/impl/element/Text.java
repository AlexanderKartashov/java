package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;

class Text implements IElement
{
	private final String _text;

	@Requires({"text != null", "text.length() > 0"})
	public Text(String text)
	{
		_text = text;
	}
}
