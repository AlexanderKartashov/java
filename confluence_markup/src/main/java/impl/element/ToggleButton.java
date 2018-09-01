package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.IElementVisitor;
import interfaces.elements.immutable.IToggleButton;
import interfaces.elements.ToggleButtonState;

class ToggleButton implements IToggleButton
{
	private final ToggleButtonState _state;

	@Requires("state != null")
	public ToggleButton(ToggleButtonState state)
	{
		_state = state;
	}

	@Override
	public ToggleButtonState state()
	{
		return _state;
	}

	@Override
	public void accept(IElementVisitor visitor)
	{
		visitor.visit(this);
	}

	@Override
	public Iterable<IElement> subElements()
	{
		return null;
	}
}
