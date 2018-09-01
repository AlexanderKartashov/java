package interfaces.elements.immutable;

import com.google.java.contract.Ensures;
import interfaces.IElement;
import interfaces.elements.ToggleButtonState;

public interface IToggleButton extends IElement
{
	@Ensures("result != null")
	ToggleButtonState state();
}
