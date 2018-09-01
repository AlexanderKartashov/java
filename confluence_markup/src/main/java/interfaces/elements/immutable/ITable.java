package interfaces.elements.immutable;

import com.google.java.contract.Ensures;
import interfaces.IElement;

public interface ITable extends IElement {
	@Ensures("result != null")
	Iterable<IElement> columns();
}
