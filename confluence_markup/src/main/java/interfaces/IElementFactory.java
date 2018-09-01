package interfaces;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.elements.*;

public interface IElementFactory {
	@Requires({"columns != null", "columns.length > 0"})
	@Ensures("result != null")
	ITable createTable(IElement[] columns);

	@Ensures("result != null")
	@Requires("state != null")
	IElement createButton(ToggleButtonState state);

	@Ensures("result != null")
	@Requires({"text != null", "text.length() > 0", "style != null"})
	IElement createText(String text, TextStyle style);

	@Requires("style != null")
	@Ensures("result != null")
	IList createList(ListStyle style);
}
