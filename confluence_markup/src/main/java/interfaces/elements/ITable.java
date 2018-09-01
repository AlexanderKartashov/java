package interfaces.elements;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.IStyle;

public interface ITable extends IElement {
	@Requires("style != null")
	@Ensures("result != null")
	ITableRow addRow(IStyle style);
}
