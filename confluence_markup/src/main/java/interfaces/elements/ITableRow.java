package interfaces.elements;

import com.google.java.contract.Requires;
import interfaces.IElement;

public interface ITableRow extends IElement{
	@Requires("element != null")
	void addItem(IElement element);
}
