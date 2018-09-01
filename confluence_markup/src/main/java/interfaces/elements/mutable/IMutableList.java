package interfaces.elements.mutable;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.ListStyle;
import interfaces.elements.immutable.IList;

public interface IMutableList extends IList
{
	@Requires("item != null")
	void addItem(IElement item);
}
