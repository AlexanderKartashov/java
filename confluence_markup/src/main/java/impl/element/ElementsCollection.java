package impl.element;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;
import interfaces.IElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class ElementsCollection
{
	private final Collection<IElement> _elements = new ArrayList<>();
	private final Optional<Integer> _fixedSize;

	@Requires("fixedSize != null")
	protected ElementsCollection(Optional<Integer> fixedSize)
	{
		_fixedSize = fixedSize;
	}

	@Requires({"element != null", "_fixedSize.isPresent() ? _elements.size() < _fixedSize.get() : true"})
	@Ensures("_elements.size() == old(_elements.size()) + 1")
	protected void add(IElement element)
	{
		_elements.add(element);
	}

	@Ensures("result != null")
	protected Iterable<IElement> elements()
	{
		return _elements;
	}
}
