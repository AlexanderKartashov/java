package interfaces.elements;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.IElement;

public interface ITable extends IElement {
	@Requires("style != null")
	@Ensures("result != null")
	ITableRow addRow(TableRowStyle style);
}
