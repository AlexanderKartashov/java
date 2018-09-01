package interfaces;

import com.google.java.contract.Requires;

public interface IAcceptor
{
	@Requires("visitor != null")
	void accept(IElementVisitor visitor);
}
