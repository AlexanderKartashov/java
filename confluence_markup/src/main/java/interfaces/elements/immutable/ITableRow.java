package interfaces.elements.immutable;

import com.google.java.contract.Ensures;
import interfaces.IElement;
import interfaces.elements.TableRowStyle;

public interface ITableRow extends IElement{
	@Ensures("result != null")
	TableRowStyle style();
}
