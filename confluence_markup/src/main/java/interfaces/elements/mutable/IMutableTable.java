package interfaces.elements.mutable;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.elements.TableRowStyle;
import interfaces.elements.immutable.ITable;

public interface IMutableTable extends ITable
{
	@Requires("style != null")
	@Ensures("result != null")
	IMutableTableRow addRow(TableRowStyle style);
}
