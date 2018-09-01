package interfaces;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.elements.*;
import interfaces.elements.immutable.IList;
import interfaces.elements.immutable.ITable;
import interfaces.elements.immutable.IText;
import interfaces.elements.immutable.IToggleButton;
import interfaces.elements.mutable.IMutableList;
import interfaces.elements.mutable.IMutableTable;

public interface IElementFactory {
	@Requires({"columns != null", "columns.length > 0"})
	@Ensures("result != null")
	IMutableTable createTable(IElement[] columns);

	@Ensures("result != null")
	@Requires("state != null")
	IToggleButton createButton(ToggleButtonState state);

	@Ensures("result != null")
	@Requires({"text != null", "text.length() > 0", "style != null"})
	IText createText(String text, TextStyle style);

	@Requires("style != null")
	@Ensures("result != null")
	IMutableList createList(ListStyle style);
}
