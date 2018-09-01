package impl.element;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.elements.ToggleButtonState;

class ToggleButton implements IElement
{
	private final ToggleButtonState _state;

	@Requires("state != null")
	public ToggleButton(ToggleButtonState state)
	{
		_state = state;
	}
}
