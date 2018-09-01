package interfaces.elements.immutable;

import com.google.java.contract.Ensures;
import interfaces.IElement;
import interfaces.elements.TextStyle;

public interface IText extends IElement
{
	@Ensures("result != null")
	TextStyle style();

	@Ensures("result != null")
	String text();
}
