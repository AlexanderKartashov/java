package interfaces.elements.mutable;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.TableRowStyle;
import interfaces.elements.immutable.ITableRow;

public interface IMutableTableRow extends ITableRow
{
	@Requires("element != null")
	void addItem(IElement element);
}
