package interfaces.elements.immutable;

import com.google.java.contract.Ensures;
import interfaces.IElement;
import interfaces.elements.ListStyle;

public interface IList extends IElement
{
	@Ensures("result != null")
	ListStyle style();
}
