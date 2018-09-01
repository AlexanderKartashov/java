package interfaces;

import com.google.java.contract.Requires;
import interfaces.elements.immutable.*;

public interface IElementVisitor
{
	@Requires("table != null")
	void visit(ITable table);

	@Requires("row != null")
	void visit(ITableRow row);

	@Requires("list != null")
	void visit(IList list);

	@Requires("text != null")
	void visit(IText text);

	@Requires("button != null")
	void visit(IToggleButton button);
}
