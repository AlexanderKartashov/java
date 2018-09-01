package interfaces.elements;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.IElement;

public interface IList extends IElement {
	@Requires("item != null")
	void addItem(IElement item);
}
