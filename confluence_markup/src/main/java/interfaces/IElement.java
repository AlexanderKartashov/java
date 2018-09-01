package interfaces;

public interface IElement extends IAcceptor {
	Iterable<IElement> subElements();
}
