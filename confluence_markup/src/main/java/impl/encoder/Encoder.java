package impl.encoder;

import com.google.java.contract.Requires;
import interfaces.IElement;
import interfaces.IElementVisitor;
import interfaces.elements.immutable.*;

import java.util.Optional;

public class Encoder
{
	@Requires("element != null")
	public void encode(IElement element)
	{
		final Visitor visitor = new Visitor();
		visitor.process(element);
	}
}
